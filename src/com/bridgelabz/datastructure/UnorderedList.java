package com.bridgelabz.datastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UnorderedList<E> {
	private Node<E> head;

	private static class Node<E> {
		private E data;
		private Node<E> next;

		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}

	public void add(E data) {
		Node<E> newNode = new Node<E>(data);
		if (head == null) {
			head = newNode;
		} else {
			Node<E> current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	public void remove(E data) {
		if (head == null) {
			return;
		}
		if (head.data.equals(data)) {
			head = head.next;
			return;
		}
		Node<E> current = head;
		while (current.next != null) {
			if (current.next.data.equals(data)) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}

	public boolean contains(E data) {
		Node<E> current = head;
		while (current != null) {
			if (current.data.equals(data)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public void saveToFile(String fileName) throws IOException {
		File file = new File(fileName);
		FileWriter writer = new FileWriter(file);
		Node<E> current = head;
		while (current != null) {
			writer.write(current.data.toString() + " ");
			current = current.next;
		}
		writer.close();
	}

	public static void main(String[] args) {
		UnorderedList<String> list = new UnorderedList<String>();
		Scanner scanner = new Scanner(System.in);

		// Read the text from a file and add each word to the list
		System.out.print("Enter the file name: ");
		String fileName = scanner.nextLine();
		try {
			File file = new File(fileName);
			Scanner fileScanner = new Scanner(file);
			while (fileScanner.hasNext()) {
				String word = fileScanner.next();
				list.add(word);
			}
			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}

		// Take user input to search a word in the list and add/remove it accordingly
		System.out.print("Enter a word to search: ");
		String word = scanner.next();
		if (list.contains(word)) {
			list.remove(word);
			System.out.println(word + " removed from the list");
		} else {
			list.add(word);
			System.out.println(word + " added to the list");
		}

		// Save the list to a file
		System.out.print("Enter the output file name: ");
		String outputFileName = scanner.next();
		try {
			list.saveToFile(outputFileName);
			System.out.println("List saved to " + outputFileName);
		} catch (IOException e) {
			System.out.println("Error writing to file");
			return;
		}

		scanner.close();
	}
}
