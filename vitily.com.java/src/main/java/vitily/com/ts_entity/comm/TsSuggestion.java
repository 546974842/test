package vitily.com.ts_entity.comm;

import vitily.com.tb_entity.comm.TbSuggestion;
import vitily.base.ts_entity.BaseSearch;

public class TsSuggestion extends BaseSearch<TbSuggestion> {
	public TsSuggestion(){
		super(new TbSuggestion());
	}
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
