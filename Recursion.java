import java.util.*;

public class Recursion{

      public static boolean isSorted(int arr[],int i ){   //i should be 0 from calling of function... // O(n) is tc
            if(i == arr.length-1){
                  return true;
            }
            if(arr[i]> arr[i+1]){
                  return false;
            }
            return isSorted(arr, i+1);
      }

      public static int firstOccur(int arr[], int key,int i){  // tc is O(n)
            if(i == arr.length){
                  return -1;
            }
            if(arr[i] == key){
                  return i;  
            }
            return firstOccur(arr, key, i+1);
      }

      public static int lastOccur(int arr[],int key ,int n ){
            if(n == -1){
                  return -1;
            }
            if(arr[n-1] == key){
                  return (n-1);
            }
            return lastOccur(arr,key,n-1);
      }

      public static int lastOccur1(int arr[],int key ,int i ){
            if(i == arr.length){
                  return -1;
            }
            int isFound =lastOccur1(arr, key, i+1);
            if(isFound == -1 && arr[i] == key){
                  return i;
            }
            return isFound;
      }

      public static int xPowN(int x,int n){  // O(n)
            if(n == 1){
                  return x;
            }
            return (x*xPowN(x, n-1));
      }

      // optimize code for power a number upTo n times...
      // time complexity will be O(log n)...

      public static int optimizePower(int a ,int n){
            if(n == 0){
                  return 1;
            }
            int halfPower = optimizePower(a, n/2);
            int halfPowerSqr = halfPower * halfPower;

            if( n%2 != 0){
                  halfPowerSqr = (a*halfPowerSqr);
            }

            return halfPowerSqr;
      }

      public static int tilingProb(int n){  //2* n tile area ...
            if(n == 0  || n== 1){
                  return 1;
            }
            // method ans choice in horizontal and vertical 
            // when vertical is choose 
            int type1 =tilingProb(n-1);

            int type2 = tilingProb(n-2);

            // total method to fill that area ...

            return (type1 + type2);

            // or we can simply right like 
            // return (tilingProb(n-1) + tilingProb(n-2));
      }

      // remove duplicates in a string...
      public static void removeDuplicates(String str ,int i,boolean map[],StringBuilder newStr){
            if(i == str.length()){
                  System.out.println(newStr);
                  return;
            }
            char currentChar =str.charAt(i);
            if(map[currentChar-'a']== true){
                  // duplicates
                  removeDuplicates(str, i+1, map, newStr);
            }else{
                  //add to string builder ...
                  map[currentChar-'a']=true;
                  removeDuplicates(str, i+1, map, newStr.append(currentChar));
            }
      }

      // calling function removeDuplicates...
      public static void removeDuplicatesCall(String str){
            removeDuplicates(str, 0,new boolean[26], new StringBuilder());
      }

      // friend pairing in a party ...
      public static int friendsPairing(int n){
            if(n == 1 || n== 2){
                  return n;
            }
            // choice 
            // if single the we remove on person and call function for n-1 
            int case1 = friendsPairing(n-1);

            // if one pair then we'll call function for n-2 and multiply with n-1 because this is the way of making pair with other of one person 
            int  case2 = ((n-1)*friendsPairing(n-2));

            // we finally return total ways 

            return (case1 + case2);

            // or we can simply right like 
            // return (friendsPairing(n-1)+ ((n-1)*friendsPairing(n-2)));
      }

      // bitString which can't content 1 1 simultaneously ...
      public static void printBitString(int n ,int lastBit ,String str){
            // base case 
            if(n == 0){
                  System.out.println(str);
                  return;
            }

            // work...
            // if(lastBit == 0){
            //       printBitString(n-1, 0, str+"0");
            //       printBitString(n-1, 1, str+"1");
            // }else{
            //       printBitString(n-1, 0, str+"0");
            // }

            // optimize work ...
            printBitString(n-1, 0, str+"0");

            if(lastBit == 0){
                  printBitString(n-1, 1, str+"1");
            }

      }

      public static void main(String args[]){
            // int arr[]={1,2,3,4,1,3};
            // String str ="apnacollege";
            // removeDuplicatesCall(str);
            // System.out.println(friendsPairing(3));
            printBitString(3, 0, "");
            Scanner Joe =new Scanner(System.in);
            int a =Joe.nextInt();
            System.out.println(a);
            Joe.close();
            // a= a*b -> b= a/b -> a=a/b  
            // com( int a ->x ,->j int b ,int x int y )
            //  System.out.println(a + x ,....);

            
            
      }
}