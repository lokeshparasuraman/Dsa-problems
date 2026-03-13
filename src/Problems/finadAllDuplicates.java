package Problems;

import java.util.*;
class finadAllDuplicates {
    static void main() {
        int []arr={9,9,9,8,8,8,8,7,6,5,4,3,2};

        System.out.println(findDuplicates(arr));
    }
    public static List<Integer> findDuplicates(int[] arr) {
        int i = 0;
        while (i<arr.length){
            int correct=arr[i]-1;
            if(arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }
            else{
                i++;
            }
        }
        List <Integer> ans=new ArrayList<>();
        for(int j=0;j<arr.length;j++){
            if(arr[j]!=j+1)
                ans.add(arr[j]);    
        }
        return ans;
        }

static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
    }
        
    

    
