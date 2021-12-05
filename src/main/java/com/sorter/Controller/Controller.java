package com.sorter.Controller;

import com.sorter.Model.GenericBubbleSort;
import com.sorter.Model.GenericQuickSort;
import com.sorter.Model.GenericTree;
import com.sorter.Model.GenericTreeSort;

import java.util.ArrayList;
import java.util.List;

public class Controller
{
    private final GenericBubbleSort<Integer> genericBubbleSortInt;
    private final GenericQuickSort<Integer> genericQuickSort;
    private final GenericTreeSort<Integer> genericTreeSort;

    public Controller()
    {
        genericBubbleSortInt = new GenericBubbleSort<>();
        genericQuickSort = new GenericQuickSort<>();
        genericTreeSort = new GenericTreeSort<>();
    }

    public String printBubbleTime()
    {
        return genericBubbleSortInt.getExecutionTime() + " seconds";
    }

    public String printQuickSortTime()
    {
        return genericQuickSort.getExecutionTime() + " seconds";
    }

    public Integer[] sortBubbleArray(Integer[] arr)
    {
        return genericBubbleSortInt.sort(arr);
    }

    public List<Integer> sortBubbleList(List<Integer> list)
    {
            return genericBubbleSortInt.sort(list);
    }

    public static <T> List<T> toList(T[] arr)
    {
        List<T> list = new ArrayList<>();
        for(T i : arr)
        {
            list.add(i);
        }

        return list;
    }

    public Integer[] sortQuickArray(Integer[] arr)
    {
        return genericQuickSort.sort(arr);
    }

    public List<Integer> sortQuickList(List<Integer> list)
    {
        return genericQuickSort.sort(list);
    }

    public List<Integer> treeSort(Integer[] array)
    {
        GenericTree<Integer> tree = new GenericTree<>(array);
        GenericTreeSort<Integer> sorter = new GenericTreeSort<>();
        return sorter.sort(tree);
    }

    public String printTreeSortTime()
    {
        return genericTreeSort.getExecutionTime() + " seconds";
    }
}
