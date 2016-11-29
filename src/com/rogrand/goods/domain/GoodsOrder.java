package com.rogrand.goods.domain;

import com.rogrand.core.annotation.FieldAnnotation;
import com.rogrand.core.domain.Base;

import java.util.Date;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：商品订单类
 */
public class GoodsOrder extends Base {

	private static final long serialVersionUID = 1696927755643420762L;

	@FieldAnnotation(comment = "主键", exp = false, imp = false, empty = true, len = 10, pk = true)
	private Long id;

	@FieldAnnotation(comment = "订单号", exp = true, imp = true, empty = true, len = 20)
	private String number;

	@FieldAnnotation(comment = "创建时间", exp = true, imp = true, empty = true)
	private Date create_date;

	@FieldAnnotation(comment = "付款时间", exp = true, imp = true, empty = true)
	private Date pay_date;

	@FieldAnnotation(comment = "创建用户id", exp = true, imp = true, empty = true, len = 10)
	private Long user_id;

	// 用户名称
	private String user_name;

	@FieldAnnotation(comment = "商品id(多个以逗号隔开)", exp = true, imp = true, empty = true, len = 20)
	private String goods_id;

	// 物品名称
	private String goods_name;

	@FieldAnnotation(comment = "收货地址", exp = true, imp = true, empty = true, len = 50)
	private String address;

	@FieldAnnotation(comment = "联系人", exp = true, imp = true, empty = true, len = 10)
	private String contacts;

	@FieldAnnotation(comment = "联系电话", exp = true, imp = true, empty = true, len = 20)
	private String phone;

	@FieldAnnotation(comment = "订单状态", exp = true, imp = true, empty = true, len = 20)
	private String state;

	@FieldAnnotation(comment = "订单金额", exp = true, imp = true, empty = true, len = 20, scale = 2)
	private Double amount;

	@FieldAnnotation(comment = "收货地址id", exp = true, imp = true, empty = true, len = 10)
	private Long address_id;

	// 收货地址
	private String address_name;

	@FieldAnnotation(comment = "商品型号", exp = true, imp = true, empty = true, len = 20)
	private String goods_model;

	/**
	 * 商品订单对象构造函数
	 */
	public GoodsOrder() {
		super();
	}

	public GoodsOrder(String id) {
		this("id", id);
	}

	public GoodsOrder(String property, Object value) {
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
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(Double amount) {
		putField("amount");
		this.amount = amount;
	}

	/**
	 * @return the address_id
	 */
	public Long getAddress_id() {
		return address_id;
	}

	/**
	 * @param address_id
	 *            the address_id to set
	 */
	public void setAddress_id(Long address_id) {
		putField("address_id");
		this.address_id = address_id;
	}

	/**
	 * @return the goods_model
	 */
	public String getGoods_model() {
		return goods_model;
	}

	/**
	 * @param goods_model
	 *            the goods_model to set
	 */
	public void setGoods_model(String goods_model) {
		putField("goods_model");
		this.goods_model = goods_model;
	}

	/**
	 * 获得订单号
	 * 
	 * @return String
	 */
	public String getNumber() {
		return this.number;
	}

	/**
	 * 设置订单号
	 * 
	 * @param number
	 *            订单号
	 */
	public void setNumber(String number) {
		putField("number");
		this.number = number;
	}

	/**
	 * 获得创建时间
	 * 
	 * @return Date
	 */
	public Date getCreate_date() {
		return this.create_date;
	}

	/**
	 * 设置创建时间
	 * 
	 * @param create_date
	 *            创建时间
	 */
	public void setCreate_date(Date create_date) {
		putField("create_date");
		this.create_date = create_date;
	}

	/**
	 * 获得付款时间
	 * 
	 * @return Date
	 */
	public Date getPay_date() {
		return this.pay_date;
	}

	/**
	 * 设置付款时间
	 * 
	 * @param pay_date
	 *            付款时间
	 */
	public void setPay_date(Date pay_date) {
		putField("pay_date");
		this.pay_date = pay_date;
	}

	/**
	 * 获得创建用户id
	 * 
	 * @return Long
	 */
	public Long getUser_id() {
		return this.user_id;
	}

	/**
	 * 设置创建用户id
	 * 
	 * @param user_id
	 *            创建用户id
	 */
	public void setUser_id(Long user_id) {
		putField("user_id");
		this.user_id = user_id;
	}

	/**
	 * 获得商品id(多个以逗号隔开)
	 * 
	 * @return String
	 */
	public String getGoods_id() {
		return this.goods_id;
	}

	/**
	 * 设置商品id(多个以逗号隔开)
	 * 
	 * @param goods_id
	 *            商品id(多个以逗号隔开)
	 */
	public void setGoods_id(String goods_id) {
		putField("goods_id");
		this.goods_id = goods_id;
	}

	/**
	 * 获得收货地址
	 * 
	 * @return String
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * 设置收货地址
	 * 
	 * @param address
	 *            收货地址
	 */
	public void setAddress(String address) {
		putField("address");
		this.address = address;
	}

	/**
	 * 获得联系人
	 * 
	 * @return String
	 */
	public String getContacts() {
		return this.contacts;
	}

	/**
	 * 设置联系人
	 * 
	 * @param contacts
	 *            联系人
	 */
	public void setContacts(String contacts) {
		putField("contacts");
		this.contacts = contacts;
	}

	/**
	 * 获得联系电话
	 * 
	 * @return String
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * 设置联系电话
	 * 
	 * @param phone
	 *            联系电话
	 */
	public void setPhone(String phone) {
		putField("phone");
		this.phone = phone;
	}

	/**
	 * 获得订单状态
	 * 
	 * @return String
	 */
	public String getState() {
		return this.state;
	}

	/**
	 * 设置订单状态
	 * 
	 * @param state
	 *            订单状态
	 */
	public void setState(String state) {
		putField("state");
		this.state = state;
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

	/**
	 * @return the goods_name
	 */
	public String getGoods_name() {
		return goods_name;
	}

	/**
	 * @param goods_name
	 *            the goods_name to set
	 */
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	/**
	 * @return the address_name
	 */
	public String getAddress_name() {
		return address_name;
	}

	/**
	 * @param address_name
	 *            the address_name to set
	 */
	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}
}