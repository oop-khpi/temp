package ex01;

public class Main {

	public static void main(String[] args) {
		System.out.println("Begin...");
		Library library = new Library("1234567890", "No name", "No author", "A-ba-ba-ha-la-ma-ha", "Pulp fiction",
				"08/02/2021");
		System.out.println(library);
		System.out.println("Done.");
	}

}
