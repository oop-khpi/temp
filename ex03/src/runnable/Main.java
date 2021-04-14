package runnable;

import java.util.Random;

import util.ArrayUtil;

abstract class Task implements Runnable {
	protected int[] array;
	protected int result;

	public Task(int[] initArray) {
		array = initArray;
	}

	public int getResult() {
		return result;
	}
}

class countPositiveTask extends Task {
	public countPositiveTask(int[] initArray) {
		super(initArray);
	}

	public void run() {
		result = ArrayUtil.countPositive(array);
	}
}

class countNegativeTask extends Task {
	public countNegativeTask(int[] initArray) {
		super(initArray);
	}

	public void run() {
		result = ArrayUtil.countNegative(array);
	}
}

class findMinTask extends Task {
	public findMinTask(int[] initArray) {
		super(initArray);
	}

	public void run() {
		result = ArrayUtil.findMin(array);
	}
}

class findMaxTask extends Task {
	public findMaxTask(int[] initArray) {
		super(initArray);
	}

	public void run() {
		result = ArrayUtil.findMax(array);
	}
}

public class Main {

	private static final int REP_NUMBER = 5;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Begin...");

		int[] array = new Random().ints(100_000_000, -1, 2).toArray();
		System.out.println("CPU count: " + Runtime.getRuntime().availableProcessors());
		System.out.println("Array length: " + array.length);
		System.out.println("---");

		for (int repeatCounter = 1; repeatCounter < REP_NUMBER; ++repeatCounter) {
			System.out.println("Non-parallel calculation #" + repeatCounter);

			long elapsedNanos, startTime = System.nanoTime();
			System.out.println("\tThread count: " + Thread.activeCount());
			System.out.println("\t" + ArrayUtil.countPositive(array));
			System.out.println("\t" + ArrayUtil.countNegative(array));
			System.out.println("\t" + ArrayUtil.findMin(array));
			System.out.println("\t" + ArrayUtil.findMax(array));
			elapsedNanos = System.nanoTime() - startTime;
			System.out.printf("Time: %g\n", elapsedNanos / 1_000_000.0);

			Task[] tasks = { new countPositiveTask(array), new countNegativeTask(array), new findMinTask(array),
					new findMaxTask(array) };

			Thread[] threads = new Thread[tasks.length];
			for (int i = 0; i < threads.length; ++i) {
				threads[i] = new Thread(tasks[i]);
			}

			System.out.println("Parallel calculating #" + repeatCounter);

			startTime = System.nanoTime();
			for (int i = 0; i < threads.length; ++i) {
				threads[i].start();
			}
			System.out.println("\tThread count: " + Thread.activeCount());
			for (int i = 0; i < threads.length; ++i) {
				threads[i].join();
			}
			elapsedNanos = System.nanoTime() - startTime;

			for (int i = 0; i < tasks.length; ++i) {
				System.out.println("\t" + tasks[i].getResult());
			}
			System.out.printf("Time: %g\n", elapsedNanos / 1_000_000.0);
			System.out.println("---");
		}

		System.out.println("Done.");
	}
}
