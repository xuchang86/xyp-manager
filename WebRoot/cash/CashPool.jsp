<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/Taglib.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="model">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收入提现</title>
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
		<span style="padding-left: 10px;font-size:20px;color: #5bc0de;">平台提现</span>
	</div>

	<div>
		<form class="form-horizontal" role="form">

		  <div class="form-group">
		    <label for="amount" class="col-sm-2 control-label"><span style="color:red;">*</span>提现金额:</label>
		    <div class="col-sm-10">
		      <input type="number" ng-model="data.amount" class="form-control" id="amount" placeholder="请填写提现金额">
		    </div>
		  </div>

		  <div class="form-group">
		    <label for="account" class="col-sm-2 control-label"><span style="color:red;">*</span>银行账户:</label>
		    <div class="col-sm-10">
		      <input type="text" ng-click="accountClick()" ng-model="data.account" class="form-control search" id="account" placeholder="请填写银行账户">
		    </div>
		  </div>

		  <div class="form-group">
		  	  <label for="platform" class="col-sm-2 control-label">平台收入:</label>
		  	  <div class="col-sm-10">
		  	    <input type="number" readonly="true" ng-model="data.platform" class="form-control" id="platform" placeholder="">
		  	  </div>
		  </div>

		  <div class="form-group">
		    <label for="bankName" class="col-sm-2 control-label"><span style="color:red;">*</span>银行名称:</label>
		    <div class="col-sm-10">
		      <input type="text" readonly="true" ng-model="data.name" class="form-control" id="bankName" placeholder="">
		    </div>
		  </div>

		  <div class="form-group">
		    <label for="receiver" class="col-sm-2 control-label"><span style="color:red;">*</span>收款人:</label>
		    <div class="col-sm-10">
		      <input type="text" readonly="true" ng-model="data.receiver" class="form-control" id="receiver" placeholder="">
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
var value = "<%=request.getParameter("value")%>";
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
		if (!$scope.data.amount || $scope.data.amount < 0) {
			cui.alert("提现金额不能为空");
			return;
		}

		if ($scope.data.amount > $scope.data.platform) {
			cui.alert("提现金额不能大于平台收入")
			return;
		}

		if (!$scope.data.account) {
			cui.alert("银行账户信息不能为空");
			return;
		}

        //同步前先禁用按钮
		$scope.isBtnDisable = true;

		$.ajax({
			url: '${webRoot}/cashPool/cashPool_getBill.do',
			dataType: 'json',
			type: 'POST',
			data: {
				dataModel: angular.toJson($scope.data)
			},
			success: function(data) {
				if (data["status"] == "error") {
					cui.alert("提现失败:" + data["message"]);
					return;
				}
				if (data["status"] == "success") {
					cui.message("提现成功!", 'success', {
						'callback': function() {
							$scope.cancel();
						}
					});
				}
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				cui.alert("提现失败:" + errorThrown);
				$scope.isBtnDisable = false;
			}
		});
	}

    //打开银行账户界面
	$scope.accountClick = function(){
		var url = "${webRoot}/cashPool/bankAccount_main.do?from=f7";
		var width = 800; //窗口宽度
		var height = 400; //窗口高度
		var top = (window.screen.height - 30 - height) / 2;
		var left = (window.screen.width - 10 - width) / 2;
		window.open(url, "_blank", "Scrollbars=no,Toolbar=no,Location=no,titlebar=no,Direction=no,Resizeable=no,alwaysLowered=yes,Width=" + width + " ,Height=" + height + ",top=" + top + ",left=" + left);
	}

    //取消
	$scope.cancel = function(){
		window.opener.reloadPage();
		window.close();
	}

    //银行账户回调
	$scope.bankAccountCallBack = function(rowData){
		$scope.data.accountId = rowData.id;
		$scope.data.account = rowData.account;
		$scope.data.name = rowData.name;
		$scope.data.receiver = rowData.receiver;
		$scope.$apply();
	}
});

</script>
</html>