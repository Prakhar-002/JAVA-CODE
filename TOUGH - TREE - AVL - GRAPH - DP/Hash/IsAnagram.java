import java.util.HashMap;

public class IsAnagram {

      // valid anagram...
      //Given two strings s and t, return true if t is an anagram of s, and false otherwise.
      // An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
      // typically using all the original letters exactly once.
      // s = "race" t = "care" ---TRUE

      public static boolean isAnagram(String s , String t){   // O(n)
            if (s.length() != t.length()) {
                  return false;
            }
            HashMap<Character ,Integer> map = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                  map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }

            for (int i = 0; i < t.length(); i++) {
                  char ch = t.charAt(i);
                  if (map.get(ch) != null) {
                        if (map.get(ch) == 1) {
                              map.remove(ch);
                        }else{
                              map.put(ch, map.get(ch) - 1);
                        }
                  }else{
                        return false;
                  }
            }

            return map.isEmpty();
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            System.out.println(isAnagram("race", "care"));
      }

      //? Output 
      // 1. 
      //    true
}
