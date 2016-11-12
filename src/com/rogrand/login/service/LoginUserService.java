package com.rogrand.login.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.rogrand.core.domain.PageResult;
import com.rogrand.core.domain.PageParam;
import com.rogrand.core.service.BaseService;
import com.rogrand.login.domain.LoginUser;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-12 <br/>
 * 描述：逍遥派用户 Service
 */
@Service("LoginUserService")
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = Throwable.class)
public class LoginUserService extends BaseService {
    /**
     * 查询逍遥派用户对象
     * @param id 字符串型主键
     * @return LoginUser
     * @throws Exception 异常
     */
    public LoginUser query(String id) throws Exception{
    	PageParam param = new PageParam();
    	param.put("id", id);
        return sqlDao.query("t_login_user.pageList", param);
    }

    /**
     * 查询逍遥派用户对象集合
     * @param param 查询条件
     * @return List<LoginUser>
     * @throws Exception 异常
     */
    public List<LoginUser> list(PageParam param) throws Exception {
    	return sqlDao.list("t_login_user.pageList",param);
    }
    
    /**
     * 逍遥派用户翻页查询
     * @param 分页条件对象
     * @return PageResult
     * @throws Exception 异常
     */
    public PageResult pageList(PageParam param) throws Exception {
    	param.setCountSql("t_login_user.pageCount");
    	param.setRecordSql("t_login_user.pageList");
        return pageService.pageQuery(param);
    }

    /**
     * 插入逍遥派用户记录
     * @param loginUser 逍遥派用户对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String create(LoginUser loginUser) throws Exception  {
        sqlDao.create("t_login_user.create",loginUser);
        return "1";
    }

    /**
     * 更新逍遥派用户记录
     * @param loginUser 逍遥派用户对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String update(LoginUser loginUser) throws Exception {
        sqlDao.update("t_login_user.update", loginUser);
        return "1";
    }

    /**
     * 删除逍遥派用户记录
     * @param loginUser 逍遥派用户对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(LoginUser loginUser) throws Exception {
        sqlDao.delete("t_login_user.delete", loginUser);
        return "1";
    }

    /**
     * 删除逍遥派用户记录
     * @param id 字符串型主键
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(String id) throws Exception {
        return delete(new LoginUser(id));
    }

    /**
     * 删除逍遥派用户记录
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