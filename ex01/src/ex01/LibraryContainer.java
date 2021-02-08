package ex01;

import java.util.Arrays;

public class LibraryContainer {
	private Library[] array = new Library[0];
	void add(Library libray) {
		Library[] old = array;
		array = new Library[old.length + 1];
		for(int i = 0; i < old.length; ++i) {
			array[i] = old[i];
		}
		array[old.length] = libray;
	}
	@Override
	public String toString() {
		return "LibraryContainer:\n" + Arrays.toString(array);
	}

}
