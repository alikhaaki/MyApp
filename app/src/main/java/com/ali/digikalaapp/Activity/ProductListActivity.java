package com.ali.digikalaapp.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ali.digikalaapp.Adapter.AdapterHomeSuggestList;
import com.ali.digikalaapp.HelperClass.RecyclerViewItemClickListener;
import com.ali.digikalaapp.Model.ModelHomeTools;
import com.ali.digikalaapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

public class ProductListActivity extends AppCompatActivity {
	
	public static final String PRODUCT_ID_NAME = "PR_ID_NAME";
	private final String KEY_STRING = DigiActivity.KEY_NAME;
	private boolean gridView = false;
	
	private final int cleaner = DigiActivity.CLEANER;
	private final int babyToys = DigiActivity.BABY_TOYS;
	private final int driedFruit = DigiActivity.DRIED_FRUIT;
	private final int gold = DigiActivity.GOLD;
	private final int hairCutter = DigiActivity.HAIR_CUTTER;
	private final int homeAppliance = DigiActivity.HOME_APPLIANCE;
	private final int mobile = DigiActivity.MOBILE;
	private final int notePaper = DigiActivity.NOTE_PAPER;
	private final int SPORT = DigiActivity.SPORT;
	private final int tools = DigiActivity.TOOLS;
	
