// { Driver Code Starts
import java.util.*;


class Find_All_Possible_Strings
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t =  sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			GfG g = new GfG();
			g.printSpace(str);
                        System.out.println();
			t--;
		}
	}
}// } Driver Code Ends
/*You have to complete this function*/
class GfG
{
    void printSpace(String s)
    {
        char[] str= s.toCharArray(); 
        int n = str.length; 
        int opsize = (int)(Math.pow(2, n - 1)); 
        System.out.print(opsize);
        for (int counter = 0; counter < opsize; counter++) { 
            for (int j = 0; j < n; j++) { 
      
                System.out.print(str[j]); 
                if ((counter & (1 << j)) > 0) 
                    System.out.print(" "); 
            } 
            System.out.println(); 
        } 
    }
}
