import java.awt.Point;

public class Player{

	private char symbol;

	public Player(char symbol){
		this.symbol = symbol;
	}

	public char symbol(){
		return this.symbol;
	}

	public Point play(){
		return null;
	}

	public int[] optimalMoves(Board boar){
	
		return new int[0];
	}
	
	public int min(Board board){
		return 0;
	}

	public int max(Board board){
		return 0;
	}
}
