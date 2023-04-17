package com.bridgelabz.algorithmprogram;

import java.util.Scanner;

public class InsertionSort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a list of words separated by spaces: ");
		String input = scanner.nextLine();

		String[] words = input.split(" ");

		// sort the array using insertion sort
		for (int i = 1; i < words.length; i++) {
			String key = words[i];
			int j = i - 1;

			while (j >= 0 && words[j].compareTo(key) > 0) {
				words[j + 1] = words[j];
				j--;
			}
			words[j + 1] = key;
		}

		// print the sorted list
		System.out.print("Sorted List: ");
		for (String word : words) {
			System.out.print(word + " ");
		}
	}
}
