package com.ali.digikalaapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ali.digikalaapp.Model.ModelButton;
import com.ali.digikalaapp.R;

import java.util.List;

public class AdapterButton extends RecyclerView.Adapter<AdapterButton.ViewHolderButton> {
	
	private Context context;
	private List<ModelButton> modelButton;
	
	public AdapterButton(Context context, List<ModelButton> modelButton) {
		this.context = context;
		this.modelButton = modelButton;
	}
	
	@NonNull
	@Override
	public ViewHolderButton onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		
		View v = LayoutInflater.from(context).inflate(R.layout.model_button, parent, false);
		return new ViewHolderButton(v);
	}
	@Override
	public void onBindViewHolder(@NonNull ViewHolderButton holder, int position) {
		
		ModelButton models = modelButton.get(position);
		
		holder.textView.setText(models.getTextButton());
		
		
		
		
	}
	@Override
	public int getItemCount() {
		return modelButton.size();
	}
	class ViewHolderButton extends RecyclerView.ViewHolder {
		
		
		private TextView textView;
		ViewHolderButton(View itemView) {
			super(itemView);
			textView = itemView.findViewById(R.id.textRecyclerModel);
			
		}
		
	}
	
}
