package com.soap.webservices.soapcoursemanagement.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soap.webservices.soapcoursemanagement.soap.bean.Course;
import com.soap.webservices.soapcoursemanagement.soap.exception.CourseNotFoundException;
import com.soap.webservices.soapcoursemanagement.soap.service.CourseDetailsService;
import com.spring_shyam_demo.CourseDetails;
import com.spring_shyam_demo.DeleteCourseDetailsRequest;
import com.spring_shyam_demo.DeleteCourseDetailsResponse;
import com.spring_shyam_demo.GetAllCourseDetailsRequest;
import com.spring_shyam_demo.GetAllCourseDetailsResponse;
import com.spring_shyam_demo.GetCourseDetailsRequest;
import com.spring_shyam_demo.GetCourseDetailsResponse;
import com.spring_shyam_demo.StatusType;

@Endpoint
public class SoapEndpoint {
	//method
	//input - GetCourseDetailsRequest
	//output - GetCourseDetailsResponse
	//http://www.spring-shyam-demo.com
	//GetCourseDetailsRequest
	
	
	@Autowired
	CourseDetailsService service;
	
	@PayloadRoot(localPart = "GetCourseDetailsRequest", namespace = "http://www.spring-shyam-demo.com")
	@ResponsePayload
	public GetCourseDetailsResponse processGetCourseDetailsResponse(@RequestPayload  GetCourseDetailsRequest request) {
		
		Course course = service.findById(request.getId());
		if(course == null) {
			throw new CourseNotFoundException("Invalid Course ID " +request.getId());
		}
		
		return mapCourseDetails(course);
	}

	private GetCourseDetailsResponse mapCourseDetails(Course course) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		
		
		response.setCourseDetails(mapCourse(course));
		return response;
	}
	
	private GetAllCourseDetailsResponse mapAllCourseDetails(List<Course> courses) {
		GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
		
		for(Course course: courses) {
			CourseDetails mapCourse = mapCourse(course);
			response.getCourseDetails().add(mapCourse);
		}
		return response;
	}

	private CourseDetails mapCourse(Course course) {
		CourseDetails courseDetails = new CourseDetails();
		
		
		
		courseDetails.setId(course.getId());
		courseDetails.setDescription(course.getDescription());
		courseDetails.setName(course.getName());
		return courseDetails;
	}
	
	@PayloadRoot(localPart = "GetAllCourseDetailsRequest", namespace = "http://www.spring-shyam-demo.com")
	@ResponsePayload
	public GetAllCourseDetailsResponse processAllGetCourseDetailsResponse(@RequestPayload  GetAllCourseDetailsRequest request) {
		
		List<Course> course = service.findAll();
		
		return mapAllCourseDetails(course);
	}
	
	@PayloadRoot(localPart = "DeleteCourseDetailsRequest", namespace = "http://www.spring-shyam-demo.com")
	@ResponsePayload
	public DeleteCourseDetailsResponse processDeleteCourseDetailsResponse(@RequestPayload  DeleteCourseDetailsRequest request) {
		
//		
		int status = service.deleteById(request.getId());
		DeleteCourseDetailsResponse response = new DeleteCourseDetailsResponse();
		response.setStatus(status);
		return response;
	}
	
}
