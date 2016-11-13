package com.rogrand.goods.domain;
import com.rogrand.core.annotation.FieldAnnotation;
import com.rogrand.core.domain.Base;
import java.util.Date;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：商城商品类
 */
public class MallGoods extends Base {

    @FieldAnnotation(comment = "主键", exp = false, imp = false, empty = true, len = 10, pk = true)
    private Long id;

    @FieldAnnotation(comment = "商品名称", exp = true, imp = true, empty = true, len = 20)
    private String name;

    @FieldAnnotation(comment = "商品描述", exp = true, imp = true, empty = true, len = 150)
    private String description;

    @FieldAnnotation(comment = "商品编码", exp = true, imp = true, empty = true, len = 20)
    private String number;

    @FieldAnnotation(comment = "商品类型id", exp = true, imp = true, empty = true, len = 10)
    private Long type_id;

    @FieldAnnotation(comment = "商品价格", exp = true, imp = true, empty = true, len = 10, scale = 2)
    private Double price;

    @FieldAnnotation(comment = "创建用户id", exp = true, imp = true, empty = true, len = 10)
    private Long user_id;

    @FieldAnnotation(comment = "创建日期", exp = true, imp = true, empty = true)
    private Date create_date;

    @FieldAnnotation(comment = "商品图片", exp = true, imp = true, empty = true, len = 100)
    private String url;

    @FieldAnnotation(comment = "商品地区", exp = true, imp = true, empty = true, len = 20)
    private String area;

    @FieldAnnotation(comment = "是否出售", exp = true, imp = true, empty = true, len = 3)
    private Integer is_sale;

    @FieldAnnotation(comment = "卖家id", exp = true, imp = true, empty = true, len = 10)
    private Long seller_id;

    @FieldAnnotation(comment = "会员价格", exp = true, imp = true, empty = true, len = 10, scale = 2)
    private Double vip_price;

    @FieldAnnotation(comment = "商品等级", exp = true, imp = true, empty = true, len = 10)
    private Long level;


    /**
     * 商城商品对象构造函数
     */
    public MallGoods() {
        super();
    }

    public MallGoods(String id) {
        this("id",id);
    }

    public MallGoods(String property, Object value) {
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
     * 获得商品名称
     * @return String
     */
    public String getName(){
        return this.name;
    }

    /**
     * 设置商品名称
     * @param name  商品名称
     */
    public void setName(String name){
        putField("name");
        this.name = name;
    }
    /**
     * 获得商品描述
     * @return String
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * 设置商品描述
     * @param description  商品描述
     */
    public void setDescription(String description){
        putField("description");
        this.description = description;
    }
    /**
     * 获得商品编码
     * @return String
     */
    public String getNumber(){
        return this.number;
    }

    /**
     * 设置商品编码
     * @param number  商品编码
     */
    public void setNumber(String number){
        putField("number");
        this.number = number;
    }
    /**
     * 获得商品类型id
     * @return Long
     */
    public Long getType_id(){
        return this.type_id;
    }

    /**
     * 设置商品类型id
     * @param type_id  商品类型id
     */
    public void setType_id(Long type_id){
        putField("type_id");
        this.type_id = type_id;
    }
    /**
     * 获得商品价格
     * @return Double
     */
    public Double getPrice(){
        return this.price;
    }

    /**
     * 设置商品价格
     * @param price  商品价格
     */
    public void setPrice(Double price){
        putField("price");
        this.price = price;
    }
    /**
     * 获得创建用户id
     * @return Long
     */
    public Long getUser_id(){
        return this.user_id;
    }

    /**
     * 设置创建用户id
     * @param user_id  创建用户id
     */
    public void setUser_id(Long user_id){
        putField("user_id");
        this.user_id = user_id;
    }
    /**
     * 获得创建日期
     * @return Date
     */
    public Date getCreate_date(){
        return this.create_date;
    }

    /**
     * 设置创建日期
     * @param create_date  创建日期
     */
    public void setCreate_date(Date create_date){
        putField("create_date");
        this.create_date = create_date;
    }
    /**
     * 获得商品图片
     * @return String
     */
    public String getUrl(){
        return this.url;
    }

    /**
     * 设置商品图片
     * @param url  商品图片
     */
    public void setUrl(String url){
        putField("url");
        this.url = url;
    }
    /**
     * 获得商品地区
     * @return String
     */
    public String getArea(){
        return this.area;
    }

    /**
     * 设置商品地区
     * @param area  商品地区
     */
    public void setArea(String area){
        putField("area");
        this.area = area;
    }
    /**
     * 获得是否出售
     * @return Integer
     */
    public Integer getIs_sale(){
        return this.is_sale;
    }

    /**
     * 设置是否出售
     * @param is_sale  是否出售
     */
    public void setIs_sale(Integer is_sale){
        putField("is_sale");
        this.is_sale = is_sale;
    }
    /**
     * 获得卖家id
     * @return Long
     */
    public Long getSeller_id(){
        return this.seller_id;
    }

    /**
     * 设置卖家id
     * @param seller_id  卖家id
     */
    public void setSeller_id(Long seller_id){
        putField("seller_id");
        this.seller_id = seller_id;
    }
    /**
     * 获得会员价格
     * @return Double
     */
    public Double getVip_price(){
        return this.vip_price;
    }

    /**
     * 设置会员价格
     * @param vip_price  会员价格
     */
    public void setVip_price(Double vip_price){
        putField("vip_price");
        this.vip_price = vip_price;
    }
    /**
     * 获得商品等级
     * @return Long
     */
    public Long getLevel(){
        return this.level;
    }

    /**
     * 设置商品等级
     * @param level  商品等级
     */
    public void setLevel(Long level){
        putField("level");
        this.level = level;
    }
}