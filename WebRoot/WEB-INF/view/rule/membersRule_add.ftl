<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-13 <br/>
描述：会员成长规则添加页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>会员成长规则添加</title>
    <#include "/WEB-INF/view/linkScript.ftl"/>
    <script type="text/javascript">
        $(function(){
            $("body").layout();
            $('#form input.easyui-numberbox').numberbox();
        });

        function save() {
            if (!$("#form").form("validate")) return;
            var membersRule = $("#form").serializeJson();
            $.showLoad();
            $.ajaxPost("${path}/rule/membersRule_addSave.do", {"membersRule":membersRule}, function(result) {
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
                <td class="th">等级</td>
                <td class="td"><input type="text" id="level" name="level" class="input easyui-numberbox" min="0" max="9999999999" precision="0" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">升级数</td>
                <td class="td"><input type="text" id="level_count" name="level_count" class="input easyui-numberbox" min="0" max="9999999999" precision="0" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">资金池</td>
                <td class="td"><input type="text" id="money_pool" name="money_pool" class="input easyui-numberbox" min="0" max="99999999.99" precision="2" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">弟子给师傅的红包</td>
                <td class="td"><input type="text" id="packet" name="packet" class="input easyui-numberbox" min="0" max="99999999.99" precision="2" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">徒弟红包总数</td>
                <td class="td"><input type="text" id="packet_count" name="packet_count" class="input easyui-numberbox" min="0" max="9999999999" precision="0" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">徒孙给师傅的红包</td>
                <td class="td"><input type="text" id="child_packet" name="child_packet" class="input easyui-numberbox" min="0" max="99999999.99" precision="2" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">徒孙给师傅的红包总数</td>
                <td class="td"><input type="text" id="child_packet_count" name="child_packet_count" class="input easyui-numberbox" min="0" max="9999999999" precision="0" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">升级奖励</td>
                <td class="td"><input type="text" id="upgrade_awards" name="upgrade_awards" class="input easyui-numberbox" min="0" max="99999999.99" precision="2" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">会员收入</td>
                <td class="td"><input type="text" id="member_income" name="member_income" class="input easyui-numberbox" min="0" max="99999999.99" precision="2" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">平台收入</td>
                <td class="td"><input type="text" id="platform_income" name="platform_income" class="input easyui-numberbox" min="0" max="99999999.99" precision="2" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">弟子总数</td>
                <td class="td"><input type="text" id="total_child" name="total_child" class="input easyui-numberbox" min="0" max="9999999999" precision="0" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">备注</td>
                <td class="td"><input type="text" id="remark" name="remark" class="input easyui-validatebox" validType="maxLength[100]" style="width:300px;"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>