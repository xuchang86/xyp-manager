package com.rogrand.order.domain;
import com.rogrand.core.annotation.FieldAnnotation;
import com.rogrand.core.domain.Base;
import java.util.Date;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：支付宝付款订单类
 */
public class PayOrder extends Base {

    @FieldAnnotation(comment = "主键", exp = false, imp = false, empty = true, len = 10, pk = true)
    private Long id;

    @FieldAnnotation(comment = "支付宝订单号", exp = true, imp = true, empty = true, len = 50)
    private String order_code;

    @FieldAnnotation(comment = "付款日期", exp = true, imp = true, empty = true)
    private Date pay_date;

    @FieldAnnotation(comment = "用户ID", exp = true, imp = true, empty = true, len = 10)
    private Long user_id;

    @FieldAnnotation(comment = "付款金额", exp = true, imp = true, empty = true, len = 10, scale = 2)
    private Double pay_amount;


    /**
     * 支付宝付款订单对象构造函数
     */
    public PayOrder() {
        super();
    }

    public PayOrder(String id) {
        this("id",id);
    }

    public PayOrder(String property, Object value) {
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
     * 获得支付宝订单号
     * @return String
     */
    public String getOrder_code(){
        return this.order_code;
    }

    /**
     * 设置支付宝订单号
     * @param order_code  支付宝订单号
     */
    public void setOrder_code(String order_code){
        putField("order_code");
        this.order_code = order_code;
    }
    /**
     * 获得付款日期
     * @return Date
     */
    public Date getPay_date(){
        return this.pay_date;
    }

    /**
     * 设置付款日期
     * @param pay_date  付款日期
     */
    public void setPay_date(Date pay_date){
        putField("pay_date");
        this.pay_date = pay_date;
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
     * 获得付款金额
     * @return Double
     */
    public Double getPay_amount(){
        return this.pay_amount;
    }

    /**
     * 设置付款金额
     * @param pay_amount  付款金额
     */
    public void setPay_amount(Double pay_amount){
        putField("pay_amount");
        this.pay_amount = pay_amount;
    }
}