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

public class Fragment_Category_Digital extends Fragment {
	

	private ListView listView;
	private ArrayList<ModelCategory> model;
	private AdapterListCategory adapterList;
	public Fragment_Category_Digital() {
 	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		
		View v=inflater.inflate(R.layout.fragment_fragment__category_mobile, container,false);
		
		listView=v.findViewById(R.id.listView);
		
		model=new ArrayList<>();
		
		ModelCategory item;
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.digital_1);
		item.setTextCategory("موبایل");
		model.add(item);
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.digital_2);
		item.setTextCategory("تبلت");
		model.add(item);
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.digital_3);
		item.setTextCategory("لپ تاب");
		model.add(item);
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.digital_4);
		item.setTextCategory("دوربین عکاسی");
		model.add(item);
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.digital_5);
		item.setTextCategory("کامپیوتر خانگی");
		model.add(item);
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.digital_6);
		item.setTextCategory("لوازم جانبی موبایل");
		model.add(item);
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.digital_7);
		item.setTextCategory("لوازم جانبی کامپیوتر");
		model.add(item);
		
		item=new ModelCategory();
		item.setImageCategory(R.drawable.digital_8);
		item.setTextCategory("کنسول بازی");
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
						intent.putExtra(DigiActivity.KEY_NAME, DigiActivity.MOBILE);
						startActivity(intent);
						break;
					case 1:
						Toast.makeText(view.getContext(),  "تبلت", Toast.LENGTH_SHORT).show();
						break;
					case 2:
						Toast.makeText(view.getContext(), "لپ تاب" , Toast.LENGTH_SHORT).show();
						break;
					case 3:
						Toast.makeText(view.getContext(),  "دوربین عکاسی", Toast.LENGTH_SHORT).show();
						break;
					case 4:
						Toast.makeText(view.getContext(),  "کامپیوتر خانگی", Toast.LENGTH_SHORT).show();
						break;
					case 5:
						Toast.makeText(view.getContext(),  "  لوازم جانبی موبایل", Toast.LENGTH_SHORT).show();
						break;
					case 6:
						Toast.makeText(view.getContext(),  "لوازم جانبی کامپیوتر", Toast.LENGTH_SHORT).show();
						break;
					case 7:
						Toast.makeText(view.getContext(),  "کنسول بازی ", Toast.LENGTH_SHORT).show();
						break;
					
				}
				
			}
		});
		
 		return v;
	}
	
	
	public static Fragment_Category_Digital newInstance() {
		
		Bundle args = new Bundle();
		
		Fragment_Category_Digital fragment = new Fragment_Category_Digital();
		fragment.setArguments(args);
		return fragment;
	}
}
