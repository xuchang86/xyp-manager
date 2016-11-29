package com.rogrand.goods.domain;

import com.rogrand.core.annotation.FieldAnnotation;
import com.rogrand.core.domain.Base;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-30 <br/>
 * 描述：个人收货地址类
 */
public class UserAddress extends Base {

	private static final long serialVersionUID = 6425429861175695792L;

	@FieldAnnotation(comment = "主键", exp = false, imp = false, empty = true, len = 10, pk = true)
	private Long id;

	@FieldAnnotation(comment = "用户ID", exp = true, imp = true, empty = true, len = 10)
	private Long user_id;

	@FieldAnnotation(comment = "联系人", exp = true, imp = true, empty = true, len = 50)
	private String contracts;

	@FieldAnnotation(comment = "电话", exp = true, imp = true, empty = true, len = 50)
	private String phone;

	@FieldAnnotation(comment = "城市", exp = true, imp = true, empty = true, len = 50)
	private String city;

	@FieldAnnotation(comment = "详细地址", exp = true, imp = true, empty = true, len = 100)
	private String address;

	private String user_name;

	/**
	 * 个人收货地址对象构造函数
	 */
	public UserAddress() {
		super();
	}

	public UserAddress(String id) {
		this("id", id);
	}

	public UserAddress(String property, Object value) {
		this();
		init(property, value);
	}

	/**
	 * 获得主键
	 * 
	 * @return Long
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * 设置主键
	 * 
	 * @param id
	 *            主键
	 */
	public void setId(Long id) {
		putField("id");
		this.id = id;
	}

	/**
	 * 获得用户ID
	 * 
	 * @return Long
	 */
	public Long getUser_id() {
		return this.user_id;
	}

	/**
	 * 设置用户ID
	 * 
	 * @param user_id
	 *            用户ID
	 */
	public void setUser_id(Long user_id) {
		putField("user_id");
		this.user_id = user_id;
	}

	/**
	 * 获得联系人
	 * 
	 * @return String
	 */
	public String getContracts() {
		return this.contracts;
	}

	/**
	 * 设置联系人
	 * 
	 * @param contracts
	 *            联系人
	 */
	public void setContracts(String contracts) {
		putField("contracts");
		this.contracts = contracts;
	}

	/**
	 * 获得电话
	 * 
	 * @return String
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * 设置电话
	 * 
	 * @param phone
	 *            电话
	 */
	public void setPhone(String phone) {
		putField("phone");
		this.phone = phone;
	}

	/**
	 * 获得城市
	 * 
	 * @return String
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * 设置城市
	 * 
	 * @param city
	 *            城市
	 */
	public void setCity(String city) {
		putField("city");
		this.city = city;
	}

	/**
	 * 获得详细地址
	 * 
	 * @return String
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * 设置详细地址
	 * 
	 * @param address
	 *            详细地址
	 */
	public void setAddress(String address) {
		putField("address");
		this.address = address;
	}

	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * @param user_name
	 *            the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
}