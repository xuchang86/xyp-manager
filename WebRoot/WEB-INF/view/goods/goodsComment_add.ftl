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

        /**
         * 选择项目
         */
        function selectProject(strTitle,strUrl){
        	$("#dialog").css("display","block").dialog({
                title: strTitle,
                width:window.$.autoWidth(),
                height:window.$.autoHeight(),
                onMove:function(left,top){$.adjustPosition("dialog",left,top)},
                onBeforeClose:function(){$.restoreDialog("dialog")}
            });
        	
            $("#iframe").attr("src", strUrl);
        }
        
        /**
         * 选择评论人——回调
         */
        function selectUser(hospitals){
        	var hosId=hospitals[0].id;
        	var hosName=hospitals[0].name;
        	$("#user_id").attr("value",hosId);
        	$("#user_name").attr("value",hosName);
        }
        /**
         * 选择商品——回调
         */
        function selectGoods(hospitals){
        	var hosId=hospitals[0].id;
        	var hosName=hospitals[0].name;
        	$("#goods_id").attr("value",hosId);
        	$("#goods_name").attr("value",hosName);
        }
        /**
         * 选择订单——回调
         */
        function selectOrder(hospitals){
        	var hosId=hospitals[0].id;
        	var hosName=hospitals[0].number;
        	$("#order_id").attr("value",hosId);
        	$("#order_name").attr("value",hosName);
        }
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
                <td class="td">
	                <input type="text" id="user_name" name="user_name" class="input easyui-validatebox" validType="maxLength[100]" style="width:300px;"/>
	            	<input type="button" onclick="selectProject('选择评论人','${path}/login/loginUser_select.do?callback=selectUser')" value="选择评论人">
	            	<input type="text" id="user_id" name="user_id" style="width:300px;visibility:hidden;"/>
                </td>
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
                <td class="th">商品</td>
                <td class="td">
	                <input type="text" id="goods_name" name="goods_name" class="input easyui-validatebox" validType="maxLength[100]" style="width:300px;"/>
	            	<input type="button" onclick="selectProject('选择商品','${path}/goods/mallGoods_select.do?callback=selectGoods')" value="选择商品">
	            	<input type="text" id="goods_id" name="goods_id" style="width:300px;visibility:hidden;"/>
                </td>
            </tr>
            <tr>
                <td class="th">订单</td>
                <td class="td">
	                <input type="text" id="order_name" name="order_name" class="input easyui-validatebox" validType="maxLength[100]" style="width:300px;"/>
	            	<input type="button" onclick="selectProject('选择订单','${path}/goods/goodsOrder_select.do?callback=selectOrder')" value="选择订单">
	            	<input type="text" id="order_id" name="order_id" style="width:300px;visibility:hidden;"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="dialog" style="width:800px;height:400px; overflow:hidden;display: none" resizable="true" maximizable="true" modal="true">
<iframe id="iframe" name="iframe" scrolling="auto" src="about:blank" style="width:100%;height:100%;" frameborder="0" ></iframe>
</div>

</body>
</html>