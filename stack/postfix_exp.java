// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class postfix_exp {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new solve().evaluatePostFix(br.readLine().trim()));
		}
	}
}// } Driver Code Ends


class solve{
    public static int evaluatePostFix(String exp){
         Stack<Integer> stack=new Stack<>(); 
        for(int i=0;i<exp.length();i++){ 
            char c=exp.charAt(i); 
            if(Character.isDigit(c)) 
            stack.push(c - '0'); 
            else{ 
                int val1 = stack.pop(); 
                int val2 = stack.pop(); 
                switch(c) { 
                    case '+': 
                    stack.push(val2+val1); 
                    break; 
                      
                    case '-': 
                    stack.push(val2- val1); 
                    break; 
                      
                    case '/': 
                    stack.push(val2/val1); 
                    break; 
                      
                    case '*': 
                    stack.push(val2*val1); 
                    break; 
              } 
            } 
        } 
        return stack.pop();     
    }
    
}
