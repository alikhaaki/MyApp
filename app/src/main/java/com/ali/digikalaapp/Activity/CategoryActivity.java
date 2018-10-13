package com.ali.digikalaapp.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ali.digikalaapp.Adapter.AdapterViewPagerCategory;
import com.ali.digikalaapp.R;

public class CategoryActivity extends AppCompatActivity {
	
	private ViewPager viewPager;
	private AdapterViewPagerCategory adapterViewpager;
	private TabLayout tabLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_category);
		
		tabLayout = findViewById(R.id.tab_layout);
		viewPager = findViewById(R.id.view_pager);
		
		adapterViewpager = new AdapterViewPagerCategory(getSupportFragmentManager());
		
		viewPager.setAdapter(adapterViewpager);
		tabLayout.setupWithViewPager(viewPager);
		
	}
}
