<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-13 <br/>
描述：门派事件修改页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>门派事件修改</title>
    <#include "/WEB-INF/view/linkScript.ftl"/>
    <script type="text/javascript">
        $(function(){
            $("body").layout();
            $('#form input.easyui-numberbox').numberbox();
        });

        function save() {
            if (!$("#form").form("validate")) return;
            var mpEvent = $("#form").serializeJson();
            $.showLoad();
            $.ajaxPost("${path}/event/mpEvent_editSave.do", {"mpEvent":mpEvent}, function(result) {
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
        <input type="hidden" id="id" name="id"  value="${(mpEvent.id)!}">
        <table class="table-border" width="100%">
            <col width="20%">
            <col width="80%">
            <tr>
                <td class="th">事件内容</td>
                <td class="td"><input type="text" id="content" name="content" class="input easyui-validatebox" validType="maxLength[800]" value="${(mpEvent.content)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">人物ID</td>
                <td class="td"><input type="text" id="person_id" name="person_id" class="input easyui-numberbox" min="0" max="9999999999" precision="0" value="${(mpEvent.person_id)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">开始时间</td>
                <td class="td"><input type="text" id="start_date" name="start_date" class="input Wdate" onclick="WdatePicker()" value="<@dateOut mpEvent.start_date/>" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">结束时间</td>
                <td class="td"><input type="text" id="end_date" name="end_date" class="input Wdate" onclick="WdatePicker()" value="<@dateOut mpEvent.end_date/>" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">事件类型</td>
                <td class="td"><input type="text" id="type" name="type" class="input easyui-validatebox" validType="maxLength[20]" value="${(mpEvent.type)!}" style="width:300px;"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>