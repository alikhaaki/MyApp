package com.ali.digikalaapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;

import com.ali.digikalaapp.Adapter.AdapterServerProduct;
import com.ali.digikalaapp.HelperClass.GsonApi;
import com.ali.digikalaapp.Model.ModelProductServer;
import com.ali.digikalaapp.R;
import com.android.volley.Response;

import java.util.Collections;
import java.util.List;

public class ProductServerActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_from_server);
		
	
		GsonApi gsonApi=new GsonApi(this);
		
		gsonApi.getPost(new GsonApi.ReceiveGson() {
			
			@Override
			public void onReceivedData(List<ModelProductServer> listLavazem) {
			
//				List<ModelProductServer> model=response
//				Collections.sort();
				RecyclerView recyclerView = findViewById(R.id.recycler_server);
				AdapterServerProduct adapt_server = new AdapterServerProduct(ProductServerActivity.this, listLavazem);
				recyclerView.setLayoutManager(new LinearLayoutManager(ProductServerActivity.this, LinearLayoutManager.VERTICAL, false));
				recyclerView.setAdapter(adapt_server);
			}
		});
		
		
//		ApiServices api = new ApiServices(this);
//
//		api.getPost(new ApiServices.ReceiveVolley() {
//
//			@Override
//			public void onReceivedData(List<ModelProductServer> listLavazem) {
//
//
//			}
//		});
	}
}
