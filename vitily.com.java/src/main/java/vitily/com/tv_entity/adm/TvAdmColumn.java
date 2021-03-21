package vitily.com.tv_entity.adm;


import java.util.List;

import vitily.com.tb_entity.adm.TbAdmColumn;

public class TvAdmColumn extends TbAdmColumn {
	public TvAdmColumn(){}
	public TvAdmColumn(TbAdmColumn entity){
		setId(entity.getId());
		setState(entity.getState());
		setDeltag(entity.getDeltag());
		setCreateDate(entity.getCreateDate());
		setUpdateDate(entity.getUpdateDate());
		setParentId(entity.getParentId());
		setSort(entity.getSort());
        setName(entity.getName());
        setUrlLink(entity.getUrlLink());
		setIcon(entity.getIcon());
	}
	/**
	 * 是否有权限
	 */
	private boolean hasRight;
	/**
	 * 直属子节点
	 */
	private List<TvAdmColumn> children;
	public boolean isHasRight() {
		return hasRight;
	}
	public void setHasRight(boolean hasRight) {
		this.hasRight = hasRight;
	}
	public List<TvAdmColumn> getChildren() {
		return children;
	}
	public void setChildren(List<TvAdmColumn> children) {
		this.children = children;
	}


}
