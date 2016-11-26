<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-13 <br/>
描述：发布的活动,任务,悬赏添加页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>发布的活动,任务,悬赏添加</title>
    <#include "/WEB-INF/view/linkScript.ftl"/>
    <script type="text/javascript">
        $(function(){
            $("body").layout();
            $('#form input.easyui-numberbox').numberbox();
        });

        /**
         * 选择项目
         */
        function selectProject(strTitle,strUrl){
        	$("#dialog").css("display","block").dialog({
                title: strTitle,
                width:window.$.autoWidth(),
                height:window.$.autoHeight(),
                onMove:function(left,top){$.adjustPosition("dialog",left,top)},
                onBeforeClose:function(){$.restoreDialog("dialog")}
            });
        	
            $("#iframe").attr("src", strUrl);
        }
        
        /**
         * 选择人物——回调
         */
        function selectPerson(hospitals){
        	var hosId=hospitals[0].id;
        	var hosName=hospitals[0].name;
        	$("#person_id").attr("value",hosId);
        	$("#person_name").attr("value",hosName);
        }
        
        function save() {
            if (!$("#form").form("validate")) return;
            var publishActivity = $("#form").serializeJson();
            $.showLoad();
            $.ajaxPost("${path}/publish/publishActivity_addSave.do", {"publishActivity":publishActivity}, function(result) {
                if(result=="1"){
                	window.parent.$.messager.show({
                        title:"消息提醒",
                        msg:"记录添加成功",
                        timeout:5000,
                        showType:"slide"
                    });
                    $.hideLoad();
                    window.parent.$.closeDialog('dialog');
                    window.parent.reloadPage();
                }else{
                	$.messager.alert("提示",result,"info");
                	$.hideLoad();
                }
            });
        }

    </script>
</head>
<body class="easyui-layout">
<div region="north" style="height:32px; background-color: #EFEFEF;border-bottom: 1px solid #99bbe8;" border="false">
    <div style="padding: 2px;">
        <a href="javascript:save()" class="easyui-linkbutton" icon="icon-save" plain="true">保存</a>
        <a href="javascript:window.parent.$.closeDialog('dialog');" class="easyui-linkbutton" icon="icon-cancel" plain="true">关闭</a>
    </div>
</div>

<div region="center" border="false" style="padding:10px;">
    <form id="form" name="form" style="+zoom:1;">
        <table class="table-border" width="100%">
            <col width="20%">
            <col width="80%">
            <tr>
                <td class="th">活动类型</td>
                <td class="td">
                	<SELECT name="type" id="type"  style="width:309px;" > 
	                	<option value="school_activity">门派活动</option> 
	                	<option value="reward_task">悬赏任务</option> 
	                	<option value="sale_service">出售服务</option>  
	            	</SELECT>
                </td>
            </tr>
            <tr>
                <td class="th">发布地址</td>
                <td class="td"><input type="text" id="address" name="address" class="input easyui-validatebox" validType="maxLength[50]" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">发布内容</td>
                <td class="td"><input type="text" id="content" name="content" class="input easyui-validatebox" validType="maxLength[500]" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">日期</td>
                <td class="td"><input type="text" id="date" name="date" class="input Wdate" onclick="WdatePicker()" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">人物</td>
                <td class="td">
	                <input type="text" id="person_name" name="person_name" class="input easyui-validatebox" validType="maxLength[100]" style="width:300px;"/>
	            	<input type="button" onclick="selectProject('选择人物','${path}/person/basePerson_select.do?callback=selectPerson')" value="选择人物">
	            	<input type="text" id="person_id" name="person_id" style="width:300px;visibility:hidden;"/>
                </td>
            </tr>
            <tr>
                <td class="th">费用</td>
                <td class="td"><input type="text" id="cost" name="cost" class="input easyui-numberbox" min="0" max="99999999.99" precision="2" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">城市</td>
                <td class="td"><input type="text" id="city" name="city" class="input easyui-validatebox" validType="maxLength[50]" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">活动方式</td>
                <td class="td">
                	<SELECT name="way" id="way"  style="width:309px;" > 
	                	<option value="ask_about">打听</option> 
	                	<option value="part_time">兼职</option> 
	                	<option value="other">其他</option>  
	            	</SELECT>
                </td>
            </tr>
            <tr>
                <td class="th">付款方式</td>
                <td class="td">
	                <SELECT name="payway" id="payway"  style="width:309px;" > 
		            	<option value="aa">AA付款</option> 
		            	<option value="man_a_woman_free">男A女免费</option> 
		            	<option value="woman_a_man_free">女A男免费</option>  
		            	<option value="all_free">全部免费</option>  
		        	</SELECT>
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="dialog" style="width:800px;height:400px; overflow:hidden;display: none" resizable="true" maximizable="true" modal="true">
<iframe id="iframe" name="iframe" scrolling="auto" src="about:blank" style="width:100%;height:100%;" frameborder="0" ></iframe>
</div>

</body>
</html>