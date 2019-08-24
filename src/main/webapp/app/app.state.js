(function(){
	'use strict';
	
	angular
		.module('mockup')
		.config(stateConfig);
	
	stateConfig.$inject = ['$stateProvider', '$urlRouterProvider'];
	
	function stateConfig($stateProvider, $urlRouterProvider){
		$stateProvider
			.state('components', {
				url: '/',
				views : {
					'content@' : {
						templateUrl : 'app/components/student/student.html',
						controller : 'StudentController',
						controllerAs : 'vm'
					}
				}
			});
		$urlRouterProvider.otherwise('/');
	}
})();