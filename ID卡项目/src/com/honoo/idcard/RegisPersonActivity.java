package com.honoo.idcard;

import com.example.idcard.R;
import com.honoo.service.RegisterService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisPersonActivity extends Activity {
	private Button submit;
	private RadioGroup sex;
	private EditText userName;
	private EditText userPassword1;
	private EditText userPassword2;
	private EditText userPhone;
	private RadioButton check;
	private String number;
	private ImageView back;
	final DaoService daoservice = new DaoService(this, "idcard.db3", 1);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.person);
		submit = (Button) findViewById(R.id.submit);
		sex = (RadioGroup) findViewById(R.id.sex);
		userName = (EditText) findViewById(R.id.username);
		userPhone = (EditText) findViewById(R.id.userPhone);
		userPassword1 = (EditText) findViewById(R.id.userPassWord1);
		userPassword2 = (EditText) findViewById(R.id.userPassWord2);
		number = getIntent().getStringExtra("number");
		back = (ImageView) findViewById(R.id.back);
		userPhone.setText(number);
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				RegisPersonActivity.this.finish();
			}
		});
		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (userName.getText().toString().equals("")
						|| userPassword1.getText().toString().equals("")) {
					Toast.makeText(RegisPersonActivity.this, "请正确填写!",
							Toast.LENGTH_SHORT).show();

					return;

				}
				if (RegisterService.checkPassword(userPassword1.getText()
						.toString(), userPassword2.getText().toString())) {

					check = (RadioButton) findViewById(sex
							.getCheckedRadioButtonId());
					System.out.println(check.getText());
					System.out.println(number);
					RegisterService.insertUser(
							daoservice.getWritableDatabase(), userName
									.getText().toString(), userPassword1
									.getText().toString(), check.getText()
									.toString(), number);
					Toast.makeText(RegisPersonActivity.this, "注册成功!",
							Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(RegisPersonActivity.this,
							LoginActivity.class);

					startActivity(intent);
					RegisPersonActivity.this.finish();
				} else {

					Toast.makeText(RegisPersonActivity.this, "两次密码输入不一致",
							Toast.LENGTH_SHORT).show();
					return;
				}
			}
		});

	}
}
