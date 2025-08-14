package Oops.graphs;
import java.util.*;
class GraphIOUsingAdjacencyList {
    static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
    public static List<List<Integer>> adjList() {
        List<List<Integer>> graph = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        Pair<Integer, Integer>[] edges = new Pair[e];
        for (int i = 0; i < e; i++) {
            int key = s.nextInt();
            int value = s.nextInt();

            edges[i] = new Pair<>(key, value);
        }
        for (Pair<Integer, Integer> p : edges) {
            graph.get(p.getKey()).add(p.getValue());
            graph.get(p.getValue()).add(p.getKey());
        }
        s.close();
        return graph;
    }
    public static void display(List<List<Integer>> graph) {
        for (int i = 1; i <= graph.size() - 1; i++) {
            System.out.print(i);
            for (Integer in : graph.get(i)) {
                System.out.print(" -> " + in);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        display(adjList());
    }
}
