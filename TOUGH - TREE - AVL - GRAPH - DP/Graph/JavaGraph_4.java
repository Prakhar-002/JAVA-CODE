import java.util.ArrayList;
import java.util.PriorityQueue;

public class JavaGraph_4 {
      

      static class Edge {
            int src ;
            int dest;
            int weight;

            public Edge(int src, int dest , int wt){
                  this.src = src;
                  this.dest = dest;
                  this.weight = wt;
            }
      }

//--------------------------------------------------------------------------------------------------------------
// Dijkstra's Algorithm
// Shortest paths from the source to all vertices (weighted graph)

      public static void DijkstraTree(ArrayList<Edge> graph[]){
            for (int i = 0; i < graph.length; i++) {
                  graph[i] = new ArrayList<>();
            }

            /*             (7)
            *         >1----------->3
            *        / |         ^| \    
            *   (2) / |          |   \>(1)
            *     0  |(1)     (2)|   5 
            *     \  |           |  />
            *   (4)\ |>          | /(5)
            *       >2------------->4
            *            (3)
            */         

            graph [0] . add (new Edge(0, 1, 2));
            graph [0] .add ( new Edge(0, 2, 4));

            graph [1] . add (new Edge(1, 3, 7));
            graph [1] . add (new Edge(1, 2, 1));

            graph [2] .add ( new Edge(2, 4, 3));

            graph [3] . add (new Edge(3, 5, 1));

            graph [4] .add ( new Edge(4, 3, 2));
            graph [4] .add ( new Edge(4, 5, 5));
      }

      static class Pair implements Comparable<Pair>{
            int node;
            int path;

            public Pair(int node , int path){
                  this.node = node ;
                  this.path = path;
            }

            @Override
            public int compareTo(Pair p){
                  return this.path - p.path; // pair ke base pr sort...
            }
      }

      public static void Dijkstra(ArrayList<Edge> graph[] , int src){
            int distance[] = new int[graph.length];
            for (int i = 0; i < distance.length; i++) {
                  if (i != src) {
                        distance[i] = Integer.MAX_VALUE; // +infinity...
                  }
            }

            boolean visited[] = new boolean[graph.length];
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            // add first pair source...
            pq.add(new Pair(src, 0)); // node is src and distance is 0
            while (!pq.isEmpty()) {
                  Pair cur = pq.remove();
                  if (!visited[cur.node]) { // if node is not visited...
                        // neighbors...
                        for (int i = 0; i < graph[cur.node].size(); i++) {
                              Edge e = graph[cur.node].get(i);
                              int u = e.src;
                              int v = e.dest;
                              int wt = e.weight;

                              if (distance[u] + wt < distance[v])  {
                                    // we'll update...
                                    distance[v] = distance[u] + wt;
                                    // we'll add in pq
                                    pq.add(new Pair(v, distance[v]));
                              }
                        }
                  }
            }

            // print 
            System.out.println("Minimum Distance up to destination from source is");
            for (int i = 0; i < distance.length; i++) {
                  if (distance[i] == Integer.MAX_VALUE) {
                        System.out.println("From "+src+" To "+i+ " -> "+"Not Linked");
                        continue;
                  }
                  System.out.println("From 0 To "+i+ " -> "+distance[i]);
            }
      }

      public static void DijkstraTreeCall(){
            int vertex = 6;
            ArrayList<Edge> graph[] = new ArrayList[vertex];
            DijkstraTree(graph);

            int src = 2; // let any source...

            Dijkstra(graph , src);
      }

//--------------------------------------------------------------------------------------------------------------
// Bellman Ford Algorithm
// Shortest paths from the source to all vertices (negative edges)

// Perform this operation V-1 times
// for all edges (u, v)
// if dist[ul + wt(u, v) < dist[vl
// dist[vl = dist[ul + wt(u, v)

// Note - doesn't work for Negative W3ht Cycles ...

