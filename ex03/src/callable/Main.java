package callable;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;

import util.ArrayUtil;

public class Main {

	private static final int REP_NUMBER = 5;

	private static class Task implements Callable<Integer> {
		private int[] array;
		private Function<int[], Integer> func;

		public Task(int[] initArray, Function<int[], Integer> initFunc) {
			array = initArray;
			func = initFunc;
		}

		@Override
		public Integer call() throws Exception {
			return func.apply(array);
		}
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Begin...");
		System.out.println("CPU count: " + Runtime.getRuntime().availableProcessors());
		int[] array = new Random().ints(100_000_000, -1, 2).toArray();
		System.out.println("Array length: " + array.length);
		System.out.println("---");

		for (int repeatCounter = 1; repeatCounter < REP_NUMBER; ++repeatCounter) {

			ExecutorService es = Executors.newFixedThreadPool(4);
			// ExecutorService es = Executors.newSingleThreadExecutor();
			// ExecutorService es = Executors.newCachedThreadPool();

			ArrayList<Future<Integer>> results = new ArrayList<>();

			results.add(es.submit(new Task(array, ArrayUtil::countPositive)));

			results.add(es.submit(new Task(array, ArrayUtil::countNegative)));

			results.add(es.submit(new Task(array, ArrayUtil::findMin)));

			results.add(es.submit(new Task(array, ArrayUtil::findMax)));

			System.out.println("\tThread count: " + Thread.activeCount());

			es.shutdown();

			long elapsedNanos, startTime = System.nanoTime();
			for (Future<Integer> r : results) {
				System.out.println("\t" + r.get());
			}
			elapsedNanos = System.nanoTime() - startTime;
			System.out.printf("Time: %g\n", elapsedNanos / 1_000_000.0);
			System.out.println("---");
		}

		System.out.println("Done.");

	}

}
