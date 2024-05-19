public class Palindrome {

      public static void isPalindrome(String str){
            for (int i = 0; i < str.length()/2; i++) {
                  int n = str.length();
                  if(str.charAt(i) != str.charAt(n-i-1)){
                        System.out.println("This is  not a palindrome string...");
                        return ;
                  } 
            }
            System.out.println("This is a palindrome string...");
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            isPalindrome("KillBroJson");
      }

      //? Output 
      // 1. 
      //     This is  not a palindrome string...

      
}
