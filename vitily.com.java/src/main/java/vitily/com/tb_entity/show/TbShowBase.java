package vitily.com.tb_entity.show;

import com.alibaba.fastjson.annotation.JSONField;
import vitily.base.tb_entity.BaseEntity;
import vitily.com.util.CentToYuanSerializer;

/**
 * 描述:体验类目主表表的实体类
 * @version
 * @author:  whh
 * @创建时间: 2018-08-22
 */
public class TbShowBase extends BaseEntity {

    /**
	* @Fields {todo}
	*/
	private static final long serialVersionUID = 1L;

	/**
     * 平台类型（0手机淘宝1手机天猫2手机京东）
     */
    private Integer platform;

    /**
     * 店铺id/名称
     */
    private String shopId;

    /**
     * 宝贝链接
     */
    private String babyLink;

    /**
     * 宝贝类目id组合
     */
    private String shopCateIds;

    /**
     * 宝贝类目名称
     */
    private String shopCateName;

    /**
     * 宝贝名称
     */
    private String babyName;

    /**
     * 宝贝主图
     */
    private String babyMainPic;

    /**
     * SKU截图
     */
    private String babySkuPic;

    /**
     * 体验价格（单位：分）
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long babyPrice;

    /**
     * 是否包邮
     */
    private Integer shipping;

    /**
     * 基础邮费（单位：分）
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long postage;

    /**
     * 体验类型
     */
    private Integer experiType;

    /**
     * 商品重量（单位：斤）
     */
    private Long weight;

    /**
     * 体验类型
     */
    private Integer experiWay;

    /**
     * 搜索关键字，以半角逗号分隔
     */
    private String serchKeys;
    /**
     * 搜索关键字，以半角逗号分隔
     */
    private String serchKeysTwo;
    /**
     * 搜索关键字，以半角逗号分隔
     */
    private String serchKeysThree;

    /**
     * 搜索截图
     */
    private String searchPic;

    /**
     * 卡条件截图
     */
    private String ofConditionPic;

    /**
     * 停留时间分类
     */
    private Integer stayTime;

    /**
     * 体验发布数量
     */
    private Integer experiNumber;
    
    /**
     * 体验剩余数量
     */
    private Integer surplusNumber;

    /**
     * 体验日期
     */
    private String experiDate;

    /**
     * 进店后浏览
     */
    private String viewTime;

    /**
     * 附加值
     */
    private String addedValue;

    /**
     * 模特年龄选项
     */
    private String modelAge;

    /**
     * 模特性别
     */
    private Integer modelGender;

    /**
     * 淘气值区间
     */
    private String naughtyValue;

    /**
     * 模特所在区域
     */
    private String modelArea;

    /**
     * 体验注意事项隔
     */
    private String notice;

    /**
     * 拍摄注意事项
     */
    private String shootNotice;

    /**
     * 退货收件人
     */
    private String offlineReturnRecerver;

    /**
     * 退货联系电话
     */
    private String offlineReturnPhone;

    /**
     * 退货省
     */
    private String offlineReturnProvince;

    /**
     * 退货市
     */
    private String offlineReturnCity;

    /**
     * 退货区
     */
    private String offlineReturnArea;

    /**
     * 退货详细地址
     */
    private String offlineReturnAddress;

    /**
     * 退货注意事项
     */
    private String offlineReturnNotice;

    /**
     * 是否模板
     */
    private Integer asTemplate;

    /**
     * 
     */
    private Integer memberId;

    /**
     * 
     */
    private String templateName;

    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long addValuePrice;
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long naughtyPrice;
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long modelAreaPrice;
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long weightPrice;
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long servicePrice;
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long modelReward;
    /**
     * 商家支出总金额（=（模特奖励佣金+服务费）*数量）单位：分
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long totalPayAmount;

    /**
     * 总价格（单位：分）
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long totalAmount;

    /**
     * 平台类型（0手机淘宝1手机天猫2手机京东）
     * [whh]@return platform 平台类型（0手机淘宝1手机天猫2手机京东）
     */
    public Integer getPlatform() {
        return platform;
    }

    /**
     * 平台类型（0手机淘宝1手机天猫2手机京东）
     * @param platform 平台类型（0手机淘宝1手机天猫2手机京东）
     */
    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    /**
     * 店铺id/名称
     * [whh]@return shop_id 店铺id/名称
     */
    public String getShopId() {
        return shopId;
    }

    /**
     * 店铺id/名称
     * @param shopId 店铺id/名称
     */
    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    /**
     * 宝贝链接
     * [whh]@return baby_link 宝贝链接
     */
    public String getBabyLink() {
        return babyLink;
    }

