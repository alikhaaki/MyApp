package com.ali.digikalaapp.HelperClass;

import android.content.Context;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ApiServices {
	
	public static final String JSON_URL = "http://192.168.1.3:88/7learn/GetPosts.php";
	
	private Context context;
	private Gson gson=new Gson();
	GsonBuilder gsonBuilder=new GsonBuilder();
	
	public ApiServices(Context context){
		this.context=context;
	}
	
	public void getPost(final ReceiveVolley receivePost) {
		
		JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
			
			@Override
			public void onResponse(JSONArray response) {
			
				if (response == null) {

				} else
				{
					List<ModelProductServer> modelPost=new ArrayList<>();

					for (int i = 0; i < response.length(); i++) {
						ModelProductServer model=new ModelProductServer();
						try {

							JSONObject jsonObject=response.getJSONObject(i);
							model.setImage_url(jsonObject.getString("image_url"));
							model.setPrice_original(jsonObject.getString("price_original"));
							model.setPrice_discount(jsonObject.getString("price_discount"));
							model.setTitle(jsonObject.getString("title"));
							model.setSub_title(jsonObject.getString("sub_title"));

							
							modelPost.add(model);

						} catch (JSONException e) {
							e.printStackTrace();
						}
						receivePost.onReceivedData(modelPost);
					
					}
				}
			}
			
			
		}, new Response.ErrorListener() {
			
			@Override
			public void onErrorResponse(VolleyError error) {
			
			}
		});
		
		request.setRetryPolicy(new DefaultRetryPolicy(18000,2,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
		RequestQueue requestQueue= Volley.newRequestQueue(context);
		requestQueue.add(request);
		
	}
	
	public interface ReceiveVolley {
		
		void onReceivedData(List<ModelProductServer> listLavazem);
	}
}
