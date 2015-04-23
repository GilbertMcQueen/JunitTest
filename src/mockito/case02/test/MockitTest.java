package mockito.case02.test;

import mockit.Mocked;
import mockit.*;

public class MockitTest {

	@Mocked
	String mockStr;
	// String mockStr = org.mockit.Mockit.mock(String.class);

	public void show() {
		System.out.println();
	}
}
