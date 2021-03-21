package vitily.com.service_adapter;

import vitily.com.consts.FundsTypeDesc;

import java.util.Date;

public interface MemLocalAccountAdapter {
    /**
     * 冻结收入
     * @param memberId 会员ID
     * @param operaAmount 操作金额
     * @param fundsType 资金类型
     * @param memo 备注
     * @param platform 资金平台
     * @param relationId 关联ID
     * @param date 操作日期
     */
    void freezeIn(
            Integer memberId
            ,Long operaAmount
            ,FundsTypeDesc fundsType
            ,String memo
            ,int platform
            ,Integer relationId
            ,Date date)throws Exception;
    /**
     * 冻结支出，还款成功，提现成功，放款
     * @param memberId 会员ID
     * @param operaAmount 操作金额
     * @param fundsType 资金类型
     * @param memo 备注
     * @param platform 资金平台
     * @param relationId 关联ID
     * @param date 操作日期
     */
    void freezeOut(
            Integer memberId
            ,Long operaAmount
            ,FundsTypeDesc fundsType
            ,String memo
            ,int platform
            ,Integer relationId
            ,Date date)throws Exception;
    /**
     * 普通收入：充值、放款等
     * @param memberId 会员ID
     * @param operaAmount 操作金额
     * @param fundsType 资金类型
     * @param memo 备注
     * @param platform 资金平台
     * @param relationId 关联ID
     * @param date 操作日期
     */
    void availableIn(
            Integer memberId
            ,Long operaAmount
            ,FundsTypeDesc fundsType
            ,String memo
            ,int platform
            ,Integer relationId
            ,Date date)throws Exception;
    /**
     * 普通支出
     * @param memberId 会员ID
     * @param operaAmount 操作金额
     * @param fundsType 资金类型
     * @param memo 备注
     * @param platform 资金平台
     * @param relationId 关联ID
     * @param date 操作日期
     */
    void availableOut(
            Integer memberId
            ,Long operaAmount
            ,FundsTypeDesc fundsType
            ,String memo
            ,int platform
            ,Integer relationId
            ,Date date)throws Exception;
    /**
     * 支出->冻结中，投标，提现申请、还款申请
     * @param memberId 会员ID
     * @param operaAmount 操作金额
     * @param fundsType 资金类型
     * @param memo 备注
     * @param platform 资金平台
     * @param relationId 关联ID
     * @param date 操作日期
     */
    void availableToFreeze(
            Integer memberId
            ,Long operaAmount
            ,FundsTypeDesc fundsType
            ,String memo
            ,int platform
            ,Integer relationId
            ,Date date)throws Exception;
    /**
     * 普通收入，冻结支出，流标返还资金、提现驳回
     * @param memberId 会员ID
     * @param operaAmount 操作金额
     * @param fundsType 资金类型
     * @param memo 备注
     * @param platform 资金平台
     * @param relationId 关联ID
     * @param date 操作日期
     */
    void freezeToAvailable(
            Integer memberId
            ,Long operaAmount
            ,FundsTypeDesc fundsType
            ,String memo
            ,int platform
            ,Integer relationId
            ,Date date)throws Exception;
}
