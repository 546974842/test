package vitily.com.api_entity.req_entity.mem;

public class TqSetMemPersonalCertifyinfo extends TqMemBase {

    /**
     * 身份证号码
     */
    private String idNumber;

    /**
     * 淘宝号码
     */
    private String tbNumber;

    /**
     * 支付宝号码
     */
    private String zfbNumber;

    /**
     * 支付宝号码
     */
    private String bankcardNumber;

    /**
     * 微信号码
     */
    private String wxNumber;

    /**
     * qq号码
     */
    private String qqNumber;

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getTbNumber() {
        return tbNumber;
    }

    public void setTbNumber(String tbNumber) {
        this.tbNumber = tbNumber;
    }

    public String getZfbNumber() {
        return zfbNumber;
    }

    public void setZfbNumber(String zfbNumber) {
        this.zfbNumber = zfbNumber;
    }

    public String getBankcardNumber() {
        return bankcardNumber;
    }

    public void setBankcardNumber(String bankcardNumber) {
        this.bankcardNumber = bankcardNumber;
    }

    public String getWxNumber() {
        return wxNumber;
    }

    public void setWxNumber(String wxNumber) {
        this.wxNumber = wxNumber;
    }

    public String getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber;
    }
}
