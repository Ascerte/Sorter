package com.sorter.Model;


import com.sorter.Model.Interfaces.Sortable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort implements Sortable
{
    private double executionTime;

    private void bubbleSortArray(int[] array)
    {
        boolean isSwapped = true;

        while(isSwapped)
        {
            isSwapped = false;
            for(int i  = 0; i < array.length - 1; i++)
            {
                if(array[i] > array[i + 1])
                {
                    int aux = array[i];
                    array[i] = array[i+1];
                    array[i+1] = aux;
                    isSwapped = true;
                }
            }
            if(!isSwapped)
                break;
        }
    }

    private void bubbleSortList(List<Integer> list)
    {
        boolean isSwapped = true;

        while(isSwapped)
        {
            isSwapped = false;
            for(int i  = 0; i < list.size() - 1; i++)
            {
                if(list.get(i) > list.get(i + 1))
                {
                    int aux = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1,aux);
                    isSwapped = true;
                }


            }
            if(!isSwapped)
                break;
        }
    }

    @Override
    public String toString()
    {
        return "BubbleSort{" +
                "executionTime=" + executionTime +
                '}';
    }

    public double getExecutionTime()
    {
        return executionTime;
    }

    @Override
    public int[] sort(int[] array)
    {
        if (array == null || array.length == 0)
        {
            System.out.println("Invalid array");
            return null;
        }
        else
        {
            int[] output = Arrays.copyOf(array, array.length);
            long startTime = System.nanoTime();
            bubbleSortArray(output);
            long endTime = System.nanoTime();
            executionTime = (endTime - startTime) / Math.pow(10, 9);
            return output;
        }
    }

    @Override
    public List<Integer> sort(List<Integer> list)
    {
        if(list.isEmpty())
        {
            System.out.println("Invalid list");
            return null;
        }
        else
        {
            List<Integer> output = new ArrayList<>(list);
            long startTime = System.nanoTime();
            bubbleSortList(output);
            long endTime = System.nanoTime();
            executionTime = (endTime - startTime) / Math.pow(10, 9);
            return output;
        }
    }
}
