package it.edoardo.springweb.logger.user;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import it.edoardo.springweb.logger.Logger;

@Aspect
public class UserLogger extends Logger{
	
	// TODO: remove message field, add LocalDateTime ...

	public UserLogger(String logMessage) {
		super(logMessage);
	}

	@After(value = "execution(* it.edoardo.springweb.controller.rest.UserController.*(..))")
	@Override
	public void log(JoinPoint joinPoint) {
		this.writeConsoleLog();
		this.writeFileLog();
	}

	@Override
	protected void writeConsoleLog() {		
		System.out.println("Before a method of UserController class");
	}

	@Override
	protected void writeFileLog() {
	}

}
