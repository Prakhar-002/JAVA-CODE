public class SubString {

      public static void stringSubstring(String str, int SI, int EI){
            String subString = "";
            for (int i = SI; i < EI; i++) {
                  subString += str.charAt(i);
            }
            System.out.println(subString);
      }
      // or we can call its InBuild function ...str.substring(starting index,ending index)
      // str.substring(0,5);
      

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            stringSubstring("jsonFormat", 0, 5);
      }

      //? Output 
      // 1. 
      //     jsonF
}
