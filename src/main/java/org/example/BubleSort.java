package org.example;

public class BubleSort {

    public static void main(String[]args)
    {
        int[] arr = {4,5,2,3};

        for(int i=0;i<arr.length; ++i)
        {
            for (int j=i;j<arr.length;++j)
            {
                if(arr[i]>arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
