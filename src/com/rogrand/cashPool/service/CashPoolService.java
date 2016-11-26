package com.rogrand.cashPool.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.rogrand.core.domain.PageResult;
import com.rogrand.core.domain.PageParam;
import com.rogrand.core.service.BaseService;
import com.rogrand.cashPool.domain.CashPool;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：资金池 Service
 */
@Service("CashPoolService")
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = Throwable.class)
public class CashPoolService extends BaseService {
    /**
     * 查询资金池对象
     * @param id 字符串型主键
     * @return CashPool
     * @throws Exception 异常
     */
    public CashPool query(String id) throws Exception{
    	PageParam param = new PageParam();
    	param.put("id", id);
        return sqlDao.query("t_cash_pool.pageList", param);
    }

    /**
     * 查询资金池对象集合
     * @param param 查询条件
     * @return List<CashPool>
     * @throws Exception 异常
     */
    public List<CashPool> list(PageParam param) throws Exception {
    	return sqlDao.list("t_cash_pool.pageList",param);
    }
    
    /**
     * 资金池翻页查询
     * @param 分页条件对象
     * @return PageResult
     * @throws Exception 异常
     */
    public PageResult pageList(PageParam param) throws Exception {
    	param.setCountSql("t_cash_pool.pageCount");
    	param.setRecordSql("t_cash_pool.pageList");
        return pageService.pageQuery(param);
    }

    /**
     * 插入资金池记录
     * @param cashPool 资金池对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String create(CashPool cashPool) throws Exception  {
        sqlDao.create("t_cash_pool.create",cashPool);
        return "1";
    }

    /**
     * 更新资金池记录
     * @param cashPool 资金池对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String update(CashPool cashPool) throws Exception {
        sqlDao.update("t_cash_pool.update", cashPool);
        return "1";
    }

    /**
     * 删除资金池记录
     * @param cashPool 资金池对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(CashPool cashPool) throws Exception {
        sqlDao.delete("t_cash_pool.delete", cashPool);
        return "1";
    }

    /**
     * 删除资金池记录
     * @param id 字符串型主键
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(String id) throws Exception {
        return delete(new CashPool(id));
    }

    /**
     * 删除资金池记录
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