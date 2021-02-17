package ex02;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		System.out.println("Begin...");
		Library library = new Library("1234567890", "no name", "no author", "a-ba-ba-ha-la-ma-ha", "pulp fiction",
				"08/02/2021");
		System.out.println(library);
		System.out.println("---");
		Library[] array = { new Library("1234567890", "name1", "author1", "publisher1", "genre1", "date1"),
				new Library("3282849494", "name2", "author2", "publisher2", "genre2", "date2"),
				new Library("9494873772", "name3", "author3", "publisher3", "genre1", "date3") };
		
		System.out.println(Arrays.toString(array));
		System.out.println("---");
		// ArrayList HashSet AbstractCollection Collections
		Container<Library> container = new Container<>();
		container.add(library);
		for (Library lib : array) {
			container.add(lib);
		}
		System.out.print(container);
		System.out.println("---");
		container.sort(new Comparator<Library>() {
			public int compare(Library o1, Library o2) {
				return o2.getIsbn().compareTo(o1.getIsbn());
			}
		});
		System.out.println(container);
		System.out.println("---");
		sort(container, (o1, o2) -> o1.getName().compareTo(o2.getName()));
		System.out.println(container);
		System.out.println("Done.");
	}

	public static <T> void sort(Container<T> list, Comparator<? super T> c) {
        list.sort(c);
    }
}
