package com.rogrand.goods.controller;

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
import com.rogrand.goods.domain.UserAddress;
import com.rogrand.goods.service.UserAddressService;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-30 <br/>
 * 描述：个人收货地址 Controller
 */
@Controller("UserAddressController")
@RequestMapping("/goods/userAddress_*.do")
public class UserAddressController extends BaseController{

    @Autowired
    @Qualifier("UserAddressService")
    private UserAddressService userAddressService;

    @ActionAnnotation(name = "个人收货地址入口",group = "查询")
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "个人收货地址分页",group = "查询")
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PageParam userAddress = BeanUtil.wrapPageBean(request);
        PageResult pageResult = userAddressService.pageList(userAddress);
        return responseText(response, EasyuiUtil.toDataGridData(pageResult));
    }

    @ActionAnnotation(name = "个人收货地址详细",group = "查询")
    public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        UserAddress userAddress = userAddressService.query(request.getParameter("id"));
        model.put("userAddress",userAddress);
        return getView(request,model);
    }

    @ActionAnnotation(name = "个人收货地址添加",group = "添加")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "个人收货地址添加保存",group = "添加",log = true)
    public ModelAndView addSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserAddress userAddress = BeanUtil.wrapBean(UserAddress.class, request.getParameter("userAddress"));
        String result = userAddressService.create(userAddress);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "个人收货地址修改",group = "修改")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        UserAddress userAddress = userAddressService.query(request.getParameter("id"));
        model.put("userAddress",userAddress);
        return getView(request,model);
    }

    @ActionAnnotation(name = "个人收货地址修改保存",group = "修改",log = true)
    public ModelAndView editSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserAddress userAddress = BeanUtil.wrapBean(UserAddress.class, request.getParameter("userAddress"));
        String result = userAddressService.update(userAddress);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "个人收货地址删除",group = "删除",log = true)
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = userAddressService.delete(request.getParameter("id"));
        return responseText(response, result);
    }

    @ActionAnnotation(name = "个人收货地址批量删除",group = "删除",log = true)
    public ModelAndView deleteBatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = BeanUtil.wrapArray(String.class, request.getParameter("ids"));
        String result = userAddressService.delete(ids);
        return responseText(response, result);
    }
}
