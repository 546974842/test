package vitily.com.ts_entity.pro;

import vitily.com.tb_entity.pro.TbProBase;
import vitily.base.ts_entity.BaseSearch;
import vitily.com.tb_entity.pro.TbProDynproVal;
import vitily.com.tv_entity.pro.TvProMemPri;
import vitily.com.tv_entity.pro.TvProSpVal;
import vitily.com.util.CommonUtil;

import java.util.List;

public class TsProBase extends BaseSearch<TbProBase> {
	public TsProBase(){
		super(new TbProBase());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cateIdStr;
	private String typeIdStr;
	private String labelIdStr;
	private Integer minMaxCanbuy;
	private Integer maxMaxCanbuy;
	private Integer minHits;
	private Integer maxHits;
	private Long beginSalePrice;
	private Long endSalePrice;
	private String selKeyword;
	private String payWayIdStr;
	private String deliveryIdStr;
	private Integer beginStock;
	private Integer endStock;
	private Integer beginSoldCount;
	private Integer endSoldCount;
	private Integer beginCommitCount;
	private Integer endCommitCount;
	/**
	 *  标签id
	 */
	private Integer selLabelId;
	
	private Integer oldVersion;

	List<TbProDynproVal> dynList;//额外属性
	List<TvProMemPri> pmpList;//会员价格
	List<TvProSpVal> pspList;//规格价格
	private boolean changeDyn;//是否更新属性
	private String delSppIds;

	public String getCateIdStr() {
		return cateIdStr;
	}
	public void setCateIdStr(String cateIdStr) {
		if(CommonUtil.isNumOrD(cateIdStr)){
			this.cateIdStr = cateIdStr;
		}
	}
	public String getTypeIdStr() {
		return typeIdStr;
	}
	public void setTypeIdStr(String typeIdStr) {
		if(CommonUtil.isNumOrD(typeIdStr)){
			this.typeIdStr = typeIdStr;
		}
	}
	public String getLabelIdStr() {
		return labelIdStr;
	}
	public void setLabelIdStr(String labelIdStr) {
		if(CommonUtil.isNumOrD(labelIdStr)){
			this.labelIdStr = labelIdStr;
		}
	}

	public Integer getMinMaxCanbuy() {
		return minMaxCanbuy;
	}

	public void setMinMaxCanbuy(Integer minMaxCanbuy) {
		this.minMaxCanbuy = minMaxCanbuy;
	}

	public Integer getMaxMaxCanbuy() {
		return maxMaxCanbuy;
	}

	public void setMaxMaxCanbuy(Integer maxMaxCanbuy) {
		this.maxMaxCanbuy = maxMaxCanbuy;
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

	public Long getBeginSalePrice() {
		return beginSalePrice;
	}
	public void setBeginSalePrice(Long beginSalePrice) {
		this.beginSalePrice = beginSalePrice;
	}
	public Long getEndSalePrice() {
		return endSalePrice;
	}
	public void setEndSalePrice(Long endSalePrice) {
		this.endSalePrice = endSalePrice;
	}
	public String getSelKeyword() {
		return selKeyword;
	}
	public void setSelKeyword(String selKeyword) {
		this.selKeyword = selKeyword;
	}
	public String getPayWayIdStr() {
		return payWayIdStr;
	}
	public void setPayWayIdStr(String payWayIdStr) {
		if(CommonUtil.isNumOrD(payWayIdStr)){
			this.payWayIdStr = payWayIdStr;
		}
	}
	public String getDeliveryIdStr() {
		return deliveryIdStr;
	}
	public void setDeliveryIdStr(String deliveryIdStr) {
		if(CommonUtil.isNumOrD(deliveryIdStr)){
			this.deliveryIdStr = deliveryIdStr;
		}
	}
	public Integer getBeginStock() {
		return beginStock;
	}
	public void setBeginStock(Integer beginStock) {
		this.beginStock = beginStock;
	}
	public Integer getEndStock() {
		return endStock;
	}
	public void setEndStock(Integer endStock) {
		this.endStock = endStock;
	}
	public Integer getBeginSoldCount() {
		return beginSoldCount;
	}
	public void setBeginSoldCount(Integer beginSoldCount) {
		this.beginSoldCount = beginSoldCount;
	}
	public Integer getEndSoldCount() {
		return endSoldCount;
	}
	public void setEndSoldCount(Integer endSoldCount) {
		this.endSoldCount = endSoldCount;
	}
	public Integer getBeginCommitCount() {
		return beginCommitCount;
	}
	public void setBeginCommitCount(Integer beginCommitCount) {
		this.beginCommitCount = beginCommitCount;
	}
	public Integer getEndCommitCount() {
		return endCommitCount;
	}
	public void setEndCommitCount(Integer endCommitCount) {
		this.endCommitCount = endCommitCount;
	}

	public Integer getSelLabelId() {
		return selLabelId;
	}

	public void setSelLabelId(Integer selLabelId) {
		this.selLabelId = selLabelId;
	}

	public Integer getOldVersion() {
		return oldVersion;
	}
	public void setOldVersion(Integer oldVersion) {
		this.oldVersion = oldVersion;
	}

	public List <TbProDynproVal> getDynList() {
		return dynList;
	}

	public void setDynList(List <TbProDynproVal> dynList) {
		this.dynList = dynList;
	}

	public List <TvProMemPri> getPmpList() {
		return pmpList;
	}

	public void setPmpList(List <TvProMemPri> pmpList) {
		this.pmpList = pmpList;
	}

	public List <TvProSpVal> getPspList() {
		return pspList;
	}

	public void setPspList(List <TvProSpVal> pspList) {
		this.pspList = pspList;
	}

	public boolean isChangeDyn() {
		return changeDyn;
	}

	public void setChangeDyn(boolean changeDyn) {
		this.changeDyn = changeDyn;
	}

	public String getDelSppIds() {
		return delSppIds;
	}

	public void setDelSppIds(String delSppIds) {
		if(CommonUtil.isNumOrD(delSppIds)) {
			this.delSppIds = delSppIds;
		}
	}
}
