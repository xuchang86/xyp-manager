package com.rogrand.cashPool.controller;

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
import com.rogrand.cashPool.domain.CashPool;
import com.rogrand.cashPool.service.CashPoolService;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：资金池 Controller
 */
@Controller("CashPoolController")
@RequestMapping("/cashPool/cashPool_*.do")
public class CashPoolController extends BaseController{

    @Autowired
    @Qualifier("CashPoolService")
    private CashPoolService cashPoolService;

    @ActionAnnotation(name = "资金池入口",group = "查询")
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "资金池分页",group = "查询")
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PageParam cashPool = BeanUtil.wrapPageBean(request);
        PageResult pageResult = cashPoolService.pageList(cashPool);
        return responseText(response, EasyuiUtil.toDataGridData(pageResult));
    }

    @ActionAnnotation(name = "资金池详细",group = "查询")
    public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        CashPool cashPool = cashPoolService.query(request.getParameter("id"));
        model.put("cashPool",cashPool);
        return getView(request,model);
    }

    @ActionAnnotation(name = "资金池添加",group = "添加")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "资金池添加保存",group = "添加",log = true)
    public ModelAndView addSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CashPool cashPool = BeanUtil.wrapBean(CashPool.class, request.getParameter("cashPool"));
        String result = cashPoolService.create(cashPool);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "资金池修改",group = "修改")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        CashPool cashPool = cashPoolService.query(request.getParameter("id"));
        model.put("cashPool",cashPool);
        return getView(request,model);
    }

    @ActionAnnotation(name = "资金池修改保存",group = "修改",log = true)
    public ModelAndView editSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CashPool cashPool = BeanUtil.wrapBean(CashPool.class, request.getParameter("cashPool"));
        String result = cashPoolService.update(cashPool);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "资金池删除",group = "删除",log = true)
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = cashPoolService.delete(request.getParameter("id"));
        return responseText(response, result);
    }

    @ActionAnnotation(name = "资金池批量删除",group = "删除",log = true)
    public ModelAndView deleteBatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = BeanUtil.wrapArray(String.class, request.getParameter("ids"));
        String result = cashPoolService.delete(ids);
        return responseText(response, result);
    }
}