      public static void  BellmanFordGraph(ArrayList<Edge> graph[]){
            for (int i = 0; i < graph.length; i++) {
                  graph[i] = new ArrayList<>();
            }

            graph[0].add(new Edge(0, 1, 2));
            graph[0].add(new Edge(0, 2, 4));

            graph[1].add(new Edge(1, 2, -4));

            graph[2].add(new Edge(2, 3, 2));

            graph[3].add(new Edge(3, 4, 4));

            graph[4].add(new Edge(4, 1, -1));
      }

      public static void BellmanFord(ArrayList<Edge> graph[] , int src){
            int distance[] = new int[graph.length];
            for (int i = 0; i < distance.length; i++) {
                  if (i != src) {
                        distance[i] = Integer.MAX_VALUE;
                  }
            }

            int V = graph.length ;

            // algo... (V)
            for (int i = 0; i < V-1; i++) {
                  // Edge --O(Edge)
                  for (int j = 0; j < graph.length; j++) {
                        for (int k = 0; k < graph[j].size(); k++) {
                              Edge e = graph[j].get(k);

                              // update 
                              if (distance[e.src] != Integer.MAX_VALUE && (distance[e.src] + e.weight) < distance[e.dest]) {
                                    distance[e.dest] = distance[e.src] + e.weight;
                              }
                        }
                  }
            }

            // print 
            System.out.println("Minimum Distance up to destination from source is");
            for (int i = 0; i < distance.length; i++) {
                  if (distance[i] == Integer.MAX_VALUE) {
                        System.out.println("From "+src+" To "+i+ " -> "+"Not Linked");
                        continue;
                  }
                  System.out.println("From "+src+" To "+i+ " -> "+distance[i]);
            }
      }

      public static void BellmanFordCall() {
            int vertex = 5;
            ArrayList<Edge> graph[] = new ArrayList[vertex];

            /*                           (-1)
             *                 >1 <----------------
             *                /  |                  \
             *            (2)/   |                   \ 
             *              /    |                    4
             *             0     | (-4)              /^ 
             *               \   |                 / (4) 
             *             (4)\  |>               /    
             *                 >2 ------------->3   
             *                         (2)    
             */ 

            BellmanFordGraph(graph);

            BellmanFord(graph, 2);
      }

//--------------------------------------------------------------------------------------------------------------
// for only edges...


      public static void  BellmanFordGraphForEdges(ArrayList<Edge> graph){
            graph.add(new Edge(0, 1, 2));
            graph.add(new Edge(0, 2, 4));

            graph.add(new Edge(1, 2, -4));

            graph.add(new Edge(2, 3, 2));

            graph.add(new Edge(3, 4, 4));

            graph.add(new Edge(4, 1, -1));
      }

      public static void BellmanFordForEdges(ArrayList<Edge> graph , int src , int V){
            int distance[] = new int[V];
            for (int i = 0; i < distance.length; i++) {
                  if (i != src) {
                        distance[i] = Integer.MAX_VALUE;
                  }
            }

            // algo... (V)
            for (int i = 0; i < V-1; i++) {
                  // Edge --O(Edge)
                  for (int j = 0; j < graph.size(); j++) {
                        Edge e = graph.get(j);

                        // update 
                        if (distance[e.src] != Integer.MAX_VALUE && (distance[e.src] + e.weight) < distance[e.dest]) {
                              distance[e.dest] = distance[e.src] + e.weight;
                        }
                  }
            }

            // print 
            System.out.println("Minimum Distance up to destination from source is");
            for (int i = 0; i < distance.length; i++) {
                  if (distance[i] == Integer.MAX_VALUE) {
                        System.out.println("From "+src+" To "+i+ " -> "+"Not Linked");
                        continue;
                  }
                  System.out.println("From "+src+" To "+i+ " -> "+distance[i]);
            }
      }

