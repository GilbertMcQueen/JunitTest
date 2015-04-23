package basic.case02.test;

import static org.junit.Assert.*;
import java.lang.reflect.Field;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import basic.case02.Person;

/**
 * @author y_kusano
 *
 */
public class PersonTest extends  TestCase{

	private Person defaultPerson;

	public PersonTest(String name) {
		super(name);
	}

	public void setUp() throws Exception {
		this.defaultPerson = new Person();
	}

	public void testDefaultPerson() throws Exception {
		Class c = this.defaultPerson.getClass();

		Field nameField = c.getDeclaredField("name");

		nameField.setAccessible(true);

		String getName;

		assertEquals("TEST太郎", getName = (String)nameField.get(this.defaultPerson));

		System.out.println(getName);
	}

//	/**
//	 * @throws java.lang.Exception
//	 */
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	/**
//	 * {@link Person#Person()} のためのテスト・メソッド。
//	 */
//	@Test
//	public void testPerson() {
//		fail("まだ実装されていません");
//	}
//
//	/**
//	 * {@link Person#Person(java.lang.String)} のためのテスト・メソッド。
//	 */
//	@Test
//	public void testPersonString() {
//		fail("まだ実装されていません");
//	}
//
}
