package com.ali.digikalaapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ali.digikalaapp.Model.ModelHomeTools;
import com.ali.digikalaapp.R;

import java.util.List;

public class AdapterDigiSuggestion extends RecyclerView.Adapter<AdapterDigiSuggestion.ViewHolderDigiSuggestion> {
	
	private Context context;
	private List<ModelHomeTools> modelHomeTools;
	
	public AdapterDigiSuggestion(Context context, List<ModelHomeTools> modelHomeTools) {
		this.context = context;
		this.modelHomeTools = modelHomeTools;
	}
	
	@NonNull
	@Override
	public ViewHolderDigiSuggestion onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(context).inflate(R.layout.model_digi_suggestion, parent,false);
		
		return new ViewHolderDigiSuggestion(v);
	}
	
	
	@Override
	public void onBindViewHolder(@NonNull ViewHolderDigiSuggestion holder, int position) {
		
		ModelHomeTools item= modelHomeTools.get(position);
		
		holder.textHeader.setText(item.getTextTitle());
		holder.textPreviousPrice.setText(item.getTextPriceDiscount());
		holder.textCurrentPrice.setText(item.getTextPriceOriginal());
		holder.textSubHeader.setText(item.getTextSubTitle());
		holder.imageView.setImageResource(item.getImageProductItem());
	}
	
	@Override
	public int getItemCount() {
		return modelHomeTools.size();
	}
	public class ViewHolderDigiSuggestion extends RecyclerView.ViewHolder {
		private ImageView imageView;
		private TextView textCurrentPrice;
		private TextView textPreviousPrice;
		private TextView textHeader;
		private TextView textSubHeader;
		public ViewHolderDigiSuggestion(View itemView) {
			super(itemView);
			imageView=itemView.findViewById(R.id.image_tools_asli_digi);
			textCurrentPrice =itemView.findViewById(R.id.text_tools_current_price_asli_digi);
			textSubHeader=itemView.findViewById(R.id.text_tools_sub_asli_digi);
			textPreviousPrice =itemView.findViewById(R.id.text_tools_previous_piece_asli_digi);
			textHeader =itemView.findViewById(R.id.text_tools_header_asli_digi);
			
		}
	}
}
