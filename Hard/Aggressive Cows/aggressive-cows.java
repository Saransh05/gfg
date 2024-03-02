//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        int l=0;
        int b=stalls.length;
        Arrays.sort(stalls);
        int u=stalls[b-1]-stalls[0];
        while(l<=u)
        {
            int mid=(l+u)/2;
            boolean a=(WeCanPlace(stalls,mid,k));
            if(a==true)
            {
                l=mid+1;
            }
            else{
                u=mid-1;
            }
        }
        return u;
    }
    public static boolean WeCanPlace(int[] stalls ,int mid,int k)
    {
        int n=stalls.length;
        int last=stalls[0];
        int c=1;
        for(int i=0;i<n;i++)
        {
            if(stalls[i]-last>=mid)
            {
                c++;
                last=stalls[i];
            }
        }
        if(c>=k)
        {
            return true;
        }
        else{
            return false;
        }
    }
}