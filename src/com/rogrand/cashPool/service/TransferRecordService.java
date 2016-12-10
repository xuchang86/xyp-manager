package com.rogrand.cashPool.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.rogrand.core.domain.PageResult;
import com.rogrand.core.domain.PageParam;
import com.rogrand.core.service.BaseService;
import com.rogrand.cashPool.domain.TransferRecord;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-12-10 <br/>
 * 描述：提现记录 Service
 */
@Service("TransferRecordService")
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = Throwable.class)
public class TransferRecordService extends BaseService {
    /**
     * 查询提现记录对象
     * @param id 字符串型主键
     * @return TransferRecord
     * @throws Exception 异常
     */
    public TransferRecord query(String id) throws Exception{
    	PageParam param = new PageParam();
    	param.put("id", id);
        return sqlDao.query("t_transfer_record.pageList", param);
    }

    /**
     * 查询提现记录对象集合
     * @param param 查询条件
     * @return List<TransferRecord>
     * @throws Exception 异常
     */
    public List<TransferRecord> list(PageParam param) throws Exception {
    	return sqlDao.list("t_transfer_record.pageList",param);
    }
    
    /**
     * 提现记录翻页查询
     * @param 分页条件对象
     * @return PageResult
     * @throws Exception 异常
     */
    public PageResult pageList(PageParam param) throws Exception {
    	param.setCountSql("t_transfer_record.pageCount");
    	param.setRecordSql("t_transfer_record.pageList");
        return pageService.pageQuery(param);
    }

    /**
     * 插入提现记录记录
     * @param transferRecord 提现记录对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String create(TransferRecord transferRecord) throws Exception  {
        sqlDao.create("t_transfer_record.create",transferRecord);
        return "1";
    }

    /**
     * 更新提现记录记录
     * @param transferRecord 提现记录对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String update(TransferRecord transferRecord) throws Exception {
        sqlDao.update("t_transfer_record.update", transferRecord);
        return "1";
    }

    /**
     * 删除提现记录记录
     * @param transferRecord 提现记录对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(TransferRecord transferRecord) throws Exception {
        sqlDao.delete("t_transfer_record.delete", transferRecord);
        return "1";
    }

    /**
     * 删除提现记录记录
     * @param id 字符串型主键
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(String id) throws Exception {
        return delete(new TransferRecord(id));
    }

    /**
     * 删除提现记录记录
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