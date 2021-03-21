package vitily.com.tb_entity.mem;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:商家信息表表表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2018-12-06
 */
public class TbMemSeller extends BaseEntity {

    /**
     * 
     */
    private Integer memberId;

    /**
     * 商家会员级别
     */
    private Integer level;

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
     * 商家会员级别
     * [whh]@return level 商家会员级别
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 商家会员级别
     * @param level 商家会员级别
     */
    public void setLevel(Integer level) {
        this.level = level;
    }
}