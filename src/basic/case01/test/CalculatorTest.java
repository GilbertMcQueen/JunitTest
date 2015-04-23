package basic.case01.test;

import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.hasItem;
import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.hamcrest.CoreMatchers.*;
import static basic.case01.test.IsNumber.*;
import java.util.ArrayList;
import basic.case01.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

//@RunWith(Theories.class)
//@RunWith(Enclosed.class)
public class CalculatorTest {

	/**
	 * テストデータをパラメータ化したテスト
	 */
	@DataPoints
	static public int num1[] = { 1, 2, 3, 4 };
	@DataPoints
	static public int num2[] = { 5, 6, 7, 8 };

	@Theory
	@Before
	public void pre() {
		System.out.println("call!!pre");
	}

	@Theory
	public void Theoryテスト(int num1, int num2) {
		System.out.println("num1:" + num1 + " | num2:" + num2);
	}

	@Theory
	@After
	public void end() {
		System.out.println("call!!end");
	}

	/**
	 * 通常の値で乗算を行うテスト１
	 */
	@Test
	public void multipyで3と4の乗算結果が取得できる() {
		Calculator calc = new Calculator();
		int expected = 12;
		int actual = calc.multiply(3, 4);
		assertThat(actual, is(expected));
	}

	/**
	 * 通常の値で乗算を行うテスト２
	 */
	@Test
	public void multipyで5と7の乗算結果が取得できる() {
		Calculator calc = new Calculator();
		int expected = 35;
		int actual = calc.multiply(5, 7);
		assertThat(actual, is(expected));
	}

	/**
	 * 通常の値で乗算を行うテスト３ (自作マッチャー)
	 */
	@Test
	public void multipyの結果が10か20() {
		Calculator calc = new Calculator();
		int actual = calc.multiply(5, 7);
		actual = 10;
		assertThat(actual, is(numberOf(10, 20)));
	}

	/**
	 * いろいろなMatcherAPIメソッド
	 */
	@Test
	public void 厳密な確認() {
		Calculator calc = new Calculator();
		int expected = 12;
		int actual = calc.multiply(3, 4);

		// ****************
		// * CoreMatchers *
		// ****************
		// actual(実測値)がnullでないこと
		assertThat(actual, is(notNullValue()));
		// actual(実測値)が同じインスタンスであること(==演算子と同じ)
		assertThat(actual, is(sameInstance(expected)));
		// actual(実測値)が指定のクラスと互換性があること(instanceOf演算子と同じ)
		assertThat(actual, is(instanceOf(Integer.class)));
		// actual(実測値)とexpected(期待値)が同じであること(equalsと同じ)
		assertThat(actual, is(expected));

		// *****************
		// * JUnitMatchers *
		// *****************
		ArrayList<String> actualList = new ArrayList<String>();
		// actual(実測値)のリストや配列に指定のアイテムが含まれていること
		assertThat(actualList, hasItem("test"));
		// actual(実測値)のリストや配列に複数ある指定のアイテムが含まれていること
		assertThat(actualList, hasItems("test1", "test2"));
	}

	/**
	 * 通常の値で除算を行うテスト
	 */
	@Test
	public void divideで3と2の除算結果が取得できる() {
		Calculator calc = new Calculator();
		float expected = 1.5f;
		float actual = calc.divide(3, 2);
		assertThat(actual, is(expected));
	}

	/**
	 * 0で除算したときに例外を投げるテスト
	 */
	@Test(expected = IllegalArgumentException.class)
	public void divideで5と0のときIllegalArgumentExceptionを送出する() {
		Calculator calc = new Calculator();
		calc.divide(5, 0);
	}

	/**
	 * 何でも失敗させるテスト
	 */
	@Test
	public void 何か難しいけど重要なテストケース() {
		fail("runが呼ばれてしまった");
	}

	/**
	 * @author y_kusano クラスをネストして指定したテストケースを実行するテスト
	 */
	@RunWith(Enclosed.class)
	public static class Enclosedテスト {

		/**
		 * @author y_kusano ネストしたクラス１
		 */
		public static class 引数が3と4の場合 {

			/**
			 * 必ず最初に実行される処理
			 */
			@Before
			public void setup() {
				System.out.println("ケース1");
			}

			/**
			 * 通常の値で乗算を行うテスト１
			 */
			@Test
			public void multipyで3と4の乗算結果が取得できる() {
				Calculator calc = new Calculator();
				int expected = 12;
				int actual = calc.multiply(3, 4);
				assertThat(actual, is(expected));
			}

			/**
			 * 通常の値で乗算を行うテスト２
			 */
			@Test
			public void divideで3と2の除算結果が取得できる() {
				Calculator calc = new Calculator();
				float expected = 1.5f;
				float actual = calc.divide(3, 2);
				assertThat(actual, is(expected));
			}

			/**
			 * 必ず最後に実行される処理
			 */
			@After
			public void out() {
				System.out.println("ケース1の終了");
			}
		}

		/**
		 * @author y_kusano ネストしたクラス２
		 */
		public static class 引数が5と10の場合 {

			/**
			 * 必ず最初に実行される処理
			 */
			@Before
			public void setup() {
				System.out.println("ケース2");
			}

			/**
			 * 通常の値で乗算を行うテスト１
			 */
			@Test
			public void multipyで5と10の乗算結果が取得できる() {
				Calculator calc = new Calculator();
				int expected = 50;
				int actual = calc.multiply(5, 10);
				assertThat(actual, is(expected));
			}

			/**
			 * 通常の値で乗算を行うテスト２
			 */
			@Test
			public void divideで5と10の除算結果が取得できる() {
				Calculator calc = new Calculator();
				float expected = 0.5f;
				float actual = calc.divide(5, 10);
				assertThat(actual, is(expected));
			}

			/**
			 * 必ず最後に実行される処理
			 */
			@After
			public void out() {
				System.out.println("ケース2の終了");
			}
		}
	}
}
