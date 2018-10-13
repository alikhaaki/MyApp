package com.ali.digikalaapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ali.digikalaapp.Model.ModelCategory;
import com.ali.digikalaapp.R;

import java.util.ArrayList;

public class AdapterListCategory extends BaseAdapter {
	private Context context;
	private ArrayList<ModelCategory> list;
	
	public AdapterListCategory(Context context,ArrayList<ModelCategory> list){
		this.context=context;
		this.list=list;
	}
	@Override
	public int getCount() {
		return list.size();
	}
	@Override
	public Object getItem(int position) {
		return list.get(position);
	}
	@Override
	public long getItemId(int i) {
		return i;
	}
	@Override
	public View getView(int position, View v, ViewGroup parent) {
		if (v==null){
			v= LayoutInflater.from(context).inflate(R.layout.model_category, parent,false);
		}
		ModelCategory model= (ModelCategory) getItem(position);
		
		ImageView imageView=v.findViewById(R.id.image_category);
		TextView textView=v.findViewById(R.id.text_category);
		
		imageView.setImageResource(model.getImageCategory());
		textView.setText(model.getTextCategory());
		
		
		return v;
	}
}
