package vitily.com.api_entity.req_entity.mem;

import vitily.com.annotation.RequireValidator;

public class TqModelCertify extends TqMemBase{

    /**
     * 艺名
     */
    @RequireValidator
    private String name;

    /**
     * 性别
     */
    @RequireValidator
    private String sex;

    /**
     * 年龄
     */
    @RequireValidator
    private String age;

    /**
     * 所在城市
     */
    @RequireValidator
    private String city;

    /**
     * 身高
     */
    @RequireValidator
    private String height;

    /**
     * 体重范围
     */
    @RequireValidator
    private String weight;

    /**
     * 职业
     */
    @RequireValidator
    private String occupation;

    /**
     * 拍摄风格
     */
    @RequireValidator
    private String style;

    /**
     * 期望价格
     */
    @RequireValidator
    private String price;

    /**
     * 拍摄用材
     */
    @RequireValidator
    private String tool;

    /**
     * 可否送拍
     */
    @RequireValidator
    private String give;

    /**
     * 联系方式
     */
    @RequireValidator
    private String contact;

    /**
     * 淘气值
     */
    @RequireValidator
    private String tqValue;

    /**
     * 淘宝信用
     */
    @RequireValidator
    private String tbCredit;

    /**
     * 身份证图片
     */
    //@RequireValidator
    private String idImg;

    /**
     * 封面图片
     */
    @RequireValidator
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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
}
