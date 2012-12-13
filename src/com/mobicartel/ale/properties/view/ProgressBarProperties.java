package com.mobicartel.ale.properties.view;

import android.view.View;
import android.widget.ProgressBar;

import com.mobicartel.ale.properties.XmlSerializablePropertyAbsImpl;
import com.mobicartel.ale.util.InputMethod;
import com.mobicartel.ale.util.Verifier;

public class ProgressBarProperties extends ViewProperties {

	private final String PROP_INDETERMINATE = "indeterminate";
	private final String PROP_MAX = "max";
	private final String PROP_PROGRESS = "progress";
	private final String PROP_SECONDARY_PROGRESS = "secondaryProgress";
	
	public Indeterminate indeterminate;
	public Max max;
	public Progress progress;
	public SecondaryProgress secondary_progress;
	
	public ProgressBarProperties() {
		super();
		
		indeterminate = new Indeterminate();
		max = new Max();
		progress = new Progress();
		secondary_progress = new SecondaryProgress();
		this.list_properties.add(indeterminate);
		this.list_properties.add(max);
		this.list_properties.add(progress);
		this.list_properties.add(secondary_progress);
		
	}
	
	public class Indeterminate extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_INDETERMINATE;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			if (value.equals("true")) {
				((ProgressBar) view).setIndeterminate(true);
			} else {
				((ProgressBar) view).setIndeterminate(false);
			}
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (Verifier.isBoolean(value)) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of '" + NAME + "' must be 'true' or 'false'");
			}
		}
		public String getValue() {
			return value;
		}
		@Override
		public InputMethod getInputMethod() {
			
			return InputMethod.BOOLEAN;
		}
	}
	
	public class Max extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_MAX;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			((ProgressBar) view).setMax(Integer.parseInt(value));
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (Verifier.isInteger(value)) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of '" + NAME + "' must be an integer");
			}
		}
		public String getValue() {
			return value;
		}
		@Override
		public InputMethod getInputMethod() {
			
			return null;
		}
	}
	
	public class Progress extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_PROGRESS;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			((ProgressBar) view).setProgress(Integer.parseInt(value));
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (Verifier.isInteger(value)) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of '" + NAME + "' must be an integer");
			}
		}
		public String getValue() {
			return value;
		}
		@Override
		public InputMethod getInputMethod() {
			
			return null;
		}
	}
	
	public class SecondaryProgress extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_SECONDARY_PROGRESS;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			((ProgressBar) view).setSecondaryProgress(Integer.parseInt(value));
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (Verifier.isInteger(value)) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of '" + NAME + "' must be an integer");
			}
		}
		public String getValue() {
			return value;
		}
		@Override
		public InputMethod getInputMethod() {
			
			return null;
		}
	}

}
