(function () {
    'use strict';
    angular.module('mockup').config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('student', {
            parent: 'components',
            url: 'student',
            data: {},
            views: {
                'content@': {
                    templateUrl: 'app/components/student/student.html',
                    controller: 'StudentController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                // lazy load, i18n
            }
        }).state('student-add', {
            parent: 'student',
            url: '/add',
            data: {},
            views: {
                'content@': {
                    templateUrl: 'app/components/student/student-form.html',
                    controller: 'StudentFormController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
				// lazy load, i18n
            }
        }).state('student-update', {
            parent: 'student',
            url: 'update/:id',
            data: {},
            views: {
                'content@': {
                    templateUrl: 'app/components/student/student-form.html',
                    controller: 'StudentFormController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
				// lazy load, i18n
            }
        });
    }
})();