public class FirstUpperCase {

      public static void eachFirstLatterUpperCase(){
            String str = "hi I am your host";
            StringBuilder sb = new StringBuilder("");
            char ch = Character.toUpperCase(str.charAt(0));
            sb.append(ch);
            for(int i=1; i<str.length(); i++){
                  if(str.charAt(i) == ' ' && i < str.length() - 1){
                        sb.append(str.charAt(i));
                        i++;
                        ch = Character.toUpperCase(str.charAt(i));
                        sb.append(ch);
                  }else{
                        sb.append(str.charAt(i));     
                  }
            }
            System.out.println(sb);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            eachFirstLatterUpperCase();
      }

      //? Output 
      // 1. 
      //     Hi I Am Your Host
      
}
