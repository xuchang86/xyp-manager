package com.rogrand.publish.domain;
import com.rogrand.core.annotation.FieldAnnotation;
import com.rogrand.core.domain.Base;
import java.util.Date;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：发布的活动,任务,悬赏类
 */
public class PublishActivity extends Base {

    @FieldAnnotation(comment = "主键", exp = false, imp = false, empty = true, len = 10, pk = true)
    private Long id;

    @FieldAnnotation(comment = "活动类型", exp = true, imp = true, empty = true, len = 20)
    private String type;

    @FieldAnnotation(comment = "发布地址", exp = true, imp = true, empty = true, len = 50)
    private String address;

    @FieldAnnotation(comment = "发布内容", exp = true, imp = true, empty = true, len = 500)
    private String content;

    @FieldAnnotation(comment = "日志", exp = true, imp = true, empty = true)
    private Date date;

    @FieldAnnotation(comment = "人物ID", exp = true, imp = true, empty = true, len = 10)
    private Long person_id;
    private String person_name;

    @FieldAnnotation(comment = "费用", exp = true, imp = true, empty = true, len = 10, scale = 2)
    private Double cost;

    @FieldAnnotation(comment = "城市", exp = true, imp = true, empty = true, len = 50)
    private String city;

    @FieldAnnotation(comment = "活动方式", exp = true, imp = true, empty = true, len = 20)
    private String way;

    @FieldAnnotation(comment = "付款方式", exp = true, imp = true, empty = true, len = 20)
    private String payway;


    public String getPerson_name() {
		return person_name;
	}

	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}

	/**
     * 发布的活动,任务,悬赏对象构造函数
     */
    public PublishActivity() {
        super();
    }

    public PublishActivity(String id) {
        this("id",id);
    }

    public PublishActivity(String property, Object value) {
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
     * 获得活动类型
     * @return String
     */
    public String getType(){
        return this.type;
    }

    /**
     * 设置活动类型
     * @param type  活动类型
     */
    public void setType(String type){
        putField("type");
        this.type = type;
    }
    /**
     * 获得发布地址
     * @return String
     */
    public String getAddress(){
        return this.address;
    }

    /**
     * 设置发布地址
     * @param address  发布地址
     */
    public void setAddress(String address){
        putField("address");
        this.address = address;
    }
    /**
     * 获得发布内容
     * @return String
     */
    public String getContent(){
        return this.content;
    }

    /**
     * 设置发布内容
     * @param content  发布内容
     */
    public void setContent(String content){
        putField("content");
        this.content = content;
    }
    /**
     * 获得日志
     * @return Date
     */
    public Date getDate(){
        return this.date;
    }

    /**
     * 设置日志
     * @param date  日志
     */
    public void setDate(Date date){
        putField("date");
        this.date = date;
    }
    /**
     * 获得人物ID
     * @return Long
     */
    public Long getPerson_id(){
        return this.person_id;
    }

    /**
     * 设置人物ID
     * @param person_id  人物ID
     */
    public void setPerson_id(Long person_id){
        putField("person_id");
        this.person_id = person_id;
    }
    /**
     * 获得费用
     * @return Double
     */
    public Double getCost(){
        return this.cost;
    }

    /**
     * 设置费用
     * @param cost  费用
     */
    public void setCost(Double cost){
        putField("cost");
        this.cost = cost;
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
     * 获得活动方式
     * @return String
     */
    public String getWay(){
        return this.way;
    }

    /**
     * 设置活动方式
     * @param way  活动方式
     */
    public void setWay(String way){
        putField("way");
        this.way = way;
    }
    /**
     * 获得付款方式
     * @return String
     */
    public String getPayway(){
        return this.payway;
    }

    /**
     * 设置付款方式
     * @param payway  付款方式
     */
    public void setPayway(String payway){
        putField("payway");
        this.payway = payway;
    }
}