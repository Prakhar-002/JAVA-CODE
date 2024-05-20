class TrappingRainWater {

      public static void trap(int height[]) {
            int n = height.length;

            // right max...

            int right[] = new int[n];
            right[0] = height[0];
            for (int i = 1; i < n; i++) {
                  right[i] = Math.max(right[i - 1], height[i]);
            }

            // left max...

            int left[] = new int[n];
            left[n - 1] = height[n - 1];

            for (int i = (n - 2); i >= 0; i--) {
                  left[i] = Math.max(left[i + 1], height[i]);
            }
            // finding volume of water trap...
            int volume = 0;

            for (int i = 0; i < n; i++) {
                  volume += (Math.min(left[i], right[i]) - height[i]);
            }
            System.out.println(volume);
      }

      public static void callWaterTrap() {
            int height[] = { 4, 2, 0, 6, 3, 2, 5 };
            trap(height);
      }

      public static void main(String args[]) {
            int height[] = { 7, 1, 2, 3, 4, 5, 1 };
            trap(height);
      }

      // ? Output
      // 1.
      //    10
}