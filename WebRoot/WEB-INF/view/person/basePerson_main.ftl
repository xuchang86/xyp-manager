<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-13 <br/>
描述：人物信息主页面
-->
<#include "/WEB-INF/view/macro.ftl"/>

<#assign checkAdd = check("添加")>
<#assign checkEdit = check("修改")>
<#assign checkDelete= check("删除")>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>人物信息管理</title>
    <#include "/WEB-INF/view/linkScript.ftl"/>
    <script type="text/javascript">
        $(function() {
            $("body").layout();
            $("#form").css("display","block");

            $("#table").datagrid({
                onLoadError:showError,
                sortName:"id",    
                sortOrder:"asc",        
                pageNumber:1,           
                pageSize:20,            
                queryParams:{"refresh":"1"},
                onLoadSuccess:function(data){
                    delete $("#table").datagrid("options").queryParams.refresh;
                },
                frozenColumns:[[
                    {field:'ck',checkbox:true},
                    {title:'操作',field:'id',width:120,sortable:false,align:"center",
                        formatter:function(value, data, index){
                            var link= "<a href=\"javascript:void(0)\" onclick=\"view(event, '" + value + "')\">查看</a>&nbsp;";
                            <#if checkEdit>
                            link+="<a href=\"javascript:void(0)\" onclick=\"edit(event, '" + value + "')\">修改</a>&nbsp;";
                            <#else>
                            link+="<span style='color:#808080'>修改</span>&nbsp;";
                            </#if>
                            <#if checkDelete>
                            link+="<a href=\"javascript:void(0)\" onclick=\"del(event, '" + value + "')\">删除</a>&nbsp;";
                            <#else>
                            link+="<span style='color:#808080'>删除</span>&nbsp;";
                            </#if>
                            return link;
                        }
                    }
                ]],
                columns:[[
                    {title:'用户id',field:'user_id',width:150,sortable:true},
                    {title:'级别',field:'level',width:150,sortable:true,
                     formatter: function(value, data, index) {
							if (value == 1) {
								return "见习弟子";
							} else if (value == 2) {
								return "精英弟子";
							} else if (value == 3) {
								return "副组长";
							} else if (value == 4) {
								return "组长";
							} else if (value == 5) {
								return "副队长";
							} else if (value == 6) {
								return "队长";
							} else if (value == 7) {
								return "副堂主";
							} else if (value == 8) {
								return "堂主";
							} else if (value == 9) {
								return "副舵主";
							} else if (value == 10) {
								return "舵主";
							} else if (value == 11) {
								return "青龙护法";
							} else if (value == 12) {
								return "白虎护法";
							} else if (value == 13) {
								return "朱雀护法";
							} else if (value == 14) {
								return "玄武护法";
							} else if (value == 15) {
								return "逍遥左使";
							} else if (value == 16) {
								return "逍遥右使";
							} else if (value == 17) {
								return "大长老";
							} else if (value == 18) {
								return "副掌门";
							}
							return "";
						}
                    },
                    {title:'逍遥币',field:'bill',width:150,sortable:true},
                    {title:'师傅id',field:'parent_id',width:150,sortable:true},
                    {title:'创建时间',field:'create_date',width:150,sortable:true},
                    {title:'名称',field:'name',width:150,sortable:true}
                ]],
                toolbar:[
                    {
                        handler:refreshPage,
                        text:"刷新",
                        iconCls:"icon-reload"
                    },
                    "-",
                    {
                        <#if checkAdd>
                        handler:add,
                        <#else>
                        disabled:true,
                        </#if>
                        text:"添加",
                        iconCls:"icon-add"
                    },
                    {
                        <#if checkDelete>
                        handler:delBatch,
                        <#else>
                        disabled:true,
                        </#if>
                        text:"删除",
                        iconCls:"icon-remove"
                    }
                ]
            });
        });

        /**
         * 显示人物信息添加对话框
         */
        function add() {
            $("#dialog").css("display","block").dialog({
                title: "记录添加",
                width:window.$.autoWidth(),
                height:window.$.autoHeight(),
                onMove:function(left,top){$.adjustPosition("dialog",left,top)},
                onBeforeClose:function(){$.restoreDialog("dialog")}
            });
            $("#iframe").attr("src", "${path}/person/basePerson_add.do");
        }

        /**
         * 显示人物信息修改对话框
         */
        function edit(event, value) {
            $.event.fix(event).stopPropagation();
            $("#dialog").css("display","block").dialog({
                title: "记录修改",
                width:window.$.autoWidth(),
                height:window.$.autoHeight(),
                onMove:function(left,top){$.adjustPosition("dialog",left,top)},
                onBeforeClose:function(){$.restoreDialog("dialog")}
            });
            $("#iframe").attr("src","${path}/person/basePerson_edit.do?id="+value);
        }

        /**
         * 删除人物信息
         */
        function del(event,val) {
            $.event.fix(event).stopPropagation();
            $.messager.confirm("提示信息", "你确认要删除该记录吗？", function(b) {
                if (b) {
                    $.ajaxPost("${path}/person/basePerson_delete.do",{"id":val},function(result){
                        $.messager.show({
                            title:"消息提醒",
                            msg:"记录删除成功",
                            timeout:5000,
                            showType:"slide"
                        });
                        reloadPage();
                    });
                }
            });
        }

        /**
         * 批量删除人物信息
         */
        function delBatch(){
            var selections=$("#table").datagrid("getSelections");
            if(selections.length==0){
                $.messager.alert("系统提示", "请选择你要删除的记录", "info");  
            }
            else{
                $.messager.confirm("系统提示", "你确认要删除所选择的记录吗？", function(b){
                    if(b){
                        var ids=new Array();
                        $.each(selections,function(i,o){
                           ids.push(o.id);
                        });

                        $.ajaxPost("${path}/person/basePerson_deleteBatch.do", {"ids":ids}, function(result) {
                            $.messager.show({
                                title:"消息提醒",
                                msg:"记录删除成功",
                                timeout:5000,
                                showType:"slide"
                            });
                            reloadPage();
                        });
                    }
                });
            }
        }

        /**
         * 查看人物信息详细
         */
        function view(event,value){
            $.event.fix(event).stopPropagation();
            $("#dialog").css("display","block").dialog({
                title: "详细查看",
                width:window.$.autoWidth(),
                height:window.$.autoHeight(),
                onMove:function(left,top){$.adjustPosition("dialog",left,top)},
                onBeforeClose:function(){$.restoreDialog("dialog")}
            });
            $("#iframe").attr("src","${path}/person/basePerson_view.do?id="+value);
        }

        /**
         * 刷新页面
         */
        function refreshPage(){
            window.location="${path}/person/basePerson_main.do";
            return false;
        }

        /**
         * 重载表格数据,刷新当前页 (添加、修改、删除后)
         */
        function reloadPage(){
            $("#table").datagrid("options").queryParams.refresh="1";
            $("#table").datagrid("clearSelections").datagrid("reload");
        }

          /**
         * 查询翻页
         */
        function searchPage(reset) {
            if(reset) {
                $("#form input:text").val(""); //重置查询表单
                $("#form input.combobox-f").combobox("clear");
                $("#form select").val("");
            }

            var basePerson = $("#form").serializeJson();
            basePerson.refresh = "1"; //刷新记录数参数
            $("#table").datagrid("clearSelections").datagrid("load",basePerson);
        }
    </script>
