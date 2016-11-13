package com.rogrand.publish.domain;
import com.rogrand.core.annotation.FieldAnnotation;
import com.rogrand.core.domain.Base;
import java.util.Date;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：活动参与人类
 */
public class ActivityPerson extends Base {

    @FieldAnnotation(comment = "主键", exp = false, imp = false, empty = true, len = 10, pk = true)
    private Long id;

    @FieldAnnotation(comment = "人物ID", exp = true, imp = true, empty = true, len = 10)
    private Long person_id;

    @FieldAnnotation(comment = "活动ID", exp = true, imp = true, empty = true, len = 10)
    private Long activity_id;


    /**
     * 活动参与人对象构造函数
     */
    public ActivityPerson() {
        super();
    }

    public ActivityPerson(String id) {
        this("id",id);
    }

    public ActivityPerson(String property, Object value) {
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
     * 获得活动ID
     * @return Long
     */
    public Long getActivity_id(){
        return this.activity_id;
    }

    /**
     * 设置活动ID
     * @param activity_id  活动ID
     */
    public void setActivity_id(Long activity_id){
        putField("activity_id");
        this.activity_id = activity_id;
    }
}