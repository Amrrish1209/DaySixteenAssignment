package com.bridgelabz.datastructure;

import java.util.*;

public class HashTable {
	private int slots = 10;
	private List<Integer>[] table;

	public HashTable() {
		table = new LinkedList[slots];
		for (int i = 0; i < slots; i++) {
			table[i] = new LinkedList<>();
		}
	}

	private int hashFunction(int number) {
		return number % slots;
	}

	public void addNumber(int number) {
		int slot = hashFunction(number);
		List<Integer> chain = table[slot];
		if (!chain.contains(number)) {
			chain.add(number);
		}
	}

	public boolean searchNumber(int number) {
		int slot = hashFunction(number);
		List<Integer> chain = table[slot];
		if (chain.contains(number)) {
			chain.remove((Integer) number);
			return true;
		} else {
			chain.add(number);
			return false;
		}
	}

	public void saveNumbers(String fileName) throws Exception {
		Formatter formatter = new Formatter(fileName);
		for (int i = 0; i < slots; i++) {
			List<Integer> chain = table[i];
			for (int j = 0; j < chain.size(); j++) {
				formatter.format("%d ", chain.get(j));
			}
		}
		formatter.close();
	}

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		HashTable hashTable = new HashTable();

		// Read numbers from file
		Scanner fileScanner = new Scanner("numbers.txt");
		while (fileScanner.hasNextInt()) {
			int number = fileScanner.nextInt();
			hashTable.addNumber(number);
		}
		fileScanner.close();

		// Search for a number
		System.out.print("Enter a number to search: ");
		int searchNumber = scanner.nextInt();
		boolean found = hashTable.searchNumber(searchNumber);
		if (found) {
			System.out.println("Number found!");
		} else {
			System.out.println("Number not found.");
		}

		// Save numbers to file
		hashTable.saveNumbers("output.txt");
	}
}
