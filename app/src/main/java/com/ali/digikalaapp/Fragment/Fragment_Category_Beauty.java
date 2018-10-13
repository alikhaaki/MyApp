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

public class Fragment_Category_Beauty extends Fragment {
	private ListView listView;
	private ArrayList<ModelCategory> model;
	private AdapterListCategory adapterList;
	public Fragment_Category_Beauty() {
	
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.fragment_fragment__beauty, container, false);
		
		
		listView=v.findViewById(R.id.listView);
		
		model=new ArrayList<>();
		
		ModelCategory item;
		
		
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.abzar_mate);
		item.setTextCategory("ابزار برقی چند کاره");
		model.add(item);
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.mate_tools);
		item.setTextCategory("مته دریل");
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
						intent.putExtra(DigiActivity.KEY_NAME, DigiActivity.TOOLS);
						startActivity(intent);
						break;
					case 1:
						Toast.makeText(view.getContext(),  "مته دریل", Toast.LENGTH_SHORT).show();
						break;
				 
					
				}
				
			}
		});
		return v;
	}
	public static Fragment_Category_Beauty newInstance() {
		
		Bundle args = new Bundle();
		
		Fragment_Category_Beauty fragment = new Fragment_Category_Beauty();
		fragment.setArguments(args);
		return fragment;
	}
	
}
