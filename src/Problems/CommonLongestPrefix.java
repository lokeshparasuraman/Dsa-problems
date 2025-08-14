package Problems;

public class CommonLongestPrefix {
    public static void main(String[] args) {
        String[] qns = {"Helo", "hell", "heat"};
        

    }

    static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String p = strs[0];
        for (String s : strs) {
            while (s.indexOf(p) != 0) {
                p = p.substring(0, p.length() - 1);
            }
        }
        return p;
    }
}
