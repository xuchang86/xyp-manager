package com.rogrand.inviteCode.domain;
import com.rogrand.core.annotation.FieldAnnotation;
import com.rogrand.core.domain.Base;
import java.util.Date;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：邀请码类
 */
public class InviteCode extends Base {

    @FieldAnnotation(comment = "主键", exp = false, imp = false, empty = true, len = 10, pk = true)
    private Long id;

    @FieldAnnotation(comment = "邀请码", exp = true, imp = true, empty = true, len = 50)
    private String number;

    @FieldAnnotation(comment = "用户ID", exp = true, imp = true, empty = true, len = 10)
    private Long user_id;

    @FieldAnnotation(comment = "聊天室ID", exp = true, imp = true, empty = true, len = 50)
    private String chatroom_id;


    /**
     * 邀请码对象构造函数
     */
    public InviteCode() {
        super();
    }

    public InviteCode(String id) {
        this("id",id);
    }

    public InviteCode(String property, Object value) {
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
     * 获得邀请码
     * @return String
     */
    public String getNumber(){
        return this.number;
    }

    /**
     * 设置邀请码
     * @param number  邀请码
     */
    public void setNumber(String number){
        putField("number");
        this.number = number;
    }
    /**
     * 获得用户ID
     * @return Long
     */
    public Long getUser_id(){
        return this.user_id;
    }

    /**
     * 设置用户ID
     * @param user_id  用户ID
     */
    public void setUser_id(Long user_id){
        putField("user_id");
        this.user_id = user_id;
    }
    /**
     * 获得聊天室ID
     * @return String
     */
    public String getChatroom_id(){
        return this.chatroom_id;
    }

    /**
     * 设置聊天室ID
     * @param chatroom_id  聊天室ID
     */
    public void setChatroom_id(String chatroom_id){
        putField("chatroom_id");
        this.chatroom_id = chatroom_id;
    }
}