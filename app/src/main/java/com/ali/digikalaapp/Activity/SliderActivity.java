package com.ali.digikalaapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.ali.digikalaapp.R;
import com.github.chrisbanes.photoview.PhotoView;

import static com.ali.digikalaapp.Activity.ProductListActivity.PRODUCT_ID_NAME;

public class SliderActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_slider);
		
		PhotoView photoView1=findViewById(R.id.photo_view_slider1);
		PhotoView photoView2=findViewById(R.id.photo_view_slider2);
		PhotoView photoView3=findViewById(R.id.photo_view_slider3);
		
		
		ImageView imageViewOne=findViewById(R.id.image_slide_one);
		ImageView imageViewTwo=findViewById(R.id.image_slide_two);
		ImageView imageViewThree=findViewById(R.id.image_slide_three);
		
		
		
		Intent intent = getIntent();
		int keyId = intent.getIntExtra(PRODUCT_ID_NAME, 0);
		
		switch (keyId) {
			case 701:
			imageViewOne.setImageResource(R.drawable.note_one_1);
			imageViewTwo.setImageResource(R.drawable.note_one_2);
			imageViewThree.setImageResource(R.drawable.note_one_3);
			
			photoView1.setImageResource(R.drawable.note_one_1);
			photoView2.setImageResource(R.drawable.note_one_2);
			photoView3.setImageResource(R.drawable.note_one_3);
			break;
		}
		
	}

	/*	list = new ArrayList<>();
		adapter = new AdapterSliderImage(this, list);
		
		recyclerView = findViewById(R.id.recycler_slider);
		
		ModelSlider model = new ModelSlider();
		
		model.setImage(R.drawable.ps41);
		list.add(model);
		
		model = new ModelSlider();
		model.setImage(R.drawable.ps42);
		list.add(model);
		
		list.add(new ModelSlider(R.drawable.ps43));
		list.add(new ModelSlider(R.drawable.ps44));
		list.add(new ModelSlider(R.drawable.ps45));
		
		recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
		recyclerView.setAdapter(adapter);
		
		Fragment_pager_one one = new Fragment_pager_one();
		FragmentManager fragment = getSupportFragmentManager();
		FragmentTransaction transaction = fragment.beginTransaction();
		transaction.replace(R.id.fragment_slider, one);
		transaction.commit();
		
		recyclerView.addOnItemTouchListener(new RecyclerViewItemClickListener(this, recyclerView, new RecyclerViewItemClickListener.OnItemClickListener() {
			
			@Override
			public void onItemClick(View view, int position) {
				
				switch (position) {
					case 0:
						Fragment one = new Fragment_pager_one();
						FragmentManager fragment = getSupportFragmentManager();
						FragmentTransaction transaction = fragment.beginTransaction();
						transaction.replace(R.id.fragment_slider, one);
						transaction.commit();
						break;
					case 1:
						one = new Fragment_pager_two();
						fragment = getSupportFragmentManager();
						transaction = fragment.beginTransaction();
						transaction.replace(R.id.fragment_slider, one);
						transaction.commit();
						break;
					case 2:
						one = new Fragment_Three();
						fragment = getSupportFragmentManager();
						transaction = fragment.beginTransaction();
						transaction.replace(R.id.fragment_slider, one);
						transaction.commit();
						break;
					case 3:
						one = new Fragment_Four();
						fragment = getSupportFragmentManager();
						transaction = fragment.beginTransaction();
						transaction.replace(R.id.fragment_slider, one);
						transaction.commit();
						break;
					case 4:
						one = new Fragment_Five();
						fragment = getSupportFragmentManager();
						transaction = fragment.beginTransaction();
						transaction.replace(R.id.fragment_slider, one);
						transaction.commit();
						break;
					
				}
				
			}
			@Override
			public void onItemLongClick(View view, int position) {
			
			}
		}));
		*/
	
}

