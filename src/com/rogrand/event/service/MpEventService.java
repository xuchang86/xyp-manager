package com.rogrand.event.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.rogrand.core.domain.PageResult;
import com.rogrand.core.domain.PageParam;
import com.rogrand.core.service.BaseService;
import com.rogrand.event.domain.MpEvent;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：门派事件 Service
 */
@Service("MpEventService")
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = Throwable.class)
public class MpEventService extends BaseService {
    /**
     * 查询门派事件对象
     * @param id 字符串型主键
     * @return MpEvent
     * @throws Exception 异常
     */
    public MpEvent query(String id) throws Exception{
    	PageParam param = new PageParam();
    	param.put("id", id);
        return sqlDao.query("t_mp_event.pageList", param);
    }

    /**
     * 查询门派事件对象集合
     * @param param 查询条件
     * @return List<MpEvent>
     * @throws Exception 异常
     */
    public List<MpEvent> list(PageParam param) throws Exception {
    	return sqlDao.list("t_mp_event.pageList",param);
    }
    
    /**
     * 门派事件翻页查询
     * @param 分页条件对象
     * @return PageResult
     * @throws Exception 异常
     */
    public PageResult pageList(PageParam param) throws Exception {
    	param.setCountSql("t_mp_event.pageCount");
    	param.setRecordSql("t_mp_event.pageList");
        return pageService.pageQuery(param);
    }

    /**
     * 插入门派事件记录
     * @param mpEvent 门派事件对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String create(MpEvent mpEvent) throws Exception  {
        sqlDao.create("t_mp_event.create",mpEvent);
        return "1";
    }

    /**
     * 更新门派事件记录
     * @param mpEvent 门派事件对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String update(MpEvent mpEvent) throws Exception {
        sqlDao.update("t_mp_event.update", mpEvent);
        return "1";
    }

    /**
     * 删除门派事件记录
     * @param mpEvent 门派事件对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(MpEvent mpEvent) throws Exception {
        sqlDao.delete("t_mp_event.delete", mpEvent);
        return "1";
    }

    /**
     * 删除门派事件记录
     * @param id 字符串型主键
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(String id) throws Exception {
        return delete(new MpEvent(id));
    }

    /**
     * 删除门派事件记录
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