      public static void BellmanFordCallForEdges() {
            int V = 5;
            ArrayList<Edge> graph = new ArrayList();

            /*                           (-1)
             *                 >1 <----------------
             *                /  |                  \
             *            (2)/   |                   \ 
             *              /    |                    4
             *             0     | (-4)              /^ 
             *               \   |                 / (4) 
             *             (4)\  |>               /    
             *                 >2 ------------->3   
             *                         (2)    
             */ 

            BellmanFordGraphForEdges(graph);

            BellmanFordForEdges(graph, 0 , V);
      }

//---------------------------------------------------------------------------------------------------------------

// Minimum Spanning Tree (MST)
// A minimum spanning tree (MST) or minimum weight spanning tree is a subset of the
// edges of a connected, edge-weighted undirected graph that connects all the vertices
// together, without any cycles and with the minimum possible total edge weight.

// Prim's Algorithm...

      public static void PrimAlgorithmGraphCreate(ArrayList<Edge> graph[]){
            for (int i = 0; i < graph.length; i++) {
                  graph[i] = new ArrayList<>();
            }

            /*
             *                      0
             *                   /  |   \
             *             (10)/    |     \ (15)
             *               /      |       \   
             *             1        | (30)   2   
             *              \       |      /
             *          (40)  \     |     / (50)
             *                  \   |    / 
             *                      3   
             *                    
             */

            graph[0].add(new Edge(0, 1, 10));
            graph[0].add(new Edge(0, 2, 15));
            graph[0].add(new Edge(0, 3, 30));

            graph[1].add(new Edge(1, 0, 10));
            graph[1].add(new Edge(1, 3, 40));

            graph[2].add(new Edge(2, 0, 15));
            graph[2].add(new Edge(2, 3, 50));

            graph[3].add(new Edge(3, 0, 30));
            graph[3].add(new Edge(3, 1, 40));
            graph[3].add(new Edge(3, 2, 50));
      }

      static class PrimPair implements Comparable<PrimPair>{
            int vertex;
            int cost;

            public PrimPair(int v , int c){
                  this.vertex = v;
                  this.cost = c;
            }

            @Override
            public int compareTo(PrimPair p){
                  return this.cost - p.cost;
            }
      }

      public static void Prims(ArrayList<Edge> graph[]){
            boolean visited[] = new boolean[graph.length];

            PriorityQueue<PrimPair> pq= new PriorityQueue<>();
            pq.add(new PrimPair(0, 0)); // initialize with 0 vertex and 0 cost of 1 vertex...
            int finalCost = 0; // MST total minimum 
            ArrayList<Edge> MST = new ArrayList<>(); // we'll store all vertex...

            while (!pq.isEmpty()) {
                  PrimPair cur= pq.remove();
                  // vertex is not visited then we'll perform our task...
                  if (!visited[cur.vertex]) {
                        visited[cur.vertex] = true;
                        finalCost += cur.cost;
                        MST.add(new Edge(cur.vertex, cur.cost, finalCost));

                        for (int i = 0; i < graph[cur.vertex].size(); i++) {
                              Edge e = graph[cur.vertex].get(i);
                              pq.add(new PrimPair(e.dest, e.weight));
                        }
                  }
            }

            System.out.println("minimum cost of MST is "+ finalCost);
            for (int i = 0; i < MST.size(); i++) {
                  Edge e = MST.get(i);
                  System.out.println("vertex "+ e.src + " with edge wright ->"+ e.dest);
            }
      }

      public static void PrimAlgorithmCall(){
            int vertex = 4;
            ArrayList<Edge> graph[] = new ArrayList[vertex];

            PrimAlgorithmGraphCreate(graph);

            Prims(graph);
      }

      public static void main(String[] args) {
            // 1...DijkstraTreeCall();  // O(vertex + edge Log( vertex ) ) because of pq...
            // 2...BellmanFordCall(); // (V * Edge ) --> V = graph.length-1
            // 3...BellmanFordCallForEdges(); // (V * Edge ) --> V = graph.length-1
            // 4...PrimAlgorithmCall();
      }
}
