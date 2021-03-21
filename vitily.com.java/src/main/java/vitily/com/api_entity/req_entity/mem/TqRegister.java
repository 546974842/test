package vitily.com.api_entity.req_entity.mem;

import vitily.base.ts_entity.TqBase;
import vitily.com.tv_entity.mem.TvMemBase;

/**
 * 注册请求实体
 * @author lether
 *
 */
public class TqRegister extends TqBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TvMemBase entity;
	/**
	 * 验证码
	 */
	String valifyCode;
	public TvMemBase getEntity() {
		return entity;
	}
	public void setEntity(TvMemBase entity) {
		this.entity = entity;
	}
	public String getValifyCode() {
		return valifyCode;
	}
	public void setValifyCode(String valifyCode) {
		this.valifyCode = valifyCode;
	}
	
}
