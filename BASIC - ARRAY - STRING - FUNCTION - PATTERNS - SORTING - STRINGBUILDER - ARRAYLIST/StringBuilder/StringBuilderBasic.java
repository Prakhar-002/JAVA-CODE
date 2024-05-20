import java.util.*;

// STRINGS ARE IMMUTABLE ...
public class StringBuilderBasic {

      // we can convert an object to string by writing sb.toString()...
      // int a = 10 ...a.toString() will not convert 
      //because it is not as object but INTEGER a = 10 will convert to string

      public static void stringBuilder(){
            // we use stringBuilder instant of string because it is a immutable...
            StringBuilder sb = new StringBuilder("");
            for(char ch = 'a'; ch <='z'; ch++){
                  sb.append(ch);
            }
            System.out.println(sb);
            System.out.println(sb.length());
      }

      public static void main (String args[]){
            stringBuilder();
      }

      //? Output

      //    abcdefghijklmnopqrstuvwxyz
      //    26
}
