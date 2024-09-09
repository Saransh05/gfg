//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> a = new ArrayList<>();

            for (String s : inputArray) {
                a.add(Integer.parseInt(s));
            }

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        // code here
        int c0=0,c1=0,c2=0;
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i)==0) c0++;
            if(arr.get(i)==1) c1++;
            if(arr.get(i)==2) c2++;
        }
        for(int i=0;i<c0;i++)
        {
            arr.set(i,0);
        }
        for(int i=c0;i<c1+c0;i++)
        {
            arr.set(i,1);
        }
        for(int i=c1+c0;i<c0+c1+c2;i++)
        {
            arr.set(i,2);
        }
    }
}