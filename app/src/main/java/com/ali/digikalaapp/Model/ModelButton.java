package com.ali.digikalaapp.Model;

public class ModelButton {
	
	private String textButton;
	private  int imgBut;
	public ModelButton(){
	
	}
	public ModelButton(int imgBut) {
		this.imgBut = imgBut;
	}
	
	public String getTextButton() {
		return textButton;
	}
	public void setTextButton(String textButton) {
		this.textButton = textButton;
	}
	public int getImgBut() {
		return imgBut;
	}
	public void setImgBut(int imgBut) {
		this.imgBut = imgBut;
	}
}
