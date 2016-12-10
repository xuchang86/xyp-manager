package com.rogrand.cashPool.domain;
import com.rogrand.core.annotation.FieldAnnotation;
import com.rogrand.core.domain.Base;
import java.util.Date;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-12-10 <br/>
 * 描述：银行账户信息类
 */
public class BankAccount extends Base {

    @FieldAnnotation(comment = "主键", exp = false, imp = false, empty = true, len = 10, pk = true)
    private Long id;

    @FieldAnnotation(comment = "银行名称", exp = true, imp = true, empty = true, len = 50)
    private String name;

    @FieldAnnotation(comment = "银行账户", exp = true, imp = true, empty = true, len = 50)
    private String account;

    @FieldAnnotation(comment = "收款人", exp = true, imp = true, empty = true, len = 50)
    private String receiver;


    /**
     * 银行账户信息对象构造函数
     */
    public BankAccount() {
        super();
    }

    public BankAccount(String id) {
        this("id",id);
    }

    public BankAccount(String property, Object value) {
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
     * 获得银行名称
     * @return String
     */
    public String getName(){
        return this.name;
    }

    /**
     * 设置银行名称
     * @param name  银行名称
     */
    public void setName(String name){
        putField("name");
        this.name = name;
    }
    /**
     * 获得银行账户
     * @return String
     */
    public String getAccount(){
        return this.account;
    }

    /**
     * 设置银行账户
     * @param account  银行账户
     */
    public void setAccount(String account){
        putField("account");
        this.account = account;
    }
    /**
     * 获得收款人
     * @return String
     */
    public String getReceiver(){
        return this.receiver;
    }

    /**
     * 设置收款人
     * @param receiver  收款人
     */
    public void setReceiver(String receiver){
        putField("receiver");
        this.receiver = receiver;
    }
}