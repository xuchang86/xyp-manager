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
import com.rogrand.cashPool.domain.BankAccount;
import com.rogrand.cashPool.service.BankAccountService;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-12-10 <br/>
 * 描述：银行账户信息 Controller
 */
@Controller("BankAccountController")
@RequestMapping("/cashPool/bankAccount_*.do")
public class BankAccountController extends BaseController{

    @Autowired
    @Qualifier("BankAccountService")
    private BankAccountService bankAccountService;

    @ActionAnnotation(name = "银行账户信息入口",group = "查询")
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "银行账户信息分页",group = "查询")
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PageParam bankAccount = BeanUtil.wrapPageBean(request);
        PageResult pageResult = bankAccountService.pageList(bankAccount);
        return responseText(response, EasyuiUtil.toDataGridData(pageResult));
    }

    @ActionAnnotation(name = "银行账户信息详细",group = "查询")
    public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        BankAccount bankAccount = bankAccountService.query(request.getParameter("id"));
        model.put("bankAccount",bankAccount);
        return getView(request,model);
    }

    @ActionAnnotation(name = "银行账户信息添加",group = "添加")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "银行账户信息添加保存",group = "添加",log = true)
    public ModelAndView addSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BankAccount bankAccount = BeanUtil.wrapBean(BankAccount.class, request.getParameter("bankAccount"));
        String result = bankAccountService.create(bankAccount);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "银行账户信息修改",group = "修改")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        BankAccount bankAccount = bankAccountService.query(request.getParameter("id"));
        model.put("bankAccount",bankAccount);
        return getView(request,model);
    }

    @ActionAnnotation(name = "银行账户信息修改保存",group = "修改",log = true)
    public ModelAndView editSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BankAccount bankAccount = BeanUtil.wrapBean(BankAccount.class, request.getParameter("bankAccount"));
        String result = bankAccountService.update(bankAccount);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "银行账户信息删除",group = "删除",log = true)
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = bankAccountService.delete(request.getParameter("id"));
        return responseText(response, result);
    }

    @ActionAnnotation(name = "银行账户信息批量删除",group = "删除",log = true)
    public ModelAndView deleteBatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = BeanUtil.wrapArray(String.class, request.getParameter("ids"));
        String result = bankAccountService.delete(ids);
        return responseText(response, result);
    }
}
