package Trees;
import java.util.*;
import static java.util.Collections.sort;
public class SafeNodes {
    public static List<Integer> safeNodes(int[][]grid){
        int m= grid.length;;
        int n=grid[0].length;
        boolean[]visited=new boolean[m];
        boolean []path=new boolean[m];
        List<Integer> ans=new ArrayList<>();
        for (int i = 0; i <m; i++) {
            if(!visited[i]){
                dfs(i,grid,path,visited,ans);
            }
        }
        Collections.sort(ans);
        return ans;
    }
    public static boolean dfs(int curr,int[][]grid,boolean[]path,boolean[]visited,List<Integer> ans){
        visited[curr]=true;
        path[curr]=true;
        for (int k:grid[curr]) {
            if(!visited[k]){
                if(dfs(k,grid,path,visited,ans))
                    return true;

            } else if (path[k]) {
                return true;
            }
        }
        path[curr]=false;
        ans.add(curr);
        return false;
    }

    static void main(String[] args) {
        int[][]g={
                {1,2},{2,3,6},{5},{0},{5},{},{},{3}
        };
        System.out.println(safeNodes(g));
    }
}
