<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-13 <br/>
描述：发布的活动,任务,悬赏查看页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>发布的活动,任务,悬赏详细</title>
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
        <input type="hidden" id="id" name="id" value="${(publishActivity.id)!}">
        <table class="table-border" width="100%">
            <col width="20%">
            <col width="80%">
            <tr>
                <td class="th">活动类型</td>
                <td class="td">${(publishActivity.type)!}</td>
            </tr>
            <tr>
                <td class="th">发布地址</td>
                <td class="td">${(publishActivity.address)!}</td>
            </tr>
            <tr>
                <td class="th">发布内容</td>
                <td class="td">${(publishActivity.content)!}</td>
            </tr>
            <tr>
                <td class="th">日志</td>
                <td class="td"><@dateOut publishActivity.date/></td>
            </tr>
            <tr>
                <td class="th">人物ID</td>
                <td class="td">${(publishActivity.person_id)!}</td>
            </tr>
            <tr>
                <td class="th">费用</td>
                <td class="td">${(publishActivity.cost)!}</td>
            </tr>
            <tr>
                <td class="th">城市</td>
                <td class="td">${(publishActivity.city)!}</td>
            </tr>
            <tr>
                <td class="th">活动方式</td>
                <td class="td">${(publishActivity.way)!}</td>
            </tr>
            <tr>
                <td class="th">付款方式</td>
                <td class="td">${(publishActivity.payway)!}</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
