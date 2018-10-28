package com.ali.digikalaapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ali.digikalaapp.R;

import static com.ali.digikalaapp.Activity.ProductDetailActivity.badgeItem;

public class BasketActivity extends AppCompatActivity {
	
	 private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_basket);
		
//		 textView=findViewById(R.id.text_some_text);
		
 
//		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
//
//		int innnn=sp.getInt("my_key",0);
//
//		textView.setText(String.valueOf(innnn));
		
	
		
	}
}
