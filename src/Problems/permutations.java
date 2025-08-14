package Problems;

import java.util.*;
public class permutations {
    public static void main(String[] args) {
        System.out.println(combinations("","23"));
    }

    static ArrayList<String> permutation(String p,String up){
        if(up.isEmpty()){
            ArrayList<String>list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans=new ArrayList<>();
        char ch=up.charAt(0);
        for (int i = 0; i <=p.length(); i++) {
            String f=p.substring(0,i);
            String s=p.substring(i);
            ans.addAll(permutation(f + ch + s,up.substring(1)));
        }
        return ans;

    }

     static ArrayList<String> combinations(String p, String up) {
        if (up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        int digit = up.charAt(0) -'0';
        for (int i = (digit - 1)*3; i < digit*3; i++) {
            char ch = (char)('a'+i);
            list.addAll(combinations(p + ch,up.substring(1)));
        }
        return list;
    }
}
