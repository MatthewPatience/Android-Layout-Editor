package com.mobicartel.ale;

import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import com.mobicartel.ale.object.*;
import com.mobicartel.ale.properties.*;

public class StringDialog extends BasePropertyEditDialog implements View.OnClickListener {

	private static final int ID_DONE = 4771;

	private EditText txtbox_text;
	private Button btn_done;

	public StringDialog(Context context, XmlSerializableProperty property, Component component) {
		super(context, property, component);

	}

	@Override
	public void onCreate(Bundle state) {
		super.onCreate(state);
		setContentView(R.layout.dialog_dimensions);

		initUi();

	}

	private void initUi() {

		LinearLayout layout_bg = new LinearLayout(getContext());
		layout_bg.setOrientation(LinearLayout.HORIZONTAL);
				

		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		txtbox_text = new EditText(getContext());
		
		btn_done = new Button(getContext());
		btn_done.setId(ID_DONE);
		btn_done.setOnClickListener(this);
		
		layout_bg.addView(txtbox_text, params);
		
		setContentView(layout_bg);

	}

	@Override
	public void onClick(View view) {
		
		switch (view.getId()) {
		case ID_DONE:
			setPropertyValue(txtbox_text.getText().toString());
			this.dismiss();
			break;
		}
		
	}
	
}
