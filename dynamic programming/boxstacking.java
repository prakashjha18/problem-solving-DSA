// { Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;

class gfg
{
    public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    
    //sc.next();
    while(t-- > 0)
    {
        int n = sc.nextInt();
        
        int A[]  =new int[1000];
        int B[] = new int[1000];
        int C[] = new int[1000];
        
        for(int i = 0; i < n; i++)
        {
            int a =sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            
            A[i] = a;
            B[i] = b;
            C[i] = c;
        }
        
        Geeks ob = new Geeks();
        System.out.println(ob.maxHeight(A,B,C,n));
    }
   }
}// } Driver Code Ends


//User function Template for Java



class Box{
    int h;
    int w;
    int d;
    int area;
    
    public Box(int h,int w,int d){
        this.h = h;
        this.w = w;
        this.d = d;
        area = w * d;
    }
}
class Geeks 
{
    public static int maxHeight(int height[], int width[], int length[], int n)
   {
       Comparator<Box> comp = (b1,b2) -> -Integer.compare(b1.area,b2.area);
       
       Box box[] = new Box[n];
       for(int i = 0;i<n;i++){
           box[i] = new Box(height[i],width[i],length[i]);
       }
       
       Box allRotationsArr[] = new Box[3 * n];
       
       int index = -1;
       for(int i = 0;i<n;i++){
           allRotationsArr[++index] = new Box(box[i].h,Math.max(box[i].d,box[i].w),Math.min(box[i].d,box[i].w));
           allRotationsArr[++index] = new Box(box[i].w,Math.max(box[i].d,box[i].h),Math.min(box[i].d,box[i].h));
           allRotationsArr[++index] = new Box(box[i].d,Math.max(box[i].w,box[i].h),Math.min(box[i].w,box[i].h));

       }

       Arrays.sort(allRotationsArr,comp);
       
       int newLength = 3 * n;
       int msh[] = new int[newLength];
       
       for(int i = 0;i<newLength;i++){
           msh[i] = allRotationsArr[i].h;
       }
       
       
       int max = -1;
       for(int i = 1;i<newLength;i++){
           for(int j = 0;j<i;j++){
                if(allRotationsArr[i].d < allRotationsArr[j].d && allRotationsArr[i].w < allRotationsArr[j].w)
                    msh[i] = Math.max(msh[i],msh[j] + allRotationsArr[i].h);
           }
           
           max = Math.max(max,msh[i]);
       }

       return max;
   }
}


