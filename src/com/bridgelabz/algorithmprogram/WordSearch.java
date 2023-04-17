package com.bridgelabz.algorithmprogram;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class WordSearch {
	public static void main(String[] args) {
		try {
			File file = new File("wordlist.txt");
			Scanner scanner = new Scanner(file);
			String line = scanner.nextLine(); // read the entire line of input
			String[] words = line.split(","); // split the line into individual words
			Arrays.sort(words); // sort the array of words

			System.out.print("Enter a word to search: ");
			String searchWord = scanner.nextLine(); // read the entire line of input
			int index = Arrays.binarySearch(words, searchWord); // perform binary search

			if (index >= 0) {
				System.out.println("The word is found in the list.");
			} else {
				System.out.println("The word is not found in the list.");
			}

			scanner.close();
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}
}
