package ex02;

import java.util.Arrays;
import java.util.Comparator;

public class Container<E> {
	private Object[] array = new Object[0];

	void add(E data) {
//		Object[] old = array;
//		array = new Object[old.length + 1];
//		for(int i = 0; i < old.length; ++i) {
//			array[i] = old[i];
//		}
//		array[old.length] = data;
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = data;
	}

	public E remove(int index) {
		@SuppressWarnings("unchecked")
		E removed = (E) array[index];
		int i = array.length - 1;
		if (index < i) {
			System.arraycopy(array, index + 1, array, index, i - index);
		}
		array[i] = null;
		return removed;
	}

	public Object[] toArray() {
		return Arrays.copyOf(array, array.length);
	}

	public <T> T[] toArray(T[] a) {
		if (a.length < array.length) {
			@SuppressWarnings("unchecked")
			T[] result = (T[]) Arrays.copyOf(array, array.length, a.getClass());
			return result;
		}
		System.arraycopy(array, 0, a, 0, array.length);
		return a;
	}

	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		for (Object object : array) {
			buf.append(object).append(System.lineSeparator());
		}
		buf.delete(buf.length() - System.lineSeparator().length(), buf.length());
		return buf.toString();
	}

	void sort(Comparator<? super E> c) {
		@SuppressWarnings("unchecked")
		E[] a = (E[]) array;
		Arrays.sort(a, c);
	}

}
