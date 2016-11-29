<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-12 <br/>
描述：逍遥派用户修改页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>逍遥派用户修改</title>
    <#include "/WEB-INF/view/linkScript.ftl"/>
    <script type="text/javascript">
        $(function(){
            $("body").layout();
            $('#form input.easyui-numberbox').numberbox();
        });

        function save() {
            if (!$("#form").form("validate")) return;
            var loginUser1 = $("#form").serializeJson();
            $.showLoad();
            $.ajaxPost("${path}/login/loginUser_editSave.do", {"loginUser1":loginUser1}, function(result) {
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
        <input type="hidden" id="id" name="id"  value="${(loginUser1.id)!}">
        <table class="table-border" width="100%">
            <col width="20%">
            <col width="80%">
            <tr>
                <td class="th">电话</td>
                <td class="td"><input type="text" id="phone" name="phone" class="input easyui-validatebox" validType="maxLength[20]" value="${(loginUser1.phone)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">密码</td>
                <td class="td"><input type="text" id="password" name="password" class="input easyui-validatebox" validType="maxLength[50]" value="${(loginUser1.password)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">名称</td>
                <td class="td"><input type="text" id="name" name="name" class="input easyui-validatebox" validType="maxLength[20]" value="${(loginUser1.name)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">生日</td>
                <td class="td"><input type="text" id="birthday" name="birthday" class="input Wdate" onclick="WdatePicker()" value="<@dateOut loginUser1.birthday/>" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">地址</td>
                <td class="td"><input type="text" id="address" name="address" class="input easyui-validatebox" validType="maxLength[50]" value="${(loginUser1.address)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">我提供的资源</td>
                <td class="td"><input type="text" id="providerid" name="providerid" class="input easyui-validatebox" validType="maxLength[20]" value="${(loginUser1.providerid)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">我需要的资源</td>
                <td class="td"><input type="text" id="requiredid" name="requiredid" class="input easyui-validatebox" validType="maxLength[20]" value="${(loginUser1.requiredid)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">城市</td>
                <td class="td"><input type="text" id="city" name="city" class="input easyui-validatebox" validType="maxLength[20]" value="${(loginUser1.city)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">性别</td>
                <td class="td">
                <select>
                  <option value="0" <#if loginUser1.sex=="0">selected</#if>>男</option>
	              <option value="1" <#if loginUser1.sex=="1">selected</#if>>女</option>
				</select>
                </td>
            </tr>
            <tr>
                <td class="th">用户名</td>
                <td class="td"><input type="text" id="username" name="username" class="input easyui-validatebox" validType="maxLength[15]" value="${(loginUser1.username)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">是否已付款</td>
                <td class="td">
                <select>
                  <option value="0" <#if loginUser1.ispay=="0">selected</#if>>否</option>
	              <option value="1" <#if loginUser1.ispay=="1">selected</#if>>是</option>
				</select>
                </td>
            </tr>
            <tr>
                <td class="th">个人头像</td>
                <td class="td"><input type="text" id="url" name="url" class="input easyui-validatebox" validType="maxLength[100]" value="${(loginUser1.url)!}" style="width:300px;"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>