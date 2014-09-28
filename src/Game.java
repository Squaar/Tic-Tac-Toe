public class Game{
	
	private Board board;
	private char turn;

	public Game(){
		char[][] board = new char[3][3];
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				board[j][i] = 'b';
		this.board = new Board(board);
		this.turn = 'X';
	}

	public Game(char[][] initialBoard){
		this.board = new Board(initialBoard);
		this.turn = 'X';
	}
}
