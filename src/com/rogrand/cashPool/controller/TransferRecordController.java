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
import com.rogrand.cashPool.domain.TransferRecord;
import com.rogrand.cashPool.service.TransferRecordService;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-12-10 <br/>
 * 描述：提现记录 Controller
 */
@Controller("TransferRecordController")
@RequestMapping("/cashPool/transferRecord_*.do")
public class TransferRecordController extends BaseController{

    @Autowired
    @Qualifier("TransferRecordService")
    private TransferRecordService transferRecordService;

    @ActionAnnotation(name = "提现记录入口",group = "查询")
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "提现记录分页",group = "查询")
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PageParam transferRecord = BeanUtil.wrapPageBean(request);
        PageResult pageResult = transferRecordService.pageList(transferRecord);
        return responseText(response, EasyuiUtil.toDataGridData(pageResult));
    }

    @ActionAnnotation(name = "提现记录详细",group = "查询")
    public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        TransferRecord transferRecord = transferRecordService.query(request.getParameter("id"));
        model.put("transferRecord",transferRecord);
        return getView(request,model);
    }

    @ActionAnnotation(name = "提现记录添加",group = "添加")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getView(request);
    }

    @ActionAnnotation(name = "提现记录添加保存",group = "添加",log = true)
    public ModelAndView addSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        TransferRecord transferRecord = BeanUtil.wrapBean(TransferRecord.class, request.getParameter("transferRecord"));
        String result = transferRecordService.create(transferRecord);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "提现记录修改",group = "修改")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> model = new HashMap<String,Object>();
        TransferRecord transferRecord = transferRecordService.query(request.getParameter("id"));
        model.put("transferRecord",transferRecord);
        return getView(request,model);
    }

    @ActionAnnotation(name = "提现记录修改保存",group = "修改",log = true)
    public ModelAndView editSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        TransferRecord transferRecord = BeanUtil.wrapBean(TransferRecord.class, request.getParameter("transferRecord"));
        String result = transferRecordService.update(transferRecord);
        return responseText(response, result);
    }

    @ActionAnnotation(name = "提现记录删除",group = "删除",log = true)
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = transferRecordService.delete(request.getParameter("id"));
        return responseText(response, result);
    }

    @ActionAnnotation(name = "提现记录批量删除",group = "删除",log = true)
    public ModelAndView deleteBatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = BeanUtil.wrapArray(String.class, request.getParameter("ids"));
        String result = transferRecordService.delete(ids);
        return responseText(response, result);
    }
}
