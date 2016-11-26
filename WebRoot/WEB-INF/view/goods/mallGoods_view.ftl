<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-13 <br/>
描述：商城商品查看页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>商城商品详细</title>
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
        <input type="hidden" id="id" name="id" value="${(mallGoods.id)!}">
        <table class="table-border" width="100%">
            <col width="20%">
            <col width="80%">
            <tr>
                <td class="th">商品名称</td>
                <td class="td">${(mallGoods.name)!}</td>
            </tr>
            <tr>
                <td class="th">商品描述</td>
                <td class="td">${(mallGoods.description)!}</td>
            </tr>
            <tr>
                <td class="th">商品编码</td>
                <td class="td">${(mallGoods.number)!}</td>
            </tr>
            <tr>
                <td class="th">商品类型id</td>
                <td class="td">${(mallGoods.type_id)!}</td>
            </tr>
            <tr>
                <td class="th">商品价格</td>
                <td class="td">${(mallGoods.price)!}</td>
            </tr>
            <tr>
                <td class="th">创建用户id</td>
                <td class="td">${(mallGoods.user_id)!}</td>
            </tr>
            <tr>
                <td class="th">创建日期</td>
                <td class="td"><@dateOut mallGoods.create_date/></td>
            </tr>
            <tr>
                <td class="th">商品图片</td>
                <td class="td">${(mallGoods.url)!}</td>
            </tr>
            <tr>
                <td class="th">商品地区</td>
                <td class="td">${(mallGoods.area)!}</td>
            </tr>
            <tr>
                <td class="th">是否出售</td>
                <td class="td">${(mallGoods.is_sale)!}</td>
            </tr>
            <tr>
                <td class="th">卖家id</td>
                <td class="td">${(mallGoods.seller_id)!}</td>
            </tr>
            <tr>
                <td class="th">会员价格</td>
                <td class="td">${(mallGoods.vip_price)!}</td>
            </tr>
            <tr>
                <td class="th">商品等级</td>
                <td class="td">${(mallGoods.level)!}</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
