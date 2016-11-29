<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-13 <br/>
描述：人物信息添加页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>人物信息添加</title>
    <#include "/WEB-INF/view/linkScript.ftl"/>
    <script type="text/javascript">
        $(function(){
            $("body").layout();
            $('#form input.easyui-numberbox').numberbox();
        });

        function save() {
            if (!$("#form").form("validate")) return;
            var basePerson = $("#form").serializeJson();
            $.showLoad();
            $.ajaxPost("${path}/person/basePerson_addSave.do", {"basePerson":basePerson}, function(result) {
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

        var creatorClick = function(){
            var url = "${path}/login/loginUser_main.do?from=f7";
            var width = 800; //窗口宽度
            var height = 400; //窗口高度
            var top = (window.screen.height - 30 - height) / 2;
            var left = (window.screen.width - 10 - width) / 2;
            window.open(url, "_blank", "Scrollbars=no,Toolbar=no,Location=no,titlebar=no,Direction=no,Resizeable=no,alwaysLowered=yes,Width=" + width + " ,Height=" + height + ",top=" + top + ",left=" + left);
        }

        function personClick(){
            var url = "${path}/person/basePerson_main.do?from=f7";
            var width = 800; //窗口宽度
            var height = 400; //窗口高度
            var top = (window.screen.height - 30 - height) / 2;
            var left = (window.screen.width - 10 - width) / 2;
            window.open(url, "_blank", "Scrollbars=no,Toolbar=no,Location=no,titlebar=no,Direction=no,Resizeable=no,alwaysLowered=yes,Width=" + width + " ,Height=" + height + ",top=" + top + ",left=" + left);
        }

        function userCallBack(rowData){
            $("#phone").val(rowData.phone);
            $("#user_id").val(rowData.id);
            $("#name").val(rowData.name);
        }

        function personCallBack(rowData){
            $("#parent_name").val(rowData.name);
            $("#parent_id").val(rowData.id);
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
               <td class="th">用户手机</td>
               <td class="td">
                   <input type="text" id="phone" name="phone" onclick="creatorClick()" class="input search" value="${(basePerson.phone)!}" style="width:300px;"/>
                   <input type="hidden" id="user_id" name="user_id" class="input easyui-numberbox" min="0" max="9999999999" precision="0" value="${(basePerson.user_id)!}" style="width:300px;"/>
               </td>
            </tr>
            <tr>
                <td class="th">人物名称</td>
                <td class="td">
                    <input type="text" id="name" name="name" class="input easyui-validatebox" validType="maxLength[20]" style="width:300px;"/>

                </td>
            </tr>
            <tr>
                <td class="th">师傅名称</td>
                <td class="td">
                   <input type="text" id="parent_name" name="parent_name" onclick="personClick()" class="input search" value="${(basePerson.parent_name)!}" style="width:300px;"/>
                   <input type="hidden" id="parent_id" name="parent_id" class="input easyui-numberbox" min="0" max="9999999999" precision="0" value="${(basePerson.parent_id)!}" style="width:300px;"/>
                </td>
            </tr>
            
            <tr>
                <td class="th">级别</td>
                <td class="td">
                     <select id="level" name="level">
                      <option value="1">见习弟子</option> 
                      <option value="2">精英弟子</option>
                      <option value="3">副组长</option>
                      <option value="4">组长</option> 
                      <option value="5" >副队长</option>
                      <option value="6" >队长</option>
                      <option value="7" >副堂主</option>
                      <option value="8" >堂主</option>
                      <option value="9" >副舵主</option>
                      <option value="10" >舵主</option>
                      <option value="11" >青龙护法</option>
                      <option value="12" >白虎护法</option>
                      <option value="13" >朱雀护法</option>
                      <option value="14" >玄武护法</option>
                      <option value="15">逍遥左使</option>
                      <option value="16">逍遥右使</option>
                      <option value="17">大长老</option>
                      <option value="18">副掌门</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="th">逍遥币</td>
                <td class="td"><input type="text" id="bill" name="bill" class="input easyui-numberbox" min="0" max="99999999.99" precision="2" style="width:300px;"/></td>
            </tr>
            
            <tr>
                <td class="th">创建时间</td>
                <td class="td"><input type="text" id="create_date" name="create_date" class="input Wdate" onclick="WdatePicker()" style="width:300px;"/></td>
            </tr>
           
        </table>
    </form>
</div>
</body>
</html>