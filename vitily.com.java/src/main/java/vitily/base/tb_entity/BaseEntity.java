package vitily.base.tb_entity;


import com.alibaba.fastjson.annotation.JSONField;
import vitily.com.consts.StateDesc;
import vitily.com.util.EnumHelperUtil;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date updateDate;

	private Integer deltag;
	
	private Double sort;
	
	private Integer state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getDeltag() {
		return deltag;
	}

	public void setDeltag(Integer deltag) {
		this.deltag = deltag;
	}

	public Double getSort() {
		return sort;
	}

	public void setSort(Double sort) {
		this.sort = sort;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	protected String stateDesc;
	public String getStateDesc(){
		this.stateDesc = EnumHelperUtil.getEnumWrapDescByValue(StateDesc.class, state);
		return this.stateDesc;
	}
}
