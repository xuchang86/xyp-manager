package com.rogrand.publish.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.rogrand.core.domain.PageResult;
import com.rogrand.core.domain.PageParam;
import com.rogrand.core.service.BaseService;
import com.rogrand.publish.domain.PublishActivity;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：发布的活动,任务,悬赏 Service
 */
@Service("PublishActivityService")
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = Throwable.class)
public class PublishActivityService extends BaseService {
    /**
     * 查询发布的活动,任务,悬赏对象
     * @param id 字符串型主键
     * @return PublishActivity
     * @throws Exception 异常
     */
    public PublishActivity query(String id) throws Exception{
    	PageParam param = new PageParam();
    	param.put("id", id);
        return sqlDao.query("t_publish_activity.pageList", param);
    }

    /**
     * 查询发布的活动,任务,悬赏对象集合
     * @param param 查询条件
     * @return List<PublishActivity>
     * @throws Exception 异常
     */
    public List<PublishActivity> list(PageParam param) throws Exception {
    	return sqlDao.list("t_publish_activity.pageList",param);
    }
    
    /**
     * 发布的活动,任务,悬赏翻页查询
     * @param 分页条件对象
     * @return PageResult
     * @throws Exception 异常
     */
    public PageResult pageList(PageParam param) throws Exception {
    	param.setCountSql("t_publish_activity.pageCount");
    	param.setRecordSql("t_publish_activity.pageList");
        return pageService.pageQuery(param);
    }

    /**
     * 插入发布的活动,任务,悬赏记录
     * @param publishActivity 发布的活动,任务,悬赏对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String create(PublishActivity publishActivity) throws Exception  {
        sqlDao.create("t_publish_activity.create",publishActivity);
        return "1";
    }

    /**
     * 更新发布的活动,任务,悬赏记录
     * @param publishActivity 发布的活动,任务,悬赏对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String update(PublishActivity publishActivity) throws Exception {
        sqlDao.update("t_publish_activity.update", publishActivity);
        return "1";
    }

    /**
     * 删除发布的活动,任务,悬赏记录
     * @param publishActivity 发布的活动,任务,悬赏对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(PublishActivity publishActivity) throws Exception {
        sqlDao.delete("t_publish_activity.delete", publishActivity);
        return "1";
    }

    /**
     * 删除发布的活动,任务,悬赏记录
     * @param id 字符串型主键
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(String id) throws Exception {
        return delete(new PublishActivity(id));
    }

    /**
     * 删除发布的活动,任务,悬赏记录
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