package it.edoardo.springweb.logger.user;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import it.edoardo.springweb.logger.Logger;

@Aspect
public class UserLogger extends Logger{

	@After(value = "execution(* it.edoardo.springweb.controller.rest.UserController.*(..))")
	@Override
	public void log(JoinPoint joinPoint) {
		StringBuilder strBuilder = new StringBuilder().append("[").append(LocalDateTime.now()).append("]")
				.append(" - ").append(this.getMethodType(joinPoint)).append("\n");
		this.logMessage = strBuilder.toString();
		this.writeConsoleLog(this.logMessage);
		this.writeFileLog(this.logMessage);
	}
	
	// TODO: refactoring del metodo
	private String getMethodType(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		HttpServletRequest request = (HttpServletRequest)joinPoint.getArgs()[0];
		HttpServletResponse response = (HttpServletResponse)joinPoint.getArgs()[1];
		for(Annotation annotation : method.getAnnotations()) {
			if(annotation.annotationType().equals(GetMapping.class)) {
				return "[GET] - [" + ((GetMapping)annotation).path()[0] + "] - [" + request.getRemoteHost() + "]";
			}
			if(annotation.annotationType().equals(PostMapping.class)) {
				return "[POST] - ["  + ((PostMapping)annotation).path()[0] + "]";
			}
			if(annotation.annotationType().equals(PutMapping.class)) {
				return "[PUT] - [" + ((PutMapping)annotation).path()[0] + "]";
			}
			if(annotation.annotationType().equals(DeleteMapping.class)) {
				return "[DELETE] - [" + ((PutMapping)annotation).path()[0] + "]";
			}
		}
		return "null";
	}

	@Override
	protected void writeConsoleLog(String message) {		
		System.out.print(this.logMessage);
	}

	@Override
	protected void writeFileLog(String message) {
		// TODO: rivedere salvataggio file
	}
}
