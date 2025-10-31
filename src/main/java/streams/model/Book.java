package streams.model;

import java.util.Objects;

public class Book {

	private String title;
	private String author;
	private int pages;
	private int year;

	public Book(String title, String author, int pages, int year) {
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.year = year;
	}

	public int getPages() {
		return pages;
	}

	public int getYear() {
		return year;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Book)) return false;
		Book book = (Book) o;
		return pages == book.pages && year == book.year && title.equals(book.title) && author.equals(book.author);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, author, pages, year);
	}

	@Override
	public String toString() {
		return title + " by " + author + " (" + pages + " pages, " + year + ")";
	}
}
