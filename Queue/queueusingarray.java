// { Driver Code Starts
import java.util.Scanner;

class queueusingarray
{
	public static void main(String args[])
	{
		 Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
		 {
			MyQueue obj = new MyQueue();
			int Q = sc.nextInt();
			while(Q>0)
			{
				int QueryType = 0;
				QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					
					obj.push(a);
					
				}else if(QueryType == 2)
				{
				System.out.print(obj.pop()+" ");
				}
				Q--;
			}
			System.out.println("");
			t--;
		 }
	}
}



// } Driver Code Ends


class MyQueue {

    int front, rear;
	int arr[] = new int[100005];

    MyQueue()
	{
		front=0;
		rear=0;
	}
	
	/* The method push to push element
	   into the queue */
	void push(int a)
	{
	    // Your code here
	    arr[rear++] = a;
	} 

    /* The method pop which return the 
       element poped out of the queue*/
	int pop()
	{
		// Your code here
		if(front >= rear)
        return -1;
        
        return arr[front++];
	} 
}



