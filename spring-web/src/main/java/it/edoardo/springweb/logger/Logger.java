package it.edoardo.springweb.logger;

import org.aspectj.lang.JoinPoint;

public abstract class Logger {
	
	protected String logMessage;

	public abstract void log(JoinPoint joinPoint);

	protected abstract void writeConsoleLog(String message);
	protected abstract void writeFileLog(String message);
}
