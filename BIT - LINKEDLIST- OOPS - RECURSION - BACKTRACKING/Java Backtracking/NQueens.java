import java.util.Scanner;

public class NQueens {

      // N Queen program... time complexity is n! n factorial

      // count solution for N*N chess board...
      static int countSolQueen = 0;

      // Is safe will check for the place of queen...
      public static Boolean isSafe(char chessBoard[][], int row, int col) {
            // check for vertical up
            for (int i = row - 1; i >= 0; i--) {
                  if (chessBoard[i][col] == 'Q') {
                        return false;
                  }
            }

            // check for left up Diagonal
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                  if (chessBoard[i][j] == 'Q') {
                        return false;
                  }
            }

            // check for right up Diagonal
            for (int i = row - 1, j = col + 1; i >= 0 && j < chessBoard.length; i--, j++) {
                  if (chessBoard[i][j] == 'Q') {
                        return false;
                  }
            }
            return true;
      }

      public static void nQueen(char chessBoard[][], int row) {
            // base condition
            if (row == chessBoard.length) {
                  printChessBoard(chessBoard);
                  countSolQueen++;
                  return;
            }
            // column loop to place queen ...
            for (int j = 0; j < chessBoard.length; j++) {
                  if (isSafe(chessBoard, row, j)) {
                        chessBoard[row][j] = 'Q';
                        nQueen(chessBoard, row + 1); // recursion ... for all rows queen
                        chessBoard[row][j] = '*'; // backtracking...
                  }
            }
      }

      // print the board function...
      public static void printChessBoard(char chessBoard[][]) {
            System.out.println("-------Chess Board-------");
            for (int i = 0; i < chessBoard.length; i++) {
                  for (int j = 0; j < chessBoard.length; j++) {
                        System.out.print(chessBoard[i][j] + " ");
                  }
                  System.out.println();
            }
      }

      // calling the function ...
      public static void queenCall() {
            System.out.println("Enter the board length...");
            int n;
            Scanner Joe = new Scanner(System.in);
            n = Joe.nextInt();
            char chessBoard[][] = new char[n][n];
            // initialize ...
            for (int i = 0; i < n; i++) {
                  for (int j = 0; j < n; j++) {
                        chessBoard[i][j] = '*';
                  }
            }
            // call the function who will get the right place of a queen...
            nQueen(chessBoard, 0);
            System.out.println("Number of solution for " + n + "*" + n + " chess board is " + countSolQueen);
            Joe.close();
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            queenCall();
      }

      // ? Output
      //  1. 
      //     Enter the board length...
      //     4
      //*    -------Chess Board-------
      //*    * Q * *
      //*    * * * Q
      //*    Q * * *
      //*    * * Q *
      //*    -------Chess Board-------
      //*    * * Q *
      //*    Q * * *
      //*    * * * Q
      //*    * Q * *
      //     Number of solution for 4*4 chess board is 2 

}
