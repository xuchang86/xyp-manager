package com.rogrand.event.controller;

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
import com.rogrand.event.domain.MpEvent;
import com.rogrand.event.service.MpEventService;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：门派事件 Controller
 */
@Controller("MpEventController")
@RequestMapping("/event/mpEvent_*.do")
public class MpEventController extends BaseController{

    @Autowired
    @Qualifier("MpEventService")
    private MpEventService mpEventService;

    @ActionAnnotation(name = "门派事件入口",group = "查询")
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "门派事件分页",group = "查询")
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PageParam mpEvent = BeanUtil.wrapPageBean(request);
        PageResult pageResult = mpEventService.pageList(mpEvent);
        return responseText(response, EasyuiUtil.toDataGridData(pageResult));
    }

    @ActionAnnotation(name = "门派事件详细",group = "查询")
    public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        MpEvent mpEvent = mpEventService.query(request.getParameter("id"));
        model.put("mpEvent",mpEvent);
        return getView(request,model);
    }

    @ActionAnnotation(name = "门派事件添加",group = "添加")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "门派事件添加保存",group = "添加",log = true)
    public ModelAndView addSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MpEvent mpEvent = BeanUtil.wrapBean(MpEvent.class, request.getParameter("mpEvent"));
        String result = mpEventService.create(mpEvent);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "门派事件修改",group = "修改")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        MpEvent mpEvent = mpEventService.query(request.getParameter("id"));
        model.put("mpEvent",mpEvent);
        return getView(request,model);
    }

    @ActionAnnotation(name = "门派事件修改保存",group = "修改",log = true)
    public ModelAndView editSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MpEvent mpEvent = BeanUtil.wrapBean(MpEvent.class, request.getParameter("mpEvent"));
        String result = mpEventService.update(mpEvent);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "门派事件删除",group = "删除",log = true)
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = mpEventService.delete(request.getParameter("id"));
        return responseText(response, result);
    }

    @ActionAnnotation(name = "门派事件批量删除",group = "删除",log = true)
    public ModelAndView deleteBatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = BeanUtil.wrapArray(String.class, request.getParameter("ids"));
        String result = mpEventService.delete(ids);
        return responseText(response, result);
    }
}
