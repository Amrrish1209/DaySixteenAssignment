package com.bridgelabz.algorithmprogram;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class GenericSearch {
    public static <T extends Comparable<T>> int binarySearch(T[] arr, T key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid].compareTo(key) < 0) {
                low = mid + 1;
            } else if (arr[mid].compareTo(key) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        try {
            File file = new File("wordlist.txt");
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine(); // read the entire line of input
            String[] words = line.split(","); // split the line into individual words
            Arrays.sort(words); // sort the array of words

            System.out.print("Enter a word to search: ");
            String searchWord = scanner.nextLine(); // read the entire line of input
            int index = binarySearch(words, searchWord); // perform binary search

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

