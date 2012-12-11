package com.mobicartel.ale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class XmlPreviewActivity extends Activity implements OnClickListener {
	
	private TextView txt_preview;
	private Button btn_send;
	
	private String preview_text = "";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_xml_preview);
		
		init();
		
	}
	
	private void init() {
		
		txt_preview = (TextView) findViewById(R.id.txt_preview);
		btn_send = (Button) findViewById(R.id.btn_send);
		btn_send.setOnClickListener(this);
		
		preview_text = getIntent().getStringExtra("PREVIEW");
		txt_preview.setText(preview_text);
		
	}

	public void onClick(View view) {
		
		switch(view.getId()) {
		case(R.id.btn_send):
			Intent share_intent = new Intent(android.content.Intent.ACTION_SEND);
			share_intent.setType("text/plain");
			share_intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "ALE Layout File");
			share_intent.putExtra(android.content.Intent.EXTRA_TEXT, preview_text + "\n\n\n Created using ALE");
			startActivity(Intent.createChooser(share_intent, "Send via..."));
			break;
		}
		
	}
	
	

}
