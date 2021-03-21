package vitily.com.tb_entity.comm;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_image_sams表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-19
 */
public class TbImageModel extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 图片地址(小)
	 */
	private Integer memberId;

    /**
     * 图片地址(小)
     */
    private String url;

    /**
     * 图片名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;


    /**
     * 图片名称
     * [whh]@return name 图片名称
     */
    public String getName() {
        return name;
    }

    /**
     * 图片名称
     * @param name 图片名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 描述
     * [whh]@return description 描述
     */
    public String getDescription() {
        return description;
    }
    

    public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/**
     * 描述
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
    
    
}