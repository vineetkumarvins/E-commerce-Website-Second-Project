/**
 *  JobService 
 */

app.factory('JobService',function($http){
	var jobService={}
	
	jobService.saveJob=function(job){
		return $http.post("http://localhost:8081/project2_backend/savejob",job)
	}
	
	jobService.getAllJobs=function(){
		return $http.get("http://localhost:8081/project2_backend/getalljobs")
	}
	
	return jobService;
})