import java.util.*;
public class JavaGraphs {

      static class Edge{
            int scr;
            int dest;
            int weight;

            public Edge(int s , int d , int w){
                  this.scr = s;
                  this.dest = d ;
                  this.weight = w;
            }
      }

      public static void graphBuild(){
            /*
             *                (5)
             *           0---------1
             *                   /   \ 
             *              (1) /     \ (3)
             *                 /       \
             *                2---------3
             *                |   (1)
             *             (2)|
             *                |
             *                4      
             */

            int vertex = 5;
            ArrayList<Edge> graph[] = new ArrayList[vertex]; // null -> empty arrayList

            for (int i = 0; i < vertex; i++) {
                  graph[i] = new ArrayList<>(); // every box define as a arrayList...
            }

            // 0 vertex...
            graph[0].add(new Edge(0, 1, 5));

            // 1 vertex
            graph[1].add(new Edge(1, 2, 1));
            graph[1].add(new Edge(1, 3, 3));
            graph[1].add(new Edge(1, 0, 5));

            // 2 vertex
            graph[2].add(new Edge(2, 1, 1));
            graph[2].add(new Edge(2, 3, 1));
            graph[2].add(new Edge(2, 4, 2));

            // 3 vertex
            graph[3].add(new Edge(3, 1, 3));
            graph[3].add(new Edge(3, 2, 1));

            // 4 vertex
            graph[4].add(new Edge(4, 2, 2));

            // 2's neighbors...
            for (int i = 0; i < graph[2].size(); i++) {
                  Edge e = graph[2].get(i);
                  System.out.println(e.dest);
            }
      }

//------------------------------------------------------------------------------------------------

      public static void BFS_DFS_TreeBuild(ArrayList<Edge> graph[]){

      /*
      *       1---3
      *      /   |  \  
      *     0    |   5 ---6
      *     \    |  /
      *      2---- 4
      */

            for (int i = 0; i < graph.length; i++) {
                  graph[i] = new ArrayList<>();
            }

            graph[0].add(new Edge(0, 1, 1));
            graph[0].add(new Edge(0, 2, 1));

            graph[1].add(new Edge(1, 0, 1));
            graph[1].add(new Edge(1, 3, 1));

            graph[2].add(new Edge(2, 0, 1));
            graph[2].add(new Edge(2, 4, 1));

            graph[3].add(new Edge(3, 1, 1));
            graph[3].add(new Edge(3, 4, 1));
            graph[3].add(new Edge(3, 5, 1));

            graph[4].add(new Edge(4, 2, 1));
            graph[4].add(new Edge(4, 3, 1));
            graph[4].add(new Edge(4, 5, 1));

            graph[5].add(new Edge(5, 3, 1));
            graph[5].add(new Edge(5, 4, 1));
            graph[5].add(new Edge(5, 6, 1));

            graph[6].add(new Edge(6, 5, 1));
      }

      public static void BFSTraversing(ArrayList<Edge> graph[]){
            Queue<Integer> q = new LinkedList<>();
            boolean visited[] = new boolean[graph.length];
            q.add(0); // add source... (0)

            while (!q.isEmpty()) {
                  int cur = q.remove();

                  if (!visited[cur]) {
                        System.out.print(cur +" ");
                        visited[cur] = true;
                        for (int i = 0; i < graph[cur].size(); i++) {
                              Edge e = graph[cur].get(i); // find the edge of that arrayList...
                              q.add(e.dest);  // add the edge'destination in queue...
                        }
                  }
            }

      }

      public static void BFSCall(){  // (Vertex + edge)
            int vertex = 7;

            ArrayList<Edge> graph[] = new ArrayList[vertex];

            // building tree for BFS...
            BFS_DFS_TreeBuild(graph);

            // traversing calling...
            BFSTraversing(graph);
      }

//------------------------------------------------------------------------------------------------

      public static void DFSTraversing(ArrayList<Edge> graph[] , int cur , boolean visited[]){
            System.out.print(cur +" ");
            visited[cur] = true;

            for (int i = 0; i < graph[cur].size(); i++) {
                  Edge e = graph[cur].get(i);
                  if (!visited[e.dest]) {
                        DFSTraversing(graph , e.dest , visited);
                  }
            }
      }

      public static void DFSCall(){ // O(Vertex + Edge)
            int vertex = 7;
            ArrayList<Edge> graph[] = new ArrayList[vertex];

            // build graph for DFS...
            BFS_DFS_TreeBuild(graph);

            // DFS traversing call...
            DFSTraversing(graph, 0, new boolean[graph.length]);
      }

//------------------------------------------------------------------------------------------------

      public static boolean hasPath(ArrayList<Edge> graph[] , int scr , int dest , boolean visited[]){
            if (scr == dest) {
                  return true;
            }

            visited[scr] = true;
            for (int i = 0; i < graph[scr].size(); i++) {
                  Edge e = graph[scr].get(i);
                  // e.dest neighbor
                  if (!visited[e.dest] && hasPath(graph, e.dest, dest, visited)) {
                        return true;
                  }
            }

            return false;
      }

      public static void hasPathCall(){
            int vertex = 7;
            ArrayList<Edge> graph[] = new ArrayList[vertex];

            // build graph ...
            BFS_DFS_TreeBuild(graph);

            // call for hasPath...
            boolean ans = hasPath(graph, 0, 5, new boolean[vertex]);
            System.out.println(ans);
      }

      public static void main(String[] args) {
            // 1...graphBuild();
            // 2...BFSCall();
            // 3...DFSCall();
            hasPathCall();
      }
}
