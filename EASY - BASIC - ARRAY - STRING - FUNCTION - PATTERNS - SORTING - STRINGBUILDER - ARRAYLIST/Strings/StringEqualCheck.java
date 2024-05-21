public class StringEqualCheck {

      public static void stringEqual(String str1, String str2){
            if(str1.equals(str2)){
                  System.out.println("Strings are equal ...");
            }else{
                  System.out.println("Strings are not equal...");
            }
      }

      public static void stringEqualCall(){
            String s1 = "tony";
            String s2 = new String("tony");
            // in this condition s1 and s2 are not equal as we check it like s1==s2...
            stringEqual(s1, s2);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            stringEqualCall();
      }

      //? Output 
      // 1. 
      //     Strings are equal ...
      
}
