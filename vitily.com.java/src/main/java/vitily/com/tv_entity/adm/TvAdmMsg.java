package vitily.com.tv_entity.adm;


import vitily.com.consts.MsgStateDesc;
import vitily.com.tb_entity.adm.TbAdmMsg;
import vitily.com.util.EnumHelperUtil;

public class TvAdmMsg extends TbAdmMsg {
    private String labelNames;
    private String typeName;
    private String toAdmUserName;
    private String fromAdmUserName;
    private String memName;
    private String memRealName;//真实姓名or公司名称

    public String getLabelNames() {
        return labelNames;
    }

    public void setLabelNames(String labelNames) {
        this.labelNames = labelNames;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getToAdmUserName() {
        return toAdmUserName;
    }

    public void setToAdmUserName(String toAdmUserName) {
        this.toAdmUserName = toAdmUserName;
    }

    public String getFromAdmUserName() {
        return fromAdmUserName;
    }

    public void setFromAdmUserName(String fromAdmUserName) {
        this.fromAdmUserName = fromAdmUserName;
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
    @Override
    public String getStateDesc(){
        this.stateDesc = EnumHelperUtil.getEnumWrapDescByValue(MsgStateDesc.class, this.getState());
        return this.stateDesc;
    }
}
