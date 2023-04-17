package com.bridgelabz.datastructure;

import java.util.EmptyStackException;

public class GenericPrimeAnagram<T> {

	private class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node<T> top;

	public void push(T data) {
		Node<T> newNode = new Node<T>(data);
		newNode.next = top;
		top = newNode;
	}

	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		T data = top.data;
		top = top.next;
		return data;
	}

	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void findAndPushAnagramPrimes(int start, int end) {
		for (int i = start; i <= end; i++) {
			if (isPrime(i)) {
				for (int j = i + 1; j <= end; j++) {
					if (isPrime(j) && areAnagrams(i, j)) {
						push((T) (i + " " + j));
					}
				}
			}
		}
	}

	private boolean isPrime(int n) {
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

	private boolean areAnagrams(int n1, int n2) {
		int[] count = new int[10];
		while (n1 > 0) {
			count[n1 % 10]++;
			n1 /= 10;
		}
		while (n2 > 0) {
			count[n2 % 10]--;
			n2 /= 10;
		}
		for (int i = 0; i < 10; i++) {
			if (count[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public void printStack() {
		while (!isEmpty()) {
			System.out.println(pop());
		}
	}

	public static void main(String[] args) {
		GenericPrimeAnagram<String> stack = new GenericPrimeAnagram<String>();
		stack.findAndPushAnagramPrimes(0, 1000);
		stack.printStack();
	}
}
