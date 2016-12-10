package com.rogrand.cashPool.domain;

import com.rogrand.core.annotation.FieldAnnotation;
import com.rogrand.core.domain.Base;
import java.util.Date;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-12-10 <br/>
 * 描述：提现记录类
 */
public class TransferRecord extends Base {

	private static final long serialVersionUID = 1L;

	@FieldAnnotation(comment = "主键", exp = false, imp = false, empty = true, len = 10, pk = true)
	private Long id;

	@FieldAnnotation(comment = "提现日期", exp = true, imp = true, empty = true)
	private Date date;

	@FieldAnnotation(comment = "提现人", exp = true, imp = true, empty = true, len = 50)
	private String operator;

	@FieldAnnotation(comment = "提现账户", exp = true, imp = true, empty = true, len = 10)
	private Long account_id;

	private String account;

	private String account_name;

	@FieldAnnotation(comment = "提现金额", exp = true, imp = true, empty = true, len = 10, scale = 2)
	private Double amount;

	/**
	 * 提现记录对象构造函数
	 */
	public TransferRecord() {
		super();
	}

	public TransferRecord(String id) {
		this("id", id);
	}

	public TransferRecord(String property, Object value) {
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
	 * 获得提现日期
	 * 
	 * @return Date
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * 设置提现日期
	 * 
	 * @param date
	 *            提现日期
	 */
	public void setDate(Date date) {
		putField("date");
		this.date = date;
	}

	/**
	 * 获得提现人
	 * 
	 * @return String
	 */
	public String getOperator() {
		return this.operator;
	}

	/**
	 * 设置提现人
	 * 
	 * @param operator
	 *            提现人
	 */
	public void setOperator(String operator) {
		putField("operator");
		this.operator = operator;
	}

	/**
	 * 获得提现账户
	 * 
	 * @return Long
	 */
	public Long getAccount_id() {
		return this.account_id;
	}

	/**
	 * 设置提现账户
	 * 
	 * @param account_id
	 *            提现账户
	 */
	public void setAccount_id(Long account_id) {
		putField("account_id");
		this.account_id = account_id;
	}

	/**
	 * 获得提现金额
	 * 
	 * @return Double
	 */
	public Double getAmount() {
		return this.amount;
	}

	/**
	 * 设置提现金额
	 * 
	 * @param amount
	 *            提现金额
	 */
	public void setAmount(Double amount) {
		putField("amount");
		this.amount = amount;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the account_name
	 */
	public String getAccount_name() {
		return account_name;
	}

	/**
	 * @param account_name
	 *            the account_name to set
	 */
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
}