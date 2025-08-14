package Oops.collections;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> l=new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            l.add(i);
        }

        System.out.println(l);
    }
}
