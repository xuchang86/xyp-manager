/******************************************************************************
 * Copyright (C) 2016 ShenZhen xiaoyue Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为许畅个人开发研制。未经本人正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.rogrand.login.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 聊天VO
 * 
 * @author 许畅
 * @since JDK1.7
 * @version 2016年12月30日 许畅 新建
 */
public class ChatVO implements Serializable {

	/** 序列号 */
	private static final long serialVersionUID = -875911771229265757L;

	/** id */
	private Long id;

	/** user_id */
	private Long user_id;

	/** 用户名称 */
	private String user_name;

	/** 发起人id */
	private String from_id;

	/** 接收人id */
	private String to_id;

	/** 发起人聊天内容 */
	private String content;

	/** 创建时间 */
	private Date create_time;

	/** 发送内容 */
	private String toContent;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the user_id
	 */
	public Long getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id
	 *            the user_id to set
	 */
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
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
	 * @return the from_id
	 */
	public String getFrom_id() {
		return from_id;
	}

	/**
	 * @param from_id
	 *            the from_id to set
	 */
	public void setFrom_id(String from_id) {
		this.from_id = from_id;
	}

	/**
	 * @return the to_id
	 */
	public String getTo_id() {
		return to_id;
	}

	/**
	 * @param to_id
	 *            the to_id to set
	 */
	public void setTo_id(String to_id) {
		this.to_id = to_id;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the create_time
	 */
	public Date getCreate_time() {
		return create_time;
	}

	/**
	 * @param create_time
	 *            the create_time to set
	 */
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	/**
	 * @return the toContent
	 */
	public String getToContent() {
		return toContent;
	}

	/**
	 * @param toContent
	 *            the toContent to set
	 */
	public void setToContent(String toContent) {
		this.toContent = toContent;
	}

}
