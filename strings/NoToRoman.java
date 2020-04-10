// { Driver Code Starts
import java.util.Scanner;
import java.util.*;


class NoToRoman
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int N = sc.nextInt();
			
			GfG g = new GfG();
			g.convertToRoman(N);
			t--;
		}
	}
}// } Driver Code Ends
/*you are required to complete this function*/
class GfG
{
    void convertToRoman(int num)
    {
	// Your code here	
	// storing roman values of digits from 0-9  
        // when placed at different places 
        String m[] = {"", "M", "MM", "MMM"}; 
        String c[] = {"", "C", "CC", "CCC", "CD", "D",  
                            "DC", "DCC", "DCCC", "CM"}; 
        String x[] = {"", "X", "XX", "XXX", "XL", "L",  
                            "LX", "LXX", "LXXX", "XC"}; 
        String i[] = {"", "I", "II", "III", "IV", "V",  
                            "VI", "VII", "VIII", "IX"}; 
              
        // Converting to roman 
        String thousands = m[num/1000]; 
        String hundereds = c[(num%1000)/100]; 
        String tens = x[(num%100)/10]; 
        String ones = i[num%10]; 
              
        String ans = thousands + hundereds + tens + ones; 
              
        System.out.println(ans); 
    }
}