	private ImageView imageChangeList;
	private RecyclerView recyclerViewTools;
	private AdapterHomeSuggestList adapterHomeSuggestList;
	private ModelHomeTools modelHomeTools;
	private List<ModelHomeTools> listTools;
	private TextView textViewFilterOne;
	private Toolbar toolbarTools;
	private RelativeLayout relativeLayout;
	private TextView textCartItemCount;
	private int selected;
	private int mCartItemCount = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_product_list_activity);
		
		final Intent intentOne = getIntent();
		final int idName = intentOne.getIntExtra(KEY_STRING, 0);
		
		setToolbar();
		alertDialogBox();
		changeItemList();
		initRecyclerView();
		
		Collections.sort(listTools, new Comparator<ModelHomeTools>() {
			
			@Override
			public int compare(ModelHomeTools o1, ModelHomeTools o2) {
				return o1.getTextTitle().compareTo(o2.getTextTitle());
			}
		});
		
		
		switch (idName) {
			
			case 99:
				setMostBuyList();
				getSupportActionBar().setTitle("پرفروشترین ها");
				break;
			
			case 98:
				setMostViewvedList();
				getSupportActionBar().setTitle("پربازدیدترین ها");
				break;
			
			case 97:
				setNewestItemList();
				getSupportActionBar().setTitle("جدیدترین ها");
				break;
			
			case driedFruit:
				setDriedFruit();
				getSupportActionBar().setTitle("خشکبار");
				break;
			
			case homeAppliance:
				setHomeApplianceList();
				getSupportActionBar().setTitle("لوازم خانگی");
				break;
			
			case notePaper:
				setPaperList();
				getSupportActionBar().setTitle("دفترچه یادداشت");
				break;
			
			case mobile:
				setMobileList();
				getSupportActionBar().setTitle("موبایل");
				break;
			
			case gold:
				setGoldList();
				getSupportActionBar().setTitle("طلا");
				break;
			
			case cleaner:
				setCleanerList();
				getSupportActionBar().setTitle("مواد شوینده ");
				break;
			
			case hairCutter:
				setHairCutterList();
				getSupportActionBar().setTitle("ماشین اصلاح");
				break;
			
			case tools:
				setToolsList();
				getSupportActionBar().setTitle("ابزار");
				break;
			
			case SPORT:
				setSportList();
				getSupportActionBar().setTitle("کفش ورزشی");
				break;
			
			case babyToys:
				setToysList();
				getSupportActionBar().setTitle("اسباب بازی");
				break;
			
		}
		
		
		
		recyclerViewTools.addOnItemTouchListener(new RecyclerViewItemClickListener(this, recyclerViewTools, new RecyclerViewItemClickListener.OnItemClickListener() {
			
			
			
			@Override
			public void onItemClick(View view, int position) {
				Intent intentDetail = new Intent(ProductListActivity.this, ProductDetailActivity.class);
				
				/*
				
				CLEANER            1
				GOLD               2
				TOOLS              3
				DRIED_FRUIT        4
				MOBILE             5
				HAIR_CUTTER        6
				NOTE_PAPER         7
				SPORT              8
				HOME_APPLIANCE     9
				BABY_TOYS          11
				
				*/
				
				int pos = position + 1;
				switch (position) {
					
					case 0:
						
						switch (idName) {
							case notePaper:
								intentDetail.putExtra(PRODUCT_ID_NAME, 70);
								startActivity(intentDetail);
								break;
							case cleaner:
								
								intentDetail.putExtra(PRODUCT_ID_NAME, 10);
								startActivity(intentDetail);
								break;
							case babyToys:
								
								intentDetail.putExtra(PRODUCT_ID_NAME, 110);
								startActivity(intentDetail);
								break;
							case mobile:
								
								intentDetail.putExtra(PRODUCT_ID_NAME, 50);
								startActivity(intentDetail);
								break;
							case tools:
								
								intentDetail.putExtra(PRODUCT_ID_NAME, 30);
								startActivity(intentDetail);
								break;
							case SPORT:
								
								intentDetail.putExtra(PRODUCT_ID_NAME, 80);
								startActivity(intentDetail);
								break;
							case hairCutter:
								
								intentDetail.putExtra(PRODUCT_ID_NAME, 60);
								startActivity(intentDetail);
								break;
							case driedFruit:
								
								intentDetail.putExtra(PRODUCT_ID_NAME, 40);
								startActivity(intentDetail);
								break;
							case gold:
								
								intentDetail.putExtra(PRODUCT_ID_NAME, 20);
								startActivity(intentDetail);
								break;
							case homeAppliance:
								
								intentDetail.putExtra(PRODUCT_ID_NAME, 90);
								startActivity(intentDetail);
								break;
							case 99:
								
								intentDetail.putExtra(PRODUCT_ID_NAME, 990);
								startActivity(intentDetail);
								break;
							case 98:
								
								intentDetail.putExtra(PRODUCT_ID_NAME, 980);
								startActivity(intentDetail);
								break;
							case 97:
								
								intentDetail.putExtra(PRODUCT_ID_NAME, 970);
								startActivity(intentDetail);
								break;
						}
						break;
					case 1:
						switch (idName) {
							case 97:
								
								intentDetail.putExtra(PRODUCT_ID_NAME, 971);
								startActivity(intentDetail);
								break;
							
							case 98:
								
								intentDetail.putExtra(PRODUCT_ID_NAME, 981);
								startActivity(intentDetail);
								break;
							
							case 99:
								
								intentDetail.putExtra(PRODUCT_ID_NAME, 991);
								startActivity(intentDetail);
								break;
							
							case notePaper:
								intentDetail.putExtra(PRODUCT_ID_NAME, 71);
								startActivity(intentDetail);
								break;
							case cleaner:
								
								intentDetail.putExtra(PRODUCT_ID_NAME, 11);
								startActivity(intentDetail);
								break;
							case babyToys:
								
								intentDetail.putExtra(PRODUCT_ID_NAME, 111);
								startActivity(intentDetail);
								break;
							case mobile:
								
								intentDetail.putExtra(PRODUCT_ID_NAME, 51);
								startActivity(intentDetail);
								break;
							case tools:
								
								intentDetail.putExtra(PRODUCT_ID_NAME, 31);
								startActivity(intentDetail);
								break;
							case SPORT:
								
								intentDetail.putExtra(PRODUCT_ID_NAME, 81);
								startActivity(intentDetail);
								break;
							case hairCutter:
								
								intentDetail.putExtra(PRODUCT_ID_NAME, 61);
								startActivity(intentDetail);
								break;
							case driedFruit:
								
								intentDetail.putExtra(PRODUCT_ID_NAME, 41);
								startActivity(intentDetail);
								break;
							case gold:
								
								intentDetail.putExtra(PRODUCT_ID_NAME, 21);
								startActivity(intentDetail);
								break;
							case homeAppliance:
								
								intentDetail.putExtra(PRODUCT_ID_NAME, 91);
								startActivity(intentDetail);
								break;
							
						}
						break;
					case 2:
						
						Toast.makeText(ProductListActivity.this, " آیتم " + pos + " کلیک شد ", Toast.LENGTH_SHORT).show();
						break;
					case 3:
						Toast.makeText(ProductListActivity.this, " آیتم " + pos + " کلیک شد ", Toast.LENGTH_SHORT).show();
						break;
					case 4:
						Toast.makeText(ProductListActivity.this, " آیتم " + pos + " کلیک شد ", Toast.LENGTH_SHORT).show();
						break;
					case 5:
						Toast.makeText(ProductListActivity.this, " آیتم " + pos + " کلیک شد ", Toast.LENGTH_SHORT).show();
						break;
					case 6:
						Toast.makeText(ProductListActivity.this, " آیتم " + pos + " کلیک شد ", Toast.LENGTH_SHORT).show();
						break;
					case 7:
						Toast.makeText(ProductListActivity.this, " آیتم " + pos + " کلیک شد ", Toast.LENGTH_SHORT).show();
						break;
					case 8:
						Toast.makeText(ProductListActivity.this, " آیتم " + pos + " کلیک شد ", Toast.LENGTH_SHORT).show();
						break;
				}
				
			}
			@Override
			public void onItemLongClick(View view, int position) {
			
			}
		}));
		
		int countItem=0;
		 
			countItem=recyclerViewTools.getAdapter().getItemCount();
			Log.i("countItem", " recyclerView item count "+countItem);
		 
	}
	
	private void initRecyclerView() {
		recyclerViewTools = findViewById(R.id.recycler_tools_product);
		modelHomeTools = new ModelHomeTools();
		listTools = new ArrayList<>();
		adapterHomeSuggestList = new AdapterHomeSuggestList(this, listTools);
		recyclerViewTools.setLayoutManager(gridLayoutManager);
		recyclerViewTools.setAdapter(adapterHomeSuggestList);
		recyclerViewTools.setHasFixedSize(true);
		recyclerViewTools.setAdapter(new ScaleInAnimationAdapter(adapterHomeSuggestList));
	}
	private void alertDialogBox() {
		relativeLayout = findViewById(R.id.relative_sort_item);
		relativeLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				final String[] select = {"پربازدیدترین", "پرفروشترین", "جدیدترین", "ارزانترین", "گرانترین"};
				AlertDialog dialog = new AlertDialog.Builder(ProductListActivity.this, R.style.MyDialogTheme)
					
					                     .setSingleChoiceItems(select, -1, new DialogInterface.OnClickListener() {
						
						                     @Override
						                     public void onClick(DialogInterface dialog, int which) {
							                    switch (which)
							                    {
								                    case 0:
									                    
									                    Toast.makeText(ProductListActivity.this, "tostinnnnnng", Toast.LENGTH_SHORT).show();
									                    break;
								                    case 1:
									                    Toast.makeText(ProductListActivity.this, "this toast", Toast.LENGTH_SHORT).show();
									                    break;
									                    default:
									                    	return;
							                    }
						                     }
					                     })
					                     .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						
						                     @Override
						                     public void onClick(DialogInterface dialog, int which) {
						                     	switch (which){
							                         case 0:
								                     
								                         Toast.makeText(ProductListActivity.this, "case 0", Toast.LENGTH_SHORT).show();
								                         break;
							                         case 1:
								                         Toast.makeText(ProductListActivity.this, "case 1 ", Toast.LENGTH_SHORT).show();
								                         break;
								                         default:
								                         	return;
						                         }
							                    // Toast.makeText(ProductListActivity.this, select[selected] + " " + " انتخاب شد ", Toast.LENGTH_SHORT).show();
						                     }
					                     })
					                     .create();
				dialog.show();
			}
		});
	}
	private void changeItemList() {
		imageChangeList = findViewById(R.id.image_button_change_layout_tools);
		imageChangeList.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				gridView = !gridView;
				if (gridView) {
					imageChangeList.setImageResource(R.drawable.ic_list_line);
					recyclerViewTools.setLayoutManager(linearLayoutManager);
					recyclerViewTools.setAdapter(new ScaleInAnimationAdapter(adapterHomeSuggestList));
				} else {
					imageChangeList.setImageResource(R.drawable.ic_list_grid);
					recyclerViewTools.setLayoutManager(gridLayoutManager);
					recyclerViewTools.setAdapter(new ScaleInAnimationAdapter(adapterHomeSuggestList));
				}
				
			}
		});
	}
	private void setMostBuyList() {
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.note_one_1);
		modelHomeTools.setTextTitle("  دفترچه یادداشت پاپکو");
		modelHomeTools.setTextSubTitle("100 برگ");
		modelHomeTools.setTextPriceOriginal("25،000");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.iphone16);
		modelHomeTools.setTextTitle("آیفون 7  پلاس");
		modelHomeTools.setTextSubTitle("مدل 32 گیگ");
		modelHomeTools.setTextPriceOriginal("6،400،000 تومان");
		modelHomeTools.setTextPriceDiscount("7،000،000 تومان");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.tools_abzar_4);
		modelHomeTools.setTextTitle("پیچ گوشتی 25 سر ");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("   185،000 تومان");
		modelHomeTools.setTextPriceDiscount("300،000 تومان ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.khoshkbar_tokhme1);
		modelHomeTools.setTextTitle("تخمه چاپار");
		modelHomeTools.setTextSubTitle("  تخمه کدو ");
		modelHomeTools.setTextPriceOriginal("10،000 تومان");
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.haircut_panasonic);
		modelHomeTools.setTextTitle(" ریش تراش پاناسونیک ");
		modelHomeTools.setTextSubTitle("مدل BLADE ");
		modelHomeTools.setTextPriceOriginal("  835،000 تومان");
		modelHomeTools.setTextPriceDiscount(" 1،100،000 تومان");
		listTools.add(modelHomeTools);
	}
	private void setMostViewvedList() {
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.iphone16);
		modelHomeTools.setTextTitle("آیفون 7  پلاس");
		modelHomeTools.setTextSubTitle("مدل 32 گیگ");
		modelHomeTools.setTextPriceOriginal("6،400،000 تومان");
		modelHomeTools.setTextPriceDiscount("7،000،000 تومان");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.lg18);
		modelHomeTools.setTextTitle(getString(R.string.vije_981_title));
		modelHomeTools.setTextSubTitle(getString(R.string.vije_981_sub));
		modelHomeTools.setTextPriceOriginal(getString(R.string.vije_981_original));
		modelHomeTools.setTextPriceDiscount(getString(R.string.vije_981_discount));
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.samsung21);
		modelHomeTools.setTextTitle("SAMSUNG A5   ");
		modelHomeTools.setTextSubTitle("مدل 32 گیگ");
		modelHomeTools.setTextPriceOriginal("  6،000،000 تومان");
		modelHomeTools.setTextPriceDiscount("6،500،000 تومان");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.new_balance_1);
		modelHomeTools.setTextTitle("کفش  نیو بالانس مخصوص پیاده روی");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("  2،200،000 تومان");
		modelHomeTools.setTextPriceDiscount(" 2،456،000 تومان");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.adidas_1);
		modelHomeTools.setTextTitle("کفش  آدیداس پیاده روی");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("  2،400،000 تومان");
		modelHomeTools.setTextPriceDiscount(" 2،456،000 تومان");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.sorkhkon);
		modelHomeTools.setTextTitle("Sorkh kon philips 200 W");
		modelHomeTools.setTextSubTitle(" مدل 333");
		modelHomeTools.setTextPriceOriginal("799،000 تومان");
		modelHomeTools.setTextPriceDiscount("890,000 تومان");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.clean_maye_zarfshooyi);
		modelHomeTools.setTextTitle("مایع ظرفشویی بانو");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("  20،000 تومان");
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
	}
	private void setNewestItemList() {
		modelHomeTools.setImageProductItem(R.drawable.khoshkbar_peste0);
		modelHomeTools.setTextTitle("پسته دامغان");
		modelHomeTools.setTextSubTitle("");
		modelHomeTools.setTextPriceOriginal("25،000 تومان");
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.khoshkbar_aloo0);
		modelHomeTools.setTextTitle("آلو دامغان ");
		modelHomeTools.setTextSubTitle(" آلو بخارا");
		modelHomeTools.setTextPriceOriginal("12،000 تومان");
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.microvavelavazem);
		modelHomeTools.setTextTitle("Micro wave hardston 2000 W");
		modelHomeTools.setTextSubTitle(" مدل 234   ");
		modelHomeTools.setTextPriceOriginal("1،999،999 تومان");
		modelHomeTools.setTextPriceDiscount("2,540,000 تومان");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.note_paper_shokrgozari);
		modelHomeTools.setTextTitle("دفترچه یادداشت شکرگزاری");
		modelHomeTools.setTextSubTitle("مدل شکرگزاری");
		modelHomeTools.setTextPriceOriginal("35،222 تومان");
