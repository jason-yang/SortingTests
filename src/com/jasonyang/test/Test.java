package com.jasonyang.test;

import com.jasonyang.sort.BubbleSort;
import com.jasonyang.sort.InsertionSort;
import com.jasonyang.sort.SelectionSort;
import com.jasonyang.sort.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test<E extends Comparable<? super E>> {

	private static int ITERATIONS = 1000;
	private static int ARRAY_SIZE = 100;

	//	public void siftDown(List<E> arr, int start, int end) {
//		int root = start;
//
//		while ((root * 2 + 1) <= end) { // While root has at least 1 child
//			int left = root * 2 + 1;   // Left child
//			int right = left + 1;
//			int swap = root;            // Keep track of child to swap with
//
//			if (arr.get(swap).compareTo(arr.get(left)) < 0) {
//				swap = left;
//			}
//			// If there is a right child and that child is greater
//			if (right < end && arr.get(swap).compareTo(arr.get(right)) < 0) {
//				swap = right;
//			}
//			if (swap == root) {
//				// The root holds the largest element. We are done
//				return;
//			} else {
//				swap(arr, root, swap);
//				root = swap;
//			}
//		}
//	}
//
//	public void heapify(List<E> arr) {
//		for (int start = (int) Math.floor((arr.size() - 2) / 2); start >= 0; start--) {
//			siftDown(arr, start, arr.size() - 1);
//		}
//	}
//
//	public List<E> heapSort(List<E> arr) {
//		heapify(arr);
//
//		int end = arr.size() - 1;
//		while (end > 0) {
//			swap(arr, end, 0);
//			end--;
//			siftDown(arr, 0, end);
//		}
//
//		return null;
//	}
//
//	public List<E> quickSort(List<E> arr) {
//		if (arr.isEmpty()) {
//			return arr;
//		} else {
//			E pivot = arr.get(0);
//
//			List<E> less = new LinkedList<E>();
//			List<E> pivotList = new LinkedList<E>();
//			List<E> more = new LinkedList<E>();
//
//			for (E i : arr) {
//				int compare = i.compareTo(pivot);
//				if (compare < 0) {
//					less.add(i);
//				} else if (compare > 0) {
//					more.add(i);
//				} else {
//					pivotList.add(i);
//				}
//			}
//
//			less = quickSort(less);
//			more = quickSort(more);
//
//			less.addAll(pivotList);
//			less.addAll(more);
//
//			return less;
//		}
//	}
//
//	public void quickSortInplace(List<E> arr) {
//		quickSortInplace(arr, 0, arr.size() - 1);
//	}
//
//	public void quickSortInplace(List<E> arr, int left, int right) {
//		if (left < right) {
//			int p = partition(arr, left, right);
//			quickSortInplace(arr, left, p - 1);
//			quickSortInplace(arr, p + 1, right);
//		}
//	}
//
//	public int partition(List<E> arr, int left, int right) {
//		E pivot = arr.get(right);
//
//		int index = left;
//		for (int i = left; i < right; i++) {
//			if (arr.get(i).compareTo(pivot) < 0) {
//				swap(arr, i, index);
//				index++;
//			}
//		}
//		swap(arr, index, right);
//
//		return index;
//	}

	private static List<Integer> generateArray(int capacity) {
		List<Integer> list = new ArrayList<Integer>(capacity);
		Random gen = new Random();
		for (int i = 0; i < capacity; i++) {
			list.add(gen.nextInt(capacity));
		}

		return list;
	}

	private static <T extends Sort> void test(Class<T> cls, String name) {
		try {
			Sort sort = cls.newInstance();
			long total = 0;
			for (int i = 0; i < ITERATIONS; i++) {
				List<Integer> list = generateArray(ARRAY_SIZE);

				long start = System.nanoTime();
				sort.sort(list);
				long end = System.nanoTime();
				total += end - start;

				if (!validate(list)) {
					System.out.println(name + " did not sort properly: " + list);
					break;
				}
			}

			System.out.println(name + ": " + total/1000000 + "ms");


		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private static boolean validate(List<Integer> arr) {
		int size = arr.size();
		for (int i = 0; i < size - 1; i++) {
			if (arr.get(i).compareTo(arr.get(i+1)) > 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(String.format("Iterations: %d, Array Size: %d\n", ITERATIONS, ARRAY_SIZE));

		test(BubbleSort.class, "Bubble Sort");
		test(SelectionSort.class, "Selection Sort");
		test(InsertionSort.class, "Insertion Sort");

	}
}