    /**
     * 宝贝链接
     * @param babyLink 宝贝链接
     */
    public void setBabyLink(String babyLink) {
        this.babyLink = babyLink;
    }

    /**
     * 宝贝类目id组合
     * [whh]@return shop_cate_ids 宝贝类目id组合
     */
    public String getShopCateIds() {
        return shopCateIds;
    }

    /**
     * 宝贝类目id组合
     * @param shopCateIds 宝贝类目id组合
     */
    public void setShopCateIds(String shopCateIds) {
        this.shopCateIds = shopCateIds;
    }

    /**
     * 宝贝类目名称
     * [whh]@return shop_cate_name 宝贝类目名称
     */
    public String getShopCateName() {
        return shopCateName;
    }

    /**
     * 宝贝类目名称
     * @param shopCateName 宝贝类目名称
     */
    public void setShopCateName(String shopCateName) {
        this.shopCateName = shopCateName;
    }

    /**
     * 宝贝名称
     * [whh]@return baby_name 宝贝名称
     */
    public String getBabyName() {
        return babyName;
    }

    /**
     * 宝贝名称
     * @param babyName 宝贝名称
     */
    public void setBabyName(String babyName) {
        this.babyName = babyName;
    }

    /**
     * 宝贝主图
     * [whh]@return baby_main_pic 宝贝主图
     */
    public String getBabyMainPic() {
        return babyMainPic;
    }

    /**
     * 宝贝主图
     * @param babyMainPic 宝贝主图
     */
    public void setBabyMainPic(String babyMainPic) {
        this.babyMainPic = babyMainPic;
    }

    /**
     * SKU截图
     * [whh]@return baby_sku_pic SKU截图
     */
    public String getBabySkuPic() {
        return babySkuPic;
    }

    /**
     * SKU截图
     * @param babySkuPic SKU截图
     */
    public void setBabySkuPic(String babySkuPic) {
        this.babySkuPic = babySkuPic;
    }

    /**
     * 体验价格（单位：分）
     * [whh]@return experi_price 体验价格（单位：分）
     */
    public Long getBabyPrice() {
        return babyPrice;
    }

    /**
     * 体验价格（单位：分）
     * @param babyPrice 体验价格（单位：分）
     */
    public void setBabyPrice(Long babyPrice) {
        this.babyPrice = babyPrice;
    }

    /**
     * 是否包邮
     * [whh]@return shipping 是否包邮
     */
    public Integer getShipping() {
        return shipping;
    }

    /**
     * 是否包邮
     * @param shipping 是否包邮
     */
    public void setShipping(Integer shipping) {
        this.shipping = shipping;
    }

    /**
     * 基础邮费（单位：分）
     * [whh]@return postage 基础邮费（单位：分）
     */
    public Long getPostage() {
        return postage;
    }

    /**
     * 基础邮费（单位：分）
     * @param postage 基础邮费（单位：分）
     */
    public void setPostage(Long postage) {
        this.postage = postage;
    }

    /**
     * 体验类型
     * [whh]@return experi_type 体验类型
     */
    public Integer getExperiType() {
        return experiType;
    }

    /**
     * 体验类型
     * @param experiType 体验类型
     */
    public void setExperiType(Integer experiType) {
        this.experiType = experiType;
    }

    /**
     * 商品重量（单位：斤）
     * [whh]@return weight 商品重量（单位：斤）
     */
    public Long getWeight() {
        return weight;
    }

    /**
     * 商品重量（单位：斤）
     * @param weight 商品重量（单位：斤）
     */
    public void setWeight(Long weight) {
        this.weight = weight;
    }

    /**
     * 体验类型
     * [whh]@return experi_way 体验类型
     */
    public Integer getExperiWay() {
        return experiWay;
    }

    /**
     * 体验类型
     * @param experiWay 体验类型
     */
    public void setExperiWay(Integer experiWay) {
        this.experiWay = experiWay;
    }

    /**
     * 搜索关键字，以半角逗号分隔
     * [whh]@return serch_keys 搜索关键字，以半角逗号分隔
     */
    public String getSerchKeys() {
        return serchKeys;
    }

    /**
     * 搜索关键字，以半角逗号分隔
     * @param serchKeys 搜索关键字，以半角逗号分隔
     */
    public void setSerchKeys(String serchKeys) {
        this.serchKeys = serchKeys;
    }

    /**
     * 搜索截图
     * [whh]@return search_pic 搜索截图
     */
    public String getSearchPic() {
        return searchPic;
    }

    /**
     * 搜索截图
     * @param searchPic 搜索截图
     */
    public void setSearchPic(String searchPic) {
        this.searchPic = searchPic;
    }