//				modelHomeTools.setTextPriceDiscount("19،000");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.lg14);
		modelHomeTools.setTextTitle("LG K10 2017   ");
		modelHomeTools.setTextSubTitle("مدل 16 گیگ");
		modelHomeTools.setTextPriceOriginal("1،999،000 تومان");
		modelHomeTools.setTextPriceDiscount("2،000،000 تومان");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.gold0);
		modelHomeTools.setTextTitle("دستبند طلای 18 عیار");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("  6،000،000 تومان");
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.gold1);
		modelHomeTools.setTextTitle("دستبند طلا و سنگ    ");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("  3،200،000 تومان");
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.clean_homcare);
		modelHomeTools.setTextTitle("پودر ماشین لباسشویی هوم کر  ");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("  19،000 تومان");
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.clean_maye_litri);
		modelHomeTools.setTextTitle("مایع ظرفشویی 5 لیتری  ");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("  20،000 تومان");
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.clean_maye_saboon);
		modelHomeTools.setTextTitle("مایع صابون");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("  20،000 تومان");
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.clean_maye_zarfshooyi);
		modelHomeTools.setTextTitle("مایع ظرفشویی بانو");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("  20،000 تومان");
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.clean_sefidconnade);
		modelHomeTools.setTextTitle("مایع سفید کنند بانو");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("  20،000 تومان");
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.clean_shishepakon);
		modelHomeTools.setTextTitle("شیشه پاک کن هوم کر      ");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("  20،000 تومان");
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
	}
	private void setDriedFruit() {
		
		modelHomeTools.setImageProductItem(R.drawable.khoshkbar_peste0);
		modelHomeTools.setTextTitle(getString(R.string.fruit_40_title));
		modelHomeTools.setTextSubTitle("");
		modelHomeTools.setTextPriceOriginal(getString(R.string.fruit_40_original));
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.khoshkbar_aloo0);
		modelHomeTools.setTextTitle(getString(R.string.fruit_41_title));
		modelHomeTools.setTextSubTitle(getString(R.string.fruit_41_sub));
		modelHomeTools.setTextPriceOriginal(getString(R.string.fruit_41_original));
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.khoshkbar_peste4);
		modelHomeTools.setTextTitle(" پسته 300 گرمی رفسنجان  ");
		modelHomeTools.setTextSubTitle("پسته کرمان");
		modelHomeTools.setTextPriceOriginal("19،000 تومان");
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.khoshkbar_tokhme1);
		modelHomeTools.setTextTitle("تخمه چاپار");
		modelHomeTools.setTextSubTitle("  تخمه کدو ");
		modelHomeTools.setTextPriceOriginal("10،000 تومان");
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.khoshkbar_peste2);
		modelHomeTools.setTextTitle("پسته لورا  ");
		modelHomeTools.setTextSubTitle("   ");
		modelHomeTools.setTextPriceOriginal("45،000 تومان");
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
	}
	private void setHomeApplianceList() {
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.sorkhkon);
		modelHomeTools.setTextTitle(getString(R.string.home_90_title));
		modelHomeTools.setTextSubTitle(getString(R.string.home_90_sub));
		modelHomeTools.setTextPriceOriginal(getString(R.string.home_90_original));
		modelHomeTools.setTextPriceDiscount(getString(R.string.home_90_discount));
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.ojaghgaz);
		modelHomeTools.setTextTitle(getString(R.string.home_91_title));
		modelHomeTools.setTextSubTitle(getString(R.string.home_91_sub));
		modelHomeTools.setTextPriceOriginal(getString(R.string.home_91_original));
		modelHomeTools.setTextPriceDiscount(getString(R.string.home_91_discount));
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.microvavelavazem);
		modelHomeTools.setTextTitle("Micro wave hardston 2000 W");
		modelHomeTools.setTextSubTitle(" مدل 234   ");
		modelHomeTools.setTextPriceOriginal("1،999،999 تومان");
		modelHomeTools.setTextPriceDiscount("2,540,000 تومان");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.sandwichsaz);
		modelHomeTools.setTextTitle("Sandwich saz kenwood");
		modelHomeTools.setTextSubTitle(" مدل ایر   ");
		modelHomeTools.setTextPriceOriginal("200،000 تومان");
		modelHomeTools.setTextPriceDiscount("290,000 تومان");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.polopazapars);
		modelHomeTools.setTextTitle("Polo paz pars khazar");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("850،222");
