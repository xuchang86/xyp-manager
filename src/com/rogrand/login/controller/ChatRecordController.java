package com.rogrand.login.controller;

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
import com.easemob.server.example.comm.utils.EmchatOperator;
import com.easemob.server.example.comm.wrapper.ResponseWrapper;
import com.rogrand.core.annotation.ActionAnnotation;
import com.rogrand.core.controller.BaseController;
import com.rogrand.core.domain.PageParam;
import com.rogrand.core.domain.PageResult;
import com.rogrand.core.util.BeanUtil;
import com.rogrand.core.util.EasyuiUtil;
import com.rogrand.login.domain.ChatRecord;
import com.rogrand.login.domain.ChatVO;
import com.rogrand.login.service.ChatRecordService;

/**
 * 版权：LAB <br/>
 * 作者：dailing <br/>
 * 生成日期：2016-12-30 <br/>
 * 描述：聊天记录 Controller
 */
@Controller("ChatRecordController")
@RequestMapping("/login/chatRecord_*.do")
public class ChatRecordController extends BaseController {

	@Autowired
	@Qualifier("ChatRecordService")
	private ChatRecordService chatRecordService;

	@ActionAnnotation(name = "聊天记录入口", group = "查询")
	public ModelAndView main(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return getView(request);
	}

	@ActionAnnotation(name = "聊天记录分页", group = "查询")
	public ModelAndView page(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PageParam chatRecord = BeanUtil.wrapPageBean(request);
		chatRecord.put("to_id", "10000");
		PageResult pageResult = chatRecordService.pageList(chatRecord);
		return responseText(response, EasyuiUtil.toDataGridData(pageResult));
	}

	@ActionAnnotation(name = "聊天记录分页", group = "查询")
	public ModelAndView page2(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PageParam chatRecord = BeanUtil.wrapPageBean(request);
		chatRecord.put("to_id", "10001");
		PageResult pageResult = chatRecordService.pageList(chatRecord);
		return responseText(response, EasyuiUtil.toDataGridData(pageResult));
	}

	@ActionAnnotation(name = "聊天记录详细", group = "查询")
	public ModelAndView view(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		ChatRecord chatRecord = chatRecordService.query(request
				.getParameter("id"));
		model.put("chatRecord", chatRecord);
		return getView(request, model);
	}

	@ActionAnnotation(name = "聊天记录添加", group = "添加")
	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return getView(request);
	}

	@ActionAnnotation(name = "聊天记录添加保存", group = "添加", log = true)
	public ModelAndView addSave(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ChatRecord chatRecord = BeanUtil.wrapBean(ChatRecord.class,
				request.getParameter("chatRecord"));
		String result = chatRecordService.create(chatRecord);
		return responseText(response, result);
	}

	@ActionAnnotation(name = "聊天记录修改", group = "修改")
	public ModelAndView edit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		ChatRecord chatRecord = chatRecordService.query(request
				.getParameter("id"));
		model.put("chatRecord", chatRecord);
		return getView(request, model);
	}

	@ActionAnnotation(name = "聊天记录修改保存", group = "修改", log = true)
	public ModelAndView editSave(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ChatRecord chatRecord = BeanUtil.wrapBean(ChatRecord.class,
				request.getParameter("chatRecord"));
		String result = chatRecordService.update(chatRecord);
		return responseText(response, result);
	}

	@ActionAnnotation(name = "聊天记录删除", group = "删除", log = true)
	public ModelAndView delete(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String result = chatRecordService.delete(request.getParameter("id"));
		return responseText(response, result);
	}

	@ActionAnnotation(name = "聊天记录批量删除", group = "删除", log = true)
	public ModelAndView deleteBatch(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String[] ids = BeanUtil.wrapArray(String.class,
				request.getParameter("ids"));
		String result = chatRecordService.delete(ids);
		return responseText(response, result);
	}

	/**
	 * 回复客户
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView sendMessageToUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String dataModel = request.getParameter("dataModel");
		ChatVO chatVO = JSON.parseObject(dataModel, ChatVO.class);

		// 调用环信接口发送消息
		ResponseWrapper resp = EmchatOperator.sendMessage("users",
				new String[] { chatVO.getFrom_id() }, chatVO.getTo_id(), null,
				chatVO.getToContent());
		JSONObject result = new JSONObject();
		if (resp.getResponseStatus().equals(200)) {
			result.put("status", "success");
			result.put("message", "发送消息成功");
		} else {
			result.put("status", "error");
			result.put("message", "发送消息失败:" + resp.getResponseBody());
		}
		return responseText(response, result.toJSONString());
	}

}