</head>
<body class="easyui-layout">
<div region="west" split="true" border="true" title="操作面板" style="width:250px;padding:10px;">
    <form id="form" name="form" style="display: none">
        <table class="table">
            <tr>
                <td class="th">用户id</td>
                <td class="td"><input id="user_id" name="user_id" type="text" class="input easyui-numberbox" min="0" max="9999999999" precision="0"/></td>
            </tr>
            <tr>
                <td class="th">用户id</td>
                <td class="td"><input id="user_id_min" name="user_id_min" type="text" class="input easyui-numberbox" min="0" max="9999999999" precision="0"/></td>
            </tr>
            <tr>
                <td class="th">至</td>
                <td class="td"><input id="user_id_max" name="user_id_max" type="text" class="input easyui-numberbox" min="0" max="9999999999" precision="0"/></td>
            </tr>
            <tr>
                <td class="th">级别</td>
                <td class="td"><input id="level" name="level" type="text" class="input easyui-numberbox" min="0" max="9999999999" precision="0"/></td>
            </tr>
            <tr>
                <td class="th">级别</td>
                <td class="td"><input id="level_min" name="level_min" type="text" class="input easyui-numberbox" min="0" max="9999999999" precision="0"/></td>
            </tr>
            <tr>
                <td class="th">至</td>
                <td class="td"><input id="level_max" name="level_max" type="text" class="input easyui-numberbox" min="0" max="9999999999" precision="0"/></td>
            </tr>
            <tr>
                <td class="th">逍遥币</td>
                <td class="td"><input id="bill" name="bill" type="text" class="input easyui-numberbox" min="0" max="99999999.99" precision="2"/></td>
            </tr>
            <tr>
                <td class="th">逍遥币</td>
                <td class="td"><input id="bill_min" name="bill_min" type="text" class="input easyui-numberbox" min="0" max="99999999.99" precision="2"/></td>
            </tr>
            <tr>
                <td class="th">至</td>
                <td class="td"><input id="bill_max" name="bill_max" type="text" class="input easyui-numberbox" min="0" max="99999999.99" precision="2"/></td>
            </tr>
            <tr>
                <td class="th">师傅id</td>
                <td class="td"><input id="parent_id" name="parent_id" type="text" class="input easyui-numberbox" min="0" max="9999999999" precision="0"/></td>
            </tr>
            <tr>
                <td class="th">师傅id</td>
                <td class="td"><input id="parent_id_min" name="parent_id_min" type="text" class="input easyui-numberbox" min="0" max="9999999999" precision="0"/></td>
            </tr>
            <tr>
                <td class="th">至</td>
                <td class="td"><input id="parent_id_max" name="parent_id_max" type="text" class="input easyui-numberbox" min="0" max="9999999999" precision="0"/></td>
            </tr>
            <tr>
                <td class="th">创建时间</td>
                <td class="td"><input id="create_date_begin" name="create_date_begin" type="text" class="input Wdate" onclick="WdatePicker()"/></td>
            </tr>
            <tr>
                <td class="th">至</td>
                <td class="td"><input id="create_date_end" name="create_date_end" type="text" class="input Wdate" onclick="WdatePicker()"/></td>
            </tr>
            <tr>
                <td class="th">名称</td>
                <td class="td"><input id="name" name="name" type="text" class="input"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:center;" class="td">
                    <a href="javascript:searchPage(false)" class="easyui-linkbutton" icon="icon-search" id="searchBtn">查询</a>
                    <a href="javascript:searchPage(true)" class="easyui-linkbutton" icon="icon-reload" id="resetBtn">重置</a>
                </td>
            </tr>
        </table>
    </form>
</div>
<div region="center" title="当前位置：人物信息管理">
    <table id="table"
           url="${path}/person/basePerson_page.do"
           border="false"         <#--无边框-->
           fit="true"             <#--自动填充宽度高度-->
           singleSelect="false"   <#--单选模式-->
           pagination="true"      <#--是否显示翻页导航-->
           rownumbers="true"      <#--是否显示行号-->
           striped="true"         <#--奇偶行颜色交错-->
           idField="id"  <#--主键字段-->
           nowrap="true">         <#--单元格数据不换行-->
    </table>
</div>
<div id="dialog" style="width:800px;height:400px; overflow:hidden;display: none" resizable="true" maximizable="true" modal="true">
<iframe id="iframe" name="iframe" scrolling="auto" src="about:blank" style="width:100%;height:100%;" frameborder="0" ></iframe>
</div>
</body>
</html>