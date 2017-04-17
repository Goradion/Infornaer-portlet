package game.infonaer.game;

public class AudienceJokerResult {
	private double percentA;
	private double percentB;
	private double percentC;
	private double percentD;

	public AudienceJokerResult(double percentA, double percentB, double percentC, double percentD) {
		super();
		this.percentA = percentA;
		this.percentB = percentB;
		this.percentC = percentC;
		this.percentD = percentD;
	}
	
	public double getPercentA() {
		return percentA;
	}
	public double getPercentB() {
		return percentB;
	}
	public double getPercentC() {
		return percentC;
	}
	public double getPercentD() {
		return percentD;
	}

	@Override
	public String toString() {
		return "AudienceJokerResult [percentA=" + percentA + ", percentB=" + percentB + ", percentC=" + percentC
				+ ", percentD=" + percentD + "]";
	}
	

	
}
