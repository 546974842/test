package vitily.com.tv_entity.comm;


import vitily.com.consts.TaskLogTypeDesc;
import vitily.com.tb_entity.comm.TbTaskLog;
import vitily.com.util.CommonUtil;
import vitily.com.util.EnumHelperUtil;

public class TvTaskLog extends TbTaskLog {
	private String typeDesc;

	public String getTypeDesc() {
		if(CommonUtil.isNull(typeDesc)){
			this.typeDesc = EnumHelperUtil.getEnumWrapDescByValue(TaskLogTypeDesc.class,this.getType());
		}
		return typeDesc;
	}


}
