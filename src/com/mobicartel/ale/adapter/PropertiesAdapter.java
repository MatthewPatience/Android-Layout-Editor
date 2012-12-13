package com.mobicartel.ale.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mobicartel.ale.BasePropertyEditDialog;
import com.mobicartel.ale.R;
import com.mobicartel.ale.object.Component;
import com.mobicartel.ale.object.HeaderListCollection;
import com.mobicartel.ale.properties.XmlSerializableProperty;
import com.mobicartel.ale.util.InputMethod;
import android.content.*;

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
		
		TextView txt_value = (TextView) view.findViewById(R.id.txt_value);
		txt_value.setText(property.getValue());
		
		Button btn_edit = (Button) view.findViewById(R.id.btn_edit);
		btn_edit.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				
				displayEditDialog(property.getInputMethod(), property);
				
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
	
	private void displayEditDialog(InputMethod input, XmlSerializableProperty property) {
		
		if (input == null) {
			Toast.makeText(context, "No editor input method available for this property", Toast.LENGTH_SHORT).show();
			return;
		}
		
		try {
			BasePropertyEditDialog dialog = input.clazz.getConstructor(Context.class, XmlSerializableProperty.class, Component.class)
					.newInstance(context, property, component);
			dialog.show();
			dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
				@Override
				public void onDismiss(DialogInterface dialog) {
					PropertiesAdapter.this.notifyDataSetChanged();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(context, "An error occured while trying to open the editor, please let the developer know", Toast.LENGTH_LONG).show();
		}
		
	}

}
