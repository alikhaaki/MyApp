package com.ali.digikalaapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ali.digikalaapp.Model.ModelSlider;
import com.ali.digikalaapp.R;

import java.util.List;

public class AdapterSliderImage extends RecyclerView.Adapter<AdapterSliderImage.HolderSlider> {
	
	private final Context context;
	private List<ModelSlider> modelSliders;
	
	public AdapterSliderImage(Context context, List<ModelSlider> modelSliders) {
		this.context = context;
		this.modelSliders = modelSliders;
	}
	@NonNull
	@Override
	public HolderSlider onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_slider, parent, false);
		
		return new HolderSlider(v);
	}
	@Override
	public void onBindViewHolder(@NonNull HolderSlider holder, int position) {
		ModelSlider m = modelSliders.get(position);
		holder.imageView.setImageResource(m.getImage());
		
	}
	@Override
	public int getItemCount() {
		return modelSliders.size();
	}
	 public class HolderSlider extends RecyclerView.ViewHolder {
		
		 private ImageView imageView;
		 public HolderSlider(View itemView) {
			 super(itemView);
			 imageView = itemView.findViewById(R.id.image_slider);
		 }
		
	 }


}
