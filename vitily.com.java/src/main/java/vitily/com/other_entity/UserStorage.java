package vitily.com.other_entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 存储的用户信息
 * @author lether
 *
 */
public class UserStorage implements Serializable{
	/*
	 * 	用户id
	 */
	private int id;
	/**
	 * 用户名称：登录名
	 */
	private String name;
	/**
	 * 显示名称:
	 */
	private String showName;
	
	/**
	 * 临时token
	 * 加密token md5（salt＋id＋token）
	 */
	private String authToken;
	
	/**
	 * 权限字符窜列表：id权限方式
	 */
	private String permissonStr;
	
	/**
	 * 权限窜:其他列表形式
	 */
	private List<String> permisionList = new ArrayList <>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getPermissonStr() {
		return permissonStr;
	}

	public void setPermissonStr(String permissonStr) {
		this.permissonStr = permissonStr;
	}

	public List<String> getPermisionList() {
		return permisionList;
	}

	public void setPermisionList(List<String> permisionList) {
		this.permisionList = permisionList;
	}
	
}
