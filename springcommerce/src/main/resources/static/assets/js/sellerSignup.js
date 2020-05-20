angular
		.module('mySellerApp', [])
		.controller(
				'SellerController',
				function($scope) {

					var sellers = [ {
						firstName: "",
						lastName: "",
						age: "",
						gender: "",
						address: "",
						city: "",
						state: "",
						email: ""
					} ];

					$scope.addThisSeller = function() {
						$scope.sellers.push({
							firstName : $scope.firstName,
							lastName : $scope.lastName,
							age : $scope.age,
							gender : $scope.gender,
							address : $scope.address,
							city : $scope.city,
							state : $scope.state,
							email : $scope.email
						});
						document.getElementById("register").reset();
					};

					$scope.removeThisSeller = function(index) {
						$scope.sellers.splice(index, 1);						
					};

					$scope.editThisSeller = function(index) {
						document.forms["register"].elements['firstName'].value = $scope.sellers[index].firstName;
						document.forms["register"].elements['lastName'].value = $scope.sellers[index].lastName;
						document.forms["register"].elements['age'].value = $scope.sellers[index].age;
						document.forms["register"].elements['gender'].value = $scope.sellers[index].gender;
						document.forms["register"].elements['address'].value = $scope.sellers[index].address;
						document.forms["register"].elements['city'].value = $scope.sellers[index].city;
						document.forms["register"].elements['state'].value = $scope.sellers[index].state;
						document.forms["register"].elements['email'].value = $scope.sellers[index].email;

						$scope.sellers.splice(index, 1);
					};

					$scope.sellers = sellers;
					$scope.firstName = sellers.firstName;
					$scope.lastName = sellers.lastName;
					$scope.age = sellers.age;
					$scope.gender = sellers.gender;
					$scope.address = sellers.address;
					$scope.city = sellers.city;
					$scope.state = sellers.state;
					$scope.email = sellers.email;

				});