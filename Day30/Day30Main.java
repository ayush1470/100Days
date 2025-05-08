/* LeetCode Problem: (821) Shortest Distance to a Character */

import java.util.*;

public class Day30Main{
    public static int[] shortestToChar(String s, char c){
        int n = s.length();
        int[] result = new int[n];

        /* Initialize far Left:- we do this so that c milne se pehle waali
           (left waali) saari values badi ho jae {aisa isliye kar rhe taaki
           minimum jab nikaale left pass aur right paas ka toh badi values
           woh ignore ho jae as hum min function use kar rhe} */
        int prev = -n;

        // Left to Right pass
        for(int i=0; i<n; i++){
            if(s.charAt(i) == c){
                prev = i;
            }
            result[i] = i - prev;
        }

        /* Initialize far Right: same logic as left wala bas as peeche se shuru
           kar rhe toh value of i already badi hai isliye 2*n {same way jab left
           se start kiya toh -n de diya tha value of prev ko as start ki values
           already choti hai aur i-prev karte hi value badi ho jaegi jo hume chaiye
            kyuki abhi tak c mila nhi hai} */
        prev = 2*n;
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) == c){
                prev = i;
            }
            result[i] = Math.min(result[i], prev - i);
        }
        return result;
    }

    public static void main(String[] args){
        String s = "loveleetcode";
        char c = 'e';
        System.out.println(Arrays.toString(shortestToChar(s,c)));
    }
}

/* Key Logic: - First pass (Left to Right):
                For each position, store distance from the nearest 'c' character
                seen so far on the left.

              - Second pass (Right to Left):
                For each position, update distance by comparing with distance
                to the nearest 'c' on the right.

              - Using two passes ensures we get the minimum distance to any
                'c' from both directions in O(N) time. */

