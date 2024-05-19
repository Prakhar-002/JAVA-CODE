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

      public static void print(int arr[]) {
            System.out.println("array is ...");
            for (int i = 0; i < arr.length; i++) {
                  System.out.print(arr[i] + " ");
            }
            System.out.println();
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
            print(arr);;
            sc.close();
      }

      public static void main(String args[]) {
            // newArray();
            // checkDouble();
            String a = "sbfvnlnrlf";
            char arr[] = new char[50];
            arr = a.toCharArray();
            // System.out.println();
            for (int i = 0; i < arr.length; i++) {
                  System.out.print(arr[i] + " ");
            }
      }
}