import java.util.ArrayList;
import java.awt.Point;

public class Game{
	
	private Board board;
	private Player turn;
	private Player x;
	private Player o;

	public Game(){
		char[][] board = new char[3][3];
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				board[j][i] = 'b';
		this.board = new Board(board);
		this.x = new Player('X');
		this.o = new Player('O');
		this.turn = this.x;
	}

	public Game(char[][] initialBoard){
		this.board = new Board(initialBoard);
		this.x = new Player('X');
		this.o = new Player('O');
		this.turn = this.x;
	}

	public Board board(){
		return this.board;
	}

	public char getWinner(){
		return this.board.winner();
	}

	public int[] getOptimalMoves(){
		if(getWinner() == 'b' || getWinner() == 'T')
			return new int[0];

		ArrayList<Point> optimalMoves =  turn.optimalMoves(board);
		ArrayList<Integer> numerical = new ArrayList<Integer>();
		int k = 0;
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++){
				if(optimalMoves.contains(new Point(j, i)))
					numerical.add(k);
				k++;
			}	

		// java primitives suck
		int[] ans = new int[numerical.size()];
		for(int i=0; i<numerical.size(); i++){
			ans[i] = numerical.get(i);
		}
		return ans;
	}
}
