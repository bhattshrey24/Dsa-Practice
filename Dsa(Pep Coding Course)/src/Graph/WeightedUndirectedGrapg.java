package Graph;
import java.util.LinkedList;


public class WeightedUndirectedGrapg {
	public LinkedList<Edge> adj[];//array of linked List
	
	public WeightedUndirectedGrapg(int v) {
		 adj = new LinkedList[v];// we are initializing adj array , we are just telling its size like int []a; a=new int[v];
		  for(int i=0;i<v;i++) { // assuming vertices starts from 0
			  adj[i]= new LinkedList<Edge>();// we are connecting a empty linked list to every vertex i.e element of array adj
		  }
	}
	
	static class Edge{  // simply make linked list of this class instead of Integer if your graph is weighted it will look like a[1]=>(v:2,w:8)->(v:4,w:5)
  		  int vertice;             
		  int weight;
		  Edge(int v,int w){
			  vertice=v;
			  weight=w;
		  }
	  }
	  public void addEdge(int source, int destination,int weight) {
		  //creating an undirected graph therefore i connected source with destination as well as destination with source 
		  adj[source].add(new Edge(destination,weight));// simply adding the a node in linkedlist of vertice 'source'
		  adj[destination].add(new Edge(source,weight));// if we simply remove this line then it becomes directed graph  
	  }
}
