package it.edoardo.springweb.info;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import it.edoardo.springweb.model.Item;
import it.edoardo.springweb.model.interfaces.Jsonable;


public class JsonResponse implements Jsonable{
	
	private JSONArray data;
	
	public JsonResponse(List<Item> items) {
		this.data = new JSONArray();
		items.forEach((item) -> this.data.put(item));
	}
	
	public JsonResponse(Item item) {
		this.data = new JSONArray().put(item.toJson());
	}
	
	public JSONArray getData() {
		return data;
	}
	
	public void setData(JSONArray data) {
		this.data = data;
	}
	
	@Override
	public JSONObject toJson() {
		return new JSONObject().put("data", this.data);
	}
}
