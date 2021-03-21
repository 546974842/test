package vitily.base.ts_entity;

import vitily.base.tb_entity.BaseEntity;
import vitily.com.consts.DelTagDesc;
import vitily.com.util.CommonUtil;
import vitily.com.util.StringUtil;

import java.util.List;

public class BaseSearch<T extends BaseEntity> extends TqBase {
	protected  BaseSearch(T entity){
		this.entity = entity;
		this.entity.setDeltag(DelTagDesc.正常.getValue());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PageInfo pageInfo;
	/**
	 * 表id组合如：1,2,...x:必须为整数开头整数结尾的以“,”分割的字符窜集合
	 */
	private String idStr;
	
	/**
	 * 状态集合如：1,2,...x
	 */
	private String stateStr;
	private String beginCreateDate;
	private String endCreateDate;
	private String beginUpdateDate;
	private String endUpdateDate;
	private List<Integer> ids;
	private List<Integer> states;
	
	private T entity;

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getIdStr() {
		return idStr;
	}

	public void setIdStr(String idStr) {
		if(CommonUtil.isNumOrD(idStr) || StringUtil.isEmpty(idStr)){
			this.idStr = idStr;
		}
	}

	public String getStateStr() {
		return stateStr;
	}

	public void setStateStr(String stateStr) {
		if(CommonUtil.isNumOrD(stateStr)){
			this.stateStr = stateStr;
		}
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public String getBeginCreateDate() {
		return beginCreateDate;
	}

	public void setBeginCreateDate(String beginCreateDate) {
		this.beginCreateDate = beginCreateDate;
	}

	public String getEndCreateDate() {
		return endCreateDate;
	}

	public void setEndCreateDate(String endCreateDate) {
		this.endCreateDate = endCreateDate;
	}

	public String getBeginUpdateDate() {
		return beginUpdateDate;
	}

	public void setBeginUpdateDate(String beginUpdateDate) {
		this.beginUpdateDate = beginUpdateDate;
	}

	public String getEndUpdateDate() {
		return endUpdateDate;
	}

	public void setEndUpdateDate(String endUpdateDate) {
		this.endUpdateDate = endUpdateDate;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public List<Integer> getStates() {
		return states;
	}

	public void setStates(List<Integer> states) {
		this.states = states;
	}
}
