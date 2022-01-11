import java.util.Scanner;

public class ArticulationPoint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertices and edges in graph");
		int v= sc.nextInt();
		int e= sc.nextInt(); 
		WeightedUndirectedGrapg grf= new WeightedUndirectedGrapg(v);
        System.out.println();   
        for(int i=0;i<e;i++) {
        	System.out.println("Enter source and destination");
        	int source=sc.nextInt();
        	int destination=sc.nextInt();
        	int weight=0;
          grf.addEdge(source,destination,weight);
        }
        DisplayArticulationPoint(grf);
        	
	}

	public static void DisplayArticulationPoint(WeightedUndirectedGrapg gf) {

		boolean[] visited = new boolean[gf.adj.length];
		int[] discovery = new int[gf.adj.length];
		int[] parent = new int[gf.adj.length];
		int[] low = new int[gf.adj.length];
		boolean[] isAp = new boolean[gf.adj.length];
		
		int discoveredAt = 0;

		int []countForActualSource = new int [1] ; // this is a jugad cause we cant pass a variable since we want to pass this parameter by reference/address so that anything changed with it can be reflected out of function 

		for (int i = 0; i < gf.adj.length; i++) {
			if (!visited[i]) {
				//System.out.println("inside if with i"+i);
				dfs(gf, visited, i, low, parent, discovery, isAp, discoveredAt, i , countForActualSource);
			   
				if(countForActualSource[0]>=2) {// since there can be multiple components in given graph
			    	isAp[i]=true;
			    }
			}
		}

		System.out.println("Articulation Points Are :-");
		int numberofAP=0;
		for(int i=0;i<isAp.length;i++) {
			if(isAp[i]) {
				numberofAP++;
				System.out.print (i+" AND ");
			}
		}
		if(numberofAP>0) {
			System.out.println("Number of AP are : "+ numberofAP);
		}else {
			System.out.println("There are no AP's");
		}
	}

	public static void dfs(WeightedUndirectedGrapg gf, boolean[] visited, int vertx, int[] low, int[] parent,
			int[] discovery, boolean[] isAp, int discoverdAt, int actualSource , int [] countForActualSource) {

		if (visited[vertx]) { // base case
			return;
		}
		
		//System.out.println();
		visited[vertx] = true; // marking visited

		discovery[vertx] = discoverdAt;// work
		low[vertx] = discoverdAt;// work
		discoverdAt++;// work

		for (WeightedUndirectedGrapg.Edge nbr : gf.adj[vertx]) {
			if (parent[vertx] == nbr.vertice) {
				continue; // that is dont do anything if current nbr is your parent just ignore this
							// neighbor completely
			} else if (visited[nbr.vertice]) {// if neighbor not visited then do dfs
				low[vertx] = Math.min(low[vertx], discovery[nbr.vertice]);
			} else {
				if(vertx==actualSource) {
					countForActualSource[0]+=1; // we are just calculating that how many times dfs is run from actual source cause if its more than one then it means that actual source is also Ap
				}

				parent[nbr.vertice] = vertx;// since we are about to go in dfs so before that make current vertex as
											// father of the neighbor jispr dfs lagne jaara hai
			
				dfs(gf, visited, nbr.vertice, low, parent, discovery, isAp, discoverdAt, actualSource , countForActualSource);

				// now we come here when BACKTRACKING

				low[vertx] = Math.min(low[vertx], low[nbr.vertice]);// now here we used low of neighbor and not
																	// discovery cause while backtracing we obviously
																	// will return in same path in whic dfs was run and
																	// since previously in if block where we checked "is
																	// visited" we updated low with discovery of
																	// neighbor and not low with low of neighbor 
				// therefore right now our neighbor's low
				// can not be less than that(i.e discovery of our
				// neighbor's neighbor) therefore we wont cross any
				// path of dfs

				if (low[nbr.vertice] >= discovery[vertx] && vertx != actualSource) {// that is if my neighbor can at max
																					// reach till me and not
					// before me means i'm the articulation point
					isAp[vertx] = true;
				}

			}
		}
		

	}
	

}
