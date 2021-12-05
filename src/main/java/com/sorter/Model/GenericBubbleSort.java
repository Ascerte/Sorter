package com.sorter.Model;

import com.sorter.Model.Interfaces.GenericSortable;

import java.util.ArrayList;
import java.util.List;

public class GenericBubbleSort<T extends Comparable<? super T>> implements GenericSortable<T>
{
    double executionTime;

    @Override
    public T[] sort(T[] list)
    {
        long startTime = System.nanoTime();
        bubbleSort(list);
        long endTime = System.nanoTime();
        executionTime = (endTime - startTime) / Math.pow(10, 9);
        return list;
    }

    @Override
    public List<T> sort(List<T> list)
    {
        if(list.isEmpty())
        {
            System.out.println("Invalid list");
            return null;
        }
        else
        {
            List<T> output = new ArrayList<>(list);
            long startTime = System.nanoTime();
            bubbleSortList(output);
            long endTime = System.nanoTime();
            executionTime = (endTime - startTime) / Math.pow(10, 9);
            return output;
        }
    }

    private void bubbleSortList(List<T> list)
    {
        boolean isSwapped = true;

        while(isSwapped)
        {
            isSwapped = false;
            for(int i  = 0; i < list.size() - 1; i++)
            {
                if(list.get(i).compareTo(list.get(i + 1)) > 0 )
                {
                    T aux = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1,aux);
                    isSwapped = true;
                }


            }
            if(!isSwapped)
                break;
        }
    }

    private void bubbleSort(T[] array)
    {
        boolean isSwapped = true;

        while (isSwapped)
        {
            isSwapped = false;
            for (int i = 0; i < array.length - 1; i++)
            {
                if (array[i].compareTo(array[i + 1]) > 0)
                {
                    {
                        swapElements(i, array);
                        isSwapped = true;
                    }
                }

            }
            if (!isSwapped)
                break;
        }
    }

    private void swapElements(int index, T[] arr)
    {
        T temp = arr[index];
        arr[index] = arr[index+1];
        arr[index+1] = temp;
    }

    public double getExecutionTime()
    {
        return executionTime;
    }
}
