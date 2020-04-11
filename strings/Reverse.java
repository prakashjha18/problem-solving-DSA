// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0) {
            String s = sc.next();

            Reverse obj = new Reverse();
            obj.reverseWords(s);
             System.out.println();

            test--;
        }
    }
}
// } Driver Code Ends
class Reverse {

    public static void reverseWords(String str) {
       // System.out.print(sd);
        //String str = "Geeks.forGeeks.forStu.ents"; 
        String[] arrOfStr = str.split("\\.");
        for(int i=arrOfStr.length-1;i>=0;i--){
            if(i==0)
                System.out.print(arrOfStr[i]);
            else
            System.out.print(arrOfStr[i]+".");
        }
    }
}
