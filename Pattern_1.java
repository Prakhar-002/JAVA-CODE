import java.util.*;
public class Pattern_1 {
      public static void main (String args[]){
            Scanner sc=new Scanner (System.in);
            System.out.println("Enter a number ...");
            int n=sc.nextInt();
            // int m=sc.nextInt();

            System.out.println("1st...\n");

            // first...
            for (int i=1;i<=n;i++){
                  for(int j=1;j<=i;j++){
                        System.out.print("*");
                  }
                  System.out.println();

            }
            // *
            // **
            // ***
            // ****

            System.out.println("2nd...\n");

            // second 
            for (int i=n;i>=1;i--){
                  for(int j=1;j<=i;j++){
                        System.out.print("*");
                  }
                  System.out.println();

            }
            System.out.println("3rd...\n");

            int count=1;
            for (int i=1;i<n;i++){
                  for(int j=0;j<i;j++){
                        System.out.print(count);
                        count++;

                  }
                  System.out.println();
            }

            System.out.println("4th...\n");
            
            //we can make another variable to take input 
            // Scanner t=new Scanner(System.in); 
            // int apple=t.nextInt();
            // System.out.println(apple);
            sc.close();




      }
}
