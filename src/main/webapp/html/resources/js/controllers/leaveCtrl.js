var sysProitem=[];
var leaveCtrl = function($scope,$http, $location,LocalStorageService) {
	
	$scope.page=[];
    $scope.user = LocalStorageService.get("loginIfo");
    var courseUser =  {
    		id:$scope.user.id,
    		roleIds:$scope.user.roleIds
    };
    
    var courelist = $http({
		method:'POST',
		url:"leaves/list.do",
		data:courseUser,
		dataType:'json'
	}).success(function(data){
		  $scope.page = {
			result:data
		 };
		console.log($scope.page);
	});
    
    
    
      $scope.addleave=function(){
	    $location.path('/home/addleave');
        } 
 
	 
  	$scope.deluser = function(items,$event) {
		$http({
	    	method:"post",
	    	url:"leaves/delete.do",
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
	  $scope.updateuser = function(items) {
			 sysProitem = items;
			 $location.path('/home/addleave');
		}
	  $scope.apply = function(items) {
			sysProitem = items;
			$http({
		    	method:"post",
		    	url:"leaves/list.do",
		    	data:items.id
		    }).success(function(data){
		    	console.log(data);
	    		$location.path('/home/class');
		    })
		}
}

var addleaveCtrl = function($scope, $http,$location,$compile,LocalStorageService) {
	$scope.sysPro = sysProitem;
	sysProitem = [];
	$scope.user = LocalStorageService.get("loginIfo");
	$scope.removeItem = function($event) {
		$($event.target).parent().parent().parent().remove();
	}
	
		 $scope.saveleave = function() {
		 
			 var saveleave = {
					 id : $scope.sysPro.id ? $scope.sysPro.id : null,
					 courseId:$scope.sysPro.courseId,
					 courseName: $scope.sysPro.courseName,
				     userId: $scope.sysPro.userId,
		    		 userName: $scope.sysPro.userName,
		    		 leaveTime : $scope.sysPro.leaveTime,
		    		 leaveNo :$scope.sysPro.leaveNo,
		    		 reason:$scope.sysPro.reason,
		    		 leaveStatus:$scope.sysPro.leaveStatus,
		    		 createUser:$scope.user.id,
					 createDate:null,
					 updateUserName:null,
		    		 createUserName:null,
		    		 delFlag :"0",
					 updateUser:$scope.user.id,
					 updateDate:null,
			 }
		 console.log(saveleave);

			 $http({
					method:'POST',
					url:"leaves/save.do",
					data:saveleave,
					dataType:'json'
			}).success(function(data){
				if(data.result=='save_success'){
					alert("保存成功");
					$location.path('/home/leave');
				}else{
					alert("保存失败");
				}
				
			});	 
//			 console.log($scope.saveleave);
			 
			 
		}
		 
		 $scope.cancel = function() {
			 $location.path('/home/leave');
		}
}
