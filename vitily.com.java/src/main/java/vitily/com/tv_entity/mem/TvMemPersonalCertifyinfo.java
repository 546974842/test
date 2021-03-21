package vitily.com.tv_entity.mem;

import vitily.com.consts.CreditfileCertifyStateDesc;
import vitily.com.tb_entity.mem.TbMemPersonalCertifyinfo;
import vitily.com.util.EnumHelperUtil;

public class TvMemPersonalCertifyinfo extends TbMemPersonalCertifyinfo {
    private String memName;
    private String memRealName;//真实姓名

    private String idNumberCertifyStateDesc;
    private String tbNumberCertifyStateDesc;
    private String zfbNumberCertifyStateDesc;
    private String bankcardNumberCertifyStateDesc;
    private String wxNumberCertifyStateDesc;
    private String qqNumberCertifyStateDesc;

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

    public void setIdNumberCertifyStateDesc(String idNumberCertifyStateDesc) {
        idNumberCertifyStateDesc = EnumHelperUtil.getEnumWrapDescByValue(CreditfileCertifyStateDesc.class,this.getIdNumberCertifyState());
        this.idNumberCertifyStateDesc = idNumberCertifyStateDesc;
    }

    public void setTbNumberCertifyStateDesc(String tbNumberCertifyStateDesc) {
        tbNumberCertifyStateDesc = EnumHelperUtil.getEnumWrapDescByValue(CreditfileCertifyStateDesc.class,this.getTbNumberCertifyState());
        this.tbNumberCertifyStateDesc = tbNumberCertifyStateDesc;
    }

    public void setZfbNumberCertifyStateDesc(String zfbNumberCertifyStateDesc) {
        zfbNumberCertifyStateDesc = EnumHelperUtil.getEnumWrapDescByValue(CreditfileCertifyStateDesc.class,this.getZfbNumberCertifyState());
        this.zfbNumberCertifyStateDesc = zfbNumberCertifyStateDesc;
    }

    public void setBankcardNumberCertifyStateDesc(String bankcardNumberCertifyStateDesc) {
        bankcardNumberCertifyStateDesc = EnumHelperUtil.getEnumWrapDescByValue(CreditfileCertifyStateDesc.class,this.getBankcardNumberCertifyState());
        this.bankcardNumberCertifyStateDesc = bankcardNumberCertifyStateDesc;
    }

    public void setWxNumberCertifyStateDesc(String wxNumberCertifyStateDesc) {
        qqNumberCertifyStateDesc = EnumHelperUtil.getEnumWrapDescByValue(CreditfileCertifyStateDesc.class,this.getQqNumberCertifyState());
        this.wxNumberCertifyStateDesc = wxNumberCertifyStateDesc;
    }

    public void setQqNumberCertifyStateDesc(String qqNumberCertifyStateDesc) {

        qqNumberCertifyStateDesc = EnumHelperUtil.getEnumWrapDescByValue(CreditfileCertifyStateDesc.class,this.getQqNumberCertifyState());
        this.qqNumberCertifyStateDesc = qqNumberCertifyStateDesc;
    }
}