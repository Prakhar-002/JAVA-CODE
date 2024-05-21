import java.util.Scanner;

public class StringBasic {

      public static void stringBasic(){
            String name = "tony";
            String alpha = new String("look");
            System.out.println(name + " " + alpha);

            // input 
            Scanner Joe = new Scanner(System.in);

            String movieName = Joe.nextLine();

            // length 
            System.out.println(movieName.length());  //bracket is imp because this is a function of string but in array that was a property of array...
            // charAt()  for character at any index...
            System.out.println(name.charAt(3));
            Joe.close();
      } 

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            stringBasic();
      }
}
