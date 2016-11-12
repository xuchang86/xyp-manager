<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-12 <br/>
描述：逍遥派用户查看页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>逍遥派用户详细</title>
    <#include "/WEB-INF/view/linkScript.ftl"/>
    <script type="text/javascript">
        $(function(){
            $("body").layout();
        });
    </script>
</head>
<body class="easyui-layout">
<div region="north" style="height:32px; background-color: #EFEFEF;border-bottom: 1px solid #99bbe8;" border="false">
    <div style="padding: 2px;">
        <a href="javascript:window.location.reload();" class="easyui-linkbutton" icon="icon-reload" plain="true">刷新</a>
        <a href="javascript:window.parent.$.closeDialog('dialog');" class="easyui-linkbutton" icon="icon-cancel" plain="true">关闭</a>
    </div>
</div>
<div region="center" border="false" style="padding:10px;">
    <div style="+zoom:1;">
        <input type="hidden" id="id" name="id" value="${(loginUser1.id)!}">
        <table class="table-border" width="100%">
            <col width="20%">
            <col width="80%">
            <tr>
                <td class="th">电话</td>
                <td class="td">${(loginUser1.phone)!}</td>
            </tr>
            <tr>
                <td class="th">密码</td>
                <td class="td">${(loginUser1.password)!}</td>
            </tr>
            <tr>
                <td class="th">名称</td>
                <td class="td">${(loginUser1.name)!}</td>
            </tr>
            <tr>
                <td class="th">生日</td>
                <td class="td"><@dateOut loginUser1.birthday/></td>
            </tr>
            <tr>
                <td class="th">地址</td>
                <td class="td">${(loginUser1.address)!}</td>
            </tr>
            <tr>
                <td class="th">我提供的资源</td>
                <td class="td">${(loginUser1.providerid)!}</td>
            </tr>
            <tr>
                <td class="th">我需要的资源</td>
                <td class="td">${(loginUser1.requiredid)!}</td>
            </tr>
            <tr>
                <td class="th">城市</td>
                <td class="td">${(loginUser1.city)!}</td>
            </tr>
            <tr>
                <td class="th">性别</td>
                <td class="td">${(loginUser1.sex)!}</td>
            </tr>
            <tr>
                <td class="th">用户名</td>
                <td class="td">${(loginUser1.username)!}</td>
            </tr>
            <tr>
                <td class="th">是否已付款</td>
                <td class="td">${(loginUser1.ispay)!}</td>
            </tr>
            <tr>
                <td class="th">个人头像</td>
                <td class="td">${(loginUser1.url)!}</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
