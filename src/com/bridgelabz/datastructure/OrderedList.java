package com.bridgelabz.datastructure;

import java.io.*;
import java.util.*;

class Node<T extends Comparable<T>> {
	T data;
	Node<T> next;

	Node(T data) {
		this.data = data;
		next = null;
	}
}

class OrderedList<T extends Comparable<T>> {
	Node<T> head;

	OrderedList() {
		head = null;
	}

	// Method to insert data into the linked list
	void insert(T data) {
		Node<T> newNode = new Node<T>(data);
		if (head == null || head.data.compareTo(data) >= 0) {
			newNode.next = head;
			head = newNode;
		} else {
			Node<T> temp = head;
			while (temp.next != null && temp.next.data.compareTo(data) < 0) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;
		}
	}

	// Method to remove data from the linked list
	boolean remove(T data) {
		if (head == null) {
			return false;
		}
		if (head.data.compareTo(data) == 0) {
			head = head.next;
			return true;
		}
		Node<T> temp = head;
		while (temp.next != null && temp.next.data.compareTo(data) != 0) {
			temp = temp.next;
		}
		if (temp.next == null) {
			return false;
		}
		temp.next = temp.next.next;
		return true;
	}

	// Method to display the linked list
	void display() {
		Node<T> temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	// Method to save the linked list to a file
	void saveToFile(String fileName) {
		try {
			FileWriter fw = new FileWriter(fileName);
			Node<T> temp = head;
			while (temp != null) {
				fw.write(temp.data + " ");
				temp = temp.next;
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		OrderedList<Integer> list = new OrderedList<Integer>();
		try {
			Scanner sc = new Scanner(new File("input.txt"));
			while (sc.hasNextInt()) {
				int num = sc.nextInt();
				list.insert(num);
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.print("Enter a number to search: ");
		Scanner scanner = new Scanner(System.in);
		int searchNum = scanner.nextInt();
		boolean removed = list.remove(searchNum);
		if (removed) {
			System.out.println(searchNum + " is removed from the list");
		} else {
			System.out.println(searchNum + " is not found in the list");
			list.insert(searchNum);
			System.out.println(searchNum + " is added to the list");
		}
		list.display();
		list.saveToFile("output.txt");
	}
}
