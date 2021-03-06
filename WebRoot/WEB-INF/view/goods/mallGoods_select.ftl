<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-13 <br/>
描述：商城商品主页面
-->
<#include "/WEB-INF/view/macro.ftl"/>

<#assign checkAdd = check("添加")>
<#assign checkEdit = check("修改")>
<#assign checkDelete= check("删除")>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>商城商品管理</title>
    <#include "/WEB-INF/view/linkScript.ftl"/>
    <style type="text/css">
        img{
            height: 100px;
            width: 60px;
        }
    </style>
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
                    {title:'商品名称',field:'name',width:150,sortable:true},
                    {title:'商品图片',field:'url',width:150,sortable:true,hidden:true},
                    {title:'商品描述',field:'description',width:150,sortable:true,hidden:true},
                    {title:'商品编码',field:'number',width:150,sortable:true},
                    {title:'商品类型',field:'type_name',width:150,sortable:true},
                    {title:'商品价格',field:'price',width:150,sortable:true},
                    {title:'创建用户',field:'creator',width:150,sortable:true,hidden:true},
                    {title:'创建日期',field:'create_date',width:150,sortable:true,hidden:true},
                    {title:'商品地区',field:'area',width:150,sortable:true,hidden:true},
                    {title:'是否出售',field:'is_sale',width:150,sortable:true,hidden:true,
                    formatter:function(value, data, index){
                        if(value==0){
                            return "否";
                        }else if(value==1){
                            return "是";
                        }else{
                            return value;
                        }
                    }
                    },
                    {title:'卖家昵称',field:'seller_nick',width:150,sortable:true,hidden:true},
                    {title:'卖家真实名称',field:'seller_name',width:150,sortable:true,hidden:true},
                    {title:'会员价格',field:'vip_price',width:150,sortable:true,hidden:true},
                    {title:'商品等级',field:'level',width:150,sortable:true,hidden:true}
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
         * 查看商城商品详细
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
            $("#iframe").attr("src","${path}/goods/mallGoods_view.do?id="+value);
        }

        /**
         * 刷新页面
         */
        function refreshPage(){
            window.location="${path}/goods/mallGoods_main.do";
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

            var mallGoods = $("#form").serializeJson();
            mallGoods.refresh = "1"; //刷新记录数参数
            $("#table").datagrid("clearSelections").datagrid("load",mallGoods);
        }
    </script>
</head>
<body class="easyui-layout">
<div region="west" split="true" border="true" title="操作面板" style="width:250px;padding:10px;">
    <form id="form" name="form" style="display: none">
        <table class="table">
            <tr>
                <td class="th">商品名称</td>
                <td class="td"><input id="name" name="name" type="text" class="input"></td>
            </tr>
            <tr>
                <td class="th">商品编码</td>
                <td class="td"><input id="number" name="number" type="text" class="input"></td>
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
<div region="center" title="当前位置：商城商品管理">
    <table id="table"
           url="${path}/goods/mallGoods_page.do"
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