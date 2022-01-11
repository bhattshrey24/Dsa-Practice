import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ChefAndReversing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertices and edges in graph");
		int v= sc.nextInt();
		int e= sc.nextInt(); 
		
	    ChefAndReversing obj = new ChefAndReversing();
        System.out.println(); 
        
        WeightedDirectedGraph grf= new WeightedDirectedGraph(v);
        
        for(int i=0;i<e;i++) {
        	System.out.println("Enter source and destination");
        	int source=sc.nextInt();
        	int destination=sc.nextInt();
        	int weight=0;	
          grf.addEdge(source, destination, weight);;
        }
        System.out.println("the source vertex for dijktras");
        int src=sc.nextInt();
       obj.chefAndReverseUsingDijktras(grf, src);
	}	
	public void chefAndReverseUsingDijktras(WeightedDirectedGraph gf, int source) {	 // this is the best case solution  TC is O(E+V) 
		for(int i=0;i<gf.adj.length;i++) {// reversing and adding edges in same graph			
			for(WeightedDirectedGraph.Edge nbr:gf.adj[i]) {
				if(nbr.weight==1) { // if the weight is 1 means we already reversed the edge so no need to do it again
					continue;
				}
			gf.addEdge(nbr.vertice, i, 1);				
			}	
		}
		System.out.println("The Combined Graph with original and reversed edges");
		for(int i=0;i<gf.adj.length;i++) {// just displaying the graph
			System.out.print("["+i+"]");
			for(WeightedDirectedGraph.Edge nbr:gf.adj[i]) {
             System.out.print("->"+"("+nbr.vertice+" "+ nbr.weight+")");			
			}	
			System.out.println();
		}
		
	boolean []visited= new boolean[gf.adj.length];	

	PriorityQueue<Pair> pq= new PriorityQueue<>(); // here since we re using priority queue therefore we dont have to check for the condition d(u)+c(u)<d(v) manually cause priority queue takes care of it
	
	pq.add(new Pair(gf.adj[0].get(0).vertice,gf.adj[0].get(0).weight));
	
	while(!pq.isEmpty()) {
		
		Pair curVertex=pq.remove();// remove
		
		if(visited[curVertex.v]) {// check 
			continue;
		}		
		visited[curVertex.v]=true;	// mark
		
		if(curVertex.v==gf.adj.length-1) { // becasue in question we just have to find min edges required to be reversed from 0 to N(i.e the last vertice)
			System.out.println("min  :"+curVertex.wsf);// this and the graph is the only change rest is just dijktras
			return;
		}	
		for(WeightedDirectedGraph.Edge nbr: gf.adj[curVertex.v]) {
			if(visited[nbr.vertice]==false) {
				pq.add(new Pair(nbr.vertice,curVertex.wsf+nbr.weight));	
			}
		}
	}	
}
		public class Pair implements Comparable<Pair>{
		int v;//Vertex
		int wsf;//(Weight So Far)
	Pair(int v, int wsf){
		this.v=v;
		this.wsf=wsf;
	}
	@Override
	public int compareTo(ChefAndReversing.Pair o) {
		// TODO Auto-generated method stub
		return this.wsf-o.wsf;
	}
	}		
		
//		public void reverse(WeightedDirectedGraph gf,int v) {
//			for(int i=0;i<v;i++) {			
//				for(WeightedDirectedGraph.Edge nbr:gf.adj[i]) {
//					if(nbr.weight==1) {
//						continue;
//					}
////					WeightedDirectedGraph.Edge edg= new WeightedDirectedGraph.Edge(i,1);
////					gf.adj[nbr.vertice].add(edg);
//					 // public void addEdge(int source, int destination,int weight) {
//				gf.addEdge(nbr.vertice, i, 1);				
//				}	
//			}
//			
//		}
	
}


