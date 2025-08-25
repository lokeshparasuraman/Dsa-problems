package Oops.graphs;

import java.util.*;

public class Khans_Algorithm {
    public static List<Integer> sort(List<List<Integer>> graph) {
        int n = graph.size();
        int[] indegree = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int k : graph.get(i)) {
                indegree[k] += 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int front = q.poll();
            ans.add(front);
            for (int k : graph.get(front)) {
                indegree[k] -= 1;
                if (indegree[k] == 0) {
                    q.add(k);
                }
            }
        }
        return ans;
    }

}
