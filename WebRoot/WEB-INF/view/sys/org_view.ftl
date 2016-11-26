<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>标题</title>
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
    <table class="table-border" id="table" width="100%">
        <tbody>
        <tr>
            <td class="th" width="150">机构名称</td>
            <td class="td">${org.so_name}</td>
        </tr>
        <tr>
            <td class="th">机构编码</td>
            <td class="td">${org.so_code}</td>
        </tr>
        <tr>
            <td class="th">上级机构</td>
            <td class="td">${(org.so_parentname)!"无"}</td>
        </tr>
        <tr>
            <td class="th">联系方式</td>
            <td class="td">${org.so_contact}</td>
        </tr>
        <tr>
            <td class="th">邮箱地址</td>
            <td class="td">${org.so_email}</td>
        </tr>
        <tr>
            <td class="th">邮政编码</td>
            <td class="td">${org.so_post}</td>
        </tr>
        </tbody>
    </table>
    </div>

</div>
</body>
</html>