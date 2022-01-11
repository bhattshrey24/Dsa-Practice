import java.util.Scanner;
import java.util.Stack;

public class Kosaraju_StronglyConnectedGraph {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertices and edges in graph");
		int v= sc.nextInt();
		int e= sc.nextInt(); 
        System.out.println(); 
        WeightedDirectedGraph grf= new WeightedDirectedGraph(v);
        for(int i=0;i<e;i++) {
        	System.out.println("Enter source and destination");
        	int source=sc.nextInt();
        	int destination=sc.nextInt();
        	int weight=0;	
          grf.addEdge(source, destination, weight);;
        }
//        System.out.println("the starting vertex for dfs : ");
//        int start=sc.nextInt();
        
        kosaraju(grf);
		
	}
	
	public static void kosaraju(WeightedDirectedGraph gf) {
		 Stack<Integer> solSt= new Stack<>(); 
	//STEP 1
		 
		 boolean []visited= new boolean[gf.adj.length];
	
		 for(int i=0;i<visited.length;i++) {// we do this cause we have to apply dfs from all the edges cause we have to add all vertices , and it doesnt result in duplicates in stack becasue we are passing same visited array therefore ones that are already added will not be added again in stack
			 dfsRecursion(gf, visited, i, solSt);
	        }
		 
		 
	//STEP 2 (Reversing) // we are reversing in the same graph,  the ones with weight 1 are reversed edgs
		 
			for(int i=0;i<gf.adj.length;i++) {// reversing and adding edges in same graph			
				for(WeightedDirectedGraph.Edge nbr:gf.adj[i]) {
					if(nbr.weight==1) { // if the weight is 1 means we already reversed the edge so no need to do it again
						continue;
					}
				gf.addEdge(nbr.vertice, i, 1);				
				}	
			}
	
	//STEP 3
			
	 int count=0;	

	 boolean []vis= new boolean[gf.adj.length];
	 
		while(!solSt.isEmpty()) {
			int popped= solSt.pop();
			if(vis[popped]!=true) {
				System.out.println("inside if");
				dfsKosaraju(gf,vis,popped);
				count++;
			}
		}
	System.out.println("ANS is :"+count);
	
	}
	
	public static void dfsKosaraju(WeightedDirectedGraph gf,boolean []visited,int vertx ) {
	    if(visited[vertx]) { // base case
			return;
		}		
		visited[vertx]=true; // marking visited
		System.out.println(vertx);// work
		
		for(WeightedDirectedGraph.Edge nbr:gf.adj[vertx]) {
			if(nbr.weight==1) {
		        dfsKosaraju(gf, visited,nbr.vertice); // adding neighbors
				
			}
		}
	}
	

	public static void dfsRecursion(WeightedDirectedGraph gf,boolean []visited,int vertx,Stack<Integer> sol) {
	
    if(visited[vertx]) { // base case
		return;
	}		
	visited[vertx]=true; // marking visited
	
	System.out.println(vertx);// work
	
	for(WeightedDirectedGraph.Edge nbr:gf.adj[vertx]) {
	        dfsRecursion(gf, visited,nbr.vertice,sol); // adding neighbors
	}
	// backtracking
		sol.add(vertx);
  }
	

}
