<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-13 <br/>
描述：商品订单主页面
-->
<#include "/WEB-INF/view/macro.ftl"/>

<#assign checkAdd = check("添加")>
<#assign checkEdit = check("修改")>
<#assign checkDelete= check("删除")>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>商品订单管理</title>
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
                    {title:'订单号',field:'number',width:150,sortable:true},
                    {title:'订单金额',field:'amount',width:150,sortable:true},
                    {title:'商品名称',field:'goods_name',width:150,sortable:true},
                    {title:'商品型号',field:'goods_model',width:150,sortable:true},
                    {title:'收货地址',field:'address',width:150,sortable:true},
                    {title:'收货城市',field:'address_name',width:150,sortable:true},
                    {title:'联系人',field:'contacts',width:150,sortable:true},
                    {title:'联系电话',field:'phone',width:150,sortable:true},
                    {
                        title: '订单状态',
                        field: 'state',
                        width: 150,
                        sortable: true,
                        formatter: function(value, data, index) {
                            if(value=="todo"){
                                return "待付款";
                            }else if(value=="paying"){
                                return "已付款";
                            }else if(value=="to"){
                                return "已发货";
                            }else if(value=="get"){
                                return "已收货";
                            }else if(value=="after_sale"){
                                return "售后";
                            }else if(value=="sales_return"){
                                return "退货";
                            }else{
                                return value;
                            }
                        }
                    },
                    {title:'创建用户',field:'user_name',width:150,sortable:true},
                    {title:'创建时间',field:'create_date',width:150,sortable:true},
                    {title:'付款时间',field:'pay_date',width:150,sortable:true}
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
         * 显示商品订单添加对话框
         */
        function add() {
            $("#dialog").css("display","block").dialog({
                title: "记录添加",
                width:window.$.autoWidth(),
                height:window.$.autoHeight(),
                onMove:function(left,top){$.adjustPosition("dialog",left,top)},
                onBeforeClose:function(){$.restoreDialog("dialog")}
            });
            $("#iframe").attr("src", "${path}/goods/goodsOrder_add.do");
        }

        /**
         * 显示商品订单修改对话框
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
            $("#iframe").attr("src","${path}/goods/goodsOrder_edit.do?id="+value);
        }

        /**
         * 删除商品订单
         */
        function del(event,val) {
            $.event.fix(event).stopPropagation();
            $.messager.confirm("提示信息", "你确认要删除该记录吗？", function(b) {
                if (b) {
                    $.ajaxPost("${path}/goods/goodsOrder_delete.do",{"id":val},function(result){
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
         * 批量删除商品订单
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

                        $.ajaxPost("${path}/goods/goodsOrder_deleteBatch.do", {"ids":ids}, function(result) {
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
         * 查看商品订单详细
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
            $("#iframe").attr("src","${path}/goods/goodsOrder_view.do?id="+value);
        }

        /**
         * 刷新页面
         */
        function refreshPage(){
            window.location="${path}/goods/goodsOrder_main.do";
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

            var goodsOrder = $("#form").serializeJson();
            goodsOrder.refresh = "1"; //刷新记录数参数
            $("#table").datagrid("clearSelections").datagrid("load",goodsOrder);
        }
    </script>
</head>
<body class="easyui-layout">
<div region="west" split="true" border="true" title="操作面板" style="width:250px;padding:10px;">
    <form id="form" name="form" style="display: none">
        <table class="table">
            <tr>
                <td class="th">订单号</td>
                <td class="td"><input id="number" name="number" type="text" class="input"></td>
            </tr>
            <tr>
                <td class="th">订单金额</td>
                <td class="td"><input id="amount" name="amount" type="text" class="input easyui-numberbox"></td>
            </tr>
            <tr>
                <td class="th">订单金额从</td>
                <td class="td"><input id="amount_min" name="amount_min" type="text" class="input easyui-numberbox"></td>
            </tr>
            <tr>
                <td class="th">订单金额至</td>
                <td class="td"><input id="amount_max" name="amount_max" type="text" class="input easyui-numberbox"></td>
            </tr>
            <tr>
                <td class="th">商品名称</td>
                <td class="td"><input id="goods_name" name="goods_name" type="text" class="input"></td>
            </tr>
            <tr>
                <td class="th">商品型号</td>
                <td class="td"><input id="goods_model" name="goods_model" type="text" class="input"></td>
            </tr>
            <tr>
                <td class="th">订单城市</td>
                <td class="td"><input id="address_name" name="address_name" type="text" class="input"></td>
            </tr>
            <tr>
                <td class="th">创建时间从</td>
                <td class="td"><input id="create_date_begin" name="create_date_begin" type="text" class="input Wdate" onclick="WdatePicker()"/></td>
            </tr>
            <tr>
                <td class="th">至</td>
                <td class="td"><input id="create_date_end" name="create_date_end" type="text" class="input Wdate" onclick="WdatePicker()"/></td>
            </tr>
            <tr>
                <td class="th">付款时间从</td>
                <td class="td"><input id="pay_date_begin" name="pay_date_begin" type="text" class="input Wdate" onclick="WdatePicker()"/></td>
            </tr>
            <tr>
                <td class="th">至</td>
                <td class="td"><input id="pay_date_end" name="pay_date_end" type="text" class="input Wdate" onclick="WdatePicker()"/></td>
            </tr>
            <tr>
                <td class="th">创建用户</td>
                <td class="td"><input id="user_name" name="user_name" type="text" class="input" /></td>
            </tr>
           
            <tr>
                <td class="th">收货地址</td>
                <td class="td"><input id="address" name="address" type="text" class="input"></td>
            </tr>
            <tr>
                <td class="th">联系人</td>
                <td class="td"><input id="contacts" name="contacts" type="text" class="input"></td>
            </tr>
            <tr>
                <td class="th">联系电话</td>
                <td class="td"><input id="phone" name="phone" type="text" class="input"></td>
            </tr>
            <tr>
                <td class="th">订单状态</td>
                <td class="td">
                    <select id="state" name="state">
                        <option value="">请选择</option>
                        <option value="todo">待付款</option>
                        <option value="paying">已付款</option>
                        <option value="to">已发货</option>
                        <option value="get">已收货</option>
                        <option value="after_sale">售后</option>
                        <option value="sales_return">退货</option>
                    </select>
                </td>
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
<div region="center" title="当前位置：商品订单管理">
    <table id="table"
           url="${path}/goods/goodsOrder_page.do"
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