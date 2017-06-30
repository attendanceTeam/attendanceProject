var sysProitem=[];


var userCtrl = function($scope,$http,$location,LocalStorageService) {
	
	$scope.page=[];
	   $scope.user = LocalStorageService.get("loginIfo");
	    var SysUser =  {
	    		id:$scope.user.id,
	    		roleIds:$scope.user.roleIds
	    } ;
	    
//	    console.log($scope.user);	
	    var useList = $http({
			method:'POST',
			url:"user/list.do",
			data:SysUser,
			dataType:'json'
		}).success(function(data){
			  $scope.page = {
				result:data
			 };
			console.log($scope.page);
		});
	    
	
	$scope.sysPro = sysProitem;
	$scope.useradd=function(){
		$location.path('/home/useradd');
	}
	$scope.deluser = function(items,$event) {
		$http({
	    	method:"post",
	    	url:"user/delete.do",
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
	};
	
	$scope.updateuser = function(items) {
		sysProitem = items;
		$location.path('/home/useradd');
	};
	
	$scope.apply = function(items) {
		sysProitem = items;
		$http({
	    	method:"POST",
	    	url:"user/list.do",
	    	data:items.id
	    }).success(function(data){
//	    	console.log(data);
    		$location.path('/home/class');
	    });
	};
}



		//新增用户
var useraddCtrl = function($scope, $http,$location,$compile,LocalStorageService) {
	$scope.sysPro = sysProitem;
	sysProitem = [];
	$scope.roleNmae = "管理员";
	$scope.user = LocalStorageService.get("loginIfo");
	$scope.removeItem = function($event) {
		$($event.target).parent().parent().parent().remove();
	}
	$scope.roleListtemp = $http({
		method : 'POST',
		url : "sysRole/list.do"
	}).success(function(data) {
		 $scope.page = {
			result:data
		};
		 $scope.roleList = data;
		 $scope.initrole();
	});
	$scope.initrole = function(){
		var isEmpty = 1;
		for(var x in $scope.roleList){
			if($scope.sysPro.roleIds == $scope.roleList[x].id)
				{$scope.roleNmae = $scope.roleList[x].roleName;isEmpty = 0}
		}
		var index = 0;
		if(isEmpty)
			$scope.sysPro.roleIds = $scope.roleList[index].id;
	};
	
	 $scope.save = function() {
		 for(var x in $scope.roleList){
				if($scope.roleNmae == $scope.roleList[x].roleName)
					{$scope.sysPro.roleIds = $scope.roleList[x].id;}
				
			}
		 var saveUsers= {
				 id : $scope.sysPro.id ? $scope.sysPro.id : null,
				 username:$scope.sysPro.username,
				 password: $scope.sysPro.password,
			     name: $scope.sysPro.name,
	    		 orgId: $scope.sysPro.orgId,
	    		 birthday :null,
	    		 userPhoto: null,
	    		 createUser:$scope.user.id,
	    		 createDate:null,
	    		 updateUser:$scope.user.id,
	    		 updateUserName:null,
	    		 createUserName:null,
	    		 updateDate:null,
	    		 delFlag :"0",
	    		 menuList:null,
	    		 roleIds:$scope.sysPro.roleIds,
	    		 orgCode:null,
	    		 orgName :null,
	    		 orgNumber:$scope.sysPro.orgNumber,
	    		 sex:$scope.sysPro.sex,
	    		 phone:$scope.sysPro.phone,
	    		 email:$scope.sysPro.email,
	    		 description:$scope.sysPro.description,
	    		
		 }
		 console.log("save");
		 console.log(saveUsers);
		 
		 $http({
				method:'POST',
				url:"user/save.do",
				data:saveUsers,
				dataType:'json'
		}).success(function(data){
			if(data.result=='save_success'){
				alert("保存成功");
		/*		console.log(saveUsers);*/
				$location.path('/home/user');
			}else{
				alert("保存失败");
			}
			
		});	 
//		 console.log($scope.userdata);
		 
	};
	 
	 $scope.cancel = function() {
		 $location.path('/home/user');
	};
}


