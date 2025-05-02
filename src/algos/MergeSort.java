package algos;

import java.util.Arrays;

public class MergeSort {

    static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] larr = new int[n1];
        int[] rarr = new int[n2];

        for(int i = 0; i < n1; i++) {
            larr[i] = arr[i + l];
        }

        for(int i = 0; i < n2; i++) {
            rarr[i] = arr[m + 1 + i];
        }

        int i = 0, j = 0, k = l;

        while(i < n1 && j < n2) {
            if(larr[i] <= rarr[j]) {
                arr[k] = larr[i];
                i++;
            } else {
                arr[k] = rarr[j];
                j++;
            }

            k++;
        }

        while(i < n1) {
            arr[k] = larr[i];
            i++;
            k++;
        }

        while(j < n2) {
            arr[k] = rarr[j];
            j++;
            k++;
        }
    }

    static void sort(int[] arr, int l, int r) {
        if(l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 1};

        sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

}
