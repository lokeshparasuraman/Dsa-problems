package Problems;
import java.util.*;
public class decode_string_pattern {
    static void main() {
        System.out.println(decode("DDD"));
    }
    public static String decode(String str) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<=str.length();i++)
        {
            st.push(i+1);
            if(i==str.length()||str.charAt(i)=='I')
            {
                while(!st.isEmpty())
                {
                    result.append(st.pop());
                }
            }
        }
        return result.toString();
    }
}
