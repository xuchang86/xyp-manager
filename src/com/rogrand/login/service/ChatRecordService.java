package com.rogrand.login.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.rogrand.core.domain.PageResult;
import com.rogrand.core.domain.PageParam;
import com.rogrand.core.service.BaseService;
import com.rogrand.login.domain.ChatRecord;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-12-29 <br/>
 * 描述：聊天记录 Service
 */
@Service("ChatRecordService")
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = Throwable.class)
public class ChatRecordService extends BaseService {
    /**
     * 查询聊天记录对象
     * @param id 字符串型主键
     * @return ChatRecord
     * @throws Exception 异常
     */
    public ChatRecord query(String id) throws Exception{
    	PageParam param = new PageParam();
    	param.put("id", id);
        return sqlDao.query("t_chat_record.pageList", param);
    }

    /**
     * 查询聊天记录对象集合
     * @param param 查询条件
     * @return List<ChatRecord>
     * @throws Exception 异常
     */
    public List<ChatRecord> list(PageParam param) throws Exception {
    	return sqlDao.list("t_chat_record.pageList",param);
    }
    
    /**
     * 聊天记录翻页查询
     * @param 分页条件对象
     * @return PageResult
     * @throws Exception 异常
     */
    public PageResult pageList(PageParam param) throws Exception {
    	param.setCountSql("t_chat_record.pageCount");
    	param.setRecordSql("t_chat_record.pageList");
        return pageService.pageQuery(param);
    }

    /**
     * 插入聊天记录记录
     * @param chatRecord 聊天记录对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String create(ChatRecord chatRecord) throws Exception  {
        sqlDao.create("t_chat_record.create",chatRecord);
        return "1";
    }

    /**
     * 更新聊天记录记录
     * @param chatRecord 聊天记录对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String update(ChatRecord chatRecord) throws Exception {
        sqlDao.update("t_chat_record.update", chatRecord);
        return "1";
    }

    /**
     * 删除聊天记录记录
     * @param chatRecord 聊天记录对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(ChatRecord chatRecord) throws Exception {
        sqlDao.delete("t_chat_record.delete", chatRecord);
        return "1";
    }

    /**
     * 删除聊天记录记录
     * @param id 字符串型主键
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(String id) throws Exception {
        return delete(new ChatRecord(id));
    }

    /**
     * 删除聊天记录记录
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