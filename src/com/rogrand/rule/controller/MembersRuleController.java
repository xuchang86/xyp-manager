package com.rogrand.rule.controller;

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
import com.rogrand.rule.domain.MembersRule;
import com.rogrand.rule.service.MembersRuleService;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：会员成长规则 Controller
 */
@Controller("MembersRuleController")
@RequestMapping("/rule/membersRule_*.do")
public class MembersRuleController extends BaseController{

    @Autowired
    @Qualifier("MembersRuleService")
    private MembersRuleService membersRuleService;

    @ActionAnnotation(name = "会员成长规则入口",group = "查询")
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "会员成长规则分页",group = "查询")
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PageParam membersRule = BeanUtil.wrapPageBean(request);
        PageResult pageResult = membersRuleService.pageList(membersRule);
        return responseText(response, EasyuiUtil.toDataGridData(pageResult));
    }

    @ActionAnnotation(name = "会员成长规则详细",group = "查询")
    public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        MembersRule membersRule = membersRuleService.query(request.getParameter("id"));
        model.put("membersRule",membersRule);
        return getView(request,model);
    }

    @ActionAnnotation(name = "会员成长规则添加",group = "添加")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "会员成长规则添加保存",group = "添加",log = true)
    public ModelAndView addSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MembersRule membersRule = BeanUtil.wrapBean(MembersRule.class, request.getParameter("membersRule"));
        String result = membersRuleService.create(membersRule);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "会员成长规则修改",group = "修改")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        MembersRule membersRule = membersRuleService.query(request.getParameter("id"));
        model.put("membersRule",membersRule);
        return getView(request,model);
    }

    @ActionAnnotation(name = "会员成长规则修改保存",group = "修改",log = true)
    public ModelAndView editSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MembersRule membersRule = BeanUtil.wrapBean(MembersRule.class, request.getParameter("membersRule"));
        String result = membersRuleService.update(membersRule);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "会员成长规则删除",group = "删除",log = true)
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = membersRuleService.delete(request.getParameter("id"));
        return responseText(response, result);
    }

    @ActionAnnotation(name = "会员成长规则批量删除",group = "删除",log = true)
    public ModelAndView deleteBatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = BeanUtil.wrapArray(String.class, request.getParameter("ids"));
        String result = membersRuleService.delete(ids);
        return responseText(response, result);
    }
}
