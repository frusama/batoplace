package com.kapava.common.bean;

public class LabelValueBean {

	private String label = null;
	private String value = null;

	public LabelValueBean() {
	}

	public LabelValueBean(String label, String value) {
		this.value = value;
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
