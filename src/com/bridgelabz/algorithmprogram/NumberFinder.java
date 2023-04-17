package com.bridgelabz.algorithmprogram;

import java.util.Scanner;

public class NumberFinder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the value of N: ");
		int n = sc.nextInt();
		int low = 0;
		int high = n - 1;
		int numGuesses = 0;

		while (low <= high) {
			int mid = (low + high) / 2;
			System.out.print("Is the number between " + low + " and " + mid + "? (true/false): ");
			boolean response = sc.nextBoolean();
			numGuesses++;

			if (response) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		System.out.println("The number is " + low);
		System.out.println("Number of guesses: " + numGuesses);
	}
}
