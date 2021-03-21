package vitily.com.tb_entity.mem;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:会员摩卡表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2018-12-08
 */
public class TbMemMocard extends BaseEntity {

    /**
     * 会员ID
     */
    private Integer memberId;

    /**
     * 摩卡图片地址
     */
    private String picUrl;
    /**
     * 会员ID
     * [whh]@return member_id 会员ID
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 会员ID
     * @param memberId 会员ID
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * 摩卡图片地址
     * [whh]@return pic_url 摩卡图片地址
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * 摩卡图片地址
     * @param picUrl 摩卡图片地址
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}