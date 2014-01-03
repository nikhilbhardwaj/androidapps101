package in.nikhilbhardwaj.luckyseven;

public class NaiveDice implements Dice {
	private int lastRoll = -1;

	@Override
	public int roll() {
		lastRoll =  (int) (1 + (Math.random() * (getNumberOfFaces() - 1)));
		return lastRoll;
	}

	@Override
	public int getNumberOfFaces() {
		// This is a standard dice
		return 6;
	}

	@Override
	public String toString() {
		return "The last roll returned " + lastRoll;
		
	}
}
