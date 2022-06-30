package com.atguigu;

/**
 * @author linlin
 * @create 2022-06-09 17:33
 */
public class test9 {
    public static void main(String[] args) {
        int arr[] = {1,2,9,3,3,3,4};
        int arr1[]=new int[arr.length];
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            boolean flag = true;
            for(int j = 0 ; j < arr1.length ; j++){
                if(arr[i] == arr1[j]){
                    flag = false;
                    continue;
                }
            }

            if(flag){
                arr1[count++]=arr[i];
            }
        }
     for(int i : arr1){
         System.out.print(i);
     }

    }
}
