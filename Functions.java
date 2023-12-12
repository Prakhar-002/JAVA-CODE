import java.util.*;
public class Functions {

      public static int hlw (){
            System.out.println("hlw lalit");
            System.out.println("krishna");
            System.out.println("dj");
            return 3;
      }

      public static int sum(int n,int m){   //parameters and formal parameter
            return n+m;
      }

      public static int ncr(int n,int r){
            int f=1;
            int fr=1;
            if(n>=r){
                  for(int i=n;i>n-r;i--){
                        f*=i;
                  }
                  for(int i=r;i>1;i--){
                        fr*=i;
                  }
            }else{
                  System.out.println("are yrr mad hai kya....");
            }
            return f/fr;
      }

      // to check a number is prime or not...
      public static Boolean prime(int n) {
            for(int i=2;i<=Math.sqrt(n);i++){
                  if(n%i==0){
                        return false;
                  }
            }
            return true;
      }

      //print up to n prime number...
      public static void nPrime (){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter a number for prime number up to...");
            int prime=sc.nextInt();
            for(int i=2;i<prime;i++){
                  if (prime(i)){
                        System.out.print(i+" ");
                  }
            }
            sc.close();
      }


      //binary to decimal ...

      public static void binToDec(int bin){
            int sum=0;
            int i=0;
            while(bin>0){
                  int res=bin%10;
                  sum+=res*Math.pow(2,i);
                  i++;
                  bin=bin/10;
            }
            System.out.println(sum);
      }

      //decimal to binary...

      public static void decToBin(int n){
            int bin =0;
            int i=0;
            while(n>0){
                  int res=n%2;
                  bin+=res*(int)Math.pow(10, i);
                  i++;
                  n=n/2;

            }
            System.out.println("binary number is "+bin);

      }


      public static void main (String args[]){
            // System.out.println("hlw");
            // hlw();
            Scanner sc=new Scanner(System.in);
            // int n=sc.nextInt();
            // int r=sc.nextInt();
            // System.out.println(sum(a,b));   //actual parameter ...arguments
            // System.out.println(ncr(n, r));
            // System.out.println(prime(n));
            // nPrime();
            System.out.println("enter a decimal number");
            int n =sc.nextInt();
            decToBin(n);
            sc.close();
      }
}
