'use strict';

/**
 * loginCtrl
 */
var loginCtrl = function($scope, $http,$location,LocalStorageService) {

    $scope.login = function() {
    	
    	var newUser =  
    	{  
    			username:$scope.account, 
    			password:$scope.password  
    	}
    	$http({
    		    method:"post",
    		    url:"login/checkUser.do",
    		    data:newUser,
    		    dataType:'json'
    		  }).success(function(data){
//    			  console.log(data.result);
//    			  console.log(data.user);
//    			  console.log(data.menulist);
    			  if(data.result == "login_success"){
    				  LocalStorageService.update("loginIfo",data.user);
    				  LocalStorageService.update("menulist",data.menulist);
    				  alert("登录成功");
    				  $location.path('/home');
    			  }else{
    				  if(data.result == "account_error"){
    					 alert("没有该账户");
    				  }else{
    					 alert("密码错误");
    				  }			  
    			  }
        })
    };

    /*$scope.addNewUser = function(newUser) {
        $http.post('users/addUser/' + newUser).success(function() {
            $scope.fetchUsersList();
        });
        $scope.userName = '';
    };*/

   /* $scope.removeUser = function(user) {
        $http.delete('users/removeUser/' + user).success(function() {
            $scope.fetchUsersList();
        });
    };

    $scope.removeAllUsers = function() {
        $http.delete('users/removeAllUsers').success(function() {
            $scope.fetchUsersList();
        });

    };
*/
    /*$scope.fetchUsersList();*/
};