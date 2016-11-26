package com.rogrand.login.controller;

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
import com.rogrand.login.domain.LoginUser;
import com.rogrand.login.service.LoginUserService;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-12 <br/>
 * 描述：逍遥派用户 Controller
 */
@Controller("LoginUserController")
@RequestMapping("/login/loginUser_*.do")
public class LoginUserController extends BaseController{

    @Autowired
    @Qualifier("LoginUserService")
    private LoginUserService loginUserService;

    @ActionAnnotation(name = "逍遥派用户入口",group = "查询")
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "逍遥派用户分页",group = "查询")
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PageParam loginUser = BeanUtil.wrapPageBean(request);
        PageResult pageResult = loginUserService.pageList(loginUser);
        return responseText(response, EasyuiUtil.toDataGridData(pageResult));
    }

    @ActionAnnotation(name = "逍遥派用户详细",group = "查询")
    public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        LoginUser loginUser = loginUserService.query(request.getParameter("id"));
        model.put("loginUser1",loginUser);
        return getView(request,model);
    }

    @ActionAnnotation(name = "逍遥派用户添加",group = "添加")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "逍遥派用户添加保存",group = "添加",log = true)
    public ModelAndView addSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LoginUser loginUser = BeanUtil.wrapBean(LoginUser.class, request.getParameter("loginUser"));
        String result = loginUserService.create(loginUser);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "逍遥派用户修改",group = "修改")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        LoginUser loginUser = loginUserService.query(request.getParameter("id"));
        model.put("loginUser1",loginUser);
        return getView(request,model);
    }

    @ActionAnnotation(name = "逍遥派用户修改保存",group = "修改",log = true)
    public ModelAndView editSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LoginUser loginUser = BeanUtil.wrapBean(LoginUser.class, request.getParameter("loginUser"));
        String result = loginUserService.update(loginUser);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "逍遥派用户删除",group = "删除",log = true)
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = loginUserService.delete(request.getParameter("id"));
        return responseText(response, result);
    }

    @ActionAnnotation(name = "逍遥派用户批量删除",group = "删除",log = true)
    public ModelAndView deleteBatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = BeanUtil.wrapArray(String.class, request.getParameter("ids"));
        String result = loginUserService.delete(ids);
        return responseText(response, result);
    }
}
