package ex02;

/*
 * Дані про книгу:
 * ISBN;
 * назва;
 * автори (кількість не обмежена);
 * видавництво;
 * жанр;
 * дата видання.
 */
public class Library {
	private String isbn;
	private String name;
	private String authors;
	private String publisher;
	private String genre;
	private String date;

	@Override
	public String toString() {
		return "Library: " + isbn + ", " + name + ", " + authors + ", "
				+ publisher + ", " + genre + ", " + date;
	}

	public Library(String isbn, String name, String authors, String publisher, String genre, String date) {
		this.isbn = isbn;
		this.name = name;
		this.authors = authors;
		this.publisher = publisher;
		this.genre = genre;
		this.date = date;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
