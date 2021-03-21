package vitily.com.tv_entity.mem;

import vitily.com.consts.CreditfileCertifyStateDesc;
import vitily.com.consts.CreditfileTypeDesc;
import vitily.com.tb_entity.mem.TbMemCreditfileCertifyLog;
import vitily.com.util.CommonUtil;
import vitily.com.util.EnumHelperUtil;

public class TvMemCreditfileCertifyLog extends TbMemCreditfileCertifyLog {
    private String memName;
    private String memRealName;//真实姓名or公司名称
    private String creditfileTypeDesc;
    private String creditfileStateDesc;
    private String admUserName;

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

    public String getCreditfileTypeDesc() {
        if(CommonUtil.isNull(creditfileTypeDesc)){
            creditfileTypeDesc = EnumHelperUtil.getEnumWrapDescByValue(CreditfileTypeDesc.class,this.getCreditfileType());
        }
        return creditfileTypeDesc;
    }
    public String getCreditfileStateDesc() {
        if(CommonUtil.isNull(creditfileStateDesc)){
            creditfileStateDesc = EnumHelperUtil.getEnumWrapDescByValue(CreditfileCertifyStateDesc.class,this.getCreditfileState());
        }
        return creditfileStateDesc;
    }
    public String getAdmUserName() {
        return admUserName;
    }

    public void setAdmUserName(String admUserName) {
        this.admUserName = admUserName;
    }
}
