package com.rogrand.event.domain;

import com.rogrand.core.annotation.FieldAnnotation;
import com.rogrand.core.domain.Base;
import java.util.Date;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：门派事件类
 */
public class MpEvent extends Base {

	private static final long serialVersionUID = 701051255225636329L;

	@FieldAnnotation(comment = "主键", exp = false, imp = false, empty = true, len = 10, pk = true)
	private Long id;

	@FieldAnnotation(comment = "事件内容", exp = true, imp = true, empty = true, len = 800)
	private String content;

	@FieldAnnotation(comment = "人物ID", exp = true, imp = true, empty = true, len = 10)
	private Long person_id;

	private String person_name;

	@FieldAnnotation(comment = "开始时间", exp = true, imp = true, empty = true)
	private Date start_date;

	@FieldAnnotation(comment = "结束时间", exp = true, imp = true, empty = true)
	private Date end_date;

	@FieldAnnotation(comment = "事件类型", exp = true, imp = true, empty = true, len = 20)
	private String type;

	/**
	 * 门派事件对象构造函数
	 */
	public MpEvent() {
		super();
	}

	public MpEvent(String id) {
		this("id", id);
	}

	public MpEvent(String property, Object value) {
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
	 * 获得事件内容
	 * 
	 * @return String
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 * 设置事件内容
	 * 
	 * @param content
	 *            事件内容
	 */
	public void setContent(String content) {
		putField("content");
		this.content = content;
	}

	/**
	 * 获得人物ID
	 * 
	 * @return Long
	 */
	public Long getPerson_id() {
		return this.person_id;
	}

	/**
	 * 设置人物ID
	 * 
	 * @param person_id
	 *            人物ID
	 */
	public void setPerson_id(Long person_id) {
		putField("person_id");
		this.person_id = person_id;
	}

	/**
	 * 获得开始时间
	 * 
	 * @return Date
	 */
	public Date getStart_date() {
		return this.start_date;
	}

	/**
	 * 设置开始时间
	 * 
	 * @param start_date
	 *            开始时间
	 */
	public void setStart_date(Date start_date) {
		putField("start_date");
		this.start_date = start_date;
	}

	/**
	 * 获得结束时间
	 * 
	 * @return Date
	 */
	public Date getEnd_date() {
		return this.end_date;
	}

	/**
	 * 设置结束时间
	 * 
	 * @param end_date
	 *            结束时间
	 */
	public void setEnd_date(Date end_date) {
		putField("end_date");
		this.end_date = end_date;
	}

	/**
	 * 获得事件类型
	 * 
	 * @return String
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * 设置事件类型
	 * 
	 * @param type
	 *            事件类型
	 */
	public void setType(String type) {
		putField("type");
		this.type = type;
	}

	/**
	 * @return the person_name
	 */
	public String getPerson_name() {
		return person_name;
	}

	/**
	 * @param person_name
	 *            the person_name to set
	 */
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
}