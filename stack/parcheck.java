// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class parcheck
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            String st = sc.next();
            if(new Parenthesis().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}// } Driver Code Ends


class Parenthesis
{
    // Function to return if the paranthesis are balanced or not
    static boolean ispar(String s)
    {
        HashMap<Character, Character> mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if (mappings.containsKey(c)) {
            char topElement = stack.empty() ? '#' : stack.pop();
            if (topElement != mappings.get(c)) {
              return false;
            }
          } else {
            stack.push(c);
          }
        }
        return stack.isEmpty();
    }
}
