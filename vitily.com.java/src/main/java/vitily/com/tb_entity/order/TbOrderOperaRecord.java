package vitily.com.tb_entity.order;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:标的操作记录表的实体类
 * @version
 * @author:  whh
 * @创建时间: 2018-05-15
 */
public class TbOrderOperaRecord extends BaseEntity {

    /**
     * 操作类型
     */
    private Integer type;

    /**
     * 订单ID
     */
    private Integer orderId;

    /**
     * 关联表Id
     */
    private Integer relationId;

    /**
     * 操作描述
     */
    private String memo;

    /**
     * 前台用户
     */
    private Integer memberId;

    /**
     * 后台用户
     */
    private Integer admUserId;

    /**
     * ip
     */
    private String ip;

    /**
     * 字段1
     */
    private String field01;

    /**
     * 值1
     */
    private String value01;

    /**
     * 字段2
     */
    private String field02;

    /**
     * 值2
     */
    private String value02;

    /**
     * 字段3
     */
    private String field03;

    /**
     * 值3
     */
    private String value03;

    /**
     * 字段4
     */
    private String field04;

    /**
     * 值4
     */
    private String value04;

    /**
     * 字段5
     */
    private String field05;

    /**
     * 值5
     */
    private String value05;

    /**
     * 操作详情
     */
    private String content;
    /**
     * 操作类型
     * [whh]@return type 操作类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 操作类型
     * @param type 操作类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 订单ID
     * [whh]@return order_id 订单ID
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 订单ID
     * @param orderId 订单ID
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 关联表Id
     * [whh]@return relation_id 关联表Id
     */
    public Integer getRelationId() {
        return relationId;
    }

    /**
     * 关联表Id
     * @param relationId 关联表Id
     */
    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    /**
     * 操作描述
     * [whh]@return memo 操作描述
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 操作描述
     * @param memo 操作描述
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * 前台用户
     * [whh]@return member_id 前台用户
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 前台用户
     * @param memberId 前台用户
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * 后台用户
     * [whh]@return adm_user_id 后台用户
     */
    public Integer getAdmUserId() {
        return admUserId;
    }

    /**
     * 后台用户
     * @param admUserId 后台用户
     */
    public void setAdmUserId(Integer admUserId) {
        this.admUserId = admUserId;
    }

    /**
     * ip
     * [whh]@return ip ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * ip
     * @param ip ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 字段1
     * [whh]@return field01 字段1
     */
    public String getField01() {
        return field01;
    }

    /**
     * 字段1
     * @param field01 字段1
     */
    public void setField01(String field01) {
        this.field01 = field01;
    }

    /**
     * 值1
     * [whh]@return value01 值1
     */
    public String getValue01() {
        return value01;
    }

    /**
     * 值1
     * @param value01 值1
     */
    public void setValue01(String value01) {
        this.value01 = value01;
    }

    /**
     * 字段2
     * [whh]@return field02 字段2
     */
    public String getField02() {
        return field02;
    }

    /**
     * 字段2
     * @param field02 字段2
     */
    public void setField02(String field02) {
        this.field02 = field02;
    }

    /**
     * 值2
     * [whh]@return value02 值2
     */
    public String getValue02() {
        return value02;
    }

    /**
     * 值2
     * @param value02 值2
     */
    public void setValue02(String value02) {
        this.value02 = value02;
    }

    /**
     * 字段3
     * [whh]@return field03 字段3
     */
    public String getField03() {
        return field03;
    }

    /**
     * 字段3
     * @param field03 字段3
     */
    public void setField03(String field03) {
        this.field03 = field03;
    }

    /**
     * 值3
     * [whh]@return value03 值3
     */
    public String getValue03() {
        return value03;
    }

    /**
     * 值3
     * @param value03 值3
     */
    public void setValue03(String value03) {
        this.value03 = value03;
    }

    /**
     * 字段4
     * [whh]@return field04 字段4
     */
    public String getField04() {
        return field04;
    }

    /**
     * 字段4
     * @param field04 字段4
     */
    public void setField04(String field04) {
        this.field04 = field04;
    }

    /**
     * 值4
     * [whh]@return value04 值4
     */
    public String getValue04() {
        return value04;
    }

    /**
     * 值4
     * @param value04 值4
     */
    public void setValue04(String value04) {
        this.value04 = value04;
    }

    /**
     * 字段5
     * [whh]@return field05 字段5
     */
    public String getField05() {
        return field05;
    }

    /**
     * 字段5
     * @param field05 字段5
     */
    public void setField05(String field05) {
        this.field05 = field05;
    }

    /**
     * 值5
     * [whh]@return value05 值5
     */
    public String getValue05() {
        return value05;
    }

    /**
     * 值5
     * @param value05 值5
     */
    public void setValue05(String value05) {
        this.value05 = value05;
    }

    /**
     * 操作详情
     * [whh]@return content 操作详情
     */
    public String getContent() {
        return content;
    }

    /**
     * 操作详情
     * @param content 操作详情
     */
    public void setContent(String content) {
        this.content = content;
    }
}