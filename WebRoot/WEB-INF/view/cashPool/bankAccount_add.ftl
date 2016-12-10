<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-12-10 <br/>
描述：银行账户信息添加页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>银行账户信息添加</title>
    <#include "/WEB-INF/view/linkScript.ftl"/>
    <script type="text/javascript">
        $(function(){
            $("body").layout();
            $('#form input.easyui-numberbox').numberbox();
        });

        function save() {
            if (!$("#form").form("validate")) return;
            var bankAccount = $("#form").serializeJson();
            $.showLoad();
            $.ajaxPost("${path}/cashPool/bankAccount_addSave.do", {"bankAccount":bankAccount}, function(result) {
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
                <td class="th">银行名称</td>
                <td class="td"><input type="text" id="name" name="name" class="input easyui-validatebox" validType="maxLength[50]" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">银行账户</td>
                <td class="td"><input type="text" id="account" name="account" class="input easyui-validatebox" validType="maxLength[50]" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">收款人</td>
                <td class="td"><input type="text" id="receiver" name="receiver" class="input easyui-validatebox" validType="maxLength[50]" style="width:300px;"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>