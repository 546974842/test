package vitily.com.tb_entity.mem;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_mem_company_creditfile表的实体类
 * @version
 * @author:  whh
 * @创建时间: 2018-02-24
 */
public class TbMemCompanyCreditfile extends BaseEntity {
    /**
     * 会员Id
     */
    private Integer memberId;
    /**
     * 营业执照
     */
    private String businessLicense;

    /**
     * 营业执照urls
     */
    private String businessLicenseUrls;

    /**
     * 营业执照验证状态
     */
    private Integer businessLicenseCertifyState;

    /**
     * 注册资本信息
     */
    private String registeredCapital;

    /**
     * 注册资本urls
     */
    private String registeredCapitalUrls;

    /**
     * 注册资本验证状态
     */
    private Integer registeredCapitalCertifyState;

    /**
     * 车辆信息,多辆以,分隔
     */
    private String carInfo;

    /**
     * 车辆验证urls
     */
    private String carCertifyUrls;

    /**
     * 车辆验证状态(判断是否有车依据)
     */
    private Integer carCertifyState;

    /**
     * 房产证信息,多套以,分隔
     */
    private String estateInfo;

    /**
     * 房产验证urls
     */
    private String estateCertifyUrls;

    /**
     * 房产验证状态
     */
    private Integer estateCertifyState;

    /**
     * 股票基金信息
     */
    private String stockFund;

    /**
     * 股票基金url
     */
    private String stockFundCertifyUrls;

    /**
     * 股票基金验证状态
     */
    private Integer stockFundCertifyState;

    /**
     * 公司资产信息
     */
    private String companyAssets;

    /**
     * 公司资产信息urls
     */
    private String companyAssetsUrls;

    /**
     * 公司资产验证状态
     */
    private Integer companyAssetsCertifyState;

    /**
     * 其他信用信息
     */
    private String otherInfo;

    /**
     * 其他信息url
     */
    private String otherInfoCertifyUrls;

    /**
     * 其他信息验证状态
     */
    private Integer otherInfoCertifyState;

    /**
     * 信用积分
     */
    private Integer creditPoints;

    /**
     * 会员Id
     * [whh]@return member_id 会员Id
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 会员Id
     * @param memberId 会员Id
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
    /**
     * 营业执照
     * [whh]@return business_license 营业执照
     */
    public String getBusinessLicense() {
        return businessLicense;
    }

    /**
     * 营业执照
     * @param businessLicense 营业执照
     */
    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    /**
     * 营业执照urls
     * [whh]@return business_license_urls 营业执照urls
     */
    public String getBusinessLicenseUrls() {
        return businessLicenseUrls;
    }

    /**
     * 营业执照urls
     * @param businessLicenseUrls 营业执照urls
     */
    public void setBusinessLicenseUrls(String businessLicenseUrls) {
        this.businessLicenseUrls = businessLicenseUrls;
    }

    /**
     * 营业执照验证状态
     * [whh]@return business_license_certify_state 营业执照验证状态
     */
    public Integer getBusinessLicenseCertifyState() {
        return businessLicenseCertifyState;
    }

    /**
     * 营业执照验证状态
     * @param businessLicenseCertifyState 营业执照验证状态
     */
    public void setBusinessLicenseCertifyState(Integer businessLicenseCertifyState) {
        this.businessLicenseCertifyState = businessLicenseCertifyState;
    }

    /**
     * 注册资本信息
     * [whh]@return registered_capital 注册资本信息
     */
    public String getRegisteredCapital() {
        return registeredCapital;
    }

    /**
     * 注册资本信息
     * @param registeredCapital 注册资本信息
     */
    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    /**
     * 注册资本urls
     * [whh]@return registered_capital_urls 注册资本urls
     */
    public String getRegisteredCapitalUrls() {
        return registeredCapitalUrls;
    }

    /**
     * 注册资本urls
     * @param registeredCapitalUrls 注册资本urls
     */
    public void setRegisteredCapitalUrls(String registeredCapitalUrls) {
        this.registeredCapitalUrls = registeredCapitalUrls;
    }

    /**
     * 注册资本验证状态
     * [whh]@return registered_capital_certify_state 注册资本验证状态
     */
    public Integer getRegisteredCapitalCertifyState() {
        return registeredCapitalCertifyState;
    }

    /**
     * 注册资本验证状态
     * @param registeredCapitalCertifyState 注册资本验证状态
     */
    public void setRegisteredCapitalCertifyState(Integer registeredCapitalCertifyState) {
        this.registeredCapitalCertifyState = registeredCapitalCertifyState;
    }

    /**
     * 车辆信息,多辆以,分隔
     * [whh]@return car_info 车辆信息,多辆以,分隔
     */
    public String getCarInfo() {
        return carInfo;
    }

    /**
     * 车辆信息,多辆以,分隔
     * @param carInfo 车辆信息,多辆以,分隔
     */
    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    /**
     * 车辆验证urls
     * [whh]@return car_certify_urls 车辆验证urls
     */
    public String getCarCertifyUrls() {
        return carCertifyUrls;
    }

    /**
     * 车辆验证urls
     * @param carCertifyUrls 车辆验证urls
     */
    public void setCarCertifyUrls(String carCertifyUrls) {
        this.carCertifyUrls = carCertifyUrls;
    }

    /**
     * 车辆验证状态(判断是否有车依据)
     * [whh]@return car_certify_state 车辆验证状态(判断是否有车依据)
     */
    public Integer getCarCertifyState() {
        return carCertifyState;
    }

