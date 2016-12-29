<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/Taglib.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="model">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发起会话</title>
<link rel="stylesheet" type="text/css" href="${webRoot}/third/bootstrap-3.3.0/dist/css/bootstrap-theme.css"/>
<link rel="stylesheet" type="text/css" href="${webRoot}/third/bootstrap-3.3.0/dist/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="${webRoot}/third/cui/themes/default/css/comtop.ui.min.css"/>
<style type="text/css">
	.grid-div{
		padding-top:10px;
		padding-left:10px;
		padding-right:10px;
	}
	.search {
	    background: url('../ui/easyui/themes/icons/search.png') right center no-repeat rgb(255, 255, 255);
	}
</style>
<script type="text/javascript" src="${webRoot}/third/cui/js/comtop.ui.min.js"></script>
<script type="text/javascript" src="${webRoot}/js/angular-1.5.8/angular.js"></script>
<script type="text/javascript" src="${webRoot}/third/bootstrap-3.3.0/js/tests/vendor/jquery.min.js"></script>
</head>
<body ng-controller="modelController" ng-init="ready()" class="container-fluid">

	<div style="padding-top:10px;">
		<span style="padding-left: 10px;font-size:20px;color: #5bc0de;">发起会话</span>
	</div>

	<div>
		<form class="form-horizontal" role="form">

		  <div class="form-group">
		    <label for="account" class="col-sm-2 control-label"><span style="color:red;">*</span>用户名称:</label>
		    <div class="col-sm-10">
		      <input type="text" ng-click="accountClick()" readonly="true" ng-model="data.user_name" class="form-control" id="user_name" >
		    </div>
		  </div>

		  <div class="form-group">
		    <label for="account" class="col-sm-2 control-label"><span style="color:red;">*</span>用户消息:</label>
		    <div class="col-sm-10">
		        <textarea ng-model="data.content" readonly="true" style="height:100px;" class="form-control" id="content">
		        </textarea>
		    </div>
		  </div>

		  <div class="form-group">
		    <label for="account" class="col-sm-2 control-label"><span style="color:red;">*</span>发送内容:</label>
		    <div class="col-sm-10">
		    	<textarea ng-model="data.toContent" style="height:100px;" class="form-control" id="toContent" placeholder="请输入发送内容">
		    	</textarea>
		    </div>
		  </div>

		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="button" ng-click="confirm()" ng-disabled="isBtnDisable" class="btn btn-info">确定</button>
		      <button type="button" ng-click="cancel()" ng-disabled="isBtnDisable" class="btn btn-default">取消</button>
		    </div>
		  </div>
		</form>
	</div>

</body>
<script type="text/javascript">
var scope;
var datas = window.opener.datas;
angular.module("model", []).controller('modelController', function($scope) {
	$scope.data = {};
	$scope.isBtnDisable = false;
	$scope.ready = function() {
		scope = $scope;
		if (datas.length > 0) {
			$scope.data = datas[0];
		}
	};

	//提现
	$scope.confirm = function() {
		if (!$scope.data.toContent) {
			cui.alert("发送内容不能为空")
			return;
		}

		$.ajax({
			url: '${webRoot}/login/chatRecord_sendMessageToUser.do',
			dataType: 'json',
			type: 'POST',
			data: {
				dataModel: angular.toJson($scope.data)
			},
			success: function(data) {
				if (data["status"] == "error") {
					cui.alert("发送失败:" + data["message"]);
					return;
				}
				if (data["status"] == "success") {
					cui.message("发送成功!", 'success', {
						'callback': function() {
							$scope.cancel();
						}
					});
				}
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				cui.alert("发送失败:" + errorThrown);
			}
		});
	}

    //取消
	$scope.cancel = function(){
		window.close();
	}

});

</script>
</html>