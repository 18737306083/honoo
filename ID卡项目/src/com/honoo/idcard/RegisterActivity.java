package com.honoo.idcard;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.smssdk.EventHandler;
import cn.smssdk.OnSendMessageHandler;
import cn.smssdk.SMSSDK;

import com.example.idcard.R;
import com.honoo.service.PersonInfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity implements OnClickListener {
	private Button next;
	private Button yan;
	private EditText number;
	private EditText inputCode;
	private ImageView back;
	private Timer timer;

	private TextView view;
	private int time = 60;
	final DaoService daoservice = new DaoService(this, "idcard.db3", 1);
	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			if (msg.what == 0) {
				// /Toast.makeText(RegisterActivity.this, "已注册",
				// Toast.LENGTH_SHORT).show();
				view.setText("");
				view.setVisibility(0);
				view.setText("已注册");

			} else if (msg.what == -1) {
				view.setText("");
				view.setVisibility(0);
				view.setText("已发送");
				/*
				 * for (int i = 60; i >0; i--) { view.setText("已发送"+i); try {
				 * 
				 * } catch (Exception e) { // TODO Auto-generated catch block
				 * e.printStackTrace(); } }
				 */
				// Toast.makeText(RegisterActivity.this, "已发送",
				// Toast.LENGTH_SHORT).show();
				/*
				 * timer = new Timer(); timer.schedule(new TimerTask() {
				 * 
				 * @Override public void run() { // TODO Auto-generated method
				 * stub time--;
				 * 
				 * handler.sendEmptyMessage(3);
				 * 
				 * } }, 100,1000);
				 */
			} else if (msg.what == 20) {
				// timer.cancel();
				view.setText("");

				view.setVisibility(0);
				view.setText("验证失败");
			} else if (msg.what == 21) {
				view.setText("");
				view.setVisibility(0);
				view.setText("验证成功");

			} else if (msg.what == 3) {

				if (time > 0) {

					view.setText(time + "秒后重新发送");

				} else {
					timer.cancel();
					view.setText("");
				}

			}

		}
	};

	private static final String[] AVATARS = {
			"http://tupian.qqjay.com/u/2011/0729/e755c434c91fed9f6f73152731788cb3.jpg",
			"http://99touxiang.com/public/upload/nvsheng/125/27-011820_433.jpg",
			"http://img1.touxiang.cn/uploads/allimg/111029/2330264224-36.png",
			"http://img1.2345.com/duoteimg/qqTxImg/2012/04/09/13339485237265.jpg",
			"http://diy.qqjay.com/u/files/2012/0523/f466c38e1c6c99ee2d6cd7746207a97a.jpg",
			"http://img1.touxiang.cn/uploads/20121224/24-054837_708.jpg",
			"http://img1.touxiang.cn/uploads/20121212/12-060125_658.jpg",
			"http://img1.touxiang.cn/uploads/20130608/08-054059_703.jpg",
			"http://diy.qqjay.com/u2/2013/0422/fadc08459b1ef5fc1ea6b5b8d22e44b4.jpg",
			"http://img1.2345.com/duoteimg/qqTxImg/2012/04/09/13339510584349.jpg",
			"http://img1.touxiang.cn/uploads/20130515/15-080722_514.jpg",
			"http://diy.qqjay.com/u2/2013/0401/4355c29b30d295b26da6f242a65bcaad.jpg" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		next = (Button) findViewById(R.id.next);
		yan = (Button) findViewById(R.id.yan);
		number = (EditText) findViewById(R.id.Phone);
		inputCode = (EditText) findViewById(R.id.inputCode);
		back = (ImageView) findViewById(R.id.back);
		view = (TextView) findViewById(R.id.view);
		next.setOnClickListener(this);
		yan.setOnClickListener(this);
		back.setOnClickListener(this);
		EventHandler event = new EventHandler() {
			@Override
			public void afterEvent(int arg0, int arg1, Object arg2) {
				// TODO Auto-generated method stub
				super.afterEvent(arg0, arg1, arg2);

				if (arg0 == SMSSDK.EVENT_GET_VERIFICATION_CODE) {

					System.out.println("iiiiiiiiiiiii");
					System.out.println(arg1);
					if (arg1 == 0) {
						Toast.makeText(RegisterActivity.this, "已注册",
								Toast.LENGTH_SHORT).show();
						// inputCode.setText("已注册");
						handler.sendEmptyMessage(arg1);
					} else if (arg1 == -1) {
						// inputCode.setText("已发送");
						Toast.makeText(RegisterActivity.this, "已发送",
								Toast.LENGTH_SHORT).show();
						handler.sendEmptyMessage(arg1);
					}
				}
				if (arg0 == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
					System.out.println("jjjjjjjjjjjjjjjjj");
					System.out.println(arg1);

					if (arg1 == 0) {
						// Toast.makeText(RegisterActivity.this, "验证码不正确",
						// Toast.LENGTH_SHORT).show();
						handler.sendEmptyMessage(20);

					} else if (arg1 == -1) {
						handler.sendEmptyMessage(21);
						Intent intent = new Intent(RegisterActivity.this,
								RegisPersonActivity.class);
						// Bundle bundle = new Bundle();
						intent.putExtra("number", number.getText().toString());

						startActivity(intent);
						// Toast.makeText(RegisterActivity.this, "验证成功",
						// Toast.LENGTH_SHORT).show();

					}
					/*
					 * Toast.makeText( MsgActivity.this, arg1,
					 * Toast.LENGTH_SHORT).show();
					 */
				}
			}
		};
		SMSSDK.registerEventHandler(event);

		// 注册监听器
		/* SMSSDK.registerEventHandler(eventHandler); */

	}

	@SuppressWarnings("unused")
	private void registerUser(String country, String phone) {
		Random rnd = new Random();
		int id = Math.abs(rnd.nextInt());
		String uid = String.valueOf(id);
		String nickName = "SmsSDK_User_" + uid;
		String avatar = AVATARS[id % 12];
		SMSSDK.submitUserInfo(uid, nickName, avatar, country, phone);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.next:
			if (number.getText().toString().equals("")) {
				Toast.makeText(RegisterActivity.this, "请输入账号!",
						Toast.LENGTH_SHORT).show();
				return;

			}
			String regExp1 = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
			Pattern p1 = Pattern.compile(regExp1);
			Matcher m1 = p1.matcher(number.getText().toString().trim());
			if (!m1.matches()) {
				Toast.makeText(RegisterActivity.this, "请正确输入账号!",
						Toast.LENGTH_SHORT).show();

				return;
			}

			String password1 = PersonInfo.selectPerson(daoservice
					.getReadableDatabase(), number.getText().toString());
			if (!password1.equals("")) {
				Toast.makeText(RegisterActivity.this, "账号已注册!",
						Toast.LENGTH_SHORT).show();

				return;
			}

			SMSSDK.submitVerificationCode("+86", number.getText().toString()
					.trim(), inputCode.getText().toString().trim());

			break;
		case R.id.yan:
			if (number.getText().toString().equals("")) {
				Toast.makeText(RegisterActivity.this, "请输入账号!",
						Toast.LENGTH_SHORT).show();
				return;

			}
			String regExp11 = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
			Pattern p11 = Pattern.compile(regExp11);
			Matcher m11 = p11.matcher(number.getText().toString().trim());
			if (!m11.matches()) {
				Toast.makeText(RegisterActivity.this, "请正确输入账号!",
						Toast.LENGTH_SHORT).show();

				return;
			}

			try {
				registerUser("+86", number.getText().toString().trim());
				SMSSDK.getVerificationCode("+86", number.getText().toString()
						.trim(), new OnSendMessageHandler() {

					@Override
					public boolean onSendMessage(String arg0, String arg1) {
						// TODO Auto-generated method stub
						System.out.println(arg1);
						return false;
					}
				});

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("有异常");
			}

			break;
		case R.id.back:
			RegisterActivity.this.finish();
			break;
		default:
			break;
		}
	}

}
