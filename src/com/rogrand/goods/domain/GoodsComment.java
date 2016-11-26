package com.rogrand.goods.domain;
import com.rogrand.core.annotation.FieldAnnotation;
import com.rogrand.core.domain.Base;
import java.util.Date;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：物品评论类
 */
public class GoodsComment extends Base {

    @FieldAnnotation(comment = "主键", exp = false, imp = false, empty = true, len = 10, pk = true)
    private Long id;

    @FieldAnnotation(comment = "评论人", exp = true, imp = true, empty = true, len = 10)
    private Long user_id;
    private String user_name;

    @FieldAnnotation(comment = "评论时间", exp = true, imp = true, empty = true)
    private Date create_date;

    @FieldAnnotation(comment = "评论内容", exp = true, imp = true, empty = true, len = 500)
    private String content;

    @FieldAnnotation(comment = "商品id", exp = true, imp = true, empty = true, len = 10)
    private Long goods_id;
    private String goods_name;

    @FieldAnnotation(comment = "订单id", exp = true, imp = true, empty = true, len = 10)
    private Long order_id;
    private String order_name;


   

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getOrder_name() {
		return order_name;
	}

	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}

	/**
     * 物品评论对象构造函数
     */
    public GoodsComment() {
        super();
    }

    public GoodsComment(String id) {
        this("id",id);
    }

    public GoodsComment(String property, Object value) {
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
     * 获得评论人
     * @return Long
     */
    public Long getUser_id(){
        return this.user_id;
    }

    /**
     * 设置评论人
     * @param user_id  评论人
     */
    public void setUser_id(Long user_id){
        putField("user_id");
        this.user_id = user_id;
    }
    /**
     * 获得评论时间
     * @return Date
     */
    public Date getCreate_date(){
        return this.create_date;
    }

    /**
     * 设置评论时间
     * @param create_date  评论时间
     */
    public void setCreate_date(Date create_date){
        putField("create_date");
        this.create_date = create_date;
    }
    /**
     * 获得评论内容
     * @return String
     */
    public String getContent(){
        return this.content;
    }

    /**
     * 设置评论内容
     * @param content  评论内容
     */
    public void setContent(String content){
        putField("content");
        this.content = content;
    }
    /**
     * 获得商品id
     * @return Long
     */
    public Long getGoods_id(){
        return this.goods_id;
    }

    /**
     * 设置商品id
     * @param goods_id  商品id
     */
    public void setGoods_id(Long goods_id){
        putField("goods_id");
        this.goods_id = goods_id;
    }
    /**
     * 获得订单id
     * @return Long
     */
    public Long getOrder_id(){
        return this.order_id;
    }

    /**
     * 设置订单id
     * @param order_id  订单id
     */
    public void setOrder_id(Long order_id){
        putField("order_id");
        this.order_id = order_id;
    }
}