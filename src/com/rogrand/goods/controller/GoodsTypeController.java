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
import com.rogrand.goods.domain.GoodsType;
import com.rogrand.goods.service.GoodsTypeService;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：商品类别 Controller
 */
@Controller("GoodsTypeController")
@RequestMapping("/goods/goodsType_*.do")
public class GoodsTypeController extends BaseController{

    @Autowired
    @Qualifier("GoodsTypeService")
    private GoodsTypeService goodsTypeService;

    @ActionAnnotation(name = "商品类别入口",group = "查询")
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "商品类别分页",group = "查询")
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PageParam goodsType = BeanUtil.wrapPageBean(request);
        PageResult pageResult = goodsTypeService.pageList(goodsType);
        return responseText(response, EasyuiUtil.toDataGridData(pageResult));
    }

    @ActionAnnotation(name = "商品类别详细",group = "查询")
    public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        GoodsType goodsType = goodsTypeService.query(request.getParameter("id"));
        model.put("goodsType",goodsType);
        return getView(request,model);
    }

    @ActionAnnotation(name = "商品类别添加",group = "添加")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "商品类别添加保存",group = "添加",log = true)
    public ModelAndView addSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        GoodsType goodsType = BeanUtil.wrapBean(GoodsType.class, request.getParameter("goodsType"));
        String result = goodsTypeService.create(goodsType);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "商品类别修改",group = "修改")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        GoodsType goodsType = goodsTypeService.query(request.getParameter("id"));
        model.put("goodsType",goodsType);
        return getView(request,model);
    }

    @ActionAnnotation(name = "商品类别修改保存",group = "修改",log = true)
    public ModelAndView editSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        GoodsType goodsType = BeanUtil.wrapBean(GoodsType.class, request.getParameter("goodsType"));
        String result = goodsTypeService.update(goodsType);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "商品类别删除",group = "删除",log = true)
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = goodsTypeService.delete(request.getParameter("id"));
        return responseText(response, result);
    }

    @ActionAnnotation(name = "商品类别批量删除",group = "删除",log = true)
    public ModelAndView deleteBatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = BeanUtil.wrapArray(String.class, request.getParameter("ids"));
        String result = goodsTypeService.delete(ids);
        return responseText(response, result);
    }
}
