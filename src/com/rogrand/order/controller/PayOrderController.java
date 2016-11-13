package com.rogrand.order.controller;

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
import com.rogrand.order.domain.PayOrder;
import com.rogrand.order.service.PayOrderService;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：支付宝付款订单 Controller
 */
@Controller("PayOrderController")
@RequestMapping("/order/payOrder_*.do")
public class PayOrderController extends BaseController{

    @Autowired
    @Qualifier("PayOrderService")
    private PayOrderService payOrderService;

    @ActionAnnotation(name = "支付宝付款订单入口",group = "查询")
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "支付宝付款订单分页",group = "查询")
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PageParam payOrder = BeanUtil.wrapPageBean(request);
        PageResult pageResult = payOrderService.pageList(payOrder);
        return responseText(response, EasyuiUtil.toDataGridData(pageResult));
    }

    @ActionAnnotation(name = "支付宝付款订单详细",group = "查询")
    public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        PayOrder payOrder = payOrderService.query(request.getParameter("id"));
        model.put("payOrder",payOrder);
        return getView(request,model);
    }

    @ActionAnnotation(name = "支付宝付款订单添加",group = "添加")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "支付宝付款订单添加保存",group = "添加",log = true)
    public ModelAndView addSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PayOrder payOrder = BeanUtil.wrapBean(PayOrder.class, request.getParameter("payOrder"));
        String result = payOrderService.create(payOrder);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "支付宝付款订单修改",group = "修改")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        PayOrder payOrder = payOrderService.query(request.getParameter("id"));
        model.put("payOrder",payOrder);
        return getView(request,model);
    }

    @ActionAnnotation(name = "支付宝付款订单修改保存",group = "修改",log = true)
    public ModelAndView editSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PayOrder payOrder = BeanUtil.wrapBean(PayOrder.class, request.getParameter("payOrder"));
        String result = payOrderService.update(payOrder);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "支付宝付款订单删除",group = "删除",log = true)
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = payOrderService.delete(request.getParameter("id"));
        return responseText(response, result);
    }

    @ActionAnnotation(name = "支付宝付款订单批量删除",group = "删除",log = true)
    public ModelAndView deleteBatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = BeanUtil.wrapArray(String.class, request.getParameter("ids"));
        String result = payOrderService.delete(ids);
        return responseText(response, result);
    }
}
