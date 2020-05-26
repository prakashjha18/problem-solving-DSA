// { Driver Code Starts
//https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
/*package whatever //do not write package name here */
// Given a sorted dictionary (array of words) of an alien language, find order of characters in the language.
// Examples:

// Input:  words[] = {"baa", "abcd", "abca", "cab", "cad"}
// Output: Order of characters is 'b', 'd', 'a', 'c'
// Note that words are sorted and in the given language "baa" 
// comes before "abcd", therefore 'b' is before 'a' in output.
// Similarly we can find other orders.

// Input:  words[] = {"caa", "aaa", "aab"}
// Output: Order of characters is 'c', 'a', 'b'

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution T = new Solution();
		  //  System.out.println(T.printOrder(words,k));
		    String order = T.printOrder(words,k);
		    
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return 1;
                        else
                            return 0;
                    }
                
                    if(index1 < index2)
                        return 1;
                    else
                        return 0;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    void topologicalSortUtil(ArrayList<ArrayList<Integer>> list,int v, boolean visited[],  
                             Stack<Integer> stack)  
    {  
        visited[v] = true;  
    
        for(Integer it : list.get(v)){
            if (!visited[it])  
                topologicalSortUtil(list,it, visited, stack);  
        }
        stack.push(new Integer(v));  
    }  
    int[] topoSort(ArrayList<ArrayList<Integer>> list, int N) {
        // add your code here
        Stack<Integer> stack = new Stack<Integer>();  
    
        boolean visited[] = new boolean[N];  
        for (int i = 0; i < N; i++)  
            visited[i] = false;  
    
        for (int i = 0; i < N; i++)  
            if (visited[i] == false)  {
                topologicalSortUtil(list,i, visited, stack);  
            }
        int arr[] = new int[N];
        
        int k=0;
        while (stack.empty()==false)  {
            arr[k] = stack.pop();
            k++;
        }
        return arr;
    }
    public String printOrder(String [] words,int k)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
         for (int i = 0; i < k; i++)
                list.add(i, new ArrayList<Integer>());
        for (int i = 0; i < words.length - 1; i++) 
        { 
            String word1 = words[i]; 
            String word2 = words[i+1]; 
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) 
            { 
                if (word1.charAt(j) != word2.charAt(j)) 
                { 
                    list.get(word1.charAt(j) - 'a').add(word2.charAt(j)- 'a');
                    //System.out.print((word1.charAt(j) - 'a')+"...."+(word2.charAt(j)- 'a')+"____");
                    //graph.addEdge(word1.charAt(j) - 'a', word2.charAt(j)- 'a'); 
                    break; 
                } 
            } 
        } 
        
        int[] res = topoSort(list,k);
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<res.length;i++){
            char c = (char)('a'+res[i]);
            sb.append(c);
        }
        return sb.toString();
    }
}
