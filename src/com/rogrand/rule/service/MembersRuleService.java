package com.rogrand.rule.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.rogrand.core.domain.PageResult;
import com.rogrand.core.domain.PageParam;
import com.rogrand.core.service.BaseService;
import com.rogrand.rule.domain.MembersRule;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：会员成长规则 Service
 */
@Service("MembersRuleService")
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = Throwable.class)
public class MembersRuleService extends BaseService {
    /**
     * 查询会员成长规则对象
     * @param id 字符串型主键
     * @return MembersRule
     * @throws Exception 异常
     */
    public MembersRule query(String id) throws Exception{
    	PageParam param = new PageParam();
    	param.put("id", id);
        return sqlDao.query("t_members_rule.pageList", param);
    }

    /**
     * 查询会员成长规则对象集合
     * @param param 查询条件
     * @return List<MembersRule>
     * @throws Exception 异常
     */
    public List<MembersRule> list(PageParam param) throws Exception {
    	return sqlDao.list("t_members_rule.pageList",param);
    }
    
    /**
     * 会员成长规则翻页查询
     * @param 分页条件对象
     * @return PageResult
     * @throws Exception 异常
     */
    public PageResult pageList(PageParam param) throws Exception {
    	param.setCountSql("t_members_rule.pageCount");
    	param.setRecordSql("t_members_rule.pageList");
        return pageService.pageQuery(param);
    }

    /**
     * 插入会员成长规则记录
     * @param membersRule 会员成长规则对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String create(MembersRule membersRule) throws Exception  {
        sqlDao.create("t_members_rule.create",membersRule);
        return "1";
    }

    /**
     * 更新会员成长规则记录
     * @param membersRule 会员成长规则对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String update(MembersRule membersRule) throws Exception {
        sqlDao.update("t_members_rule.update", membersRule);
        return "1";
    }

    /**
     * 删除会员成长规则记录
     * @param membersRule 会员成长规则对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(MembersRule membersRule) throws Exception {
        sqlDao.delete("t_members_rule.delete", membersRule);
        return "1";
    }

    /**
     * 删除会员成长规则记录
     * @param id 字符串型主键
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(String id) throws Exception {
        return delete(new MembersRule(id));
    }

    /**
     * 删除会员成长规则记录
     * @param ids 字符串型主键数组
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(String[] ids) throws Exception {
        for(String id:ids){
            delete(id);
        }
        return "1";
    }
}