package com.bridgelabz.datastructure;

public class Customer {

	private final int amount;
	private final TransactionType transactionType;

	Customer(int amount, TransactionType transactionType) {
		this.amount = amount;
		this.transactionType = transactionType;
	}

	int getAmount() {
		return amount;
	}

	TransactionType getTransactionType() {
		return transactionType;
	}

	enum TransactionType {
		DEPOSIT, WITHDRAW
	}

}
