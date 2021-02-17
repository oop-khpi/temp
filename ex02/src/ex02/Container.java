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
	
	public <T> T[] toArray() {
            return (T[]) Arrays.copyOf(array, array.length);
    }
	
	@Override
	public String toString() {
		// return "Container:\n" + Arrays.toString(array);
		StringBuilder buf = new StringBuilder();
		for (Object object : array) {
			buf.append(object).append(System.lineSeparator());
		}
		return buf.toString();
	}
	
	void sort(Comparator<? super E> c) {
        //Arrays.sort(a, (Comparator) c);
        E[] a = this.toArray();
        Arrays.sort(a, c);
        array = a;
    }

}
