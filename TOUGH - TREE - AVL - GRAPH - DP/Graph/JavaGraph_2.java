import java.util.*;

public class JavaGraph_2 {

      static class Edge{
            int scr;
            int dest;

            public Edge(int s,int d ){
                  this.scr = s;
                  this.dest = d;
            }
      }

      public static void graphCreate(ArrayList<Edge> graph[]){
            for (int i = 0; i < graph.length; i++) {
                  graph[i] = new ArrayList<>();
            }

            graph[0].add(new Edge(0, 1));
            graph[0].add(new Edge(0, 2));
            graph[0].add(new Edge(0, 3));

            graph[1].add(new Edge(1, 0));
            graph[1].add(new Edge(1, 2));

            graph[2].add(new Edge(2, 0));
            graph[2].add(new Edge(2, 1));

            graph[3].add(new Edge(3, 0));
            graph[3].add(new Edge(3, 4));

            graph[4].add(new Edge(4, 3));
      }

      public static boolean detectCycle(ArrayList<Edge> graph[]){ // (Vertex + Edge)
            boolean visited[] = new boolean[graph.length];

            for (int i = 0; i < visited.length; i++) {
                  if (!visited[i]) {
                        if (detectCycleUtil(graph , visited , i , -1)) {
                              return true;
                              // cycle exist in one of its parts
                        }
                  }
            }

            return false;
      }

      public static boolean detectCycleUtil(ArrayList<Edge> graph[] , boolean visited[] , int cur , int parent){ // (Vertex + Edge)
            visited[cur] = true;

            for (int i = 0; i < graph[cur].size(); i++) {
                  Edge e = graph[cur].get(i);
                  // case 3 when neighbor is not visited...then call for it's neighbors...
                  // if they give true then give true....
                  if (!visited[e.dest]) {
                        if (detectCycleUtil(graph, visited, e.dest, cur)) {
                              return true;
                        }
                  }

                  // case 1 if destination is visited and it's not equal to parent...
                  // then cycle will always exist...
                  else if (visited[e.dest] && e.dest != parent) {
                        return true;
                  }

                  // case 2 --> do  nothing... continue...if it's a parent and visited...
            }

            return false;
      }

      public static void cycleDetectionCall(){
            /*
             *           0 -------3
             *         / |        |
             *       /   |        |  
             *      1    |        4  
             *       \   |
             *        \  |
             *          2  
            */

            int vertex = 5;
            ArrayList<Edge> graph[] = new ArrayList[vertex];
            graphCreate(graph);

            System.out.println(detectCycle(graph));
      }

//-------------------------------------------------------------------------------------------------------------------

// A Bipartite Graph is a graph whose vertices can be divided into two independent sets, U and V such that every edge
// (u, v) either connects a vertex from U to V or a vertex from V to U. In other words, for every edge (u, v), either u
// belongs to U and v to V, or u belongs to V and v to U. We can also say that there is no edge that connects vertices of
// same set.
      public static void bipartiteGraphCreate(ArrayList<Edge> graph[]){
            // If graph doesn't have cycle then it is a BIPARTITE GRAPH && for Even vertex It is and for odd It is not...
            for (int i = 0; i < graph.length; i++) {
                  graph[i] = new ArrayList<>();
            }

            graph[0].add(new Edge(0, 1));
            graph[0].add(new Edge(0, 2));

            graph[1].add(new Edge(1, 0));
            graph[1].add(new Edge(1, 3));

            graph[2].add(new Edge(2, 0));
            graph[2].add(new Edge(2, 4));

            graph[3].add(new Edge(3, 1));
            graph[3].add(new Edge(3, 4));

            graph[4].add(new Edge(4, 2));
            graph[4].add(new Edge(4, 3));

      }

      public static boolean isBipartite(ArrayList<Edge> graph[]){
            int color[] =  new int[graph.length]; // color array with -1  means no color initially...
            for (int i = 0; i < color.length; i++) {
                  color[i] = -1;
            }

            Queue<Integer> q = new LinkedList<>(); // new queue for BFS...

            for (int i = 0; i < graph.length; i++) {
                  if (color[i] == -1) { // check for every part of graph... and then perform BFS
                        q.add(i);
                        color[i] = 0 ; // means olive color...
                        while (!q.isEmpty()) {
                              int cur = q.remove();
                              // check for every neighbor 
                              for (int j = 0; j < graph[cur].size(); j++) {
                                    Edge e = graph[cur].get(j); // every neighbor is e.destination ...
                                    // their are 3 condition ... 
                                    // 1st case ( destination has no color)
                                    if (color[e.dest] == -1) {
                                          // we'll give opposite color to every neighbor
                                          // find color of nextCol it will be 0 or 1 
                                          int nextCol = color[cur] == 0 ? 1 : 0;
                                          // we'll give color and add every dest to our queue
                                          color[e.dest] =  nextCol;
                                          q.add(e.dest);
                                    }else if (color[e.dest] == color[cur]) {
                                          // if destination and current color is same then 
                                          // it will be false condition ... no BIPARTITE 
                                          return false;
                                    }
                                    // their is another condition that if neighbor color is opp to it's cur color
                                    // then there will no work to do it will continue...
                              }
                        }
                  }
            }

            return true;
      }

