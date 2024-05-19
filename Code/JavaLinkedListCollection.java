import java.util.LinkedList;
public class JavaLinkedListCollection {

      public static void listCrtAddRem(){
            //create...
            LinkedList <Integer> list = new LinkedList<>();

            // add...
            list.add(10);
            list.addFirst(20);
            list.addFirst(27);
            list.addFirst(85);
            list.addFirst(79);
            list.addLast(75);

            System.out.println(list);
            // remove...
            list.remove();  // remove first 
            list.removeLast(); // remove last
            list.remove(2); // index
            // print...
            System.out.println(list);

      }


      public static void main(String[] args) {
            listCrtAddRem();
      }
}
