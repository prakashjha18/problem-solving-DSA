// { Driver Code Starts
import java.util.*;
import java.util.Stack;
import java.util.LinkedList;



class queueusingstacks
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			StackQueue g = new StackQueue();
			int q = sc.nextInt();
			while(q>0)
			{
				int QueryTyoe = sc.nextInt();
				if(QueryTyoe == 1)
				{
					int a = sc.nextInt();
					g.insert(a);
				}else
				if(QueryTyoe == 2)
				System.out.print(g.remove()+" ");
			q--;
				
			}
			System.out.println();
		t--;
		}
	}
}

// } Driver Code Ends


class StackQueue
{
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public int size() {
        return stack1.size() + stack2.size();
    }
    void insert(int B){
	   stack1.push(B);
    }
    int remove(){
	   if (size() == 0) {
            return -1;
        }
        if (stack2.isEmpty()) {
            shiftStacks();
        }
        return stack2.pop();
    }
    private void shiftStacks() {
        while (!stack1.isEmpty()) {
            Integer temp = stack1.pop();
            stack2.push(temp);
        }
    }
}
