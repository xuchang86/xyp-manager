package com.rogrand.goods.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.rogrand.core.domain.PageResult;
import com.rogrand.core.domain.PageParam;
import com.rogrand.core.service.BaseService;
import com.rogrand.goods.domain.MallGoods;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：商城商品 Service
 */
@Service("MallGoodsService")
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = Throwable.class)
public class MallGoodsService extends BaseService {
    /**
     * 查询商城商品对象
     * @param id 字符串型主键
     * @return MallGoods
     * @throws Exception 异常
     */
    public MallGoods query(String id) throws Exception{
    	PageParam param = new PageParam();
    	param.put("id", id);
        return sqlDao.query("t_mall_goods.pageList", param);
    }

    /**
     * 查询商城商品对象集合
     * @param param 查询条件
     * @return List<MallGoods>
     * @throws Exception 异常
     */
    public List<MallGoods> list(PageParam param) throws Exception {
    	return sqlDao.list("t_mall_goods.pageList",param);
    }
    
    /**
     * 商城商品翻页查询
     * @param 分页条件对象
     * @return PageResult
     * @throws Exception 异常
     */
    public PageResult pageList(PageParam param) throws Exception {
    	param.setCountSql("t_mall_goods.pageCount");
    	param.setRecordSql("t_mall_goods.pageList");
        return pageService.pageQuery(param);
    }

    /**
     * 插入商城商品记录
     * @param mallGoods 商城商品对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String create(MallGoods mallGoods) throws Exception  {
        sqlDao.create("t_mall_goods.create",mallGoods);
        return "1";
    }

    /**
     * 更新商城商品记录
     * @param mallGoods 商城商品对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String update(MallGoods mallGoods) throws Exception {
        sqlDao.update("t_mall_goods.update", mallGoods);
        return "1";
    }

    /**
     * 删除商城商品记录
     * @param mallGoods 商城商品对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(MallGoods mallGoods) throws Exception {
        sqlDao.delete("t_mall_goods.delete", mallGoods);
        return "1";
    }

    /**
     * 删除商城商品记录
     * @param id 字符串型主键
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(String id) throws Exception {
        return delete(new MallGoods(id));
    }

    /**
     * 删除商城商品记录
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