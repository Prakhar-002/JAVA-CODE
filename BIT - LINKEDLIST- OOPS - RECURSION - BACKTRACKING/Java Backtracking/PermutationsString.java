public class PermutationsString {

      // find permutation of string ... O( n * n! )
      public static void permutationString(String str, String ans) {
            // base case
            if (str.length() == 0) {
                  System.out.println(ans);
                  return;
            }
            // recursion
            for (int i = 0; i < str.length(); i++) {
                  char cur = str.charAt(i);
                  String newString = str.substring(0, i) + str.substring(i + 1); /* removing the selected element from actual string */
                  permutationString(newString, ans + cur);
            }
      }

      public static void permutationStringCall(String str) {
            permutationString(str, "");
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            permutationStringCall("hlw");
      }

      // ? Output
      //  1. 
      //     hlw
      //     hwl
      //     lhw
      //     lwh
      //     whl
      //     wlh 
}
