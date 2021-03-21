package vitily.com.service_adapter;

import vitily.com.api_entity.req_entity.mem.TqGetPhoneVerifyCode;
import vitily.com.other_entity.ResultBack;

public interface PhoneSMSService {
	ResultBack getPhoneVerifyCode(TqGetPhoneVerifyCode req)throws Exception;
}
