public class FriendsPairing {

      // friend pairing in a party ...
      public static int friendsPairing(int n) {
            if (n == 1 || n == 2) {
                  return n;
            }
            // choice
            // if single the we remove on person and call function for n-1
            int case1 = friendsPairing(n - 1);

            // if one pair then we'll call function for n-2 and multiply with n-1 because
            // this is the way of making pair with other of one person
            int case2 = ((n - 1) * friendsPairing(n - 2));

            // we finally return total ways

            return (case1 + case2);

            // or we can simply right like
            // return (friendsPairing(n-1)+ ((n-1)*friendsPairing(n-2)));
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            System.out.println(friendsPairing(10));
      }

      //? Output 
      // 1. 
      //     9496
}
