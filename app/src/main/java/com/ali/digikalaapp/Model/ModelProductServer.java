package com.ali.digikalaapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

public class ModelProductServer {

	@SerializedName("image_url")
	private String image_url;
	@SerializedName("title")
	private String title;
	@SerializedName("sub_title")
	private String sub_title;
	@SerializedName("price_original")
	private String price_original;
	@SerializedName("price_discount")
	private String price_discount;
	@SerializedName("id")
	private int id;
	
	public ModelProductServer() {

	}

	public static Comparator<ModelProductServer> SORTING=new Comparator<ModelProductServer>() {

		@Override
		public int compare(ModelProductServer model, ModelProductServer t1) {
			return model.title.compareTo(t1.title);
		}
	};
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSub_title() {
		return sub_title;
	}
	public void setSub_title(String sub_title) {
		this.sub_title = sub_title;
	}
	public String getPrice_original() {
		return price_original;
	}
	public void setPrice_original(String price_original) {
		this.price_original = price_original;
	}
	public String getPrice_discount() {
		return price_discount;
	}
	public void setPrice_discount(String price_discount) {
		this.price_discount = price_discount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
