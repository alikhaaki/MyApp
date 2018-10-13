package com.ali.digikalaapp.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ali.digikalaapp.Adapter.AdapterButton;
import com.ali.digikalaapp.Adapter.AdapterDigiSuggestion;
import com.ali.digikalaapp.HelperClass.FontCustom;
import com.ali.digikalaapp.HelperClass.ImageLoaderSlider;
import com.ali.digikalaapp.HelperClass.RecyclerViewItemClickListener;
import com.ali.digikalaapp.Model.ModelButton;
import com.ali.digikalaapp.Model.ModelHomeTools;
import com.ali.digikalaapp.R;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;
import java.util.List;

import cn.iwgang.countdownview.CountdownView;
import static com.ali.digikalaapp.Activity.ProductListActivity.PRODUCT_ID_NAME;
import q.rorbin.badgeview.QBadgeView;
import ss.com.bannerslider.Slider;
import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.event.OnSlideClickListener;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class DigiActivity extends AppCompatActivity {
	
	private Slider slider;
	private Toolbar toolbarDigi;
	private RecyclerView recyclerViewHorizontal;
	private RecyclerView recyclerViewDigi;
	private AdapterButton adapterButton;
	private AdapterDigiSuggestion adapterHomeSuggestList;
	private List<ModelButton> listButton;
	private ImageView imageDigiLavazemKH;
	private ImageView imageKhoshkbar;
	private ImageView image_server;
	private CountdownView countdownView;
	private NavigationView navigationView;
	private DrawerLayout drawerLayout;
	private TextView textEmailSingUp;
	private ImageView imageBannerNote;
	private ImageView imageBannerCleaner;
	
	public static final int CLEANER = 1;
	public static final int GOLD = 2;
	public static final int TOOLS = 3;
	public static final int DRIED_FRUIT = 4;
	public static final int MOBILE = 5;
	public static final int HAIR_CUTTER = 6;
	public static final int NOTE_PAPER = 7;
	public static final int SPORT = 8;
	public static final int HOME_APPLIANCE = 9;
	public static final int BABY_TOYS = 10;
	
	public final static String KEY_NAME = "id_cat_name";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_digi);
		
		initSlider();
		initCountDownTimer();
		initButtonRecyclerView();
		initToolbar();
		initDrawerLayout();
		clickListener();
		navigateFontAndClick();
		initRecyclerSuggestion();
		
		int mWith= Resources.getSystem().getDisplayMetrics().widthPixels;
		int mHith= Resources.getSystem().getDisplayMetrics().heightPixels;
		
		Log.i("H_T_H", "hig and wig"+"hig= "+mHith+" wig= "+"  "+"  "+mWith);
	}
	private void initRecyclerSuggestion() {
		
		recyclerViewHorizontal = findViewById(R.id.recyclerViewHomeHorizontal);
		
		recyclerViewHorizontal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
		
		List<ModelHomeTools> listItemLavazem = new ArrayList<>();
		
		
		adapterHomeSuggestList = new AdapterDigiSuggestion(this, listItemLavazem);
		
		listItemLavazem.add(new ModelHomeTools(R.drawable.sorkhkon, "Sorkh kon philips 200 W ", "", "799،000 تومان", "890,000 تومان"));
		listItemLavazem.add(new ModelHomeTools(R.drawable.polopazapars, "Polo paz pars khazar 480 W", "", "299،999 تومان", "390,000 تومان"));
		listItemLavazem.add(new ModelHomeTools(R.drawable.ojaghgaz, "Ojagh gas Hardston model 3520", "", "800,000 تومان", "1,00,000 تومان"));
		listItemLavazem.add(new ModelHomeTools(R.drawable.sandwichsaz, "Sandwich saz kenwood", " ", "200،000 تومان", "290,000 تومان"));
		listItemLavazem.add(new ModelHomeTools(R.drawable.kababsaz, "Kabab saz kenwood", " ", "500،000 تومان", "690,000 تومان"));
		listItemLavazem.add(new ModelHomeTools(R.drawable.microvavelavazem, "Micro wave hardston 2000 W", " ", "1،999،999 تومان", "2,540,000 تومان"));
		
		recyclerViewHorizontal.setAdapter(adapterHomeSuggestList);
		
		recyclerViewHorizontal.addOnItemTouchListener(new RecyclerViewItemClickListener(this, recyclerViewHorizontal, new RecyclerViewItemClickListener.OnItemClickListener() {
			
			@Override
			public void onItemClick(View view, int position) {
				Intent intent=new Intent(DigiActivity.this,ProductDetailActivity.class);
				
				switch (position){
					case 0:
						intent.putExtra(PRODUCT_ID_NAME, 90);
						startActivity(intent);
					case 1:
						intent.putExtra(PRODUCT_ID_NAME, 91);
						startActivity(intent);
				}
				
			}
			@Override
			public void onItemLongClick(View view, int position) {
			
			}
		}));
		
		RecyclerView recyclerView = findViewById(R.id.recyclerViewHomeHorizontal_shegeftANgiz);
		
		listItemLavazem = new ArrayList<>();
		
		adapterHomeSuggestList = new AdapterDigiSuggestion(this, listItemLavazem);
		
		ModelHomeTools modelHomeTools;
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.iphone16);
		modelHomeTools.setTextTitle("آیفون 7  پلاس");
		modelHomeTools.setTextSubTitle("مدل 32 گیگ");
		modelHomeTools.setTextPriceOriginal("6،400،000 تومان");
		modelHomeTools.setTextPriceDiscount("7،000،000 تومان");
		listItemLavazem.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.iphone3);
		modelHomeTools.setTextTitle("آیفون X ");
		modelHomeTools.setTextSubTitle("مدل 128 گیگ");
		modelHomeTools.setTextPriceOriginal("18،400،000 تومان");
		modelHomeTools.setTextPriceDiscount("19،000،000 تومان");
		listItemLavazem.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.iphone22);
		modelHomeTools.setTextTitle("آیفون 8 ");
		modelHomeTools.setTextSubTitle("مدل 256 گیگ");
		modelHomeTools.setTextPriceOriginal("8،999،000 تومان");
		modelHomeTools.setTextPriceDiscount("9،000،000 تومان");
		listItemLavazem.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.iphone16);
		modelHomeTools.setTextTitle("آیفون 8 ");
		modelHomeTools.setTextSubTitle("مدل 256 گیگ");
		modelHomeTools.setTextPriceOriginal("8،999،000 تومان");
		modelHomeTools.setTextPriceDiscount("9،000،000 تومان");
		listItemLavazem.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.iphone13);
		modelHomeTools.setTextTitle("آیفون 6 ");
		modelHomeTools.setTextSubTitle("مدل 16 گیگ");
		modelHomeTools.setTextPriceOriginal("3،999،000 تومان");
		modelHomeTools.setTextPriceDiscount("4،000،000 تومان");
		listItemLavazem.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.lg14);
		modelHomeTools.setTextTitle("LG K10 2017   ");
		modelHomeTools.setTextSubTitle("مدل 16 گیگ");
		modelHomeTools.setTextPriceOriginal("1،999،000 تومان");
		modelHomeTools.setTextPriceDiscount("2،000،000 تومان");
		listItemLavazem.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.lg18);
		modelHomeTools.setTextTitle("LG OLYMPUS ");
		modelHomeTools.setTextSubTitle("مدل 32 گیگ");
		modelHomeTools.setTextPriceOriginal("3،999،000 تومان");
		modelHomeTools.setTextPriceDiscount("4،500،000 تومان");
		listItemLavazem.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.lg1);
		modelHomeTools.setTextTitle("LG K10 2016 ");
		modelHomeTools.setTextSubTitle("مدل 16 گیگ");
		modelHomeTools.setTextPriceOriginal("  999،000 تومان");
		modelHomeTools.setTextPriceDiscount("1،000،000 تومان");
		listItemLavazem.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.samsung6);
		modelHomeTools.setTextTitle("SAMSUNG Note 8 ");
		modelHomeTools.setTextSubTitle("مدل 256 گیگ");
		modelHomeTools.setTextPriceOriginal("  12،000،000 تومان");
		modelHomeTools.setTextPriceDiscount("12،500،000 تومان");
		listItemLavazem.add(modelHomeTools);
		
		modelHomeTools = new ModelHomeTools();
		modelHomeTools.setImageProductItem(R.drawable.samsung21);
		modelHomeTools.setTextTitle("SAMSUNG A5   ");
		modelHomeTools.setTextSubTitle("مدل 32 گیگ");
		modelHomeTools.setTextPriceOriginal("  6،000،000 تومان");
		modelHomeTools.setTextPriceDiscount("6،500،000 تومان");
		listItemLavazem.add(modelHomeTools);
		
		recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
		recyclerView.setAdapter(adapterHomeSuggestList);
		
	}
	
	private void initDrawerLayout() {
		drawerLayout = findViewById(R.id.drawerLayoutDigiKala);
		
		QBadgeView qBadgeView = new QBadgeView(this);
		
	//	ImageView imDrawer = findViewById(R.id.image_drawer_hamburger);
		
//		qBadgeView.bindTarget(imDrawer)
//			.setBadgeBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent))
//			.setGravityOffset(-1, -5, true)
//		;
//
//		imDrawer.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//
//				drawerLayout.openDrawer(Gravity.RIGHT);
//
//			}
//		});
		ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbarDigi, 0, 0);
		drawerToggle.syncState();
	}
	private void initToolbar() {
		toolbarDigi = findViewById(R.id.toolbarDigiKala);
		setSupportActionBar(toolbarDigi);
		toolbarDigi.setTitleTextColor(ContextCompat.getColor(this, R.color.WhiteColor));
		ActionBar actionBar = getSupportActionBar();
		//actionBar.setDisplayHomeAsUpEnabled(true);
		//actionBar.setHomeButtonEnabled(true);
	}
	private void clickListener() {
		imageKhoshkbar = findViewById(R.id.imageKhoshkbarProduct);
		
		
		
		
	/*
	         CLEANER            1
	         GOLD               2
	         HOME               3
	         DRIED_FRUIT        4
	         MOBILE             5
	         HAIR_CUTTER        6
	         NOTE_PAPER         7
	         SPORT              8
	         HOME_APPLIANCE     9
	         BABY_TOYS          10
	 
	   */
		
		ImageView imageBannerMobile = findViewById(R.id.image_banner_mobile);
		imageBannerMobile.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(DigiActivity.this, ProductListActivity.class);
				intent.putExtra(KEY_NAME, MOBILE);
				startActivity(intent);
				
			}
		});
		TextView textViewMore2 = findViewById(R.id.text_show_all_shegeft_angiz);
		textViewMore2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DigiActivity.this, ProductListActivity.class);
				intent.putExtra(KEY_NAME, MOBILE);
				startActivity(intent);
				
			}
		});
		
		TextView textViewMore1 = findViewById(R.id.text_show_all_vije);
		textViewMore1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DigiActivity.this, ProductListActivity.class);
				intent.putExtra(KEY_NAME, HOME_APPLIANCE);
				startActivity(intent);
				
			}
		});
		imageBannerCleaner = findViewById(R.id.image_banner_cleaner);
		imageBannerCleaner.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(DigiActivity.this, ProductListActivity.class);
				intent.putExtra(KEY_NAME, CLEANER);
				startActivity(intent);
				
			}
		});
		imageKhoshkbar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DigiActivity.this, ProductListActivity.class);
				intent.putExtra(KEY_NAME, DRIED_FRUIT);
				
				startActivity(intent);
				
			}
		});
		imageDigiLavazemKH = findViewById(R.id.imageDigiLavazem);
		imageDigiLavazemKH.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DigiActivity.this, ProductListActivity.class);
				intent.putExtra(KEY_NAME, HOME_APPLIANCE);
				startActivity(intent);
			}
		});
		imageBannerNote = findViewById(R.id.imageCardNoteBanner);
		imageBannerNote.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(DigiActivity.this, ProductListActivity.class);
				intent.putExtra(KEY_NAME, NOTE_PAPER);
				startActivity(intent);
			}
		});
