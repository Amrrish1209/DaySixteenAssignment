package com.bridgelabz.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String inputString = scanner.nextLine().toLowerCase().replaceAll("\\s+", "");
		Deque<Character> deque = new ArrayDeque<>();

		// Add each character to the rear of the deque
		for (char c : inputString.toCharArray()) {
			deque.offerLast(c);
		}

		boolean isPalindrome = true;

		// Check if the string is a palindrome by comparing the characters at the front
		// and rear of the deque
		while (deque.size() > 1) {
			if (deque.pollFirst() != deque.pollLast()) {
				isPalindrome = false;
				break;
			}
		}

		if (isPalindrome) {
			System.out.println(inputString + " is a palindrome.");
		} else {
			System.out.println(inputString + " is not a palindrome.");
		}
	}
}
