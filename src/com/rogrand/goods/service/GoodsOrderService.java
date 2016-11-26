package com.rogrand.goods.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.rogrand.core.domain.PageResult;
import com.rogrand.core.domain.PageParam;
import com.rogrand.core.service.BaseService;
import com.rogrand.goods.domain.GoodsOrder;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：商品订单 Service
 */
@Service("GoodsOrderService")
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = Throwable.class)
public class GoodsOrderService extends BaseService {
    /**
     * 查询商品订单对象
     * @param id 字符串型主键
     * @return GoodsOrder
     * @throws Exception 异常
     */
    public GoodsOrder query(String id) throws Exception{
    	PageParam param = new PageParam();
    	param.put("id", id);
        return sqlDao.query("t_goods_order.pageList", param);
    }

    /**
     * 查询商品订单对象集合
     * @param param 查询条件
     * @return List<GoodsOrder>
     * @throws Exception 异常
     */
    public List<GoodsOrder> list(PageParam param) throws Exception {
    	return sqlDao.list("t_goods_order.pageList",param);
    }
    
    /**
     * 商品订单翻页查询
     * @param 分页条件对象
     * @return PageResult
     * @throws Exception 异常
     */
    public PageResult pageList(PageParam param) throws Exception {
    	param.setCountSql("t_goods_order.pageCount");
    	param.setRecordSql("t_goods_order.pageList");
        return pageService.pageQuery(param);
    }

    /**
     * 插入商品订单记录
     * @param goodsOrder 商品订单对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String create(GoodsOrder goodsOrder) throws Exception  {
        sqlDao.create("t_goods_order.create",goodsOrder);
        return "1";
    }

    /**
     * 更新商品订单记录
     * @param goodsOrder 商品订单对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String update(GoodsOrder goodsOrder) throws Exception {
        sqlDao.update("t_goods_order.update", goodsOrder);
        return "1";
    }

    /**
     * 删除商品订单记录
     * @param goodsOrder 商品订单对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(GoodsOrder goodsOrder) throws Exception {
        sqlDao.delete("t_goods_order.delete", goodsOrder);
        return "1";
    }

    /**
     * 删除商品订单记录
     * @param id 字符串型主键
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(String id) throws Exception {
        return delete(new GoodsOrder(id));
    }

    /**
     * 删除商品订单记录
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