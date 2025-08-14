package Problems;

public class pattern {
    public static void main(String[] args) {
            pattern2(4);

    }
    static void pattern2(int rows){
            for (int row = 0; row < rows; row++) {

                for (char ch='A';ch<'A'+row;ch++){
                    System.out.print(ch+" ");
                }
                for (int j = 0; j < rows - row - 1; j++) {
                    System.out.print("  ");
                }
                System.out.println();
            }
        }

    static void pattern1(int n){
        int on=n;
        n=2*n;
        for(int row=1;row<=n-1;row++)
        {
            for(int col=1;col<=n-1;col++){
                int atEveryIndex= on-Math.min(Math.min(row-1,col-1),Math.min(n-row-1,n-col-1));
                System.out.print(atEveryIndex +" ");
            }
            System.out.println();
        }
    }
}
