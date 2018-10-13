package com.ali.digikalaapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ali.digikalaapp.Model.ModelHomeTools;
import com.ali.digikalaapp.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AdapterSuggestionItem extends RecyclerView.Adapter<AdapterSuggestionItem.HolderCategory> {
	
	private ArrayList<JSONObject> jsonList;
	private Context context;
	private String identifier;
	private List<ModelHomeTools> modelHomeTools;
	public AdapterSuggestionItem(ArrayList<JSONObject> jsonList, Context context) {
		this.jsonList = jsonList;
		this.context = context;
	}
	
	@NonNull
	@Override
	public HolderCategory onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model_suggestion_item, parent,false);
		
		return new HolderCategory(v);
	}
	@Override
	public void onBindViewHolder(@NonNull HolderCategory holder, int position) {
	
		 JSONObject itemList=jsonList.get(position);
		
		try {
			holder.textSuggest.setText(itemList.getString("list_name"));
			identifier=itemList.getString("id");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		ArrayList<JSONObject> jsonItemHorizontal=new ArrayList<JSONObject>();
		
		
		
		
		
		String url="";
		JSONObject jsonObject=new JSONObject();
		
		try {
			jsonObject.put("category", "id");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public int getItemCount() {
		return jsonList.size();
	}
	public class HolderCategory extends RecyclerView.ViewHolder{
		
	
		private Button buttonShowAll;
		private TextView textSuggest;
		private RecyclerView recyclerViewSuggest;
		public HolderCategory(View itemView) {
			super(itemView);
			buttonShowAll=itemView.findViewById(R.id.button_suggestion_show_all);
			textSuggest=itemView.findViewById(R.id.text_suggestion_item);
			recyclerViewSuggest=itemView.findViewById(R.id.recycler_suggestion);
	
		}
	}
	
}
