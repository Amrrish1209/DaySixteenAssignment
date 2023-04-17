package com.bridgelabz.datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.bridgelabz.datastructure.Customer.TransactionType;

public class BankingCash {
	private int balance;
	private Queue<Customer> queue;

	public BankingCash() {
		balance = 0;
		queue = new LinkedList<>();
	}

	public void addCustomer(Customer customer) {
		queue.add(customer);
	}

	public void serveCustomer() {
		if (!queue.isEmpty()) {
			Customer customer = queue.poll();
			if (customer.getTransactionType() == TransactionType.DEPOSIT) {
				balance += customer.getAmount();
				System.out.println(
						"Deposited " + customer.getAmount() + " rupees. Current balance: " + balance + " rupees");
			} else {
				if (balance >= customer.getAmount()) {
					balance -= customer.getAmount();
					System.out.println(
							"Withdrew " + customer.getAmount() + " rupees. Current balance: " + balance + " rupees");
				} else {
					System.out.println("Insufficient balance");
				}
			}
		} else {
			System.out.println("No customers in queue");
		}
	}

	public static void main(String[] args) {
		BankingCash bank = new BankingCash();
		Scanner sc = new Scanner(System.in);
		int n;

		do {
			System.out.println("\nChoose an option:");
			System.out.println("1. Add customer to queue");
			System.out.println("2. Serve next customer");
			System.out.println("3. Exit");
			n = sc.nextInt();

			switch (n) {
			case 1:
				System.out.println("Enter amount: ");
				int amount = sc.nextInt();
				System.out.println("Enter transaction type (1 for deposit, 2 for withdraw): ");
				int type = sc.nextInt();
				if (type == 1) {
					bank.addCustomer(new Customer(amount, TransactionType.DEPOSIT));
				} else if (type == 2) {
					bank.addCustomer(new Customer(amount, TransactionType.WITHDRAW));
				} else {
					System.out.println("Invalid transaction type");
				}
				break;
			case 2:
				bank.serveCustomer();
				break;
			case 3:
				break;
			default:
				System.out.println("Invalid option");
			}
		} while (n != 3);
	}
}