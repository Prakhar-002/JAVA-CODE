// import java.util.*;

public class BitWIseOPR{
      public static void opr(){
            // and operator...
            System.out.println(5&6); // 0&0 :0  0&1 :0  1&0 :0  1&1 :1 
            // or operator ...
            System.out.println(4|5); // 1|1 :1  1|0 :1  0|1 :1  0|0 :0 
            // XOR OPERATOR ...
            System.out.println(4^5); // same to 0 ...diff to 1
            //binary one's compliment 
            System.out.println(~0); //ulta 
            // left shift ...
            System.out.println(5<<2); // a<<b =a*(2^b) a into 2 ki power b
            // right shift ...
            System.out.println(3>>1); // a>>b =a/(2^b) a div by 2 ki power b 

            // odd or even ... for odd LSB is 1 and for even LSB is 0  
      }  

      public static void oddOrEven(int n){
            int bitmask=1;
            if((n&bitmask) ==1){
                  System.out.println("number is odd...");
            }else{
                  System.out.println("number is even...");
            }
      } 

      public static void getIthBit(int n,int i){
            int bitMask= 1<<i;
            if((n&bitMask)== 0){
                  System.out.println("0");
            }else{
                  System.out.println("1");
            }
      }

      public static void setIthBit(int n,int i){
            int bitMask= 1<<i;
            System.out.println(n|bitMask);
      }

      public static int clearIthBit(int n,int i){
            int bitMask= ~(1<<i);
            System.out.println(n&bitMask);
            return (n&bitMask);
      }

      public static void updateIthBit(int n,int i,int newBit){
            // if(newBit==0){
            //       clearIthBit(n, i);
            // }else{
            //       setIthBit(n, i);
            // } 

            // or 

            n =clearIthBit(n, i);
            int bitmask =newBit<<i;
            System.out.println((n|bitmask));
      } 

      public static void clearIBits(int n,int i){
            int bitMask=(~0)<<i;
            System.out.println(n & bitMask);
      }

      public static void clearBitsInRange(int n,int i,int j){
            int a=((~0)<<(j+1));
            int b =(1<<i)-1;
            int bitMask =a|b;
            System.out.println(n & bitMask);
      }

      public static boolean isNumPowOfTwo(int n){
            return (n&(n-1)) ==0;
      }

      public static void isNumPowOfTwoCall(int n){
            if(isNumPowOfTwo(n)==false){
                  System.out.println("num is not a power of 2 ...");
            }else{
                  System.out.println("num is power of 2 ...");
            }
      }

      public static void countSetBits(int n){
            int count =0;
            while(n>0){
                  if((n&1) !=0){ //count our LSB
                        count++;
                  }
                  n=n>>1;
            }
            System.out.println(count);
      }

      public static void fastExpo(int a,int n){
            int ans =1;
            while(n>0){
                  if((n & 1) !=0){
                        ans = ans*a;
                  }
                  a =a*a;
                  n = n>>1;
            }
            System.out.println(ans);
      }

      // modular expo


      public static void main(String args[]){
            fastExpo(3, 5);
      }
}
