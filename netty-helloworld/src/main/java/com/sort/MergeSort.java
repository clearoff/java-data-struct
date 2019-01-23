package com.sort;


/**
 * 归并排序
 */
public class MergeSort {

    public static void mergeSort(int[] data, int size) {
        if (size <= 0) {
            throw new RuntimeException("数组大小不够");
        }
        int[] tmp = new int[size];
        mergeSort(data, tmp, 0, size - 1);
    }

    public static void mergeSort(int[] data, int[] tmp,int begin, int end) {
        if (end <= begin)
            return ;

        int mid = begin + ((end - begin) >> 1);
        int begin1 = begin, end1 = mid;
        int begin2 = mid + 1, end2 = end;

        if (begin1 < end1) {
            mergeSort(data, tmp, begin, mid);
        }

        if (begin2 < end2) {
            mergeSort(data, tmp, mid + 1, end);
        }


        int index = begin;

        while (begin1<=end1 && begin2<=end2)
        {
            if (data[begin1] < data[begin2])
                tmp[index++] = data[begin1++];
            else
                tmp[index++] = data[begin2++];   //向tmp数组中进行合并
        }

        while (begin1 <= end1) {
            tmp[index++] = data[begin1++];
        }

        while (begin2 <= end2) {
            tmp[index++] = data[begin2++];
        }

        for (int i = begin; i <= end; i++) {
            data[i] = tmp[i];
        }
    }


    public static void main(String[] args) {
        int a[] = {10,9,8,7,6,5,4,3,2,1};
        mergeSort(a, 10);
        for (int i = 0; i < 10; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
