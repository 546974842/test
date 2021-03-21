package vitily.com.other_entity;

import vitily.com.consts.ResultStatus;

import com.alibaba.fastjson.JSON;

/**
 * 自定义异常
 * @author lether
 *
 */
public class CustomerException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ResultBack result;
	public CustomerException(ResultBack rb){
		super(rb.getMessage());
		this.setResult(rb);
	}
	public CustomerException(ResultStatus status){
		this( new ResultBack(status,null));
	}
	/**
	 * 通过捕捉该异常返回json数据
	 * @param message 1
	 * @param status 2
	 */
	public CustomerException(String message,ResultStatus status){
		this(new ResultBack(status,message,null));
	}
	@Override
	public String getMessage(){
		return JSON.toJSONString(this.getResult());
	}
	
	public ResultBack getResult() {
		return result;
	}

	public void setResult(ResultBack result) {
		this.result = result;
	}
}
