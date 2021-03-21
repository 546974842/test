package vitily.com.tv_entity.mem;

import vitily.com.consts.MoneyTransverStateDesc;
import vitily.com.tb_entity.mem.TbMemMoneyTransfer;
import vitily.com.util.EnumHelperUtil;

public class TvMemMoneyTransfer extends TbMemMoneyTransfer {
    private String memName;
    private String memRealName;
    private String auditAdmUserName;
    @Override
    public String getStateDesc(){
        this.stateDesc = EnumHelperUtil.getEnumWrapDescByValue(MoneyTransverStateDesc.class, this.getState());
        return this.stateDesc;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getMemRealName() {
        return memRealName;
    }

    public void setMemRealName(String memRealName) {
        this.memRealName = memRealName;
    }

    public String getAuditAdmUserName() {
        return auditAdmUserName;
    }

    public void setAuditAdmUserName(String auditAdmUserName) {
        this.auditAdmUserName = auditAdmUserName;
    }
}
