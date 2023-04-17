package com.bridgelabz.datastructure;

public class PrimeNumberTwoDArray<T extends Number> {

	public static void main(String[] args) {
		int range = 1000;
		Number[][] primeArray = new Number[range / 100][25];
		int index = 0;

		for (int i = 0; i < range; i += 100) {
			Number[] primes = new Number[25];
			int count = 0;
			for (int j = i; j < i + 100; j++) {
				if (isPrime(j)) {
					primes[count] = j;
					count++;
				}
			}
			primeArray[index] = primes;
			index++;
		}

		for (int i = 0; i < primeArray.length; i++) {
			System.out.print("Range " + i + " primes: ");
			for (int j = 0; j < primeArray[i].length; j++) {
				if (primeArray[i][j] != null) {
					System.out.print(primeArray[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	public static boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
