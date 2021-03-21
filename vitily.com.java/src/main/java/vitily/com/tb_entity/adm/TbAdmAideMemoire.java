package vitily.com.tb_entity.adm;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;
import vitily.base.tb_entity.BaseEntity;

import java.util.Date;

/**
 * 描述:备忘录表的实体类
 * @version
 * @author:  whh
 * @创建时间: 2018-05-21
 */
public class TbAdmAideMemoire extends BaseEntity {
    /**
     * 用户id
     */
    private Integer admUserId;

    /**
     * 备忘录标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 提醒时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date remindTime;

    /**
     * 选择的标签
     */
    private String labelIds;
    /**
     * 用户id
     * [whh]@return adm_user_id 用户id
     */
    public Integer getAdmUserId() {
        return admUserId;
    }

    /**
     * 用户id
     * @param admUserId 用户id
     */
    public void setAdmUserId(Integer admUserId) {
        this.admUserId = admUserId;
    }

    /**
     * 备忘录标题
     * [whh]@return title 备忘录标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 备忘录标题
     * @param title 备忘录标题
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
     * 提醒时间
     * [whh]@return remind_time 提醒时间
     */
    public Date getRemindTime() {
        return remindTime;
    }

    /**
     * 提醒时间
     * @param remindTime 提醒时间
     */
    public void setRemindTime(Date remindTime) {
        this.remindTime = remindTime;
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