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
import com.rogrand.goods.domain.MallGoods;
import com.rogrand.goods.service.MallGoodsService;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：商城商品 Controller
 */
@Controller("MallGoodsController")
@RequestMapping("/goods/mallGoods_*.do")
public class MallGoodsController extends BaseController{

    @Autowired
    @Qualifier("MallGoodsService")
    private MallGoodsService mallGoodsService;

    @ActionAnnotation(name = "商城商品入口",group = "查询")
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "商城商品分页",group = "查询")
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PageParam mallGoods = BeanUtil.wrapPageBean(request);
        PageResult pageResult = mallGoodsService.pageList(mallGoods);
        return responseText(response, EasyuiUtil.toDataGridData(pageResult));
    }

    @ActionAnnotation(name = "商城商品详细",group = "查询")
    public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        MallGoods mallGoods = mallGoodsService.query(request.getParameter("id"));
        model.put("mallGoods",mallGoods);
        return getView(request,model);
    }

    @ActionAnnotation(name = "商城商品添加",group = "添加")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "商城商品添加保存",group = "添加",log = true)
    public ModelAndView addSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MallGoods mallGoods = BeanUtil.wrapBean(MallGoods.class, request.getParameter("mallGoods"));
        String result = mallGoodsService.create(mallGoods);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "商城商品修改",group = "修改")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        MallGoods mallGoods = mallGoodsService.query(request.getParameter("id"));
        model.put("mallGoods",mallGoods);
        return getView(request,model);
    }

    @ActionAnnotation(name = "商城商品修改保存",group = "修改",log = true)
    public ModelAndView editSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MallGoods mallGoods = BeanUtil.wrapBean(MallGoods.class, request.getParameter("mallGoods"));
        String result = mallGoodsService.update(mallGoods);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "商城商品删除",group = "删除",log = true)
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = mallGoodsService.delete(request.getParameter("id"));
        return responseText(response, result);
    }

    @ActionAnnotation(name = "商城商品批量删除",group = "删除",log = true)
    public ModelAndView deleteBatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = BeanUtil.wrapArray(String.class, request.getParameter("ids"));
        String result = mallGoodsService.delete(ids);
        return responseText(response, result);
    }
}
