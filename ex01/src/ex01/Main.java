package ex01;

public class Main {

	public static void main(String[] args) {
		System.out.println("Begin...");
		Library library = new Library("1234567890", "No name", "No author", "A-ba-ba-ha-la-ma-ha", "Pulp fiction",
				"08/02/2021");
		System.out.println(library);
		System.out.println("---");
		Library[] array = { new Library("1234567890", "name1", "author1", "publisher1", "genre1", "date1"),
				new Library("3282849494", "name2", "author2", "publisher2", "genre2", "date2"),
				new Library("9494873772", "name3", "author3", "publisher3", "genre1", "date3") };
		
		System.out.println(array);

		System.out.println("Done.");
	}

}
