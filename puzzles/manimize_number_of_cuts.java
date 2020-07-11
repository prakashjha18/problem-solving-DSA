// Java program to find minimum 
// time required to split a 
// stick of N length into 
// unit pieces 
import java.lang.*; 
  
class GFG{ 
      
// Function to return the 
// minimum time required 
// to split stick of N into 
// length into unit pieces 
static int min_time_to_cut(int N) 
{ 
    if (N == 0) 
        return 0; 
          
    // Return the minimum 
    // unit of time required 
    return (int)Math.ceil(Math.log(N) /  
                          Math.log(2)); 
} 
  
// Driver Code 
public static void main(String[] args) 
{ 
    int N = 100; 
    System.out.print(min_time_to_cut(N)); 
} 
} 
