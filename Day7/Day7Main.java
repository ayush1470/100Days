/* LeetCode Problem: (455) Assign Cookies */

import java.util.*;

public class Day7Main{
    public static int findContentChildren(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        /* We sorted 'g' and 's' arrays so that: (Bade cookies less greedy bacho pe waste nhi kar rhe hai)
        Why ascending sort is better:
        (I) If you sort both arrays in ascending order, you can give the smallest possible
            cookie to the least greedy child. This way, you save the bigger cookies for
            greedier children who really need them.
        (II) You're trying to satisfy as many children as possible,
             so it's better to satisfy the easy ones first with smaller cookies. */
        int i=0; //
        int j=0; //
        while(i<g.length && j<s.length){  // We are traversing both the arrays at the same time parallelly.
            if(s[j] >= g[i]){  // if size of cookie is big enough for greed of the child
                i++;  // give that cookie to that child
            }
            j++;  /* if s[j]<g[i] (size of cookie is smaller than greed of the child)
                     then assign the next cookie (that is smaller as we sorted) */
        }
        return i;
    }

    public static void main(String[] args){
        int[] g = {1,2,3};  // greed of the children
        int[] s = {2,3};  // Size of the cookie
        System.out.println(findContentChildren(g,s));
    }
}

/* Logic: Sort both arrays, so we can try to give the smallest possible cookie to each child.
          We are using the Two-Pointer Approach here.
          Use two pointers to efficiently iterate over both arrays.
          If a cookie satisfies a child, move to the next child.
          Either way, move to the next cookie. */