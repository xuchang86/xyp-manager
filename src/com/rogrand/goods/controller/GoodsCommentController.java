package com.rogrand.goods.controller;

import java.util.Map;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.rogrand.core.annotation.ActionAnnotation;
import com.rogrand.core.controller.BaseController;
import com.rogrand.core.domain.PageResult;
import com.rogrand.core.domain.PageParam;
import com.rogrand.core.util.BeanUtil;
import com.rogrand.core.util.EasyuiUtil;
import com.rogrand.goods.domain.GoodsComment;
import com.rogrand.goods.service.GoodsCommentService;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：物品评论 Controller
 */
@Controller("GoodsCommentController")
@RequestMapping("/goods/goodsComment_*.do")
public class GoodsCommentController extends BaseController{

    @Autowired
    @Qualifier("GoodsCommentService")
    private GoodsCommentService goodsCommentService;

    @ActionAnnotation(name = "物品评论入口",group = "查询")
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "物品评论分页",group = "查询")
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PageParam goodsComment = BeanUtil.wrapPageBean(request);
        PageResult pageResult = goodsCommentService.pageList(goodsComment);
        return responseText(response, EasyuiUtil.toDataGridData(pageResult));
    }

    @ActionAnnotation(name = "物品评论详细",group = "查询")
    public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        GoodsComment goodsComment = goodsCommentService.query(request.getParameter("id"));
        model.put("goodsComment",goodsComment);
        return getView(request,model);
    }

    @ActionAnnotation(name = "物品评论添加",group = "添加")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "物品评论添加保存",group = "添加",log = true)
    public ModelAndView addSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        GoodsComment goodsComment = BeanUtil.wrapBean(GoodsComment.class, request.getParameter("goodsComment"));
        String result = goodsCommentService.create(goodsComment);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "物品评论修改",group = "修改")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        GoodsComment goodsComment = goodsCommentService.query(request.getParameter("id"));
        model.put("goodsComment",goodsComment);
        return getView(request,model);
    }

    @ActionAnnotation(name = "物品评论修改保存",group = "修改",log = true)
    public ModelAndView editSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        GoodsComment goodsComment = BeanUtil.wrapBean(GoodsComment.class, request.getParameter("goodsComment"));
        String result = goodsCommentService.update(goodsComment);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "物品评论删除",group = "删除",log = true)
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = goodsCommentService.delete(request.getParameter("id"));
        return responseText(response, result);
    }

    @ActionAnnotation(name = "物品评论批量删除",group = "删除",log = true)
    public ModelAndView deleteBatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = BeanUtil.wrapArray(String.class, request.getParameter("ids"));
        String result = goodsCommentService.delete(ids);
        return responseText(response, result);
    }
}
