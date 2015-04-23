package mockito.case01;

public class Tekitou {
	private String strTekitou = "適当な初期化";
	private int intTekitou = 555;

	public Tekitou() {
		this.strTekitou = "適当なテスト";
		this.intTekitou = 444;
	}

	public String getStrTekitou() {
		return strTekitou;
	}
	public void setStrTekitou(String strTekitou) {
		this.strTekitou = strTekitou;
	}
	public int getIntTekitou() {
		return intTekitou;
	}
	public void setIntTekitou(int intTekitou) {
		this.intTekitou = intTekitou;
	}
}
