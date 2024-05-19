public class StringCompressor {

      public static void stringCompressor(){
            String str = "aaabbcccdddee";
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < str.length(); i++) {
                  Integer count = 1;
                  while(i < str.length() - 1 && str.charAt(i) == str.charAt(i+1)){
                        count++;
                        i++;
                  }
                  sb.append(str.charAt(i));
                  if(count > 1){
                        sb.append(count.toString());
                  }
            }
            System.out.println(sb);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            stringCompressor();
      }

      //? Output 
      // 1. 
      //     a3b2c3d3e2
      
}
