// import java.util.*;

public class BitWIseOPR {
      public static void opr() {
            // and operator...
            System.out.println(5 & 6); // 0&0 :0 0&1 :0 1&0 :0 1&1 :1
            // or operator ...
            System.out.println(4 | 5); // 1|1 :1 1|0 :1 0|1 :1 0|0 :0
            // XOR OPERATOR ...
            System.out.println(4 ^ 5); // same to 0 ...diff to 1
            // binary one's compliment
            System.out.println(~0); // ulta
            // left shift ...
            System.out.println(5 << 2); // a<<b =a*(2^b) a into 2 ki power b
            // right shift ...
            System.out.println(3 >> 1); // a>>b =a/(2^b) a div by 2 ki power b

            // odd or even ... for odd LSB is 1 and for even LSB is 0
      }

      // modular expo

      public static void main(String args[]) {
            opr();
      }

      //? Output 
      // 1. 
      //     4
      //     5
      //     1
      //     -1
      //     20
      //     1
      
}
