<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-13 <br/>
描述：商品类别主页面
-->
<#include "/WEB-INF/view/macro.ftl"/>

<#assign checkAdd = check("添加")>
<#assign checkEdit = check("修改")>
<#assign checkDelete= check("删除")>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>商品类别管理</title>
    <#include "/WEB-INF/view/linkScript.ftl"/>
    <style type="text/css">
      img{
          height: 100px;
          width: 100px;
      }
    </style>
    <script type="text/javascript">
        var from = getUrlParam("from");
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
                onClickRow:function(rowIndex,rowData){
                    gridRowClick(rowIndex,rowData);
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
                columns: [
                    [{
                        title: '类型名称',
                        field: 'name',
                        width: 150,
                        sortable: true
                    }, {
                        title: '类型编码',
                        field: 'number',
                        width: 150,
                        sortable: true
                    }, {
                        title: '类型图片',
                        field: 'url',
                        width: 150,
                        sortable: true,
                        formatter: function(value, data, index) {
                            if (value)
                                return "<img src='" + value + "'>";
                            else
                                return value;
                        }
                    }, {
                        title: '上级类型',
                        field: 'parent_name',
                        width: 150,
                        sortable: true
                    },{
                        title: '类型级别',
                        field: 'level',
                        width: 150,
                        sortable: true
                    }]
                ],
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
        
        //行点击事件
        function gridRowClick(index,rowData){
            if(from){
                window.opener.typeCallBack(rowData);
                window.close();
            }
        }

        var selectedRow;
        /**
         * 显示商品类别添加对话框
         */
        function add() {
            var selections = $("#table").datagrid("getSelections");
            var parentId = null;
            if (selections.length > 1) {
                $.messager.alert("系统提示", "不能选择多行新增", "info");
                return;
            }
            if (selections.length == 1) {
                parentId = selections[0].id;
                selectedRow = selections[0];
            }
            $("#dialog").css("display","block").dialog({
                title: "记录添加",
                width:window.$.autoWidth(),
                height:window.$.autoHeight(),
                onMove:function(left,top){$.adjustPosition("dialog",left,top)},
                onBeforeClose:function(){$.restoreDialog("dialog")}
            });
            $("#iframe").attr("src", "${path}/goods/goodsType_add.do?parentId="+parentId);
        }

        /**
         * 显示商品类别修改对话框
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
            $("#iframe").attr("src","${path}/goods/goodsType_edit.do?id="+value);
        }

        /**
         * 删除商品类别
         */
        function del(event,val) {
            $.event.fix(event).stopPropagation();
            $.messager.confirm("提示信息", "你确认要删除该记录吗？", function(b) {
                if (b) {
                    $.ajaxPost("${path}/goods/goodsType_delete.do",{"id":val},function(result){
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
         * 批量删除商品类别
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

                        $.ajaxPost("${path}/goods/goodsType_deleteBatch.do", {"ids":ids}, function(result) {
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
         * 查看商品类别详细
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
            $("#iframe").attr("src","${path}/goods/goodsType_view.do?id="+value);
        }

        /**
         * 刷新页面
         */
        function refreshPage(){
            window.location="${path}/goods/goodsType_main.do";
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

            var goodsType = $("#form").serializeJson();
            goodsType.refresh = "1"; //刷新记录数参数
            $("#table").datagrid("clearSelections").datagrid("load",goodsType);
        }
    </script>
</head>
<body class="easyui-layout">
<div region="west" split="true" border="true" title="操作面板" style="width:250px;padding:10px;">
    <form id="form" name="form" style="display: none">
        <table class="table">
            <tr>
                <td class="th">类型名称</td>
                <td class="td"><input id="name" name="name" type="text" class="input"></td>
            </tr>
            <tr>
                <td class="th">类型编码</td>
                <td class="td"><input id="number" name="number" type="text" class="input"></td>
            </tr>
            <tr>
                <td class="th">类型级别</td>
                <td class="td"><input id="level" name="level" type="text" class="input easyui-numberbox" min="0" max="9999999999" precision="0"/></td>
            </tr>
            
            <tr>
                <td class="th">上级类型</td>
                <td class="td"><input id="parent_name" name="parent_name" type="text" class="input" /></td>
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
<div region="center" title="当前位置：商品类别管理">
    <table id="table"
           url="${path}/goods/goodsType_page.do"
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