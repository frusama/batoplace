package com.kapava.common.bean;

import java.util.List;

public class DTableData<E> {

	private List<E> aaData;

	public void set(List<E> aaData) {
		this.aaData = aaData;
	}

	public List<E> get() {
		return aaData;
	}
}