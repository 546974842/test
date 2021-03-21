package vitily.com.tv_entity.order;

import vitily.com.consts.OrderOperaTypeDesc;
import vitily.com.tb_entity.order.TbOrderOperaRecord;
import vitily.com.util.CommonUtil;
import vitily.com.util.EnumHelperUtil;

public class TvOrderOperaRecord extends TbOrderOperaRecord {
    private String memName;
    private String memRealName;//真实姓名or公司名称
    private String admUserName;
    private String orderNo;//订单编号
    private String typeDesc;

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTypeDesc() {
        if(CommonUtil.isNull(typeDesc)){
            typeDesc = EnumHelperUtil.getEnumWrapDescByValue(OrderOperaTypeDesc.class,this.getType());
        }
        return typeDesc;
    }
}
