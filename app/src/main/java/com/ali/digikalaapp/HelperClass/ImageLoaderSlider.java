package com.ali.digikalaapp.HelperClass;

import android.content.Context;
import android.widget.ImageView;

import com.ali.digikalaapp.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import ss.com.bannerslider.ImageLoadingService;

public class ImageLoaderSlider implements ImageLoadingService {
	private Context context;
	public ImageLoaderSlider(Context context){
		this.context=context;
	}
	
	@Override
	public void loadImage(String url, ImageView imageView) {
		Picasso.with(context).load(url).into(imageView);
		
	}
	@Override
	public void loadImage(int resource, ImageView imageView) {
		Picasso.with(context).load(resource).into(imageView);
	}
	@Override
	public void loadImage(String url, int placeHolder, int errorDrawable, ImageView imageView) {
		Picasso.with(context).load(url).into(imageView);
		
	}
}
