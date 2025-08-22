package Trees;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    //Only for Directed Acyclic graph//
    //Time complexity:O(N+E) for all n dfs and O(N) for sorting
    //Space complexity O(3N) for additional space taken by algo
    public static List<Integer> sort(int[][]graph){
        List<Integer> list=new ArrayList<>();
        int m= graph.length;
        Stack<Integer> s=new Stack<>();
        boolean [] visited=new boolean[m];
        for (int i = 0; i < m; i++) {
            if(!visited[i]){
                dfs(i,graph,visited,s);
            }
        }
        while(!s.empty()){
            int num=s.pop();
            list.add(num);

        }
        return list;
    }
    public static void dfs(int curr,int[][]grid,boolean[]visited,Stack<Integer> s){
        visited[curr]=true;
        for (int k:grid[curr]){
            if(!visited[k]){
                dfs(k,grid,visited,s);
            }
        }
        s.push(curr);
    }

    static void main(String[] args) {
        int[][]g={
                {},{3},{3},{},{0,1},{0,2}
        };
        System.out.println(sort(g));
        //Ans:[5,4,2,1,3,0]//
    }
}