    /**
     * 卡条件截图
     * [whh]@return of_condition_pic 卡条件截图
     */
    public String getOfConditionPic() {
        return ofConditionPic;
    }

    /**
     * 卡条件截图
     * @param ofConditionPic 卡条件截图
     */
    public void setOfConditionPic(String ofConditionPic) {
        this.ofConditionPic = ofConditionPic;
    }

    /**
     * 停留时间分类
     * [whh]@return stay_time 停留时间分类
     */
    public Integer getStayTime() {
        return stayTime;
    }

    /**
     * 停留时间分类
     * @param stayTime 停留时间分类
     */
    public void setStayTime(Integer stayTime) {
        this.stayTime = stayTime;
    }

    /**
     * 体验发布数量
     * [whh]@return experi_number 体验发布数量
     */
    public Integer getExperiNumber() {
        return experiNumber;
    }

    /**
     * 体验发布数量
     * @param experiNumber 体验发布数量
     */
    public void setExperiNumber(Integer experiNumber) {
        this.experiNumber = experiNumber;
    }

    /**
     * 体验日期
     * [whh]@return experi_date 体验日期
     */
    public String getExperiDate() {
        return experiDate;
    }

    /**
     * 体验日期
     * @param experiDate 体验日期
     */
    public void setExperiDate(String experiDate) {
        this.experiDate = experiDate;
    }

    /**
     * 进店后浏览
     * [whh]@return view_time 进店后浏览
     */
    public String getViewTime() {
        return viewTime;
    }

    /**
     * 进店后浏览
     * @param viewTime 进店后浏览
     */
    public void setViewTime(String viewTime) {
        this.viewTime = viewTime;
    }

    /**
     * 附加值
     * [whh]@return added_value 附加值
     */
    public String getAddedValue() {
        return addedValue;
    }

    /**
     * 附加值
     * @param addedValue 附加值
     */
    public void setAddedValue(String addedValue) {
        this.addedValue = addedValue;
    }

    /**
     * 模特年龄选项
     * [whh]@return model_age 模特年龄选项
     */
    public String getModelAge() {
        return modelAge;
    }

    /**
     * 模特年龄选项
     * @param modelAge 模特年龄选项
     */
    public void setModelAge(String modelAge) {
        this.modelAge = modelAge;
    }

    /**
     * 模特性别
     * [whh]@return model_gender 模特性别
     */
    public Integer getModelGender() {
        return modelGender;
    }

    /**
     * 模特性别
     * @param modelGender 模特性别
     */
    public void setModelGender(Integer modelGender) {
        this.modelGender = modelGender;
    }

    /**
     * 淘气值区间
     * [whh]@return naughty_value 淘气值区间
     */
    public String getNaughtyValue() {
        return naughtyValue;
    }

    /**
     * 淘气值区间
     * @param naughtyValue 淘气值区间
     */
    public void setNaughtyValue(String naughtyValue) {
        this.naughtyValue = naughtyValue;
    }

    /**
     * 模特所在区域
     * [whh]@return model_area 模特所在区域
     */
    public String getModelArea() {
        return modelArea;
    }

    /**
     * 模特所在区域
     * @param modelArea 模特所在区域
     */
    public void setModelArea(String modelArea) {
        this.modelArea = modelArea;
    }

    /**
     * 体验注意事项隔
     * [whh]@return notice 体验注意事项隔
     */
    public String getNotice() {
        return notice;
    }

    /**
     * 体验注意事项隔
     * @param notice 体验注意事项隔
     */
    public void setNotice(String notice) {
        this.notice = notice;
    }

    /**
     * 拍摄注意事项
     * [whh]@return shoot_notice 拍摄注意事项
     */
    public String getShootNotice() {
        return shootNotice;
    }

    /**
     * 拍摄注意事项
     * @param shootNotice 拍摄注意事项
     */
    public void setShootNotice(String shootNotice) {
        this.shootNotice = shootNotice;
    }

    /**
     * 退货收件人
     * [whh]@return offline_return_recerver 退货收件人
     */
    public String getOfflineReturnRecerver() {
        return offlineReturnRecerver;
    }

    /**
     * 退货收件人
     * @param offlineReturnRecerver 退货收件人
     */
    public void setOfflineReturnRecerver(String offlineReturnRecerver) {
        this.offlineReturnRecerver = offlineReturnRecerver;
    }

    /**
     * 退货联系电话
     * [whh]@return offline_return_phone 退货联系电话
     */
    public String getOfflineReturnPhone() {
        return offlineReturnPhone;
    }

