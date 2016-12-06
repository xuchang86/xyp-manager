<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-12 <br/>
描述：逍遥派用户添加页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>逍遥派用户添加</title>
    <#include "/WEB-INF/view/linkScript.ftl"/>
    <script type="text/javascript">
        $(function(){
            $("body").layout();
            $('#form input.easyui-numberbox').numberbox();
        });

        function save() {
            if (!$("#form").form("validate")) return;
            var loginUser = $("#form").serializeJson();
            $.showLoad();
            $.ajaxPost("${path}/login/loginUser_addSave.do", {"loginUser":loginUser}, function(result) {
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
                <td class="th">电话</td>
                <td class="td"><input type="text" id="phone" name="phone" class="input easyui-validatebox" validType="maxLength[20]" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">密码</td>
                <td class="td"><input type="text" id="password" name="password" class="input easyui-validatebox" validType="maxLength[50]" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">名称</td>
                <td class="td"><input type="text" id="name" name="name" class="input easyui-validatebox" validType="maxLength[20]" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">生日</td>
                <td class="td"><input type="text" id="birthday" name="birthday" class="input Wdate" onclick="WdatePicker()" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">地址</td>
                <td class="td"><input type="text" id="address" name="address" class="input easyui-validatebox" validType="maxLength[50]" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">我提供的资源</td>
                <td class="td"><input type="text" id="providerid" name="providerid" class="input easyui-validatebox" validType="maxLength[20]" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">我需要的资源</td>
                <td class="td"><input type="text" id="requiredid" name="requiredid" class="input easyui-validatebox" validType="maxLength[20]" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">城市</td>
                <td class="td"><input type="text" id="city" name="city" class="input easyui-validatebox" validType="maxLength[20]" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">性别</td>
                <td class="td">
                 <select id="sex" name="sex">
                  <option value="0">男</option>
	              <option value="1">女</option>
				 </select>
                </td>
            </tr>
            <tr>
                <td class="th">权限等级</td>
                <td class="td">
                <select id="permission" name="permission">
                  <option value="">无</option>
                  <option value="0">普通权限</option>
                  <option value="1">发布权限</option>
                  <option value="2">所有权限</option>
                </select>
                </td>
            </tr>
            <tr>
                <td class="th">用户名</td>
                <td class="td"><input type="text" id="username" name="username" class="input easyui-validatebox" validType="maxLength[15]" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">是否已付款</td>
                <td class="td">
                 <select id="ispay" name="ispay">
                  <option value="0">否</option>
	              <option value="1">是</option>
				</select>
                </td>
            </tr>
            
        </table>
    </form>
</div>
</body>
</html>