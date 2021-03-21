package vitily.com.ts_entity.mem;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

import org.springframework.format.annotation.DateTimeFormat;

import vitily.base.ts_entity.BaseSearch;
import vitily.com.tb_entity.mem.TbModelInfo;

/**
 * 描述:tb_mem_model_info模特信息表实体
 * @version
 * @author:  lether
 * @创建时间: 2017-07-21
 */
public class TsModelInfo extends BaseSearch<TbModelInfo> {
   
	public TsModelInfo() {
		super(new TbModelInfo());
	}


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
     * 商品id
     */
    private Integer showId;

    /**
     * 身高
     */
    private String height;

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
     * 性别
     */
    private String sex;
    
    /**
     * QQ
     */
    private String invesCode;

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
     * 是否推荐1是
     */
    private Integer isRecommend;    
    /**
     * 状态1上架2待审核3下架
     */
    private Integer status;    
    /**
     * 订单状态
     */
    private Integer state;    
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
     * 订单状态
     */
    private Integer dealStatus;    

    private Integer experiencedAndHotSellerId;
    


    private Double beginWeight;
    private Double endWeight;
    private Double beginHeight;
    private Double endHeight;

    

	public Integer getDealStatus() {
		return dealStatus;
	}


	public void setDealStatus(Integer dealStatus) {
		this.dealStatus = dealStatus;
	}


	public Date getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	public Integer getState() {
		return state;
	}


	public void setState(Integer state) {
		this.state = state;
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


	public String getInvesCode() {
		return invesCode;
	}


	public void setInvesCode(String invesCode) {
		this.invesCode = invesCode;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
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


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Integer getShowId() {
		return showId;
	}


	public void setShowId(Integer showId) {
		this.showId = showId;
	}

	public Integer getExperiencedAndHotSellerId() {
		return experiencedAndHotSellerId;
	}

	public void setExperiencedAndHotSellerId(Integer experiencedAndHotSellerId) {
		this.experiencedAndHotSellerId = experiencedAndHotSellerId;
	}

	public Double getBeginWeight() {
		return beginWeight;
	}

	public void setBeginWeight(Double beginWeight) {
		this.beginWeight = beginWeight;
	}

	public Double getEndWeight() {
		return endWeight;
	}

	public void setEndWeight(Double endWeight) {
		this.endWeight = endWeight;
	}

	public Double getBeginHeight() {
		return beginHeight;
	}

	public void setBeginHeight(Double beginHeight) {
		this.beginHeight = beginHeight;
	}

	public Double getEndHeight() {
		return endHeight;
	}

	public void setEndHeight(Double endHeight) {
		this.endHeight = endHeight;
	}
}