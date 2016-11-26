package com.rogrand.publish.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.rogrand.core.domain.PageResult;
import com.rogrand.core.domain.PageParam;
import com.rogrand.core.service.BaseService;
import com.rogrand.publish.domain.ActivityPerson;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：活动参与人 Service
 */
@Service("ActivityPersonService")
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = Throwable.class)
public class ActivityPersonService extends BaseService {
    /**
     * 查询活动参与人对象
     * @param id 字符串型主键
     * @return ActivityPerson
     * @throws Exception 异常
     */
    public ActivityPerson query(String id) throws Exception{
    	PageParam param = new PageParam();
    	param.put("id", id);
        return sqlDao.query("t_activity_person.pageList", param);
    }

    /**
     * 查询活动参与人对象集合
     * @param param 查询条件
     * @return List<ActivityPerson>
     * @throws Exception 异常
     */
    public List<ActivityPerson> list(PageParam param) throws Exception {
    	return sqlDao.list("t_activity_person.pageList",param);
    }
    
    /**
     * 活动参与人翻页查询
     * @param 分页条件对象
     * @return PageResult
     * @throws Exception 异常
     */
    public PageResult pageList(PageParam param) throws Exception {
    	param.setCountSql("t_activity_person.pageCount");
    	param.setRecordSql("t_activity_person.pageList");
        return pageService.pageQuery(param);
    }

    /**
     * 插入活动参与人记录
     * @param activityPerson 活动参与人对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String create(ActivityPerson activityPerson) throws Exception  {
        sqlDao.create("t_activity_person.create",activityPerson);
        return "1";
    }

    /**
     * 更新活动参与人记录
     * @param activityPerson 活动参与人对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String update(ActivityPerson activityPerson) throws Exception {
        sqlDao.update("t_activity_person.update", activityPerson);
        return "1";
    }

    /**
     * 删除活动参与人记录
     * @param activityPerson 活动参与人对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(ActivityPerson activityPerson) throws Exception {
        sqlDao.delete("t_activity_person.delete", activityPerson);
        return "1";
    }

    /**
     * 删除活动参与人记录
     * @param id 字符串型主键
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(String id) throws Exception {
        return delete(new ActivityPerson(id));
    }

    /**
     * 删除活动参与人记录
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