package com.sort.quick_sort;

public class QuickSort {

    public static void quickSort(int[] data, int size) {
        partitonSort(data, 0, size - 1);
    }

    public static void partitonSort(int[] data, int left, int right) {
        if (data.length <= 0) {
            return ;
        }

        if (right <= left) return;

        int pivot = partitionOP(data, left, right);
        if (pivot - 1 > left) {
            partitonSort(data, left, pivot - 1);
        }
        if (pivot + 1 < right)
        partitonSort(data, pivot+1, right);
    }

    private static int partition(int[] data, int left, int right) {
        int pivot = data[right];
        int begin = left;
        int end = right - 1;

        while (begin < end) {
            while ( begin < end && data[begin] <= pivot) {
                begin++;
            }

            while ( begin < end && data[end] >= pivot) {
                end--;
            }

            if ( begin < end) {
                int tmp = data[begin];
                data[begin] = data[end];
                data[end] = tmp;
            }
        }

        if (pivot <= data[begin]) {
            int tmp = data[begin];
            data[begin] = data[right];
            data[right] = tmp;
            return begin;
        } else
            return right;
    }

    private static int partition2(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for(int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        System.out.println("i=" + i);
        return i;
    }

    public static void main(String[] args) {
        int a[] = {1,10,13,12,6};
        quickSort(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static int partitionOP(int[] data, int begin, int end) {
        int pivot = data[end];
        int prev = begin;
        for (int cur = begin; cur < end; cur++) {
            if (data[cur] < pivot) {
                if (cur == prev) {
                    prev++;
                } else {
                    int tmp = data[prev];
                    data[prev++] = data[cur];
                    data[cur] = tmp;
                }
            }
        }

        int tmp = data[prev];
        data[prev] = data[end];
        data[end] = tmp;
        return prev;
    }
}
