package com.bridgelabz.algorithmprogram;

import java.util.*;
import java.time.*;
import java.time.format.*;
import java.util.regex.*;

public class MessageDemonstration {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Read in the message
		System.out.print("Enter the message: ");
		String message = sc.nextLine();

		// Replace <<name>> with first name of the user
		String name = "John"; // Assume you are the user
		message = message.replaceAll("<<name>>", name);

		// Replace <<full name>> with user full name
		String fullName = "John Doe"; // Assume you are the user
		message = message.replaceAll("<<full name>>", fullName);

		// Replace mobile number in the format 91-xxxxxxxxxx with your contact number
		String contactNumber = "91-1234567890"; // Your contact number
		message = message.replaceAll("91-\\d{10}", contactNumber);

		// Replace any date in the format XX/XX/XXXX with current date
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dateString = formatter.format(currentDate);
		message = message.replaceAll("\\d{2}/\\d{2}/\\d{4}", dateString);

		// Print the modified message
		System.out.println("Modified message: " + message);
	}
}
