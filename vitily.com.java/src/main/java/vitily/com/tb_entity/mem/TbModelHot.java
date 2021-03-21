package vitily.com.tb_entity.mem;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

import vitily.base.tb_entity.BaseEntity;
/**
 * 描述:tb_mem_model_hot模特热度表
 * @version
 * @author:  lether
 * @创建时间: 2017-07-21
 */
public class TbModelHot  extends BaseEntity {
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 自增id
     */
    private Integer id;
    /**
     * 模特id
     */
    private Integer modeId;

    /**
     * 会员
     */
    private Integer memberId;
    
    /**
     * 类型
     */
    private String type;
    
    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;    
    
    
    
    
	public Integer getModeId() {
		return modeId;
	}
	public void setModeId(Integer modeId) {
		this.modeId = modeId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
    
    
	
}