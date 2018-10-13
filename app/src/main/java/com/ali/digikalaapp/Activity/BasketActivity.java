package com.ali.digikalaapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ali.digikalaapp.Adapter.AdapterHomeSuggestList;
import com.ali.digikalaapp.HelperClass.UserSharedPreferences;
import com.ali.digikalaapp.Model.ModelHomeTools;
import com.ali.digikalaapp.R;

import java.util.ArrayList;
import java.util.List;

public class BasketActivity extends AppCompatActivity {
	
	private UserSharedPreferences userSharedPreferences;
	private ModelHomeTools modelHomeTools;
	private RecyclerView recyclerViewBasket;
	private AdapterHomeSuggestList adapterHomeSuggestList;
	private List<ModelHomeTools> list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_basket);
		
		Intent intent = getIntent();
		intent.getIntExtra("basket_key", 0);
		list=new ArrayList<>();
		recyclerViewBasket=findViewById(R.id.recycler_basket_layout);
		adapterHomeSuggestList=new AdapterHomeSuggestList(this,list);
		modelHomeTools=new ModelHomeTools();
		
		 modelHomeTools.setTextTitle("item one");
		 modelHomeTools.setTextPriceOriginal("300،000 تومان");
		 modelHomeTools.setImageProductItem(R.drawable.adidas_1);
		 list.add(modelHomeTools);
		 
		 recyclerViewBasket.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
		 recyclerViewBasket.setAdapter(adapterHomeSuggestList);
		 
	}
}
