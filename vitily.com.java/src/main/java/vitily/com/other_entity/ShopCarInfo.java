package vitily.com.other_entity;

import java.io.Serializable;

/**
 * 购物车请求实体：cookie保存的项目
 * @author lether
 *
 */
public class ShopCarInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long specParId;
	private Long proId;
	private int proNumber;
	public Long getSpecParId() {
		return specParId;
	}
	public void setSpecParId(Long specParId) {
		this.specParId = specParId;
	}
	public Long getProId() {
		return proId;
	}
	public void setProId(Long proId) {
		this.proId = proId;
	}
	public int getProNumber() {
		return proNumber;
	}
	public void setProNumber(int proNumber) {
		this.proNumber = proNumber;
	}
	
}
