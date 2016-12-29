package com.rogrand.login.domain;
import com.rogrand.core.annotation.FieldAnnotation;
import com.rogrand.core.domain.Base;
import java.util.Date;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-12-29 <br/>
 * 描述：聊天记录类
 */
public class ChatRecord extends Base {

    @FieldAnnotation(comment = "主键", exp = false, imp = false, empty = true, len = 10, pk = true)
    private Long id;

    @FieldAnnotation(comment = "用户id", exp = true, imp = true, empty = true, len = 10)
    private Long user_id;
    
    private String user_name;

    @FieldAnnotation(comment = "发起人id", exp = true, imp = true, empty = true, len = 50)
    private String from_id;

    @FieldAnnotation(comment = "接收人id", exp = true, imp = true, empty = true, len = 50)
    private String to_id;

    @FieldAnnotation(comment = "内容", exp = true, imp = true, empty = true, len = 2000)
    private String content;


    /**
     * 聊天记录对象构造函数
     */
    public ChatRecord() {
        super();
    }

    public ChatRecord(String id) {
        this("id",id);
    }

    public ChatRecord(String property, Object value) {
        this();
        init(property, value);
    }

    /**
     * 获得主键
     * @return Long
     */
    public Long getId(){
        return this.id;
    }

    /**
     * 设置主键
     * @param id  主键
     */
    public void setId(Long id){
        putField("id");
        this.id = id;
    }
    /**
     * 获得用户id
     * @return Long
     */
    public Long getUser_id(){
        return this.user_id;
    }

    /**
     * 设置用户id
     * @param user_id  用户id
     */
    public void setUser_id(Long user_id){
        putField("user_id");
        this.user_id = user_id;
    }
    /**
     * 获得发起人id
     * @return String
     */
    public String getFrom_id(){
        return this.from_id;
    }

    /**
     * 设置发起人id
     * @param from_id  发起人id
     */
    public void setFrom_id(String from_id){
        putField("from_id");
        this.from_id = from_id;
    }
    /**
     * 获得接收人id
     * @return String
     */
    public String getTo_id(){
        return this.to_id;
    }

    /**
     * 设置接收人id
     * @param to_id  接收人id
     */
    public void setTo_id(String to_id){
        putField("to_id");
        this.to_id = to_id;
    }
    /**
     * 获得内容
     * @return String
     */
    public String getContent(){
        return this.content;
    }

    /**
     * 设置内容
     * @param content  内容
     */
    public void setContent(String content){
        putField("content");
        this.content = content;
    }

	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
}