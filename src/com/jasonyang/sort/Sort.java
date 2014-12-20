package com.jasonyang.sort;

import java.util.List;

public abstract class Sort {

	public void swap(List<Integer> arr, int i, int j) {
		int tmp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, tmp);
	}

	public abstract void sort(List<Integer> arr);
}
