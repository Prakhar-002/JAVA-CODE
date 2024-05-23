import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class JavaGraph_3 {
      

      static class Edge{
            int dest ;
            int src ;

            public Edge(int s , int d){
                  this.src = s;
                  this.dest= d;
            }
      }

//------------------------------------------------------------------------------------------------------------

// Topological Sort using BFS
// Fact : A DAG has at least one vertex with in-degree 0 and one vertex with out-degree 0.

// Kahn's Algorithm...

      // in degree -> no. of edge incoming to the node
      // out degree -> no. of edge outgoing from the node

      public static void topologicalSortBFSTree(ArrayList<Edge> graph[]){

            /*
             *                5           4
             *                |  \     /  |
             *                |    >0<    |
             *               >|           |>
             *                2           1
             *                 \         /
             *                     > 3>
             */
            for (int i = 0; i < graph.length; i++) {
                  graph[i] = new ArrayList<>();
            }

            graph[2].add(new Edge(2, 3));

            graph[3].add(new Edge(3, 1));

            graph[4].add(new Edge(4, 0));
            graph[4].add(new Edge(4, 1));

            graph[5].add(new Edge(5, 0));
            graph[5].add(new Edge(5, 2));
      }

      public static void calInDegree(ArrayList<Edge> graph[] , int inDegree[]){
            for (int i = 0; i < graph.length; i++) {
                  int ver = i ;
                  for (int j = 0; j < graph[ver].size(); j++) {
                        Edge e = graph[ver].get(j);
                        inDegree[e.dest]++; // every destination's in degree will inc by one...
                  }
            }
      }

      public static void topologicalSort(ArrayList<Edge> graph[]){
            int inDegree[] = new int[graph.length];
            calInDegree(graph, inDegree);

            Queue<Integer> q = new LinkedList<>();

            for (int i = 0; i < inDegree.length; i++) {
                  if (inDegree[i] == 0) {
                        q.add(i); // add all those have inDegree equals to one...
                  }
            }

            // perform BFS
            while (!q.isEmpty()) {
                  // first we get the element whose inDegree is 0
                  int cur = q.remove();
                  // then add it into topological sort means print
                  System.out.print(cur +" ");
                  // then decrease every neighbor's in degree o=by one
                  for (int i = 0; i < graph[cur].size(); i++) {
                        Edge e = graph[cur].get(i);
                        inDegree[e.dest]--;
                        // if inDegree is 0 then we add it to our queue
                        if (inDegree[e.dest] == 0) {
                              q.add(e.dest);
                        }
                  }
            }

            System.out.println();
      }

      public static void topologicalSortCall(){
            int vertex = 6;
            ArrayList<Edge> graph[] =  new ArrayList[vertex];

            topologicalSortBFSTree(graph); // call the tree

            topologicalSort(graph);
      }

//-------------------------------------------------------------------------------------------------------------

// All Paths from Source to Target
// Directed graph

      public static void allPathsTree(ArrayList<Edge> graph[]){

            /*
             *                5           4
             *                |  \     /  |
             *                |    >0<    |
             *               >|     |     |>
             *                2     |     1
             *                 \    |>   /
             *                     > 3>
             */
            for (int i = 0; i < graph.length; i++) {
                  graph[i] = new ArrayList<>();
            }

            graph[0].add(new Edge(0, 3));

            graph[2].add(new Edge(2, 3));

            graph[3].add(new Edge(3, 1));

            graph[4].add(new Edge(4, 0));
            graph[4].add(new Edge(4, 1));

            graph[5].add(new Edge(5, 0));
            graph[5].add(new Edge(5, 2));
      }

      public static void printAllPAth(ArrayList<Edge> graph[] , int src , int dest , String path){
            if (src == dest) {
                  System.out.println(path+ dest);
                  return;
            }

            for (int i = 0; i < graph[src].size(); i++) {
                  Edge e = graph[src].get(i);
                  printAllPAth(graph, e.dest, dest, path+src);
            }
      }

      // exponential complexity...
      public static void allPathCall(){
            int vertex = 6;
            ArrayList<Edge> graph[] = new ArrayList[vertex];
            allPathsTree(graph);

            int src = 5 ,dest = 1;
            printAllPAth(graph, src, dest, "");
      }


      public static void main(String[] args) {
            // 1...topologicalSortCall();
            // 2...allPathCall();
      }
}
