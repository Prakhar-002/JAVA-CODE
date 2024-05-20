public class SubString {

      // subString ... through backtracking ... time complexity is n*2**n n in to 2 ki
      // power n

      public static void subString(String str, String ans, int i) {
            // base case
            if (i == str.length()) {
                  if (ans == "") {
                        System.out.println("NULL");
                  } else {
                        System.out.println(ans);
                  }
                  return;
            }
            // yes choice of a character
            subString(str, ans + str.charAt(i), i + 1);
            // no choice
            subString(str, ans, i + 1);
      }

      public static void subStringCall(String str) {
            subString(str, "", 0);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            subStringCall("hl");
      }

      // ? Output
      //  1. 
      //     hl
      //     h
      //     l
      //     NULL
}
