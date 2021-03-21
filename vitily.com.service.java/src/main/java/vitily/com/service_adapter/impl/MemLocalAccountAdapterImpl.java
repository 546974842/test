package vitily.com.service_adapter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.consts.DelTagDesc;
import vitily.com.consts.FundsDirectionDesc;
import vitily.com.consts.FundsTypeDesc;
import vitily.com.consts.ResultStatus;
import vitily.com.tb_entity.finance.TbAccountFlow;
import vitily.com.tb_entity.mem.TbMemLocalAccount;
import vitily.com.mapper.finance.AccountFlowMapper;
import vitily.com.mapper.mem.MemLocalAccountMapper;
import vitily.com.other_entity.CustomerException;
import vitily.com.service_adapter.MemLocalAccountAdapter;
import vitily.com.ts_entity.mem.TsMemLocalAccount;
import vitily.com.util.MemberUtil;
import vitily.com.util.NumberUtil;

import java.util.Date;

@Component
public class MemLocalAccountAdapterImpl implements MemLocalAccountAdapter{
    @Autowired
    private MemLocalAccountMapper memLocalAccountMapper;
    @Autowired
    private AccountFlowMapper accountFlowMapper;
    /**
     * 冻结收入
     */
    @Override
    public void freezeIn(
            Integer memberId
            ,Long operaAmount
            ,FundsTypeDesc fundsType
            ,String memo
            ,int platform
            ,Integer relationId
            ,Date date)throws Exception{
        TbMemLocalAccount localAccount = selectAndCheckFreezeAmount(memberId,0,fundsType);
        localAccount.setFreezeAmount(localAccount.getFreezeAmount() + operaAmount);
        upMemLocalAcc(localAccount,operaAmount, FundsDirectionDesc.预授权收入,fundsType,memo,platform,relationId,date);
    }
    /**
     * 冻结支出，还款成功，提现成功，投标成功已放款
     */
    @Override
    public void freezeOut(
            Integer memberId
            ,Long operaAmount
            ,FundsTypeDesc fundsType
            ,String memo
            ,int platform
            ,Integer relationId
            ,Date date)throws Exception{
        TbMemLocalAccount localAccount = selectAndCheckFreezeAmount(memberId,operaAmount,fundsType);
        localAccount.setFreezeAmount(localAccount.getFreezeAmount() - operaAmount);
        upMemLocalAcc(localAccount,operaAmount,FundsDirectionDesc.支出,fundsType,memo,platform,relationId,date);
    }
    /**
     * 普通收入：充值、放款等
     */
    @Override
    public void availableIn(
            Integer memberId
            ,Long operaAmount
            ,FundsTypeDesc fundsType
            ,String memo
            ,int platform
            ,Integer relationId
            ,Date date)throws Exception{

        //第一步，取出用户余额
        TbMemLocalAccount localAccount = selectAndCheckAvailableAmount(memberId,0,fundsType);
        localAccount.setAvailableAmount(localAccount.getAvailableAmount() + operaAmount);
        upMemLocalAcc(localAccount,operaAmount,FundsDirectionDesc.收入,fundsType,memo,platform,relationId,date);
    }
    /**
     * 普通支出
     */
    @Override
    public void availableOut(
            Integer memberId
            ,Long operaAmount
            ,FundsTypeDesc fundsType
            ,String memo
            ,int platform
            ,Integer relationId
            ,Date date)throws Exception{
        TbMemLocalAccount localAccount = selectAndCheckAvailableAmount(memberId,operaAmount,fundsType);
        localAccount.setAvailableAmount(localAccount.getAvailableAmount() - operaAmount);
        upMemLocalAcc(localAccount,operaAmount,FundsDirectionDesc.支出,fundsType,memo,platform,relationId,date);
    }

    /**
     * 支出->冻结中，投标，提现申请、还款申请
     */
    @Override
    public void availableToFreeze(
            Integer memberId
            ,Long operaAmount
            ,FundsTypeDesc fundsType
            ,String memo
            ,int platform
            ,Integer relationId
            ,Date date)throws Exception{
        TbMemLocalAccount localAccount = selectAndCheckAvailableAmount(memberId,operaAmount,fundsType);
        localAccount.setAvailableAmount(localAccount.getAvailableAmount() -operaAmount);//可用金额少了
        localAccount.setFreezeAmount(localAccount.getFreezeAmount() + operaAmount);//冻结金额多了
        upMemLocalAcc(localAccount,operaAmount,FundsDirectionDesc.预授权支出,fundsType,memo,platform,relationId,date);
    }