//				modelHomeTools.setTextPriceDiscount(" 3،490،000 تومان");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.kababsaz);
		modelHomeTools.setTextTitle("Kabab saz kenwood");
		modelHomeTools.setTextSubTitle(" کباب ساز کنوود مدل  88 دارای جوجه گردان اتوماتیک و منقل");
		modelHomeTools.setTextPriceOriginal("500،000 تومان");
//				modelHomeTools.setTextPriceDiscount("690،000 تومان");
		listTools.add(modelHomeTools);
	}
	private void setPaperList() {
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.note_one_1);
		modelHomeTools.setTextTitle(getString(R.string.note_70_title));
		modelHomeTools.setTextSubTitle(getString(R.string.note_70_sub_title));
		modelHomeTools.setTextPriceOriginal("11،000 تومان");
		modelHomeTools.setTextPriceDiscount(getString(R.string.note_70_discount));
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.note_five_1);
		modelHomeTools.setTextTitle(getString(R.string.note_71_title));
		modelHomeTools.setTextSubTitle(getString(R.string.note_71_sub_title));
		modelHomeTools.setTextPriceOriginal("14،500 تومان");
 
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.note_three_3);
		modelHomeTools.setTextTitle("دفترچه یادداشت نارنجی");
		modelHomeTools.setTextSubTitle("مدل شکرگزاری");
		modelHomeTools.setTextPriceOriginal("3،222 تومان");
		modelHomeTools.setTextPriceDiscount("19،000 تومان");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.note_three_4);
		modelHomeTools.setTextTitle("دفترچه یادداشت آبی");
		modelHomeTools.setTextSubTitle("مدل شکرگزاری");
		modelHomeTools.setTextPriceOriginal("28،345 تومان");
 
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.note_three_7);
		modelHomeTools.setTextTitle("دفترچه یادداشت سبز");
		modelHomeTools.setTextSubTitle("مدل شکرگزاری");
		modelHomeTools.setTextPriceOriginal("1،500 تومان");
 
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.note_paper_shokrgozari);
		modelHomeTools.setTextTitle("دفترچه یادداشت شکرگزاری");
		modelHomeTools.setTextSubTitle("مدل شکرگزاری");
		modelHomeTools.setTextPriceOriginal("35،222 تومان");
 
		listTools.add(modelHomeTools);
		
	}
	private void setToysList() {
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.toys_asbabbazi_8);
		modelHomeTools.setTextTitle(getString(R.string.toys_110_title));
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal(getString(R.string.toys_110_original));
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.toys_asbabbazi_9);
		modelHomeTools.setTextTitle(getString(R.string.toys_111_title));
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal(getString(R.string.toys_111_original));
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.toys_asbabbazi_4);
		modelHomeTools.setTextTitle("بازی اتلو");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("32،000 تومان");
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
	}
	private void setSportList() {
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.nike_3);
		modelHomeTools.setTextTitle(getString(R.string.sport_80_title));
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal(getString(R.string.sport_80_original));
		modelHomeTools.setTextPriceDiscount(getString(R.string.sport_80_discount));
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.new_balance_2);
		modelHomeTools.setTextTitle(getString(R.string.sport_81_title));
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal(getString(R.string.sport_81_original));
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.nike_20);
		modelHomeTools.setTextTitle("کفش نایکی فوتبال ");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("  1،200،000 تومان");
		modelHomeTools.setTextPriceDiscount(" 2،800،000 تومان");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.new_balance_9);
		modelHomeTools.setTextTitle("کفش نیو بالانس فوتبال ");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("  1،200،000 تومان");
		modelHomeTools.setTextPriceDiscount(" 2،456،000 تومان");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.new_balance_1);
		modelHomeTools.setTextTitle("کفش  نیو بالانس مخصوص پیاده روی");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("  2،200،000 تومان");
		modelHomeTools.setTextPriceDiscount(" 2،456،000 تومان");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.adidas_1);
		modelHomeTools.setTextTitle("کفش  آدیداس پیاده روی");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("  2،400،000 تومان");
		modelHomeTools.setTextPriceDiscount(" 2،456،000 تومان");
		listTools.add(modelHomeTools);
	}
	private void setToolsList() {
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.tools_abzar_11);
		modelHomeTools.setTextTitle(getString(R.string.tools_30_title));
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal(getString(R.string.tools_30_original));
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.tools_abzar_4);
		modelHomeTools.setTextTitle(getString(R.string.tools_31_title));
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal(getString(R.string.tools_31_original));
		modelHomeTools.setTextPriceDiscount(getString(R.string.tools_31_discount));
		listTools.add(modelHomeTools);
	}
	private void setHairCutterList() {
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.moser_philips_4);
		modelHomeTools.setTextTitle(getString(R.string.hair_60_title));
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal(getString(R.string.hair_60_original));
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.moser_red_1);
		modelHomeTools.setTextTitle(getString(R.string.hair_61_title));
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal(getString(R.string.hair_61_original));
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.moser_black_1);
		modelHomeTools.setTextTitle("موزر مشکی  ");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("  295،000 تومان");
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.moser_braun_2);
		modelHomeTools.setTextTitle("ریش تراش براون    ");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("  644،000 تومان");
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.haircut_panasonic);
		modelHomeTools.setTextTitle(" ریش تراش پاناسونیک ");
		modelHomeTools.setTextSubTitle("مدل BLADE ");
		modelHomeTools.setTextPriceOriginal("  835،000 تومان");
		modelHomeTools.setTextPriceDiscount(" 1،100،000 تومان");
		listTools.add(modelHomeTools);
	}
	private void setCleanerList() {
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.clean_homcare);
		modelHomeTools.setTextTitle(getString(R.string.clean_10_title));
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal(getString(R.string.clean_10_original));
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.clean_maye_litri);
		modelHomeTools.setTextTitle(getString(R.string.clean_11_title));
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal(getString(R.string.clean_11_original));
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.clean_maye_saboon);
		modelHomeTools.setTextTitle("مایع صابون");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("  20،000 تومان");
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.clean_maye_zarfshooyi);
		modelHomeTools.setTextTitle("مایع ظرفشویی بانو");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("  20،000 تومان");
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.clean_sefidconnade);
		modelHomeTools.setTextTitle("مایع سفید کنند بانو");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("  20،000 تومان");
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.clean_shishepakon);
		modelHomeTools.setTextTitle("شیشه پاک کن هوم کر      ");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("  20،000 تومان");
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
	}
	private void setGoldList() {
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.gold0);
		modelHomeTools.setTextTitle(getString(R.string.gold_20_title));
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal(getString(R.string.gold_20_original));
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.gold1);
		modelHomeTools.setTextTitle(getString(R.string.gold_21_title));
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal(getString(R.string.gold_21_original));
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.gold1);
		modelHomeTools.setTextTitle("دستبند پلاتینیوم");
		modelHomeTools.setTextSubTitle(" ");
		modelHomeTools.setTextPriceOriginal("  2،200،000 تومان");
