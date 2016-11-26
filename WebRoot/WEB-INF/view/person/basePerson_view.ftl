<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-13 <br/>
描述：人物信息查看页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>人物信息详细</title>
    <#include "/WEB-INF/view/linkScript.ftl"/>
    <script type="text/javascript">
        $(function(){
            $("body").layout();
        });
    </script>
</head>
<body class="easyui-layout">
<div region="north" style="height:32px; background-color: #EFEFEF;border-bottom: 1px solid #99bbe8;" border="false">
    <div style="padding: 2px;">
        <a href="javascript:window.location.reload();" class="easyui-linkbutton" icon="icon-reload" plain="true">刷新</a>
        <a href="javascript:window.parent.$.closeDialog('dialog');" class="easyui-linkbutton" icon="icon-cancel" plain="true">关闭</a>
    </div>
</div>
<div region="center" border="false" style="padding:10px;">
    <div style="+zoom:1;">
        <input type="hidden" id="id" name="id" value="${(basePerson.id)!}">
        <table class="table-border" width="100%">
            <col width="20%">
            <col width="80%">
            <tr>
                <td class="th">用户ID</td>
                <td class="td">${(basePerson.user_id)!}</td>
            </tr>
            <tr>
                <td class="th">级别</td>
                <td class="td">
                <#if basePerson.level==1>
                                                 见习弟子
                <#elseif basePerson.level==2>
                                                精英弟子
                <#elseif basePerson.level==3>
                                                副组长
                <#elseif basePerson.level==4>
                                               组长  
                <#elseif basePerson.level==5>
                                                  副队长
                <#elseif basePerson.level==6>
                                                队长     
                <#elseif basePerson.level==7>
                                                 副堂主    
                <#elseif basePerson.level==8>
                                                堂主     
                <#elseif basePerson.level==9>
                                                 副舵主    
                <#elseif basePerson.level==10>
                                                 舵主  
                <#elseif basePerson.level==11>
                                                青龙护法
                <#elseif basePerson.level==12>
                                                白虎护法   
                <#elseif basePerson.level==13>
                                                朱雀护法
                <#elseif basePerson.level==14>
                                                玄武护法  
                <#elseif basePerson.level==15>
                                                逍遥左使  
                <#elseif basePerson.level==16>
                                                逍遥右使   
                <#elseif basePerson.level==17>
                                                 大长老 
                <#elseif basePerson.level==18>
                                                副掌门  
                </#if>
                </td>
            </tr>
            <tr>
                <td class="th">逍遥币</td>
                <td class="td">${(basePerson.bill)!}</td>
            </tr>
            <tr>
                <td class="th">师傅ID</td>
                <td class="td">${(basePerson.parent_id)!}</td>
            </tr>
            <tr>
                <td class="th">创建时间</td>
                <td class="td"><@dateOut basePerson.create_date/></td>
            </tr>
            <tr>
                <td class="th">名称</td>
                <td class="td">${(basePerson.name)!}</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
