package vitily.com.tb_entity.mem;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:模特信息表表的实体类
 * @version
 * @author:  pc
 * @创建时间: 2018-12-25
 */
public class TbMemModelInfo extends BaseEntity {

    /**
     * 
     */
    private Integer memberId;

    /**
     * 是否推荐1是
     */
    private Integer isRecommend;

    /**
     * 状态1上架2待审核3下架
     */
    private Integer status;

    /**
     * 推荐码
     */
    private Integer investCode;

    /**
     * 艺名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private String age;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 身高
     */
    private String height;

    /**
     * 体重范围
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
     * 是否推荐1是
     * [whh]@return is_recommend 是否推荐1是
     */
    public Integer getIsRecommend() {
        return isRecommend;
    }

    /**
     * 是否推荐1是
     * @param isRecommend 是否推荐1是
     */
    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    /**
     * 状态1上架2待审核3下架
     * [whh]@return status 状态1上架2待审核3下架
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态1上架2待审核3下架
     * @param status 状态1上架2待审核3下架
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 推荐码
     * [whh]@return invest_code 推荐码
     */
    public Integer getInvestCode() {
        return investCode;
    }

    /**
     * 推荐码
     * @param investCode 推荐码
     */
    public void setInvestCode(Integer investCode) {
        this.investCode = investCode;
    }

    /**
     * 艺名
     * [whh]@return name 艺名
     */
    public String getName() {
        return name;
    }

    /**
     * 艺名
     * @param name 艺名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 性别
     * [whh]@return sex 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性别
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 年龄
     * [whh]@return age 年龄
     */
    public String getAge() {
        return age;
    }

    /**
     * 年龄
     * @param age 年龄
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * 所在城市
     * [whh]@return city 所在城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 所在城市
     * @param city 所在城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 身高
     * [whh]@return height 身高
     */
    public String getHeight() {
        return height;
    }

    /**
     * 身高
     * @param height 身高
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * 体重范围
     * [whh]@return weight 体重范围
     */
    public String getWeight() {
        return weight;
    }

    /**
     * 体重范围
     * @param weight 体重范围
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * 职业
     * [whh]@return occupation 职业
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * 职业
     * @param occupation 职业
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * 拍摄风格
     * [whh]@return style 拍摄风格
     */
    public String getStyle() {
        return style;
    }

    /**
     * 拍摄风格
     * @param style 拍摄风格
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * 期望价格
     * [whh]@return price 期望价格
     */
    public String getPrice() {
        return price;
    }

    /**
     * 期望价格
     * @param price 期望价格
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * 拍摄用材
     * [whh]@return tool 拍摄用材
     */
    public String getTool() {
        return tool;
    }

    /**
     * 拍摄用材
     * @param tool 拍摄用材
     */
    public void setTool(String tool) {
        this.tool = tool;
    }

    /**
     * 可否送拍
     * [whh]@return give 可否送拍
     */
    public String getGive() {
        return give;
    }

    /**
     * 可否送拍
     * @param give 可否送拍
     */
    public void setGive(String give) {
        this.give = give;
    }

    /**
     * 买家信誉
     * [whh]@return credit 买家信誉
     */
    public String getCredit() {
        return credit;
    }

    /**
     * 买家信誉
     * @param credit 买家信誉
     */
    public void setCredit(String credit) {
        this.credit = credit;
    }

    /**
     * 系方式联
     * [whh]@return contact 系方式联
     */
    public String getContact() {
        return contact;
    }

    /**
     * 系方式联
     * @param contact 系方式联
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * 淘气值
     * [whh]@return tq_value 淘气值
     */
    public String getTqValue() {
        return tqValue;
    }

    /**
     * 淘气值
     * @param tqValue 淘气值
     */
    public void setTqValue(String tqValue) {
        this.tqValue = tqValue;
    }

    /**
     * 淘宝信用
     * [whh]@return tb_credit 淘宝信用
     */
    public String getTbCredit() {
        return tbCredit;
    }

    /**
     * 淘宝信用
     * @param tbCredit 淘宝信用
     */
    public void setTbCredit(String tbCredit) {
        this.tbCredit = tbCredit;
    }

    /**
     * 身份证图片
     * [whh]@return id_img 身份证图片
     */
    public String getIdImg() {
        return idImg;
    }

    /**
     * 身份证图片
     * @param idImg 身份证图片
     */
    public void setIdImg(String idImg) {
        this.idImg = idImg;
    }

    /**
     * 封面图片
     * [whh]@return pic_img 封面图片
     */
    public String getPicImg() {
        return picImg;
    }

    /**
     * 封面图片
     * @param picImg 封面图片
     */
    public void setPicImg(String picImg) {
        this.picImg = picImg;
    }

    /**
     * 作品一
     * [whh]@return one_img 作品一
     */
    public String getOneImg() {
        return oneImg;
    }

    /**
     * 作品一
     * @param oneImg 作品一
     */
    public void setOneImg(String oneImg) {
        this.oneImg = oneImg;
    }

    /**
     * 作品二
     * [whh]@return two_img 作品二
     */
    public String getTwoImg() {
        return twoImg;
    }

    /**
     * 作品二
     * @param twoImg 作品二
     */
    public void setTwoImg(String twoImg) {
        this.twoImg = twoImg;
    }

    /**
     * 作品三
     * [whh]@return three_img 作品三
     */
    public String getThreeImg() {
        return threeImg;
    }

    /**
     * 作品三
     * @param threeImg 作品三
     */
    public void setThreeImg(String threeImg) {
        this.threeImg = threeImg;
    }

    /**
     * 喜欢
     * [whh]@return like_num 喜欢
     */
    public Integer getLikeNum() {
        return likeNum;
    }

    /**
     * 喜欢
     * @param likeNum 喜欢
     */
    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    /**
     * 不喜欢数
     * [whh]@return dislike_num 不喜欢数
     */
    public Integer getDislikeNum() {
        return dislikeNum;
    }

    /**
     * 不喜欢数
     * @param dislikeNum 不喜欢数
     */
    public void setDislikeNum(Integer dislikeNum) {
        this.dislikeNum = dislikeNum;
    }

    /**
     * 查看数
     * [whh]@return look_num 查看数
     */
    public Integer getLookNum() {
        return lookNum;
    }

    /**
     * 查看数
     * @param lookNum 查看数
     */
    public void setLookNum(Integer lookNum) {
        this.lookNum = lookNum;
    }

    /**
     * 收藏数
     * [whh]@return colles_num 收藏数
     */
    public Integer getCollesNum() {
        return collesNum;
    }

    /**
     * 收藏数
     * @param collesNum 收藏数
     */
    public void setCollesNum(Integer collesNum) {
        this.collesNum = collesNum;
    }
}