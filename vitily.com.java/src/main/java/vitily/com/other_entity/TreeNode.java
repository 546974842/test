package vitily.com.other_entity;

import java.util.List;

/**
 * 树
 * @author lether
 *
 */
public class TreeNode {

	/**
	 * 当前节点文本
	 */
	private String text;
	/**
	 * 当前节点值
	 */
	private String value;
	/**
	 * 文本链接
	 */
	private String navigateUrl;
	/**
	 * 文本提示
	 */
	private String toolTip;
	/**
	 * 是否展开
	 */
	private boolean expand=true;
	/**
	 * 是否选中
	 */
	private boolean checked;
	/**
	 * 是否显示checkbox
	 */
	private boolean showCheckBox=true;
	/**
	 * 事件
	 */
	private String evt;
	/**
	 * 子节点
	 */
	private List<TreeNode> children;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getNavigateUrl() {
		return navigateUrl;
	}
	public void setNavigateUrl(String navigateUrl) {
		this.navigateUrl = navigateUrl;
	}
	public String getToolTip() {
		return toolTip;
	}
	public void setToolTip(String toolTip) {
		this.toolTip = toolTip;
	}
	public boolean isExpand() {
		return expand;
	}
	public void setExpand(boolean expand) {
		this.expand = expand;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	public boolean isShowCheckBox() {
		return showCheckBox;
	}
	public void setShowCheckBox(boolean showCheckBox) {
		this.showCheckBox = showCheckBox;
	}
	
	public String getEvt() {
		return evt;
	}
	public void setEvt(String evt) {
		this.evt = evt;
	}
	public List<TreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
	
}
