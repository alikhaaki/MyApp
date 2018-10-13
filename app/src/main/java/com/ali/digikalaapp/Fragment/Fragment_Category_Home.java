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

public class Fragment_Category_Home extends Fragment {
	private ListView listView;
	private ArrayList<ModelCategory> model;
	private AdapterListCategory adapterList;
	public Fragment_Category_Home() {
 	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.fragment_fragmnet__category__fashion, container, false);
		
	 
		
		listView=v.findViewById(R.id.listView);
		
		model=new ArrayList<>();
		
		ModelCategory item;
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.home_1);
		item.setTextCategory("صوتی و تصویری");
		model.add(item);
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.home_2);
		item.setTextCategory("لوازم برقی آشپزخانه");
		model.add(item);
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.home_3);
		item.setTextCategory("ظروف پلاستیکی");
		model.add(item);
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.home_4);
		item.setTextCategory("بشقاب و لیوان");
		model.add(item);
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.home_5);
		item.setTextCategory("میز غذا خوری");
		model.add(item);
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.home_6);
		item.setTextCategory("حوله دست و حمام");
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
						Toast.makeText(view.getContext(),  "صوتی و تصویری", Toast.LENGTH_SHORT).show();
						break;
					case 1:
						intent.putExtra(DigiActivity.KEY_NAME, DigiActivity.HOME_APPLIANCE);
						startActivity(intent);
						break;
					case 2:
						Toast.makeText(view.getContext(), "ظروف پلاستیکی" , Toast.LENGTH_SHORT).show();
						break;
					case 3:
						Toast.makeText(view.getContext(),  "بشقاب و لیوان", Toast.LENGTH_SHORT).show();
						break;
					case 4:
						Toast.makeText(view.getContext(),  "میز غذا خوری", Toast.LENGTH_SHORT).show();
						break;
					case 5:
						Toast.makeText(view.getContext(),  "حوله دست و حمام", Toast.LENGTH_SHORT).show();
						break;
				  
				}
				
			}
		});
		return v;
	}
	
	public static Fragment_Category_Home newInstance() {
		
		Bundle args = new Bundle();
		
		Fragment_Category_Home fragment = new Fragment_Category_Home();
		fragment.setArguments(args);
		return fragment;
	}
}
