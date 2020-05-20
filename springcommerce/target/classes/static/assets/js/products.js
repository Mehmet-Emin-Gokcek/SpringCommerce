var app = angular.module('myProductApp', []);
app.controller('productsCtrl', function($scope, $http) {
  $http.get('assets/js/productdata.json').then(function (response) {
      $scope.myProducts = response.data.productrecords;
  });
});