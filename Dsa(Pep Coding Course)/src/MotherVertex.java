import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class MotherVertex {

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

System.out.println(motherVertx(grf));
	}
    
	public static boolean motherVertx(WeightedDirectedGraph gf) {
	//Step 1 of kosaraju
		Stack<Integer> solSt= new Stack<>(); 
        boolean []visited= new boolean[gf.adj.length];
        for(int i=0;i<visited.length;i++) {
            dfsRecursion(gf, visited, i, solSt);        	
        }
        int criticalVertex = solSt.pop();
		System.out.println("critical vertex: "+ criticalVertex);
        boolean []vis= new boolean[gf.adj.length];
        Stack<Integer> solSt2= new Stack<>(); 
        dfsRecursion(gf,vis, criticalVertex, solSt2);  
        
    if(solSt2.size()==gf.adj.length) {
	System.out.println("size of solSt2 : "+solSt2.size());
	return true;
     }
   else {
	System.out.println("size of solSt2 : "+solSt2.size());
	return false;
    }
	
	}
	
	public static void dfsRecursion(WeightedDirectedGraph gf,boolean []visited,int vertx,Stack<Integer> sol) {
		
	    if(visited[vertx]) { // base case
			return;
		}		
		visited[vertx]=true; // marking visited
		
		for(WeightedDirectedGraph.Edge nbr:gf.adj[vertx]) {
		        dfsRecursion(gf, visited,nbr.vertice,sol); // adding neighbors
		}
			sol.add(vertx);
	  }

}
