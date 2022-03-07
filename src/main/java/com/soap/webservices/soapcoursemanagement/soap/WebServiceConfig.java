package com.soap.webservices.soapcoursemanagement.soap;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs

@Configuration
public class WebServiceConfig {
	//MessageDispatcherServlet
	
	//Application Context
	
	// URL --> /ws/*
	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
	}
	
	// /ws/courses.wsdl
	
	
	// soap-schema.xsd
	
	
	@Bean(name = "courses")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema courseSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		
		
		// PortType = CoursePort
		definition.setPortTypeName("CoursePort");
		//namespace - http://www.spring-shyam-demo.com
		definition.setTargetNamespace("http://www.spring-shyam-demo.com");
		definition.setLocationUri("/ws");
		definition.setSchema(courseSchema);
		// /ws
		// schema
		
		return definition;
	}
	
	
	@Bean
	public XsdSchema courseSchema() {
		
		return new SimpleXsdSchema(new ClassPathResource("/xsd/soap-schema.xsd"));
		
	}
	
	
	

}
