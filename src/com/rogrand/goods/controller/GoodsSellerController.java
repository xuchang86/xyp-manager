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
import com.rogrand.goods.domain.GoodsSeller;
import com.rogrand.goods.service.GoodsSellerService;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：卖家信息 Controller
 */
@Controller("GoodsSellerController")
@RequestMapping("/goods/goodsSeller_*.do")
public class GoodsSellerController extends BaseController{

    @Autowired
    @Qualifier("GoodsSellerService")
    private GoodsSellerService goodsSellerService;

    @ActionAnnotation(name = "卖家信息入口",group = "查询")
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "卖家信息分页",group = "查询")
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PageParam goodsSeller = BeanUtil.wrapPageBean(request);
        PageResult pageResult = goodsSellerService.pageList(goodsSeller);
        return responseText(response, EasyuiUtil.toDataGridData(pageResult));
    }

    @ActionAnnotation(name = "卖家信息详细",group = "查询")
    public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        GoodsSeller goodsSeller = goodsSellerService.query(request.getParameter("id"));
        model.put("goodsSeller",goodsSeller);
        return getView(request,model);
    }

    @ActionAnnotation(name = "卖家信息添加",group = "添加")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "卖家信息添加保存",group = "添加",log = true)
    public ModelAndView addSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        GoodsSeller goodsSeller = BeanUtil.wrapBean(GoodsSeller.class, request.getParameter("goodsSeller"));
        String result = goodsSellerService.create(goodsSeller);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "卖家信息修改",group = "修改")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        GoodsSeller goodsSeller = goodsSellerService.query(request.getParameter("id"));
        model.put("goodsSeller",goodsSeller);
        return getView(request,model);
    }

    @ActionAnnotation(name = "卖家信息修改保存",group = "修改",log = true)
    public ModelAndView editSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        GoodsSeller goodsSeller = BeanUtil.wrapBean(GoodsSeller.class, request.getParameter("goodsSeller"));
        String result = goodsSellerService.update(goodsSeller);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "卖家信息删除",group = "删除",log = true)
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = goodsSellerService.delete(request.getParameter("id"));
        return responseText(response, result);
    }

    @ActionAnnotation(name = "卖家信息批量删除",group = "删除",log = true)
    public ModelAndView deleteBatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = BeanUtil.wrapArray(String.class, request.getParameter("ids"));
        String result = goodsSellerService.delete(ids);
        return responseText(response, result);
    }
}
