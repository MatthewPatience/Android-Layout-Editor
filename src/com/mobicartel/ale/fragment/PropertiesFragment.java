package com.mobicartel.ale.fragment;

import java.util.ArrayList;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.mobicartel.ale.MainActivity;
import com.mobicartel.ale.R;
import com.mobicartel.ale.adapter.PropertiesAdapter;
import com.mobicartel.ale.object.Component;
import com.mobicartel.ale.object.HeaderListCollection;

public class PropertiesFragment extends Fragment implements OnClickListener {
	
	private ListView listview_props;
	private PropertiesAdapter adapter_props;
	private ViewSwitcher flipper_properties;
	private Button btn_outline;
	private Button btn_properties;
	private LinearLayout layout_outline;
	
	private int hierarchy_counter = 0;
	private ArrayList<HeaderListCollection> list_items;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		list_items = new ArrayList<HeaderListCollection>();
		
		adapter_props = new PropertiesAdapter(getActivity(), new Component(new View(getActivity())), list_items);
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment_properties, container, false);
		
		listview_props = (ListView) view.findViewById(R.id.listview_props);
		listview_props.setAdapter(adapter_props);
		
		flipper_properties = (ViewSwitcher) view.findViewById(R.id.flipper_properties);
		flipper_properties.setInAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_in));
		flipper_properties.setOutAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_out));
		btn_outline = (Button) view.findViewById(R.id.btn_outline);
		btn_outline.setOnClickListener(this);
		btn_properties = (Button) view.findViewById(R.id.btn_properties);
		btn_properties.setOnClickListener(this);
		layout_outline = (LinearLayout) view.findViewById(R.id.layout_outline);
		
        return view;
    }
	
	public void updateOutline() {
		
		layout_outline.removeAllViews();
		
		Component base_component = ((MainActivity) getActivity()).component;
		printComponentToOutline(base_component);
		
		//reset to zero for next redraw
		hierarchy_counter = 0;
		
	}
	
	private void printComponentToOutline(final Component component) {
		
		TextView txtview = new TextView(getActivity());
		txtview.setBackgroundResource(android.R.drawable.list_selector_background);
		txtview.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
		txtview.setTextColor(Color.WHITE);
		String id = "";
		if (component.getViewProps().id.getValue() != null) {
			id = component.getViewProps().id.getValue();
		}
		txtview.setText(" - " + id + "(" + component.getViewType().title + ")");
		txtview.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				createProperties(component);
			}
		});
		txtview.setPadding((hierarchy_counter*20), 5, 10, 5);
		layout_outline.addView(txtview);
		
		//Print children recursively
		ArrayList<Component> list_children = component.getListChildren();
		if (list_children.size() != 0) {
			hierarchy_counter++;
	        for (Component child : list_children) {
	        	printComponentToOutline(child);
	        }
		}
		
	}
	
	public void createProperties(Component component) {
		
		list_items.clear();
		
		HeaderListCollection view_header = new HeaderListCollection(component.getViewProps().list_properties, component.getViewType().title + " Properties");
		list_items.add(view_header);
		
		HeaderListCollection layout_header = null;
		if (component.getParentType() != null) {
			layout_header = new HeaderListCollection(component.getLayoutProps().list_properties, "Layout Properties");
			list_items.add(layout_header);
		}
		
		adapter_props.updateItems(list_items);
		adapter_props.updateComponent(component);
		
		flipper_properties.setDisplayedChild(1);
		listview_props.smoothScrollToPosition(0);
		
	}

	public void onClick(View view) {
		
		switch(view.getId()) {
		case(R.id.btn_outline):
			if (flipper_properties.getDisplayedChild() != 0) {
				flipper_properties.setDisplayedChild(0);
			}
			break;
		case(R.id.btn_properties):
			if (flipper_properties.getDisplayedChild() != 1) {
				flipper_properties.setDisplayedChild(1);
			}
			break;
		}
		
	}

}
