import java.awt.Point;
import java.util.ArrayList;

public class Board{
	private char[][] board;

	public Board(char[][] board){
		this.board = board;
	}

	// check to see if game is over, returns who won, T=tie, b=game isn't over yet.
	public char winner(){
		// check for tie
		boolean found = false;
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				if(board[i][j] == 'b')
					found = true;
		if(!found)
			return 'T';

		// check rows
		for(int i=0; i<board.length; i++){
			if(board[i][0]!='b' && board[i][0]==board[i][1] && board[i][0]==board[i][2])
				return board[i][0];
		}

		// check columns
		for(int i=0; i<board.length; i++){
			if(board[0][i]!='b' && board[0][i]==board[1][i] && board[0][i]==board[2][i])
				return board[0][i];
		}

		// check diagonals
		if(board[1][1]!='b' && ((board[0][0]==board[1][1] && board[1][1]==board[2][2]) || (board[2][1]==board[1][1] && board[1][1]==board[0][2])))
			return board[1][1];

		// return b if game isn't over
		return 'b';
	}

	// returns locations of blank spots on the board
	public Point[] possibleMoves(){
		ArrayList<Point> moves = new ArrayList<Point>();
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				if(board[i][j] == 'b')
					moves.add(new Point(j, i));
		return moves.toArray(new Point[0]);
	}

	// generates new board when a player makes a move
	// throws exception when a player can't move there.
	public Board move(char player, int x, int y) throws Exception{
		if(board[y][x] != 'b')
			throw new Exception("Can't move there.");
		char[][] newBoard = new char[3][3];
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++){
				if(i==y && j==x)
					newBoard[i][j] = player;
				else
					newBoard[i][j] = this.board[i][j];
			}
		return new Board(newBoard);
	}

	public String toString(){
		String str = "";
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				str += this.board[i][j] + " ";
		return str;
	}

	public String toStringPretty(){
		String str = "";
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(this.board[i][j] != 'b')
					str += this.board[i][j];
				else
					str += "_";
			}
			str += "\n";
		}
		return str;
	}
}
