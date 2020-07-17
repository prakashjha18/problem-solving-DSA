// Problem Description
// Given N three-digit numbers, your task is to find bit score of all N numbers and then print the number of pairs possible 
// based on these calculated bit score.

// 1. Rule for calculating bit score from three digit number:

// From the 3-digit number,

// · extract largest digit and multiply by 11 then

// · extract smallest digit multiply by 7 then

// · add both the result for getting bit pairs.

// Note: - Bit score should be of 2-digits, if above results in a 3-digit bit score, simply ignore most significant digit.

// Consider following examples:

// Say, number is 286

// Largest digit is 8 and smallest digit is 2

// So, 8*11+2*7 =102 so ignore most significant bit , So bit score = 02.

// Say, Number is 123

// Largest digit is 3 and smallest digit is 1

// So, 3*11+7*1=40, so bit score is 40.

// 2. Rules for making pairs from above calculated bit scores

// Condition for making pairs are

// · Both bit scores should be in either odd position or even position to be eligible to form a pair.

// · Pairs can be only made if most significant digit are same and at most two pair can be made for a given significant digit.

// Constraints
// N<=500

// Input Format
// First line contains an integer N, denoting the count of numbers.

// Second line contains N 3-digit integers delimited by space

// Output
// One integer value denoting the number of bit pairs.

// Timeout
// 1

// Explanation
// Example 1

// Input

// 8 234 567 321 345 123 110 767 111

// Output

// 3

// Explanation

// After getting the most and least significant digits of the numbers and applying the formula given in Rule 1 we get the bit scores of the numbers as:

// 58 12 40 76 40 11 19 18

// No. of pair possible are 3:

// 40 appears twice at odd-indices 3 and 5 respectively. Hence, this is one pair.

// 12, 11, 18 are at even-indices. Hence, two pairs are possible from these three-bit scores.

// Hence total pairs possible is 3


import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class pbid2
{
    public static String convert(int n){
        int largest = 0; 
        int smallest = 9; 
        while(n != 0){ 
            int r = n % 10; 
            largest = Math.max(r, largest); 
            smallest = Math.min(r, smallest); 
            n = n / 10; 
        } 
        int no = (largest*11)+(smallest*7);
        String x =String.valueOf(no);
        if(x.length()>2){
            return x.substring(1,x.length());
        }
        return  x;
    }
	public static void main (String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();

        }
        HashMap <Character,Integer> ho = new HashMap<Character,Integer>();
        HashMap <Character,Integer> he = new HashMap<Character,Integer>();
        //HashSet<Character> hs = new HashSet<Character>(); 
        String strr[] = new String[n];
        for(int i=0;i<n;i++){
            int x =arr[i];
            strr[i] = convert(x);
        }
        // for(int i=0;i<n;i++){
        //     System.out.print(strr[i]+" ");
        // }

        for(int i=0;i<n;i+=2){
            if(ho.containsKey(strr[i].charAt(0))){
                ho.put(strr[i].charAt(0),ho.get(strr[i].charAt(0))+1);
            }
            else{
                ho.put(strr[i].charAt(0),1);
            }
        }
        for(int i=1;i<n;i+=2){
            if(he.containsKey(strr[i].charAt(0))){
                he.put(strr[i].charAt(0),he.get(strr[i].charAt(0))+1);
            }
            else{
                he.put(strr[i].charAt(0),1);
            }
        }
        int count=0;
        //System.ou.print(4+a);
        char chr[] = {'0','1','2','3','4','5','6','7','8','9'};
        for(char c:chr){
            if(ho.get(c)!=null){
                int os= ho.get(c);
                if(os==2){
                    count++;
                }
                if(os>2){
                    count+=2;
                }
            }
            if(he.get(c)!=null){
                int es= he.get(c);
                if(es==2){
                    count++;
                }
                if(es>2){
                    count+=2;
                }
            }
        }
        System.out.println(count);
    }
}
