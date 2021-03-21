package vitily.com.tb_entity.adm;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:管理员消息表的实体类
 * @version
 * @author:  whh
 * @创建时间: 2018-05-21
 */
public class TbAdmMsg extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 类型ID
     */
    private Integer typeId;

    /**
     * 所属用户id
     */
    private Integer toAdmUserId;

    /**
     * 发送的用户id
     */
    private Integer fromAdmUserId;

    /**
     * 发送的会员id
     */
    private Integer fromMemberId;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 选择的标签
     */
    private String labelIds;
    /**
     * 类型ID
     * [whh]@return type_id 类型ID
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * 类型ID
     * @param typeId 类型ID
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * 所属用户id
     * [whh]@return to_adm_user_id 所属用户id
     */
    public Integer getToAdmUserId() {
        return toAdmUserId;
    }

    /**
     * 所属用户id
     * @param toAdmUserId 所属用户id
     */
    public void setToAdmUserId(Integer toAdmUserId) {
        this.toAdmUserId = toAdmUserId;
    }

    /**
     * 发送的用户id
     * [whh]@return from_adm_user_id 发送的用户id
     */
    public Integer getFromAdmUserId() {
        return fromAdmUserId;
    }

    /**
     * 发送的用户id
     * @param fromAdmUserId 发送的用户id
     */
    public void setFromAdmUserId(Integer fromAdmUserId) {
        this.fromAdmUserId = fromAdmUserId;
    }

    /**
     * 发送的会员id
     * [whh]@return from_member_id 发送的会员id
     */
    public Integer getFromMemberId() {
        return fromMemberId;
    }

    /**
     * 发送的会员id
     * @param fromMemberId 发送的会员id
     */
    public void setFromMemberId(Integer fromMemberId) {
        this.fromMemberId = fromMemberId;
    }

    /**
     * 标题
     * [whh]@return title 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 内容
     * [whh]@return content 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 选择的标签
     * [whh]@return label_ids 选择的标签
     */
    public String getLabelIds() {
        return labelIds;
    }

    /**
     * 选择的标签
     * @param labelIds 选择的标签
     */
    public void setLabelIds(String labelIds) {
        this.labelIds = labelIds;
    }
}