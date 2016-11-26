package com.rogrand.inviteCode.controller;

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
import com.rogrand.inviteCode.domain.InviteCode;
import com.rogrand.inviteCode.service.InviteCodeService;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：邀请码 Controller
 */
@Controller("InviteCodeController")
@RequestMapping("/inviteCode/inviteCode_*.do")
public class InviteCodeController extends BaseController{

    @Autowired
    @Qualifier("InviteCodeService")
    private InviteCodeService inviteCodeService;

    @ActionAnnotation(name = "邀请码入口",group = "查询")
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "邀请码分页",group = "查询")
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PageParam inviteCode = BeanUtil.wrapPageBean(request);
        PageResult pageResult = inviteCodeService.pageList(inviteCode);
        return responseText(response, EasyuiUtil.toDataGridData(pageResult));
    }

    @ActionAnnotation(name = "邀请码详细",group = "查询")
    public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        InviteCode inviteCode = inviteCodeService.query(request.getParameter("id"));
        model.put("inviteCode",inviteCode);
        return getView(request,model);
    }

    @ActionAnnotation(name = "邀请码添加",group = "添加")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "邀请码添加保存",group = "添加",log = true)
    public ModelAndView addSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        InviteCode inviteCode = BeanUtil.wrapBean(InviteCode.class, request.getParameter("inviteCode"));
        String result = inviteCodeService.create(inviteCode);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "邀请码修改",group = "修改")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        InviteCode inviteCode = inviteCodeService.query(request.getParameter("id"));
        model.put("inviteCode",inviteCode);
        return getView(request,model);
    }

    @ActionAnnotation(name = "邀请码修改保存",group = "修改",log = true)
    public ModelAndView editSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        InviteCode inviteCode = BeanUtil.wrapBean(InviteCode.class, request.getParameter("inviteCode"));
        String result = inviteCodeService.update(inviteCode);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "邀请码删除",group = "删除",log = true)
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = inviteCodeService.delete(request.getParameter("id"));
        return responseText(response, result);
    }

    @ActionAnnotation(name = "邀请码批量删除",group = "删除",log = true)
    public ModelAndView deleteBatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = BeanUtil.wrapArray(String.class, request.getParameter("ids"));
        String result = inviteCodeService.delete(ids);
        return responseText(response, result);
    }
}
