package com.ali.digikalaapp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ali.digikalaapp.R;

public class Fragment_pager_one extends Fragment {
	
	public Fragment_pager_one() {
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_pager_one, container, false);
	}
	
}
