import java.util.*;

// STRINGS ARE IMMUTABLE ...
public class J_19String {

      public static void stringBasic(){
            String name="tony";
            String alpha=new String("look");
            System.out.println(name +" "+alpha);

            // input 
            Scanner Joe =new Scanner(System.in);

            String movieName=Joe.nextLine();
            
            // length 

            System.out.println(movieName.length());  //bracket is imp because this is a function of string but in array that was a property of array...
            // charAt()  for character at any index...
            System.out.println(name.charAt(3));
            Joe.close();
      }

      public static void isPalindrome(String str){
            for (int i = 0; i < str.length()/2; i++) {
                  int n=str.length();
                  if(str.charAt(i) != str.charAt(n-i-1)){
                        System.out.println("This is  not a palindrome string...");
                        return ;
                  } 
            }
            System.out.println("This is a palindrome string...");
      }

      public static void shortestPath(String path){
            float X=0,Y=0;
            for (int i = 0; i < path.length(); i++) {
                  if(path.charAt(i)=='N'||path.charAt(i)=='n'){
                        Y++;
                  }else if(path.charAt(i)=='E'||path.charAt(i)=='e'){
                        X++;
                  }else if(path.charAt(i)=='S'||path.charAt(i)=='s'){
                        Y--;
                  }else if(path.charAt(i)=='W'||path.charAt(i)=='w'){
                        X--;
                  }else{
                        continue;
                  }
            }
            System.out.println("shortest path is : "+Math.sqrt( Math.pow(X, 2)+Math.pow(Y, 2)));
      }

      public static void stringEqual(String str1,String str2){
            if(str1.equals(str2)){
                  System.out.println("Strings are equal ...");
            }else{
                  System.out.println("strings are not equal...");
            }
      }

      public static void stringEqualCall(){
            String s1="tony";
            String s2= new String("tony");
            // in this condition s1 and s2 are not equal as we check it like s1==s2...
            stringEqual(s1, s2);
      } 

      public static void stringSubstring(String str,int SI,int EI){
            String subString="";
            for (int i = SI; i <EI; i++) {
                  subString+=str.charAt(i);
            }
            System.out.println(subString);
      }
      // or we can call its InBuild function ...str.substring(starting index,ending index)
      // str.substring(0,5);

      public static void compareToString(){
            // we use compareToIgnoreCase to let a and A are equal and use compareTo for normal cases
            String fruits[]={"apple","mango","banana"};
            String largest=fruits[0];
            for(int i=0;i<fruits.length;i++){
                  if(largest.compareToIgnoreCase(fruits[i])<0){
                        largest=fruits[i];
                  }
            }
            System.out.println("largest string according to lexicography is :"+largest);
      }

      //we cam convert an object to string by writing sb.toString()...
      // int a=10 ...a.toString() will not convert because it is not as object but INTEGER a=10 will convert to string

      public static void stringBuilder(){
            // we use stringBuilder instant of string because it is a immutable...
            StringBuilder sb=new StringBuilder("");
            for(char ch='a';ch<='z';ch++){
                  sb.append(ch);
            }
            System.out.println(sb);
            System.out.println(sb.length());
      }

      public static void eachFirstLatterUpperCase(){
            String str="hi i am purnima kesarwani";
            StringBuilder sb=new StringBuilder("");
            char ch=Character.toUpperCase(str.charAt(0));
            sb.append(ch);
            for(int i=1;i<str.length();i++){
                  if(str.charAt(i)==' '&& i<str.length()-1){
                        sb.append(str.charAt(i));
                        i++;
                        ch=Character.toUpperCase(str.charAt(i));
                        sb.append(ch);
                        
                  }else{
                        sb.append(str.charAt(i));     
                  }
            }
            System.out.println(sb);
      }

      public static void stringCompressor(){
            String str="aaabbcccdddee";
            StringBuilder sb=new StringBuilder("");
            for (int i = 0; i < str.length(); i++) {
                  Integer count=1;
                  while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                        count++;
                        i++;
                  }
                  sb.append(str.charAt(i));
                  if(count>1){
                        sb.append(count.toString());
                  }
            }
            System.out.println(sb);
      }

      public static void main (String args[]){
            stringCompressor();
      }
}
