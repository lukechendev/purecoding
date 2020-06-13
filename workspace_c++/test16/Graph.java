import java.io.*;
import java.util.*;

public class Graph {
  private int v;

  private LinkedList<Integer> adj[];

  public Graph(int v) {
    this.v = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; ++i) {
      adj[i] = new LinkedList();
    }
  }

  public void addEdge(int v, int m) {
    adj[v].add(m);
  }

  public void DFS(int v) {
    System.out.println(v + " ");
    for (int i = 0; i < adj[v].size(); ++i) {
      DFS(adj[v].get(i));
    }
  }
  
  public static void main(String[] args) {
    Graph g = new Graph(4); 
  
    g.addEdge(0, 1); 
    g.addEdge(0, 2); 
    g.addEdge(1, 2); 
    g.addEdge(2, 0); 
    g.addEdge(2, 3); 
    g.addEdge(3, 3); 
 
    System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)"); 
  
    g.DFS(2); 
  }
}
