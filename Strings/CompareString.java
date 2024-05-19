public class CompareString {

      public static void compareToString(){
            // we use compareToIgnoreCase to let a and A are equal and use compareTo for normal cases
            String fruits[] = {"apple","mango","banana"};
            String largest = fruits[0];
            for(int i = 0; i < fruits.length; i++){
                  if(largest.compareToIgnoreCase(fruits[i]) < 0){
                        largest = fruits[i];
                  }
            }
            System.out.println("largest string according to lexicography is : " + largest);
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            compareToString();
      }

      //? Output 
      // 1. 
      //     largest string according to lexicography is : mango
      
}
