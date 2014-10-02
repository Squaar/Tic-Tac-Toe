public class Main{
	public static void main(String[] args){
		System.out.println("Matt Dumford - mdumfo2@uic.edu");
		if(args.length != 9){
			System.err.println("Incorrect number of arguments.");
			System.exit(1);
		}

		char[][] board = new char[3][3];
		int k = 0;

		// get input and arrange board
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
		System.out.println(game.board().toStringPretty());
		
		// check to see if game is already over
		char winner = game.getWinner();
		if(winner == 'T'){
			System.out.println("This game was a tie.");
			System.exit(0);
		}
		else if(winner == 'X' || winner == 'O'){
			System.out.println("Player " + winner + " has already won the game.");
			System.exit(0);
		}

		// run without alpha beta pruning
		IntSolution optimalMoves = game.getOptimalMoves(false);
		System.out.println("No alpha beta pruning:");
		if(optimalMoves.solution.length == 0){
			System.out.println("No optimal moves found for player X.");
		}
		else{
			System.out.print("The optimal moves for player X are: ");
			for(int i: optimalMoves.solution)
				System.out.print(i + " ");
			System.out.println();
			System.out.println("Expanded nodes: " + optimalMoves.expandedNodes);
		}

		System.out.println();

		// reset and run with alpha beta pruning
		game = new Game(board);
		optimalMoves = game.getOptimalMoves(true);
		System.out.println("Using alpha beta pruning:");
		if(optimalMoves.solution.length == 0){
			System.out.println("No optimal moves found for player X.");
		}
		else{
			System.out.print("The optimal moves for player X are: ");
			for(int i: optimalMoves.solution)
				System.out.print(i + " ");
			System.out.println();
			System.out.println("Expanded nodes: " + optimalMoves.expandedNodes);
		}
	}
}
