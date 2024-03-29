// Chef is multi-talented. He has developed a cure for coronavirus called COVAC-19. Now that everyone
// in the world is infected, it is time to distribute it throughout the world efficiently to wipe out 
// coronavirus from the Earth. Chef just cooks the cure, you are his distribution manager.

// In the world, there are N countries (numbered 1 through N) with populations a1,a2,…,aN. Each cure can
// be used to cure one infected person once. Due to lockdown rules, you may only deliver cures to one country
// per day, but you may choose that country arbitrarily and independently on each day. Days are numbered by 
// positive integers. On day 1, Chef has x cures ready. On each subsequent day, Chef can supply twice the
// number of cures that were delivered (i.e. people that were cured) on the previous day. Chef cannot supply
// leftovers from the previous or any earlier day, as the cures expire in a day. The number of cures delivered
// to some country on some day cannot exceed the number of infected people it currently has, either.

// However, coronavirus is not giving up so easily. It can infect a cured person that comes in contact with 
// an infected person again ― formally, it means that the number of infected people in a country doubles at 
// the end of each day, i.e. after the cures for this day are used (obviously up to the population of that
// country).

// Find the minimum number of days needed to make the world corona-free.

// Input
// The first line of the input contains a single integer T denoting the number of test cases. The description 
// of T test cases follows.
// The first line of each test case contains two space-separated integers N and x.
// The second line contains N space-separated integers a1,a2,…,aN.
// Output
// For each test case, print a single line containing one integer ― the minimum number of days.

// Constraints
// 1≤T≤103
// 1≤N≤105
// 1≤ai≤109 for each valid i
// 1≤x≤109
// the sum of N over all test cases does not exceed 106
// Subtasks
// Subtask #1 (20 points): a1=a2=…=aN
// Subtask #2 (80 points): original constraints

// Example Input
// 3
// 5 5
// 1 2 3 4 5
// 5 1
// 40 30 20 10 50
// 3 10
// 20 1 110
// Example Output
// 5
// 9
// 6


import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{   
    public static long utilx(long[] arr,long x){
        Arrays.sort(arr);
        long days = 0l;
        int i=0;
        while(i<arr.length && arr[i]<x){
            long temp_x = 2*arr[i];
            if(temp_x>=x){
                x=temp_x;
                break;
            }
            i++;
        }
        //System.out.print(i + "  "+x+" ");
        for(;i<arr.length;i++){
            //System.out.print(i+" ");
            if((arr[i]*2)>=x){
                if(arr[i]<=x){
                    x=arr[i]*2;
                    arr[i]=0;
                    days++;
                } else if(arr[i]>x){
                    while(x<arr[i]){
                        x=x*2;
                        days++;
                    }
                    x=arr[i]*2;
                    arr[i]=0;
                    days++;
                }
                //System.out.print(x+" ");
            }
        }
        i=0;
        while(i<arr.length){
            if(arr[i]>0){
                days++;
            }
            i++;
        }
        return days;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		try{
    		Scanner sc = new Scanner(System.in);
    		int t = sc.nextInt();
    		while(t-->0){
    		    long n = sc.nextLong();
    		    long x =sc.nextLong();
    		    long arr[] = new long[(int)n];
    		    for(int i=0;i<n;i++)
    		        arr[i]=sc.nextLong();
    		    System.out.println(utilx(arr,x));
    		}
		}
		catch(Exception e){}
	}
}
