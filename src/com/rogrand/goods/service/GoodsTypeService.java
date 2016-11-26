package com.rogrand.goods.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.rogrand.core.domain.PageResult;
import com.rogrand.core.domain.PageParam;
import com.rogrand.core.service.BaseService;
import com.rogrand.goods.domain.GoodsType;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：商品类别 Service
 */
@Service("GoodsTypeService")
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = Throwable.class)
public class GoodsTypeService extends BaseService {
    /**
     * 查询商品类别对象
     * @param id 字符串型主键
     * @return GoodsType
     * @throws Exception 异常
     */
    public GoodsType query(String id) throws Exception{
    	PageParam param = new PageParam();
    	param.put("id", id);
        return sqlDao.query("t_goods_type.pageList", param);
    }

    /**
     * 查询商品类别对象集合
     * @param param 查询条件
     * @return List<GoodsType>
     * @throws Exception 异常
     */
    public List<GoodsType> list(PageParam param) throws Exception {
    	return sqlDao.list("t_goods_type.pageList",param);
    }
    
    /**
     * 商品类别翻页查询
     * @param 分页条件对象
     * @return PageResult
     * @throws Exception 异常
     */
    public PageResult pageList(PageParam param) throws Exception {
    	param.setCountSql("t_goods_type.pageCount");
    	param.setRecordSql("t_goods_type.pageList");
        return pageService.pageQuery(param);
    }

    /**
     * 插入商品类别记录
     * @param goodsType 商品类别对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String create(GoodsType goodsType) throws Exception  {
        sqlDao.create("t_goods_type.create",goodsType);
        return "1";
    }

    /**
     * 更新商品类别记录
     * @param goodsType 商品类别对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String update(GoodsType goodsType) throws Exception {
        sqlDao.update("t_goods_type.update", goodsType);
        return "1";
    }

    /**
     * 删除商品类别记录
     * @param goodsType 商品类别对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(GoodsType goodsType) throws Exception {
        sqlDao.delete("t_goods_type.delete", goodsType);
        return "1";
    }

    /**
     * 删除商品类别记录
     * @param id 字符串型主键
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(String id) throws Exception {
        return delete(new GoodsType(id));
    }

    /**
     * 删除商品类别记录
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