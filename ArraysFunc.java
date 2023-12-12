import java.util.*;

// import javax.lang.model.type.NullType;

class ArraysFunc {

      public static void createArray() {
            int arr1[] = { 1, 5, 6 };
            int arr2[] = new int[5];// create num array of n integer...
            arr2[0] = 10;
            Scanner sc = new Scanner(System.in);
            arr2[1] = sc.nextInt();
            String fruits[] = { "apple", "banana", "orange" };
            for (int i = 0; i < arr1.length; i++) {
                  System.out.print(arr1[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < fruits.length; i++) {
                  System.out.print(fruits[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < arr2.length; i++) {
                  System.out.print(arr2[i] + " ");
            }
            sc.close();
      }

      public static void newArray() {
            Scanner sc = new Scanner(System.in);
            System.out.println("enter the length of array");
            int n = sc.nextInt();
            int arr[] = new int[n];
            System.out.println("Enter the elements of array...");
            for (int i = 0; i < n; i++) {
                  arr[i] = sc.nextInt();
            }
            print(arr);
            // linear(arr);
            // largestNum(arr);
            reverse(arr);
            sc.close();
      }

      public static void print(int arr[]) {
            System.out.println("array is ...");
            for (int i = 0; i < arr.length; i++) {
                  System.out.print(arr[i] + " ");
            }
            System.out.println();
      }

      public static void linear(int arr[]) {
            Scanner sc = new Scanner(System.in);
            System.out.println("enter the number you want to search...");
            int n = sc.nextInt();
            for (int i = 0; i < arr.length; i++) {
                  if (arr[i] == n) {
                        System.out.println("value found at i" + i);
                        break;
                  }
                  // if(arr[n-1]!=n){
                  // System.out.println("value not found...");
                  // }
            }
            sc.close();
      }

      public static void largestNum(int arr[]) {
            int largestNum = arr[0];
            for (int i = 0; i < arr.length; i++) {
                  if (arr[i] > largestNum) {
                        largestNum = arr[i];
                  }
            }
            System.out.println("largest number in given array is :" + largestNum);
      }

      public static void reverse(int arr[]) {
            for (int i = 0; i < arr.length / 2; i++) {
                  int temp;
                  temp = arr[i];
                  arr[i] = arr[arr.length - 1 - i];
                  arr[arr.length - 1 - i] = temp;
            }
            print(arr);
      }

      public static int binarySearch(int arr[], int key) {
            int start = 0, end = arr.length - 1;
            while (start <= end) {
                  int mid = (start + end) / 2;
                  // comparisons
                  if (arr[mid] == key) {
                        return mid;
                  }
                  if (arr[mid] < key) {
                        start = mid + 1;
                  } else {
                        end = mid - 1;
                  }
            }
            return -1;
      }

      public static void binaryCall() {
            Scanner sc = new Scanner(System.in);
            int arr[] = { 2, 4, 6, 8, 10, 12, 16, 18 };
            System.out.println("search num value...");
            int key = sc.nextInt();
            int ans = binarySearch(arr, key);
            if (ans == -1) {
                  System.out.println("value not found !!!");
            } else {
                  System.out.println("value..." + arr[ans] + " found at i of " + ans);
            }
            sc.close();
      }

      public static void pairs() {
            int arr[] = { 2, 4, 6, 8, 10, 12, 16, 18 };
            for (int i = 0; i < arr.length; i++) {
                  for (int j = i + 1; j < arr.length; j++) {
                        System.out.print("(" + arr[i] + "," + arr[j] + ")" + " ");
                  }
                  System.out.println();
            }
      }

      public static void subArr() {
            int arr[] = { 2, 4, 6, 8, 10 };
            for (int i = 0; i < arr.length; i++) {
                  for (int j = i; j < arr.length; j++) {
                        for (int k = i; k <= j; k++) {
                              System.out.print(arr[k] + " ");
                        }
                        System.out.println();
                  }
                  System.out.println();
            }
      }

      // time complexity is very bad big oh of N_cube...
      // brute force...
      public static void maxSumSubArr() {
            int arr[] = { 2, 4, 6, 8, 10 };
            int sum = 0;
            int maxSum = Integer.MIN_VALUE; // it represent -infinity value...
            for (int i = 0; i < arr.length; i++) {
                  for (int j = i; j < arr.length; j++) {
                        sum = 0;
                        for (int k = i; k < j; k++) {
                              // System.out.print(arr[k] + " ");
                              sum += arr[k];
                              if (maxSum < sum) {
                                    maxSum = sum;
                              }
                        }
                        System.out.println(sum);
                  }
            }
            System.out.println("max sum of sub array is -> " + maxSum);
      }

      // prefix sum ...
      // It has time complexity N_square...better the previous one...
      public static void maxSumPrefix() {
            int arr[] = { 2, 4, 6, 8, 10 };
            int sum = 0;
            int maxSum = Integer.MIN_VALUE;
            int prefix[] = new int[arr.length];
            prefix[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                  prefix[i] = prefix[i - 1] + arr[i];
            }

            for (int i = 0; i < arr.length; i++) {
                  for (int j = 0; j < arr.length; j++) {
                        sum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
                        if (maxSum < sum) {
                              maxSum = sum;
                        }
                  }
            }
            System.out.println(maxSum);
      }

      // kadane's is most easy way to find max sum of sub array...
      public static void kadanes() {
            int cs = 0;
            int ms = 0;
            int arr[] = { -2, 4, -6, 8, -10 };
            for (int i = 0; i < arr.length; i++) {
                  cs += arr[i];
                  if (cs < 0) {
                        cs = 0;
                  }
                  ms = Math.max(cs, ms);
            }
            System.out.println("MAX sum of subArray is :" + ms);
      }

      public static void checkDouble() {
            int arr[] = { 4, 6, 0,9,10,-8, -8, -10, 5, -8,8 };
            for (int i = 0; i < arr.length; i++) {
                  int num = arr[i];
                  // arr[i] = Integer.MIN_VALUE;
                  for (int j = i+1; j < arr.length; j++) {
                        if (num == arr[j]) {
                              // System.out.println("number " + num + " is repeating ...");
                              numRp(arr,num);
                              System.exit(0);
                        }
                  }
            }
            System.out.println("no number is repeating...");
      }

      public static void numRp(int array[],int num){
            int count=0;
            for(int i =0;i<array.length;i++){
                  if(num==array[i]){
                        count++;
                  }  
            }
            System.out.println("number "+num+" repeating " +count+" times...");
      }

      public static void main(String args[]) {
            // newArray();
            // checkDouble();
            String a="sbfvnlnrlf";
            char  arr[]= new char[50];
            arr =a.toCharArray();
            // System.out.println();
            for (int i = 0; i < arr.length; i++) {
                  System.out.print(arr[i]+" ");
            }
      }
}