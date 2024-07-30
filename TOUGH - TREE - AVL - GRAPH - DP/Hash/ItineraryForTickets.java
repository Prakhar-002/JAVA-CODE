import java.util.HashMap;

public class ItineraryForTickets {

      public static String toStart(HashMap<String, String> tickets) {
            HashMap<String, String> revMap = new HashMap<>();

            for (String key : tickets.keySet()) {
                  revMap.put(tickets.get(key), key);
            }

            for (String key : tickets.keySet()) {
                  if (!revMap.containsKey(key)) {
                        return key;
                  }
            }

            return null;
      }

      public static void itineraryForTickets() { // O(n)
            HashMap<String, String> tickets = new HashMap<>();
            tickets.put("Chennai", "Bengal");
            tickets.put("Mumbai", "Delhi");
            tickets.put("Goa", "Chennai");
            tickets.put("Delhi", "Goa");

            String start = toStart(tickets);
            System.out.print(start);

            for (String key : tickets.keySet()) {
                  System.out.print(" -> " + tickets.get(start));
                  start = tickets.get(start);
            }
      }

      // ------------------------------------------------------------------------
      public static void main(String args[]) {
            itineraryForTickets();
      }


      // ? Output
      // 1.
      //    Mumbai -> Delhi -> Goa -> Chennai -> Bengal
}
