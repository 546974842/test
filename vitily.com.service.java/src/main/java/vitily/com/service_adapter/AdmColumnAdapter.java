package vitily.com.service_adapter;

import vitily.com.other_entity.UserStorage;
import vitily.com.tv_entity.adm.TvAdmColumn;
import vitily.com.other_entity.TreeNode;

import java.util.List;

public interface AdmColumnAdapter {
    void init()throws Exception;
    Integer hashAuth(String actionPath);
    void putAuth(String actionPath,Integer rightId);
    void removeAuth(String actionPath);
    Integer hashNonAuth(String actionPath);
    /**
     * 取得缓存column:所有，不过滤权限
     * @return 1
     */
    List<TvAdmColumn> getCacheColumns();
    void clearCacheColumns();
    /**
     * 从缓存获取某个栏目下的直属子节点：不过滤权限
     * @param id 1
     * @return 2
     */
    TvAdmColumn geTvColumnById(int id);

    /**
     * 获取某一树节点下的所有直属子节点：过滤权限
     * @param user 1
     * @param tbColumns 某一节点集合
     * @param pid 2
     * @return 3
     */
    List<TvAdmColumn> listPermissionColumnsByPid(UserStorage user, List <TvAdmColumn> tbColumns, int pid);
    /**
     * 获取某一个节点下的所有子节点（递归）：过滤权限
     * @param user 1
     * @param tvSearchColumns 2
     * @param rightStrs 3
     * @param pid 4
     * @return 5
     */
    List<TreeNode> listPermissionRecursiveColumnsByPid(UserStorage user, List <TvAdmColumn> tvSearchColumns, String rightStrs, int pid);
    /**
     * 获得某一树节点下面的所有子节点（非递归）：过滤权限
     * @param user 1
     * @param tbColumns 2
     * @param pid 3
     * @return 4
     */
    List<TvAdmColumn> listPermissionTreeColumnsByPid(UserStorage user, List <TvAdmColumn> tbColumns, int pid);
    /**
     * 获得当前所有权限列表
     * @param user 1
     * @return 2
     */
    List<TvAdmColumn> listPermissionColumns(UserStorage user);

    /**
     * 某用户是否有栏目id
     * @param user 1
     * @param columnId 2
     * @return 3
     */
    boolean hasColumnPermission(UserStorage user, Integer columnId);
    /**
     * 是否超级用户 1
     * @param userId 2
     * @return 3
     */
    boolean isRoot(UserStorage user);
    boolean isTestRoot(UserStorage user);
}
