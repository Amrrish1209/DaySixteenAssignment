package com.bridgelabz.datastructure;

public class GenericWeekDay<T> {

	private String day;
	private T date;

	public GenericWeekDay(String day, T date) {
		this.day = day;
		this.date = date;
	}

	public String getDay() {
		return day;
	}

	public T getDate() {
		return date;
	}
}
