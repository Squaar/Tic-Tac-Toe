import java.awt.Point;
import java.util.ArrayList;

public class Player{

	private char symbol;
	private char opponent;

	public Player(char symbol){
		this.symbol = symbol;
		if(symbol == 'X')
			this.opponent = 'O';
		else
			this.opponent = 'X';
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
		char winner = board.winner();
		if(winner == 'T')
			return 0;
		if(winner == symbol)
			return 1;
		if(winner == opponent)
			return -1;

		//return max of mins?
		Point[] possibleMoves = board.possibleMoves();
		int[] mins = new int[possibleMoves.length];
		for(int i=0; i<possibleMoves.length; i++){
			Board newBoard = board.move(symbol, move.x, move.y);
			mins[i] = min(newBoard);
		}

	}
}
