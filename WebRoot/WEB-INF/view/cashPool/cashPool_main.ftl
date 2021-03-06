<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-13 <br/>
描述：资金池主页面
-->
<#include "/WEB-INF/view/macro.ftl"/>

<#assign checkAdd = check("添加")>
<#assign checkEdit = check("修改")>
<#assign checkDelete= check("删除")>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>资金池管理</title>
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
                            
                            return link;
                        }
                    }
                ]],
                columns:[[
                    {title:'平台收入',field:'platform',width:150,sortable:true},
                   
                    {title:'创建用户',field:'user_name',width:150,sortable:true},
                    {title:'创建时间',field:'createdate',width:150,sortable:true},
                ]],
                toolbar:[
                    {
                        handler:refreshPage,
                        text:"刷新",
                        iconCls:"icon-reload"
                    },
                    "-",
                    {
                        handler:reducePlatform,
                        text:"提现",
                        iconCls:"icon-ok"
                    },
                    {
                        disabled:true,
                        text:"删除",
                        iconCls:"icon-remove"
                    }
                ]
            });
        });
        
        var datas = [];
        //提现
        function reducePlatform() {
            //先刷新数据获取最新数据
            reloadPage();

            datas = $("#table").datagrid("getData").rows;
            var url = "${path}/cash/CashPool.jsp?from=f7";
            var width = 800; //窗口宽度
            var height = 400; //窗口高度
            var top = (window.screen.height - 30 - height) / 2;
            var left = (window.screen.width - 10 - width) / 2;
            window.open(url, "_blank", "Scrollbars=no,Toolbar=no,Location=no,titlebar=no,Direction=no,Resizeable=no,alwaysLowered=yes,Width=" + width + " ,Height=" + height + ",top=" + top + ",left=" + left);
        }

        /**
         * 显示资金池添加对话框
         */
        function add() {
            $("#dialog").css("display","block").dialog({
                title: "记录添加",
                width:window.$.autoWidth(),
                height:window.$.autoHeight(),
                onMove:function(left,top){$.adjustPosition("dialog",left,top)},
                onBeforeClose:function(){$.restoreDialog("dialog")}
            });
            $("#iframe").attr("src", "${path}/cashPool/cashPool_add.do");
        }

        /**
         * 显示资金池修改对话框
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
            $("#iframe").attr("src","${path}/cashPool/cashPool_edit.do?id="+value);
        }

        /**
         * 删除资金池
         */
        function del(event,val) {
            $.event.fix(event).stopPropagation();
            $.messager.confirm("提示信息", "你确认要删除该记录吗？", function(b) {
                if (b) {
                    $.ajaxPost("${path}/cashPool/cashPool_delete.do",{"id":val},function(result){
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
         * 批量删除资金池
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

                        $.ajaxPost("${path}/cashPool/cashPool_deleteBatch.do", {"ids":ids}, function(result) {
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
         * 查看资金池详细
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
            $("#iframe").attr("src","${path}/cashPool/cashPool_view.do?id="+value);
        }

        /**
         * 刷新页面
         */
        function refreshPage(){
            window.location="${path}/cashPool/cashPool_main.do";
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

            var cashPool = $("#form").serializeJson();
            cashPool.refresh = "1"; //刷新记录数参数
            $("#table").datagrid("clearSelections").datagrid("load",cashPool);
        }

        function creatorClick(){
            var url = "${path}/login/loginUser_main.do?from=f7";
            var width = 800; //窗口宽度
            var height = 400; //窗口高度
            var top = (window.screen.height - 30 - height) / 2;
            var left = (window.screen.width - 10 - width) / 2;
            window.open(url, "_blank", "Scrollbars=no,Toolbar=no,Location=no,titlebar=no,Direction=no,Resizeable=no,alwaysLowered=yes,Width=" + width + " ,Height=" + height + ",top=" + top + ",left=" + left);
        }

        function userCallBack(rowData){
            $("#user_id").val(rowData.id);
        }

    </script>
</head>
<body class="easyui-layout">
<div region="west" split="true" border="true" title="操作面板" style="width:250px;padding:10px;">
    <form id="form" name="form" style="display: none">
        <table class="table">
            <tr>
                <td class="th">平台收入</td>
                <td class="td"><input id="platform" name="platform" type="text" class="input easyui-numberbox" min="0" max="99999999.99" precision="2"/></td>
            </tr>
            <tr>
                <td class="th">平台收入从</td>
                <td class="td"><input id="platform_min" name="platform_min" type="text" class="input easyui-numberbox" min="0" max="99999999.99" precision="2"/></td>
            </tr>
            <tr>
                <td class="th">至</td>
                <td class="td"><input id="platform_max" name="platform_max" type="text" class="input easyui-numberbox" min="0" max="99999999.99" precision="2"/></td>
            </tr>

            <tr>
                <td class="th">用户名称</td>
                <td class="td"><input id="user_id" name="user_id" type="text" onclick="creatorClick()" class="input search" /></td>
            </tr>
            
            <tr>
                <td class="th">创建时间</td>
                <td class="td"><input id="createdate_begin" name="createdate_begin" type="text" class="input Wdate" onclick="WdatePicker()"/></td>
            </tr>
            <tr>
                <td class="th">至</td>
                <td class="td"><input id="createdate_end" name="createdate_end" type="text" class="input Wdate" onclick="WdatePicker()"/></td>
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
<div region="center" title="当前位置：资金池管理">
    <table id="table"
           url="${path}/cashPool/cashPool_page.do"
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