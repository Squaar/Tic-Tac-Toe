import java.util.Arrays;

public class Main{
	public static void main(String[] args){
		if(args.length != 9){
			System.err.println("Incorrect number of arguments.");
			System.exit(1);
		}

		char[][] board = new char[3][3];
		int k = 0;

		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(args[k].charAt(0) != 'b' && args[k].charAt(0) != 'X' && args[k].charAt(0) != 'O'){
					System.err.println("Unknown symbol " + args[k].charAt(0) + ". Please only use ['b', 'X', 'O']");
					System.exit(2);
				}
				board[i][j] = args[k].charAt(0);
				k++;
			}
		}

		Game game = new Game(board);
		System.out.println(game.board());
	}
}
