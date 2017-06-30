var sysProitem=[];

var courseCtrl = function($scope,$http, $location,LocalStorageService) {
	$scope.page=[];
	
	$scope.user = LocalStorageService.get("loginIfo");

	var courseUser =  {  
		useId:$scope.user.id,
		roleId:$scope.user.roleIds.split(",")[0]
	}
	console.log(courseUser);
	var courelist = $http({
		method:'POST',
		url:"course/list.do",
		data:courseUser,
		dataType:'json'
	}).success(function(data){
		  $scope.page = {
			result:data
		  };
		  console.log($scope.page);
	});

	$scope.courseadd = function() {
		$location.path('/home/courseadd');
	}
	
	$scope.del = function(items,$event) {
		$http({
	    	method:"post",
	    	url:"course/delete.do",
	    	data:items,
	    	dataType:'json'
	    }).success(function(data){
	    	if(data.result == 'delete_success'){
	    		alert("删除成功");
		    	$($event.target).parent().parent().remove();	
	    	}else{
	    		alert("删除失败");
	    	}
	    })
	}
	
	$scope.update = function(items) {
		sysProitem = items;
		$location.path('/home/courseadd');
	}
	$scope.apply = function(items) {
		console.log(items);
		sysProitem = items;
		$http({
	    	method:"post",
	    	url:"courseUser/list.do",
	    	data:items.id,
	    	datatype:'json'
	    }).success(function(data){
	    	console.log(data);
	    	sysProitem = data;
    		$location.path('/home/class');
	    })
	}
		 
	}

var courseaddCtrl = function($scope, $http,$location,$compile,LocalStorageService) {
		$scope.sysPro = sysProitem;
		sysProitem = [];
		$scope.user = LocalStorageService.get("loginIfo");
		$scope.removeItem = function($event) {
			$($event.target).parent().parent().parent().remove();
		}
		
		 $scope.save = function() {
			 var saveRole = {
				id : $scope.sysPro.id ? $scope.sysPro.id : null,
				orgId:$scope.sysPro.orgId,
				orgName:$scope.sysPro.orgName,
				courseName:$scope.sysPro.courseName,
				courseTime:$scope.sysPro.courseTime,
				courseNumber:null,
				courseWhere:null,
				courseCount:$scope.sysPro.courseCount,
				classRaw:$scope.sysPro.classRaw,
				classLie:$scope.sysPro.classLie,
				courseInfo:$scope.sysPro.courseInfo,
				createUser:$scope.user.id,
				createDate:null,
				updateUser:$scope.user.id,
				updateDate:null,
				delFlag:"0"
			 };
			 $http({
					method:'POST',
					url:"course/save.do",
					data:saveRole,
					dataType:'json'
			}).success(function(data){
				if(data.result=='save_success'){
					alert("保存成功");
					$location.path('/home/course');
				}else{
					alert("保存失败");
				}
				
			});	 
	}
}

var classCtrl = function($scope, $http, $location, $compile) {
	$scope.sysPro = sysProitem;
	sysProitem = [];
	console.log($scope.sysPro);
	$scope.totalData = {
		courseName : "工程实践",
		courseCount : 20,
		coourseStuNum : 20,
		attanceNum : 40,
		leaveNum : 20,
		unattanceNum : 20
	}
	$scope.show = function() {
		$location.path('/home/class');
	}

}



	
