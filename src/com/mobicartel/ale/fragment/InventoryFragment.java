package com.mobicartel.ale.fragment;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.mobicartel.ale.MainActivity;
import com.mobicartel.ale.R;
import com.mobicartel.ale.XmlPreviewActivity;
import com.mobicartel.ale.adapter.InventoryAdapter;
import com.mobicartel.ale.object.Component;
import com.mobicartel.ale.util.XmlLayoutFactory;

public class InventoryFragment extends Fragment implements OnClickListener {
	
	private View view;
	private ListView listview;
	private Button btn_export;
	
	private InventoryAdapter adapter;
	private ProgressDialog loading_dialog;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
		
		view = inflater.inflate(R.layout.fragment_inventory, container, false);
		
		listview = (ListView) view.findViewById(R.id.listview);
		
		adapter = new InventoryAdapter(getActivity());
		listview.setAdapter(adapter);
		
		btn_export = (Button) view.findViewById(R.id.btn_export);
		btn_export.setOnClickListener(this);
		
        return view;
    }

	@Override
	public void onClick(View view) {
		
		switch(view.getId()) {
		case(R.id.btn_export):
			loading_dialog = ProgressDialog.show(getActivity(), "Please Wait", "Creating XML from layout...");
			new CreateXmlTask().execute(((MainActivity) getActivity()).component);
			break;
		}
		
	}
	
	private class CreateXmlTask extends AsyncTask<Component, Void, String> {
		
		private boolean error = false;
		
		@Override
		public String doInBackground(Component... params) {
			
			String preview = "";
			
			try {
				preview = XmlLayoutFactory.writeXml(params[0]);
			} catch (XmlPullParserException e) {
				e.printStackTrace();
				error = true;
			}
			
			return preview;
		}

		@Override
		public void onPostExecute(String result) {
			
			if (error) {
				Toast.makeText(getActivity(), "An XML Serializing Error Occured", Toast.LENGTH_SHORT).show();
			} else {
				loading_dialog.dismiss();
				Intent preview_intent = new Intent(getActivity(), XmlPreviewActivity.class);
				preview_intent.putExtra("PREVIEW", result);
				startActivity(preview_intent);
			}
			
		}
		
	}

}
