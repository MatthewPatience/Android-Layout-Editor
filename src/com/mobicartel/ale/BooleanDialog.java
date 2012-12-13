package com.mobicartel.ale;



import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import com.mobicartel.ale.object.*;
import com.mobicartel.ale.properties.*;

public class BooleanDialog extends BasePropertyEditDialog implements View.OnClickListener {

	private static final int ID_TRUE = 5845;
	private static final int ID_FALSE = 3309;
	
	public BooleanDialog(Context context, XmlSerializableProperty property, Component component) {
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
		Button btn_true = new Button(getContext());
		btn_true.setId(ID_TRUE);
		btn_true.setText("TRUE");
		btn_true.setOnClickListener(this);
		Button btn_false = new Button(getContext());
		btn_false.setText("FALSE");
		btn_false.setId(ID_FALSE);
		btn_false.setOnClickListener(this);
		
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		params.weight = 1.0f;
		layout_bg.addView(btn_true, params);
		layout_bg.addView(btn_false, params);
		
		setContentView(layout_bg);
		
	}
	
	@Override
	public void onClick(View view) {
		
		switch (view.getId()) {
		case ID_TRUE:
			setPropertyValue("true");
			this.dismiss();
			break;
		case ID_FALSE:
			setPropertyValue("false");
			this.dismiss();
			break;
		}
		
	}

}
