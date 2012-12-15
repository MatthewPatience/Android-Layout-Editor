package com.mobicartel.ale;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.mobicartel.ale.constants.ParentType;
import com.mobicartel.ale.fragment.InventoryFragment;
import com.mobicartel.ale.fragment.LayoutFragment;
import com.mobicartel.ale.fragment.PropertiesFragment;
import com.mobicartel.ale.object.Component;
import com.mobicartel.ale.object.DeviceConfig;
import com.mobicartel.ale.util.Constants;

public class MainActivity extends Activity implements OnItemSelectedListener {
	
	private DeviceConfig[] arr_devices;
	
	public InventoryFragment fragment_inventory;
	public LayoutFragment fragment_layout;
	public PropertiesFragment fragment_properties;
	
	public Component component;
	
	private Spinner spinner_devices;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        init();
        
        setUpActionBar();
    
    }
    
    private void setUpActionBar() {
    	
    	setUpDeviceConfigs();
    	Constants.device_config = arr_devices[0];
		fragment_layout.setDeviceConfig(Constants.device_config);
    	
    	LinearLayout layout_bg = new LinearLayout(this);
    	layout_bg.setOrientation(LinearLayout.HORIZONTAL);
    	ActionBar.LayoutParams customview_params = new ActionBar.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    	customview_params.leftMargin = 30;
    	
    	layout_bg.addView(spinner_devices);
    	
    	ActionBar actionbar = getActionBar();
    	actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME);
    	actionbar.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, 
    			new int[] { 0x696969, 0xff202020 }));
    	actionbar.setCustomView(layout_bg, customview_params);
    	
    }
    
    private void setUpDeviceConfigs() {
    	
    	spinner_devices = new Spinner(this);
    	arr_devices = DeviceConfig.values();
    	String[] arr_device_names = new String[arr_devices.length];
    	for (int i = 0; i < arr_devices.length; i++) {
    		arr_device_names[i] = arr_devices[i].getName();
    	}
    	spinner_devices.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, arr_device_names));
    	spinner_devices.setOnItemSelectedListener(this);
    	
    }
    
    private void init() {
    	
    	FragmentManager fragment_manager = getFragmentManager();

        fragment_inventory = (InventoryFragment) fragment_manager.findFragmentById(R.id.inventory);
        fragment_layout = (LayoutFragment) fragment_manager.findFragmentById(R.id.layout);        
        fragment_properties = (PropertiesFragment) fragment_manager.findFragmentById(R.id.properties);
        
        fragment_properties.updateOutline();
    	
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
    	switch(item.getItemId()) {
    	case(R.id.change_layout):
    		displayLayoutSelectionDialog();
    		return true;
    	}
    	
    	return false;
    }
    
    private void displayLayoutSelectionDialog() {
    	
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setTitle("Select A Layout");
    	final ParentType[] arr_parents = ParentType.values();
    	String[] arr_parent_titles = new String[arr_parents.length];
    	for (int i = 0; i < arr_parents.length; i++) {
    		arr_parent_titles[i] = arr_parents[i].title;
    	}
    	builder.setItems(arr_parent_titles, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				try {
					ParentType parent_type = arr_parents[which];
					ViewGroup layout = parent_type.getViewGroup(MainActivity.this);
					Component base_component = new Component(layout);
					fragment_layout.setBaseLayout(base_component);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    	builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});
    	AlertDialog dialog = builder.create();
    	dialog.show();
    	
    }

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		
		Constants.device_config = arr_devices[position];
		fragment_layout.setDeviceConfig(Constants.device_config);
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		
	}
    
}
