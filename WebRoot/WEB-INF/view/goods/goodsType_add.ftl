<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-13 <br/>
描述：商品类别添加页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>商品类别添加</title>
    <#include "/WEB-INF/view/linkScript.ftl"/>
    <script type="text/javascript">
    	var parentId = getUrlParam('parentId');
        var parentRowData = window.parent.selectedRow;
        $(function(){
            $("body").layout();
            $('#form input.easyui-numberbox').numberbox();
            initData();
        });

        function initData() {
            if (parentId && parentId != "null") {
                $("#parent_id").attr("value", parentId);
                $("#level").attr("value", parentRowData.level + 1);
            } else {
                $("#level").attr("value", 1);
            }
        }
        
        function save() {
            if (!$("#form").form("validate")) return;
            var goodsType = $("#form").serializeJson();
            $.showLoad();
            $.ajaxPost("${path}/goods/goodsType_addSave.do", {"goodsType":goodsType}, function(result) {
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
                <td class="th">类型名称</td>
                <td class="td"><input type="text" id="name" name="name" class="input easyui-validatebox" validType="maxLength[20]" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">类型编码</td>
                <td class="td"><input type="text" id="number" name="number" class="input easyui-validatebox" validType="maxLength[20]" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">类型级别</td>
                <td class="td"><input type="text" id="level" readOnly="true" name="level" class="input easyui-numberbox" min="0" max="9999999999" precision="0" style="width:300px;background-color:#efefef;"/></td>
            </tr>
            <tr>
                <td class="th">上级id</td>
                <td class="td"><input type="text" readOnly="true" id="parent_id" name="parent_id" class="input easyui-numberbox" min="0" max="9999999999" precision="0" style="width:300px;background-color:#efefef;"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>