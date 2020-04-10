// { Driver Code Starts
import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			GfG g = new GfG();
			System.out.println(g.atoi(str));
		t--;
		}
	}
}// } Driver Code Ends
/*You are required to complete this method */
class GfG
{
    int atoi(String str)
    {
    	 int res = 0,flag = 1; // Initialize result

            
            for (int i = 0; i<str.length(); i++){
                if(str.charAt(i) == '-') {
                    flag = -1;
                }
                else if(str.charAt(i) >='0' && str.charAt(i) <= '9'){
                        res = res*10 + str.charAt(i) - '0';
                }
                else {
                    return -1;
                }
            }
            return res*flag;
    }
}
