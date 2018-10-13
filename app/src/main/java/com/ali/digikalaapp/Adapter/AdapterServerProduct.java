package com.ali.digikalaapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ali.digikalaapp.Model.ModelProductServer;
import com.ali.digikalaapp.R;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterServerProduct extends RecyclerView.Adapter<AdapterServerProduct.ServerViewHolder> {
	
	private Context context;
	private List<ModelProductServer> itemList;
	
	public AdapterServerProduct(Context context, List<ModelProductServer> itemList) {
		this.context = context;
		this.itemList = itemList;
	}
	@NonNull
	@Override
	public ServerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_linear_lavazem, parent, false);
		
		return new ServerViewHolder(v);
		
	}
	
	@Override
	public void onBindViewHolder(@NonNull ServerViewHolder holder, int position) {
		ModelProductServer model = itemList.get(position);
		
		holder.textPriceDiscount.setText(model.getPrice_discount());
		holder.textPriceOriginal.setText(model.getPrice_original());
		holder.textHeader.setText(model.getTitle());
		holder.textSubHeader.setText(model.getSub_title());
		Picasso.with(context).load(model.getImage_url()).into(holder.image_product);
	}
	
	@Override
	public int getItemCount() {
		return itemList.size();
	}
	public class ServerViewHolder extends RecyclerView.ViewHolder {
		
		private ImageView image_product;
		private TextView textPriceOriginal;
		private TextView textPriceDiscount;
		private TextView textHeader;
		private TextView textSubHeader;
		public ServerViewHolder(View itemView) {
			super(itemView);
			image_product = itemView.findViewById(R.id.imageLavazemItem);
			textHeader = itemView.findViewById(R.id.textHeaderItemLavazemKhane);
			textSubHeader = itemView.findViewById(R.id.textSubItemLavazemKhane);
			textPriceDiscount = itemView.findViewById(R.id.text_price_discount);
			textPriceOriginal = itemView.findViewById(R.id.text_price_original);
		}
	}
	
}
