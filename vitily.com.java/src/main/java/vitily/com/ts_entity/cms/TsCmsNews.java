package vitily.com.ts_entity.cms;

import vitily.com.tb_entity.cms.TbCmsDynproVal;
import vitily.com.tb_entity.cms.TbCmsNews;
import vitily.base.ts_entity.BaseSearch;
import vitily.com.util.CommonUtil;

import java.util.List;

public class TsCmsNews extends BaseSearch<TbCmsNews> {
	public TsCmsNews(){
		super(new TbCmsNews());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 仅仅列出标题以及一些基础信息
	 */
	private Boolean isForTitle = false;
	/**
	 * 列出标题、id、创建时间、内容
	 */
	private Boolean isOnlyTitleAndContent = false;
	/**
	 * 基金经理分组
	 */
	private Boolean isForFundManager = false;
	
	/**
	 * 是否列出标签
	 */
	private Boolean isForLabelList = false;
	
	/**
	 * 是否列出额外信息
	 */
	private Boolean isListDyn = false;
	/**
	 *  分类idstr：如(1,2,...x)
	 */
	private String cateIdStr;
	/**
	 *  标签id
	 */
	private Integer selLabelId;
	
	/**
	 * 多个标签id
	 */
	private String labelIdStr;
	
	/**
	 * 类型idstr：如(1,2,...x)
	 */
	private String typeIdStr;
	/**
	 * 是否发布Str：如(1,2,...x)
	 */
	private String publishStr;
	/**
	 * 是否置顶Str：如(1,2,...x)
	 */
	private String topStr;
	/**
	 * 是否可评论Str：如(1,2,...x)
	 */
	private String commentableStr;
	
	/**
	 * 点击量：最低
	 */
	private Integer minHits;
	/**
	 * 点击量：最高
	 */
	private Integer maxHits;
	/**
	 * 关键字
	 */
	private String selKeyword;
	/**
	 * 作者
	 */
	private String selAuthor;
	/**
	 * 来源
	 */
	private String selComeFrom;
	
	/**
	 * 标识符
	 */
	private String selUrlTip;



	/**
	 * 额外属性
	 */
	private List<TbCmsDynproVal> dynList;
	private boolean changeDyn;//是否更新属性

	public Boolean getIsForTitle() {
		return isForTitle;
	}

	public void setIsForTitle(Boolean isForTitle) {
		this.isForTitle = isForTitle;
	}

	public String getSelUrlTip() {
		return selUrlTip;
	}

	public void setSelUrlTip(String selUrlTip) {
		this.selUrlTip = selUrlTip;
	}

	public String getCateIdStr() {
		return cateIdStr;
	}

	public void setCateIdStr(String cateIdStr) {
		if(CommonUtil.isNumOrD(cateIdStr)){
			this.cateIdStr = cateIdStr;
		}
	}

	public Integer getSelLabelId() {
		return selLabelId;
	}

	public void setSelLabelId(Integer selLabelId) {
		this.selLabelId = selLabelId;
	}

	public String getTypeIdStr() {
		return typeIdStr;
	}

	public void setTypeIdStr(String typeIdStr) {
		if(CommonUtil.isNumOrD(typeIdStr)){
			this.typeIdStr = typeIdStr;
		}
	}

	public String getPublishStr() {
		return publishStr;
	}

	public void setPublishStr(String publishStr) {
		if(CommonUtil.isNumOrD(publishStr)){
			this.publishStr = publishStr;
		}
	}

	public String getTopStr() {
		return topStr;
	}

	public void setTopStr(String topStr) {
		if(CommonUtil.isNumOrD(topStr)){
			this.topStr = topStr;
		}
	}

	public String getCommentableStr() {
		return commentableStr;
	}

	public void setCommentableStr(String commentableStr) {
		if(CommonUtil.isNumOrD(commentableStr)){
			this.commentableStr = commentableStr;
		}
	}

	public Integer getMinHits() {
		return minHits;
	}

	public void setMinHits(Integer minHits) {
		this.minHits = minHits;
	}

	public Integer getMaxHits() {
		return maxHits;
	}

	public void setMaxHits(Integer maxHits) {
		this.maxHits = maxHits;
	}

	public String getSelKeyword() {
		return selKeyword;
	}

	public void setSelKeyword(String selKeyword) {
		this.selKeyword = selKeyword;
	}

	public String getSelAuthor() {
		return selAuthor;
	}

	public void setSelAuthor(String selAuthor) {
		this.selAuthor = selAuthor;
	}

	public String getSelComeFrom() {
		return selComeFrom;
	}

	public void setSelComeFrom(String selComeFrom) {
		this.selComeFrom = selComeFrom;
	}

	public Boolean getIsForFundManager() {
		return isForFundManager;
	}

	public void setIsForFundManager(Boolean isForFundManager) {
		this.isForFundManager = isForFundManager;
	}

	public Boolean getIsForLabelList() {
		return isForLabelList;
	}

	public void setIsForLabelList(Boolean isForLabelList) {
		this.isForLabelList = isForLabelList;
	}

	public Boolean getIsOnlyTitleAndContent() {
		return isOnlyTitleAndContent;
	}

	public void setIsOnlyTitleAndContent(Boolean isOnlyTitleAndContent) {
		this.isOnlyTitleAndContent = isOnlyTitleAndContent;
	}

	public Boolean getIsListDyn() {
		return isListDyn;
	}

	public void setIsListDyn(Boolean isListDyn) {
		this.isListDyn = isListDyn;
	}

	public String getLabelIdStr() {
		return labelIdStr;
	}

	public void setLabelIdStr(String labelIdStr) {
		if(CommonUtil.isNumOrD(labelIdStr)){
			this.labelIdStr = labelIdStr;
		}
	}

	public List <TbCmsDynproVal> getDynList() {
		return dynList;
	}

	public void setDynList(List <TbCmsDynproVal> dynList) {
		this.dynList = dynList;
	}

	public boolean isChangeDyn() {
		return changeDyn;
	}

	public void setChangeDyn(boolean changeDyn) {
		this.changeDyn = changeDyn;
	}
}
