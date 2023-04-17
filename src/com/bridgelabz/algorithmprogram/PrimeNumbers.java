package com.bridgelabz.algorithmprogram;

public class PrimeNumbers {

	public static void main(String[] args) {
		int start = 0;
		int end = 1000;

		System.out.println("Prime numbers between " + start + " and " + end + " are:");

		for (int i = start; i <= end; i++) {
			if (isPrime(i)) {
				System.out.print(i + " ");
			}
		}
	}

	public static boolean isPrime(int number) {
		if (number <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
