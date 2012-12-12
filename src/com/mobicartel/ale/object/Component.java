package com.mobicartel.ale.object;

import java.util.ArrayList;

import com.mobicartel.ale.constants.ParentType;
import com.mobicartel.ale.constants.ViewType;
import com.mobicartel.ale.properties.params.LayoutParamsProperties;
import com.mobicartel.ale.properties.view.ViewProperties;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class Component {

	private ViewProperties view_props;
	private LayoutParamsProperties layout_props;
	private View view;
	private Component parent;
	private ArrayList<Component> list_children;
	
	public Component(View view) {
		
		this.view = view;
		LayoutParams params = view.getLayoutParams();
		if (params == null) {
			params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		}
		ViewType type = getViewType();
		view_props = type.props;
		setListChildren(new ArrayList<Component>());
		
	}
	
	public ViewProperties getViewProps() {
		return view_props;
	}
	public void setViewProps(ViewProperties view_props) {
		this.view_props = view_props;
	}
	public LayoutParamsProperties getLayoutProps() {
		return layout_props;
	}
	public void setLayoutProps(LayoutParamsProperties layout_props) {
		this.layout_props = layout_props;
	}
	public View getView() {
		return view;
	}
	public void setView(View view) {
		this.view = view;
	}
	public Component getParent() {
		return parent;
	}
	public void setParent(Component parent) {
		this.parent = parent;
		ParentType type = getParentType();
		layout_props = type.getProperties();
		((ViewGroup) parent.getView()).addView(view);
	}
	
	public ParentType getParentType() {
		
		if (parent == null) {
			return null;
		}
		
		for (int i = 0; i < ParentType.values().length; i++) {
			if (ParentType.values()[i].view.isInstance(parent.getView())) {
				return ParentType.values()[i];
			}
		}
		
		return null;
		
	}
	
	public ViewType getViewType() {
		
		for (int i = 0; i < ViewType.values().length; i++) {
			if (ViewType.values()[i].view.isInstance(view)) {
				return ViewType.values()[i];
			}
		}
		
		return null;
		
	}

	public ArrayList<Component> getListChildren() {
		return list_children;
	}

	public void setListChildren(ArrayList<Component> list_children) {
		this.list_children = list_children;
	}
	
	public void addChild(Component component) {
		list_children.add(component);
		component.setParent(this);
	}
	
	public void addChild(int position, Component component) {
		list_children.add(component);
	}
	
	public void removeChild(Component component) {
		list_children.remove(component);
	}
	
	public void removeChild(int position) {
		list_children.remove(position);
	}
	
	
}
