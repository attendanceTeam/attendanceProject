(function () {
    'use strict';
    angular.module('AngularSpringmvcMybatis.services')
        .factory('LocalStorageService', function () {
            var service = {};
            service.get = function(key,defaultValue){
              var val = localStorage.getItem(key);
              try{
                val = angular.fromJson(val);
              }
              catch(error){
                val = null;
              }
              if(defaultValue && !val){
                val = defaultValue;
              }
              return val;
            };
           service.update = function (key,value) {
             if(value){
               localStorage.setItem(key,angular.toJson(value));
             }
           };
           service.add = function (key,value) {
             this.update(key,value);
           };
           service.deletekey = function (key) {
            localStorage.removeItem(key);
          };

            return service;
            return {
              get: function (key, defaultValue) {
                var val = localStorage.getItem(key);
                try {
                  val = angular.fromJson(val);
                }
                catch (error) {
                  val = null;
                }
                if (defaultValue && val) {
                  val = defaultValue;
                }
                return val;
              }
            };
        });
})();
