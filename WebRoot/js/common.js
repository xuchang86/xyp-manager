
/**
 * 校验是否为空
 */
function verifyNull(id){
	var value = $("#"+id).attr("value");
    if(value==null || value==""){
    	$("#"+id+"_tips").empty();
    	$("#"+id).after("<a id='"+id+"_tips' style='color:red'>带星号的为必须录项目!</a>");
    	return false;
    }else{
    	$("#"+id+"_tips").empty();
    	return true;
    }
}

/*
 * 校验金额
 */
function verifyNum(id){
	var value = $("#"+id).attr("value");
    if(value==null || value=="" || parseFloat(value)<=0){
    	$("#"+id+"_tips").empty();
    	$("#"+id).after("<a id='"+id+"_tips' style='color:red'>金额必须大于0!</a>");
    	return false;
    }else{
    	$("#"+id+"_tips").empty();
    	return true;
    }
}

$.fn.mfycOnBlue = function(){
	var id = $(this).attr("id");
	$("#"+id).blur(function(event){
		verifyNull(id);
	});
};

$.fn.mfycNumOnBlue = function(){
	var id = $(this).attr("id");
	$("#"+id).blur(function(event){
		verifyNum(id);
	});
};

//获取url中的参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}


//获取url中的参数
function getUrlParam2(url,name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = url.match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}