package basic.case02.test;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class CommonProcess implements TestRule {

	public CommonProcess() {
		System.out.println("共通処理のテスト!ルールで記述した処理!!");
	}

	@Override
	public Statement apply(Statement arg0, Description arg1) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
