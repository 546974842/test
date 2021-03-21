package vitily.com.tb_entity.comm;

import vitily.base.tb_entity.BaseEntity;
import vitily.com.consts.FeedbackStateDesc;
import vitily.com.util.CommonUtil;
import vitily.com.util.EnumHelperUtil;

/**
* @ClassName: TbSuggestion
* @Description: 描述:tb_comm_suggestion用户反馈意见表的实体类
* @author lhy
* @date 2018年8月8日
 */
public class TbSuggestion extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 会员id
     */
    private Integer memberId;

    /**
     * 后台用户id
     */
    private Integer adminId;

    /**
     * 反馈消息
     */
    private String msg;

    /**
     * 回复内容
     */
    private String backMsg;

    /**
     * 查看状态
     */
    private Integer viewState;

    /**
     * 查看状态
     */
	private String viewStateDesc;

	public String getViewStateDesc() {
      if(CommonUtil.isNull(viewStateDesc)){
			this.viewStateDesc = EnumHelperUtil.getEnumWrapDescByValue(FeedbackStateDesc.class,this.getViewState());
		}
      
	  return viewStateDesc;
	}
	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getBackMsg() {
		return backMsg;
	}

	public void setBackMsg(String backMsg) {
		this.backMsg = backMsg;
	}

	public Integer getViewState() {
		return viewState;
	}

	public void setViewState(Integer viewState) {
		this.viewState = viewState;
	}


}