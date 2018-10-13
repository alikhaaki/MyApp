package com.ali.digikalaapp.HelperClass;

import android.content.Context;
import android.content.SharedPreferences;

import com.ali.digikalaapp.Model.ModelHomeTools;

public class UserSharedPreferences {
	
	private static final String USER_SHARED_PREF_NAME = "user_shared_pref";
	private SharedPreferences shared;
	
	public static final String TITLE_HOME ="title_home";
	public static final String PRICE_ORIGINAL ="price_home";
	
	public UserSharedPreferences(Context context) {
		shared = context.getSharedPreferences(USER_SHARED_PREF_NAME, Context.MODE_PRIVATE);
	}
	
	public  void saveBasketItem(ModelHomeTools modelHomeTools){
		if (modelHomeTools!=null){
			SharedPreferences.Editor editor=shared.edit();
			
			editor.putInt(TITLE_HOME, modelHomeTools.getItemBadgeCount());
		 
			editor.apply();
			
		}
	}
	
	
	public ModelHomeTools getBasketItem(){
		ModelHomeTools modelHomeTools =new ModelHomeTools();
		modelHomeTools.setItemBadgeCount(shared.getInt(TITLE_HOME,  0));
	 
		return modelHomeTools;
		
	}
	
	public String  UserLogniInfo(){
		return shared.getString("email", "");
	}
	public void UserInfoSave(String email) {
		SharedPreferences.Editor editor = shared.edit();
		editor.putString("email", email);
		editor.commit();
	}
	
}
