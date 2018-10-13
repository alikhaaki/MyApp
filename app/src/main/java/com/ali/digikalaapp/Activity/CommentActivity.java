package com.ali.digikalaapp.Activity;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ali.digikalaapp.R;
import com.sdsmdg.tastytoast.TastyToast;

import mehdi.sakout.fancybuttons.FancyButton;

public class CommentActivity extends AppCompatActivity {
	
	private FancyButton fancyButtonLike1;
	private FancyButton fancyButtonLike2;
	private FancyButton fancyButtonDisLike1;
	private FancyButton fancyButtonDislike2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comment_layout);
		
		fancyButtonLike1 = findViewById(R.id.button_like11);
		fancyButtonLike2 = findViewById(R.id.button_like22);
		fancyButtonDisLike1 = findViewById(R.id.button_dislike11);
		fancyButtonDislike2 = findViewById(R.id.button_dislike22);
		
		
		
		fancyButtonLike1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				TastyToast.makeText(CommentActivity.this, " نظر اول لایک شد", TastyToast.LENGTH_LONG  , TastyToast.SUCCESS);
				
			}
		});
		
		fancyButtonLike2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				TastyToast.makeText(CommentActivity.this, " نظر دوم لایک شد", TastyToast.LENGTH_LONG  , TastyToast.SUCCESS);
				
			}
		});
		fancyButtonDisLike1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				TastyToast.makeText(CommentActivity.this, " نظر اول دیسلایک شد", TastyToast.LENGTH_LONG  , TastyToast.CONFUSING);
				
			}
		});
		fancyButtonDislike2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				TastyToast.makeText(CommentActivity.this, "نظر دوم دیسلایک شد", TastyToast.LENGTH_LONG  , TastyToast.CONFUSING);
				
			}
		});
		View viewRank;
		
		viewRank = new View(this);
		viewRank = findViewById(R.id.view_row2_num4);
		viewRank.setBackground(ContextCompat.getDrawable(this, R.drawable.view_back_sixteen));
		
		viewRank = new View(this);
		viewRank = findViewById(R.id.view_row3_num5);
		viewRank.setBackgroundColor(ContextCompat.getColor(this, R.color.whiteView));
		
		viewRank = new View(this);
		viewRank = findViewById(R.id.view_row4_num3);
		viewRank.setBackground(ContextCompat.getDrawable(this, R.drawable.view_back_twenty));
		
		viewRank = new View(this);
		viewRank = findViewById(R.id.view_row5_num5);
		viewRank.setBackgroundColor(ContextCompat.getColor(this, R.color.whiteView));
		
		viewRank = new View(this);
		viewRank = findViewById(R.id.view_row4_num5);
		viewRank.setBackgroundColor(ContextCompat.getColor(this, R.color.whiteView));
		
		viewRank = new View(this);
		viewRank = findViewById(R.id.view_row4_num4);
		viewRank.setBackgroundColor(ContextCompat.getColor(this, R.color.whiteView));
		
		viewRank = new View(this);
		viewRank = findViewById(R.id.view_row2_num5);
		viewRank.setBackgroundColor(ContextCompat.getColor(this, R.color.whiteView));
		
	}
}
