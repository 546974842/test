package vitily.com.service_adapter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import vitily.base.ts_entity.PageInfo;
import vitily.com.consts.Const;
import vitily.com.mapper.adm.AdmColumnMapper;
import vitily.com.other_entity.UserStorage;
import vitily.com.service_adapter.AdmColumnAdapter;
import vitily.com.ts_entity.adm.TsAdmColumn;
import vitily.com.tv_entity.adm.TvAdmColumn;
import vitily.com.other_entity.TreeNode;
import vitily.com.util.CommonUtil;
import vitily.com.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AdmColumnAdapterImpl implements AdmColumnAdapter{
    @Autowired
    AdmColumnMapper admColumnMapper;
    @Value("${nonAuthorithPath}")
    String nonAuthorithPathStr;

    private static List<TvAdmColumn> cacheColumns;
    private static Map<String,Integer> authorithPaths = new HashMap<>();
    private static Map<String,Integer> nonAuthorithPaths = new HashMap<>();

    /**
     * 初始化，将鉴权与非鉴权一并填入map中
     */
    @Override
    public void init(){
        //填入鉴权的
        List<TvAdmColumn> cs=getCacheColumns();
        for(TvAdmColumn e:cs){
            if(StringUtil.isEmpty(e.getRightUrls())){
                continue;
            }
            String[] rightUrls = e.getRightUrls().split(",");
            for(String s:rightUrls){
                if(!StringUtil.isEmpty(s)){
                    authorithPaths.put(s,e.getId());
                }
            }
        }
        //填入非鉴权的
        String[] nonPaths = nonAuthorithPathStr.split(",");
        for(String s:nonPaths){
            nonAuthorithPaths.put(s,0);
        }
    }
    @Override
    public Integer hashAuth(String actionPath){
        return authorithPaths.get(actionPath);
    }
    @Override
    public void putAuth(String actionPath,Integer rightId){
        authorithPaths.put(actionPath,rightId);
    }
    @Override
    public void removeAuth(String actionPath){
        authorithPaths.remove(actionPath);
    }
    @Override
    public Integer hashNonAuth(String actionPath){
        return nonAuthorithPaths.get(actionPath);
    }
    /**
     * 获取缓存数据:延迟加载
     * 正常且未删除的
     * @return 1
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<TvAdmColumn> getCacheColumns(){
        if(CommonUtil.isNull(cacheColumns) || cacheColumns.isEmpty() ){
            //从数据库中加载到内存里
            TsAdmColumn queryEntity = new TsAdmColumn();
            PageInfo pageInfo = new PageInfo();
            pageInfo.setPageSize(Const.COMMON_MAX_PAGESIZE);
            pageInfo.setSortField("e.sort");
            pageInfo.setSortDistanct("desc");
            queryEntity.setPageInfo(pageInfo);
            //只用删除与否来决定显示
            //queryEntity.getEntity().setState(StateDesc.正常.getValue());
            cacheColumns=(List<TvAdmColumn>)admColumnMapper.getListByBean(queryEntity);
        }
        return cacheColumns;
    }
    @Override
    public void clearCacheColumns(){
        cacheColumns = null;
    }
    /**
     * 从缓存获取数据
     */
    @Override
    public TvAdmColumn geTvColumnById(int id){
        for(TvAdmColumn column:getCacheColumns()){
            if(CommonUtil.isEqual(id,column.getId())){
                return column;
            }
        }
        return null;
    }
    /**
     *
     */
    @Override
    public List<TvAdmColumn> listPermissionColumnsByPid(UserStorage user, List<TvAdmColumn> tv, int pid){
        List<TvAdmColumn> columns=new ArrayList<>();
        for(TvAdmColumn column:tv){
            if(CommonUtil.isEqual(pid, column.getParentId()) && hasColumnPermission(user,column.getId())){
                columns.add(new TvAdmColumn(column));
            }
        }
        return columns;
    }
    @Override
    public List<TreeNode> listPermissionRecursiveColumnsByPid(UserStorage user, List<TvAdmColumn> tvSearchColumns, String rightStrs, int pid){
        tvSearchColumns = pid < 1 ? getCacheColumns() : listPermissionTreeColumnsByPid(user, tvSearchColumns, pid);
        //当前 pid 下的直属子节点
        List<TvAdmColumn> tvColumns=listPermissionColumnsByPid(user,tvSearchColumns,pid);
        List<TreeNode> treeNodes=new ArrayList<>();
        for(TvAdmColumn column:tvColumns){
            //logger.info("tvs:"+tvSearchColumns.size()+";number:"+column.getNumber());
            TreeNode node = new TreeNode();
            node.setChecked(CommonUtil.inStr(rightStrs, String.valueOf(column.getId()),','));
            node.setEvt("javascript:void(0);");
            node.setNavigateUrl("");
            node.setShowCheckBox(true);
            node.setText(column.getName());
            node.setValue(String.valueOf(column.getId()));
            node.setToolTip(column.getName());
            //传的是tvSearchColumns指向地址
            List<TreeNode> sunTvAdmins=listPermissionRecursiveColumnsByPid(user,tvSearchColumns,rightStrs,column.getId());

            node.setExpand(CommonUtil.inStr(rightStrs, String.valueOf(column.getId()),','));
            node.setChildren(sunTvAdmins);
            treeNodes.add(node);
        }
        return treeNodes;
    }
    @Override
    public List<TvAdmColumn> listPermissionTreeColumnsByPid(UserStorage user,List<TvAdmColumn> tbColumns,int pid){
        List<TvAdmColumn> columns=new ArrayList<>();//返回的列表请不要genggai
        TvAdmColumn currentColumn=geTvColumnById(pid);
        if(CommonUtil.isNull(currentColumn)){
            return columns;
        }
        for(TvAdmColumn column:tbColumns){
            if(hasColumnPermission(user,column.getId()) && !CommonUtil.isEqual(column.getId(),currentColumn.getId())){
                columns.add(new TvAdmColumn(column));//
            }
        }
        return columns;
    }
    @Override
    public List<TvAdmColumn> listPermissionColumns(UserStorage user){
        if(isRoot(user)){
            return getCacheColumns();
        }
        List<TvAdmColumn> columns=new ArrayList<>();//返回的列表请不要更改项
        for(TvAdmColumn column:getCacheColumns()){
            if(hasColumnPermission(user,column.getId())){
                columns.add(new TvAdmColumn(column));//
            }
        }
        return columns;
    }
    /**
     * 服务端情况下只判断session、cookie，故userId暂时没用到
     */
    @Override
    public boolean hasColumnPermission(UserStorage user, Integer columnId) {
        return CommonUtil.isNotNull(columnId) && (isRoot(user) || CommonUtil.inStr(user.getPermissonStr(), String.valueOf(columnId), ','));
    }

    @Override
    public boolean isRoot(UserStorage user) {
        return CommonUtil.isEqual(user.getId(),Const.SUP_ADMIN_ID) || isTestRoot(user);
    }
    @Override
    public boolean isTestRoot(UserStorage user) {
        return CommonUtil.isEqual(user.getId(),Const.EXP_SUP_ADMIN_ID);
    }
}
