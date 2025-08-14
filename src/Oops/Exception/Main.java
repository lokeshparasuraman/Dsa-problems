package Oops.Exception;

public class Main {
    public static void main(String[] args) {

        int a=8;
        int b=0;
        try{
            divide(a,b);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static int divide(int a, int b)  throws Exception{
        if(b==0){
            throw new Exception("b is 0");
        }
        return a/b;
    }

}
