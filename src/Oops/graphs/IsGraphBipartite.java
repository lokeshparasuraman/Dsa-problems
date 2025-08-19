package Oops.graphs;
import java.util.*;
class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[]visited= new int[n];
        Arrays.fill(visited,-1);
        for(int i=0;i<n;i++){
            if(visited[i]==-1&&!dfs(i,0,graph,visited)){
                return false;
            }
        }
        return true;
    }
    boolean dfs(int i,int c,int[][]graph,int[]visited){
        visited[i]=c;
        for(int k:graph[i]){
            if(visited[k]==-1){
                if(!dfs(k,1-c,graph,visited)){
                    return false;
                }
            }
            else if(c==visited[k]){
                return false;
            }
        }
        return true;
    }
}