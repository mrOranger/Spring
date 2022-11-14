package it.edoardo.springweb.logger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Aspect
public class Logger {
	
	private String message;
	

	@After(value = "within(* it.edoardo.springweb.controller.rest..*)")
	public void log(JoinPoint joinPoint) {
		this.message = new StringBuilder().append("[").
				append(LocalDateTime.now()).append("]")
				.append(" - ").
				append(this.getLog(joinPoint)).append("\n").toString(); 
		System.out.println(this.message);
	}
	
	private String getLog(JoinPoint joinPoint) {
		for(Annotation annotation : this.getAnnotations(joinPoint)) {
			return new StringBuilder().append(getHttpMethod(annotation))
					.append(" - ")
					.append(getUrlPath(annotation))
					.append(" - ")
					.append(getRemoteHost(joinPoint)).toString();
		}
		return "null";
	}
	
	private Annotation[] getAnnotations(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		return method.getAnnotations();
	}
	
	private String getHttpMethod(Annotation annotation) {
		if(annotation.annotationType().equals(GetMapping.class)) {
			return "[GET]";
		}
		if(annotation.annotationType().equals(PostMapping.class)) {
			return "[POST]";
		}
		if(annotation.annotationType().equals(PutMapping.class)) {
			return "[PUT]";
		}
		return "[DELETE]";
	}
	
	private String getUrlPath(Annotation annotation) {
		return new StringBuilder().append("[").
				append(((RequestMapping)annotation).path()[0])
				.append("]").toString();
	}
	
	private String getRemoteHost(JoinPoint joinPoint) {
		return new StringBuilder().append("[").
				append(((HttpServletRequest)joinPoint.getArgs()[0]).getRemoteHost()).
				append("]").toString();
	}	
}
