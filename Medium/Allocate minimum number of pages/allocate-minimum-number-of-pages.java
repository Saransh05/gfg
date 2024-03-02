//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        int low=A[N-1];
        int sum=0;
        for(int i=0;i<N;i++)
        {
            sum=sum+A[i];
        }
        int high=sum;
        if(M>N)
        {
            return -1;
        }
        else{
        while(low<=high)
        {
            int mid=(low+high)/2;
            int stu=calculate(A,mid);
            if(stu<=M)
            {
             high=mid-1;   
            }
            else{
                low=mid+1;
            }
        }
        return low;
        }
    }
    public static int calculate(int[] A,int pages)
    {
        int stu=1,pagesStudent=0;
        for(int i=0;i<A.length;i++)
        {
            if(pagesStudent+A[i]<=pages)
            {
                pagesStudent+=A[i];
            }
            else{
                stu++;
                pagesStudent=A[i];
            }
        }
        return stu;
    }
}