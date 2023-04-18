package com.bridgelabz.datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Week<T, U> {
	private Queue<WeekDay<T, U>> days;

	public Week() {
		days = new LinkedList<>();
	}

	public void addDay(WeekDay<T, U> day) {
		days.add(day);
	}

	public Queue<WeekDay<T, U>> getDays() {
		return days;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Read the days of the week with their corresponding dates from the user
		WeekDay<String, Integer> sunday = new WeekDay<>("S", scanner.nextInt());
		WeekDay<String, Integer> monday = new WeekDay<>("M", scanner.nextInt());
		WeekDay<String, Integer> tuesday = new WeekDay<>("T", scanner.nextInt());
		WeekDay<String, Integer> wednesday = new WeekDay<>("W", scanner.nextInt());
		WeekDay<String, Integer> thursday = new WeekDay<>("Th", scanner.nextInt());
		WeekDay<String, Integer> friday = new WeekDay<>("F", scanner.nextInt());
		WeekDay<String, Integer> saturday = new WeekDay<>("Sa", scanner.nextInt());

		// Create a week object and add the days of the week
		Week<String, Integer> week = new Week<>();
		week.addDay(sunday);
		week.addDay(monday);
		week.addDay(tuesday);
		week.addDay(wednesday);
		week.addDay(thursday);
		week.addDay(friday);
		week.addDay(saturday);

		// Create a queue of week objects to display the calendar
		Queue<Week<String, Integer>> calendar = new LinkedList<>();
		calendar.add(week);

		// Display the calendar
		while (!calendar.isEmpty()) {
			Week<String, Integer> currentWeek = calendar.poll();
			Queue<WeekDay<String, Integer>> currentDays = currentWeek.getDays();

			while (!currentDays.isEmpty()) {
				WeekDay<String, Integer> currentDay = currentDays.poll();
				System.out.print(currentDay.getDay() + " " + currentDay.getDate() + "\t");
			}

			System.out.println();
		}

		scanner.close();
	}
}
