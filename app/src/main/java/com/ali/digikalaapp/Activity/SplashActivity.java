package com.ali.digikalaapp.Activity;

import android.content.Intent;

import com.ali.digikalaapp.R;
import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class SplashActivity extends AwesomeSplash {
	
	@Override
	public void initSplash(ConfigSplash configSplash) {
		
		configSplash.setBackgroundColor(R.color.colorPrimary);
		configSplash.setAnimCircularRevealDuration(1500);
		configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);
		configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM);
		
		configSplash.setLogoSplash(R.drawable.digisplasssssh);
		configSplash.setAnimLogoSplashDuration(1500);
		configSplash.setAnimLogoSplashTechnique(Techniques.Wobble);
		
		  //set path String
		configSplash.setOriginalHeight(400); //in relation to your svg (path) resource
		configSplash.setOriginalWidth(400); //in relation to your svg (path) resource
		configSplash.setAnimPathStrokeDrawingDuration(3000);
		configSplash.setPathSplashStrokeSize(3); //I advise value be <5
		configSplash.setPathSplashStrokeColor(R.color.colorAccent); //any color you want form colors.xml
		configSplash.setAnimPathFillingDuration(3000);
		configSplash.setPathSplashFillColor(R.color.GreyButton);
		
		configSplash.setTitleSplash("خرید و انتخاب آسان");
		configSplash.setTitleTextColor( R.color.WhiteColor);
		configSplash.setTitleTextSize(25f); //float value
		configSplash.setAnimTitleDuration(3000);
		configSplash.setAnimTitleTechnique(Techniques.FlipInX);
		
	}
	@Override
	public void animationsFinished() {
		
		Intent intent=new Intent(SplashActivity.this,DigiActivity.class);
		startActivity(intent);
		finish();
	}
}
