<#--
版权：LAB <br/>
作者：dailing <br/>
生成日期：2016-11-13 <br/>
描述：发布的活动,任务,悬赏查看页面
-->
<#include "/WEB-INF/view/macro.ftl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>发布的活动,任务,悬赏详细</title>
    <#include "/WEB-INF/view/linkScript.ftl"/>
    <script type="text/javascript">
        $(function(){
            $("body").layout();
            
            //赋值  
            document.getElementById("actType").innerHTML=getType("${(publishActivity.type)!}");
            document.getElementById("actWay").innerHTML=getWay("${(publishActivity.way)!}");
            document.getElementById("actPayway").innerHTML=getPayWay("${(publishActivity.payway)!}");
        });
        
        /**
         * 类型
         */
        function getType(value){
        	if(value=="school_activity"){
        		return "门派活动";
        	}else if(value=="reward_task"){
        		return "悬赏任务";
        	}else{
        		return "出售服务";
        	}
        }
        /**
         * 状态
         */
        function getWay(value){
        	if(value=="ask_about"){
        		return "打听";
        	}else if(value=="part_time"){
        		return "兼职";
        	}else {
        		return "其他";
        	}
        }
        /**
         * 状态
         */
        function getPayWay(value){
        	debugger
        	if(value=="aa"){
        		return "AA付款";
        	}else if(value=="man_a_woman_free"){
        		return "男A女免费";
        	}else if(value=="woman_a_man_free"){
        		return "女A男免费";
        	}else{
        		return "全部免费";
        	}
        }
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
        <input type="hidden" id="id" name="id" value="${(publishActivity.id)!}">
        <table class="table-border" width="100%">
            <col width="20%">
            <col width="80%">
            <tr>
                <td class="th">活动类型</td>
                <td class="td" id="actType"></td>
            </tr>
            <tr>
                <td class="th">发布地址</td>
                <td class="td">${(publishActivity.address)!}</td>
            </tr>
            <tr>
                <td class="th">发布内容</td>
                <td class="td">${(publishActivity.content)!}</td>
            </tr>
            <tr>
                <td class="th">日期</td>
                <td class="td"><@dateOut publishActivity.date/></td>
            </tr>
            <tr>
                <td class="th">人物</td>
                <td class="td">${(publishActivity.person_name)!}</td>
            </tr>
            <tr>
                <td class="th">费用</td>
                <td class="td">${(publishActivity.cost)!}</td>
            </tr>
            <tr>
                <td class="th">城市</td>
                <td class="td">${(publishActivity.city)!}</td>
            </tr>
            <tr>
                <td class="th">活动方式</td>
                <td class="td" id="actWay"></td>
            </tr>
            <tr>
                <td class="th">付款方式</td>
                <td class="td" id="actPayway"></td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
