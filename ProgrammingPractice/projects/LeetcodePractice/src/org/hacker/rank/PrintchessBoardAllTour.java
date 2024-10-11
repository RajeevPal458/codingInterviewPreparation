package org.hacker.rank;

public class PrintchessBoardAllTour {
  static int[][] ChessBoard ;
	// Stores the 8 possible combinations of
    // moves that the knight can follow
    static int[] DirX = { 2, 1, -1, -2, -2, -1, 1, 2 };
    static int[] DirY = { 1, 2, 2, 1, -1, -2, -2, -1 };
 
    // Function to find if (i, j) is a valid
    // cell for the knight to move and it
    // exists within the chessboard
    static boolean isSafe(int i, int j, int n, int[][] Board) {
        return (i >= 0 && j >= 0 && i < n && j < n && Board[i][j] == 0);
    }
 
    // Stores whether there exist any valid path
    static boolean isPossible = false;
 
    // Recursive function to iterate through all
    // the paths that the knight can follow
    static void knightTour(int N, int x, int y, int visited)
    {
        // Mark the current square of the chessboard
        ChessBoard[x][y] = visited;
 
        // If the number of visited squares are equal
        // to the total number of squares
        if (visited == N * N) {
            isPossible = true;
 
            // Print the current state of ChessBoard
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(ChessBoard[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
 
            // Backtrack to the previous move
            ChessBoard[x][y] = 0;
            return;
        }
 
        // Iterate through all the eight possible moves
        // for a knight
        for (int i = 0; i < 8; i++) {
 
            // Stores the new position of the knight
            // after a move
            int newX = x + DirX[i];
            int newY = y + DirY[i];
 
            // If the new position is a valid position
            // recursively call for the next move
            if (isSafe(newX, newY, N, ChessBoard)) {
                knightTour(N, newX, newY,visited + 1);
            }
        }
 
        // Backtrack to the previous move
        ChessBoard[x][y] = 0;
    }
 
    // Driver Code
    public static void main(String args[]) {
        ChessBoard = new int[5][5];
 
        int N = ChessBoard.length;
        
        knightTour(N, 0, 0, 1);
 
        // If no valid sequence of moves exist
        if (isPossible == false) {
            System.out.println(-1);
        }
    }
}
