import java.awt.Point;
import java.util.ArrayList;

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

	public ArrayList<Point> optimalMoves(Board boar){
	
		return new ArrayList<Point>();
	}
	
	public int min(Board board){
		return 0;
	}

	public int max(Board board){
		return 0;
	}
}
