package it.edoardo.springweb.logger;

import org.aspectj.lang.JoinPoint;

public abstract class Logger {
	
	protected String logMessage;
	
	public Logger(String logMessage) {
		this.logMessage = logMessage;
	}

	public abstract void log(JoinPoint joinPoint);

	protected abstract void writeConsoleLog();
	protected abstract void writeFileLog();
}
