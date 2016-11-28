<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-13 <br/>
描述：物品评论查看页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>物品评论详细</title>
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
        <input type="hidden" id="id" name="id" value="${(goodsComment.id)!}">
        <table class="table-border" width="100%">
            <col width="20%">
            <col width="80%">
            <tr>
                <td class="th">评论人</td>
                <td class="td">${(goodsComment.user_name)!}</td>
            </tr>
            <tr>
                <td class="th">评论时间</td>
                <td class="td"><@dateOut goodsComment.create_date/></td>
            </tr>
            <tr>
                <td class="th">评论内容</td>
                <td class="td">${(goodsComment.content)!}</td>
            </tr>
            <tr>
                <td class="th">商品</td>
                <td class="td">${(goodsComment.goods_name)!}</td>
            </tr>
            <tr>
                <td class="th">订单</td>
                <td class="td">${(goodsComment.order_name)!}</td>
            </tr>
            <tr>
                <td class="th">评分</td>
                <td class="td">${(goodsComment.score)!}</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
