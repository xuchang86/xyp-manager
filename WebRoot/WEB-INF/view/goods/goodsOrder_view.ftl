<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-13 <br/>
描述：商品订单查看页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>商品订单详细</title>
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
        <input type="hidden" id="id" name="id" value="${(goodsOrder.id)!}">
        <table class="table-border" width="100%">
            <col width="20%">
            <col width="80%">
            <tr>
                <td class="th">订单号</td>
                <td class="td">${(goodsOrder.number)!}</td>
            </tr>
            <tr>
                <td class="th">商品名称</td>
                <td class="td">${(goodsOrder.goods_name)!}</td>
            </tr>
            <tr>
                <td class="th">商品型号</td>
                <td class="td">${(goodsOrder.goods_model)!}</td>
            </tr>
            <tr>
                <td class="th">收货城市</td>
                <td class="td">${(goodsOrder.address_name)!}</td>
            </tr>
            <tr>
                <td class="th">收货地址</td>
                <td class="td">${(goodsOrder.address)!}</td>
            </tr>
            <tr>
                <td class="th">联系人</td>
                <td class="td">${(goodsOrder.contacts)!}</td>
            </tr>
            <tr>
                <td class="th">联系电话</td>
                <td class="td">${(goodsOrder.phone)!}</td>
            </tr>
            <tr>
                <td class="th">订单状态</td>
                <td class="td">
                    <#if goodsOrder.state=="todo">
                    待付款
                    <#elseif goodsOrder.state=="paying">
                    已付款
                    <#elseif goodsOrder.state=="to">
                    已发货
                    <#elseif goodsOrder.state=="get">
                    已收货
                    <#elseif goodsOrder.state=="after_sale">
                    售后
                    <#elseif goodsOrder.state=="sales_return">
                    退货
                    <#else>
                    </#if>
                </td>
            </tr>
            <tr>
                <td class="th">创建时间</td>
                <td class="td"><@dateOut goodsOrder.create_date/></td>
            </tr>
            <tr>
                <td class="th">付款时间</td>
                <td class="td"><@dateOut goodsOrder.pay_date/></td>
            </tr>
            <tr>
                <td class="th">创建用户</td>
                <td class="td">${(goodsOrder.user_name)!}</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
