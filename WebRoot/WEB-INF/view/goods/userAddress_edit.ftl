<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-30 <br/>
描述：个人收货地址修改页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>个人收货地址修改</title>
    <#include "/WEB-INF/view/linkScript.ftl"/>
    <script type="text/javascript">
        $(function(){
            $("body").layout();
            $('#form input.easyui-numberbox').numberbox();
        });

        function save() {
            if (!$("#form").form("validate")) return;
            var userAddress = $("#form").serializeJson();
            $.showLoad();
            $.ajaxPost("${path}/goods/userAddress_editSave.do", {"userAddress":userAddress}, function(result) {
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

        var creatorClick = function(){
            var url = "${path}/login/loginUser_main.do?from=f7";
            var width = 800; //窗口宽度
            var height = 400; //窗口高度
            var top = (window.screen.height - 30 - height) / 2;
            var left = (window.screen.width - 10 - width) / 2;
            window.open(url, "_blank", "Scrollbars=no,Toolbar=no,Location=no,titlebar=no,Direction=no,Resizeable=no,alwaysLowered=yes,Width=" + width + " ,Height=" + height + ",top=" + top + ",left=" + left);
        }

        function userCallBack(rowData){
            $("#user_id").val(rowData.id);
            $("#user_name").val(rowData.name);
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
        <input type="hidden" id="id" name="id"  value="${(userAddress.id)!}">
        <table class="table-border" width="100%">
            <col width="20%">
            <col width="80%">
            <tr>
                <td class="th">用户名称</td>
                <td class="td">
                    <input type="text" id="user_name" name="user_name" onclick="creatorClick()" class="input search" value="${(userAddress.user_name)!}" style="width:300px;"/>
                    <input type="hidden" id="user_id" name="user_id" class="input easyui-numberbox" min="0" max="9999999999" precision="0" value="${(userAddress.user_id)!}" style="width:300px;"/>
                </td>
            </tr>
            <tr>
                <td class="th">联系人</td>
                <td class="td"><input type="text" id="contracts" name="contracts" class="input easyui-validatebox" validType="maxLength[50]" value="${(userAddress.contracts)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">电话</td>
                <td class="td"><input type="text" id="phone" name="phone" class="input easyui-validatebox" validType="maxLength[50]" value="${(userAddress.phone)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">城市</td>
                <td class="td"><input type="text" id="city" name="city" class="input easyui-validatebox" validType="maxLength[50]" value="${(userAddress.city)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">详细地址</td>
                <td class="td"><input type="text" id="address" name="address" class="input easyui-validatebox" validType="maxLength[100]" value="${(userAddress.address)!}" style="width:300px;"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>