package Graph;

import java.util.PriorityQueue;
import java.util.Scanner;



//Question

//There are N homes in a village, we have to facilitate water supply in each of them.
//We can either build a well in a home or connect it with pipe to some different home already
//having water supply. More formally, 
//we can either build a new well in the home or connect it with a pipeline 
//to some different home which either has it’s own well or further gets water
//supply from a different home and so on. There is some cost associated with both building 
//a new well and laying down a new pipeline. We have to supply water in all homes and 
//minimise the total cost.

//Input-
//First line contains an integer N, the number of homes.
//The next line contains N integers, the ith integer denotes the cost of building a well in that home.
//Next line contains an integer K, then K lines follows. Each of which contains 3 integers i, j and p. Which denotes the cost ‘p’ of laying down pipeline between homes i and j.

//Output-
//Output a single integer - the minimum cost to supply water to all the homes

public class OptimizedWaterSupply {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertices and edges in graph");
		int v=sc.nextInt();// this is actually N which is given in question
		int e= sc.nextInt();// this is actually K which is given in question
		WeightedUndirectedGrapg grf= new WeightedUndirectedGrapg(v+1);// V+1 cause we add 1 extra vetex to get solution
		// we assume vertices starts from 0 therefore the extra edge we take make it as Nth vertex
     	for(int i=0;i<e;i++) {
        System.out.println("Enter Source and Destination and Weight");
		int source=sc.nextInt();
		int destination= sc.nextInt();
		int weight=sc.nextInt();
		grf.addEdge(source, destination, weight);
	    }
     	System.out.println("no of vertex is "+grf.adj.length);
     	
     	// adding extra vertex to all other vertex
     	for(int j=0;j<v;j++) {
     		System.out.println("cost of building well at "+j+"th pos ");
     		int wght= sc.nextInt();
     		grf.addEdge(v,j,wght);
     	}
     	//optimizedWaterSupply(grf);
     	System.out.println(optimizedWaterSupply(grf));
	}
	
	public static int optimizedWaterSupply(WeightedUndirectedGrapg gf) {
      //Step1 make a priority queue
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for(WeightedUndirectedGrapg.Edge vrtx :gf.adj[gf.adj.length-1]) {// adding v+1th vertex neighbors to pq , which basically tells the cost of building well on each house/vetex
			pq.add(new Pair(vrtx.vertice,vrtx.weight));
		}
		
		boolean []visited = new boolean[gf.adj.length];
		
		 int minCost=0;
		
		 visited[gf.adj.length-1]=true;// cause we already added all neighbors of last vertex to priority queue cause it tells the well digging price
		 
		 while(!pq.isEmpty()) {
			 
			Pair currEle= pq.remove(); // remove   
		
			if(visited[currEle.v]) {
			
				continue;
		    
			} 
		
		   visited[currEle.v]=true;// mark
		
		   minCost+=currEle.w; //work
		   
		   System.out.println("cuurent vertex "+currEle.v);

		   for(WeightedUndirectedGrapg.Edge vrtx :gf.adj[currEle.v]) {  //add
			
			   if(visited[vrtx.vertice]==false) {
				pq.add(new Pair(vrtx.vertice,vrtx.weight));				
			   }
		}
	  }
		 return minCost;
	}
	
	public static class Pair implements Comparable<Pair>{
		int v;//Vertex
		int w;
	Pair(int v, int w){
		this.v=v;
		this.w=w;
	}
    @Override
    public int compareTo(OptimizedWaterSupply.Pair o) {
	return this.w-o.w;
    }	
	}
	

}
