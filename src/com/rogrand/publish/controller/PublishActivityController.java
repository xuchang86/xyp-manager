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
import com.rogrand.publish.domain.PublishActivity;
import com.rogrand.publish.service.PublishActivityService;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：发布的活动,任务,悬赏 Controller
 */
@Controller("PublishActivityController")
@RequestMapping("/publish/publishActivity_*.do")
public class PublishActivityController extends BaseController{

    @Autowired
    @Qualifier("PublishActivityService")
    private PublishActivityService publishActivityService;

    @ActionAnnotation(name = "发布的活动,任务,悬赏入口",group = "查询")
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "发布的活动,任务,悬赏分页",group = "查询")
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PageParam publishActivity = BeanUtil.wrapPageBean(request);
        PageResult pageResult = publishActivityService.pageList(publishActivity);
        return responseText(response, EasyuiUtil.toDataGridData(pageResult));
    }

    @ActionAnnotation(name = "发布的活动,任务,悬赏详细",group = "查询")
    public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        PublishActivity publishActivity = publishActivityService.query(request.getParameter("id"));
        model.put("publishActivity",publishActivity);
        return getView(request,model);
    }

    @ActionAnnotation(name = "发布的活动,任务,悬赏添加",group = "添加")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "发布的活动,任务,悬赏添加保存",group = "添加",log = true)
    public ModelAndView addSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PublishActivity publishActivity = BeanUtil.wrapBean(PublishActivity.class, request.getParameter("publishActivity"));
        String result = publishActivityService.create(publishActivity);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "发布的活动,任务,悬赏修改",group = "修改")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        PublishActivity publishActivity = publishActivityService.query(request.getParameter("id"));
        model.put("publishActivity",publishActivity);
        return getView(request,model);
    }

    @ActionAnnotation(name = "发布的活动,任务,悬赏修改保存",group = "修改",log = true)
    public ModelAndView editSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PublishActivity publishActivity = BeanUtil.wrapBean(PublishActivity.class, request.getParameter("publishActivity"));
        String result = publishActivityService.update(publishActivity);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "发布的活动,任务,悬赏删除",group = "删除",log = true)
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = publishActivityService.delete(request.getParameter("id"));
        return responseText(response, result);
    }

    @ActionAnnotation(name = "发布的活动,任务,悬赏批量删除",group = "删除",log = true)
    public ModelAndView deleteBatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = BeanUtil.wrapArray(String.class, request.getParameter("ids"));
        String result = publishActivityService.delete(ids);
        return responseText(response, result);
    }
}
