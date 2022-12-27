package org.example.faang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingArray {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(3);
        array.add(7);
        array.add(0);
        array.add(22);
        array.add(11);
        Collections.sort(array);
        int[] sortedArray = array.stream().mapToInt(i -> i).toArray();
        int found = binarySearch(sortedArray, 0, sortedArray.length - 1, 11);
        System.out.println(found);
    }


    static int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }

}
