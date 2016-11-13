package com.rogrand.person.controller;

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
import com.rogrand.person.domain.BasePerson;
import com.rogrand.person.service.BasePersonService;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：人物信息 Controller
 */
@Controller("BasePersonController")
@RequestMapping("/person/basePerson_*.do")
public class BasePersonController extends BaseController{

    @Autowired
    @Qualifier("BasePersonService")
    private BasePersonService basePersonService;

    @ActionAnnotation(name = "人物信息入口",group = "查询")
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "人物信息分页",group = "查询")
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PageParam basePerson = BeanUtil.wrapPageBean(request);
        PageResult pageResult = basePersonService.pageList(basePerson);
        return responseText(response, EasyuiUtil.toDataGridData(pageResult));
    }

    @ActionAnnotation(name = "人物信息详细",group = "查询")
    public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        BasePerson basePerson = basePersonService.query(request.getParameter("id"));
        model.put("basePerson",basePerson);
        return getView(request,model);
    }

    @ActionAnnotation(name = "人物信息添加",group = "添加")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "人物信息添加保存",group = "添加",log = true)
    public ModelAndView addSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BasePerson basePerson = BeanUtil.wrapBean(BasePerson.class, request.getParameter("basePerson"));
        String result = basePersonService.create(basePerson);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "人物信息修改",group = "修改")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        BasePerson basePerson = basePersonService.query(request.getParameter("id"));
        model.put("basePerson",basePerson);
        return getView(request,model);
    }

    @ActionAnnotation(name = "人物信息修改保存",group = "修改",log = true)
    public ModelAndView editSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BasePerson basePerson = BeanUtil.wrapBean(BasePerson.class, request.getParameter("basePerson"));
        String result = basePersonService.update(basePerson);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "人物信息删除",group = "删除",log = true)
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = basePersonService.delete(request.getParameter("id"));
        return responseText(response, result);
    }

    @ActionAnnotation(name = "人物信息批量删除",group = "删除",log = true)
    public ModelAndView deleteBatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = BeanUtil.wrapArray(String.class, request.getParameter("ids"));
        String result = basePersonService.delete(ids);
        return responseText(response, result);
    }
}
