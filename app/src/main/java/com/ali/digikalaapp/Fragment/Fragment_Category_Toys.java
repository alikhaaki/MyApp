package com.ali.digikalaapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ali.digikalaapp.Activity.DigiActivity;
import com.ali.digikalaapp.Activity.ProductListActivity;
import com.ali.digikalaapp.Adapter.AdapterListCategory;
import com.ali.digikalaapp.Model.ModelCategory;
import com.ali.digikalaapp.R;

import java.util.ArrayList;

public class Fragment_Category_Toys extends Fragment {
	private ListView listView;
	private ArrayList<ModelCategory> model;
	private AdapterListCategory adapterList;
	public Fragment_Category_Toys() {
 	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
 		View v= inflater.inflate(R.layout.fragment_fragment__category_digital, container, false);
		listView=v.findViewById(R.id.listView);
		
		model=new ArrayList<>();
		
		ModelCategory item;
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.baby_4);
		item.setTextCategory("اسباب بازی");
		model.add(item);
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.baby_2);
		item.setTextCategory("لوازم کودک");
		model.add(item);
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.baby_3);
		item.setTextCategory("لوازم خواب");
		model.add(item);
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.baby_1);
		item.setTextCategory("لباس کودک");
		model.add(item);
		
		adapterList=new AdapterListCategory(getActivity(),model);
		
		listView.setAdapter(adapterList);
		
		
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent=new Intent(view.getContext(), ProductListActivity.class);
				switch (position)
				{
					case 0:
						intent.putExtra(DigiActivity.KEY_NAME, DigiActivity.BABY_TOYS);
						startActivity(intent);
						break;
					case 1:
						Toast.makeText(view.getContext(),  "لوازم کودک", Toast.LENGTH_SHORT).show();
						break;
					case 2:
						Toast.makeText(view.getContext(), "لوازم خواب" , Toast.LENGTH_SHORT).show();
						break;
					case 3:
						Toast.makeText(view.getContext(),  "لباس کودک", Toast.LENGTH_SHORT).show();
						break;
					 
				}
				
			}
		});
		return v;
 	
 	
	}
	
	public static Fragment_Category_Toys newInstance() {
		
		Bundle args = new Bundle();
		
		Fragment_Category_Toys fragment = new Fragment_Category_Toys();
		fragment.setArguments(args);
		return fragment;
	}
}
