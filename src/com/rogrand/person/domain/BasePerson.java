package com.rogrand.person.domain;
import com.rogrand.core.annotation.FieldAnnotation;
import com.rogrand.core.domain.Base;
import java.util.Date;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：人物信息类
 */
public class BasePerson extends Base {

    @FieldAnnotation(comment = "主键", exp = false, imp = false, empty = true, len = 10, pk = true)
    private Long id;

    @FieldAnnotation(comment = "用户id", exp = true, imp = true, empty = true, len = 10)
    private Long user_id;

    @FieldAnnotation(comment = "级别", exp = true, imp = true, empty = true, len = 10)
    private Long level;

    @FieldAnnotation(comment = "逍遥币", exp = true, imp = true, empty = true, len = 10, scale = 2)
    private Double bill;

    @FieldAnnotation(comment = "师傅id", exp = true, imp = true, empty = true, len = 10)
    private Long parent_id;

    @FieldAnnotation(comment = "创建时间", exp = true, imp = true, empty = true)
    private Date create_date;

    @FieldAnnotation(comment = "名称", exp = true, imp = true, empty = true, len = 20)
    private String name;


    /**
     * 人物信息对象构造函数
     */
    public BasePerson() {
        super();
    }

    public BasePerson(String id) {
        this("id",id);
    }

    public BasePerson(String property, Object value) {
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
     * 获得级别
     * @return Long
     */
    public Long getLevel(){
        return this.level;
    }

    /**
     * 设置级别
     * @param level  级别
     */
    public void setLevel(Long level){
        putField("level");
        this.level = level;
    }
    /**
     * 获得逍遥币
     * @return Double
     */
    public Double getBill(){
        return this.bill;
    }

    /**
     * 设置逍遥币
     * @param bill  逍遥币
     */
    public void setBill(Double bill){
        putField("bill");
        this.bill = bill;
    }
    /**
     * 获得师傅id
     * @return Long
     */
    public Long getParent_id(){
        return this.parent_id;
    }

    /**
     * 设置师傅id
     * @param parent_id  师傅id
     */
    public void setParent_id(Long parent_id){
        putField("parent_id");
        this.parent_id = parent_id;
    }
    /**
     * 获得创建时间
     * @return Date
     */
    public Date getCreate_date(){
        return this.create_date;
    }

    /**
     * 设置创建时间
     * @param create_date  创建时间
     */
    public void setCreate_date(Date create_date){
        putField("create_date");
        this.create_date = create_date;
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
}