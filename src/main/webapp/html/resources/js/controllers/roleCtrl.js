var sysRoleitem=[];
var roleCtrl = function($scope,$http, $location,LocalStorageService) {
	$scope.page = [];
	$scope.user = LocalStorageService.get("loginIfo");
	var courseUser =  {  
		useId:$scope.user.id,
		roleId:$scope.user.roleIds
	}
	
	var rolelist = $http({
		method : 'POST',
		url : "sysRole/list.do"
	}).success(function(data) {
		 $scope.page = {
			result:data
		};
		//console.log($scope.page);
		
	});
	    
		$scope.roleadd = function() {
			 $location.path('/home/roleadd');
		}
		
		$scope.del = function(items,$event) {
			$http({
		    	method:"post",
		    	url:"sysRole/delete.do",
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
			 sysRoleitem = items;
			 $location.path('/home/roleadd');
		}
	}



	var roleaddCtrl = function($scope, $http,$location,$compile,LocalStorageService) {
		$scope.sysRole = sysRoleitem;
		sysRoleitem = [];
	
		$scope.removeItem = function($event) {
			$($event.target).parent().parent().parent().remove();
		}
		
		 $scope.save = function() {
			  var saveRole = {
					 id:$scope.sysRole.id?$scope.sysRole.id:null,
					 roleCode:$scope.sysRole.roleCode,
					 roleName:$scope.sysRole.roleName,
					 description:$scope.sysRole.description,
			 };
			 $http({
					method:'POST',
					url:"sysRole/save.do",
					data:saveRole,
					dataType:'json'
			}).success(function(data){
				if(data.result=='save_success'){
					alert("保存成功");
					$location.path('/home/role');
				}else{
					alert("保存失败");
				}
				
			});	 
		}
		}
