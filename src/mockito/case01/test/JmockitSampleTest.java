package mockito.case01.test;

import mockit.*;
import org.junit.Test;
import mockito.case01.Child;
import mockito.case01.Parent;
import mockito.case01.Tekitou;

public class JmockitSampleTest {

	@Mocked
//	private Child child;
	private Child mock;
	@Mocked
	private int intMock;
	@Mocked
	private String strMock;
	@Mocked
	private Tekitou tekitou;

	@Test
	public void test() {
//		Child child = new Child();

//		System.out.println("instanceMethod() = " + this.mock.instanceMethod());
//		System.out.println("parentInstanceMethod() = " + this.mock.parentInstanceMethod());
//		System.out.println("child.instanceField = " + child.instanceField);
//		System.out.println("child.parentInstanceField = " + child.parentInstanceField);

//		System.out.println("instanceField = " + this.child.instanceField);
//		System.out.println("parentInstanceField = " + this.child.parentInstanceField);
//		System.out.println("classMethod() = " + Child.classMethod());
//		System.out.println("Child.parentClassMethod() = " + Child.parentClassMethod());
//		System.out.println("Parent.parentClassMethod() = " + Parent.parentClassMethod());
	}

	@Test
	public void test2(@Mocked Child child) {
		System.out.println("child.instanceMethod() = " + child.instanceMethod());
		Child child2 = new Child();
		System.out.println("child2.instanceField = " + child2.instanceField);
	}
}