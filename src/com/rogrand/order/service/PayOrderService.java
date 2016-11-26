package com.rogrand.order.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.rogrand.core.domain.PageResult;
import com.rogrand.core.domain.PageParam;
import com.rogrand.core.service.BaseService;
import com.rogrand.order.domain.PayOrder;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：支付宝付款订单 Service
 */
@Service("PayOrderService")
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = Throwable.class)
public class PayOrderService extends BaseService {
    /**
     * 查询支付宝付款订单对象
     * @param id 字符串型主键
     * @return PayOrder
     * @throws Exception 异常
     */
    public PayOrder query(String id) throws Exception{
    	PageParam param = new PageParam();
    	param.put("id", id);
        return sqlDao.query("t_pay_order.pageList", param);
    }

    /**
     * 查询支付宝付款订单对象集合
     * @param param 查询条件
     * @return List<PayOrder>
     * @throws Exception 异常
     */
    public List<PayOrder> list(PageParam param) throws Exception {
    	return sqlDao.list("t_pay_order.pageList",param);
    }
    
    /**
     * 支付宝付款订单翻页查询
     * @param 分页条件对象
     * @return PageResult
     * @throws Exception 异常
     */
    public PageResult pageList(PageParam param) throws Exception {
    	param.setCountSql("t_pay_order.pageCount");
    	param.setRecordSql("t_pay_order.pageList");
        return pageService.pageQuery(param);
    }

    /**
     * 插入支付宝付款订单记录
     * @param payOrder 支付宝付款订单对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String create(PayOrder payOrder) throws Exception  {
        sqlDao.create("t_pay_order.create",payOrder);
        return "1";
    }

    /**
     * 更新支付宝付款订单记录
     * @param payOrder 支付宝付款订单对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String update(PayOrder payOrder) throws Exception {
        sqlDao.update("t_pay_order.update", payOrder);
        return "1";
    }

    /**
     * 删除支付宝付款订单记录
     * @param payOrder 支付宝付款订单对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(PayOrder payOrder) throws Exception {
        sqlDao.delete("t_pay_order.delete", payOrder);
        return "1";
    }

    /**
     * 删除支付宝付款订单记录
     * @param id 字符串型主键
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(String id) throws Exception {
        return delete(new PayOrder(id));
    }

    /**
     * 删除支付宝付款订单记录
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