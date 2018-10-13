package com.ali.digikalaapp.HelperClass;

import android.content.Context;
import android.telecom.Call;

import com.ali.digikalaapp.Model.ModelProductServer;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GsonApi {
	
	public static final String JSON_URL = "http://192.168.1.4:88/7learn/GetPosts.php";
	
	private Context context;
	private Gson gson = new Gson();
	GsonBuilder gsonBuilder = new GsonBuilder();
	
	public GsonApi(Context context) {
		this.context = context;
	}
	
	public void getPost(final ReceiveGson receivePost) {
		
		JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
			
			@Override
			public void onResponse(JSONArray response) {
				
			
				Type type = new TypeToken<List<ModelProductServer>>() {
				
				}.getType();
				
//				Collections.sort();
				List<ModelProductServer> product = gson.fromJson(response.toString(), type);
			
				receivePost.onReceivedData(product);
				
			}
			
		}, new Response.ErrorListener() {
			
			@Override
			public void onErrorResponse(VolleyError error) {
			
			}
		});
		
		request.setRetryPolicy(new DefaultRetryPolicy(18000, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
		RequestQueue requestQueue = Volley.newRequestQueue(context);
		requestQueue.add(request);
		
	}
	
	public interface ReceiveGson {
		
		void onReceivedData(List<ModelProductServer> listLavazem);
	}
}





	

