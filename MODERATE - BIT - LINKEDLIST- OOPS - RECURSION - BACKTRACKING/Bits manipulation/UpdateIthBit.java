public class UpdateIthBit {

      public static void updateIthBit(int num, int index, int newBit) {
            // if(newBit==0){
            // clearIthBit(num, index);
            // }else{
            // setIthBit(num, index);
            // }

            // or

            num = ClearIthBit.clearIthBit(num, index);
            int bitmask = newBit << index;
            System.out.println((num | bitmask));
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            updateIthBit(451, 4, 1);
      }

      //? Output 
      // 1. 
      //     467
      
}
