package basic.case02.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ StringUtilTest.class })
public class AllTests {

//	public static void main(String[] args) {
//		junit.swingui.TestRunnner.run(AllTestes.class);
//	}

//	public static Test suite() {
//		TestSuite suite = new TestSuite();
//
//		// テストケースを指定
//		suite.addTestSuite(StringUtilTest.class);
//
//		return suite;
//
//	}
}
