package com.rogrand.publish.controller;

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
import com.rogrand.publish.domain.ActivityPerson;
import com.rogrand.publish.service.ActivityPersonService;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：活动参与人 Controller
 */
@Controller("ActivityPersonController")
@RequestMapping("/publish/activityPerson_*.do")
public class ActivityPersonController extends BaseController{

    @Autowired
    @Qualifier("ActivityPersonService")
    private ActivityPersonService activityPersonService;

    @ActionAnnotation(name = "活动参与人入口",group = "查询")
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "活动参与人分页",group = "查询")
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PageParam activityPerson = BeanUtil.wrapPageBean(request);
        PageResult pageResult = activityPersonService.pageList(activityPerson);
        return responseText(response, EasyuiUtil.toDataGridData(pageResult));
    }

    @ActionAnnotation(name = "活动参与人详细",group = "查询")
    public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        ActivityPerson activityPerson = activityPersonService.query(request.getParameter("id"));
        model.put("activityPerson",activityPerson);
        return getView(request,model);
    }

    @ActionAnnotation(name = "活动参与人添加",group = "添加")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "活动参与人添加保存",group = "添加",log = true)
    public ModelAndView addSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActivityPerson activityPerson = BeanUtil.wrapBean(ActivityPerson.class, request.getParameter("activityPerson"));
        String result = activityPersonService.create(activityPerson);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "活动参与人修改",group = "修改")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        ActivityPerson activityPerson = activityPersonService.query(request.getParameter("id"));
        model.put("activityPerson",activityPerson);
        return getView(request,model);
    }

    @ActionAnnotation(name = "活动参与人修改保存",group = "修改",log = true)
    public ModelAndView editSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActivityPerson activityPerson = BeanUtil.wrapBean(ActivityPerson.class, request.getParameter("activityPerson"));
        String result = activityPersonService.update(activityPerson);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "活动参与人删除",group = "删除",log = true)
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = activityPersonService.delete(request.getParameter("id"));
        return responseText(response, result);
    }

    @ActionAnnotation(name = "活动参与人批量删除",group = "删除",log = true)
    public ModelAndView deleteBatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = BeanUtil.wrapArray(String.class, request.getParameter("ids"));
        String result = activityPersonService.delete(ids);
        return responseText(response, result);
    }
}
