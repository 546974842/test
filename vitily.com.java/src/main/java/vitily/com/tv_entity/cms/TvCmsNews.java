package vitily.com.tv_entity.cms;


import java.util.List;

import vitily.com.consts.CommentableDesc;
import vitily.com.consts.PublishedDesc;
import vitily.com.consts.TopDesc;
import vitily.com.tb_entity.cms.TbCmsNews;
import vitily.com.util.CommonUtil;
import vitily.com.util.EnumHelperUtil;

public class TvCmsNews extends TbCmsNews {
	private String typeName;
	/** 
     * 所属分类名称
     */
    private String cateName;
    /** 
     * 是否置顶描述
     */
    private String topDesc;
    /** 
     * 发布状态描述
     */
    private String publishedDesc;
    /** 
     * 是否评论
     */
    private String commentableDesc;
    
    /**
     * 关联标签名称
     */
    private String labelNames;
    

	/**
	 * 额外属性
	 */
	private List<TvCmsDynproVal> dynList;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getTopDesc() {
		if(CommonUtil.isNull(topDesc)){
			this.topDesc = EnumHelperUtil.getEnumWrapDescByValue(TopDesc.class,this.getTop());
		}
		return topDesc;
	}

	public String getPublishedDesc() {
		if(CommonUtil.isNull(publishedDesc)){
			this.publishedDesc = EnumHelperUtil.getEnumWrapDescByValue(PublishedDesc.class,this.getPublished());
		}
		return publishedDesc;
	}


	public String getCommentableDesc() {
		if(CommonUtil.isNull(commentableDesc)){
			this.commentableDesc = EnumHelperUtil.getEnumWrapDescByValue(CommentableDesc.class,this.getCommentable());
		}
		return commentableDesc;
	}


	public String getLabelNames() {
		return labelNames;
	}

	public void setLabelNames(String labelNames) {
		this.labelNames = labelNames;
	}

	public List<TvCmsDynproVal> getDynList() {
		return dynList;
	}

	public void setDynList(List<TvCmsDynproVal> dynList) {
		this.dynList = dynList;
	}


}
