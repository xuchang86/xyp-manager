<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-13 <br/>
描述：商品订单修改页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>商品订单修改</title>
    <#include "/WEB-INF/view/linkScript.ftl"/>
    <script type="text/javascript">
        $(function(){
            $("body").layout();
            $('#form input.easyui-numberbox').numberbox();
        });

        function save() {
            if (!$("#form").form("validate")) return;
            var goodsOrder = $("#form").serializeJson();
            $.showLoad();
            $.ajaxPost("${path}/goods/goodsOrder_editSave.do", {"goodsOrder":goodsOrder}, function(result) {
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

        var creatorClick = function(){
            var url = "${path}/login/loginUser_main.do?from=f7";
            var width = 800; //窗口宽度
            var height = 400; //窗口高度
            var top = (window.screen.height - 30 - height) / 2;
            var left = (window.screen.width - 10 - width) / 2;
            window.open(url, "_blank", "Scrollbars=no,Toolbar=no,Location=no,titlebar=no,Direction=no,Resizeable=no,alwaysLowered=yes,Width=" + width + " ,Height=" + height + ",top=" + top + ",left=" + left);
        }

        var goodsClick = function(){
            var url = "${path}/goods/mallGoods_main.do?from=f7";
            var width = 800; //窗口宽度
            var height = 400; //窗口高度
            var top = (window.screen.height - 30 - height) / 2;
            var left = (window.screen.width - 10 - width) / 2;
            window.open(url, "_blank", "Scrollbars=no,Toolbar=no,Location=no,titlebar=no,Direction=no,Resizeable=no,alwaysLowered=yes,Width=" + width + " ,Height=" + height + ",top=" + top + ",left=" + left);
        }

        function addressClick(){
            var url = "${path}/goods/userAddress_main.do?from=f7";
            var width = 800; //窗口宽度
            var height = 400; //窗口高度
            var top = (window.screen.height - 30 - height) / 2;
            var left = (window.screen.width - 10 - width) / 2;
            window.open(url, "_blank", "Scrollbars=no,Toolbar=no,Location=no,titlebar=no,Direction=no,Resizeable=no,alwaysLowered=yes,Width=" + width + " ,Height=" + height + ",top=" + top + ",left=" + left);
        }

        function userCallBack(rowData){
            $("#user_id").val(rowData.id);
            $("#user_name").val(rowData.name);
        }

        function addressCallBack(rowData){
            $("#address_id").val(rowData.id);
            $("#address_name").val(rowData.address);
        }

        function goodsCallBack(rowData){
            $("#goods_id").val(rowData.id);
            $("#goods_name").val(rowData.name);
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
        <input type="hidden" id="id" name="id"  value="${(goodsOrder.id)!}">
        <table class="table-border" width="100%">
            <col width="20%">
            <col width="80%">
            <tr>
                <td class="th">订单号</td>
                <td class="td"><input type="text" id="number" name="number" class="input easyui-validatebox" validType="maxLength[20]" value="${(goodsOrder.number)!}" style="width:300px;"/></td>
            </tr>
            
            <tr>
                <td class="th">商品名称</td>
                <td class="td">
                    <input type="text" id="goods_name" name="goods_name" onclick="goodsClick()" class="input search" value="${(goodsOrder.goods_name)!}" style="width:300px;"/>

                    <input type="hidden" id="goods_id" name="goods_id" class="input easyui-validatebox" validType="maxLength[20]" value="${(goodsOrder.goods_id)!}" style="width:300px;"/>
                </td>
            </tr>

            <tr>
                <td class="th">商品型号</td>
                <td class="td"><input type="text" id="goods_model" name="goods_model" class="input easyui-validatebox" validType="maxLength[20]" value="${(goodsOrder.goods_model)!}" style="width:300px;"/></td>
            </tr>
           
            <tr>
                <td class="th">收货地址</td>
                <td class="td"><input type="text" id="address" name="address" class="input easyui-validatebox" validType="maxLength[50]" value="${(goodsOrder.address)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">详细地址</td>
                <td class="td">
                    <input type="text" id="address_name" name="address_name" onclick="addressClick()" class="input search" value="${(goodsOrder.address_name)!}" style="width:300px;"/>
                    <input type="hidden" id="address_id" name="address_id" class="input easyui-validatebox" validType="maxLength[50]" value="${(goodsOrder.address_id)!}" style="width:300px;"/>
                </td>
            </tr>
            <tr>
                <td class="th">联系人</td>
                <td class="td"><input type="text" id="contacts" name="contacts" class="input easyui-validatebox" validType="maxLength[10]" value="${(goodsOrder.contacts)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">联系电话</td>
                <td class="td"><input type="text" id="phone" name="phone" class="input easyui-validatebox" validType="maxLength[20]" value="${(goodsOrder.phone)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">订单状态</td>
                <td class="td">
                    <select id="state" name="state">
                        <option value="" <#if !goodsOrder.state>selected="selected"</#if> ></option>
                        <option value="todo" <#if goodsOrder.state=="todo">selected="selected"</#if>>待付款</option>
                        <option value="paying" <#if goodsOrder.state=="paying">selected="selected"</#if>>已付款</option>
                        <option value="to" <#if goodsOrder.state=="to">selected="selected"</#if>>已发货</option>
                        <option value="get" <#if goodsOrder.state=="get">selected="selected"</#if>>已收货</option>
                        <option value="after_sale" <#if goodsOrder.state=="after_sale">selected="selected"</#if>>售后</option>
                        <option value="sales_return" <#if goodsOrder.state=="sales_return">selected="selected"</#if>>退货</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="th">创建用户</td>
                <td class="td">
                    <input type="text" id="user_name" name="user_name" onclick="creatorClick()" class="input search" value="${(goodsOrder.user_name)!}" style="width:300px;"/>
                    <input type="hidden" id="user_id" name="user_id" class="input easyui-numberbox" min="0" max="9999999999" precision="0" value="${(goodsOrder.user_id)!}" style="width:300px;"/>
                </td>
            </tr>
            <tr>
                <td class="th">创建时间</td>
                <td class="td"><input type="text" id="create_date" name="create_date" class="input Wdate" onclick="WdatePicker()" value="<@dateOut goodsOrder.create_date/>" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">付款时间</td>
                <td class="td"><input type="text" id="pay_date" name="pay_date" class="input Wdate" onclick="WdatePicker()" value="<@dateOut goodsOrder.pay_date/>" style="width:300px;"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>