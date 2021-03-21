package vitily.com.tv_entity.mem;

import vitily.com.tb_entity.mem.TbModelInfo;

/**
 * @version
 * @author:  lether
 * @创建时间: 2017-07-21
 */
public class TvModelInfo  extends TbModelInfo {
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	  /**
     * 会员
     */
    private Integer memberId;
    
    /**
     * 会员
     */
    private Integer orderId;
    
    
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
    
    
}