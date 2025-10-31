package streams.app;

import streams.model.Book;
import streams.model.Student;

import java.util.Arrays;
import java.util.List;

public class StreamApp {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student("Alice", Arrays.asList(
						new Book("The Shining", "Stephen King", 447, 1977),
						new Book("It", "Stephen King", 1138, 1986),
						new Book("Carrie", "Stephen King", 199, 1974),
						new Book("Misery", "Stephen King", 320, 1987),
						new Book("11/22/63", "Stephen King", 849, 2011)
				)),
				new Student("Bob", Arrays.asList(
						new Book("Doctor Sleep", "Stephen King", 531, 2013),
						new Book("The Institute", "Stephen King", 576, 2019),
						new Book("Under the Dome", "Stephen King", 1070, 2009),
						new Book("It", "Stephen King", 1138, 1986),
						new Book("Bag of Bones", "Stephen King", 529, 1998)
				))
		);

		students.stream()
				.peek(System.out::println)
				.flatMap(s -> s.getBooks().stream())
				.distinct()
				.filter(b -> b.getYear() > 2000)
				.sorted((b1, b2) -> Integer.compare(b1.getPages(), b2.getPages()))
				.limit(3)
				.map(Book::getYear)
				.findFirst()
				.ifPresentOrElse(
						year -> System.out.println("Found book year: " + year),
						() -> System.out.println("No book found")
				);
	}
}
