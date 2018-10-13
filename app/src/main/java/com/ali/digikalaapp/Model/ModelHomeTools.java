package com.ali.digikalaapp.Model;

public class ModelHomeTools {
	
	private int imageProductItem;
	private String textTitle;
	private String textSubTitle;
	private String textPriceOriginal;
	private String textPriceDiscount;
	private int itemBadgeCount;
	
	public ModelHomeTools(int imageProductItem, String textTitle, String textSubTitle, String textPriceOriginal, String textPriceDiscount) {
		this.imageProductItem = imageProductItem;
		this.textTitle = textTitle;
		this.textSubTitle = textSubTitle;
		this.textPriceOriginal = textPriceOriginal;
		this.textPriceDiscount = textPriceDiscount;
	}
	public ModelHomeTools() {
	
	}
	

	public int getImageProductItem() {
		return imageProductItem;
	}
	public void setImageProductItem(int imageProductItem) {
		this.imageProductItem = imageProductItem;
	}
	public String getTextTitle() {
		return textTitle;
	}
	public void setTextTitle(String textTitle) {
		this.textTitle = textTitle;
	}
	public String getTextSubTitle() {
		return textSubTitle;
	}
	public void setTextSubTitle(String textSubTitle) {
		this.textSubTitle = textSubTitle;
	}
	public String getTextPriceOriginal() {
		return textPriceOriginal;
	}
	public void setTextPriceOriginal(String textPriceOriginal) {
		this.textPriceOriginal = textPriceOriginal;
	}
	public String getTextPriceDiscount() {
		return textPriceDiscount;
	}
	public void setTextPriceDiscount(String textPriceDiscount) {
		this.textPriceDiscount = textPriceDiscount;
	}
	public int getItemBadgeCount() {
		return itemBadgeCount;
	}
	public void setItemBadgeCount(int itemBadgeCount) {
		this.itemBadgeCount = itemBadgeCount;
	}
}
