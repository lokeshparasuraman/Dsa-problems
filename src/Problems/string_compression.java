package Problems;

public class string_compression {
    static void main() {
        System.out.println(compress("abc"));
    }

    private static String compress(String str) {
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        int count = 1;
        for (int i = 1; i <= len; i++) {

            if (i == len || str.charAt(i - 1) != str.charAt(i)) {
                sb.append(str.charAt(i - 1)).append(count);
                count = 1;

            } else {
                count++;
            }
        }
        return sb.toString();
    }
}
