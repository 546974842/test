package vitily.com.api_entity.req_entity.other;

import java.util.HashMap;
import java.util.Map;

import vitily.com.consts.ApiNotifyTypeDesc;
import vitily.base.ts_entity.TqBase;

/**
 * 通知
 * @author lether
 *
 */
public class TqApiNotify extends TqBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApiNotifyTypeDesc apiNotifyType;
	private Map<String, String> dicmap = new HashMap<>();
	public ApiNotifyTypeDesc getApiNotifyType() {
		return apiNotifyType;
	}
	public void setApiNotifyType(ApiNotifyTypeDesc apiNotifyType) {
		this.apiNotifyType = apiNotifyType;
	}
	public Map<String, String> getDicmap() {
		return dicmap;
	}
	public void setDicmap(Map<String, String> dicmap) {
		this.dicmap = dicmap;
	}
}
