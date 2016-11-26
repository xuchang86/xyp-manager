<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-13 <br/>
描述：物品评论添加页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>物品评论添加</title>
    <#include "/WEB-INF/view/linkScript.ftl"/>
    <script type="text/javascript">
        $(function(){
            $("body").layout();
            $('#form input.easyui-numberbox').numberbox();
        });

        function save() {
            if (!$("#form").form("validate")) return;
            var goodsComment = $("#form").serializeJson();
            $.showLoad();
            $.ajaxPost("${path}/goods/goodsComment_addSave.do", {"goodsComment":goodsComment}, function(result) {
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
                <td class="th">评论人</td>
                <td class="td"><input type="text" id="user_id" name="user_id" class="input easyui-numberbox" min="0" max="9999999999" precision="0" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">评论时间</td>
                <td class="td"><input type="text" id="create_date" name="create_date" class="input Wdate" onclick="WdatePicker()" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">评论内容</td>
                <td class="td"><input type="text" id="content" name="content" class="input easyui-validatebox" validType="maxLength[500]" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">商品id</td>
                <td class="td"><input type="text" id="goods_id" name="goods_id" class="input easyui-numberbox" min="0" max="9999999999" precision="0" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">订单id</td>
                <td class="td"><input type="text" id="order_id" name="order_id" class="input easyui-numberbox" min="0" max="9999999999" precision="0" style="width:300px;"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>