package com.rogrand.goods.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.rogrand.core.domain.PageResult;
import com.rogrand.core.domain.PageParam;
import com.rogrand.core.service.BaseService;
import com.rogrand.goods.domain.UserAddress;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-30 <br/>
 * 描述：个人收货地址 Service
 */
@Service("UserAddressService")
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = Throwable.class)
public class UserAddressService extends BaseService {
    /**
     * 查询个人收货地址对象
     * @param id 字符串型主键
     * @return UserAddress
     * @throws Exception 异常
     */
    public UserAddress query(String id) throws Exception{
    	PageParam param = new PageParam();
    	param.put("id", id);
        return sqlDao.query("t_user_address.pageList", param);
    }

    /**
     * 查询个人收货地址对象集合
     * @param param 查询条件
     * @return List<UserAddress>
     * @throws Exception 异常
     */
    public List<UserAddress> list(PageParam param) throws Exception {
    	return sqlDao.list("t_user_address.pageList",param);
    }
    
    /**
     * 个人收货地址翻页查询
     * @param 分页条件对象
     * @return PageResult
     * @throws Exception 异常
     */
    public PageResult pageList(PageParam param) throws Exception {
    	param.setCountSql("t_user_address.pageCount");
    	param.setRecordSql("t_user_address.pageList");
        return pageService.pageQuery(param);
    }

    /**
     * 插入个人收货地址记录
     * @param userAddress 个人收货地址对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String create(UserAddress userAddress) throws Exception  {
        sqlDao.create("t_user_address.create",userAddress);
        return "1";
    }

    /**
     * 更新个人收货地址记录
     * @param userAddress 个人收货地址对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String update(UserAddress userAddress) throws Exception {
        sqlDao.update("t_user_address.update", userAddress);
        return "1";
    }

    /**
     * 删除个人收货地址记录
     * @param userAddress 个人收货地址对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(UserAddress userAddress) throws Exception {
        sqlDao.delete("t_user_address.delete", userAddress);
        return "1";
    }

    /**
     * 删除个人收货地址记录
     * @param id 字符串型主键
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(String id) throws Exception {
        return delete(new UserAddress(id));
    }

    /**
     * 删除个人收货地址记录
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