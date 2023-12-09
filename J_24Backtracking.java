import java.util.Scanner;

public class J_24Backtracking {

      // correct or edit in array ...
      public static void arrEdit(int arr[], int i, int val) {
            // base case...
            if (i == arr.length) {
                  printArr(arr);
                  return;
            }
            // recursion call...
            arr[i] = val;
            arrEdit(arr, i + 1, val + 1);
            arr[i] = arr[i] - 2; // backtracking...
      }

      public static void EditArrCall() {
            int arr[] = new int[5];
            arrEdit(arr, 0, 1);
            printArr(arr);
      }

// ------------------------------------------------------------------------------------

      // subString ... through backtracking ... time complexity is n*2**n n in to 2 ki
      // power n

      public static void subString(String str, String ans, int i) {
            // base case
            if (i == str.length()) {
                  if (ans == "") {
                        System.out.println("NULL");
                  } else {
                        System.out.println(ans);
                  }
                  return;
            }
            // yes choice of a character
            subString(str, ans + str.charAt(i), i + 1);
            // no choice
            subString(str, ans, i + 1);
      }

      public static void subStringCall(String str) {
            subString(str, "", 0);
      }

      // ------------------------------------------------------------------------------------

      // find permutation of string ...
      public static void permutationString(String str, String ans) {
            // base case
            if (str.length() == 0) {
                  System.out.println(ans);
                  return;
            }
            // recursion
            for (int i = 0; i < str.length(); i++) {
                  char cur = str.charAt(i);
                  String newString = str.substring(0, i) + str.substring(i + 1);
                  permutationString(newString, ans + cur);
            }
      }

      public static void permutationStringCall(String str) {
            permutationString(str, "");
      }

      // print array function...
      public static void printArr(int arr[]) {
            for (int i = 0; i < arr.length; i++) {
                  System.out.print(arr[i] + " ");
            }
            System.out.println();
      }

      // --------------------------------------------------------------------------------------

      // N Queen program... time complexity is n! n factorial

      // count solution for N*N chess board...
      static int countSolQueen = 0;

      // Is safe will check for the place of queen...
      public static Boolean isSafe(char chessBoard[][], int row, int col) {
            // check for vertical
            for (int i = row - 1; i >= 0; i--) {
                  if (chessBoard[i][col] == 'Q') {
                        return false;
                  }
            }

            // check for left vertical
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                  if (chessBoard[i][j] == 'Q') {
                        return false;
                  }
            }
            // check for right vertical position
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

      // ------------------------------------------------------------------------------------------
      // grid ways problem... time complexity is 2 ki power n*m ...very bad
      // (n-1 + m-1)! / (n-1)! * (m-1)! formula to found ans...
      // if we apply formula them complexity will be O(n)
      public static int gridWays(int i, int j, int n, int m) {
            if (i == n - 1 && j == m - 1) {
                  return 1;
            } else if (i == n || j == m) {
                  return 0;
            }

            int way1 = gridWays(i + 1, j, n, m);
            int way2 = gridWays(i, j + 1, n, m);
            return way1 + way2;
      }

      public static void gridWaysCall() {
            int n, m;
            System.out.println("Enter the grid dimension...");
            Scanner Joe = new Scanner(System.in);
            n = Joe.nextInt();
            m = Joe.nextInt();
            int ways = gridWays(0, 0, n, m);
            System.out.println("Total ways to get to target is :" + ways);
            Joe.close();
      }

      // ----------------------------------------------------------------------------------------

      // sudoku solver ...

      // isSafe will give the right position and the value of digit
      public static boolean isSafeSudoku(int sudoku[][],int row , int col,int digit){
            // column
            for (int i = 0; i <= 8; i++) {
                  if(sudoku[i][col] == digit){
                        return false;
                  }
            }

            // row 
            for (int j = 0; j <= 8; j++) {
                  if(sudoku[row][j] == digit){
                        return false;
                  }
            }

            // grid...
            int startRow =(row/3)*3;
            int startCol = (col/3)*3;

            for(int i=startRow; i<startRow+3;i++){
                  for(int j =startCol ;j <startCol+3;j++){
                        if(sudoku[i][j] == digit){
                              return false;
                        }
                  }
            }
            return true;
      }


      public static boolean sudokuSolver(int sudoku[][],int row , int col){
            // base case 
            if(row == 9 ){
                  return true;
            }

            // row and column selector or updater
            int nextRow = row ,nextCol = col+1;
            if(col+1 == 9){
                  nextRow = row+1;
                  nextCol =0;
            }

            //  sudoku will not run if sum default value is there 
            if(sudoku[row][col] != 0){
                  return sudokuSolver(sudoku, nextRow, nextCol);
            }

            // update or fill the value in sudoku

            for (int digit =1;digit <=9 ; digit++){
                  if(isSafeSudoku(sudoku ,row, col ,digit)){
                        sudoku[row][col] = digit;
                        if(sudokuSolver(sudoku, nextRow, nextCol)){ // solution exists...
                              return true;
                        }
                        sudoku[row][col] =0;
                  }
            }
            return false;
      }

      public static void printSudoku(int sudoku[][]){
            for (int i = 0; i < 9; i++) {
                  for (int j = 0; j < 9; j++) {
                        System.out.print(sudoku[i][j]+ " ");
                  }
                  System.out.println();
            }
      }


      public static void sudokuCall() {
            int sudoku[][] = { 
                        { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                        { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                        { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                        { 1, 8, 5, 0, 6, 0, 0, 2, 0 }, 
                        { 0, 0, 0, 0, 2, 0, 0, 6, 0 }, 
                        { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                        { 0, 3, 0, 0, 7, 2, 0, 0, 4 }, 
                        { 0, 4, 9, 0, 3, 0, 0, 5, 7 }, 
                        { 8, 2, 7, 0, 0, 9, 0, 1, 3 } };

            if(sudokuSolver(sudoku, 0, 0)){
                  System.out.println("Solution exists...");
                  printSudoku(sudoku);
            }else{
                  System.out.println("Solution does not exists...");
            }
      }

      public static void main(String args[]) {
            // 1...EditArrCall();
            // 2...subStringCall("abc");
            // 3...permutationStringCall("abc");
            // 4...queenCall();
            // 5...gridWaysCall();
            // 6...sudokuCall();
            queenCall();
      }
}
