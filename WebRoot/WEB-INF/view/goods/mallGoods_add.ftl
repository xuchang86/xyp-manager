<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-13 <br/>
描述：商城商品添加页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" ng-app="mallGoods_add">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>商城商品添加</title>
    <#include "/WEB-INF/view/linkScript.ftl"/>
    <style type="text/css">
      .search{
        background: url('../ui/easyui/themes/icons/search.png') right center no-repeat rgb(255, 255, 255);
      }
    </style>
    
    <script type="text/javascript" charset="utf-8" src="${path}/third/ueditor_1.4.3/ueditor.config.simpletext.js"></script>
    <script type="text/javascript" charset="utf-8" src="${path}/third/ueditor_1.4.3/ueditor.all.mobile.js"> </script>
       <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
       <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="${path}/third/ueditor_1.4.3/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript">
        var scope;
        angular.module("mallGoods_add", []).controller('mallGoodsAddController', function($scope) {
            $scope.ready = function() {
                scope = $scope;

                $scope.is_sales = [{
                    id: 0,
                    name: "否"
                }, {
                    id: 1,
                    name: "是"
                }];
            };

            //类型点击
            $scope.typeClick = function() {
                var url = "${path}/goods/goodsType_main.do?from=f7";
                var width = 800; //窗口宽度
                var height = 400; //窗口高度
                var top = (window.screen.height - 30 - height) / 2;
                var left = (window.screen.width - 10 - width) / 2;
                window.open(url, "_blank", "Scrollbars=no,Toolbar=no,Location=no,titlebar=no,Direction=no,Resizeable=no,alwaysLowered=yes,Width=" + width + " ,Height=" + height + ",top=" + top + ",left=" + left);
            };

            $scope.creatorClick = function(){
                var url = "${path}/login/loginUser_main.do?from=f7";
                var width = 800; //窗口宽度
                var height = 400; //窗口高度
                var top = (window.screen.height - 30 - height) / 2;
                var left = (window.screen.width - 10 - width) / 2;
                window.open(url, "_blank", "Scrollbars=no,Toolbar=no,Location=no,titlebar=no,Direction=no,Resizeable=no,alwaysLowered=yes,Width=" + width + " ,Height=" + height + ",top=" + top + ",left=" + left);
            }

            $scope.sellerNickClick = function(){
                var url = "${path}/goods/goodsSeller_main.do?from=f7";
                var width = 800; //窗口宽度
                var height = 400; //窗口高度
                var top = (window.screen.height - 30 - height) / 2;
                var left = (window.screen.width - 10 - width) / 2;
                window.open(url, "_blank", "Scrollbars=no,Toolbar=no,Location=no,titlebar=no,Direction=no,Resizeable=no,alwaysLowered=yes,Width=" + width + " ,Height=" + height + ",top=" + top + ",left=" + left);
            }

        });

        $(function(){
            $("body").layout();
            $('#form input.easyui-numberbox').numberbox();
            initImageAjaxUpload("uploadImage");
        });

        function typeCallBack(rowData) {
            $("#type_name").val(rowData.name);
            $("#type_id").val(rowData.id);
        }

        function userCallBack(rowData){
            $("#creator").val(rowData.name);
            $("#user_id").val(rowData.id);
        }

        function sellerCallBack(rowData){
            $("#seller_nick").val(rowData.nick_name);
            $("#seller_id").val(rowData.id);
        }
        
        function initImageAjaxUpload(uploadId) {
            var uploader = $("#" + uploadId);
            new AjaxUpload(uploader, {
                action: path + "/file/upload.do?maxRequestSize=500&path=pictures/image",
                name: 'file_path',
                onSubmit: function(file, ext) {
                    if (ext && /^(jpeg|jpg|bmp|png)$/.test(ext)) { //过滤上传文件格式
                        ext_str = ext;
                    } else {
                        $.messager.alert('错误信息', '非图片文件格式,请重传！', 'error');
                        return false;
                    }
                    $.showLoad();
                },
                onComplete: function(file, response) {
                    $.hideLoad();
                    if (response == "outofsize") {
                        $.messager.alert("系统提示", "文件过大，无法上传！", "info");
                    } else if (response == "errorDimension") {
                        $.messager.alert("系统提示", "图片尺寸必须是128*128", "info");
                    } else if (response == "error") {
                        $.messager.alert("系统提示", "图片上传失败，请重新上传！", "info");
                    } else {
                        eval("res=" + response);
                        var imgurl = res.path;
                        $('#picImg').attr('src', imgurl); //图片控件地址
                        $('#picImgLink').attr('href', imgurl); //点击图片连接地址
                        $('#picture').val(imgurl); //设置图片字段属性值
                    }
                }
            });
        }

        function save() {
            if (!$("#form").form("validate")) return;
            var mallGoods = $("#form").serializeJson();
            mallGoods.url = UE.getEditor('url').getContent();
            mallGoods.description = UE.getEditor('description').getContent();
            $.showLoad();
            $.ajaxPost("${path}/goods/mallGoods_addSave.do", {"mallGoods":mallGoods}, function(result) {
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
<body class="easyui-layout" ng-controller="mallGoodsAddController" ng-init="ready()">
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
                <td class="th">商品名称</td>
                <td class="td"><input type="text" id="name" name="name" class="input easyui-validatebox" validType="maxLength[20]" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">商品描述</td>
                <td class="td">
                    <div id="description" type="text/plain" style="width:100%;height:100px;"></div>
                </td>
            </tr>
            <tr>
                <td class="th">商品编码</td>
                <td class="td"><input type="text" id="number" name="number" class="input easyui-validatebox" validType="maxLength[20]" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">商品类型</td>
                <td class="td">
                    <input type="text" id="type_name" name="type_name" class="input search" min="0" max="9999999999" precision="0" ng-click="typeClick()" value="${(mallGoods.type_name)!}" style="width:300px;"/>
                    <input type="hidden" id="type_id" name="type_id" class="input easyui-numberbox" min="0" max="9999999999" precision="0" style="width:300px;"/>
                </td>
            </tr>
            <tr>
                <td class="th">商品价格</td>
                <td class="td"><input type="text" id="price" name="price" class="input easyui-numberbox" min="0" max="99999999.99" precision="2" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">创建用户</td>
                <td class="td">
                    <input type="text" id="creator" name="creator" class="input search" min="0" max="9999999999" precision="0" ng-click="creatorClick()" value="${(mallGoods.creator)!}" style="width:300px;"/>
                    <input type="hidden" id="user_id" name="user_id" class="input easyui-numberbox" min="0" max="9999999999" precision="0" style="width:300px;"/>
                </td>
            </tr>
            <tr>
                <td class="th">创建日期</td>
                <td class="td"><input type="text" id="create_date" name="create_date" class="input Wdate" onclick="WdatePicker()" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">商品图片</td>
                <td class="td">
                    <div id="url" type="text/plain" style="width:100%;height:100px;"></div>
                </td>
            </tr>
            <tr>
                <td class="th">商品地区</td>
                <td class="td"><input type="text" id="area" name="area" class="input easyui-validatebox" validType="maxLength[20]" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">是否出售</td>
                <td class="td">
                    <select ng-model="is_sale" ng-options="a.id as a.name for a in is_sales" >
                    </select>
                    <input type="hidden" name="is_sale" value="{{is_sale}}">
                </td>
            </tr>
            <tr>
                <td class="th">卖家名称</td>
                <td class="td">
                    <input type="text" id="seller_nick" ng-click="sellerNickClick()" name="seller_nick" class="input  search" min="0" max="9999999999" precision="0" value="${(mallGoods.seller_nick)!}" style="width:300px;"/>
                    <input type="hidden" id="seller_id" name="seller_id" class="input easyui-numberbox" min="0" max="9999999999" precision="0" style="width:300px;"/>
                </td>
            </tr>
            <tr>
                <td class="th">会员价格</td>
                <td class="td"><input type="text" id="vip_price" name="vip_price" class="input easyui-numberbox" min="0" max="99999999.99" precision="2" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">商品等级</td>
                <td class="td"><input type="text" id="level" name="level" class="input easyui-numberbox" min="0" max="9999999999" precision="0" style="width:300px;"/></td>
            </tr>
        </table>
    </form>
</div>
<script type="text/javascript">
//实例化编辑器
//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
var url = UE.getEditor('url');
url.ready(function() {
    UE.getEditor('url').execCommand('insertHtml', '${(mallGoods.url)!}');
});
var description = UE.getEditor("description");
description.ready(function(){
    UE.getEditor('description').execCommand('insertHtml', '${(mallGoods.description)!}');
});

</script>
</body>
</html>