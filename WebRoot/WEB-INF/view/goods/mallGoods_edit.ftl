<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-13 <br/>
描述：商城商品修改页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>商城商品修改</title>
    <#include "/WEB-INF/view/linkScript.ftl"/>
    <script type="text/javascript">
        $(function(){
            $("body").layout();
            $('#form input.easyui-numberbox').numberbox();
        });

        function save() {
            if (!$("#form").form("validate")) return;
            var mallGoods = $("#form").serializeJson();
            $.showLoad();
            $.ajaxPost("${path}/goods/mallGoods_editSave.do", {"mallGoods":mallGoods}, function(result) {
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
        <input type="hidden" id="id" name="id"  value="${(mallGoods.id)!}">
        <table class="table-border" width="100%">
            <col width="20%">
            <col width="80%">
            <tr>
                <td class="th">商品名称</td>
                <td class="td"><input type="text" id="name" name="name" class="input easyui-validatebox" validType="maxLength[20]" value="${(mallGoods.name)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">商品描述</td>
                <td class="td"><input type="text" id="description" name="description" class="input easyui-validatebox" validType="maxLength[150]" value="${(mallGoods.description)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">商品编码</td>
                <td class="td"><input type="text" id="number" name="number" class="input easyui-validatebox" validType="maxLength[20]" value="${(mallGoods.number)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">商品类型id</td>
                <td class="td"><input type="text" id="type_id" name="type_id" class="input easyui-numberbox" min="0" max="9999999999" precision="0" value="${(mallGoods.type_id)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">商品价格</td>
                <td class="td"><input type="text" id="price" name="price" class="input easyui-numberbox" min="0" max="99999999.99" precision="2" value="${(mallGoods.price)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">创建用户id</td>
                <td class="td"><input type="text" id="user_id" name="user_id" class="input easyui-numberbox" min="0" max="9999999999" precision="0" value="${(mallGoods.user_id)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">创建日期</td>
                <td class="td"><input type="text" id="create_date" name="create_date" class="input Wdate" onclick="WdatePicker()" value="<@dateOut mallGoods.create_date/>" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">商品图片</td>
                <td class="td"><input type="text" id="url" name="url" class="input easyui-validatebox" validType="maxLength[100]" value="${(mallGoods.url)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">商品地区</td>
                <td class="td"><input type="text" id="area" name="area" class="input easyui-validatebox" validType="maxLength[20]" value="${(mallGoods.area)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">是否出售</td>
                <td class="td"><input type="text" id="is_sale" name="is_sale" class="input easyui-numberbox" min="0" max="999" precision="0" value="${(mallGoods.is_sale)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">卖家id</td>
                <td class="td"><input type="text" id="seller_id" name="seller_id" class="input easyui-numberbox" min="0" max="9999999999" precision="0" value="${(mallGoods.seller_id)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">会员价格</td>
                <td class="td"><input type="text" id="vip_price" name="vip_price" class="input easyui-numberbox" min="0" max="99999999.99" precision="2" value="${(mallGoods.vip_price)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">商品等级</td>
                <td class="td"><input type="text" id="level" name="level" class="input easyui-numberbox" min="0" max="9999999999" precision="0" value="${(mallGoods.level)!}" style="width:300px;"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>