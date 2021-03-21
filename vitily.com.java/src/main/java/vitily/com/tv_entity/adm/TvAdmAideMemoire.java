package vitily.com.tv_entity.adm;


import vitily.com.consts.AideMemoireStateDesc;
import vitily.com.tb_entity.adm.TbAdmAideMemoire;
import vitily.com.util.EnumHelperUtil;

public class TvAdmAideMemoire extends TbAdmAideMemoire {
    private String labelNames;
    private String admUserName;

    public String getLabelNames() {
        return labelNames;
    }

    public void setLabelNames(String labelNames) {
        this.labelNames = labelNames;
    }

    public String getAdmUserName() {
        return admUserName;
    }

    public void setAdmUserName(String admUserName) {
        this.admUserName = admUserName;
    }
    @Override
    public String getStateDesc(){
        this.stateDesc = EnumHelperUtil.getEnumWrapDescByValue(AideMemoireStateDesc.class, this.getState());
        return this.stateDesc;
    }
}
