package vitily.com.api_entity.req_entity.other;

import vitily.base.ts_entity.TqBase;
import vitily.com.annotation.IntegerRangeValidator;
import vitily.com.annotation.RequireValidator;

/**
 * 获取验证码
 */
public class TqVerify extends TqBase {
	/**
	 * 业务类型
	 */
	@RequireValidator
	@IntegerRangeValidator(min = 0,max = 100)
	private Integer businessType;

	public Integer getBusinessType() {
		return businessType;
	}

	public void setBusinessType(Integer businessType) {
		this.businessType = businessType;
	}
}
