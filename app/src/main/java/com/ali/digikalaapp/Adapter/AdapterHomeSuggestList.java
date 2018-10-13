package com.ali.digikalaapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ali.digikalaapp.Model.ModelHomeTools;
import com.ali.digikalaapp.R;

import java.util.List;

public class AdapterHomeSuggestList extends RecyclerView.Adapter<AdapterHomeSuggestList.ViewHolderSuggestion> {
	
	private Context context;
	private List<ModelHomeTools> modelHomeTools;
	
	public AdapterHomeSuggestList(Context context, List<ModelHomeTools> modelHomeTools) {
		this.context = context;
		this.modelHomeTools = modelHomeTools;
	}
	
	@NonNull
	@Override
	public ViewHolderSuggestion onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		
		View v = LayoutInflater.from(context).inflate(R.layout.model_list_detail, parent,false);
		return new ViewHolderSuggestion(v);
		
	}
	
	@Override
	public void onBindViewHolder(@NonNull ViewHolderSuggestion holder, int position) {
	
		ModelHomeTools item= modelHomeTools.get(position);
		
		holder.textHeader.setText(item.getTextTitle());
		holder.textPreviousPrice.setText(item.getTextPriceDiscount());
		holder.textCurrentPrice.setText(item.getTextPriceOriginal());
		holder.textSubHeader.setText(item.getTextSubTitle());
		holder.imageView.setImageResource(item.getImageProductItem());
	}
	
	@Override
	public int getItemCount() {
		int cont=modelHomeTools.size();
		Log.i("adapter", "getItemCount: "+cont);
		return modelHomeTools.size();
		
	}
	public class ViewHolderSuggestion extends RecyclerView.ViewHolder {
		private ImageView imageView;
		private TextView textCurrentPrice;
		private TextView textPreviousPrice;
		private TextView textHeader;
		private TextView textSubHeader;
		public ViewHolderSuggestion(View itemView) {
			super(itemView);
			imageView=itemView.findViewById(R.id.image_tools_asli);
			textCurrentPrice =itemView.findViewById(R.id.text_tools_current_price_asli);
			textSubHeader=itemView.findViewById(R.id.text_tools_sub_asli);
			textPreviousPrice =itemView.findViewById(R.id.text_tools_previous_piece_asli);
			textHeader =itemView.findViewById(R.id.text_tools_header_asli);
			
		}
	}
}
