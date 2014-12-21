package com.jasonyang.sort;

import java.util.List;

public class HeapSort extends Sort {

	public void siftDown(List<Integer> arr, int start, int end) {
		int root = start;

		while ((root * 2 + 1) <= end) { // While root has at least 1 child
			int left = root * 2 + 1;   // Left child
			int right = left + 1;
			int swap = root;            // Keep track of child to swap with

			if (arr.get(swap).compareTo(arr.get(left)) < 0) {
				swap = left;
			}
			// If there is a right child and that child is greater
			if (right < end && arr.get(swap).compareTo(arr.get(right)) < 0) {
				swap = right;
			}
			if (swap == root) {
				// The root holds the largest element. We are done
				return;
			} else {
				swap(arr, root, swap);
				root = swap;
			}
		}
	}

	public void heapify(List<Integer> arr) {
		for (int start = (int) Math.floor((arr.size() - 2) / 2); start >= 0; start--) {
			siftDown(arr, start, arr.size() - 1);
		}
	}

	@Override
	public void sort(List<Integer> arr) {
		heapify(arr);

		int end = arr.size() - 1;
		while (end > 0) {
			swap(arr, end, 0);
			end--;
			siftDown(arr, 0, end);
		}
	}
}
