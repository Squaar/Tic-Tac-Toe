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

	public ArrayList<Point> optimalMoves(Board board){
		int min = -1;
		ArrayList<Point> mins = new ArrayList<Point>();
		Point[] moves = board.possibleMoves();
		for(Point move: moves){
			Board newBoard = null;
			try{
				newBoard = board.move(symbol, move.x, move.y);
			}
			catch(Exception e){}
			if(newBoard != null){
				int m = min(newBoard);
				if(m == min)
					mins.add(move);
				else if(m > min){
					min = m; 
					mins.clear();
					mins.add(move);
				}
			}
		}
		return mins;
	}
	
	// min of maxes
	public int min(Board board){
		char winner = board.winner();
		if(winner == 'T')
			return 0;
		if(winner == symbol)
			return 1;
		if(winner == opponent)
			return -1;

		Point[] possibleMoves = board.possibleMoves();
		int[] maxes = new int[possibleMoves.length];
		for(int i=0; i<possibleMoves.length; i++){
			try{
				Board newBoard = board.move(opponent, possibleMoves[i].x, possibleMoves[i].y);
				maxes[i] = max(newBoard);
			}
			catch(Exception e){}
		}

		int min = maxes[0];
		for(int max: maxes)
			if(max < min)
				min = max;
		return min;
	}

	// max of mins
	public int max(Board board){
		char winner = board.winner();
		if(winner == 'T')
			return 0;
		if(winner == symbol)
			return 1;
		if(winner == opponent)
			return -1;

		Point[] possibleMoves = board.possibleMoves();
		int[] mins = new int[possibleMoves.length];
		for(int i=0; i<possibleMoves.length; i++){
			try{
				Board newBoard = board.move(symbol, possibleMoves[i].x, possibleMoves[i].y);
				mins[i] = min(newBoard);
			}
			catch(Exception e){}
		}

		int max = mins[0];
		for(int min: mins)
			if(min > max)
				max = min;
		return max;
	}
}
