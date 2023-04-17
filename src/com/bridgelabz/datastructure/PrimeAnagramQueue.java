package com.bridgelabz.datastructure;

import java.util.LinkedList;

public class PrimeAnagramQueue<T> {

	private class Node<T> {
		T data;
		Node<T> next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node<T> head;
	private Node<T> tail;

	public PrimeAnagramQueue() {
		head = null;
		tail = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void enqueue(T data) {
		Node<T> newNode = new Node<>(data);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public T dequeue() {
		if (isEmpty()) {
			return null;
		}
		T data = head.data;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		return data;
	}

	public static void main(String[] args) {
		int range = 1000;
		PrimeAnagramQueue<Integer> anagramQueue = new PrimeAnagramQueue<>();

		// Find all prime numbers in the range
		for (int i = 2; i <= range; i++) {
			if (isPrime(i)) {
				// Find all pairs of prime numbers that are anagrams
				for (int j = i + 1; j <= range; j++) {
					if (areAnagrams(i, j)) {
						anagramQueue.enqueue(i);
						anagramQueue.enqueue(j);
					}
				}
			}
		}

		// Print out the anagrams from the queue
		while (!anagramQueue.isEmpty()) {
			System.out.println(anagramQueue.dequeue() + " " + anagramQueue.dequeue());
		}
	}

	private static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static boolean areAnagrams(int num1, int num2) {
		if (num1 == num2) {
			return false;
		}
		int[] digits1 = getDigits(num1);
		int[] digits2 = getDigits(num2);
		if (digits1.length != digits2.length) {
			return false;
		}
		for (int i = 0; i < digits1.length; i++) {
			boolean found = false;
			for (int j = 0; j < digits2.length; j++) {
				if (digits1[i] == digits2[j]) {
					digits2[j] = -1;
					found = true;
					break;
				}
			}
			if (!found) {
				return false;
			}
		}
		return true;
	}

	private static int[] getDigits(int num) {
		String numString = Integer.toString(num);
		int[] digits = new int[numString.length()];
		for (int i = 0; i < numString.length(); i++) {
			digits[i] = numString.charAt(i) - '0';
		}
		return digits;
	}
}