      public static void bipartiteCall(){
            /*
             *              0---------2
             *             /        /
             *            /        /
             *           1        4
             *            \      /
             *             \   /
             *               3  
             */
            int vertex = 5;
            ArrayList<Edge> graph[] = new ArrayList[vertex];
            bipartiteGraphCreate(graph); // making graph call function...
            System.out.println(isBipartite(graph));
      }


//-------------------------------------------------------------------------------------------------------------------

      public static void isCycleCreateGraphForCycle(ArrayList<Edge> graph[]){
            for (int i = 0; i < graph.length; i++) {
                  graph[i] =  new ArrayList<>();
            }

            graph[0].add(new Edge(0, 2));

            graph[1].add(new Edge(1, 0));

            graph[2].add(new Edge(2, 3));

            graph[3].add(new Edge(3, 0));
      }

      public static void isCycleCreateGraphForNonCycle(ArrayList<Edge> graph[]){
            for (int i = 0; i < graph.length; i++) {
                  graph[i] =  new ArrayList<>();
            }

            graph[0].add(new Edge(0, 1));

            graph[0].add(new Edge(0, 2));

            graph[1].add(new Edge(1, 3));

            graph[2].add(new Edge(2, 3));
      }

      public static boolean isCycle(ArrayList<Edge> graph[]){

            boolean visited[] =  new boolean[graph.length];
            boolean stack[] = new boolean[graph.length];

            for (int i = 0; i < graph.length; i++) {
                  if (!visited[i]) {
                        if (isCycleUtil(graph, i, visited, stack)) {
                              return true;
                        }
                  }
            }

            return false;
      }

      public static boolean isCycleUtil(ArrayList<Edge> graph[] ,int cur , boolean visited[] , boolean stack[] ){
            visited[cur] = true;
            stack[cur] = true;

            for (int i = 0; i < graph[cur].size(); i++) {
                  Edge e = graph[cur].get(i);
                  // if cycle exist then stack will content it's value to true
                  if (stack[e.dest]) {
                        return true;
                  }

                  if (!visited[e.dest] && isCycleUtil(graph, e.dest, visited, stack)) {
                        return true;
                  }
            }

            stack[cur] =  false;
            return false;
      }

      public static void isCycleGraphCall(){
            int vertex = 4 ;

            ArrayList<Edge> graph [] = new ArrayList[vertex];
            // isCycleCreateGraphForCycle(graph);
            isCycleCreateGraphForNonCycle(graph);
            System.out.println(isCycle(graph));
      }


//-------------------------------------------------------------------------------------------------------------------

      // Topological Sorting
      // Directed Acyclic Graph(DAG) is a directed graph with no cycles.
      // Topological sorting is used only for DAGS (not for non-DAGs)
      // It is a linear order of vertices such that every directed edge u -> v,
      // the vertex u comes before v in the order.


      public static void createGraphTopologicalSorting(ArrayList<Edge> graph[]){
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

      public static void topologicalSort(ArrayList<Edge> graph[]){
            boolean visited[] = new boolean[graph.length];
            Stack<Integer> s = new Stack<>();

            for (int i = 0; i < graph.length; i++) {
                  if (!visited[i]) {
                        topologicalSortUtil(graph , i , visited , s);
                  }
            }

            System.out.println(s);
      }

      public static void topologicalSortUtil(ArrayList<Edge> graph[] , int cur, boolean visited[] , Stack<Integer> s){
            visited[cur] = true;

            for (int i = 0; i < graph[cur].size(); i++) {
                  Edge e = graph[cur].get(i);
                  if (!visited[e.dest]) {
                        topologicalSortUtil(graph, e.dest, visited, s);
                  }
            }

            s.push(cur);
      }

      public static void topologicalSortingCall(){
            int vertex = 6;

            ArrayList<Edge> graph[] = new ArrayList[vertex];
            createGraphTopologicalSorting(graph);
            topologicalSort(graph);
      }

//-------------------------------------------------------------------------------------------------------------------

      public static void main(String[] args) {
            // 1...cycleDetectionCall();  // O(Vertex + Edge)
            // 2...bipartiteCall(); // O(Vertex + Edge)
            // 3...isCycleGraphCall(); // O(Vertex + Edge)
            // 4...topologicalSortingCall();  // O(Vertex + Edge)
      }
}
