package basic.case02.test;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import basic.case02.StringUtil;
import junit.framework.TestCase;

public class StringUtilTest extends TestCase {

	/**
	 * ルールのテスト
	 */
	@Rule
	CommonProcess cp = new CommonProcess();

	/**
	 * 文字分割のテストVer.1
	 */
	@Test
	public void testSplit() {

		System.out.println("テストが走った!文字分割のテストVer.1");


//		List list = new ArrayList();
//		try {
//			list.get(100);
//			fail("IndexOutOfBoundsExceptionを投げてください");
//			System.out.println("failで投げた");
//		} catch (IndexOutOfBoundsException expected) {
//			System.out.println("例外を投げた");
//		}

		// 分割対象の文字
		String str = "a,b,c";

		// カンマで文字列を分割
		String[] result = StringUtil.split(str,",");

		// ***以下、結果を確認***

		// resultはnullではないはず
		assertNotNull(result);

		// 結果が配列に格納されているはず
		assertEquals("a", result[0]);
		assertEquals("b", result[1]);
		assertEquals("c", result[2]);
	}

	/**
	 * 文字分割のテストVer.2
	 */
	@Test
	public void testSplit2() {

		System.out.println("テストが走った!文字分割のテストVer.2");

		// ****1ケース目****
		// 分割対象の文字
		String str = "A*B*C";

		// カンマで文字列を分割
		String[] result = StringUtil.split(str,"\\*");

		// ***以下、結果を確認***

		// resultはnullではないはず
		assertNotNull(result);

		// resultの要素数は、3つあるはず
		assertEquals(3, result.length);

		// 結果が配列に格納されているはず
		assertEquals("A", result[0]);
		assertEquals("B", result[1]);
		assertEquals("C", result[2]);

		// ****2ケース目****
		// 分割対象の文字
		str = "123[SEP]456[SEP]789";

		// カンマで文字列を分割
		result = StringUtil.split(str,"\\[SEP\\]");

		// ***以下、結果を確認***

		// resultはnullではないはず
		assertNotNull(result);

		// resultの要素数は、3つあるはず
		assertEquals(3, result.length);

		// 結果が配列に格納されているはず
		assertEquals("123", result[0]);
		assertEquals("456", result[1]);
		assertEquals("789", result[2]);
	}
}
