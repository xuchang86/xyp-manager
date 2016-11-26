<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-13 <br/>
描述：卖家信息修改页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>卖家信息修改</title>
    <#include "/WEB-INF/view/linkScript.ftl"/>
    <script type="text/javascript">
        $(function(){
            $("body").layout();
            $('#form input.easyui-numberbox').numberbox();
        });

        function save() {
            if (!$("#form").form("validate")) return;
            var goodsSeller = $("#form").serializeJson();
            $.showLoad();
            $.ajaxPost("${path}/goods/goodsSeller_editSave.do", {"goodsSeller":goodsSeller}, function(result) {
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
        <input type="hidden" id="id" name="id"  value="${(goodsSeller.id)!}">
        <table class="table-border" width="100%">
            <col width="20%">
            <col width="80%">
            <tr>
                <td class="th">昵称</td>
                <td class="td"><input type="text" id="nick_name" name="nick_name" class="input easyui-validatebox" validType="maxLength[20]" value="${(goodsSeller.nick_name)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">真实姓名</td>
                <td class="td"><input type="text" id="real_name" name="real_name" class="input easyui-validatebox" validType="maxLength[20]" value="${(goodsSeller.real_name)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">城市</td>
                <td class="td"><input type="text" id="city" name="city" class="input easyui-validatebox" validType="maxLength[50]" value="${(goodsSeller.city)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">联系电话</td>
                <td class="td"><input type="text" id="phone" name="phone" class="input easyui-validatebox" validType="maxLength[20]" value="${(goodsSeller.phone)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">邮箱</td>
                <td class="td"><input type="text" id="email" name="email" class="input easyui-validatebox" validType="maxLength[20]" value="${(goodsSeller.email)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">账户</td>
                <td class="td"><input type="text" id="account" name="account" class="input easyui-validatebox" validType="maxLength[30]" value="${(goodsSeller.account)!}" style="width:300px;"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>