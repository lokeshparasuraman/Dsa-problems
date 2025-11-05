package Oops.graphs;

import java.util.Arrays;

public class BellmanFordAlgo {
    public int[] shortestPath(int n, int start, int[][] edges) {
        int INF = (int) 1e7;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : edges) {
                int a = edge[0];
                int b = edge[1];
                int weight = edge[2];
                if (dist[a] + weight < dist[b] && dist[a] != INF) {
                    dist[b] = dist[a] + weight;
                }
            }
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int weight = edge[2];
            if (dist[a] + weight < dist[b] && dist[a] != INF) {
                return new int[]{-1};
            }

        }
        for (int i = 0; i < n - 1; i++) {
            if (dist[i] == INF) {
                dist[i] = INF;
            }
        }
        return dist;
    }
}