    /**
     * 车辆验证状态(判断是否有车依据)
     * @param carCertifyState 车辆验证状态(判断是否有车依据)
     */
    public void setCarCertifyState(Integer carCertifyState) {
        this.carCertifyState = carCertifyState;
    }

    /**
     * 房产证信息,多套以,分隔
     * [whh]@return estate_info 房产证信息,多套以,分隔
     */
    public String getEstateInfo() {
        return estateInfo;
    }

    /**
     * 房产证信息,多套以,分隔
     * @param estateInfo 房产证信息,多套以,分隔
     */
    public void setEstateInfo(String estateInfo) {
        this.estateInfo = estateInfo;
    }

    /**
     * 房产验证urls
     * [whh]@return estate_certify_urls 房产验证urls
     */
    public String getEstateCertifyUrls() {
        return estateCertifyUrls;
    }

    /**
     * 房产验证urls
     * @param estateCertifyUrls 房产验证urls
     */
    public void setEstateCertifyUrls(String estateCertifyUrls) {
        this.estateCertifyUrls = estateCertifyUrls;
    }

    /**
     * 房产验证状态
     * [whh]@return estate_certify_state 房产验证状态
     */
    public Integer getEstateCertifyState() {
        return estateCertifyState;
    }

    /**
     * 房产验证状态
     * @param estateCertifyState 房产验证状态
     */
    public void setEstateCertifyState(Integer estateCertifyState) {
        this.estateCertifyState = estateCertifyState;
    }

    /**
     * 股票基金信息
     * [whh]@return stock_fund 股票基金信息
     */
    public String getStockFund() {
        return stockFund;
    }

    /**
     * 股票基金信息
     * @param stockFund 股票基金信息
     */
    public void setStockFund(String stockFund) {
        this.stockFund = stockFund;
    }

    /**
     * 股票基金url
     * [whh]@return stock_fund_certify_urls 股票基金url
     */
    public String getStockFundCertifyUrls() {
        return stockFundCertifyUrls;
    }

    /**
     * 股票基金url
     * @param stockFundCertifyUrls 股票基金url
     */
    public void setStockFundCertifyUrls(String stockFundCertifyUrls) {
        this.stockFundCertifyUrls = stockFundCertifyUrls;
    }

    /**
     * 股票基金验证状态
     * [whh]@return stock_fund_certify_state 股票基金验证状态
     */
    public Integer getStockFundCertifyState() {
        return stockFundCertifyState;
    }

    /**
     * 股票基金验证状态
     * @param stockFundCertifyState 股票基金验证状态
     */
    public void setStockFundCertifyState(Integer stockFundCertifyState) {
        this.stockFundCertifyState = stockFundCertifyState;
    }

    /**
     * 公司资产信息
     * [whh]@return company_assets 公司资产信息
     */
    public String getCompanyAssets() {
        return companyAssets;
    }

    /**
     * 公司资产信息
     * @param companyAssets 公司资产信息
     */
    public void setCompanyAssets(String companyAssets) {
        this.companyAssets = companyAssets;
    }

    /**
     * 公司资产信息urls
     * [whh]@return company_assets_urls 公司资产信息urls
     */
    public String getCompanyAssetsUrls() {
        return companyAssetsUrls;
    }

    /**
     * 公司资产信息urls
     * @param companyAssetsUrls 公司资产信息urls
     */
    public void setCompanyAssetsUrls(String companyAssetsUrls) {
        this.companyAssetsUrls = companyAssetsUrls;
    }

    /**
     * 公司资产验证状态
     * [whh]@return company_assets_certify_state 公司资产验证状态
     */
    public Integer getCompanyAssetsCertifyState() {
        return companyAssetsCertifyState;
    }

    /**
     * 公司资产验证状态
     * @param companyAssetsCertifyState 公司资产验证状态
     */
    public void setCompanyAssetsCertifyState(Integer companyAssetsCertifyState) {
        this.companyAssetsCertifyState = companyAssetsCertifyState;
    }

    /**
     * 其他信用信息
     * [whh]@return other_info 其他信用信息
     */
    public String getOtherInfo() {
        return otherInfo;
    }

    /**
     * 其他信用信息
     * @param otherInfo 其他信用信息
     */
    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    /**
     * 其他信息url
     * [whh]@return other_info_certify_urls 其他信息url
     */
    public String getOtherInfoCertifyUrls() {
        return otherInfoCertifyUrls;
    }

    /**
     * 其他信息url
     * @param otherInfoCertifyUrls 其他信息url
     */
    public void setOtherInfoCertifyUrls(String otherInfoCertifyUrls) {
        this.otherInfoCertifyUrls = otherInfoCertifyUrls;
    }

    /**
     * 其他信息验证状态
     * [whh]@return other_info_certify_state 其他信息验证状态
     */
    public Integer getOtherInfoCertifyState() {
        return otherInfoCertifyState;
    }

    /**
     * 其他信息验证状态
     * @param otherInfoCertifyState 其他信息验证状态
     */
    public void setOtherInfoCertifyState(Integer otherInfoCertifyState) {
        this.otherInfoCertifyState = otherInfoCertifyState;
    }

    /**
     * 信用积分
     * [whh]@return credit_points 信用积分
     */
    public Integer getCreditPoints() {
        return creditPoints;
    }

    /**
     * 信用积分
     * @param creditPoints 信用积分
     */
    public void setCreditPoints(Integer creditPoints) {
        this.creditPoints = creditPoints;
    }
}