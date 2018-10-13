package com.ali.digikalaapp.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ali.digikalaapp.Fragment.Fragment_Category_Beauty;
import com.ali.digikalaapp.Fragment.Fragment_Category_Home;
import com.ali.digikalaapp.Fragment.Fragment_Category_Toys;
import com.ali.digikalaapp.Fragment.Fragment_Category_Digital;
import com.ali.digikalaapp.Fragment.Fragment_Category_Clothes;

public class AdapterViewPagerCategory extends FragmentPagerAdapter {
	
	public AdapterViewPagerCategory(FragmentManager fm) {
		super(fm);
	}
	@Override
	public Fragment getItem(int position) {
		switch (position) {
			case 0:
				return Fragment_Category_Digital.newInstance();
			case 1:
				return Fragment_Category_Home.newInstance();
			case 2:
				return Fragment_Category_Clothes.newInstance();
			case 3:
				return Fragment_Category_Beauty.newInstance();
			case 4:
				return Fragment_Category_Toys.newInstance();
			default:
				return Fragment_Category_Digital.newInstance();
		}
		
	}
	@Override
	public int getCount() {
		
		return 5;
	}
	
	
	@Nullable
	@Override
	public CharSequence getPageTitle(int position) {
		switch (position) {
			case 0:
				return "دیجیتال";
			case 1:
				return "لوازم خانه";
			case 2:
				return "مد و پوشاک";
			case 3:
				return "ابزار و وسایل برقی";
			case 4:
				return "اسباب بازی و وسایل کودکان";
			default:
				return "";
			
		}
		
	}
}
