package com.mobicartel.ale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DimensionActivity extends Activity implements OnClickListener {
	
	private static final int DIMENSION_DP = 0;
	private static final int DIMENSION_PX = 1;
	
	private Button btn_1;
	private Button btn_2;
	private Button btn_3;
	private Button btn_4;
	private Button btn_5;
	private Button btn_6;
	private Button btn_7;
	private Button btn_8;
	private Button btn_9;
	private Button btn_0;
	private Button btn_backspace;
	private Button btn_dp;
	private Button btn_px;
	private Button btn_done;
	private TextView txt_size;
	private TextView txt_dimension;
	
	private String size = "";
	
	@Override
	public void onCreate(Bundle state) {
		super.onCreate(state);
		setContentView(R.layout.dialog_dimensions);
		
		initUi();
		
	}
	
	private void initUi() {
		
		btn_1 = (Button) findViewById(R.id.btn_1);
		btn_1.setOnClickListener(this);
		btn_2 = (Button) findViewById(R.id.btn_2);
		btn_2.setOnClickListener(this);
		btn_3 = (Button) findViewById(R.id.btn_3);
		btn_3.setOnClickListener(this);
		btn_4 = (Button) findViewById(R.id.btn_4);
		btn_4.setOnClickListener(this);
		btn_5 = (Button) findViewById(R.id.btn_5);
		btn_5.setOnClickListener(this);
		btn_6 = (Button) findViewById(R.id.btn_6);
		btn_6.setOnClickListener(this);
		btn_7 = (Button) findViewById(R.id.btn_7);
		btn_7.setOnClickListener(this);
		btn_8 = (Button) findViewById(R.id.btn_8);
		btn_8.setOnClickListener(this);
		btn_9 = (Button) findViewById(R.id.btn_9);
		btn_9.setOnClickListener(this);
		btn_0 = (Button) findViewById(R.id.btn_0);
		btn_0.setOnClickListener(this);
		btn_backspace = (Button) findViewById(R.id.btn_backspace);
		btn_backspace.setOnClickListener(this);
		btn_dp = (Button) findViewById(R.id.btn_dp);
		btn_dp.setOnClickListener(this);
		btn_px = (Button) findViewById(R.id.btn_px);
		btn_px.setOnClickListener(this);
		btn_done = (Button) findViewById(R.id.btn_done);
		btn_done.setOnClickListener(this);
		txt_size = (TextView) findViewById(R.id.txt_size);
		txt_dimension = (TextView) findViewById(R.id.txt_dimension);
		
	}
	
	private void changeDimension(int dimension) {
		
		if (dimension == DIMENSION_DP) {
			txt_dimension.setText("dp");
		} else if (dimension == DIMENSION_PX) {
			txt_dimension.setText("px");
		}
		
	}

	private void appendToSize(int value) {
		
		size += value;
		txt_size.setText(size);
		
	}
	
	private void backspace() {
		
		size = size.substring(0, size.length()-1);
		txt_size.setText(size);
		
	}
	
	@Override
	public void onClick(View view) {
		
		switch (view.getId()) {
		case R.id.btn_1:
			appendToSize(1);
			break;
		case R.id.btn_2:
			appendToSize(2);
			break;
		case R.id.btn_3:
			appendToSize(3);
			break;
		case R.id.btn_4:
			appendToSize(4);
			break;
		case R.id.btn_5:
			appendToSize(5);
			break;
		case R.id.btn_6:
			appendToSize(6);
			break;
		case R.id.btn_7:
			appendToSize(7);
			break;
		case R.id.btn_8:
			appendToSize(8);
			break;
		case R.id.btn_9:
			appendToSize(9);
			break;
		case R.id.btn_0:
			appendToSize(0);
			break;
		case R.id.btn_backspace:
			backspace();
			break;
		case R.id.btn_dp:
			changeDimension(DIMENSION_DP);
			break;
		case R.id.btn_px:
			changeDimension(DIMENSION_PX);
			break;
		case R.id.btn_done:
			Intent intent = new Intent();
			intent.putExtra("SIZE", size + txt_dimension.getText());
			setResult(Activity.RESULT_OK, intent);
			finish();
			break;
		}
		
	}

}
