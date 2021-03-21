package vitily.com.tv_entity.mem;

import vitily.com.consts.CreditfileCertifyStateDesc;
import vitily.com.tb_entity.mem.TbMemCompanyCreditfile;
import vitily.com.util.EnumHelperUtil;

public class TvMemCompanyCreditfile extends TbMemCompanyCreditfile {
    private String businessLicenseCertifyStateDesc;
    private String registeredCapitalCertifyStateDesc;
    private String companyAssetsCertifyStateDesc;
    private String carCertifyStateDesc;
    private String estateCertifyStateDesc;
    private String stockFundCertifyStateDesc;
    private String otherInfoCertifyStateDesc;
    private String memName;
    private String memRealName;//公司名称

    public String getBusinessLicenseCertifyStateDesc() {
        businessLicenseCertifyStateDesc = EnumHelperUtil.getEnumWrapDescByValue(CreditfileCertifyStateDesc.class,this.getBusinessLicenseCertifyState());
        return businessLicenseCertifyStateDesc;
    }

    public String getRegisteredCapitalCertifyStateDesc() {
        registeredCapitalCertifyStateDesc = EnumHelperUtil.getEnumWrapDescByValue(CreditfileCertifyStateDesc.class,this.getRegisteredCapitalCertifyState());
        return registeredCapitalCertifyStateDesc;
    }

    public String getCompanyAssetsCertifyStateDesc() {
        companyAssetsCertifyStateDesc = EnumHelperUtil.getEnumWrapDescByValue(CreditfileCertifyStateDesc.class,this.getCompanyAssetsCertifyState());
        return companyAssetsCertifyStateDesc;
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
