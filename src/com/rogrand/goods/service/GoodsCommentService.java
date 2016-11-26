package com.rogrand.goods.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.rogrand.core.domain.PageResult;
import com.rogrand.core.domain.PageParam;
import com.rogrand.core.service.BaseService;
import com.rogrand.goods.domain.GoodsComment;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：物品评论 Service
 */
@Service("GoodsCommentService")
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = Throwable.class)
public class GoodsCommentService extends BaseService {
    /**
     * 查询物品评论对象
     * @param id 字符串型主键
     * @return GoodsComment
     * @throws Exception 异常
     */
    public GoodsComment query(String id) throws Exception{
    	PageParam param = new PageParam();
    	param.put("id", id);
        return sqlDao.query("t_goods_comment.pageList", param);
    }

    /**
     * 查询物品评论对象集合
     * @param param 查询条件
     * @return List<GoodsComment>
     * @throws Exception 异常
     */
    public List<GoodsComment> list(PageParam param) throws Exception {
    	return sqlDao.list("t_goods_comment.pageList",param);
    }
    
    /**
     * 物品评论翻页查询
     * @param 分页条件对象
     * @return PageResult
     * @throws Exception 异常
     */
    public PageResult pageList(PageParam param) throws Exception {
    	param.setCountSql("t_goods_comment.pageCount");
    	param.setRecordSql("t_goods_comment.pageList");
        return pageService.pageQuery(param);
    }

    /**
     * 插入物品评论记录
     * @param goodsComment 物品评论对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String create(GoodsComment goodsComment) throws Exception  {
        sqlDao.create("t_goods_comment.create",goodsComment);
        return "1";
    }

    /**
     * 更新物品评论记录
     * @param goodsComment 物品评论对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String update(GoodsComment goodsComment) throws Exception {
        sqlDao.update("t_goods_comment.update", goodsComment);
        return "1";
    }

    /**
     * 删除物品评论记录
     * @param goodsComment 物品评论对象
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(GoodsComment goodsComment) throws Exception {
        sqlDao.delete("t_goods_comment.delete", goodsComment);
        return "1";
    }

    /**
     * 删除物品评论记录
     * @param id 字符串型主键
     * @return String
     * @throws Exception 异常
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public String delete(String id) throws Exception {
        return delete(new GoodsComment(id));
    }

    /**
     * 删除物品评论记录
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