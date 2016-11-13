package com.rogrand.goods.domain;
import com.rogrand.core.annotation.FieldAnnotation;
import com.rogrand.core.domain.Base;
import java.util.Date;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：商品类别类
 */
public class GoodsType extends Base {

    @FieldAnnotation(comment = "主键", exp = false, imp = false, empty = true, len = 10, pk = true)
    private Long id;

    @FieldAnnotation(comment = "类型名称", exp = true, imp = true, empty = true, len = 20)
    private String name;

    @FieldAnnotation(comment = "类型编码", exp = true, imp = true, empty = true, len = 20)
    private String number;

    @FieldAnnotation(comment = "类型级别", exp = true, imp = true, empty = true, len = 10)
    private Long level;

    @FieldAnnotation(comment = "上级id", exp = true, imp = true, empty = true, len = 10)
    private Long parent_id;


    /**
     * 商品类别对象构造函数
     */
    public GoodsType() {
        super();
    }

    public GoodsType(String id) {
        this("id",id);
    }

    public GoodsType(String property, Object value) {
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
     * 获得类型名称
     * @return String
     */
    public String getName(){
        return this.name;
    }

    /**
     * 设置类型名称
     * @param name  类型名称
     */
    public void setName(String name){
        putField("name");
        this.name = name;
    }
    /**
     * 获得类型编码
     * @return String
     */
    public String getNumber(){
        return this.number;
    }

    /**
     * 设置类型编码
     * @param number  类型编码
     */
    public void setNumber(String number){
        putField("number");
        this.number = number;
    }
    /**
     * 获得类型级别
     * @return Long
     */
    public Long getLevel(){
        return this.level;
    }

    /**
     * 设置类型级别
     * @param level  类型级别
     */
    public void setLevel(Long level){
        putField("level");
        this.level = level;
    }
    /**
     * 获得上级id
     * @return Long
     */
    public Long getParent_id(){
        return this.parent_id;
    }

    /**
     * 设置上级id
     * @param parent_id  上级id
     */
    public void setParent_id(Long parent_id){
        putField("parent_id");
        this.parent_id = parent_id;
    }
}