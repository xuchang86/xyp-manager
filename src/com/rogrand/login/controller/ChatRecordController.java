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
import com.rogrand.login.domain.ChatRecord;
import com.rogrand.login.service.ChatRecordService;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-12-29 <br/>
 * 描述：聊天记录 Controller
 */
@Controller("ChatRecordController")
@RequestMapping("/login/chatRecord_*.do")
public class ChatRecordController extends BaseController{

    @Autowired
    @Qualifier("ChatRecordService")
    private ChatRecordService chatRecordService;

    @ActionAnnotation(name = "聊天记录入口",group = "查询")
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "聊天记录分页",group = "查询")
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PageParam chatRecord = BeanUtil.wrapPageBean(request);
        PageResult pageResult = chatRecordService.pageList(chatRecord);
        return responseText(response, EasyuiUtil.toDataGridData(pageResult));
    }

    @ActionAnnotation(name = "聊天记录详细",group = "查询")
    public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        ChatRecord chatRecord = chatRecordService.query(request.getParameter("id"));
        model.put("chatRecord",chatRecord);
        return getView(request,model);
    }

    @ActionAnnotation(name = "聊天记录添加",group = "添加")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "聊天记录添加保存",group = "添加",log = true)
    public ModelAndView addSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ChatRecord chatRecord = BeanUtil.wrapBean(ChatRecord.class, request.getParameter("chatRecord"));
        String result = chatRecordService.create(chatRecord);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "聊天记录修改",group = "修改")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        ChatRecord chatRecord = chatRecordService.query(request.getParameter("id"));
        model.put("chatRecord",chatRecord);
        return getView(request,model);
    }

    @ActionAnnotation(name = "聊天记录修改保存",group = "修改",log = true)
    public ModelAndView editSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ChatRecord chatRecord = BeanUtil.wrapBean(ChatRecord.class, request.getParameter("chatRecord"));
        String result = chatRecordService.update(chatRecord);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "聊天记录删除",group = "删除",log = true)
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = chatRecordService.delete(request.getParameter("id"));
        return responseText(response, result);
    }

    @ActionAnnotation(name = "聊天记录批量删除",group = "删除",log = true)
    public ModelAndView deleteBatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = BeanUtil.wrapArray(String.class, request.getParameter("ids"));
        String result = chatRecordService.delete(ids);
        return responseText(response, result);
    }
}
