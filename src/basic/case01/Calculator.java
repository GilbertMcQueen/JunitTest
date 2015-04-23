package basic.case01;

public class Calculator {
	public int multiply(int x,int y) {
		return x * y;
	}
	public float divide(int x,int y) {
		if (y == 0) {
			throw new IllegalArgumentException("devide by zero.");
		}
		return (float)x / (float)y;
	}

//	public int divide(int x,int y) {
//		return x / y;
//	}
}
