package com.mobicartel.ale.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.mobicartel.ale.object.HeaderListCollection;
import com.mobicartel.ale.object.HeaderListCollection.Header;

/**
 * This class creates an adapter for a ListView that supports headers to identify sections of the data. 
 * To use the class you must first create your own class and extend this class. You must also override 
 * both the getNormalRowView() and getHeaderRowView() methods (see method descriptions). 
 * Then create HeaderListCollection Objects for all of the sections of your data. 
 * A HeaderListCollection contains a Header object and a List of Objects. Once you have created 
 * HeaderListCollection Objects for all your sections, add them to an ArrayList and pass to the 
 * constructor.
 * 
 * @author Matthew Patience
 * @since 04-05-2012
 */
public abstract class AbsHeaderListAdapter extends BaseAdapter {

	private ArrayList<HeaderListCollection> lists_items;
	private ArrayList<Header> list_headers;
	private Context context;

	/**
	 * Creates an instance of a HeaderListAdapter.
	 * @param context Context is required for the creation of Views
	 * @param lists_items An ArrayList of HeaderListCollection Objects. A HeaderListCollection 
	 * contains both a Header object and a List of Objects to be displayed in the adapter.
	 */
	public AbsHeaderListAdapter(Context context, ArrayList<HeaderListCollection> lists_items) {

		this.lists_items = lists_items;
		
		list_headers = new ArrayList<Header>(this.lists_items.size());
		int position_counter = 0;
		for (int i = 0; i < this.lists_items.size(); i++) {
			HeaderListCollection collection = this.lists_items.get(i);
			Header header = collection.getHeader();
			
			header.setPosition(position_counter);

			position_counter += collection.getListItems().size();

			list_headers.add(header);
		}
		
		this.context = context;

	}

	public int getCount() {
		
		int count = 0;
		for (int i = 0; i < lists_items.size(); i++) {
			List<?> collection = lists_items.get(i).getListItems();
			if (collection != null) {
				count += collection.size();
			}
		}
		
		return count;
	}
	
	public Object getItem(int position) {

		int position_counter = 0;
		for (int i = 0; i < lists_items.size(); i++) {
			HeaderListCollection collection = lists_items.get(i);
			List<?> list_items = collection.getListItems();
			if (position < (list_items.size() + position_counter)) {
				return list_items.get(position - position_counter);
			}

			position_counter += list_items.size();
		}

		return null;
	}

	public long getItemId(int position) {

		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		LinearLayout layout_bg = new LinearLayout(context);
		layout_bg.setOrientation(LinearLayout.VERTICAL);
		
		View view_row = getNormalRowView(getItem(position));
		
		View view_header = null;
		for (int i = 0; i < list_headers.size(); i++) {
			Header header = list_headers.get(i);
			if (position == header.getPosition()) {
				view_header = getHeaderRowView(header.getName());
				break;
			}
		}
		
		if (view_header != null) {
			layout_bg.addView(view_header);
		}
		
		layout_bg.addView(view_row);

		return layout_bg;
	}
	
	public void updateItems(ArrayList<HeaderListCollection> lists_items) {
		
		this.lists_items = lists_items;
		list_headers.clear();
		
		int position_counter = 0;
		for (int i = 0; i < this.lists_items.size(); i++) {
			HeaderListCollection collection = this.lists_items.get(i);
			Header header = collection.getHeader();
			
			header.setPosition(position_counter);

			position_counter += collection.getListItems().size();

			list_headers.add(header);
		}
		
		this.notifyDataSetChanged();
		
	}
	
	/**
	 * Override and return the view which you want to displayed for your regular row items.
	 * @param object The object for the current position in the adapter being populated
	 * @return Normal view for a row in the adapter
	 */
	public abstract View getNormalRowView(Object object);
	
	/**
	 * Override and return the view which you want to displayed for your headers in the adapter.
	 * @param object The name of the current header to be displayed in the view
	 * @return Header view in the adapter
	 */
	public abstract View getHeaderRowView(String name);

}
