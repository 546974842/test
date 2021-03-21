package vitily.base.ts_entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import vitily.com.consts.Const;
import vitily.com.consts.JdbcTypeDesc;
import vitily.com.util.CommonUtil;

/**
 * 分页的基本参数对象
 */
public class PageInfo implements Serializable {
	/**
	 * 每页显示条数
	 */
	private int pageSize= Const.COMMON_DEFAULT_PAGESIZE;
	/**
	 * 当前页数 1 起步
	 */
	private int page=1;
	/**
	 * 跳转步数
	 */
	private int step;
	/**
	 * 总纪录
	 */
	private int recordCount;
	/**
	 * 排序内容 类似： id desc,createDate asc 等等
	 */
	@JSONField(serialize = false)
	private String fieldOrder;
	/**
	 * 排序字段
	 */
	private String sortField="e.id";
	/**
	 * 排序方式
	 */
	private String sortDistanct="desc";
	@JSONField(serialize = false)
	private JdbcTypeDesc jdbcType = JdbcTypeDesc.mysql;

	public String getSortField() {
		return sortField;
	}
	public void setSortField(String sortField) {
		sortField=sortField.replace("`", "");
		if(!CommonUtil.isNull(sortField) && sortField.trim().length() > 0 && CommonUtil.isNormalSql(sortField)){
			if(CommonUtil.isEqual(this.jdbcType.getValue(), JdbcTypeDesc.mysql.getValue()) && !sortField.contains(".")){
				this.sortField = "`"+sortField.replaceAll(",", "`,`")+"`";
			}else{
				this.sortField = sortField;
			}
		}
	}
	
	public String getSortDistanct() {
		return sortDistanct;
	}
	public void setSortDistanct(String sortDistanct) {
		if(CommonUtil.isNormalSql(sortDistanct)){
			this.sortDistanct = sortDistanct;
		}
	}
	public int getPageSize() {
		return pageSize;
	}
	/*
	 * 最高不得高于50条
	 */
	public void setPageSize(int pageSize) {
		if(pageSize > 0 && pageSize <= Const.COMMON_MAX_PAGESIZE){
			this.pageSize = pageSize;
		}
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page > 0){
			this.page = page;
		}
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	/**
	 * 根据"," 分组，只有sortField[]、sortDistanct[]里的数目一样才可以
	 * @return 1
	 */
	public String getFieldOrder() {
		String[] fields = getSortField().split(",");
		String[] distancts = getSortDistanct().split(",");
		StringBuilder fieldOrders = new StringBuilder("e.sort desc");
		if(fields.length != distancts.length){
			return fieldOrders.toString();
		}
		fieldOrders = new StringBuilder();
		for(int i = 0,len = fields.length;i < len;++i){
			fieldOrders.append(" ");
			fieldOrders.append(fields[i]);
			fieldOrders.append(" ");
			fieldOrders.append(distancts[i]);
			if(i != len - 1){
				fieldOrders.append(",");
			}
		}
		return fieldOrders.toString();
	}
	public int getStep() {
		this.step = (page-1)*pageSize;
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getMaxRow() {
		return page * pageSize;
	}
	public JdbcTypeDesc getJdbcType() {
		return jdbcType;
	}
	public void setJdbcType(JdbcTypeDesc jdbcType) {
		this.jdbcType = jdbcType;
	}
}
