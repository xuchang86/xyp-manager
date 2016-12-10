<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-12-10 <br/>
描述：提现记录查看页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>提现记录详细</title>
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
        <input type="hidden" id="id" name="id" value="${(transferRecord.id)!}">
        <table class="table-border" width="100%">
            <col width="20%">
            <col width="80%">
            <tr>
                <td class="th">提现金额</td>
                <td class="td">${(transferRecord.amount)!}</td>
            </tr>

            <tr>
                <td class="th">提现日期</td>
                <td class="td"><@dateOut transferRecord.date/></td>
            </tr>
            <tr>
                <td class="th">提现人</td>
                <td class="td">${(transferRecord.operator)!}</td>
            </tr>
            <tr>
                <td class="th">提现账户</td>
                <td class="td">${(transferRecord.account)!}</td>
            </tr>
            <tr>
                <td class="th">提现银行</td>
                <td class="td">${(transferRecord.account_name)!}</td>
            </tr>
            
        </table>
    </div>
</div>
</body>
</html>
