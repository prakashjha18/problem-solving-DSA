// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			while (t-- > 0) {
				String str = br.readLine();
				boolean result = new solve().rearrangeCharacters(str);
				if (result)
					System.out.println(1);
				else
					System.out.println(0);
			}
		} catch (Exception e) {

		}
	}
}
// } Driver Code Ends


class solve{
    static boolean rearrangeCharacters(String S) {
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
                return false;
            result.append(last);
        }
        return true;
	}
}
