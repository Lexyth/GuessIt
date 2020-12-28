
public class Game {

	private UserView userView;
	
	private int target;
	//TODO add gui to change difficulty
	private int difficulty;
	
	private boolean alreadyWon;
	
	Game(UserView view) {
		
		userView = view;
	}
	
	public void init() {
		
		target = 0;
		setDifficulty(100);
		alreadyWon = false;
		
		reset();
	}
	
	public void guess() {
		
		if (alreadyWon) {
			
			userView.comment("You have to restart!");
			return;
		}
		
		int g = userView.getGuess();
		
		if (g == -1) {	
			
			userView.comment("Input not valid!");
			
		}else if (g<target) {
			
			userView.answer("Try higher!");
		} else if (g>target) {
			
			userView.answer("Try lower!");
		} else if (g==target) {
			
			userView.answer("Congratulations!");
			alreadyWon = true;
		}
	}
	
	public void reset() {
		
		target = (int)(Math.random()*100);
		alreadyWon = false;
		userView.comment("Reset was successful.");
	}
	
	public void setDifficulty(int d) {
		
		difficulty = d;
	}
	
	public int getDifficulty() {
		
		return difficulty;
	}
}
