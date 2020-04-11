//     Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

// If possible, output any possible result.  If not possible, return the empty string.

// Example 1:

// Input: S = "aab"
// Output: "aba"
// Example 2:

// Input: S 
// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Rearrange
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            String str = "";
            str = sc.next();
            
            int old = str.length();
            	int chs[] = new int[26];
        	  Arrays.fill(chs, 0);
        	  
        	  for(int i=0;i<str.length();i++)
	               chs[str.charAt(i)-'a']++;
	          
	          GfG gfg = new GfG();     
	         str = gfg.rearrangeString(str);
	         int flag=1,ff=0;
	         int chs2[] = new int[26];
	        Arrays.fill(chs2, 0);
	        
	        for(int i=0;i<str.length();i++)
	             chs2[str.charAt(i)-'a']++;
	             
	        if(str.length() != old)
	         System.out.println(0);
	        else
	        {
	            
	        for(int i=0;i<26;i++)
            if(chs[i] != chs2[i])
                ff=1;
            if(ff==1){
                    System.out.println(0);
                }
    else{
	if(str != "-1"){
	for(int i=0;i<str.length();i++)
	{
		if(i>0)
		if(str.charAt(i-1) == str.charAt(i))
			flag=0;
	}
	if(flag == 1)
		System.out.println(1);
	else
	System.out.println(0 );
	}
	else
		System.out.println(0);
    }
    }
        }
    }
}// } Driver Code Ends
/* The below function should return 
the transformed string */
class GfG
{
    
   
   public static String rearrangeString(String S)
   {
       HashMap<Character,Integer> counts = new HashMap<>();
        
        for(Character c: S.toCharArray()){
            counts.put(c,counts.getOrDefault(c,0)+1);
        }
        
        PriorityQueue<Character> maxheap = new PriorityQueue<>((a,b)->counts.get(b)-counts.get(a));
        
        maxheap.addAll(counts.keySet());
        
        StringBuilder result = new StringBuilder();
        
        while(maxheap.size()>1){
            char current = maxheap.remove();
            char next = maxheap.remove();
            
            result.append(current);
            result.append(next);
            
            counts.put(current,counts.get(current)-1);
            counts.put(next,counts.get(next)-1);
            
            if(counts.get(current)>0)
                maxheap.add(current);
                
            if(counts.get(next)>0)
                maxheap.add(next);
        }
        if(!maxheap.isEmpty()){
            char last = maxheap.remove();
            if(counts.get(last)>1)
                return "";
            result.append(last);
        }
        return result.toString();
   }
   
}
