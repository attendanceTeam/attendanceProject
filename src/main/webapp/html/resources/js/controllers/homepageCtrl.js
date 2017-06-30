
var homepageCtrl = function($scope, $http,$location,LocalStorageService,$compile) {
/*	$scope.systemmenu={show:false};*/
    $scope.systemMangerShow = function($event) {
    	if($($event.target).next().is(":hidden")){
    		$($event.target).next().show();    //如果元素为隐藏,则将它显现
    	}else{
    		$($event.target).next().hide();     //如果元素为显现,则将其隐藏
    	}
    };
    $scope.loginInfo = LocalStorageService.get("loginIfo");
    $scope.menuList = LocalStorageService.get("menulist");
    $('#menusiderbar').append($scope.menuList);
    $compile($('#menusiderbar').contents())($scope);
    $('.sub-menu').hide(); 
}



