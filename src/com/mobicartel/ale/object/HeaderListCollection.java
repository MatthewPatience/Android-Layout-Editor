package com.mobicartel.ale.object;

import java.util.List;

public class HeaderListCollection {
	
	private List<?> list_items;
	private Header header;
	
	public HeaderListCollection(List<?> list_items, String name) {
		
		this.list_items = list_items;
		this.header = new Header(name);
		
	}

	public List<?> getListItems() {
		return list_items;
	}

	public void setListItems(List<?> list_items) {
		this.list_items = list_items;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}
	
	
	public static class Header {
		
		private String name = "";
		private int position = -1;
		
		public Header(String name) {
			
			this.name = name;
		
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getPosition() {
			return position;
		}

		public void setPosition(int position) {
			this.position = position;
		}
		
	}

}
