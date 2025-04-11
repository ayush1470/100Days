/* LeetCode Problem: (69) Sqrt(x) */

public class Day3Main{
    public static int mySqrt(int x) {
        int Lptr = 1;
        int Rptr = x;
        int mid;
        if(x == 0 || x == 1){  // handles base cases
            return x;
        }
        while(Lptr <= Rptr){  /* we used <= and not < as we want to check the last possible mid-point also
                                when the Lptr = Rptr. */
            mid = Lptr + (Rptr - Lptr)/2;  // mid point
            if(mid == x/mid){  /* we didn't use x*x in order to avoid the overflow of mid*mid
                                 as if x=2^31 then the value of x*x might exceed int value. */
                return mid;
            }else if(mid > x/mid){
                Rptr = mid - 1;
            }else{
                Lptr = mid + 1;
            }
        }
        return Rptr;  /* when Lptr>Rptr the loop breaks and Rptr*Rptr <= x while (Rptr+1)*(Rptr+1) > x
                         {as Lptr>Rptr}. So we return Rptr.
                         Take example of when Rptr=3 and Lptr=4 and dry run the loop. */
    }

    public static void main(String[] args){
        int x = 8;
        System.out.println(mySqrt(x));
    }
}

/* Logic: We are applying Binary Search from 1 to the number x whose Square root we have to find.
          We used the 'mid = x/mid' approach in order to satisfy the constraints like if x=2^31. */