/* LeetCode Problem: (1957): Delete Characters to Make Fancy String */

public class Day92Main{
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        if(s == null || s.length() < 3){
            return s;
        }
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
            }else{
                count = 1;
            }
            if(count < 3){
                sb.append(s.charAt(i));
            }
        }
        return s.charAt(0) + sb.toString();
    }
}