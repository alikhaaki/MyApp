package com.ali.digikalaapp.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ali.digikalaapp.HelperClass.ImageLoaderSlider;
import com.ali.digikalaapp.HelperClass.UserSharedPreferences;
import com.ali.digikalaapp.Model.ModelHomeTools;
import com.ali.digikalaapp.R;

import at.blogc.android.views.ExpandableTextView;
import cn.iwgang.countdownview.CountdownView;
import static com.ali.digikalaapp.Activity.ProductListActivity.PRODUCT_ID_NAME;
import mehdi.sakout.fancybuttons.FancyButton;
import ss.com.bannerslider.Slider;
import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class ProductDetailActivity extends AppCompatActivity {
	
	private final String product_id = PRODUCT_ID_NAME;
	
	private ExpandableTextView expandableTextView;
	private Button buttonEdameText;
	private CountdownView timerCountProduct;
	private Slider slider;
	private View viewRank;
	private ImageView imageViewBasketItem;
	private FancyButton buttonAddToBasket;
	private ImageView imageBackButton;
	private FancyButton buttonProductSpecification;
	private FancyButton buttonProductComment;
	private TextView textHeadTitle;
	private TextView textSubTitle;
	private TextView textShegeft1;
	private TextView textShegeft2;
	private TextView textGaranty;
	private TextView textShopinSell;
	private TextView textSendToCustomer;
	private TextView textPriceOriginal;
	private TextView textPriceDiscount;
	private CountdownView countdownView;
	private Toolbar toolbarDetail;
	private int badgeCountItem;
	public  static int badgeItem=0;
	private TextView textCartItemCount;
	private UserSharedPreferences userSharedPreferences;
	private ModelHomeTools modelHomeTools;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_product_detail_activity);
		
		initExpandableText();
		initTimer();
		initRankBarProduct();
		initBasketItemView();
		findId();
		initToolbar();
		
		final Intent intent = getIntent();
		final int intentProductActivity = intent.getIntExtra(product_id, 0);
		
		userSharedPreferences = new UserSharedPreferences(this);
		modelHomeTools = new ModelHomeTools();
		modelHomeTools = userSharedPreferences.getBasketItem();
		
		//	textCartItemCount.setText(modelHomeTools.getItemBadgeCount());
		
		buttonAddToBasket = findViewById(R.id.button_add_to_basket);
		buttonAddToBasket.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				badgeCountItem = badgeCountItem + 1;
				
			}
		});
		
		switch (intentProductActivity) {
			
			case 70:
				notePaper1();
				
				break;
			case 71:
				
				getSupportActionBar().setTitle(getString(R.string.note_71_title));
				
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 3;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.note_five_3);
								break;
							case 1:
								imageSlideViewHolder.bindImageSlide(R.drawable.note_five_2);
								break;
							case 2:
								imageSlideViewHolder.bindImageSlide(R.drawable.note_five_1);
								break;
						}
						
					}
				});
				
				Slider.init(new ImageLoaderSlider(this));
				
				textHeadTitle.setText(getString(R.string.note_71_title));
				textSubTitle.setText(getString(R.string.note_71_sub_title));
				
				textGaranty.setText("گارانتی دفترچه یادداشت 2");
				textShopinSell.setText(" شاپینگ دفترچه 2");
				textSendToCustomer.setText(" ارسال در چند روز ");
				textPriceOriginal.setText(getString(R.string.note_71_original));
				
				slider.setSelectedSlide(2);
				break;
			case 90:
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 3;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.sorkhkon2);
								break;
							case 1:
								imageSlideViewHolder.bindImageSlide(R.drawable.sorkhkon1);
								break;
							case 2:
								imageSlideViewHolder.bindImageSlide(R.drawable.sorkhkon);
								break;
						}
						
					}
				});
				
				Slider.init(new ImageLoaderSlider(this));
				
				textHeadTitle.setText(getString(R.string.philips));
				textSubTitle.setText(R.string.philips_sub);
				
				getSupportActionBar().setTitle(getString(R.string.philips_sub));
				
				textGaranty.setText("گارانتی سرخ کن");
				textShopinSell.setText(" شاپینگ سرخ کن");
				textSendToCustomer.setText(" ارسال در 2 روز");
				textPriceOriginal.setText(getString(R.string.home_90_original));
				textPriceDiscount.setVisibility(View.VISIBLE);
				textPriceDiscount.setText(getString(R.string.home_90_discount));
				
				textShegeft1.setVisibility(View.VISIBLE);
				textShegeft2.setVisibility(View.VISIBLE);
				timerCountProduct.setVisibility(View.VISIBLE);
				
				slider.setSelectedSlide(2);
				break;
			case 91:
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 3;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.ojagh_2);
								break;
							case 1:
								imageSlideViewHolder.bindImageSlide(R.drawable.ojagh_1);
								break;
							case 2:
								imageSlideViewHolder.bindImageSlide(R.drawable.ojaghgaz);
								break;
						}
						
					}
				});
				
				Slider.init(new ImageLoaderSlider(this));
				
				textHeadTitle.setText(getString(R.string.hardston));
				textSubTitle.setText(R.string.hard_sub);
				
				getSupportActionBar().setTitle(getString(R.string.hard_sub));
				
				textGaranty.setText("گارانتی اجاق گاز");
				textShopinSell.setText(" شاپینگ  اجاق گاز");
				textSendToCustomer.setText(" ارسال در چند روز ");
				textPriceOriginal.setText(getString(R.string.home_91_original));
				textPriceDiscount.setVisibility(View.VISIBLE);
				textPriceDiscount.setText(getString(R.string.home_91_discount));
				
				textShegeft1.setVisibility(View.VISIBLE);
				textShegeft2.setVisibility(View.VISIBLE);
				timerCountProduct.setVisibility(View.VISIBLE);
				
				slider.setSelectedSlide(2);
				break;
			case 10:
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 1;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.clean_homcare);
								break;
							
						}
						
					}
				});
				
				Slider.init(new ImageLoaderSlider(this));
				
				textHeadTitle.setText(getString(R.string.clean_10_title));
				textSubTitle.setText(" ");
				
				getSupportActionBar().setTitle(getString(R.string.clean_10_title));
				
				textGaranty.setText(" ");
				textShopinSell.setText(" ");
				textSendToCustomer.setText(" ارسال در چند روز ");
				textPriceOriginal.setText(getString(R.string.clean_10_original));
				slider.setSelectedSlide(0);
				
				break;
			case 11:
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 1;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.clean_maye_litri);
								break;
							
						}
						
					}
				});
				
				Slider.init(new ImageLoaderSlider(this));
				
				textHeadTitle.setText(getString(R.string.clean_11_title));
				textSubTitle.setText(" ");
				
				getSupportActionBar().setTitle(getString(R.string.clean_11_title));
				
				textGaranty.setText(" ");
				textShopinSell.setText(" ");
				textSendToCustomer.setText(" ارسال در چند روز ");
				textPriceOriginal.setText(getString(R.string.clean_11_original));
				slider.setSelectedSlide(0);
				
				break;
			case 60:
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 3;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.moser_philips_2);
								break;
							case 1:
								imageSlideViewHolder.bindImageSlide(R.drawable.moser_philips_3);
								break;
							case 2:
								imageSlideViewHolder.bindImageSlide(R.drawable.moser_philips_4);
								break;
						}
						
					}
				});
				
				Slider.init(new ImageLoaderSlider(this));
				
				textHeadTitle.setText(getString(R.string.hair_60_title));
				textSubTitle.setText(" ");
				
				getSupportActionBar().setTitle(getString(R.string.hair_60_title));
				
				textGaranty.setText("گارانتی فیلیپس ");
				textShopinSell.setText("مانیا ");
				textSendToCustomer.setText(" ارسال در3 روز ");
				textPriceOriginal.setText(getString(R.string.hair_60_original));
				slider.setSelectedSlide(2);
				
				break;
			case 61:
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 3;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.moser_red_3);
								break;
							case 1:
								imageSlideViewHolder.bindImageSlide(R.drawable.moser_red_2);
								break;
							case 2:
								imageSlideViewHolder.bindImageSlide(R.drawable.moser_red_1);
								break;
						}
						
					}
				});
				
				Slider.init(new ImageLoaderSlider(this));
				
				textHeadTitle.setText(getString(R.string.hair_61_title));
				textSubTitle.setText(" ");
				
				getSupportActionBar().setTitle(getString(R.string.hair_61_title));
				
				textGaranty.setText("گارانتی موزر ");
				textShopinSell.setText("راد الکترونیک ");
				textSendToCustomer.setText(" ارسال 2 روز ");
				textPriceOriginal.setText(getString(R.string.hair_61_original));
				slider.setSelectedSlide(2);
				
				break;
			case 80:
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 3;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.nike_1);
								break;
							case 1:
								imageSlideViewHolder.bindImageSlide(R.drawable.nike_2);
								break;
							case 2:
								imageSlideViewHolder.bindImageSlide(R.drawable.nike_3);
								break;
						}
						
					}
				});
				
				Slider.init(new ImageLoaderSlider(this));
				
				textHeadTitle.setText(getString(R.string.sport_80_title));
				textSubTitle.setText(" ");
				
				getSupportActionBar().setTitle(getString(R.string.sport_80_title));
				
				textGaranty.setText("گارانتی نایک ");
				textShopinSell.setText("اسپرت ");
				textSendToCustomer.setText(" ارسال 2 روز ");
				textPriceOriginal.setText(getString(R.string.sport_80_original));
				textPriceDiscount.setVisibility(View.VISIBLE);
				textPriceDiscount.setText(getString(R.string.sport_80_discount));
				
				textShegeft1.setVisibility(View.VISIBLE);
				textShegeft2.setVisibility(View.VISIBLE);
				timerCountProduct.setVisibility(View.VISIBLE);
				slider.setSelectedSlide(2);
				
				break;
			case 81:
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 3;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.new_balance_3);
								break;
							case 1:
								imageSlideViewHolder.bindImageSlide(R.drawable.new_balance_4);
								break;
							case 2:
								imageSlideViewHolder.bindImageSlide(R.drawable.new_balance_2);
								break;
						}
						
					}
				});
				
				Slider.init(new ImageLoaderSlider(this));
				
				textHeadTitle.setText(getString(R.string.sport_81_title));
				textSubTitle.setText(" ");
				
				getSupportActionBar().setTitle(getString(R.string.sport_81_title));
				textGaranty.setText("گارانتی نیو بالانس ");
				textShopinSell.setText("اسپرت ");
				textSendToCustomer.setText(" ارسال 2 روز ");
				textPriceOriginal.setText(getString(R.string.sport_81_original));
				slider.setSelectedSlide(2);
				
				break;
			case 110:
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 3;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.toys_asbabbazi_6);
								break;
							case 1:
								imageSlideViewHolder.bindImageSlide(R.drawable.toys_asbabbazi_7);
								break;
							case 2:
								imageSlideViewHolder.bindImageSlide(R.drawable.toys_asbabbazi_8);
								break;
						}
						
					}
				});
				
				Slider.init(new ImageLoaderSlider(this));
				
				textHeadTitle.setText(getString(R.string.toys_110_title));
				textSubTitle.setText(" ");
				
				getSupportActionBar().setTitle(getString(R.string.toys_110_title));
				textGaranty.setText("گارانتی اسباب بازی ");
				textShopinSell.setText("اسباب بازی ");
				textSendToCustomer.setText(" ارسال 2 روز ");
				textPriceOriginal.setText(getString(R.string.toys_110_original));
				slider.setSelectedSlide(2);
				
				break;
			case 111:
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 3;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.toys_asbabbazi_11);
								break;
							case 1:
								imageSlideViewHolder.bindImageSlide(R.drawable.toys_asbabbazi_13);
								break;
							case 2:
								imageSlideViewHolder.bindImageSlide(R.drawable.toys_asbabbazi_9);
								break;
						}
						
					}
				});
				
				Slider.init(new ImageLoaderSlider(this));
				
				textHeadTitle.setText(getString(R.string.toys_111_title));
				textSubTitle.setText(" ");
				
				getSupportActionBar().setTitle(getString(R.string.toys_111_title));
				
				textGaranty.setText("گارانتی اسباب بازی ");
				textShopinSell.setText("اسباب بازی ");
				textSendToCustomer.setText(" ارسال 2 روز ");
				textPriceOriginal.setText(getString(R.string.toys_111_original));
				slider.setSelectedSlide(2);
				
				break;
			case 30:
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 3;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.tools_abzar_9);
								break;
							case 1:
								imageSlideViewHolder.bindImageSlide(R.drawable.tools_abzar_6);
								break;
							case 2:
								imageSlideViewHolder.bindImageSlide(R.drawable.tools_abzar_11);
								break;
						}
						
					}
				});
				
				Slider.init(new ImageLoaderSlider(this));
				
				textHeadTitle.setText(getString(R.string.tools_30_title));
				textSubTitle.setText(" ");
				
				getSupportActionBar().setTitle(getString(R.string.tools_30_title));
				textGaranty.setText("گارانتی ابزار   ");
				textShopinSell.setText("ابزار   ");
				textSendToCustomer.setText(" ارسال 2 روز ");
				textPriceOriginal.setText(getString(R.string.tools_30_original));
				slider.setSelectedSlide(2);
				
				break;
			case 31:
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 3;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.tools_abzar_3);
								break;
							case 1:
								imageSlideViewHolder.bindImageSlide(R.drawable.tools_abzar_2);
								break;
							case 2:
								imageSlideViewHolder.bindImageSlide(R.drawable.tools_abzar_4);
								break;
						}
						
					}
				});
				
				Slider.init(new ImageLoaderSlider(this));
				
				textHeadTitle.setText(getString(R.string.tools_31_title));
				textSubTitle.setText(" ");
				
				getSupportActionBar().setTitle(getString(R.string.tools_31_title));
				textGaranty.setText("گارانتی ابزار   ");
				textShopinSell.setText("ابزار   ");
				textSendToCustomer.setText(" ارسال 2 روز ");
				textPriceOriginal.setText(getString(R.string.tools_31_original));
				textPriceDiscount.setVisibility(View.VISIBLE);
				textPriceDiscount.setText(getString(R.string.tools_31_discount));
				
				textShegeft1.setVisibility(View.VISIBLE);
				textShegeft2.setVisibility(View.VISIBLE);
				timerCountProduct.setVisibility(View.VISIBLE);
				slider.setSelectedSlide(2);
				
				break;
			case 20:
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 3;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.gold0);
								break;
							case 1:
								imageSlideViewHolder.bindImageSlide(R.drawable.gold11);
								break;
							case 2:
								imageSlideViewHolder.bindImageSlide(R.drawable.gold0);
								break;
						}
						
					}
				});
				
				Slider.init(new ImageLoaderSlider(this));
				
				textHeadTitle.setText(getString(R.string.gold_20_title));
				textSubTitle.setText(" ");
				
				getSupportActionBar().setTitle(getString(R.string.gold_20_title));
				textGaranty.setText("گارانتی طلا   ");
				textShopinSell.setText("طلا   ");
				textSendToCustomer.setText(" ارسال 2 روز ");
				textPriceOriginal.setText(getString(R.string.gold_20_original));
				slider.setSelectedSlide(2);
				
				break;
			case 21:
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 3;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.gold10);
								break;
							case 1:
								imageSlideViewHolder.bindImageSlide(R.drawable.gold9);
								break;
							case 2:
								imageSlideViewHolder.bindImageSlide(R.drawable.gold1);
								break;
						}
						
					}
				});
				
				Slider.init(new ImageLoaderSlider(this));
				
				textHeadTitle.setText(getString(R.string.gold_21_title));
				textSubTitle.setText(" ");
				getSupportActionBar().setTitle(getString(R.string.gold_21_title));
				textGaranty.setText("گارانتی طلا   ");
				textShopinSell.setText("طلا   ");
				textSendToCustomer.setText(" ارسال 2 روز ");
				textPriceOriginal.setText(getString(R.string.gold_21_original));
				slider.setSelectedSlide(2);
				
				break;
			case 50:
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 4;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.iphone11);
								break;
							case 1:
								imageSlideViewHolder.bindImageSlide(R.drawable.iphone4);
								break;
							case 2:
								imageSlideViewHolder.bindImageSlide(R.drawable.iphone8);
								break;
							case 3:
								imageSlideViewHolder.bindImageSlide(R.drawable.iphone3);
								break;
						}
						
					}
				});
				
				Slider.init(new ImageLoaderSlider(this));
				
				textHeadTitle.setText(getString(R.string.mobile_50_title));
				textSubTitle.setText(getString(R.string.mobile_50_sub));
				getSupportActionBar().setTitle(getString(R.string.mobile_50_title));
				textGaranty.setText("گارانتی راد سیستم");
				textShopinSell.setText("فروش توسط راد سیستم ");
				textSendToCustomer.setText(" ارسال در 2 روز ");
				textPriceOriginal.setText(getString(R.string.mobile_50_original));
				textPriceDiscount.setVisibility(View.VISIBLE);
				textPriceDiscount.setText(getString(R.string.mobile_50_discount));
				
				textShegeft1.setVisibility(View.VISIBLE);
				textShegeft2.setVisibility(View.VISIBLE);
				timerCountProduct.setVisibility(View.VISIBLE);
				slider.setSelectedSlide(3);
				
				break;
			case 51:
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 4;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.iphone14);
								break;
							case 1:
								imageSlideViewHolder.bindImageSlide(R.drawable.iphone18);
								break;
							case 2:
								imageSlideViewHolder.bindImageSlide(R.drawable.iphone17);
								break;
							case 3:
								imageSlideViewHolder.bindImageSlide(R.drawable.iphone16);
								break;
						}
						
					}
				});
				
				Slider.init(new ImageLoaderSlider(this));
				
				textHeadTitle.setText(getString(R.string.mobile_51_title));
				textSubTitle.setText(getString(R.string.mobile_51_sub));
				
				getSupportActionBar().setTitle(getString(R.string.mobile_51_title));
				textGaranty.setText("گارانتی مدیا پردازش");
				textShopinSell.setText("فروش توسط مدیا پردازش ");
				textSendToCustomer.setText(" ارسال در 2 روز ");
				textPriceOriginal.setText(getString(R.string.mobile_51_original));
				textPriceDiscount.setVisibility(View.VISIBLE);
				textPriceDiscount.setText(getString(R.string.mobile_51_discount));
				
				textShegeft1.setVisibility(View.VISIBLE);
				textShegeft2.setVisibility(View.VISIBLE);
				timerCountProduct.setVisibility(View.VISIBLE);
				slider.setSelectedSlide(3);
				
				break;
			case 40:
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 3;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.khoshkbar_peste0);
								break;
							case 1:
								imageSlideViewHolder.bindImageSlide(R.drawable.khoshkbar_peste1);
								break;
							case 2:
								imageSlideViewHolder.bindImageSlide(R.drawable.khoshkbar_peste0);
								break;
							
						}
						
					}
				});
				
				Slider.init(new ImageLoaderSlider(this));
				
				textHeadTitle.setText(getString(R.string.fruit_40_title));
				textSubTitle.setText(" ");
				getSupportActionBar().setTitle(getString(R.string.fruit_40_title));
				textGaranty.setText("     ");
				textShopinSell.setText("    ");
				textSendToCustomer.setText(" ارسال 2 روز ");
				textPriceOriginal.setText(getString(R.string.fruit_40_original));
				slider.setSelectedSlide(2);
				
				break;
			case 41:
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 3;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.khoshkbar_aloo2);
								break;
							case 1:
								imageSlideViewHolder.bindImageSlide(R.drawable.khoshkbar_aloo1);
								break;
							case 2:
								imageSlideViewHolder.bindImageSlide(R.drawable.khoshkbar_aloo0);
								break;
							
						}
						
					}
				});
				
				Slider.init(new ImageLoaderSlider(this));
				
				textHeadTitle.setText(getString(R.string.fruit_41_title));
				textSubTitle.setText(getString(R.string.fruit_41_sub));
				getSupportActionBar().setTitle(getString(R.string.fruit_41_title));
				textGaranty.setText("     ");
				textShopinSell.setText("    ");
				textSendToCustomer.setText(" ارسال 2 روز ");
				textPriceOriginal.setText(getString(R.string.fruit_41_original));
				slider.setSelectedSlide(2);
				
				break;
			
			case 990:
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 3;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.note_one_3);
								break;
							case 1:
								imageSlideViewHolder.bindImageSlide(R.drawable.note_one_2);
								break;
							case 2:
								imageSlideViewHolder.bindImageSlide(R.drawable.note_one_1);
								break;
						}
						
					}
				});
				
				Slider.init(new ImageLoaderSlider(this));
				
				textHeadTitle.setText(getString(R.string.note_70_title));
				textSubTitle.setText(getString(R.string.note_70_sub_title));
				getSupportActionBar().setTitle(getString(R.string.note_70_title));
				textShegeft1.setVisibility(View.VISIBLE);
				textShegeft2.setVisibility(View.VISIBLE);
				
				countdownView.setVisibility(View.VISIBLE);
				
				textGaranty.setText("گارانتی دفترچه یادداشت 1");
				textShopinSell.setText(" شاپینگ دفترچه 1");
				textSendToCustomer.setText(" ارسال در یک روز");
				textPriceDiscount.setText(getString(R.string.note_70_original));
				textPriceOriginal.setText(getString(R.string.note_70_discount));
				textPriceDiscount.setVisibility(View.VISIBLE);
				slider.setSelectedSlide(2);
				
				break;
			
			case 991:
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 4;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.iphone14);
								break;
							case 1:
								imageSlideViewHolder.bindImageSlide(R.drawable.iphone18);
								break;
							case 2:
								imageSlideViewHolder.bindImageSlide(R.drawable.iphone17);
								break;
							case 3:
								imageSlideViewHolder.bindImageSlide(R.drawable.iphone16);
								break;
						}
						
					}
				});
				
				Slider.init(new ImageLoaderSlider(this));
				
				textHeadTitle.setText(getString(R.string.mobile_51_title));
				textSubTitle.setText(" ");
				getSupportActionBar().setTitle(getString(R.string.mobile_51_title));
				textGaranty.setText("گارانتی    ");
				textShopinSell.setText("ایفون   ");
				textSendToCustomer.setText(" ارسال 2 روز ");
				textPriceOriginal.setText(getString(R.string.mobile_51_original));
				textPriceDiscount.setVisibility(View.VISIBLE);
				textPriceDiscount.setText(getString(R.string.mobile_51_discount));
				
				textShegeft1.setVisibility(View.VISIBLE);
				textShegeft2.setVisibility(View.VISIBLE);
				timerCountProduct.setVisibility(View.VISIBLE);
				slider.setSelectedSlide(3);
				
				break;
			case 980:
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 4;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.iphone14);
								break;
							case 1:
								imageSlideViewHolder.bindImageSlide(R.drawable.iphone18);
								break;
							case 2:
								imageSlideViewHolder.bindImageSlide(R.drawable.iphone17);
								break;
							case 3:
								imageSlideViewHolder.bindImageSlide(R.drawable.iphone16);
								break;
						}
						
					}
				});
				Slider.init(new ImageLoaderSlider(this));
				textHeadTitle.setText(getString(R.string.mobile_51_title));
				getSupportActionBar().setTitle(getString(R.string.mobile_51_title));
				textSubTitle.setText(" ");
				textGaranty.setText("گارانتی    ");
				textShopinSell.setText("ایفون   ");
				textSendToCustomer.setText(" ارسال 2 روز ");
				textPriceOriginal.setText(getString(R.string.mobile_51_original));
				textPriceDiscount.setVisibility(View.VISIBLE);
				textPriceDiscount.setText(getString(R.string.mobile_51_discount));
				textShegeft1.setVisibility(View.VISIBLE);
				textShegeft2.setVisibility(View.VISIBLE);
				timerCountProduct.setVisibility(View.VISIBLE);
				slider.setSelectedSlide(3);
				
				break;
			case 981:
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 4;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.lg21);
								break;
							case 1:
								imageSlideViewHolder.bindImageSlide(R.drawable.lg20);
								break;
							case 2:
								imageSlideViewHolder.bindImageSlide(R.drawable.lg19);
								break;
							case 3:
								imageSlideViewHolder.bindImageSlide(R.drawable.lg18);
								break;
						}
						
					}
				});
				Slider.init(new ImageLoaderSlider(this));
				textHeadTitle.setText(getString(R.string.vije_981_title));
				textSubTitle.setText(" ");
				getSupportActionBar().setTitle(getString(R.string.vije_981_title));
				textGaranty.setText("گارانتی LG   ");
				textShopinSell.setText("LG   ");
				textSendToCustomer.setText(" ارسال 2 روز ");
				textPriceOriginal.setText(getString(R.string.vije_981_original));
				textPriceDiscount.setVisibility(View.VISIBLE);
				textPriceDiscount.setText(getString(R.string.vije_981_discount));
				textShegeft1.setVisibility(View.VISIBLE);
				textShegeft2.setVisibility(View.VISIBLE);
				timerCountProduct.setVisibility(View.VISIBLE);
				slider.setSelectedSlide(3);
				
				break;
			case 970:
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 3;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.khoshkbar_peste0);
								break;
							case 1:
								imageSlideViewHolder.bindImageSlide(R.drawable.khoshkbar_peste1);
								break;
							case 2:
								imageSlideViewHolder.bindImageSlide(R.drawable.khoshkbar_peste0);
								break;
							
						}
						
					}
				});
				Slider.init(new ImageLoaderSlider(this));
				textHeadTitle.setText(getString(R.string.fruit_40_title));
				textSubTitle.setText(" ");
				getSupportActionBar().setTitle(getString(R.string.fruit_40_title));
				textGaranty.setText("     ");
				textShopinSell.setText("    ");
				textSendToCustomer.setText(" ارسال 2 روز ");
				textPriceOriginal.setText(getString(R.string.fruit_40_original));
				slider.setSelectedSlide(2);
				
				break;
			case 971:
				
				slider.setAdapter(new SliderAdapter() {
					
					@Override
					public int getItemCount() {
						return 3;
					}
					@Override
					public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
						switch (position) {
							
							case 0:
								imageSlideViewHolder.bindImageSlide(R.drawable.khoshkbar_aloo2);
								break;
							case 1:
								imageSlideViewHolder.bindImageSlide(R.drawable.khoshkbar_aloo1);
								break;
							case 2:
								imageSlideViewHolder.bindImageSlide(R.drawable.khoshkbar_aloo0);
								break;
							
						}
						
					}
				});
				Slider.init(new ImageLoaderSlider(this));
				textHeadTitle.setText(getString(R.string.fruit_41_title));
				textSubTitle.setText(getString(R.string.fruit_41_sub));
				getSupportActionBar().setTitle(getString(R.string.fruit_41_title));
				textGaranty.setText("     ");
				textShopinSell.setText("    ");
				textSendToCustomer.setText(" ارسال 2 روز ");
				textPriceOriginal.setText(getString(R.string.fruit_41_original));
				slider.setSelectedSlide(2);
				
				break;
			
		}
		
		buttonProductComment.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				startActivity(new Intent(ProductDetailActivity.this, CommentActivity.class));
				
			}
		});
		buttonProductSpecification.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(ProductDetailActivity.this, SpecificationActivity.class));
				
			}
		});
		
		clickBasket();
	}
	private void initToolbar() {
		toolbarDetail = findViewById(R.id.toolbar_product_detail_activity);
		setSupportActionBar(toolbarDetail);
		toolbarDetail.setTitleTextColor(ContextCompat.getColor(this, R.color.WhiteColor));
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);
	}
	private void findId() {
		slider = findViewById(R.id.sliderProductViewList);
		textHeadTitle = findViewById(R.id.text_title_list);
		textSubTitle = findViewById(R.id.text_sub_title_list);
		textShegeft1 = findViewById(R.id.text_propose_pishnahad_list);
		textShegeft2 = findViewById(R.id.text_propose_shegeft_list);
		textGaranty = findViewById(R.id.text_detail_garanty_list);
		textShopinSell = findViewById(R.id.text_detail_shoper_list);
		textSendToCustomer = findViewById(R.id.text_detail_sending_list);
		textPriceOriginal = findViewById(R.id.text_price_original_list);
		textPriceDiscount = findViewById(R.id.text_price_discount_list);
		expandableTextView = findViewById(R.id.expandable_text_list);
		countdownView = findViewById(R.id.timer_pishnahad_list);
		buttonProductComment = findViewById(R.id.button_Comment_item);
		buttonProductSpecification = findViewById(R.id.button_specification_layout);
	}
	private void notePaper1() {
		
		
		slider.setAdapter(new SliderAdapter() {
			
			@Override
			public int getItemCount() {
				return 3;
			}
			@Override
			public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
				switch (position) {
					case 0:
						imageSlideViewHolder.bindImageSlide(R.drawable.note_one_3);
						break;
					case 1:
						imageSlideViewHolder.bindImageSlide(R.drawable.note_one_2);
						break;
					case 2:
						imageSlideViewHolder.bindImageSlide(R.drawable.note_one_1);
						break;
				}
				
			}
		});
		
		Slider.init(new ImageLoaderSlider(this));
		
		getSupportActionBar().setTitle(getString(R.string.note_70_title));
		textHeadTitle.setText(getString(R.string.note_70_title));
		textSubTitle.setText(getString(R.string.note_70_sub_title));
		
		textShegeft1.setVisibility(View.VISIBLE);
		textShegeft2.setVisibility(View.VISIBLE);
		
		countdownView.setVisibility(View.VISIBLE);
		
		textGaranty.setText("گارانتی دفترچه یادداشت 1");
		textShopinSell.setText(" شاپینگ دفترچه 1");
		textSendToCustomer.setText(" ارسال در یک روز");
		textPriceDiscount.setText(getString(R.string.note_70_original));
		textPriceOriginal.setText(getString(R.string.note_70_discount));
		textPriceDiscount.setVisibility(View.VISIBLE);
		
		slider.setSelectedSlide(2);
	}
	private void initBasketItemView() {
		imageViewBasketItem = findViewById(R.id.image_basket_icon_button);

//		buttonAddToBasket = findViewById(R.id.button_add_to_basket);
//
//		final QBadgeView qBadgeView = new QBadgeView(this);
//		qBadgeView.bindTarget(imageViewBasketItem)
//			.setBadgeBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent))
//			.setGravityOffset(-1, -5, true);
//
//
//		buttonAddToBasket.setOnClickListener(new View.OnClickListener() {
//
//			int i = 0;
//			@Override
//			public void onClick(View v) {
//				qBadgeView.bindTarget(imageViewBasketItem).setBadgeNumber(i = i + 1);
//
//			}
//		});
		
	}
	private void initRankBarProduct() {
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
	private void initTimer() {
		
		timerCountProduct = findViewById(R.id.timer_pishnahad_list);
		timerCountProduct.start(1400000);
	}
	private void initExpandableText() {
		expandableTextView = findViewById(R.id.expandable_text_list);
		buttonEdameText = findViewById(R.id.button_edame_matlab_list);
		Typeface font = Typeface.createFromAsset(ProductDetailActivity.this.getAssets(), "iransansmobile.ttf");
		expandableTextView.setTypeface(font);
		
		expandableTextView.setAnimationDuration(650L);
		expandableTextView.setInterpolator(new OvershootInterpolator());
		
		buttonEdameText.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				buttonEdameText.setText(expandableTextView.isExpanded() ? "ادامه مطلب" : "بستن ");
				expandableTextView.toggle();
			}
		});
	}
	private void clickBasket() {
		buttonAddToBasket.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				
				
				
				Intent intent = new Intent(ProductDetailActivity.this, BasketActivity.class);
 
 
				startActivity(intent);
				
 
				
				
			
				
			}
		});
	}
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.basket_menu_item, menu);
		
		final MenuItem menuItem = menu.findItem(R.id.action_cart);
		
		View actionView = menuItem.getActionView();
		
		textCartItemCount = actionView.findViewById(R.id.cart_badge);

//		textCartItemCount.setText(String.valueOf(0));
		actionView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				onOptionsItemSelected(menuItem);
				Toast.makeText(ProductDetailActivity.this, "سبد خرید ", Toast.LENGTH_SHORT).show();
			}
		});
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		switch (id) {
			case android.R.id.home:
				finish();
				break;
		}
		return super.onOptionsItemSelected(item);
	}
	private void setUpBadge() {

//		if (textCartItemCount != null) {
//
//			if (badgeCountItem == 0) {
//				if (textCartItemCount.getVisibility() != View.GONE) {
//					textCartItemCount.setVisibility(View.GONE);
//				}
//			} else {
//				textCartItemCount.setText(String.valueOf( badgeCountItem));
//				if (textCartItemCount.getVisibility() != View.VISIBLE) {
//					textCartItemCount.setVisibility(View.VISIBLE);
//				}
//			}
//		}
//
//	}
	}
}
