package com.rogrand.login.domain;
import com.rogrand.core.annotation.FieldAnnotation;
import com.rogrand.core.domain.Base;
import java.util.Date;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-12 <br/>
 * 描述：逍遥派用户类
 */
public class LoginUser extends Base {

    @FieldAnnotation(comment = "主键", exp = false, imp = false, empty = true, len = 10, pk = true)
    private Long id;

    @FieldAnnotation(comment = "电话", exp = true, imp = true, empty = true, len = 20)
    private String phone;

    @FieldAnnotation(comment = "密码", exp = true, imp = true, empty = true, len = 50)
    private String password;

    @FieldAnnotation(comment = "名称", exp = true, imp = true, empty = true, len = 20)
    private String name;

    @FieldAnnotation(comment = "生日", exp = true, imp = true, empty = true)
    private Date birthday;

    @FieldAnnotation(comment = "地址", exp = true, imp = true, empty = true, len = 50)
    private String address;

    @FieldAnnotation(comment = "我提供的资源", exp = true, imp = true, empty = true, len = 20)
    private String providerid;

    @FieldAnnotation(comment = "我需要的资源", exp = true, imp = true, empty = true, len = 20)
    private String requiredid;

    @FieldAnnotation(comment = "城市", exp = true, imp = true, empty = true, len = 20)
    private String city;

    @FieldAnnotation(comment = "性别", exp = true, imp = true, empty = true, len = 10)
    private Long sex;

    @FieldAnnotation(comment = "用户名", exp = true, imp = true, empty = true, len = 15)
    private String username;

    @FieldAnnotation(comment = "是否已付款", exp = true, imp = true, empty = true, len = 10)
    private Long ispay;

    @FieldAnnotation(comment = "个人头像", exp = true, imp = true, empty = true, len = 100)
    private String url;


    /**
     * 逍遥派用户对象构造函数
     */
    public LoginUser() {
        super();
    }

    public LoginUser(String id) {
        this("id",id);
    }

    public LoginUser(String property, Object value) {
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
     * 获得电话
     * @return String
     */
    public String getPhone(){
        return this.phone;
    }

    /**
     * 设置电话
     * @param phone  电话
     */
    public void setPhone(String phone){
        putField("phone");
        this.phone = phone;
    }
    /**
     * 获得密码
     * @return String
     */
    public String getPassword(){
        return this.password;
    }

    /**
     * 设置密码
     * @param password  密码
     */
    public void setPassword(String password){
        putField("password");
        this.password = password;
    }
    /**
     * 获得名称
     * @return String
     */
    public String getName(){
        return this.name;
    }

    /**
     * 设置名称
     * @param name  名称
     */
    public void setName(String name){
        putField("name");
        this.name = name;
    }
    /**
     * 获得生日
     * @return Date
     */
    public Date getBirthday(){
        return this.birthday;
    }

    /**
     * 设置生日
     * @param birthday  生日
     */
    public void setBirthday(Date birthday){
        putField("birthday");
        this.birthday = birthday;
    }
    /**
     * 获得地址
     * @return String
     */
    public String getAddress(){
        return this.address;
    }

    /**
     * 设置地址
     * @param address  地址
     */
    public void setAddress(String address){
        putField("address");
        this.address = address;
    }
    /**
     * 获得我提供的资源
     * @return String
     */
    public String getProviderid(){
        return this.providerid;
    }

    /**
     * 设置我提供的资源
     * @param providerid  我提供的资源
     */
    public void setProviderid(String providerid){
        putField("providerid");
        this.providerid = providerid;
    }
    /**
     * 获得我需要的资源
     * @return String
     */
    public String getRequiredid(){
        return this.requiredid;
    }

    /**
     * 设置我需要的资源
     * @param requiredid  我需要的资源
     */
    public void setRequiredid(String requiredid){
        putField("requiredid");
        this.requiredid = requiredid;
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
     * 获得性别
     * @return Long
     */
    public Long getSex(){
        return this.sex;
    }

    /**
     * 设置性别
     * @param sex  性别
     */
    public void setSex(Long sex){
        putField("sex");
        this.sex = sex;
    }
    /**
     * 获得用户名
     * @return String
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * 设置用户名
     * @param username  用户名
     */
    public void setUsername(String username){
        putField("username");
        this.username = username;
    }
    /**
     * 获得是否已付款
     * @return Long
     */
    public Long getIspay(){
        return this.ispay;
    }

    /**
     * 设置是否已付款
     * @param ispay  是否已付款
     */
    public void setIspay(Long ispay){
        putField("ispay");
        this.ispay = ispay;
    }
    /**
     * 获得个人头像
     * @return String
     */
    public String getUrl(){
        return this.url;
    }

    /**
     * 设置个人头像
     * @param url  个人头像
     */
    public void setUrl(String url){
        putField("url");
        this.url = url;
    }
}