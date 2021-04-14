package util;

public class ArrayUtil {
	public static int countPositive(int[] a) {
		int counter = 0;
		for (int i = 0; i < a.length; ++i) {
			if (a[i] > 0) {
				++counter;
			}
		}
		return counter;
	}

	public static int countNegative(int[] a) {
		int counter = 0;
		for (int i = 0; i < a.length; ++i) {
			if (a[i] < 0) {
				++counter;
			}
		}
		return counter;
	}

	public static int findMin(int[] a) {
		int minIdx = 0;
		for (int i = 1; i < a.length; ++i) {
			if (a[minIdx] > a[i]) {
				minIdx = i;
			}
		}
		return a[minIdx];
	}

	public static int findMax(int[] a) {
		int maxIdx = 0;
		for (int i = 1; i < a.length; ++i) {
			if (a[maxIdx] < a[i]) {
				maxIdx = i;
			}
		}
		return a[maxIdx];
	}
}