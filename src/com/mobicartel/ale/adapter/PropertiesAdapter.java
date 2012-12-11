package com.mobicartel.ale.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mobicartel.ale.R;
import com.mobicartel.ale.object.Component;
import com.mobicartel.ale.object.HeaderListCollection;
import com.mobicartel.ale.properties.XmlSerializableProperty;

public class PropertiesAdapter extends AbsHeaderListAdapter {
	
	private LayoutInflater inflater;
	private Component component;
	private Context context;

	public PropertiesAdapter(Context context, Component component, ArrayList<HeaderListCollection> lists_items) {
		super(context, lists_items);
		
		this.context = context;
		this.component =  component;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
	}

	@Override
	public View getNormalRowView(Object object) {
		
		View view = inflater.inflate(R.layout.item_row_property, null);
		
		
		final XmlSerializableProperty property = (XmlSerializableProperty) object;
		
		TextView txt_name = (TextView) view.findViewById(R.id.txt_name);
		txt_name.setText(property.getName());
		
		final EditText txtbox_value = (EditText) view.findViewById(R.id.txtbox_value);
		txtbox_value.setText(property.getValue());
		
		Button btn_save = (Button) view.findViewById(R.id.btn_save);
		btn_save.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				try {
					property.setValue(txtbox_value.getText().toString());
					property.updateView(component.getView());
					component.getView().invalidate();
				} catch (IllegalArgumentException e) {
					if (e.getMessage() != null) {
						Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
					} else {
						Toast.makeText(context, "Invalid Property", Toast.LENGTH_SHORT).show();
					}
				} catch (NullPointerException e) {
					e.printStackTrace();
					Toast.makeText(context, "An Error Occured", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		
		return view;
	}

	@Override
	public View getHeaderRowView(String name) {
		
		View view = inflater.inflate(R.layout.item_row_header, null);
		
		TextView txt_name = (TextView) view.findViewById(R.id.txt_name);
		txt_name.setText(name);
		
		return view;
	}
	
	public void updateComponent(Component component) {
		
		this.component = component;
		
	}

}
