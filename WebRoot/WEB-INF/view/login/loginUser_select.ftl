<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-12 <br/>
描述：逍遥派用户主页面
-->
<#include "/WEB-INF/view/macro.ftl"/>

<#assign checkAdd = check("添加")>
<#assign checkEdit = check("修改")>
<#assign checkDelete= check("删除")>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>逍遥派用户管理</title>
    <#include "/WEB-INF/view/linkScript.ftl"/>
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
//                            <#if checkEdit>
//                            link+="<a href=\"javascript:void(0)\" onclick=\"edit(event, '" + value + "')\">修改</a>&nbsp;";
//                            <#else>
//                            link+="<span style='color:#808080'>修改</span>&nbsp;";
//                            </#if>
//                            <#if checkDelete>
//                            link+="<a href=\"javascript:void(0)\" onclick=\"del(event, '" + value + "')\">删除</a>&nbsp;";
//                            <#else>
//                            link+="<span style='color:#808080'>删除</span>&nbsp;";
//                            </#if>
                            return link;
                        }
                    }
                ]],
                columns:[[
                    {title:'电话',field:'phone',width:150,sortable:true,hidden:true},
                    {title:'密码',field:'password',width:150,sortable:true,hidden:true},
                    {title:'名称',field:'name',width:150,sortable:true},
                    {title:'生日',field:'birthday',width:150,sortable:true,hidden:true},
                    {title:'地址',field:'address',width:150,sortable:true,hidden:true},
                    {title:'我提供的资源',field:'providerid',width:150,sortable:true,hidden:true},
                    {title:'我需要的资源',field:'requiredid',width:150,sortable:true,hidden:true},
                    {title:'城市',field:'city',width:150,sortable:true},
                    {title:'性别',field:'sex',width:150,sortable:true,
                     formatter:function(value, data, index){
                       if(value==0){
                         return "男";
                       }else if(value==1){
                         return "女";
                       }else{
                         return "";
                       }
                     }
                    },
                    {title:'用户名',field:'username',width:150,sortable:true},
                    {title:'是否已付款',field:'ispay',width:150,sortable:true,
                    formatter:function(value, data, index){
                       if(value==0){
                         return "否";
                       }else if(value==1){
                         return "是";
                       }else{
                         return "";
                       }
                    }
                    },
                    {title:'个人头像',field:'url',width:150,sortable:true,hidden:true}
                ]],
                toolbar:[
                    {
					    handler:select,
					    text:"选择",
					    iconCls:"icon-ok"
					},
					{
					    handler:closePage,
					    text:"关闭",
					    iconCls:"icon-cancel"
					}
                ]
            });
        });

        //行点击事件
        function gridRowClick(index, rowData) {
            if (from) {
                window.opener.userCallBack(rowData);
                window.close();
            }
        }
        /**
         * 选择
         */
        function select(){
        	var selections=$("#table").datagrid("getSelections");
        	if(selections==null || selections.length==0){
        		$.messager.alert("系统提示","请选择商品","info");
        		return;
        	}
        	
        	window.parent.${RequestParameters.callback!}(selections);
    	    window.parent.$.closeDialog('dialog');
        }

        /**
         * 关闭
         */
        function closePage(){
        	window.parent.$.closeDialog('dialog');
        }

        /**
         * 查看逍遥派用户详细
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
            $("#iframe").attr("src","${path}/login/loginUser_view.do?id="+value);
        }

        /**
         * 刷新页面
         */
        function refreshPage(){
            window.location="${path}/login/loginUser_main.do";
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

            var loginUser = $("#form").serializeJson();
            loginUser.refresh = "1"; //刷新记录数参数
            $("#table").datagrid("clearSelections").datagrid("load",loginUser);
        }
    </script>
</head>
<body class="easyui-layout">
<div region="west" split="true" border="true" title="操作面板" style="width:250px;padding:10px;">
    <form id="form" name="form" style="display: none">
        <table class="table">
            <tr>
                <td class="th">名称</td>
                <td class="td"><input id="name" name="name" type="text" class="input"></td>
            </tr>
            <tr>
                <td class="th">城市</td>
                <td class="td"><input id="city" name="city" type="text" class="input"></td>
            </tr>
            <tr>
                <td class="th">性别</td>
                <td class="td"><input id="sex" name="sex" type="text" class="input easyui-numberbox" min="0" max="9999999999" precision="0"/></td>
            </tr>
            <tr>
                <td class="th">性别</td>
                <td class="td"><input id="sex_min" name="sex_min" type="text" class="input easyui-numberbox" min="0" max="9999999999" precision="0"/></td>
            </tr>
            <tr>
                <td class="th">至</td>
                <td class="td"><input id="sex_max" name="sex_max" type="text" class="input easyui-numberbox" min="0" max="9999999999" precision="0"/></td>
            </tr>
            <tr>
                <td class="th">用户名</td>
                <td class="td"><input id="username" name="username" type="text" class="input"></td>
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
<div region="center" title="当前位置：逍遥派用户管理">
    <table id="table"
           url="${path}/login/loginUser_page.do"
           border="false"         <#--无边框-->
           fit="true"             <#--自动填充宽度高度-->
           singleSelect="true"   <#--单选模式-->
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