package com.ali.digikalaapp.Activity;



import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ali.digikalaapp.R;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import mehdi.sakout.fancybuttons.FancyButton;

public class LoginActivity extends AppCompatActivity {
	
	EditText editEmail,   editName;
	TextInputEditText editPassword;
	FancyButton buttonSIgnIN;
	String URL= "http://192.168.1.4:88/test-android/index.php";
	FancyButton butRegisterIn;
	JSONParser jsonParser=new JSONParser();
	
	int i=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_login);
		
		editEmail=(EditText)findViewById(R.id.editEmail);
		editName=(EditText)findViewById(R.id.editName);
		editPassword= findViewById(R.id.editPassword);
		
		buttonSIgnIN = findViewById(R.id.button_btnSignIn);
		butRegisterIn = findViewById(R.id.button_btnRegister);
		
		buttonSIgnIN.setText("ورود");
		buttonSIgnIN.setBackgroundColor(this.getResources().getColor(R.color.colorAccent));
		buttonSIgnIN.setFocusBackgroundColor(this.getResources().getColor(R.color.WhiteColor));
		buttonSIgnIN.setRadius(5);
		buttonSIgnIN.setBorderWidth(1);
		buttonSIgnIN.setBorderColor(this.getResources().getColor(R.color.GreenText));
		
		
		
		butRegisterIn.setText("ساخت حساب");
		butRegisterIn.setBackgroundColor(this.getResources().getColor(R.color.colorAccent));
		butRegisterIn.setFocusBackgroundColor(this.getResources().getColor(R.color.WhiteColor));
		butRegisterIn.setRadius(5);
		butRegisterIn.setBorderWidth(1);
		butRegisterIn.setBorderColor(this.getResources().getColor(R.color.GreenText));
		
		
		buttonSIgnIN.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				AttemptLogin attemptLogin= new AttemptLogin();
				attemptLogin.execute(editName.getText().toString(),editPassword.getText().toString(),"");
				
				String emailText=editEmail.getText().toString();
				
				Intent intentDigi=new Intent(LoginActivity.this,DigiActivity.class);
				intentDigi.putExtra("email", emailText);
				startActivity(intentDigi);
				finish();
			}
		});
		
		butRegisterIn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				
				if(i==0)
				{
					i=1;
					editEmail.setVisibility(View.VISIBLE);
					buttonSIgnIN.setVisibility(View.GONE);
					butRegisterIn.setText("ساخت حساب");
				}
				else{
					
					butRegisterIn.setText("ساخت حساب");
					editEmail.setVisibility(View.GONE);
					buttonSIgnIN.setVisibility(View.VISIBLE);
					i=0;
					
					AttemptLogin attemptLogin= new AttemptLogin();
					attemptLogin.execute(editName.getText().toString(),editPassword.getText().toString(),editEmail.getText().toString());
					
					String emailText=editEmail.getText().toString();
					
					Intent intentDigi=new Intent(LoginActivity.this,DigiActivity.class);
					intentDigi.putExtra("email", emailText);
					startActivity(intentDigi);
					finish();
				}
				
			}
		});
		
		
	}
	
	private class AttemptLogin extends AsyncTask<String, String, JSONObject> {
		
		@Override
		
		protected void onPreExecute() {
			
			super.onPreExecute();
			
		}
		
		@Override
		
		protected JSONObject doInBackground(String... args) {
			
			
			
			String email = args[2];
			String password = args[1];
			String name= args[0];
			
			ArrayList params = new ArrayList();
			params.add(new BasicNameValuePair("username", name));
			params.add(new BasicNameValuePair("password", password));
			if(email.length()>0)
				params.add(new BasicNameValuePair("email",email));
			
			JSONObject json = jsonParser.makeHttpRequest(URL, "POST", params);
			
			
			return json;
			
		}
		
		protected void onPostExecute(JSONObject result) {
			
			// dismiss the dialog once product deleted
			//Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
			
			try {
				if (result != null) {
					Toast.makeText(getApplicationContext(),result.getString("message"),Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(getApplicationContext(), "خطا در دریافت اطلاعات از سرور", Toast.LENGTH_LONG).show();
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			
		}
		
	}
}