    /**
     * 退货联系电话
     * @param offlineReturnPhone 退货联系电话
     */
    public void setOfflineReturnPhone(String offlineReturnPhone) {
        this.offlineReturnPhone = offlineReturnPhone;
    }

    /**
     * 退货省
     * [whh]@return offline_return_province 退货省
     */
    public String getOfflineReturnProvince() {
        return offlineReturnProvince;
    }

    /**
     * 退货省
     * @param offlineReturnProvince 退货省
     */
    public void setOfflineReturnProvince(String offlineReturnProvince) {
        this.offlineReturnProvince = offlineReturnProvince;
    }

    /**
     * 退货市
     * [whh]@return offline_return_city 退货市
     */
    public String getOfflineReturnCity() {
        return offlineReturnCity;
    }

    /**
     * 退货市
     * @param offlineReturnCity 退货市
     */
    public void setOfflineReturnCity(String offlineReturnCity) {
        this.offlineReturnCity = offlineReturnCity;
    }

    /**
     * 退货区
     * [whh]@return offline_return_area 退货区
     */
    public String getOfflineReturnArea() {
        return offlineReturnArea;
    }

    /**
     * 退货区
     * @param offlineReturnArea 退货区
     */
    public void setOfflineReturnArea(String offlineReturnArea) {
        this.offlineReturnArea = offlineReturnArea;
    }

    /**
     * 退货详细地址
     * [whh]@return offline_return_address 退货详细地址
     */
    public String getOfflineReturnAddress() {
        return offlineReturnAddress;
    }

    /**
     * 退货详细地址
     * @param offlineReturnAddress 退货详细地址
     */
    public void setOfflineReturnAddress(String offlineReturnAddress) {
        this.offlineReturnAddress = offlineReturnAddress;
    }

    /**
     * 退货注意事项
     * [whh]@return offline_return_notice 退货注意事项
     */
    public String getOfflineReturnNotice() {
        return offlineReturnNotice;
    }

    /**
     * 退货注意事项
     * @param offlineReturnNotice 退货注意事项
     */
    public void setOfflineReturnNotice(String offlineReturnNotice) {
        this.offlineReturnNotice = offlineReturnNotice;
    }

    /**
     * 是否模板
     * [whh]@return as_template 是否模板
     */
    public Integer getAsTemplate() {
        return asTemplate;
    }

    /**
     * 是否模板
     * @param asTemplate 是否模板
     */
    public void setAsTemplate(Integer asTemplate) {
        this.asTemplate = asTemplate;
    }

    /**
     * 
     * [whh]@return member_id 
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 
     * @param memberId 
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * 
     * [whh]@return template_name 
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * 
     * @param templateName 
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    /**
     * 总价格（单位：分）
     * [whh]@return total_amount 总价格（单位：分）
     */
    public Long getTotalAmount() {
        return totalAmount;
    }

    /**
     * 总价格（单位：分）
     * @param totalAmount 总价格（单位：分）
     */
    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getAddValuePrice() {
        return addValuePrice;
    }

    public void setAddValuePrice(Long addValuePrice) {
        this.addValuePrice = addValuePrice;
    }

    public Long getNaughtyPrice() {
        return naughtyPrice;
    }

    public void setNaughtyPrice(Long naughtyPrice) {
        this.naughtyPrice = naughtyPrice;
    }

    public Long getModelAreaPrice() {
        return modelAreaPrice;
    }

    public void setModelAreaPrice(Long modelAreaPrice) {
        this.modelAreaPrice = modelAreaPrice;
    }

    public Long getWeightPrice() {
        return weightPrice;
    }

    public void setWeightPrice(Long weightPrice) {
        this.weightPrice = weightPrice;
    }

    public Long getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Long servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Long getModelReward() {
        return modelReward;
    }

    public void setModelReward(Long modelReward) {
        this.modelReward = modelReward;
    }
    

	public Integer getSurplusNumber() {
		return surplusNumber;
	}

	public void setSurplusNumber(Integer surplusNumber) {
		this.surplusNumber = surplusNumber;
	}

	public String getSerchKeysTwo() {
		return serchKeysTwo;
	}

	public void setSerchKeysTwo(String serchKeysTwo) {
		this.serchKeysTwo = serchKeysTwo;
	}

	public String getSerchKeysThree() {
		return serchKeysThree;
	}

	public void setSerchKeysThree(String serchKeysThree) {
		this.serchKeysThree = serchKeysThree;
	}

    public Long getTotalPayAmount() {
        return totalPayAmount;
    }

    public void setTotalPayAmount(Long totalPayAmount) {
        this.totalPayAmount = totalPayAmount;
    }
}