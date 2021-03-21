package vitily.com.tv_entity.show;

import vitily.com.consts.*;
import vitily.com.tb_entity.show.TbShowBase;
import vitily.com.tb_entity.show.TbShowTime;
import vitily.com.util.EnumHelperUtil;

public class TvShowBase extends TbShowBase {
    private String memName;
    private String memRealName;//真实姓名or公司名称
    private String platformDesc;
    private String experiTypeDesc;
    private String modelGenderDesc;
    private TbShowTime showTime;
    private String experiWayDesc;
    private String stayTimeDesc;

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
        this.stateDesc = EnumHelperUtil.getEnumWrapDescByValue(ShowStateDesc.class, this.getState());
        return this.stateDesc;
    }

    public String getPlatformDesc() {
        platformDesc = EnumHelperUtil.getEnumWrapDescByValue(ShowPlatformDesc.class,this.getPlatform());
        return platformDesc;
    }

    public String getExperiTypeDesc() {
        experiTypeDesc = EnumHelperUtil.getEnumWrapDescByValue(ShowExperiTypeDesc.class,this.getExperiType());
        return experiTypeDesc;
    }

    public String getModelGenderDesc() {
        modelGenderDesc = EnumHelperUtil.getEnumWrapDescByValue(GenderDesc.class,this.getModelGender());
        return modelGenderDesc;
    }

    public TbShowTime getShowTime() {
        return showTime;
    }

    public void setShowTime(TbShowTime showTime) {
        this.showTime = showTime;
    }

    public String getExperiWayDesc() {
        experiWayDesc = EnumHelperUtil.getEnumWrapDescByValue(ShowExperiWayDesc.class,this.getExperiWay());
        return experiWayDesc;
    }

    public String getStayTimeDesc() {
        stayTimeDesc = EnumHelperUtil.getEnumWrapDescByValue(ShowStateTimeDesc.class,this.getExperiWay());
        return stayTimeDesc;
    }
}
