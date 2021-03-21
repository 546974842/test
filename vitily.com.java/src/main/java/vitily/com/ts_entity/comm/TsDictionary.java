package vitily.com.ts_entity.comm;

import vitily.com.tb_entity.comm.TbDictionary;
import vitily.base.ts_entity.BaseSearch;
import vitily.com.util.CommonUtil;

public class TsDictionary extends BaseSearch<TbDictionary> {
	public TsDictionary(){
		super(new TbDictionary());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * key 模糊搜索
	 */
	private String selKey;
	
	/**
	 * value 模糊搜索
	 */
	private String selValue;
	
	/**
	 * 类型idstr：如(1,2,...x)
	 */
	private String typeIdStr;

	public String getSelKey() {
		return selKey;
	}

	public void setSelKey(String selKey) {
		this.selKey = selKey;
	}

	public String getSelValue() {
		return selValue;
	}

	public void setSelValue(String selValue) {
		this.selValue = selValue;
	}

	public String getTypeIdStr() {
		return typeIdStr;
	}

	public void setTypeIdStr(String typeIdStr) {
		if(CommonUtil.isNumOrD(typeIdStr)){
			this.typeIdStr = typeIdStr;
		}
	}

}
