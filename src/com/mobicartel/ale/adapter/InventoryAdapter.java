package com.mobicartel.ale.adapter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import android.content.ClipData;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.mobicartel.ale.constants.ViewType;

public class InventoryAdapter extends BaseAdapter {
	
	private Context context;
	private ArrayList<ViewType> list_views;
	
	private LinearLayout.LayoutParams view_params;

	public InventoryAdapter(Context context) {
		
		this.context = context;
		
		view_params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		view_params.setMargins(15, 15, 15, 15);
		
		list_views = new ArrayList<ViewType>();
		ViewType[] arr_viewtypes = ViewType.values();
		for (int i = 0; i < arr_viewtypes.length; i++) {
			ViewType view_type = arr_viewtypes[i];
			if (!view_type.viewgroup) list_views.add(view_type);
		}
		
	}
	
	public int getCount() {
		
		if (list_views == null) {
			return 0;
		}
		
		return list_views.size();
	}

	public Object getItem(int position) {
		
		return list_views.get(position);
	}

	public long getItemId(int position) {
		
		return 0;
	}

	public View getView(int position, View convert_view, ViewGroup parent) {
		
		LinearLayout layout_bg = (LinearLayout) convert_view;
		
		if (convert_view == null) {
			layout_bg = new LinearLayout(context);
			layout_bg.setGravity(Gravity.CENTER);
		}
		
		layout_bg.removeAllViews();
		
		try {
			final ViewType view_type = list_views.get(position);
			final View view = view_type.getComponent(context).getView();
			view.setOnLongClickListener(new OnLongClickListener() {
				@Override
				public boolean onLongClick(View view) {
					
					ClipData.Item item = new ClipData.Item(view_type.name());
				    ClipData drag_data = new ClipData("VIEW_TYPE", new String[] {"text/plain"}, item);
				    view.startDrag(drag_data, new View.DragShadowBuilder(view), null, 0);
				    
				    return true;
				}
			});
			layout_bg.addView(view, view_params);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return layout_bg;
	}
	
	

}
