package com.ali.digikalaapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ali.digikalaapp.R;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.transitionseverywhere.TransitionManager;

public class AboutActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_layout);
		
		Toolbar toolbar=findViewById(R.id.toolbar_about);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
 
		
		
		TextView textViewANdroid=findViewById(R.id.text_bottom_androidDev);
		TextView textViewName=findViewById(R.id.text_name_android);
		
		YoYo.with(Techniques.Pulse).duration(3000)
			.repeat(2)
			.playOn(textViewName);
		
		YoYo.with(Techniques.BounceInDown).duration(3000)
			.repeat(1)
			.playOn(textViewANdroid);
		 
		
		final RelativeLayout transContainer = findViewById(R.id.linearLayoutTrans);
		
		
		Button button_resume = findViewById(R.id.button_show_resume);
		final TextView textViewResume = findViewById(R.id.text_resume_show);
		
		button_resume.setOnClickListener(new View.OnClickListener() {
			
			boolean visible;
			@Override
			public void onClick(View v) {
				
				TransitionManager.beginDelayedTransition(transContainer);
				visible = !visible;
				textViewResume.setVisibility(visible ? View.VISIBLE : View.GONE);
				
				
			}
		});
	}
	
 
	
}
