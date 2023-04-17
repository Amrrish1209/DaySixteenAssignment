package com.bridgelabz.algorithmprogram;

import java.util.Arrays;

public class GenericBubbleSort {

	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j].compareTo(arr[j + 1]) > 0) {
					// swap arr[j] and arr[j+1]
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		Integer[] arr = { 64, 34, 25, 12, 22, 11, 90 };
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));

		String[] strArr = { "apple", "orange", "banana", "grapes", "pear" };
		bubbleSort(strArr);
		System.out.println(Arrays.toString(strArr));
	}
}
