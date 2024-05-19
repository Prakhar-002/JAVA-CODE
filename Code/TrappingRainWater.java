// import java.util.*;

// auxiliary array...

class TrappingRainWater{

      public static void trap(int height[]){
            int n=height.length;

            //right max...

            int right[]=new int [n];
            right[0]=height[0];
            for(int i=1;i<n;i++){
                  right[i]=Math.max(right[i-1],height[i]);
            }

            //left max...

            int left[]=new int [n];
            left[n-1]=height[n-1];

            for(int i=(n-2);i>=0;i--){
                  left[i]=Math.max(left[i+1],height[i]);
            }
            // finding volume of water trap...
            int volume=0;

            for(int i=0;i<n;i++){
                  volume+=(Math.min(left[i],right[i])-height[i]);
            }
            System.out.println(volume);
      }

      public static void callWaterTrap(){
            int height[]={4,2,0,6,3,2,5};
            trap(height);
      }

      //best time to buy and sell a stock....

      public static void bestTimeToBuyAndSell(int price[]){
            int n=price.length;
            int maxPrice=0;
            int buyPrice=Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                  if(buyPrice<price[i]){
                        int profit=price[i]-buyPrice;
                        maxPrice=Math.max(maxPrice, profit);
                  }else{
                        buyPrice=price[i];
                  }
            }
            System.out.println(maxPrice);
      }

      public static void bestTimeToBuyAndSellPrint(){
            int price[]={4,7,5,2,4,8,11};
            bestTimeToBuyAndSell(price);
      }



      public static void main(String args[]){
            // int height[] = {7,1,2,3,4,5,1};
            // trap(height);
            bestTimeToBuyAndSellPrint();
      }
}