package Oops.generics;

import java.util.Arrays;

public class CustomArrayList<T>{

    private Object[] data;
    private int DEFAULT_SIZE=10;
    private int size=0;

    public CustomArrayList(){
        this.data=new Object[DEFAULT_SIZE];
    }
    public void add(T num){
        if(isFull()){
            resize();
        }
        data[size++]=num;
    }
    private void resize() {
            Object[]temp=new Object[data.length*2];
            for(int i=0;i<data.length;i++){
                temp[i]=data[i];
            }
            data=temp;
    }
    private boolean isFull() {
        return size== data.length;
    }
    private T remove(){
        T removed =(T)(data[--size]);
        return removed;
    }
    @Override
    public String toString(){
        return "CustomArrayList{" +"data="+ Arrays.toString(data) + ", Size=" +size+"}";
    }

    public static void main(String[] args) {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        for (int i = 1; i <=11; i++) {
            list.add(i);
        }
        System.out.println(list.remove());

        System.out.println(list);


    }
}
