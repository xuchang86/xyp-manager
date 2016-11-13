<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-13 <br/>
描述：会员成长规则查看页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>会员成长规则详细</title>
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
        <input type="hidden" id="id" name="id" value="${(membersRule.id)!}">
        <table class="table-border" width="100%">
            <col width="20%">
            <col width="80%">
            <tr>
                <td class="th">等级</td>
                <td class="td">${(membersRule.level)!}</td>
            </tr>
            <tr>
                <td class="th">升级数</td>
                <td class="td">${(membersRule.level_count)!}</td>
            </tr>
            <tr>
                <td class="th">资金池</td>
                <td class="td">${(membersRule.money_pool)!}</td>
            </tr>
            <tr>
                <td class="th">弟子给师傅的红包</td>
                <td class="td">${(membersRule.packet)!}</td>
            </tr>
            <tr>
                <td class="th">徒弟红包总数</td>
                <td class="td">${(membersRule.packet_count)!}</td>
            </tr>
            <tr>
                <td class="th">徒孙给师傅的红包</td>
                <td class="td">${(membersRule.child_packet)!}</td>
            </tr>
            <tr>
                <td class="th">徒孙给师傅的红包总数</td>
                <td class="td">${(membersRule.child_packet_count)!}</td>
            </tr>
            <tr>
                <td class="th">升级奖励</td>
                <td class="td">${(membersRule.upgrade_awards)!}</td>
            </tr>
            <tr>
                <td class="th">会员收入</td>
                <td class="td">${(membersRule.member_income)!}</td>
            </tr>
            <tr>
                <td class="th">平台收入</td>
                <td class="td">${(membersRule.platform_income)!}</td>
            </tr>
            <tr>
                <td class="th">弟子总数</td>
                <td class="td">${(membersRule.total_child)!}</td>
            </tr>
            <tr>
                <td class="th">备注</td>
                <td class="td">${(membersRule.remark)!}</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
