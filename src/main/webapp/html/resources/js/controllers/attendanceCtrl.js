 var sysAttendance=[];


var attendanceCtrl = function($scope,$http, $location) {
// var menuCtrl = function($scope,$http, $location) {
	 	$scope.page=[];
	 	
	 	
	 		$scope.add = function() {
	 			// $location.path('/home/attendanceadd');
	 			$location.path('/home/menuList');
	 		}
	 		 $scope.del = function(id,$event) {
	 			//请求删除,删除成功后移除
	 			 console.log(id);
	 			 $($event.target).parent().parent().remove();
	 		}
	 		 $scope.update = function(items) {
	 			 sysProitem = items;
	 			 $location.path('/home/attendanceadd');
	 		}
	 		 
	 		 
};

var attendanceaddCtrl = function($scope, $http,$location,$compile) {
	//var menuListCtrl = function($scope, $http,$location,$compile) {
 		$scope.sysAttendance = sysAttendanceitem;
 		sysAttendanceitem = [];
 		
 		$scope.removeItem = function($event) {
 			$($event.target).parent().parent().parent().remove();
 		}
 		 $scope.save = function() {
 		   
// 			 $scope.saveAttendance
 		
 			var saveAttendance = {
 					 id:$scope.sysAttendance.id?$scope.sysAttendance.id:null,		 					 
 					 studentId: $scope.sysAttendance.studentId,
 					 studentName: $scope.sysAttendance.studentName,
 					 courseId: $scope.sysAttendance.courseId,
 					 courseName: $scope.sysAttendance.courseName,
 					 attendanceNo:$scope.sysAttendance.attendanceNo,
 					 row:$scope.sysAttendance.row,
 					 lie :$scope.sysAttendance.lie,
 					 attendanceStatus :$scope.sysAttendance.attendanceStatus,
 					 attendanceTime :$scope.sysAttendance.attendanceTime,
 					 info :$scope.sysAttendance.info,
 					 
 					 
 			 }
 			 console.log($scope.saveAttendance);
 			$location.path('/home/attendance');
 			//$location.path('/home/menu');
 		}
 		 $scope.can = function() {
 			 $location.path('/home/menu');
 		}
 };
 


 

 
	
