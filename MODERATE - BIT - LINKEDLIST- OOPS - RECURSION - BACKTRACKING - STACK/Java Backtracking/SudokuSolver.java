public class SudokuSolver {
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
            int startRow =(row / 3) * 3;
            int startCol = (col / 3) * 3;

            for(int i=startRow; i<startRow+3;i++){
                  for(int j = startCol; j < startCol + 3; j++){
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

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            sudokuCall();
      }

      // ? Output
      //  1. 
      //     Solution exists...
      //     2 1 8 3 9 6 7 4 5 
      //     4 9 6 1 5 7 8 3 2
      //     7 5 3 2 8 4 1 9 6
      //     1 8 5 7 6 3 4 2 9
      //     3 7 4 9 2 8 5 6 1
      //     9 6 2 4 1 5 3 7 8
      //     5 3 1 6 7 2 9 8 4
      //     6 4 9 8 3 1 2 5 7
      //     8 2 7 5 4 9 6 1 3 
}
