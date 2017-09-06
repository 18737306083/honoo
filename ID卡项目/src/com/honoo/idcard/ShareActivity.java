package com.honoo.idcard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import cn.sharesdk.onekeyshare.OnekeyShare;

import com.example.idcard.R;
import com.honoo.erweima.ZXingUtils;
import com.honoo.service.Base64s;
import com.honoo.service.RC4entry;

import datetime.pick.CustomDatePicker;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ShareActivity extends Activity implements View.OnClickListener {
	private Button shared;
	private RelativeLayout selectDate, selectTime;
	private TextView currentDate1, currentTime;
	private CustomDatePicker customDatePicker1, customDatePicker2;
	private ImageView hidebitmap;
	private String phone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.share);
		shared = (Button) findViewById(R.id.shared1);
		hidebitmap = (ImageView) findViewById(R.id.hidebitmap);
		selectTime = (RelativeLayout) findViewById(R.id.selectTime);
		selectTime.setOnClickListener(this);
		selectDate = (RelativeLayout) findViewById(R.id.selectDate);
		selectDate.setOnClickListener(this);
		currentDate1 = (TextView) findViewById(R.id.currentDate1);
		currentTime = (TextView) findViewById(R.id.currentTime);
		Intent intent = getIntent();
		phone = intent.getStringExtra("phone");
		initDatePicker();
		shared.setOnClickListener(this);

	}

	private void showShare() {

		OnekeyShare oks = new OnekeyShare();
		// 关闭sso授权
		oks.disableSSOWhenAuthorize();

		// 分享时Notification的图标和文字 2.5.9以后的版本不 调用此方法
		// oks.setNotification(R.drawable.ic_launcher,
		// getString(R.string.app_name));
		// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
		oks.setTitle("花偌实创");
		// titleUrl是标题的网络链接，仅在人人网和QQ空间使用
		oks.setTitleUrl("http://sharesdk.cn");
		// text是分享文本，所有平台都需要这个字段
		oks.setText("二维码");
		// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
		// oks.setImagePath("");//确保SDcard下面存在此张图片
		oks.setViewToShare(hidebitmap);
		// url仅在微信（包括好友和朋友圈）中使用
		// oks.setUrl("http://sharesdk.cn");
		// comment是我对这条分享的评论，仅在人人网和QQ空间使用
		// oks.setComment("我是测试评论文本");
		// site是分享此内容的网站名称，仅在QQ空间使用
		// oks.setSite(getString(R.string.app_name));
		// siteUrl是分享此内容的网站地址，仅在QQ空间使用
		oks.setSiteUrl("http://sharesdk.cn");

		// 启动分享GUI
		oks.show(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.selectDate:
			// 鏃ユ湡鏍煎紡涓簓yyy-MM-dd
			/* customDatePicker1.show(currentDate.getText().toString()); */
			customDatePicker2.show(currentTime.getText().toString());
			break;

		case R.id.selectTime:
			// 鏃ユ湡鏍煎紡涓簓yyy-MM-dd HH:mm
			customDatePicker2.show(currentTime.getText().toString());
			break;
		case R.id.shared1:
			String time1 = currentDate1.getText().toString().trim();
			String time2 = currentTime.getText().toString().trim();
			SimpleDateFormat simple1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			SimpleDateFormat simple2 = new SimpleDateFormat("ddHHmmss");
			Bitmap bitmap;
			/* String time1Str=simple.parse(time1); */
			/* simple.format() */

			try {
				String begin = simple2.format(simple1.parse(time1));
				String end = simple2.format(simple1.parse(time2));
				System.out.println(begin + phone);

				byte[] str1 = RC4entry.encry_RC4_byte("c|" + phone.substring(3)
						+ "|" + begin + "|" + end, "1234567890");
				// System.out.println(str);
				// Base64s.encode(str);

				byte[] by = Base64s.encode(str1);

				// System.out.println(number+first+second+str);

				bitmap = ZXingUtils.createQRImage("#*" + new String(by), 300,
						300);
				hidebitmap.setImageBitmap(bitmap);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			showShare();

			break;
		}
	}

	private void initDatePicker() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm",
				Locale.CHINA);
		Calendar calen = Calendar.getInstance();
		calen.add(Calendar.YEAR, 10);
		String now1 = sdf.format(new Date());
		String now = sdf.format(calen.getTime());
		currentDate1.setText(now1);
		currentTime.setText(now1);

		customDatePicker1 = new CustomDatePicker(this,
				new CustomDatePicker.ResultHandler() {
					@Override
					public void handle(String time) { // 鍥炶皟鎺ュ彛锛岃幏寰楅�変腑鐨勬椂闂�
						currentDate1.setText(time);
					}
				}, "2017-01-01 00:00", now); // 鍒濆鍖栨棩鏈熸牸寮忚鐢細yyyy-MM-dd
												// HH:mm锛屽惁鍒欎笉鑳芥甯歌繍琛�
		customDatePicker1.showSpecificTime(true); // 涓嶆樉绀烘椂鍜屽垎
		customDatePicker1.setIsLoop(false);

		customDatePicker2 = new CustomDatePicker(this,
				new CustomDatePicker.ResultHandler() {
					@Override
					public void handle(String time) {
						currentTime.setText(time);
					}
				}, "2017-01-01 00:00", now);
		customDatePicker2.showSpecificTime(true);
		customDatePicker2.setIsLoop(true); //
	}

}
