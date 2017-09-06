package com.honoo.idcard;

/*游客登录*/
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.example.idcard.R;
import com.honoo.erweima.ZXingUtils;
import com.honoo.service.Base64s;
import com.honoo.service.RC4entry;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Visortor extends Activity implements View.OnClickListener {
	private ImageView view;
	private Button btn_create;
	private EditText edit;
	private ImageView back;
	private Button share;
	private Button model;
	private TextView erweima;
	private int flag = 1;
	String phone;
	private Handler uiHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {

			switch (msg.what) {
			case 1:
				if (flag == 1) {
					parseString1(phone, view);
				} else {
					parseString2(phone, view);
				}
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.code);
		// perrsonInfo=(ImageView) findViewById(R.id.perrsonInfo);
		view = (ImageView) findViewById(R.id.iv_two_code);
		back = (ImageView) findViewById(R.id.back);
		share = (Button) findViewById(R.id.shared);
		model = (Button) findViewById(R.id.model);
		erweima = (TextView) findViewById(R.id.erweima);
		registerForContextMenu(erweima);
		Intent intent = getIntent();
		phone = intent.getStringExtra("phone");
		System.out.println(view.getWidth());
		share.setOnClickListener(this);
		model.setOnClickListener(this);
		back.setOnClickListener(this);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				uiHandler.sendEmptyMessage(1);
			}
		}, 0, 5000);
	}

	// 格式一
	public void parseString1(String phone, ImageView view1) {
		SimpleDateFormat sim;
		Calendar ca;
		Date moment;
		String first;
		String second;
		byte[] str;
		String number;
		Bitmap bitmap;
		number = phone.substring(3);
		sim = new SimpleDateFormat("ddHHmmss");
		ca = Calendar.getInstance();
		moment = new Date();
		ca.setTime(moment);
		first = sim.format(ca.getTime());
		ca.add(Calendar.SECOND, 10);
		second = sim.format(ca.getTime());
		str = RC4entry.encry_RC4_byte("a|" + number + "|" + second,
				"1234567890");
		byte[] by = Base64s.encode(str);
		System.out.println(view1.getWidth());
		System.out.println(new String(by));
		bitmap = ZXingUtils.createQRImage("#*" + new String(by), 200, 200);
		view1.setImageBitmap(bitmap);

	}
	public void parseString2(String phone, ImageView view1) {
		SimpleDateFormat sim;
		Calendar ca;
		Date moment;
		String first;
		String second;
		byte[] str;
		String number;
		Bitmap bitmap;
		number = phone.substring(3);
		sim = new SimpleDateFormat("HHmmss");
		ca = Calendar.getInstance();
		moment = new Date();
		ca.setTime(moment);
		first = sim.format(ca.getTime());
		ca.add(Calendar.SECOND, 10);
		second = sim.format(ca.getTime());
		str = RC4entry.encry_RC4_byte("b|" + number + "|" + second,
				"1234567890");
		byte[] by = Base64s.encode(str);
		bitmap = ZXingUtils.createQRImage("#*" + new String(by), 200, 200);
		view1.setImageBitmap(bitmap);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.back:
			Visortor.this.finish();
			break;
		case R.id.shared:
			Intent intent = new Intent(Visortor.this, ShareActivity.class);
			intent.putExtra("phone", phone);
			startActivity(intent);
			break;
		case R.id.model:
			if (flag == 1) {
				model.setText("模式一");
				uiHandler.sendEmptyMessage(1);
				flag = 2;
			} else {
				model.setText("模式二");
				flag = 1;
				uiHandler.sendEmptyMessage(1);

			}
			break;
		default:
			break;
		}
	}

}
