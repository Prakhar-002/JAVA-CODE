// import java.util.*;
public class JavaTrie {

      static class Node{
            Node children[] = new Node[26]; // 26
            Boolean eow = false;  // endOfWord

            Node(){
                  for (int i = 0; i < 26; i++) {
                        children[i] = null;
                  }
            }
      }

      public static Node root = new Node(); // root will not store any value...

      public static void insert(String word){  // O(L) L=> "length of word"...
            Node cur = root;
            for (int level = 0; level < word.length(); level++) {
                  int idx = word.charAt(level) - 'a';
                  if (cur.children[idx] == null) {
                        cur.children[idx] = new Node();
                  }
                  cur = cur.children[idx];
            }

            cur.eow = true;
      }

      public static boolean search(String key){   // O(L)
            Node cur = root;
            for (int level = 0; level < key.length(); level++) {
                  int idx = key.charAt(level) - 'a';
                  if (cur.children[idx] == null) {
                        return false;
                  }
                  cur = cur.children[idx];
            }

            return cur.eow == true;
      }

      public static void wordsStore(){
            String words[] = {"the", "a", "there", "their" ,"any" , "thee"};
            for (int i = 0; i < words.length; i++) {
                  insert(words[i]);
            }

            // searching...
            System.out.println(search("there"));
            System.out.println(search("thor"));
      }

//-------------------------------------------------------------------------------------------

// Given an input string and a dictionary of words, find out if the input string
// can be broken into a space-separated sequence of dictionary words.

// word break problem...

public static boolean checkWord(String key){  // O(L)
      if (key.length() == 0) {
            return true;
      }
      for (int i = 1; i <= key.length(); i++) {
            if ( search(key.substring(0 , i)) && checkWord(key.substring(i))) {
                  return true;
            }
      }
      return false;
}

public static void wordBreakProblem(){
      String words[] = {"i" , "like" , "sam", "samsung" ,"mobile" , "ice"};
      for (int i = 0; i < words.length; i++) {
            insert(words[i]);
      }

      String key = "ilikesamsung";

      System.out.println(checkWord(key));
}

//-------------------------------------------------------------------------------------------

// Find shortest unique prefix for every word in a given list.
// Assume no word is prefix of another.

      static class PreNode{
            PreNode children[] = new PreNode[26];
            boolean eow ;
            int freq ;

            public PreNode(){
                  for (int i = 0; i < children.length; i++) {
                        children[i] = null;
                  }
                  freq = 1;  // if node have no child then it's freq is 1 else equal to number of nodes of links
                  eow = false;
            }
      }

      public static PreNode preRoot = new PreNode();

      public static void preInsert(String word){
            PreNode cur = preRoot;
            for (int i = 0; i < word.length(); i++) {
                  int idx = word.charAt(i) - 'a';
                  if (cur.children[idx] == null) {
                        cur.children[idx] = new PreNode();
                  }else{
                        cur.children[idx].freq++;
                  }
                  cur = cur.children[idx];
            }
            cur.eow = true;
      }

      public static void findPrefix(PreNode root,String ans){
            if (root == null) {
                  return;
            }

            if (root.freq == 1) {
                  System.out.println(ans);
                  return;
            }

            for (int i = 0; i < root.children.length; i++) {
                  if (root.children[i] != null) {
                        findPrefix(root.children[i], ans+(char)(i +'a'));
                  }
            }
      }

      public static void prefixProblem(){  //O(l) longest word...
            String prefixWords[]= {"zebra" , "dog" ,"duck" ,"dove"};
            for (int i = 0; i < prefixWords.length; i++) {
                  preInsert(prefixWords[i]);
            } 

            preRoot.freq = -1;

            findPrefix(preRoot, "");
      }

//-------------------------------------------------------------------------------------------

// Create a function boolean startsWith(String prefix) for a trie.
// Returns true if there is a previously inserted string word that has the prefix
// , and false otherwise.

      public static boolean startWith(String key){
            Node cur = root;
            for (int i = 0; i < key.length(); i++) {
                  int idx = key.charAt(i) - 'a';
                  if (cur.children[idx] == null) {
                        return false;
                  }
                  cur = cur.children[idx];
            }
            return true;
      }

      public static void startWithProblem(){
            String word []= {"apple", "app", "mango" ,"man" ,"woman"};
            for (int i = 0; i < word.length; i++) {
                  insert(word[i]);
            }

            System.out.println(startWith("xa"));
      }

//-------------------------------------------------------------------------------------------

// Given a string of length n of lowercase alphabet characters, we need to count total 
// number of distinct substrings of this string.

      public static int countNodes(Node root){
            if (root == null) {
                  return 0;
            }

            int count = 0;
            for (int i = 0; i < root.children.length; i++) {
                  if (root.children[i] != null) {
                        count += countNodes(root.children[i]);
                  }
            }

            return count+1;
      }

      public static void uniqueSubStringProblem(){
            String str = "joe"; // ans = 10

            // suffix insert in Trie...
            for (int i = 0; i < str.length(); i++) {
                  String suffix = str.substring(i);
                  insert(suffix);
            }

            // calling the count node function because trie only stores the unique prefix...
            System.out.println(countNodes(root));
      }

//-------------------------------------------------------------------------------------------

// Longest Word with all Prefixes
// Find the longest string in words such that every prefix of it is also in words.

      public static String ans = "";

      public static void largestWord(Node root , StringBuilder temp){
            if (root == null) {
                  return;
            }

            // for (int i = 0; i < root.children.length; i++) {  // it will give apple
            for (int i = root.children.length -1; i >=0 ; i--) {  // it will give apply
                  if (root.children[i] != null && root.children[i].eow == true){
                        char ch = (char)(i +'a');
                        temp.append(ch);
                        if (temp.length() > ans.length() ) { // || temp.toString().compareTo(ans) > 0
                              ans = temp.toString();
                        }
                        largestWord(root.children[i], temp);
                        // backtracing...
                        temp.deleteCharAt(temp.length()-1);
                  }
            }
      } 

      public static void longestWordWithAllPrefix(){
            String words [] = {"a" ,"ap", "banana", "app" ,"apple" , "appl", "apply"};

            for (int i = 0; i < words.length; i++) {
                  insert(words[i]);
            }

            largestWord(root, new StringBuilder(""));
            System.out.println(ans);
      }

      public static void main(String[] args) {
            // 1...wordsStore();
            // 2...wordBreakProblem();
            // 3...prefixProblem();
            // 4...startWithProblem();
            // 5...uniqueSubStringProblem();
            longestWordWithAllPrefix();
      }
}