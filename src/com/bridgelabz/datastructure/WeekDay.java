package com.bridgelabz.datastructure;

class WeekDay<T, U> {
	private T day;
	private U date;

	public WeekDay(T day, U date) {
		this.day = day;
		this.date = date;
	}

	public T getDay() {
		return day;
	}

	public U getDate() {
		return date;
	}
}
