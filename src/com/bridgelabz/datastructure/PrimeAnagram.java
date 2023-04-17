package com.bridgelabz.datastructure;

import java.util.*;
import java.util.stream.Collectors;

public class PrimeAnagram {
	public static void main(String[] args) {
		int range = 1000;
		List<Integer> primes = new ArrayList<>();
		List<Integer> anagrams = new ArrayList<>();

		// Find all prime numbers in the range
		for (int i = 2; i <= range; i++) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}

		// Find all pairs of prime numbers that are anagrams
		for (int i = 0; i < primes.size() - 1; i++) {
			for (int j = i + 1; j < primes.size(); j++) {
				if (areAnagrams(primes.get(i), primes.get(j))) {
					anagrams.add(primes.get(i));
					anagrams.add(primes.get(j));
				}
			}
		}

		// Create a 2D array to store the anagrams and non-anagrams
		int numRanges = 11;
		int[][] anagramArray = new int[numRanges][];
		int[][] nonAnagramArray = new int[numRanges][];

		// Populate the arrays with the anagrams and non-anagrams
		for (int i = 0; i < numRanges; i++) {
			int start = i * 100;
			int end = Math.min(start + 99, range);
			List<Integer> rangeAnagrams = new ArrayList<>();
			List<Integer> rangeNonAnagrams = new ArrayList<>();
			for (int j = 0; j < anagrams.size(); j += 2) {
				int num1 = anagrams.get(j);
				int num2 = anagrams.get(j + 1);
				if (num1 >= start && num1 <= end && num2 >= start && num2 <= end) {
					rangeAnagrams.add(num1);
					rangeAnagrams.add(num2);
				} else {
					rangeNonAnagrams.add(num1);
					rangeNonAnagrams.add(num2);
				}
			}
			anagramArray[i] = rangeAnagrams.stream().mapToInt(Integer::intValue).toArray();
			nonAnagramArray[i] = rangeNonAnagrams.stream().mapToInt(Integer::intValue).toArray();
		}

		// Print out the results
		for (int i = 0; i < numRanges; i++) {
			int start = i * 100;
			int end = Math.min(start + 99, range);
			System.out.println("Range " + (i + 1) + " (" + start + " - " + end + "):");
			System.out.println("Anagrams: " + Arrays.toString(anagramArray[i]));
			System.out.println("Non-Anagrams: " + Arrays.toString(nonAnagramArray[i]));
			System.out.println();
		}
	}

	// Helper method to check if a number is prime
	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	// Helper method to check if two numbers are anagrams of each other
	public static boolean areAnagrams(int num1, int num2) {
		String str1 = Integer.toString(num1);
		String str2 = Integer.toString(num2);
		if (str1.length() != str2.length()) {
			return false;
		}
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		return Arrays.equals(arr1, arr2);
	}
}
