package vitily.com.tv_entity.mem;

import vitily.com.consts.CreditfileTypeDesc;
import vitily.com.tb_entity.mem.TbMemCreditHistory;
import vitily.com.util.CommonUtil;
import vitily.com.util.EnumHelperUtil;

public class TvMemCreditHistory extends TbMemCreditHistory {
    private String memName;
    private String memRealName;//真实姓名or公司名称
    private String admUserName;
    private String recordTypeDesc;
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

    public String getAdmUserName() {
        return admUserName;
    }

    public void setAdmUserName(String admUserName) {
        this.admUserName = admUserName;
    }

    public String getRecordTypeDesc() {
        if(CommonUtil.isNull(recordTypeDesc)){
            recordTypeDesc = EnumHelperUtil.getEnumWrapDescByValue(CreditfileTypeDesc.class,this.getRecordType());
        }
        return recordTypeDesc;
    }
}
