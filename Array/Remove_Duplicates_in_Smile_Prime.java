// { Driver Code Starts
import java.util.*;
import java.util.Scanner;

// Using LinkedListSet


class Remove_Duplicates_in_Smile_Prime
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			//ArrayList<Integer> al = new ArrayList<Integer>();
			int arr[] = new int[n];
			for(int i=0; i<n; i++)
			{
				arr[i] = sc.nextInt();
				
			}
			
			
			GfG g = new GfG();
			g.removeDuplicate(arr);
			
			//Iterator<Integer> itr = al.iterator();
			//while(itr.hasNext())
			//System.out.print(itr.next());
			//for(int i=0;i<arr.length();i++)
				//System.out.print(arr[i]);
			System.out.println();
		t--;
		}
	}
}// } Driver Code Ends
class GfG
{
    // You have to complete the method and print the 
    // array after removing duplicate elements
    void removeDuplicate(int arr[])
    {
	    HashSet<Integer> s = new HashSet<Integer>();

        for( int i =0; i < arr.length ; i++) 
        {
            if(s.add(arr[i]))
            {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
