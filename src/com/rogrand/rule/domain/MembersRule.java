package com.rogrand.rule.domain;
import com.rogrand.core.annotation.FieldAnnotation;
import com.rogrand.core.domain.Base;
import java.util.Date;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：会员成长规则类
 */
public class MembersRule extends Base {

    @FieldAnnotation(comment = "主键", exp = false, imp = false, empty = true, len = 10, pk = true)
    private Long id;

    @FieldAnnotation(comment = "等级", exp = true, imp = true, empty = true, len = 10)
    private Long level;

    @FieldAnnotation(comment = "升级数", exp = true, imp = true, empty = true, len = 10)
    private Long level_count;

    @FieldAnnotation(comment = "资金池", exp = true, imp = true, empty = true, len = 10, scale = 2)
    private Double money_pool;

    @FieldAnnotation(comment = "弟子给师傅的红包", exp = true, imp = true, empty = true, len = 10, scale = 2)
    private Double packet;

    @FieldAnnotation(comment = "徒弟红包总数", exp = true, imp = true, empty = true, len = 10)
    private Long packet_count;

    @FieldAnnotation(comment = "徒孙给师傅的红包", exp = true, imp = true, empty = true, len = 10, scale = 2)
    private Double child_packet;

    @FieldAnnotation(comment = "徒孙给师傅的红包总数", exp = true, imp = true, empty = true, len = 10)
    private Long child_packet_count;

    @FieldAnnotation(comment = "升级奖励", exp = true, imp = true, empty = true, len = 10, scale = 2)
    private Double upgrade_awards;

    @FieldAnnotation(comment = "会员收入", exp = true, imp = true, empty = true, len = 10, scale = 2)
    private Double member_income;

    @FieldAnnotation(comment = "平台收入", exp = true, imp = true, empty = true, len = 10, scale = 2)
    private Double platform_income;

    @FieldAnnotation(comment = "弟子总数", exp = true, imp = true, empty = true, len = 10)
    private Long total_child;

    @FieldAnnotation(comment = "备注", exp = true, imp = true, empty = true, len = 100)
    private String remark;


    /**
     * 会员成长规则对象构造函数
     */
    public MembersRule() {
        super();
    }

    public MembersRule(String id) {
        this("id",id);
    }

    public MembersRule(String property, Object value) {
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
     * 获得等级
     * @return Long
     */
    public Long getLevel(){
        return this.level;
    }

    /**
     * 设置等级
     * @param level  等级
     */
    public void setLevel(Long level){
        putField("level");
        this.level = level;
    }
    /**
     * 获得升级数
     * @return Long
     */
    public Long getLevel_count(){
        return this.level_count;
    }

    /**
     * 设置升级数
     * @param level_count  升级数
     */
    public void setLevel_count(Long level_count){
        putField("level_count");
        this.level_count = level_count;
    }
    /**
     * 获得资金池
     * @return Double
     */
    public Double getMoney_pool(){
        return this.money_pool;
    }

    /**
     * 设置资金池
     * @param money_pool  资金池
     */
    public void setMoney_pool(Double money_pool){
        putField("money_pool");
        this.money_pool = money_pool;
    }
    /**
     * 获得弟子给师傅的红包
     * @return Double
     */
    public Double getPacket(){
        return this.packet;
    }

    /**
     * 设置弟子给师傅的红包
     * @param packet  弟子给师傅的红包
     */
    public void setPacket(Double packet){
        putField("packet");
        this.packet = packet;
    }
    /**
     * 获得徒弟红包总数
     * @return Long
     */
    public Long getPacket_count(){
        return this.packet_count;
    }

    /**
     * 设置徒弟红包总数
     * @param packet_count  徒弟红包总数
     */
    public void setPacket_count(Long packet_count){
        putField("packet_count");
        this.packet_count = packet_count;
    }
    /**
     * 获得徒孙给师傅的红包
     * @return Double
     */
    public Double getChild_packet(){
        return this.child_packet;
    }

    /**
     * 设置徒孙给师傅的红包
     * @param child_packet  徒孙给师傅的红包
     */
    public void setChild_packet(Double child_packet){
        putField("child_packet");
        this.child_packet = child_packet;
    }
    /**
     * 获得徒孙给师傅的红包总数
     * @return Long
     */
    public Long getChild_packet_count(){
        return this.child_packet_count;
    }

    /**
     * 设置徒孙给师傅的红包总数
     * @param child_packet_count  徒孙给师傅的红包总数
     */
    public void setChild_packet_count(Long child_packet_count){
        putField("child_packet_count");
        this.child_packet_count = child_packet_count;
    }
    /**
     * 获得升级奖励
     * @return Double
     */
    public Double getUpgrade_awards(){
        return this.upgrade_awards;
    }

    /**
     * 设置升级奖励
     * @param upgrade_awards  升级奖励
     */
    public void setUpgrade_awards(Double upgrade_awards){
        putField("upgrade_awards");
        this.upgrade_awards = upgrade_awards;
    }
    /**
     * 获得会员收入
     * @return Double
     */
    public Double getMember_income(){
        return this.member_income;
    }

    /**
     * 设置会员收入
     * @param member_income  会员收入
     */
    public void setMember_income(Double member_income){
        putField("member_income");
        this.member_income = member_income;
    }
    /**
     * 获得平台收入
     * @return Double
     */
    public Double getPlatform_income(){
        return this.platform_income;
    }

    /**
     * 设置平台收入
     * @param platform_income  平台收入
     */
    public void setPlatform_income(Double platform_income){
        putField("platform_income");
        this.platform_income = platform_income;
    }
    /**
     * 获得弟子总数
     * @return Long
     */
    public Long getTotal_child(){
        return this.total_child;
    }

    /**
     * 设置弟子总数
     * @param total_child  弟子总数
     */
    public void setTotal_child(Long total_child){
        putField("total_child");
        this.total_child = total_child;
    }
    /**
     * 获得备注
     * @return String
     */
    public String getRemark(){
        return this.remark;
    }

    /**
     * 设置备注
     * @param remark  备注
     */
    public void setRemark(String remark){
        putField("remark");
        this.remark = remark;
    }
}