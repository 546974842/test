package vitily.com.other_entity;

import vitily.com.consts.ResultStatus;

/**
 * 记录不存在
 * @author lether
 *
 */
public class NoExistsException extends CustomerException {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 通过捕捉该异常返回json数据
	 * @param result 1
	 */
	public NoExistsException(){
		this(ResultStatus.查询不存在.getDesc());
	}
	/**
	 * 通过捕捉该异常返回json数据
	 * @param message
	 */
	public NoExistsException(String message){
		super(message,ResultStatus.查询不存在);
	}
}
