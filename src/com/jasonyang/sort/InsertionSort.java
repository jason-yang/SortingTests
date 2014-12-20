package com.jasonyang.sort;

import java.util.List;

public class InsertionSort extends Sort {
	@Override
	public void sort(List<Integer> arr) {
		int size = arr.size();
		for (int i = 1; i < size; i++) {
			for (int j = i; j > 0; j--) {
				if (arr.get(j).compareTo(arr.get(j-1)) < 0) {
					swap(arr, j, j-1);
				} else {
					break;
				}
			}
		}
	}
}
