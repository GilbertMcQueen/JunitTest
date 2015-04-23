package yaml.case01;

import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;

public class BookStore {

	public static void main(String[] args) {
//		Book book = (Book) new Yaml().load("junit-tutorial/src/junit/yaml/yml/book_fixtures.yaml");
		Yaml yml = new  Yaml();
		InputStream is = yml.getClass().getResourceAsStream("junit-tutorial/src/junit/yaml/yml/book_fixtures.yaml");
		Book book = (Book) yml.load(is);
		System.out.println("book.getTitle : " + book.getTitle());
	}
}
