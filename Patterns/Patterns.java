import java.util.Scanner;

class Patterns {

      //Hollow rectangular pattern

      public static void pattern1(int n,int m){
            for (int i=0;i<n;i++){
                  for(int j=0;j<m;j++){
                        if(i==0||i==n-1||j==0||j==m-1){
                              System.out.print("*");
                        }else{
                              System.out.print(" ");
                        }
                  }
                  System.out.println();
            }
      }

      // *****
      // *   *
      // *   *
      // *   *
      // *****

      //INVERTED & ROTATED HALF-PYRAMID...

      public static void pattern2(int n){
            for(int i=1;i<=n;i++){
                  for(int j=n-i;j>0;j--){
                        System.out.print(" ");
                  }
                  for(int j=1;j<=i;j++){
                        System.out.print("*");
                  }
                  System.out.println();
            }
      }

      //    *
      //   **
      //  ***
      // ****

      //INVERTED HALF-PYRAMID with Numbers...

      public static void pattern3(int n){
            for(int i=n;i>=1;i--){
                  for(int j=1;j<=i;j++){
                        System.out.print(j+" ");
                  }
                  System.out.println();
            }
      }

      // 1 2 3 4 5
      // 1 2 3 4
      // 1 2 3
      // 1 2
      // 1

      // floyd's triangle...

      public static void pattern4(int n){
            int count=1;
            for(int i=1;i<=n;i++){
                  for(int j=1;j<=i;j++){
                        System.out.print(count+" ");
                        count++;
                  }
                  System.out.println();
            }
      }

      // 1
      // 2 3
      // 4 5 6
      // 7 8 9 10
      // 11 12 13 14 15


      //0-1 triangle ...
      
      public static void pattern5(int n){
            for(int i=1;i<=n;i++){
                  for(int j=1;j<=i;j++){
                        if((i+j)%2==0){
                              System.out.print("1"+" ");
                        }else{
                              System.out.print("0"+" ");
                        }
                        
                  }
                  System.out.println();
            }
      }

      // 1
      // 0 1
      // 1 0 1
      // 0 1 0 1
      // 1 0 1 0 1

      //butterfly pattern...

      public static void pattern6(int n){
            for(int i=1;i<=n;i++){
                  for(int j=1;j<=i;j++){
                        System.out.print("*"+" ");
                  }
                  for(int j=2*(n-i);j>=2;j=j-2){
                        System.out.print("    ");
                  }
                  for(int j=1;j<=i;j++){
                        System.out.print("*"+" ");
                  }
                  

                  System.out.println();
            }
            for(int i=n;i>=1;i--){
                  for(int j=1;j<=i;j++){
                        System.out.print("*"+" ");
                  }
                  for(int j=2*(n-i);j>=2;j=j-2){
                        System.out.print("    ");
                  }
                  for(int j=1;j<=i;j++){
                        System.out.print("*"+" ");
                  }
                  

                  System.out.println();
            }
      }

      // *                 *
      // * *             * *
      // * * *         * * *
      // * * * *     * * * *
      // * * * * * * * * * *
      // * * * * * * * * * *
      // * * * *     * * * *
      // * * *         * * *
      // * *             * *
      // *                 * 

      //solid rhombus...

      public static void pattern7(int n){
            for(int i=n;i>=1;i--){
                  for(int j=1;j<=i-1;j++){  
                        System.out.print("  ");                     
                  }
                  for(int j=0;j<n;j++){
                        System.out.print("*"+" ");
                  }
                  System.out.println();
            }
      }

      //         * * * * *
      //       * * * * *
      //     * * * * *
      //    * * * * *
      //  * * * * *


      //hollow rhombus...

      public static void pattern8(int n){
            for(int i=n;i>=1;i--){
                  for(int j=1;j<=i-1;j++){  
                        System.out.print("  ");                     
                  }
                  for(int j=1;j<=n;j++){
                        if(i==1||i==n||j==1||j==n){
                              System.out.print("*"+" ");
                        }else{
                              System.out.print("  ");
                        }
                  }
                  System.out.println();
            }
      }

      //          * * * * *
      //        *       *
      //      *       *
      //    *       *
      //  * * * * *


      //diamond...

      public static void pattern9(int n){
            for(int i=1;i<=n;i++){
                  for(int j=n-i;j>0;j--){
                        System.out.print("  ");
                  }
                  for(int j=2;j<=2*i;j++){
                        System.out.print("*"+" ");
                  }
                  System.out.println();
            }
            for(int i=n;i>=1;i--){
                  for(int j=n-i;j>0;j--){
                        System.out.print("  ");
                  }
                  for(int j=2;j<=2*i;j++){
                        System.out.print("*"+" ");
                  }
                  System.out.println();
            }
      }

      //           *
      //         * * *
      //       * * * * *
      //     * * * * * * *
      //   * * * * * * * * *
      //   * * * * * * * * *
      //     * * * * * * *
      //       * * * * *
      //         * * *
      //           *
      

      public static void main(String args[]){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            // int m=sc.nextInt();
            pattern9(n);
            sc.close();

      }
}
