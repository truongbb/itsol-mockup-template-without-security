(function() {
	'use strict';

	angular.module('mockup').factory('StudentService', StudentService);

	StudentService.$inject = [ '$resource' ];

	function StudentService($resource) {
		var resourceUrl = '/student';
		return $resource(resourceUrl, {}, {
			'searchStudent': {
				method: 'POST',
				url: resourceUrl + '/search',
				isArray: true
			},
			'add': {
				method: 'POST',
				url: resourceUrl + '/add',
				transformRequest: function (data) {
					return angular.toJson(data);
				}
			},
			'delete': {
				method: 'POST',
				url: resourceUrl + '/delete',
				transformRequest: function (data) {
					return angular.toJson(data);
				}
			}
		});
	}
})();