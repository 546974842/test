package vitily.com.tb_entity.mem;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

import vitily.base.tb_entity.BaseEntity;
import vitily.com.consts.MemModelDesc;
import vitily.com.util.EnumHelperUtil;
/**
 * 描述:tb_mem_model_info模特信息表实体
 * @version
 * @author:  lether
 * @创建时间: 2017-07-21
 */
public class TbModelInfo  extends BaseEntity {
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 会员
     */
    private Integer memberId;
    
    /**
     * QQ
     */
    private String investCode;

    /**
     * 身高
     */
    private String height;
    /**
     * 性别
     */
    private String sex;

    /**
     * 体重
     */
    private String weight;

    /**
     * 职业
     */
    private String occupation;

    /**
     * 拍摄风格
     */
    private String style;

    /**
     * 期望价格
     */
    private String price;

    /**
     * 拍摄用材
     */
    private String tool;

    /**
     * 可否送拍
     */
    private String give;

    /**
     * 买家信誉
     */
    private String credit;

    /**
     * 系方式联
     */
    private String contact;
    /**
     * 淘气值
     */
    private String tqValue;    
    /**
     * 淘宝信用
     */
    private String tbCredit;    
    /**
     * 身份证图片
     */
    private String idImg;    
    /**
     * 封面图片
     */
    private String picImg;    
    /**
     * 作品一
     */
    private String oneImg;    
    /**
     * 作品二
     */
    private String twoImg;  
    /**
     * 作品三
     */
    private String threeImg;    
    /**
     * 艺名
     */
    private String name;    
    /**
     * 所在城市
     */
    private String city;    
    /**
     * 年龄
     */
    private String age;    
    /**
     * 是否推荐1是
     */
    private Integer isRecommend;    
    /**
     * 状态1上架2待审核3下架
     */
    private Integer status;    
    /**
     * 喜欢
     */
    private Integer likeNum;    
    /**
     * 不喜欢数
     */
    private Integer dislikeNum;    
    /**
     * 查看数	
     */
    private Integer lookNum;    
    
    /**
     * 收藏数	
     */
    private Integer collesNum;    
    
    /**
     * 订单id
     */
    private Integer orderId;    
    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;    
    /**
     * 最后更新时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;    
    
    /**
     * 剩余数
     */
    private Integer surplusNumber;
    /**
     * 总数
     */
	private Integer experiNumber;
	
    protected String statusDesc;
    
    /**
     * 宝贝名称
     */
    protected String babyName;
    /**
     * 订单状态
     */
    protected Integer dealStatus;
    
    
    
    
	public Integer getDealStatus() {
		return dealStatus;
	}


	public void setDealStatus(Integer dealStatus) {
		this.dealStatus = dealStatus;
	}


	public String getBabyName() {
		return babyName;
	}


	public void setBabyName(String babyName) {
		this.babyName = babyName;
	}


	public Integer getSurplusNumber() {
		return surplusNumber;
	}


	public void setSurplusNumber(Integer surplusNumber) {
		this.surplusNumber = surplusNumber;
	}


	public Integer getExperiNumber() {
		return experiNumber;
	}


	public void setExperiNumber(Integer experiNumber) {
		this.experiNumber = experiNumber;
	}


	public String getStatusDesc(){
		this.statusDesc = EnumHelperUtil.getEnumWrapDescByValue(MemModelDesc.class, status);
		return this.statusDesc;
	}
    

	public Integer getOrderId() {
		return orderId;
	}



	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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


	public Integer getCollesNum() {
		return collesNum;
	}


	public void setCollesNum(Integer collesNum) {
		this.collesNum = collesNum;
	}


	public Integer getIsRecommend() {
		return isRecommend;
	}


	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Integer getLikeNum() {
		return likeNum;
	}


	public void setLikeNum(Integer likeNum) {
		this.likeNum = likeNum;
	}


	public Integer getDislikeNum() {
		return dislikeNum;
	}


	public void setDislikeNum(Integer dislikeNum) {
		this.dislikeNum = dislikeNum;
	}


	public Integer getLookNum() {
		return lookNum;
	}


	public void setLookNum(Integer lookNum) {
		this.lookNum = lookNum;
	}




	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getTqValue() {
		return tqValue;
	}


	public void setTqValue(String tqValue) {
		this.tqValue = tqValue;
	}


	public String getTbCredit() {
		return tbCredit;
	}


	public void setTbCredit(String tbCredit) {
		this.tbCredit = tbCredit;
	}


	public String getIdImg() {
		return idImg;
	}


	public void setIdImg(String idImg) {
		this.idImg = idImg;
	}


	public String getPicImg() {
		return picImg;
	}


	public void setPicImg(String picImg) {
		this.picImg = picImg;
	}


	public String getOneImg() {
		return oneImg;
	}


	public void setOneImg(String oneImg) {
		this.oneImg = oneImg;
	}


	public String getTwoImg() {
		return twoImg;
	}


	public void setTwoImg(String twoImg) {
		this.twoImg = twoImg;
	}


	public String getThreeImg() {
		return threeImg;
	}


	public void setThreeImg(String threeImg) {
		this.threeImg = threeImg;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getMemberId() {
		return memberId;
	}


	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}


	public String getHeight() {
		return height;
	}


	public void setHeight(String height) {
		this.height = height;
	}


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public String getOccupation() {
		return occupation;
	}


	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}


	public String getStyle() {
		return style;
	}


	public void setStyle(String style) {
		this.style = style;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getTool() {
		return tool;
	}


	public void setTool(String tool) {
		this.tool = tool;
	}


	public String getGive() {
		return give;
	}


	public void setGive(String give) {
		this.give = give;
	}


	public String getCredit() {
		return credit;
	}


	public void setCredit(String credit) {
		this.credit = credit;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getInvestCode() {
		return investCode;
	}


	public void setInvestCode(String investCode) {
		this.investCode = investCode;
	}


	
}