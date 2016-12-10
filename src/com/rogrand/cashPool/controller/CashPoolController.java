package com.rogrand.cashPool.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rogrand.cashPool.domain.CashPool;
import com.rogrand.cashPool.domain.TransferRecord;
import com.rogrand.cashPool.service.CashPoolService;
import com.rogrand.cashPool.service.TransferRecordService;
import com.rogrand.core.annotation.ActionAnnotation;
import com.rogrand.core.controller.BaseController;
import com.rogrand.core.domain.PageParam;
import com.rogrand.core.domain.PageResult;
import com.rogrand.core.util.BeanUtil;
import com.rogrand.core.util.EasyuiUtil;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-11-13 <br/>
 * 描述：资金池 Controller
 */
@Controller("CashPoolController")
@RequestMapping("/cashPool/cashPool_*.do")
public class CashPoolController extends BaseController {

	@Autowired
	@Qualifier("CashPoolService")
	private CashPoolService cashPoolService;

	@Autowired
	@Qualifier("TransferRecordService")
	private TransferRecordService transferRecordService;

	/**
	 * 提现接口
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ModelAndView getBill(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String dataModel = request.getParameter("dataModel");
		JSONObject obj = JSON.parseObject(dataModel);
		String poolId = obj.getString("id");
		CashPool cashPool = cashPoolService.query(poolId);
		BigDecimal platform = new BigDecimal(cashPool.getPlatform());
		BigDecimal amount = new BigDecimal(obj.getString("amount"));

		JSONObject result = new JSONObject();
		// 校验金额是否超出收入
		if (platform.compareTo(amount) < 0) {
			result.put("status", "error");
			result.put("message", "当前提现金额[" + amount + "]大于平台收入[" + platform
					+ "],不允许提现.");
			return responseText(response, result.toJSONString());
		}

		// 减少平台收入
		cashPool.setPlatform(Double.valueOf(platform.subtract(amount)
				.toString()));
		cashPoolService.update(cashPool);

		// 生成记录
		TransferRecord record = new TransferRecord();
		record.setAccount_id(obj.getLong("accountId"));
		record.setDate(new Date());
		record.setOperator(getLoginUser(request).getSu_name());
		record.setAmount(Double.valueOf(amount.toString()));
		transferRecordService.create(record);

		result.put("status", "success");
		result.put("message", "提现成功");
		return responseText(response, result.toJSONString());
	}

	@ActionAnnotation(name = "资金池入口", group = "查询")
	public ModelAndView main(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return getView(request);
	}

	@ActionAnnotation(name = "资金池分页", group = "查询")
	public ModelAndView page(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PageParam cashPool = BeanUtil.wrapPageBean(request);
		PageResult pageResult = cashPoolService.pageList(cashPool);
		return responseText(response, EasyuiUtil.toDataGridData(pageResult));
	}

	@ActionAnnotation(name = "资金池详细", group = "查询")
	public ModelAndView view(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		CashPool cashPool = cashPoolService.query(request.getParameter("id"));
		model.put("cashPool", cashPool);
		return getView(request, model);
	}

	@ActionAnnotation(name = "资金池添加", group = "添加")
	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return getView(request);
	}

	@ActionAnnotation(name = "资金池添加保存", group = "添加", log = true)
	public ModelAndView addSave(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CashPool cashPool = BeanUtil.wrapBean(CashPool.class,
				request.getParameter("cashPool"));
		String result = cashPoolService.create(cashPool);
		return responseText(response, result);
	}

	@ActionAnnotation(name = "资金池修改", group = "修改")
	public ModelAndView edit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		CashPool cashPool = cashPoolService.query(request.getParameter("id"));
		model.put("cashPool", cashPool);
		return getView(request, model);
	}

	@ActionAnnotation(name = "资金池修改保存", group = "修改", log = true)
	public ModelAndView editSave(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CashPool cashPool = BeanUtil.wrapBean(CashPool.class,
				request.getParameter("cashPool"));
		String result = cashPoolService.update(cashPool);
		return responseText(response, result);
	}

	@ActionAnnotation(name = "资金池删除", group = "删除", log = true)
	public ModelAndView delete(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String result = cashPoolService.delete(request.getParameter("id"));
		return responseText(response, result);
	}

	@ActionAnnotation(name = "资金池批量删除", group = "删除", log = true)
	public ModelAndView deleteBatch(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String[] ids = BeanUtil.wrapArray(String.class,
				request.getParameter("ids"));
		String result = cashPoolService.delete(ids);
		return responseText(response, result);
	}
}
