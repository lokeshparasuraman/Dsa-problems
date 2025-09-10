package Oops.graphs;

import java.util.*;

class Pairs {
        int vertex, weight;
    
        Pairs(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
    }
}
public class DijkstraAlgo {
    static int[] dijkstra(int n, ArrayList<ArrayList<Pairs>> adj, int start) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Pairs> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        pq.add(new Pairs(start, 0));
    
        while (!pq.isEmpty()) {
            Pairs x = pq.poll();
            int cur = x.vertex;
    
            for (Pairs k : adj.get(cur)) {
                int neighbour = k.vertex;
                int weight = k.weight;
                if (dist[cur] + weight < dist[neighbour]) {
                    dist[neighbour] = dist[cur] + weight;
                    pq.add(new Pairs(neighbour, dist[neighbour]));
                }
            }
        }
        return dist;
    }


     static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<ArrayList<Pairs>> adj = new ArrayList<ArrayList<Pairs>>();
        for (int i = 0; i <n; i++) {
            adj.add(new ArrayList<Pairs>());
        }
    
        for (int i = 0; i <m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            adj.get(u).add(new Pairs(v, w));
            adj.get(v).add(new Pairs(u, w));
        }
    
        int start = scanner.nextInt();
        int[] dist = dijkstra(n, adj, start);
    
        for (int d : dist) {
            System.out.print(d + " ");
        }
        System.out.println();
    }
}