package vitily.com.tb_entity.comm;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_task_log表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-19
 */
public class TbTaskLog extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 操作时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    /**
     * 定时任务类型
     */
    private Integer type;

    /**
     * 描述
     */
    private String description;

    /**
     * 操作时间
     * [whh]@return time 操作时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 操作时间
     * @param time 操作时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 定时任务类型
     * [whh]@return type 定时任务类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 定时任务类型
     * @param type 定时任务类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 描述
     * [whh]@return description 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }
}