//		image_server = findViewById(R.id.image_server_layout);
//
//		image_server.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				startActivity(new Intent(DigiActivity.this, ProductServerActivity.class));
//			}
//		});
	}
	private void initButtonRecyclerView() {
		listButton = new ArrayList<>();
		ModelButton model = new ModelButton();
		model.setTextButton("موبایل");
		listButton.add(model);
		model = new ModelButton();
		model.setTextButton("زیورآلات طلا");
		listButton.add(model);
		model = new ModelButton();
		model.setTextButton("خشکبار");
		listButton.add(model);
		model = new ModelButton();
		model.setTextButton("ورزش و سفر");
		listButton.add(model);
		model = new ModelButton();
		model.setTextButton("ابزار و وسایل ");
		listButton.add(model);
		model = new ModelButton();
		model.setTextButton("اسباب بازی ");
		listButton.add(model);
		
		model = new ModelButton();
		model.setTextButton("لوازم التحریر");
		listButton.add(model);
		
		recyclerViewDigi = findViewById(R.id.recyclerViewDigiKala);
		recyclerViewDigi.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
		adapterButton = new AdapterButton(this, listButton);
		recyclerViewDigi.setAdapter(adapterButton);
		
		recyclerViewDigi.addOnItemTouchListener(new RecyclerViewItemClickListener(this, recyclerViewDigi, new RecyclerViewItemClickListener.OnItemClickListener() {
			
			@Override
			public void onItemClick(View view, int position) {
				Intent intent = new Intent(DigiActivity.this, ProductListActivity.class);
				switch (position) {
					case 0:
						intent.putExtra(KEY_NAME, MOBILE);
						startActivity(intent);
						break;
					
					case 1:
						intent.putExtra(KEY_NAME, GOLD);
						startActivity(intent);
						break;
					
					case 2:
						intent.putExtra(KEY_NAME, DRIED_FRUIT);
						startActivity(intent);
						break;
					
					case 3:
						intent.putExtra(KEY_NAME, SPORT);
						startActivity(intent);
						break;
					
					case 4:
						intent.putExtra(KEY_NAME, TOOLS);
						startActivity(intent);
						break;
					
					case 5:
						intent.putExtra(KEY_NAME, BABY_TOYS);
						startActivity(intent);
						break;
					
					case 6:
						intent.putExtra(KEY_NAME, NOTE_PAPER);
						startActivity(intent);
						break;
				}
			}
			@Override
			public void onItemLongClick(View view, int position) {
			
			}
		}));
	}
	private void initCountDownTimer() {
		countdownView = findViewById(R.id.timer);
		countdownView.start(54000000);
		
		countdownView = new CountdownView(this);
		countdownView = findViewById(R.id.timerShegeftAngiz);
		countdownView.start(85000000);
	}
	private void initSlider() {
		
		Slider.init(new ImageLoaderSlider(DigiActivity.this));
		
		slider = findViewById(R.id.slider_digi_kala);
		slider.setAdapter(new SliderAdapter() {
			
			@Override
			public int getItemCount() {
				return 3;
			}
			@Override
			public void onBindImageSlide(int position, ImageSlideViewHolder holder) {
				switch (position) {
					
					case 0:
						holder.bindImageSlide(R.drawable.bannerone);
						break;
					case 1:
						holder.bindImageSlide(R.drawable.bannertwo);
						break;
					case 2:
						holder.bindImageSlide(R.drawable.bannerthree);
						break;
					
				}
				
			}
		});
		
		
		slider.setOnSlideClickListener(new OnSlideClickListener() {
			
			@Override
			public void onSlideClick(int position) {
				
				switch (position) {
					case 0:
						Intent intentHair = new Intent(DigiActivity.this, ProductListActivity.class);
						intentHair.putExtra(KEY_NAME, HAIR_CUTTER);
						startActivity(intentHair);
						break;
					case 1:
						Intent intentGold = new Intent(DigiActivity.this, ProductListActivity.class);
						intentGold.putExtra(KEY_NAME, GOLD);
						startActivity(intentGold);
						break;
					case 2:
						Intent intentTools = new Intent(DigiActivity.this, ProductListActivity.class);
						intentTools.putExtra(KEY_NAME, TOOLS);
						startActivity(intentTools);
						break;
					default:
						return;
				}
				
			}
		});
		
	}
	private void applyFontItem(MenuItem mi) {
		Typeface font = Typeface.createFromAsset(getAssets(), "iransansmobile.ttf");
		SpannableString mNewTitle = new SpannableString(mi.getTitle());
		mNewTitle.setSpan(new FontCustom("", font), 0, mNewTitle.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
		mi.setTitle(mNewTitle);
		
	}
	private void showEmailNavigationHeader(String email) {
		textEmailSingUp.setText(email);
	}
	private void navigateFontAndClick() {
		navigationView = findViewById(R.id.navigation_View_digi);
		Menu m = navigationView.getMenu();
		for (int i = 0; i < m.size(); i++) {
			MenuItem mi = m.getItem(i);
			SubMenu subMenu = mi.getSubMenu();
			if (subMenu != null && subMenu.size() > 0) {
				for (int j = 0; j < subMenu.size(); j++) {
					MenuItem subMenuItem = subMenu.getItem(j);
					applyFontItem(subMenuItem);
				}
			}
			applyFontItem(mi);
		}
		textEmailSingUp = navigationView.getHeaderView(0).findViewById(R.id.text_header_email_signUp);
		
		Intent iii = getIntent();
		
		Bundle bundle = iii.getExtras();
		String em;
		if (bundle != null) {
			em = (String) bundle.get("email");
			textEmailSingUp.setText(em);
			SharedPreferences pref = DigiActivity.this.getSharedPreferences("preferring", MODE_PRIVATE);
			SharedPreferences.Editor editor = pref.edit();
			
			editor.putString("em", em);
		}

//		UserSharedPreferences userSharedPreferences = new UserSharedPreferences(DigiActivity.this);
//		String email = userSharedPreferences.getUserLogniInfo();
//		if (!email.isEmpty()) {
//			textEmailSingUp.setText(email);
//		}
		
		navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
			
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem item) {
				Intent intent1=new Intent(DigiActivity.this,ProductListActivity.class);
				
				switch (item.getItemId()) {
					case R.id.menu_sign_in:
						startActivityForResult(new Intent(DigiActivity.this, LoginActivity.class), REQUEST_CODE_LOGIN);
						break;
					case R.id.itemList:
						Intent intent = new Intent(DigiActivity.this, CategoryActivity.class);
						startActivity(intent);
						break;
					case R.id.itemHome:
						drawerLayout.closeDrawers();
						break;
					case R.id.menu_basket_item:
						
						
 					Toast.makeText(DigiActivity.this, "سبد خرید انتخاب شد", Toast.LENGTH_SHORT).show();
						break;
					case R.id.menu_item_special_suggest:
						intent1.putExtra(KEY_NAME, HOME_APPLIANCE);
						startActivity(intent1);
						break;
					case R.id.menu_item_most_buy:
						intent1.putExtra(KEY_NAME, 99);
						startActivity(intent1);
						break;
					case R.id.menu_most_viewed:
						intent1.putExtra(KEY_NAME, 98);
						startActivity(intent1);
						break;
					case R.id.menu_newest_item:
						intent1.putExtra(KEY_NAME, 97);
						startActivity(intent1);
						break;
					case R.id.menu_item_setting:
						TastyToast.makeText(DigiActivity.this, "تنظیمات",TastyToast.LENGTH_LONG, TastyToast.DEFAULT);
						break;
					case R.id.menu_most_question:
						TastyToast.makeText(DigiActivity.this, "سوالات متدوال",TastyToast.LENGTH_LONG, TastyToast.INFO);
						break;
					case R.id.itemAbout:
						startActivity(new Intent(DigiActivity.this,AboutActivity.class));
						break;
					
				}
				return true;
			}
		});
	}
	 private TextView textCartItemCount;
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.basket_menu_item, menu);
		
		
		final MenuItem menuItem=menu.findItem(R.id.action_cart);
		
		View actionView = menuItem.getActionView();
		
		textCartItemCount =   actionView.findViewById(R.id.cart_badge);
		
		setUpBadge();
		
		actionView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onOptionsItemSelected(menuItem);
				Toast.makeText(DigiActivity.this, "سبد خرید ", Toast.LENGTH_SHORT).show();
			}
		});
		return true;
	}
	private int mCartItemCount=0;
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
			default:
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
	private static final int REQUEST_CODE_LOGIN = 2;
	public static final int RESULT_OK = 1;
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == REQUEST_CODE_LOGIN) {
			if (resultCode == RESULT_OK) {
				String email = data.getStringExtra("email");
				if (email != null && !email.isEmpty()) {
					
					showEmailNavigationHeader(email);
					
				}
			}
		}
	}
}