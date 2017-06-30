'use strict';
var App = angular.module('AngularSpringmvcMybatis', [   
	'ui.router',                                                 
   'AngularSpringmvcMybatis.filters',
   'AngularSpringmvcMybatis.services', 
   'AngularSpringmvcMybatis.directives']);

// Declare app level module which depends on filters, and services
App.config( function ($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise('/login');
    $stateProvider
        .state('login', {
            url: '/login',
            templateUrl: 'html/login/login.html'
        })
        .state('home', {
            url: '/home',
            templateUrl: 'html/homepage/homepage.html'
        })
        .state('home.menu', {
            url: '/menu',
            templateUrl: 'html/system/menu/menu.html'
        })
        .state('home.org', {
            url: '/org',
            templateUrl: 'html/system/org/org.html'
        })
        .state('home.user', {
            url: '/user',
            templateUrl: 'html/system/user/user.html'
        })
        .state('home.useradd', {
            url: '/useradd',
            templateUrl: 'html/system/user/useradd.html'
        })
        .state('home.role', {
            url: '/role',
            templateUrl: 'html/system/role/role.html'
        })
            .state('home.roleadd', {
            url: '/roleadd',
            templateUrl: 'html/system/role/roleadd.html'
        })
        .state('home.dictionary', {
            url: '/dictionary',
            templateUrl: 'html/system/dictionary/dictionary.html'
        })
        .state('home.adddictionary', {
            url: '/adddictionary',
            templateUrl: 'html/system/dictionary/adddictionary.html'
        })
        .state('home.addorg', {
            url: '/addorg',
            templateUrl: 'html/system/org/addorg.html'
        })
         .state('home.course', {
            url: '/course',
            templateUrl: 'html/course/course.html'
        })
         .state('home.courseadd', {
            url: '/courseadd',
            templateUrl: 'html/course/courseadd.html'
        })
         .state('home.class', {
            url: '/class',
            templateUrl: 'html/course/class.html'
        })
         .state('home.leave', {
            url: '/leave',
            templateUrl: 'html/leave/leave.html'
        })
         .state('home.addleave', {
            url: '/addleave',
            templateUrl: 'html/leave/addleave.html'
        })
         .state('home.attendance', {
            url: '/attendance',
            templateUrl: 'html/attendance/attendance.html'
        })

   
});
