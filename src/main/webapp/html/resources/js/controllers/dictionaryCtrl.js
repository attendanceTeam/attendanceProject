var sysDictionaryitem=[];

var dictionaryCtrl = function($scope, $http,$location) {
	$scope.page=[];
	 var dictlist = $http({
			method:'POST',
			url:"sysDictionary/list.do"
		}).success(function(data){
			 $scope.page = {
				result:data	 
			 }
//			 console.log($scope.page);
	});
	
	$scope.adddictionary = function() {
		 $location.path('/home/adddictionary');
	}
	 $scope.del = function(items,$event) {
		//请求删除,删除成功后移除
//		 console.log(items);
		 $http({
		    	method:"post",
		    	url:"sysDictionary/delete.do",
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
		 $($event.target).parent().parent().remove();
	}
	 $scope.update = function(items) {
		 sysDictionaryitem = items;
		 $location.path('/home/adddictionary');
	}
}
var addDicionaryCtrl = function($scope, $http,$location,$compile) {
	$scope.sysDictionary = sysDictionaryitem;
	sysDictionaryitem = [];
	$scope.addItem = function() {
		$('#childrenTable').append($('#trTemplate').html());
		$compile($('#childrenTable .addtr:last').contents())($scope);
	}
	$scope.removeItem = function($event) {
		$($event.target).parent().parent().parent().remove();
	}
	 $scope.save = function() {
		 var childrenList = [];
		 var temp= {code:"",name:"",sort:""}
		 $("#childrenTable input").each(function(index){
			 if(index%3 == 0){
				 temp.code = $(this).val();
			 }
			 else if(index%3 == 1){
				 temp.name = $(this).val();
			 }
			 else if(index%3 == 2){
				 temp.sort = $(this).val();
				 var tmp = {code:temp.code,name:temp.name,sort:temp.sort};
				 childrenList.push(tmp);
			 }
		 });
//		 console.log(childrenList);
		 var saveDictionary = {
				 id:$scope.sysDictionary.id?$scope.sysDictionary.id:'',
				 code:$scope.sysDictionary.code,
				 name:$scope.sysDictionary.name,
				 children:childrenList,	 
		 }
		 
		 $http({
				method:'POST',
				url:"sysDictionary/save.do",
				data:saveDictionary,
				dataType:'json'
		}).success(function(data){
			if(data.result=='save_success'){
				alert("保存成功");
				 $location.path('/home/dictionary');
			}else{
				alert("保存失败");
			}
			
		});	 
//		 console.log($scope.saveDictionary);
		
	}
	 $scope.cancel = function() {
		 $location.path('/home/dictionary');
	}
}