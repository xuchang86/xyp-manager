<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-13 <br/>
描述：活动参与人修改页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>活动参与人修改</title>
    <#include "/WEB-INF/view/linkScript.ftl"/>
    <script type="text/javascript">
        $(function(){
            $("body").layout();
            $('#form input.easyui-numberbox').numberbox();
        });

        function save() {
            if (!$("#form").form("validate")) return;
            var activityPerson = $("#form").serializeJson();
            $.showLoad();
            $.ajaxPost("${path}/publish/activityPerson_editSave.do", {"activityPerson":activityPerson}, function(result) {
                if(result=="1"){
                	window.parent.$.messager.show({
                        title:"消息提醒",
                        msg:"记录修改成功",
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

        /**
         * 选择人物
         */
        function selectData(title,url){
        	$("#dialog").css("display","block").dialog({
    			title: title,
    			width:window.$.autoWidth(),
    			height:window.$.autoHeight(),
    			onMove:function(left,top){$.adjustPosition("dialog",left,top)},
    			onBeforeClose:function(){$.restoreDialog("dialog")}
    		});
    		$("#iframe").attr("src", url);
        }
        
        function selectPersonBack(basePerson){
        	$("#person_id").val(basePerson.id);
        	$("#person_name").val(basePerson.name);
        }
        
        function selectActityBack(publishActivity){
        	$("#activity_id").val(publishActivity.id);
        	$("#activity_name").val(publishActivity.content);
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
        <input type="hidden" id="id" name="id"  value="${(activityPerson.id)!}">
        <table class="table-border" width="100%">
            <col width="20%">
            <col width="80%">
            <tr>
                <td class="th">人物ID</td>
                <td class="td">
                	<input type="text" id="person_id" name="person_id" class="input easyui-numberbox" min="0" max="9999999999" precision="0" value="${(activityPerson.person_id)!}" style="display:none"/>
                	<input type="text" id="person_name" name="person_name" class="input" disabled="true" value="${(activityPerson.person_name)!}" style="width:300px;"/>
                	<input type="button" value="选择人物" onclick="selectData('选择人物','${path}/person/basePerson_select.do?callback=selectPersonBack')">
                </td>
            </tr>
            <tr>
                <td class="th">活动ID</td>
                <td class="td">
                	<input type="text" id="activity_id" name="activity_id" class="input easyui-numberbox" min="0" max="9999999999" precision="0" value="${(activityPerson.activity_id)!}" style="display:none"/>
                	<input type="text" id="activity_name" name="activity_name" class="input" disabled="true" value="${(activityPerson.activity_content)!}" style="width:300px;"/>
                	<input type="button" value="选择活动" onclick="selectData('选择活动','${path}/publish/publishActivity_select.do?callback=selectActityBack')">
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