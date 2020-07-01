// { Driver Code Starts
// Given a set of N jobs where each job i has a deadline and profit associated to it. Each job takes 1 
// unit of time to complete and only one job can be scheduled at a time. We earn the profit if and only 
// if the job is completed by its deadline. The task is to find the maximum profit and the number of jobs done.

// Input:
// The first line of input contains an integer T denoting the number of test cases. Each test case 
// consist of an integer N in first line denoting the number of jobs and the next line consist of Job id,
// Deadline and the Profit associated to that Job.

// Output:
// Output the number of jobs done and the maximum profit.

// Your Task : Complete the function jobscheduling() that returns count of jobs and maximum profit.

// Constraints:
// 1 <= T <= 100
// 1 <= N <= 100
// 1 <= Deadline <= 100
// 1 <= Profit <= 500

// Expected Time Complexity : O(NlogN)
// Expected Auxilliary Space : O(N)

// Example:
// Input:
// 2
// 4
// 1 4 20 2 1 10 3 1 40 4 1 30
// 5
// 1 2 100 2 1 19 3 2 27 4 1 25 5 1 15

// Output:
// 2 60
// 2 127

// Explanation:
// Testcase 1: 2 jobs can be done with maximum profit of 60 (20+40).
// Testcase 2: 2 jobs can be done with maximum profit of 127 (100+27).
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            int[] res = new solve().JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}// } Driver Code Ends


class Sortbyprof implements Comparator<Job>
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Job a, Job b) 
    { 
        return (int)b.profit - (int)a.profit; 
    } 
} 

class solve{
    // return an array of size 2 having the 0th element equal to the count
    // and 1st element equal to the maximum profit
    int[] JobScheduling(Job arr[], int n){
        // Your code here
        Arrays.sort(arr, new Sortbyprof()); 
        HashSet<Integer> s = new  HashSet<Integer>();
        s.add(arr[0].deadline);
        int res = arr[0].profit;
        for(int i=1;i<n;i++){
            for(int j=arr[i].deadline;j>=1;j--){
                if(!s.contains(j)){
                    System.out.print(j+"__");
                    s.add(j);
                    res+=arr[i].profit;
                    break;
                }
            }
        }
        System.out.print(s);
        return new int[]{s.size(),res};
    }
}
