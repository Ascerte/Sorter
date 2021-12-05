package com.sorter.Model;

import com.sorter.Model.Interfaces.GenericSortable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericQuickSort<T extends Comparable<? super T>> implements GenericSortable<T>
{

    private double executionTime;

    @Override
    public T[] sort(T[] array)
    {
        T[] out = Arrays.copyOf(array, array.length);
        long startTime = System.nanoTime();
        quickSort(out, 0, out.length - 1);
        long endTime = System.nanoTime();
        executionTime = (endTime - startTime) / Math.pow(10, 9);
        return out;
    }

    void quickSort(T[] arr, int low, int high){
        if(low < high){
            int p = partition(arr, low, high);
            quickSort(arr, low, p-1);
            quickSort(arr, p+1, high);
        }
    }

    void swap(T[] arr, int low, int pivot){
        T tmp = arr[low];
        arr[low] = arr[pivot];
        arr[pivot] = tmp;
    }

    int partition(T[] arr, int low, int high){
        int p = low, j;
        for(j=low+1; j <= high; j++)
            if (arr[j].compareTo(arr[low]) < 0)
                swap(arr, ++p, j);

        swap(arr, low, p);
        return p;
    }

    @Override
    public List<T> sort(List<T> list)
    {
        List<T> out = new ArrayList<>(list);
        long startTime = System.nanoTime();
        quickSort(out, 0, out.size() - 1);
        long endTime = System.nanoTime();
        executionTime = (endTime - startTime) / Math.pow(10, 9);
        return out;
    }

    void quickSort(List<T> arr, int low, int high){
        if(low < high){
            int p = partition(arr, low, high);
            quickSort(arr, low, p-1);
            quickSort(arr, p+1, high);
        }
    }

    void swap(List<T> list, int low, int pivot)
    {
        T aux = list.get(low);
        list.set(low, list.get(pivot));
        list.set(pivot,aux);
    }

    int partition(List<T> arr, int low, int high){
        int p = low, j;
        for(j=low+1; j <= high; j++)
            if(arr.get(j).compareTo(arr.get(low)) < 0 )
                swap(arr, ++p, j);

        swap(arr, low, p);
        return p;
    }

    public double getExecutionTime()
    {
        return executionTime;
    }
}
