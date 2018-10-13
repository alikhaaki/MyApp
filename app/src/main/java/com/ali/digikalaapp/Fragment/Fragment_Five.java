package com.ali.digikalaapp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ali.digikalaapp.R;

public class Fragment_Five extends Fragment {
	
	public Fragment_Five() {
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_five, container, false);
		
	}
	
	public static Fragment_Five newInstance() {
		
		Bundle args = new Bundle();
		
		Fragment_Five fragment = new Fragment_Five();
		fragment.setArguments(args);
		return fragment;
	}
}
