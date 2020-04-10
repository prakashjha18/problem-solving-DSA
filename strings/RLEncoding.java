// { Driver Code Starts
import java.util.*;
 
class RLEncoding
{
   public static void main(String[] args) 
   {
 
      Scanner sc = new Scanner(System.in);
    
	  int T = sc.nextInt();
	  sc.nextLine();
	  while(T>0)
	  {
		  
		String str = sc.nextLine();
		
		GfG g = new GfG();
		System.out.println(g.encode(str));
		
      
        T--;
	  }
   }
}

// } Driver Code Ends
class GfG
 {
	String encode(String str)
	{
          //Your code here
          String s="";
          int n = str.length(); 
            for (int i = 0; i < n; i++) { 
                // Count occurrences of current character 
                int count = 1; 
                while (i < n - 1 &&  
                       str.charAt(i) == str.charAt(i + 1)) { 
                    count++; 
                    i++; 
                } 
                // Print character and its count 
                s+=str.charAt(i); 
                s+=count; 
            } 
            return s;
	}
	
 }
