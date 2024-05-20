public class SearchInRotatedArray {

      // search in rotated array around a pivot ...
      public static int searchRotatedArray(Integer arr[], int target, int si, int ei){
            if(si > ei){
                  return -1;
            }

            // finding our mid value ...
            int mid = si + (ei-si)/2; //(si+ei)/2;

            // target FOUND 
            if(arr[mid] == target){
                  return mid ;
            }

            // on line one L1 
            if(arr[si] <= arr[mid]){
                  // case 'a'
                  if(arr[si] >= target && target <= arr[mid]){
                        return searchRotatedArray(arr, target, si, mid-1);
                  }
                  // case 'b'
                  else{
                        return searchRotatedArray(arr, target, mid+1, ei);
                  }
            }

            // on line 2 ke 
            else{
                  // case 'c'
                  if(target >= arr[mid] && target <= arr[ei]){
                        return searchRotatedArray(arr, target, mid+1, ei);
                  }
                  // case 'd'
                  else{
                        return searchRotatedArray(arr, target, si, mid-1);
                  }
            }
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            System.out.println(searchRotatedArray(new Integer[] {5, 8, 62, 10, 22}, 22, 0, 4));
      }

      //? Output 
      // 1. 
      //     4
      

      
}
