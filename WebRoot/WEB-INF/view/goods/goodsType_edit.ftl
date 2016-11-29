<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-13 <br/>
描述：商品类别修改页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>商品类别修改</title>
    <#include "/WEB-INF/view/linkScript.ftl"/>
    <script type="text/javascript">
        $(function(){
            $("body").layout();
            $('#form input.easyui-numberbox').numberbox();
            initImageAjaxUpload("uploadPicture");
        });

        function save() {
            if (!$("#form").form("validate")) return;
            var goodsType = $("#form").serializeJson();
            $.showLoad();
            $.ajaxPost("${path}/goods/goodsType_editSave.do", {"goodsType":goodsType}, function(result) {
                if(result=="1"){
                	window.parent.$.messager.show({
                        title:"消息提醒",
                        msg:"记录修改成功",
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
                        $('#urlImg').attr('src', imgurl); //图片控件地址
                        $('#urlLink').attr('href', imgurl); //点击图片连接地址
                        $('#url').val(imgurl); //设置图片字段属性值
                    }
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
        <input type="hidden" id="id" name="id"  value="${(goodsType.id)!}">
        <table class="table-border" width="100%">
            <col width="20%">
            <col width="80%">
            <tr>
                <td class="th">类型名称</td>
                <td class="td"><input type="text" id="name" name="name" class="input easyui-validatebox" validType="maxLength[20]" value="${(goodsType.name)!}" style="width:300px;"/></td>
            </tr>
            <tr>
                <td class="th">类型编码</td>
                <td class="td"><input type="text" id="number" name="number" class="input easyui-validatebox" validType="maxLength[20]" value="${(goodsType.number)!}" style="width:300px;"/></td>
            </tr>
             <tr>
                <td class="th">图片</td>
                <td class="td"><a id="urlLink" href="${(goodsType.url)!}" target="_blank"> <img id="urlImg" src="${(goodsType.url)!}"></a></td>
            </tr>
            <tr>
                <td class="th">上传图片</td>
                <td class="td">
                    <a href="javascript:void(0)" style="pointer: cursor" id="uploadPicture" class="easyui-linkbutton" icon="icon-importPic" plain="true">上传图片&nbsp;&nbsp;</a>
                    <div> 图片支持jpg，png，bmp</div>
                    <input type="hidden" id="url" name="url" value="${(goodsType.url)!}">
                </td>
            </tr>
            <tr>
                <td class="th">类型级别</td>
                <td class="td"><input type="text" id="level" readOnly="true" name="level" class="input easyui-numberbox" min="0" max="9999999999" precision="0" value="${(goodsType.level)!}" style="width:300px;background-color:#efefef;"/></td>
            </tr>
            <tr>
                <td class="th">上级类型</td>
                <td class="td">
                    <input type="text" id="parent_name" name="parent_name" readOnly="true" value="${(goodsType.parent_name)!}"  class="input" style="width:300px;background-color:#efefef;"/>
                    <input type="hidden" id="parent_id" readOnly="true" name="parent_id" class="input easyui-numberbox" min="0" max="9999999999" precision="0" value="${(goodsType.parent_id)!}" style="width:300px;background-color:#efefef;"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>