package com.rogrand.cashPool.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.rogrand.core.domain.PageResult;
import com.rogrand.core.domain.PageParam;
import com.rogrand.core.service.BaseService;
import com.rogrand.cashPool.domain.BankAccount;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-12-10 <br/>
 * 描述：银行账户信息 Service
 */
@Service("BankAccountService")
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = Throwable.class)
public class BankAccountService extends BaseService {
    /**
     * 查询银行账户信息对象
     * @param id 字符串型主键
     * @return BankAccount
     * @throws Exception 异常
     */
    public BankAccount query(String id) throws Exception{
    	PageParam param = new PageParam();
    	param.put("id", id);
        return sqlDao.query("t_bank_account.pageList", param);
    }

    /**
     * 查询银行账户信息对象集合
     * @param param 查询条件
     * @return List<BankAccount>
     * @throws Exception 异常
     */
    public List<BankAccount> list(PageParam param) throws Exception {
    	return sqlDao.list("t_bank_account.pageList",param);
    }
    
    /**
     * 银行账户信息翻页查询
     * @param 分页条件对象
     * @return PageResult
     * @throws Exception 异常
     */
    public PageResult pageList(PageParam param) throws Exception {
    	param.setCountSql("t_bank_account.pageCount");
    	param.setRecordSql("t_bank_account.pageList");
        return pageService.pageQuery(param);
    }

    /**
     * 插入银行账户信息记录
     * @param bankAccount 银行账户信息对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String create(BankAccount bankAccount) throws Exception  {
        sqlDao.create("t_bank_account.create",bankAccount);
        return "1";
    }

    /**
     * 更新银行账户信息记录
     * @param bankAccount 银行账户信息对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String update(BankAccount bankAccount) throws Exception {
        sqlDao.update("t_bank_account.update", bankAccount);
        return "1";
    }

    /**
     * 删除银行账户信息记录
     * @param bankAccount 银行账户信息对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(BankAccount bankAccount) throws Exception {
        sqlDao.delete("t_bank_account.delete", bankAccount);
        return "1";
    }

    /**
     * 删除银行账户信息记录
     * @param id 字符串型主键
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(String id) throws Exception {
        return delete(new BankAccount(id));
    }

    /**
     * 删除银行账户信息记录
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