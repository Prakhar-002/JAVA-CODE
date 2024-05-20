public class RemoveDuplicates {

      // remove duplicates in a string...
      public static void removeDuplicates(String str, int i, boolean map[], StringBuilder newStr) {
            if (i == str.length()) {
                  System.out.println(newStr);
                  return;
            }
            char currentChar = str.charAt(i);
            if (map[currentChar - 'a'] == true) {
                  // duplicates
                  removeDuplicates(str, i + 1, map, newStr);
            } else {
                  // add to string builder ...
                  map[currentChar - 'a'] = true;
                  removeDuplicates(str, i + 1, map, newStr.append(currentChar));
            }
      }

      // calling function removeDuplicates...
      public static void removeDuplicatesCall(String str) {
            removeDuplicates(str, 0, new boolean[26], new StringBuilder());
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            removeDuplicatesCall("ppppppjjjjssss");
      }

      //? Output 
      // 1. 
      //     pjs
}
