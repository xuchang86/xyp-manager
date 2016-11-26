package com.rogrand.person.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.rogrand.core.domain.PageResult;
import com.rogrand.core.domain.PageParam;
import com.rogrand.core.service.BaseService;
import com.rogrand.person.domain.BasePerson;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：人物信息 Service
 */
@Service("BasePersonService")
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = Throwable.class)
public class BasePersonService extends BaseService {
    /**
     * 查询人物信息对象
     * @param id 字符串型主键
     * @return BasePerson
     * @throws Exception 异常
     */
    public BasePerson query(String id) throws Exception{
    	PageParam param = new PageParam();
    	param.put("id", id);
        return sqlDao.query("t_base_person.pageList", param);
    }

    /**
     * 查询人物信息对象集合
     * @param param 查询条件
     * @return List<BasePerson>
     * @throws Exception 异常
     */
    public List<BasePerson> list(PageParam param) throws Exception {
    	return sqlDao.list("t_base_person.pageList",param);
    }
    
    /**
     * 人物信息翻页查询
     * @param 分页条件对象
     * @return PageResult
     * @throws Exception 异常
     */
    public PageResult pageList(PageParam param) throws Exception {
    	param.setCountSql("t_base_person.pageCount");
    	param.setRecordSql("t_base_person.pageList");
        return pageService.pageQuery(param);
    }

    /**
     * 插入人物信息记录
     * @param basePerson 人物信息对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String create(BasePerson basePerson) throws Exception  {
        sqlDao.create("t_base_person.create",basePerson);
        return "1";
    }

    /**
     * 更新人物信息记录
     * @param basePerson 人物信息对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String update(BasePerson basePerson) throws Exception {
        sqlDao.update("t_base_person.update", basePerson);
        return "1";
    }

    /**
     * 删除人物信息记录
     * @param basePerson 人物信息对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(BasePerson basePerson) throws Exception {
        sqlDao.delete("t_base_person.delete", basePerson);
        return "1";
    }

    /**
     * 删除人物信息记录
     * @param id 字符串型主键
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(String id) throws Exception {
        return delete(new BasePerson(id));
    }

    /**
     * 删除人物信息记录
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