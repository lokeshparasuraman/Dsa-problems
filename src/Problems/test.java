package Problems;

import java.util.Scanner;

public class test {
    static void main() {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++) {
            if((i&1)==0){
                i++;
            }
            if((i&1)==1){
                System.out.print((i<<1)+" ");
            }
        }


    }
public static  int f(int n,int W,int[]weights,int[]values){
        int[]prev=new int[W+1];

        for(int i=weights[0];i<=W;i++){
            prev[i]=values[0];
        }

        for(int ind=1;ind<n;ind++){

            for(int max=W;max>=0;max--){

                int notTake=prev[max];

                int take=0;

                if(weights[ind]<=max){
                    take=values[ind]+prev[max-weights[ind]];
                }
                prev[max]=Math.max(take,notTake);
            }

        }
        return prev[W];
}

}
