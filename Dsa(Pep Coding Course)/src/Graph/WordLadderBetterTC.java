package Graph;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordLadderBetterTC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="pqrswxyz";
		
		for(int i=0;i<str.length();i++) {
			  for(int j=97;j<=122;j++) {
				  if(i==0) {
					  char ch=(char)j;
			          System.out.print(ch+str.substring(i+1)+" ");
				  }
				  else if(i==str.length()-1) {
					   	 char ch=(char)j;
			        	 System.out.print(str.substring(0,str.length()-1)+ch+" ");  
				  }else {
					   	 char ch=(char)j;
			        	 System.out.print(str.substring(0,i)+ch+str.substring(i+1)+" ");
				  } 
		         }
			  System.out.println();
		}
		
		List<String> wordList= new ArrayList<String>();
wordList.add("hot");

wordList.add("dot");		
wordList.add("dog");		
wordList.add("lot");		
wordList.add("log");
wordList.add("cog");	
		
//		wordList.add("dot");		
//		wordList.add("dog");
//		wordList.add("hot");

		

int ans=ladderLength("hit", "cog", wordList);
		System.out.println("Ans:"+ans);
	
       
	}
 	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
// Step 1 Convert given wordlist in hashset
 		boolean isBeginWordPresent=false;
 		HashSet<String> wordListSet= new HashSet<>();
 		
 		for(String ele:wordList) {
 			if(ele.equals(beginWord)) {
 				isBeginWordPresent=true;
 	 			wordListSet.add(ele);
 				continue;
 			}
 			wordListSet.add(ele);
 		}
 		if(!isBeginWordPresent) {
 			wordListSet.add(beginWord);
 		}
 		
// 		for(String ele:wordListSet) {
// 			System.out.println(ele);
// 		}
// 		
 // Step 2 generating all permutation and finding if it is there 
 		ArrayDeque<Pair> que= new ArrayDeque<>();
 		que.add(new Pair(beginWord,1));
 		int min=0;
 		while(!que.isEmpty()) {
 			Pair currEle= que.remove();
 			
 			if(!wordListSet.contains(currEle.word)) {// this is condition for visited
 				continue;
 			}
 			wordListSet.remove(currEle.word);// marked visited , here visited is marked by removing from wordlist
 			
 			if(currEle.word.equals(endWord)) {// work
 				min=currEle.cost;
 			}
 			
 			for(int i=0;i<currEle.word.length();i++) { // finding and adding neighbors
 				  for(int j=97;j<=122;j++) {
 					  String perm="";
 					  if(i==0) {
 						  char ch=(char)j;
 				          perm =ch+currEle.word.substring(i+1);
 					  }
 					  else if(i==currEle.word.length()-1) {
 						   	 char ch=(char)j;
 				        	 perm= currEle.word.substring(0,currEle.word.length()-1)+ch;  
 					  }else {
 						   	 char ch=(char)j;
 				        	 perm =currEle.word.substring(0,i)+ch+currEle.word.substring(i+1);
 					  } 
 					  
 					  if(wordListSet.contains(perm)) {// this is like checking if it is already visited or not
 	 					  // if we inside means we havent visited it
 						  que.add(new Pair(perm,currEle.cost+1));
 	 				  }
 				  }
 				
 			}
 		}
 		
 		return min;
	
	}
 	
 	public static class Pair{
 		String word;
 		int cost;
 		public Pair(String word,int cost) {
 			this.word=word;
 			this.cost=cost;
 		}
 	}

}
