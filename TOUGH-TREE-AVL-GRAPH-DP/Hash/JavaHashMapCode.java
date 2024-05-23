import java.util.*;
public class JavaHashMapCode {

      static class HashMap<K , V>{ // generic... K and V can be any type
            public class Node{
                  K key ;
                  V value;

                  public Node(K key , V value){  // constructor of Node class... 
                        this.key = key;
                        this.value = value;
                  }
            }

            private int listLength; // number of nodes at a index of bucket's linked list 
            private int N; // size of max bucket index...
            private LinkedList<Node> buckets[]; // (N = buckets.length) array of linked list type...

            @SuppressWarnings("unchecked")
            public HashMap(){
                  this.N = 4;
                  this.buckets = new LinkedList[N];  // size of array is 4 of linked List type... 
                  for (int i = 0; i < N; i++) {
                        this.buckets[i] = new LinkedList<>(); // every array's block will create a empty linked list 
                  }
            }

            private int hashFunction(K key){
                  int hCode = key.hashCode(); // will give any code ... -ve || +ve
                  return Math.abs(hCode) % N; // first we'll  create a +ve value then 
                  // hCode be in b/n 0  to size hence we % that
            }

            private int searchInLL(K key , int bucketIdx){
                  LinkedList<Node> ll = buckets[bucketIdx];
                  int dataIdx = 0;

                  for (int i = 0; i < ll.size(); i++) {
                        Node node = ll.get(i);
                        if (node.key == key) {
                              return dataIdx;
                        } 
                        dataIdx++;
                  }

                  return -1;
            }

            @SuppressWarnings("unchecked")
            private void reHash(){
                  LinkedList<Node> oldBucket[] = buckets; // store old data in a array
                  buckets = new LinkedList[N*2]; // double size array this time...
                  N = 2*N;
                  // initialize with a new linked list
                  for (int i = 0; i < N; i++) {
                        buckets[i] = new LinkedList<>();
                  }

                  // Node -> add in bucket...
                  for (int i = 0; i < oldBucket.length; i++) {
                        LinkedList<Node> ll = oldBucket[i]; // we'll get ll from every index of oldBucket and it will store randomly at any position of new Bucket... 
                        for (int j = 0; j < ll.size(); j++) {
                              Node node = ll.remove();
                              put(node.key, node.value);
                        }
                  }

            }

            public void put(K key , V value){
                  int bucketIdx = hashFunction(key);
                  int dataIdx = searchInLL(key , bucketIdx);

                  if (dataIdx != -1) {  // valid index hence update ...
                        Node node = buckets[bucketIdx].get(dataIdx); // search for that node
                        node.value = value; // update
                  }else{ // new linked list create ...
                        buckets[bucketIdx].add(new Node(key, value)); // add a new linked list at the index of bucket which is given by hashFunc
                        listLength++; // size is +ve by one...
                  }

                  // condition of reHashing...
                  double lambda = (double)listLength/N ; // no. of linkedList node at a index of bucket divided by max length of bucket(N)
                  if (lambda > 2.0) { // greater than threshold...
                        reHash();
                  }
            }

      //------------------------------------------------------------------------------

            public boolean containsKey(K key){
                  int searchIdx = hashFunction(key);
                  int dataIdx = searchInLL(key, searchIdx);

                  if (dataIdx != -1) {
                        return true;
                  }else{
                        return false;
                  }
            }

      //------------------------------------------------------------------------------

            public V get(K key){
                  int searchIdx = hashFunction(key);
                  int dataIdx = searchInLL(key, searchIdx);

                  if (dataIdx != -1) {
                        Node node = buckets[searchIdx].get(dataIdx);
                        return node.value;
                  }else{
                        return null;
                  }
            }

      //------------------------------------------------------------------------------

            public V remove(K key){
                  int searchIdx = hashFunction(key);
                  int dataIdx = searchInLL(key, searchIdx);

                  if (dataIdx != -1) {
                        Node node = buckets[searchIdx].remove(dataIdx);
                        listLength--;
                        return node.value;
                  }else{
                        return null;
                  }
            }

      //---------------------------------------------------------------------------

            public ArrayList<K> keySet(){
                  ArrayList<K> keys = new ArrayList<>();

                  for (int i = 0; i < buckets.length; i++) {
                        LinkedList<Node> ll = buckets[i];
                        for (Node node : ll) {
                              keys.add(node.key);
                        }
                  }

                  return keys;
            }

      //------------------------------------------------------------------------------


            public boolean isEmpty(){
                  return listLength==0;
            }
      }

      public static void myHashMapCall(){
            HashMap<String,Integer> hm = new HashMap<>();
            hm.put("India", 1000);
            hm.put("USA", 200);
            hm.put("China", 500);
            hm.put("Indonesia", 150);
            hm.put("Leo", 501);

            ArrayList<String> keys = hm.keySet();

            for (String key : keys) {
                  System.out.println(key);
            }

            System.out.println(hm.get("India"));
            System.out.println(hm.remove("Leo"));
            System.out.println(hm.get("Leo"));
      }


      public static void main(String[] args) {
            // 1...myHashMapCall();
      }
}
