package it.edoardo.springweb.info;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;

import it.edoardo.springweb.model.interfaces.Jsonable;


public class JsonResponse implements Jsonable{
	
	private JSONArray data;
	
	public JsonResponse(JSONArray data) {
		this.data = data;
	}
	
	public JsonResponse(JSONObject data) {
		this.data = new JSONArray().put(data);
	}
	
	public JSONArray getData() {
		return data;
	}
	
	public void setData(JSONArray data) {
		this.data = data;
	}
	
	@Override
	public JSONObject toJson() {
		return null;
	}
}
