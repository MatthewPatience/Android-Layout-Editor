package com.mobicartel.ale.fragment;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mobicartel.ale.MainActivity;
import com.mobicartel.ale.R;
import com.mobicartel.ale.constants.ViewType;
import com.mobicartel.ale.object.Component;
import com.mobicartel.ale.object.DeviceConfig;
import com.mobicartel.ale.properties.view.LinearLayoutProperties;

public class LayoutFragment extends Fragment implements OnDragListener, OnClickListener {
	
	private ViewGroup layout_frame;
	private FrameLayout layout_bg;
	private Component layout_bg_component;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment_layout, container, false);
		
		layout_bg = (FrameLayout) view.findViewById(R.id.layout_bg);
		layout_bg.setOnDragListener(this);
		layout_bg.setOnClickListener(this);
		layout_bg_component = new Component(layout_bg);
		layout_frame = (LinearLayout) view.findViewById(R.id.layout_frame);
		
		LinearLayout layout = new LinearLayout(getActivity());
		layout.setOrientation(LinearLayout.VERTICAL);
		Component base_component = new Component(layout);
		((LinearLayoutProperties) base_component.getViewProps()).orientation.setValue("vertical");
		((LinearLayoutProperties) base_component.getViewProps()).orientation.updateView(base_component.getView());
		setBaseLayout(base_component);
		
        return view;
    }
	
	public void setDeviceConfig(final DeviceConfig config) {
		
		DisplayMetrics real_metrics = getResources().getDisplayMetrics();
		DisplayMetrics emulated_metrics = config.getDisplayMetrics();
		
		float conversion = emulated_metrics.density / real_metrics.density;
		int new_width = (int) (emulated_metrics.widthPixels / conversion);
		int new_height = (int) (emulated_metrics.heightPixels / conversion);
		layout_bg.getLayoutParams().width = new_width;
		layout_bg.getLayoutParams().height = new_height;
		layout_bg.requestLayout();
		layout_bg.invalidate();
		
	}
	
	public void setBaseLayout(Component new_root) {
		
		Component root = ((MainActivity) getActivity()).component;
		ArrayList<Component> list_children = null;
		
		if (root != null) {
			list_children = root.getListChildren();
			((ViewGroup) root.getView()).removeAllViews();
			root.setView(new_root.getView());
			root.setLayoutProps(new_root.getLayoutProps());
			root.setViewProps(new_root.getViewProps());
		} else {
			root = new_root;
		}
		
		root.setParent(layout_bg_component);
		
		if (list_children != null) {
			root.setListChildren(new ArrayList<Component>());
			for (int i = 0; i < list_children.size(); i++) {
				Component child = list_children.get(i);
				root.addChild(child);
			}
		}
		
		root.getLayoutProps().width.setValue("match_parent");
		root.getLayoutProps().width.updateView(root.getView());
		root.getLayoutProps().height.setValue("match_parent");
		root.getLayoutProps().height.updateView(root.getView());
		
		if (((MainActivity) getActivity()).fragment_properties != null) {
			((MainActivity) getActivity()).fragment_properties.updateOutline();
		}
		
		((MainActivity) getActivity()).component = root;
		
	}

	public boolean onDrag(View view, DragEvent event) {
		
		switch(view.getId()) {
		case(R.id.layout_bg):
			
			if (event.getAction() == DragEvent.ACTION_DRAG_ENTERED) {
				layout_frame.setBackgroundColor(0xff006400);
			} else if (event.getAction() == DragEvent.ACTION_DRAG_EXITED || event.getAction() == DragEvent.ACTION_DRAG_ENDED) {
				layout_frame.setBackgroundColor(Color.WHITE);
			} else if (event.getAction() == DragEvent.ACTION_DROP) {
				layout_frame.setBackgroundColor(Color.WHITE);
				try {
					addViewToLayout(event);
				} catch (Exception e) {
					e.printStackTrace();
					Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
				}
			}
			
			return true;
		}
		
		return false;
	}
	
	private void addViewToLayout(DragEvent event) throws IllegalArgumentException, SecurityException, java.lang.InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
		
		final Component child;
		Component root = ((MainActivity) getActivity()).component;
		
		String str_view_type = event.getClipData().getItemAt(0).getText().toString();
		ViewType view_type = ViewType.getViewType(str_view_type);
		child = view_type.getComponent(getActivity(), true);
		child.getView().setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				((MainActivity) getActivity()).fragment_properties.createProperties(child);
			}
		});
		child.getView().setOnLongClickListener(new OnLongClickListener() {
			@Override
			public boolean onLongClick(View view) {
				displayChildOptionsDialog(child);
				return false;
			}
		});
		root.addChild(child);
		((MainActivity) getActivity()).fragment_properties.updateOutline();
		
	}

	public void onClick(View view) {
		
		switch(view.getId()) {
		case(R.id.layout_bg):
			((MainActivity) getActivity()).fragment_properties.createProperties(((MainActivity) getActivity()).component);
			break;
		}
		
	}
	
	private void displayChildOptionsDialog(final Component component) {
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("View Options");
		String[] options = new String[] { "Delete" };
		builder.setItems(options, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Component parent = component.getParent();
				((ViewGroup) parent.getView()).removeView(component.getView());
				parent.removeChild(component);
				((MainActivity) getActivity()).fragment_properties.updateOutline();
			}
		});
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});
		AlertDialog dialog = builder.create();
		dialog.show();
		
	}

}