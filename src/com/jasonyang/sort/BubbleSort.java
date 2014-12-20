package com.jasonyang.sort;

import java.util.List;

public class BubbleSort extends Sort {
	@Override
	public void sort(List<Integer> arr) {
		int size = arr.size();
		boolean swapped;
		do {
			swapped = false;
			for (int i = 0; i < size - 1; i++) {
				if (arr.get(i).compareTo(arr.get(i+1)) > 0) {
					swap(arr, i, i+1);
					swapped = true;
				}
			}
		} while (swapped);
	}
}