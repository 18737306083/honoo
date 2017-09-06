package com.honoo.idcard;



import java.util.HashMap;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
 




import com.example.idcard.R;
import com.honoo.service.PersonInfo;
import com.mob.MobSDK;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class LoginActivity extends Activity implements View.OnClickListener{
  private Button login;
  private EditText phone;
  private EditText password;
  private TextView yulan;
  private TextView register;
  private ImageView cancel1;
  private ImageView cancel2;
  final DaoService daoservice=new DaoService(this, "idcard.db3", 1);
	   @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		login=(Button) findViewById(R.id.login);
		phone=(EditText) findViewById(R.id.inputPhone);
		password=(EditText) findViewById(R.id.inputPassWords);
		yulan=(TextView) findViewById(R.id.yu);
		register=(TextView) findViewById(R.id.register);
		cancel1=(ImageView) findViewById(R.id.cancel1);
		cancel2=(ImageView) findViewById(R.id.cancel2);
		//final DaoService daoservice=new DaoService(this, "idcard.db3", 1);
		login.setOnClickListener(this);
		yulan.setOnClickListener(this);
		register.setOnClickListener(this);
	
	}

//ºÏ≤Èµ«¬º
	public Boolean checkLogin(DaoService daoservice,String number,String password){
		
	String password1=PersonInfo.selectPerson(daoservice.getReadableDatabase(), number);
	
		if(password1 ==null || password1.equals("")){
			
			Toast.makeText(LoginActivity.this, "Œ¥◊¢≤·", Toast.LENGTH_SHORT).show();
			 return false;
		}
		else{
			if(password.equals(password1)){
				//µ«¬º
				 
				return true;
			}
			else{
				
				Toast.makeText(LoginActivity.this, "√‹¬Î¥ÌŒÛ!", Toast.LENGTH_SHORT).show();
				return false;
			}
			
		}
		
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.login:
			Boolean loginstatus;
			if (phone.getText().toString().trim().equals("")) {
				Toast.makeText(LoginActivity.this, "«Î ‰»Î’À∫≈!", Toast.LENGTH_SHORT)
						.show();

				return;
			}
			if (phone.getText().toString().trim().length() < 10) {
				Toast.makeText(LoginActivity.this, "«Î’˝»∑ ‰»Î’À∫≈!",
						Toast.LENGTH_SHORT).show();

				return;
			}
			String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
			Pattern p = Pattern.compile(regExp);
			Matcher m = p.matcher(phone.getText().toString().trim());
			if (!m.matches()) {
				Toast.makeText(LoginActivity.this, "«Î’˝»∑ ‰»Î’À∫≈!",
						Toast.LENGTH_SHORT).show();
				return;
			}

			/* µ«¬º */
			loginstatus = checkLogin(daoservice, phone.getText().toString(),
					password.getText().toString());
			if (loginstatus) {
				Intent intent = new Intent(LoginActivity.this, Visortor.class);
				intent.putExtra("phone", phone.getText().toString());
				startActivity(intent);

			}

			else {

			}

			break;
		case R.id.yu:

			Intent intent = new Intent(LoginActivity.this, Visortor.class);
			if (phone.getText().toString().trim().equals("")) {
				Toast.makeText(LoginActivity.this, "«Î ‰»Î’À∫≈!", Toast.LENGTH_SHORT)
						.show();

				return;
			}
			if (phone.getText().toString().trim().length() < 10) {
				Toast.makeText(LoginActivity.this, "«Î’˝»∑ ‰»Î’À∫≈!",
						Toast.LENGTH_SHORT).show();

				return;
			}

			String regExp1 = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
			Pattern p1 = Pattern.compile(regExp1);
			Matcher m1 = p1.matcher(phone.getText().toString().trim());
			if (!m1.matches()) {
				Toast.makeText(LoginActivity.this, "«Î’˝»∑ ‰»Î’À∫≈!",
						Toast.LENGTH_SHORT).show();
				return;
			}

			intent.putExtra("phone", phone.getText().toString());
			startActivity(intent);

			break;
		case R.id.register:
			Intent intent1 = new Intent(LoginActivity.this,
					RegisterActivity.class);
			startActivity(intent1);
			break;
		default:
			break;
		}
	}
 
	
	 
}
