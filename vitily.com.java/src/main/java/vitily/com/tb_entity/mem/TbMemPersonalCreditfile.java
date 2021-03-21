package vitily.com.tb_entity.mem;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_mem_personal_creditfile表的实体类
 * @version
 * @author:  whh
 * @创建时间: 2018-03-06
 */
public class TbMemPersonalCreditfile extends BaseEntity {
    /**
     * 会员Id
     */
    private Integer memberId;

    /**
     * 最高学历（教育程度）
     */
    private Integer educationLevel;

    /**
     * 毕业院校
     */
    private String graduatedSchool;

    /**
     * 教育认证信息url
     */
    private String educationCertifyUrls;

    /**
     * 教育认证结果(未验证:0,申请验证中:2,验证通过:1,验证无效:-1,重新申请:3)
     */
    private Integer educationCertifyState;

    /**
     * 专业信息
     */
    private String disciplineInfo;

    /**
     * 工作年限
     */
    private Integer jobsYears;

    /**
     * 技术职称
     */
    private String technicalTitles;

    /**
     * 工作信息urls
     */
    private String jobsCertifyUrls;

    /**
     * 工作验证状态
     */
    private Integer jobsCertifyState;

    /**
     * 工作信息
     */
    private String jobsInfo;

    /**
     * 驾照信息
     */
    private String driverLicense;

    /**
     * 驾照信息urls
     */
    private String driverLicenseCertifyUrls;

    /**
     * 驾照验证状态
     */
    private Integer driverLicenseCertifyState;

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
     * 最高学历（教育程度）
     * [whh]@return education_level 最高学历（教育程度）
     */
    public Integer getEducationLevel() {
        return educationLevel;
    }

    /**
     * 最高学历（教育程度）
     * @param educationLevel 最高学历（教育程度）
     */
    public void setEducationLevel(Integer educationLevel) {
        this.educationLevel = educationLevel;
    }

    /**
     * 毕业院校
     * [whh]@return graduated_school 毕业院校
     */
    public String getGraduatedSchool() {
        return graduatedSchool;
    }

    /**
     * 毕业院校
     * @param graduatedSchool 毕业院校
     */
    public void setGraduatedSchool(String graduatedSchool) {
        this.graduatedSchool = graduatedSchool;
    }

    /**
     * 教育认证信息url
     * [whh]@return education_certify_urls 教育认证信息url
     */
    public String getEducationCertifyUrls() {
        return educationCertifyUrls;
    }

    /**
     * 教育认证信息url
     * @param educationCertifyUrls 教育认证信息url
     */
    public void setEducationCertifyUrls(String educationCertifyUrls) {
        this.educationCertifyUrls = educationCertifyUrls;
    }

    /**
     * 教育认证结果(未验证:0,申请验证中:2,验证通过:1,验证无效:-1,重新申请:3)
     * [whh]@return education_certify_state 教育认证结果(未验证:0,申请验证中:2,验证通过:1,验证无效:-1,重新申请:3)
     */
    public Integer getEducationCertifyState() {
        return educationCertifyState;
    }

    /**
     * 教育认证结果(未验证:0,申请验证中:2,验证通过:1,验证无效:-1,重新申请:3)
     * @param educationCertifyState 教育认证结果(未验证:0,申请验证中:2,验证通过:1,验证无效:-1,重新申请:3)
     */
    public void setEducationCertifyState(Integer educationCertifyState) {
        this.educationCertifyState = educationCertifyState;
    }

    /**
     * 专业信息
     * [whh]@return discipline_info 专业信息
     */
    public String getDisciplineInfo() {
        return disciplineInfo;
    }

    /**
     * 专业信息
     * @param disciplineInfo 专业信息
     */
    public void setDisciplineInfo(String disciplineInfo) {
        this.disciplineInfo = disciplineInfo;
    }

    /**
     * 工作年限
     * [whh]@return jobs_years 工作年限
     */
    public Integer getJobsYears() {
        return jobsYears;
    }

    /**
     * 工作年限
     * @param jobsYears 工作年限
     */
    public void setJobsYears(Integer jobsYears) {
        this.jobsYears = jobsYears;
    }

    /**
     * 技术职称
     * [whh]@return technical_titles 技术职称
     */
    public String getTechnicalTitles() {
        return technicalTitles;
    }

    /**
     * 技术职称
     * @param technicalTitles 技术职称
     */
    public void setTechnicalTitles(String technicalTitles) {
        this.technicalTitles = technicalTitles;
    }

    /**
     * 工作信息urls
     * [whh]@return jobs_certify_urls 工作信息urls
     */
    public String getJobsCertifyUrls() {
        return jobsCertifyUrls;
    }

    /**
     * 工作信息urls
     * @param jobsCertifyUrls 工作信息urls
     */
    public void setJobsCertifyUrls(String jobsCertifyUrls) {
        this.jobsCertifyUrls = jobsCertifyUrls;
    }

    /**
     * 工作验证状态
     * [whh]@return jobs_certify_state 工作验证状态
     */
    public Integer getJobsCertifyState() {
        return jobsCertifyState;
    }

    /**
     * 工作验证状态
     * @param jobsCertifyState 工作验证状态
     */
    public void setJobsCertifyState(Integer jobsCertifyState) {
        this.jobsCertifyState = jobsCertifyState;
    }

    /**
     * 工作信息
     * [whh]@return jobs_info 工作信息
     */
    public String getJobsInfo() {
        return jobsInfo;
    }

    /**
     * 工作信息
     * @param jobsInfo 工作信息
     */
    public void setJobsInfo(String jobsInfo) {
        this.jobsInfo = jobsInfo;
    }

    /**
     * 驾照信息
     * [whh]@return driver_license 驾照信息
     */
    public String getDriverLicense() {
        return driverLicense;
    }

    /**
     * 驾照信息
     * @param driverLicense 驾照信息
     */
    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    /**
     * 驾照信息urls
     * [whh]@return driver_license_certify_urls 驾照信息urls
     */
    public String getDriverLicenseCertifyUrls() {
        return driverLicenseCertifyUrls;
    }

    /**
     * 驾照信息urls
     * @param driverLicenseCertifyUrls 驾照信息urls
     */
    public void setDriverLicenseCertifyUrls(String driverLicenseCertifyUrls) {
        this.driverLicenseCertifyUrls = driverLicenseCertifyUrls;
    }

    /**
     * 驾照验证状态
     * [whh]@return driver_license_certify_state 驾照验证状态
     */
    public Integer getDriverLicenseCertifyState() {
        return driverLicenseCertifyState;
    }

    /**
     * 驾照验证状态
     * @param driverLicenseCertifyState 驾照验证状态
     */
    public void setDriverLicenseCertifyState(Integer driverLicenseCertifyState) {
        this.driverLicenseCertifyState = driverLicenseCertifyState;
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