//				modelHomeTools.setTextPriceDiscount(" ");
		listTools.add(modelHomeTools);
	}
	private void setMobileList() {
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.iphone3);
		modelHomeTools.setTextTitle(getString(R.string.mobile_50_title));
		modelHomeTools.setTextSubTitle(getString(R.string.mobile_50_sub));
		modelHomeTools.setTextPriceOriginal(getString(R.string.mobile_50_original));
		modelHomeTools.setTextPriceDiscount(getString(R.string.mobile_50_discount));
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.iphone16);
		modelHomeTools.setTextTitle(getString(R.string.mobile_51_title));
		modelHomeTools.setTextSubTitle(getString(R.string.mobile_51_sub));
		modelHomeTools.setTextPriceOriginal(getString(R.string.mobile_51_original));
		modelHomeTools.setTextPriceDiscount(getString(R.string.mobile_51_discount));
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.iphone22);
		modelHomeTools.setTextTitle("آیفون 6 ");
		modelHomeTools.setTextSubTitle("مدل 32 گیگ");
		modelHomeTools.setTextPriceOriginal("2،999،000 تومان");
		modelHomeTools.setTextPriceDiscount("3،000،000 تومان");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.iphone26);
		modelHomeTools.setTextTitle("آیفون 8 پلاس");
		modelHomeTools.setTextSubTitle("مدل 256 گیگ");
		modelHomeTools.setTextPriceOriginal("8،999،000 تومان");
		modelHomeTools.setTextPriceDiscount("9،000،000 تومان");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.iphone13);
		modelHomeTools.setTextTitle("آیفون 6 ");
		modelHomeTools.setTextSubTitle("مدل 16 گیگ");
		modelHomeTools.setTextPriceOriginal("3،999،000 تومان");
		modelHomeTools.setTextPriceDiscount("4،000،000 تومان");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.lg14);
		modelHomeTools.setTextTitle("LG K10 2017   ");
		modelHomeTools.setTextSubTitle("مدل 16 گیگ");
		modelHomeTools.setTextPriceOriginal("1،999،000 تومان");
		modelHomeTools.setTextPriceDiscount("2،000،000 تومان");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.lg18);
		modelHomeTools.setTextTitle("LG OLYMPUS ");
		modelHomeTools.setTextSubTitle("مدل 32 گیگ");
		modelHomeTools.setTextPriceOriginal("3،999،000 تومان");
		modelHomeTools.setTextPriceDiscount("4،500،000 تومان");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.lg1);
		modelHomeTools.setTextTitle("LG K10 2016 ");
		modelHomeTools.setTextSubTitle("مدل 16 گیگ");
		modelHomeTools.setTextPriceOriginal("  999،000 تومان");
		modelHomeTools.setTextPriceDiscount("1،000،000 تومان");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.samsung6);
		modelHomeTools.setTextTitle("SAMSUNG Note 8 ");
		modelHomeTools.setTextSubTitle("مدل 256 گیگ");
		modelHomeTools.setTextPriceOriginal("  12،000،000 تومان");
		modelHomeTools.setTextPriceDiscount("12،500،000 تومان");
		listTools.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.samsung21);
		modelHomeTools.setTextTitle("SAMSUNG A5   ");
		modelHomeTools.setTextSubTitle("مدل 32 گیگ");
		modelHomeTools.setTextPriceOriginal("  6،000،000 تومان");
		modelHomeTools.setTextPriceDiscount("6،500،000 تومان");
		listTools.add(modelHomeTools);
	}
	private void setToolbar() {
		toolbarTools = findViewById(R.id.toolbar_product_activity_tool);
		
		setSupportActionBar(toolbarTools);
		toolbarTools.setTitleTextColor(ContextCompat.getColor(this, R.color.WhiteColor));
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.basket_menu_item, menu);
		
		final MenuItem menuItem = menu.findItem(R.id.action_cart);
		
		View actionView = menuItem.getActionView();
		
		textCartItemCount = actionView.findViewById(R.id.cart_badge);
		
		setUpBadge();
		
		actionView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				onOptionsItemSelected(menuItem);
				Toast.makeText(ProductListActivity.this, "سبد خرید ", Toast.LENGTH_SHORT).show();
			}
		});
		return true;
	}
	
	private void setUpBadge() {
		
		if (textCartItemCount != null) {
			
			if (mCartItemCount == 0) {
				if (textCartItemCount.getVisibility() != View.GONE) {
					textCartItemCount.setVisibility(View.GONE);
				}
			} else {
				textCartItemCount.setText(String.valueOf(Math.min(mCartItemCount, 99)));
				if (textCartItemCount.getVisibility() != View.VISIBLE) {
					textCartItemCount.setVisibility(View.VISIBLE);
				}
			}
		}
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		switch (id) {
			case R.id.cart_menu_icon:
				Toast.makeText(this, "سبد خرید انتخاب شد", Toast.LENGTH_SHORT).show();
				
				break;
			case R.id.search_icon_menu:
				Toast.makeText(this, "جستجو در محصولات", Toast.LENGTH_SHORT).show();
				break;
			case android.R.id.home:
				finish();
				break;
			default:
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
	final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2) {
		
		@Override
		public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
			super.smoothScrollToPosition(recyclerView, state, position);
			
			LinearSmoothScroller smoothScroller = new LinearSmoothScroller(ProductListActivity.this) {
				
				private static final float SPEED = 300f;
				@Override
				protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
					return SPEED / displayMetrics.densityDpi;
				}
			};
			smoothScroller.setTargetPosition(position);
			startSmoothScroll(smoothScroller);
			
		}
	};
	final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this) {
		
		@Override
		public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
			super.smoothScrollToPosition(recyclerView, state, position);
			
			LinearSmoothScroller smoothScroller = new LinearSmoothScroller(ProductListActivity.this) {
				
				private static final float SPEED = 300f;
				@Override
				protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
					return SPEED / displayMetrics.densityDpi;
				}
			};
			smoothScroller.setTargetPosition(position);
			startSmoothScroll(smoothScroller);
			
		}
	};
}
