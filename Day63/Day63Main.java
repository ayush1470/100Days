public class Day63Main{
    public static boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    private static String build(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                result.append(c);
            } else if (result.length() > 0) {
                result.deleteCharAt(result.length() - 1);
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(backspaceCompare(s,t));
    }
}
