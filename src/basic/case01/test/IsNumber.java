package basic.case01.test;


import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
//import java.util.regex.Matcher;
//import static org.junit.Assert.*;
//import org.junit.Before;
//import org.junit.Test;

/**
 * @author y_kusano
 * 自作マッチャークラス
 */
public class IsNumber extends BaseMatcher<Integer> {

	private final int num1;
	private final int num2;

	public IsNumber() {
		this.num1 = 10;
		this.num2 = 20;
	}
	public IsNumber(int num1,int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	/**
	 * 指定した2つの値のうち、どちらかの値があればテスト成功
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static org.hamcrest.Matcher<Integer> numberOf(int num1,int num2) {
		return new IsNumber(num1,num2);
	}

	@Override
	public boolean matches(Object actual) {
		if (this.num1 == (Integer)actual) {
			return true;
		}else if (this.num2 == (Integer)actual) {
			return true;
		}
		return false;
	}

	@Override
	public void describeTo(Description arg0) {
		System.out.println("違う");
	}
}
