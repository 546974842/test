package vitily.com.tv_entity.mem;

import vitily.com.consts.CreditfileCertifyStateDesc;
import vitily.com.consts.EducationLevelDesc;
import vitily.com.tb_entity.mem.TbMemPersonalCreditfile;
import vitily.com.util.EnumHelperUtil;

public class TvMemPersonalCreditfile extends TbMemPersonalCreditfile {
    private String educationLevelDesc;
    private String educationCertifyStateDesc;
    private String jobsCertifyStateDesc;
    private String driverLicenseCertifyStateDesc;
    private String carCertifyStateDesc;
    private String estateCertifyStateDesc;
    private String stockFundCertifyStateDesc;
    private String otherInfoCertifyStateDesc;
    private String memName;
    private String memRealName;//真实姓名

    public String getEducationLevelDesc() {
        educationLevelDesc = EnumHelperUtil.getEnumWrapDescByValue(EducationLevelDesc.class,this.getEducationLevel());
        return educationLevelDesc;
    }

    public String getEducationCertifyStateDesc() {
        educationCertifyStateDesc = EnumHelperUtil.getEnumWrapDescByValue(CreditfileCertifyStateDesc.class,this.getEducationCertifyState());
        return educationCertifyStateDesc;
    }

    public String getJobsCertifyStateDesc() {
        jobsCertifyStateDesc = EnumHelperUtil.getEnumWrapDescByValue(CreditfileCertifyStateDesc.class,this.getJobsCertifyState());
        return jobsCertifyStateDesc;
    }

    public String getDriverLicenseCertifyStateDesc() {
        driverLicenseCertifyStateDesc = EnumHelperUtil.getEnumWrapDescByValue(CreditfileCertifyStateDesc.class,this.getDriverLicenseCertifyState());
        return driverLicenseCertifyStateDesc;
    }

    public String getCarCertifyStateDesc() {
        carCertifyStateDesc = EnumHelperUtil.getEnumWrapDescByValue(CreditfileCertifyStateDesc.class,this.getCarCertifyState());
        return carCertifyStateDesc;
    }

    public String getEstateCertifyStateDesc() {
        estateCertifyStateDesc = EnumHelperUtil.getEnumWrapDescByValue(CreditfileCertifyStateDesc.class,this.getEstateCertifyState());
        return estateCertifyStateDesc;
    }

    public String getStockFundCertifyStateDesc() {
        stockFundCertifyStateDesc = EnumHelperUtil.getEnumWrapDescByValue(CreditfileCertifyStateDesc.class,this.getStockFundCertifyState());
        return stockFundCertifyStateDesc;
    }

    public String getOtherInfoCertifyStateDesc() {
        otherInfoCertifyStateDesc = EnumHelperUtil.getEnumWrapDescByValue(CreditfileCertifyStateDesc.class,this.getOtherInfoCertifyState());
        return otherInfoCertifyStateDesc;
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
}
