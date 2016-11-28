package com.rogrand.cashPool.domain;

import com.rogrand.core.annotation.FieldAnnotation;
import com.rogrand.core.domain.Base;
import java.util.Date;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：资金池类
 */
public class CashPool extends Base {

	/** 序列 */
	private static final long serialVersionUID = 6195758869546204010L;

	@FieldAnnotation(comment = "主键", exp = false, imp = false, empty = true, len = 10, pk = true)
	private Long id;

	@FieldAnnotation(comment = "资金", exp = true, imp = true, empty = true, len = 10, scale = 2)
	private Double money;

	@FieldAnnotation(comment = "用户ID", exp = true, imp = true, empty = true, len = 10)
	private Long user_id;

	private String user_name;

	@FieldAnnotation(comment = "创建时间", exp = true, imp = true, empty = true)
	private Date createdate;

	@FieldAnnotation(comment = "平台收入", exp = true, imp = true, empty = true, len = 10, scale = 2)
	private Double platform;

	/**
	 * 资金池对象构造函数
	 */
	public CashPool() {
		super();
	}

	public CashPool(String id) {
		this("id", id);
	}

	public CashPool(String property, Object value) {
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
	 * 获得资金
	 * 
	 * @return Double
	 */
	public Double getMoney() {
		return this.money;
	}

	/**
	 * 设置资金
	 * 
	 * @param money
	 *            资金
	 */
	public void setMoney(Double money) {
		putField("money");
		this.money = money;
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
	 * 获得创建时间
	 * 
	 * @return Date
	 */
	public Date getCreatedate() {
		return this.createdate;
	}

	/**
	 * 设置创建时间
	 * 
	 * @param createdate
	 *            创建时间
	 */
	public void setCreatedate(Date createdate) {
		putField("createdate");
		this.createdate = createdate;
	}

	/**
	 * 获得平台收入
	 * 
	 * @return Double
	 */
	public Double getPlatform() {
		return this.platform;
	}

	/**
	 * 设置平台收入
	 * 
	 * @param platform
	 *            平台收入
	 */
	public void setPlatform(Double platform) {
		putField("platform");
		this.platform = platform;
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