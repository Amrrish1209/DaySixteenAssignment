package com.bridgelabz.datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenericWeek<T> {

	private Queue<GenericWeekDay<T>> days;
	private Stack<GenericWeekDay<T>> stack1;
	private Stack<GenericWeekDay<T>> stack2;

	public GenericWeek() {
		days = new LinkedList<GenericWeekDay<T>>();
		stack1 = new Stack<GenericWeekDay<T>>();
		stack2 = new Stack<GenericWeekDay<T>>();
	}

	public void addDay(GenericWeekDay<T> day) {
		days.add(day);
	}

	public void queueToStacks() {
		while (!days.isEmpty()) {
			GenericWeekDay<T> currentDay = days.poll();
			stack1.push(currentDay);
		}
	}

	public void stackToQueue() {
		while (!stack1.isEmpty()) {
			GenericWeekDay<T> currentDay = stack1.pop();
			stack2.push(currentDay);
		}

		while (!stack2.isEmpty()) {
			GenericWeekDay<T> currentDay = stack2.pop();
			days.add(currentDay);
		}
	}

	public void displayCalendar() {
		queueToStacks();

		while (!stack1.isEmpty()) {
			GenericWeekDay<T> currentDay = stack1.pop();
			System.out.print(currentDay.getDay() + " " + currentDay.getDate() + "\t");
		}

		System.out.println();

		stackToQueue();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Read the days of the week with their corresponding dates from the user
		GenericWeekDay<Integer> sunday = new GenericWeekDay<>("S", scanner.nextInt());
		GenericWeekDay<Integer> monday = new GenericWeekDay<>("M", scanner.nextInt());
		GenericWeekDay<Integer> tuesday = new GenericWeekDay<>("T", scanner.nextInt());
		GenericWeekDay<Integer> wednesday = new GenericWeekDay<>("W", scanner.nextInt());
		GenericWeekDay<Integer> thursday = new GenericWeekDay<>("Th", scanner.nextInt());
		GenericWeekDay<Integer> friday = new GenericWeekDay<>("F", scanner.nextInt());
		GenericWeekDay<Integer> saturday = new GenericWeekDay<>("Sa", scanner.nextInt());

		// Create a week object and add the days of the week
		GenericWeek<Integer> week = new GenericWeek<>();
		week.addDay(sunday);
		week.addDay(monday);
		week.addDay(tuesday);
		week.addDay(wednesday);
		week.addDay(thursday);
		week.addDay(friday);
		week.addDay(saturday);

		// Display the calendar
		week.displayCalendar();

		scanner.close();
	}
}
