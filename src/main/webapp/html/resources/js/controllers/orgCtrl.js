var sysOrgInfo=[];

var orgCtrl = function($scope, $http,$location,LocalStorageService) {
	$scope.page=[];
	 var orglist = $http({
			method:'POST',
			url:"org/list.do"
		}).success(function(data){
			 $scope.page = {
				result:data
			 };
		console.log($scope.page);
			 
	});

	 $scope.addorg = function() {
		 $location.path('/home/addorg');
	}
	 $scope.del = function(items,$event) {
			$http({
		    	method:"post",
		    	url:"org/delete.do",
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
		 sysOrgInfo = items;
		 $location.path('/home/addorg');
	}
}
	 

var addOrgCtrl = function($scope, $http,$location,$compile,LocalStorageService) {
	$scope.org = sysOrgInfo;
	sysOrgInfo = [];	
	$scope.removeItem = function($event) {
		$($event.target).parent().parent().parent().remove();
	}
	
	
	
	 $scope.save = function() {
		 var saveOrg = {
					id : $scope.org.id ? $scope.org.id : null,
					orgCode:$scope.org.orgCode,
					orgName:$scope.org.orgName,
		 };
		 $http({
				method:'POST',
				url:"org/save.do",
				data:saveOrg,
				dataType:'json'
		}).success(function(data){
			if(data.result=='save_success'){
				alert("保存成功");
//				console.log(saveOrg);
				$location.path('/home/org');
			}else{
				alert("保存失败");
			}
			
		});	 
	 }
}
	