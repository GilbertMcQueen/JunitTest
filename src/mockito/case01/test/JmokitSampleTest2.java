package mockito.case01.test;

import mockit.Mocked;
import org.junit.Before;
import org.junit.Test;
import mockito.case01.Child;

public class JmokitSampleTest2 {

	@Mocked
	private Child child;

	@Test
	public void test() {
		System.out.println("instanceMethod() = " + this.child.instanceMethod());
		System.out.println("parentInstanceMethod() = " + this.child.parentInstanceMethod());
		// System.out.println("classMethod() = " + Child.classMethod());
		// System.out.println("Child.parentClassMethod() = " +
		// Child.parentClassMethod());
		// System.out.println("Parent.parentClassMethod() = " +
		// Parent.parentClassMethod());
	}

	@Before
	public void setUp() throws Exception {
	}
}
