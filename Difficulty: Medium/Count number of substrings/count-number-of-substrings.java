//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    long substrCount (String S, int K) {
        // The result is the difference between at most K and at most (K-1) distinct characters.
        return func(S, K) - func(S, K-1);
    }
    
    long func(String s, int k)
    {
        int count = 0;
        int len = s.length();
        int l = 0, r = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>(); // To count character frequencies

        while (r < len)
        {
            // Add the current character to the frequency map
            char rightChar = s.charAt(r);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);

            // Shrink the window until we have at most 'k' distinct characters
            while (freqMap.size() > k)
            {
                char leftChar = s.charAt(l);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar); // Remove from map if count becomes 0
                }
                l++; // Move the left pointer to shrink the window
            }

            // Calculate the number of valid substrings in the current window
            count += (r - l + 1);
            r++; // Expand the window by moving the right pointer
        }

        return count;
    }
}
