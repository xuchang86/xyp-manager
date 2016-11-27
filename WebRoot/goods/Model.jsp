<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/Taglib.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="model">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>规格选择</title>
<link rel="stylesheet" type="text/css" href="${webRoot}/third/bootstrap-3.3.0/dist/css/bootstrap-theme.css"/>
<link rel="stylesheet" type="text/css" href="${webRoot}/third/bootstrap-3.3.0/dist/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="${webRoot}/third/cui/themes/default/css/comtop.ui.min.css"/>
<style type="text/css">
	.grid-div{
		padding-top:10px;
		padding-left:10px;
		padding-right:10px;
	}
</style>
<script type="text/javascript" src="${webRoot}/third/cui/js/comtop.ui.min.js"></script>
<script type="text/javascript" src="${webRoot}/js/angular-1.5.8/angular.js"></script>
</head>
<body ng-controller="modelController" ng-init="ready()" class="container-fluid">

	<div style="padding-top:10px;">
		<span style="padding-left: 10px;font-size:20px;">商品规格</span>
		<span style="float:right;">
			<button type="button" ng-click="confirm()"  class="btn btn-info">确定</button>
			<button type="button" ng-click="cancel()"  class="btn btn-default">取消</button>
		</span>
	</div>
	<div style="padding-left:10px;padding-right:10px;">
		<button type="button" ng-click="addNewLine()" class="btn btn-primary">新增行</button>
		<button type="button" ng-click="deleteLine(selectedData,selectedIndex)" class="btn btn-danger">删除行</button>
	</div>
	<div class="grid-div">
		<table class="table table-bordered">
			<thead>
			   <tr>
				   <th style="width:20px;">
				      <input type="checkbox" >
				   </th>
				   <th style="width:100px;">
				        规格填写
				   </th>
			   </tr>
			</thead>
			<tbody>
				 <tr ng-repeat="data in datas" ng-click="rowClick(data,$index)" style="background-color: {{$index== selectedIndex ? '#99ccff' : '#ffffff'}}">
					  <td style="width:20px;">
					 	  <input type="checkbox" name="{{ 'data'+($index +1) }}" ng-model="data.check">
					  </td>
					  <td>
					 	   <input type="text"  class="form-control" type="text" ng-model="data.model">
					  </td>
				 </tr>
			</tbody>
		</table>
	</div>
</body>
<script type="text/javascript">
var scope;
var value = "<%=request.getParameter("value")%>";
angular.module("model", []).controller('modelController', function($scope) {

	$scope.ready = function() {
		scope = $scope;
		if (value) {
			var datas =[];
			value.split(",").forEach(function(item,index,arr){
				datas.push({model:item});
			});
			$scope.datas = datas;
		} else {
			$scope.datas = [];
		}
	};

	$scope.addNewLine = function(){
		var data ={model:""};
		$scope.datas.push(data);
	}

	$scope.rowClick = function(data, index) {
		$scope.selectedData = data;
		$scope.selectedIndex = index;
	}

	$scope.deleteLine = function(rowData, index) {
		if (!rowData) {
			cui.alert("没有选中任何行");
			return;
		}
		var datas = [];
		for (var i = 0; i < $scope.datas.length; i++) {
			if (i != index) {
				datas.push($scope.datas[i]);
			}
		};
		$scope.datas = datas;
	}

	$scope.confirm = function(){
		if($scope.datas.length<=0){
			cui.alert("没有填写任何数据");
			return;
		}
		window.opener.confirmCallBack($scope.datas);
		window.close();
	}

	$scope.cancel = function(){
		window.close();
	}
});


</script>
</html>