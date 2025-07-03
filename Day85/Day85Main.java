/* LeetCode Problem: (3304): Find the K-th Character in String Game I */

public class Day85Main{
    public static char kthCharacter(int k) {
        StringBuilder word = new StringBuilder();
        word.append('a');
        char ch = 'a';
        while(word.length() < k){
            int len = word.length();
            for(int i=0; i<word.length(); i++){
                ch = (char)(word.charAt(i) + 1);
                word.append(ch);
                if(word.length() == 2*len){
                    break;
                }
            }
        }
        return word.charAt(k-1);
    }

    public static void main(String[] args) {
        int k = 5;
        System.out.println(kthCharacter(k));
    }
}

/* Key Logic:
- Start with the string "a" and iteratively build the next versions by:
  1. Appending the incremented character (+1 ASCII) of each character in the current string.
  2. After each round, the string approximately doubles in size.
- Continue this process until the string length is at least 'k'.
- Finally, return the (k-1)th character from the built string. */
