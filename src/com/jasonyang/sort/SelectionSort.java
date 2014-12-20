package com.jasonyang.sort;

import java.util.List;

public class SelectionSort extends Sort {
	@Override
	public void sort(List<Integer> arr) {
		int min;
		int size = arr.size();
		for (int i = 0; i < size-1; i++) {
			min = i;

			for (int j = i + 1; j < size; j++) {
				if (arr.get(j).compareTo(arr.get(min)) < 0) {
					min = j;
				}
			}

			if (min != i) {
				swap(arr, min, i);
			}
		}
	}
}
