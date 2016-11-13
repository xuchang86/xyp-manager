package com.rogrand.goods.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.rogrand.core.domain.PageResult;
import com.rogrand.core.domain.PageParam;
import com.rogrand.core.service.BaseService;
import com.rogrand.goods.domain.GoodsSeller;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：卖家信息 Service
 */
@Service("GoodsSellerService")
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = Throwable.class)
public class GoodsSellerService extends BaseService {
    /**
     * 查询卖家信息对象
     * @param id 字符串型主键
     * @return GoodsSeller
     * @throws Exception 异常
     */
    public GoodsSeller query(String id) throws Exception{
    	PageParam param = new PageParam();
    	param.put("id", id);
        return sqlDao.query("t_goods_seller.pageList", param);
    }

    /**
     * 查询卖家信息对象集合
     * @param param 查询条件
     * @return List<GoodsSeller>
     * @throws Exception 异常
     */
    public List<GoodsSeller> list(PageParam param) throws Exception {
    	return sqlDao.list("t_goods_seller.pageList",param);
    }
    
    /**
     * 卖家信息翻页查询
     * @param 分页条件对象
     * @return PageResult
     * @throws Exception 异常
     */
    public PageResult pageList(PageParam param) throws Exception {
    	param.setCountSql("t_goods_seller.pageCount");
    	param.setRecordSql("t_goods_seller.pageList");
        return pageService.pageQuery(param);
    }

    /**
     * 插入卖家信息记录
     * @param goodsSeller 卖家信息对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String create(GoodsSeller goodsSeller) throws Exception  {
        sqlDao.create("t_goods_seller.create",goodsSeller);
        return "1";
    }

    /**
     * 更新卖家信息记录
     * @param goodsSeller 卖家信息对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String update(GoodsSeller goodsSeller) throws Exception {
        sqlDao.update("t_goods_seller.update", goodsSeller);
        return "1";
    }

    /**
     * 删除卖家信息记录
     * @param goodsSeller 卖家信息对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(GoodsSeller goodsSeller) throws Exception {
        sqlDao.delete("t_goods_seller.delete", goodsSeller);
        return "1";
    }

    /**
     * 删除卖家信息记录
     * @param id 字符串型主键
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(String id) throws Exception {
        return delete(new GoodsSeller(id));
    }

    /**
     * 删除卖家信息记录
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