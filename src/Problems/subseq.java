package Problems;

import java.util.*;

public class subseq {
    public static void main(String[] args) {
            int[]arr={1,2,2};
            List<List<Integer>>ans=subseqDuplicate(arr);
            for(List<Integer> list:ans){
                System.out.println(list);
            }

    }
    static ArrayList<String> subseq(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch=up.charAt(0);
        ArrayList<String> right=subseq(p,up.substring(1));
        ArrayList<String> left=subseq(p+ch,up.substring(1));

        left.addAll(right);
        return left;
    }

    static List<List<Integer>> subseqDuplicate(int []arr){
        Arrays.sort(arr);
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());
        int s=0;
        int e=0;
        for (int i = 0; i < arr.length; i++) {
            int n=outer.size();
            s=0;
            if(i>0&& arr[i]==arr[i-1]){
                s=e+1;
            }
            e=outer.size();
            for (int j = s; j < n; j++) {
                List<Integer> internal=new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
            
        }
        return outer;

    }
}
