package com.bridgelabz.algorithmprogram;

import java.util.*;

class Tasks {
	static class Task {
		int deadline;
		int time;

		public Task(int deadline, int time) {
			this.deadline = deadline;
			this.time = time;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		List<Task> tasks = new ArrayList<>();

		for (int i = 0; i < t; i++) {
			int d = sc.nextInt();
			int m = sc.nextInt();

			tasks.add(new Task(d, m));
		}

		Collections.sort(tasks, new Comparator<Task>() {
			public int compare(Task t1, Task t2) {
				return t1.deadline - t2.deadline;
			}
		});

		int maxOvershoot = 0;
		int currentDeadline = 0;

		for (Task task : tasks) {
			currentDeadline += task.time;
			maxOvershoot = Math.max(maxOvershoot, currentDeadline - task.deadline);
		}

		System.out.println(maxOvershoot);
	}
}
