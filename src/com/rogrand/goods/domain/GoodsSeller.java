package com.rogrand.goods.domain;
import com.rogrand.core.annotation.FieldAnnotation;
import com.rogrand.core.domain.Base;
import java.util.Date;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：卖家信息类
 */
public class GoodsSeller extends Base {

    @FieldAnnotation(comment = "主键", exp = false, imp = false, empty = true, len = 10, pk = true)
    private Long id;

    @FieldAnnotation(comment = "昵称", exp = true, imp = true, empty = true, len = 20)
    private String nick_name;

    @FieldAnnotation(comment = "真实姓名", exp = true, imp = true, empty = true, len = 20)
    private String real_name;

    @FieldAnnotation(comment = "城市", exp = true, imp = true, empty = true, len = 50)
    private String city;

    @FieldAnnotation(comment = "联系电话", exp = true, imp = true, empty = true, len = 20)
    private String phone;

    @FieldAnnotation(comment = "邮箱", exp = true, imp = true, empty = true, len = 20)
    private String email;

    @FieldAnnotation(comment = "账户", exp = true, imp = true, empty = true, len = 30)
    private String account;


    /**
     * 卖家信息对象构造函数
     */
    public GoodsSeller() {
        super();
    }

    public GoodsSeller(String id) {
        this("id",id);
    }

    public GoodsSeller(String property, Object value) {
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
     * 获得昵称
     * @return String
     */
    public String getNick_name(){
        return this.nick_name;
    }

    /**
     * 设置昵称
     * @param nick_name  昵称
     */
    public void setNick_name(String nick_name){
        putField("nick_name");
        this.nick_name = nick_name;
    }
    /**
     * 获得真实姓名
     * @return String
     */
    public String getReal_name(){
        return this.real_name;
    }

    /**
     * 设置真实姓名
     * @param real_name  真实姓名
     */
    public void setReal_name(String real_name){
        putField("real_name");
        this.real_name = real_name;
    }
    /**
     * 获得城市
     * @return String
     */
    public String getCity(){
        return this.city;
    }

    /**
     * 设置城市
     * @param city  城市
     */
    public void setCity(String city){
        putField("city");
        this.city = city;
    }
    /**
     * 获得联系电话
     * @return String
     */
    public String getPhone(){
        return this.phone;
    }

    /**
     * 设置联系电话
     * @param phone  联系电话
     */
    public void setPhone(String phone){
        putField("phone");
        this.phone = phone;
    }
    /**
     * 获得邮箱
     * @return String
     */
    public String getEmail(){
        return this.email;
    }

    /**
     * 设置邮箱
     * @param email  邮箱
     */
    public void setEmail(String email){
        putField("email");
        this.email = email;
    }
    /**
     * 获得账户
     * @return String
     */
    public String getAccount(){
        return this.account;
    }

    /**
     * 设置账户
     * @param account  账户
     */
    public void setAccount(String account){
        putField("account");
        this.account = account;
    }
}