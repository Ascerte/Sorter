package com.sorter.Model;

import com.sorter.Model.Interfaces.Sortable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort implements Sortable
{
    private double executionTime;

    @Override
    public int[] sort(int[] array)
    {
        int[] out = Arrays.copyOf(array, array.length);
        long startTime = System.nanoTime();
        quickSort(out, 0, out.length - 1);
        long endTime = System.nanoTime();
        executionTime = (endTime - startTime) / Math.pow(10, 9);
        return out;
    }

    static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int p = partition(arr, low, high);
            quickSort(arr, low, p-1);
            quickSort(arr, p+1, high);
        }
    }

    static void swap(int[] arr, int low, int pivot){
        int tmp = arr[low];
        arr[low] = arr[pivot];
        arr[pivot] = tmp;
    }

    static int partition(int[] arr, int low, int high){
        int p = low, j;
        for(j=low+1; j <= high; j++)
            if(arr[j] < arr[low])
                swap(arr, ++p, j);

        swap(arr, low, p);
        return p;
    }

    @Override
    public List<Integer> sort(List<Integer> list)
    {
        List<Integer> out = new ArrayList<>(list);
        long startTime = System.nanoTime();
        quickSort(out, 0, out.size() - 1);
        long endTime = System.nanoTime();
        executionTime = (endTime - startTime) / Math.pow(10, 9);
        return out;
    }

    void quickSort(List<Integer> arr, int low, int high){
        if(low < high){
            int p = partition(arr, low, high);
            quickSort(arr, low, p-1);
            quickSort(arr, p+1, high);
        }
    }

    void swap(List<Integer> list, int low, int pivot)
    {
        int aux = list.get(low);
        list.set(low, list.get(pivot));
        list.set(pivot,aux);
    }

    int partition(List<Integer> arr, int low, int high){
        int p = low, j;
        for(j=low+1; j <= high; j++)
            if(arr.get(j) < arr.get(low))
                swap(arr, ++p, j);

        swap(arr, low, p);
        return p;
    }

    public double getExecutionTime()
    {
        return executionTime;
    }
}
