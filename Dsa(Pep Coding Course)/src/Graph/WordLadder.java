package Graph;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


//Q 127 leetcode

public class WordLadder {
//THIS IS NOT THE BEST SOLUTION
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
		System.out.println("ENTER NUMBER OF VERTICES AND EDGES");
		int v = sc.nextInt();
		int e = sc.nextInt();
		for (int i = 0; i < e; i++) {
			System.out.println("Enter Source and Destination");
			int source = sc.nextInt();
			int destination = sc.nextInt();
			// check if source already exsist or not if not then add if yes then add the
			// destination in hashset of that source
			
			if (hm.containsKey(source)) {
				hm.get(source).add(destination); // this gives us the address of hashset and we simply add a node in it
			    
				if(hm.containsKey(destination)) {
			    	hm.get(destination).add(source);
			    }else {
			    	HashSet<Integer> set = new HashSet<Integer>();
					set.add(source);
					hm.put(destination, set); 
			    }
			} else {
				if(hm.containsKey(destination)) {
					//add des->src
					hm.get(destination).add(source);
					// and make source and add destination to it
					HashSet<Integer> set = new HashSet<Integer>();
					set.add(destination);
					hm.put(source, set); // putting the newly made hashset

				}else {
					HashSet<Integer> set = new HashSet<Integer>();
					set.add(destination);
					hm.put(source, set);
					
					HashSet<Integer> dSet = new HashSet<Integer>();
                    dSet.add(source);
                    
                    hm.put(destination,dSet);
					
				}
			}
		}

		for (Map.Entry<Integer, HashSet<Integer>> ele : hm.entrySet()) {
			int source = ele.getKey();
			HashSet<Integer> nbrSet = ele.getValue();

			System.out.print(source);

			for (Integer nbr : nbrSet) {
				System.out.print("->" + nbr);
			}
			System.out.println();
		}

	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		// step 1 add begin word to list if its not already present
		boolean isPresent = false;
		for (String ele : wordList) {
			if (ele.equals(beginWord)) {
				isPresent = true;
			}
		}
		if (!isPresent) {
			wordList.add(beginWord);
		}
				
		// Step 2 make a graph of hashmap of hashset
		
		HashMap<String,HashSet<String>> hm = new HashMap<>();
		for (String ele : wordList) {
			for (String ele2 : wordList) {
				if (ele2.equals(ele)) {
					continue;
				}
				int count = 0;
				for (int i = 0; i < ele.length(); i++) {// difference in length might cause problem
					if (ele.charAt(i) != ele2.charAt(i)) {
						count++;
					}
				}
				if (count == 1) {				
					if (hm.containsKey(ele)) {
						hm.get(ele).add(ele2); 
						if(hm.containsKey(ele2)) {
					    	hm.get(ele2).add(ele);
					    }else {
					    	HashSet<String> set = new HashSet<String>();
							set.add(ele);
							hm.put(ele2, set); 
					    }
					} else {
						if(hm.containsKey(ele2)) {
							hm.get(ele2).add(ele);
							HashSet<String> set = new HashSet<String>();
							set.add(ele2);
							hm.put(ele, set); 

						}else {
							HashSet<String> set = new HashSet<String>();
							set.add(ele2);
							hm.put(ele, set);
							
							HashSet<String> dSet = new HashSet<String>();
		                    dSet.add(ele);
		                    
		                    hm.put(ele2,dSet);
							
						}
					}
					
					
				
				
				}
				
			}
		}
		
		// Jugad for giving index to each node
		HashMap<String ,Integer> visHM = new HashMap<>();
		int index=0;
        boolean endPresent =false;
		for(Map.Entry<String, HashSet<String>> entry : hm.entrySet()) {
			visHM.put(entry.getKey(),index);
            if(entry.getKey().equals(endWord)){
                endPresent=true;
            }
			index++;
		}
		if(!endPresent){ // if there's no end word means no solution
            return 0;
        }		
		
		//Step 3 apply bfs on the graph		
		
		boolean []visited= new boolean[visHM.size()];
        ArrayDeque<Pair> que= new ArrayDeque<>();
        if(visHM.size()==0){ // this means no solution present
            return 0;
        }
        que.add(new Pair(beginWord,1,visHM.get(beginWord)));// making begin word as 0 vertex
        int count=0;
        while(!que.isEmpty()) {
        	Pair rem= que.remove();
        	if(visited[rem.idx]) {
        		continue;
        	}  	
        	visited[rem.idx]=true;
        	if(rem.vertx.equals(endWord)) {
        		count=rem.count;
        		break;
        	}
               for(String el:hm.get(rem.vertx)) {
            	   if(!visited[visHM.get(el)]) {
            		   que.add(new Pair(el,rem.count+1,visHM.get(el)));
            	   }
               }  
        }
        return count;
	}	
	public static class Pair{
		int count;
		String vertx;
		int idx;
		public Pair(String vertx,int count, int idx) {
			this.vertx=vertx;
			this.count=count;
		    this.idx=idx;
		}
	}
}
