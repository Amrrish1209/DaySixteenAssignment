package com.bridgelabz.algorithmprogram;

import java.util.*;

public class MergeSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of elements: ");
		int n = sc.nextInt();
		String[] arr = new String[n];
		System.out.println("Enter the elements:");
		for (int i = 0; i < n; i++) {
			arr[i] = sc.next();
		}
		mergeSort(arr, 0, n - 1);
		System.out.println("Sorted array:");
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void mergeSort(String[] arr, int lo, int hi) {
		if (lo < hi) {
			int mid = (lo + hi) / 2;
			mergeSort(arr, lo, mid);
			mergeSort(arr, mid + 1, hi);
			merge(arr, lo, mid, hi);
		}
	}

	public static void merge(String[] arr, int lo, int mid, int hi) {
		int n1 = mid - lo + 1;
		int n2 = hi - mid;
		String[] left = new String[n1];
		String[] right = new String[n2];
		for (int i = 0; i < n1; i++) {
			left[i] = arr[lo + i];
		}
		for (int j = 0; j < n2; j++) {
			right[j] = arr[mid + 1 + j];
		}
		int i = 0, j = 0, k = lo;
		while (i < n1 && j < n2) {
			if (left[i].compareTo(right[j]) <= 0) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = left[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = right[j];
			j++;
			k++;
		}
	}
}
