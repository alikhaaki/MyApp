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

public class Fragment_Category_Clothes extends Fragment {
	private ListView listView;
	private ArrayList<ModelCategory> model;
	private AdapterListCategory adapterList;
	public Fragment_Category_Clothes() {
 	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
 		
		View v= inflater.inflate(R.layout.fragment_fragment__home__tools, container, false);
		listView=v.findViewById(R.id.listView);
		
		model=new ArrayList<>();
		
		ModelCategory item;
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.sport1);
		item.setTextCategory("کفش ورزرشی");
		model.add(item);
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.clothes_3);
		item.setTextCategory("عینک آفتابی");
		model.add(item);
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.clothes_4);
		item.setTextCategory("کت تک");
		model.add(item);
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.clothes_5);
		item.setTextCategory("پوشاک آقایان");
		model.add(item);
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.clothes_6);
		item.setTextCategory("لباس ورزشی");
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
						intent.putExtra(DigiActivity.KEY_NAME, DigiActivity.SPORT);
						startActivity(intent);
						break;
					case 1:
						Toast.makeText(view.getContext(),  " عینک آفتابی", Toast.LENGTH_SHORT).show();
						break;
					case 2:
						Toast.makeText(view.getContext(), "کت تک" , Toast.LENGTH_SHORT).show();
						break;
					case 3:
						Toast.makeText(view.getContext(),  "پوشاک آقایان", Toast.LENGTH_SHORT).show();
						break;
					case 4:
						Toast.makeText(view.getContext(),  "لباس ورزشی", Toast.LENGTH_SHORT).show();
						break;
					 
					
				}
				
			}
		});
		
		return v;
 	
	}
	
	public static Fragment_Category_Clothes newInstance() {
		
		Bundle args = new Bundle();
		
		Fragment_Category_Clothes fragment = new Fragment_Category_Clothes();
		fragment.setArguments(args);
		return fragment;
	}
}
