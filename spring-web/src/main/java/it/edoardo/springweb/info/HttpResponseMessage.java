package it.edoardo.springweb.info;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;

import it.edoardo.springweb.model.interfaces.Jsonable;

public class HttpResponseMessage implements Jsonable{
	
	private String message;
	private JSONArray data;
	private HttpStatus status;
	
	public HttpResponseMessage(String message, JSONArray data, HttpStatus status) {
		this.message = message;
		this.data = data;
		this.status = status;
	}
	
	public HttpResponseMessage(String message, JSONObject data, HttpStatus status) {
		this.message = message;
		this.data = new JSONArray().put(data);
		this.status = status;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public JSONArray getData() {
		return data;
	}
	
	public void setData(JSONArray data) {
		this.data = data;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	@Override
	public JSONObject toJson() {
		final JSONObject json = new JSONObject();
		json.put("message", this.getMessage())
			.put("data", this.getData())
			.put("status", this.getStatus().toString());
		return json;
	}
}