    /**
     * 冻结->收入，流标返还资金、提现驳回
     */
    @Override
    public void freezeToAvailable(
            Integer memberId
            ,Long operaAmount
            ,FundsTypeDesc fundsType
            ,String memo
            ,int platform
            ,Integer relationId
            ,Date date)throws Exception{
        TbMemLocalAccount localAccount = selectAndCheckAvailableAmount(memberId,0,fundsType);
        localAccount.setFreezeAmount(localAccount.getFreezeAmount() - operaAmount);//冻结金额少了
        localAccount.setAvailableAmount(localAccount.getAvailableAmount() + operaAmount);//可用金额多了
        upMemLocalAcc(localAccount,operaAmount,FundsDirectionDesc.收入,fundsType,memo,platform,relationId,date);
    }


    private TbMemLocalAccount selectAndCheckAvailableAmount(int memberId,long checkAmount,FundsTypeDesc fundsType)throws Exception{
        TbMemLocalAccount localAccount = memLocalAccountMapper.selectByMemberIdForUpdate(memberId);
        MemberUtil.checkMemAvailableAmount(localAccount, checkAmount,"账户余额[%s]不足，无法操作["+fundsType.getDesc()+"]了哟[%s]");
        return localAccount;
    }
    private TbMemLocalAccount selectAndCheckFreezeAmount(int memberId,long checkAmount,FundsTypeDesc fundsType)throws Exception{
        TbMemLocalAccount localAccount = memLocalAccountMapper.selectByMemberIdForUpdate(memberId);
        MemberUtil.checkMemFreezeAmount(localAccount, checkAmount,"账户冻结余额[%s]不足，无法操作["+fundsType.getDesc()+"]了哟[%s]");
        return localAccount;
    }
    private void upMemLocalAcc(
            TbMemLocalAccount localAccount
            ,Long operaAmount
            ,FundsDirectionDesc direction
            ,FundsTypeDesc fundsType
            ,String memo
            ,int platform
            ,Integer relationId
            ,Date date)throws Exception{

        //1，更新用户资金
        TsMemLocalAccount queryLocalAcc = new TsMemLocalAccount();
        queryLocalAcc.setOldVersion(localAccount.getVersion());
        localAccount.setVersion(localAccount.getVersion() + 1);
        localAccount.setUpdateDate(date);
        queryLocalAcc.setEntity(localAccount);

        //2，插入资金流水，
        TbAccountFlow accountFlow = new TbAccountFlow();
        accountFlow.setCreateDate(date);
        accountFlow.setDeltag(DelTagDesc.正常.getValue());
        accountFlow.setMemberId(localAccount.getMemberId());
        accountFlow.setAmount(operaAmount);
        accountFlow.setAvailableBalance(localAccount.getAvailableAmount());
        accountFlow.setFreezeBalance(localAccount.getFreezeAmount());
        String sb = "进行[" + fundsType.getDesc() + "]操作，涉及金额:[" + NumberUtil.respScale2MDownYuanByCent(operaAmount) + "],会员ID[" + localAccount.getMemberId() + "]";
        accountFlow.setMemo(sb);
        accountFlow.setFundsType(fundsType.getValue());
        accountFlow.setPlatform(platform);
        accountFlow.setRelationId(relationId);
        accountFlow.setRemark("操作备注："+memo);
        accountFlow.setDirection(direction.getValue());

        //1,判断冻结资金、可用余额是否大于等于0
        if(accountFlow.getAvailableBalance() < 0 || accountFlow.getFreezeBalance() < 0){
            throw new CustomerException("用户余额或者冻结余额异常了哟,余额["+ NumberUtil.respScale2MDownYuanByCent(accountFlow.getAvailableBalance())+"],冻结余额["+ NumberUtil.respScale2MDownYuanByCent(accountFlow.getFreezeBalance())+"]！" , ResultStatus.操作异常);
        }
        //1，更新用户资金
        if(memLocalAccountMapper.updateByTs(queryLocalAcc) < 1){
            throw new CustomerException("更新用户账户异常了哟！" , ResultStatus.操作异常);
        }
        //2，插入资金流水，
        if(accountFlowMapper.insertSelective(accountFlow) < 1){
            throw new CustomerException("资金流水插入异常！" , ResultStatus.操作异常);
        }
    }
}
