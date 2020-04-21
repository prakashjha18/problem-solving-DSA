// Given two polynomial numbers represented by a linked list. The task is to complete the  function addPolynomial() that adds these lists meaning adds the coefficients who have same variable powers.

// Input:
// The first line of input contains an integer T denoting the number of test cases. Then in the next line is an integer N denoting the number of terms of first polynomial. In the next line are N space separated pairs x and y where x denotes the coefficient and y denotes the power. Similarly In the next line is an integer M denoting the no of terms of the second polynomial and in the line following it are N space separated pairs for second polynomial.

// Output:
// For each test case in a new line print the required polynomial in decreasing order of the power.

// User Task:
// The task is to complete the function addPolynomial() which should add the polynomial with same powers.

// Constraints:
// 1 <= T <= 100
// 1 <= N, M <= 105
// 1 <= x, y <= 106

// Example:
// Input:
// 2
// 1
// 1 2
// 1
// 1 3
// 2
// 1 3 2 2
// 2
// 3 3 4 2
// Output:
// 1x^3 + 1x^2
// 4x^3 + 6x^2
// { Driver Code Starts
import java.util.Scanner;
import java.io.*;
class Node{
    int coeff;
    int pow;
    Node next;
    Node(int a,int b)
    {
        coeff=a;
        pow=b;
        next=null;
    }
}
class GFG2
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            Node start1=null,cur1=null,start2=null,cur2=null;
            while(n-->0)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                Node ptr=new Node(a,b);
                if(start1==null)
                {
                    start1=ptr;
                    cur1=ptr;
                }
                else{
                    cur1.next=ptr;
                    cur1=ptr;
                }
            }
            n=sc.nextInt();
            while(n-->0)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                Node ptr=new Node(a,b);
                if(start2==null)
                {
                    start2=ptr;
                    cur2=ptr;
                }
                else{
                    cur2.next=ptr;
                    cur2=ptr;
                }
            }
            GFG obj=new GFG();
            obj.addPolynomial(start1,start2);
            System.out.println();
        }
    }
}// } Driver Code Ends
/*class Node{
    int coeff;
    int pow;
    Node next;
    Node(int a,int b)
    {
        coeff=a;
        pow=b;
        next=null;
    }
}*/

//Print the polynomial formed by adding both LL in the function itself.
class GFG
{ 
    static int k;
    GFG()
    {
        k=0;
    }
    public static void addPolynomial(Node p1,Node p2)
    {
        
    if(p1!=null && p2!=null){
        if(p1.pow>p2.pow)
        {
            if(k==1)
            System.out.print(" + ");
            System.out.print(p1.coeff+"x^"+p1.pow);
            k=1;
            addPolynomial(p1.next,p2);
        }
        else if(p1.pow<p2.pow)
        {
            if(k==1)
            System.out.print(" + ");
            System.out.print(p2.coeff+"x^"+p2.pow);
            k=1;
            addPolynomial(p1,p2.next);
        }
        else
        {
            if(k==1)
            System.out.print(" + ");
            int num=p1.coeff+p2.coeff;
            System.out.print(num+"x^"+p1.pow);
            k=1;
            addPolynomial(p1.next,p2.next);
        }
    
    }
    else if(p1!=null)
    {
        if(k==1)
        System.out.print(" + ");
        System.out.print(p1.coeff+"x^"+p1.pow);k=1;
        addPolynomial(p1.next,null);
    }
    else if(p2!=null){
        if(k==1)
        System.out.print(" + ");
        System.out.print(p2.coeff+"x^"+p2.pow);k=1;
        addPolynomial(null,p2.next);
    }
    }
}
