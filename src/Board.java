import java.awt.Point;
import java.util.ArrayList;

public class Board{
	private char[][] board;

	public Board(char[][] board){
		this.board = board;
	}

	public char winner(){
		for(int i=0; i<board.length; i++){
			if(board[i][0]!='b' && board[i][0]==board[i][1] && board[i][0]==board[i][2])
				return board[i][0];
		}
		for(int i=0; i<board.length; i++){
			if(board[0][i]!='b' && board[0][i]==board[1][i] && board[0][i]==board[2][i])
				return board[0][i];
		}
		if(board[1][1]!='b' && ((board[0][0]==board[1][1] && board[1][1]==board[2][2]) || (board[2][1]==board[1][1] && board[1][1]==board[0][2])))
			return board[1][1];
		return 'b';
	}

	public Point[] possibleMoves(){
		ArrayList<Point> moves = new ArrayList<Point>();
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				if(board[i][j] == 'b')
					moves.add(new Point(j, i));
		return moves.toArray(new Point[0]);
	}

	// returns true or false depending on if the move was successful
	public boolean move(char player, int x, int y){
		if(board[y][x] != 'b')
			return false;
		board[y][x] = player;
		return true;
	}

	public String toString(){
		String str = "";
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				str += this.board[i][j] + " ";
		return str;
	}
}
