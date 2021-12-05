package com.sorter.Model;

import com.sorter.Model.Interfaces.GenericSortableTree;

import java.util.ArrayList;
import java.util.List;

public class GenericTreeSort<T extends Comparable<? super T>> implements GenericSortableTree<T>
{
    private double executionTime;

    @Override
    public List<T> sort(GenericTree<T> tree)
    {
        List<T> out = new ArrayList<>();
        long startTime = System.nanoTime();
        treeSort(tree.node, out);
        long endTime = System.nanoTime();
        executionTime = (endTime - startTime) / Math.pow(10, 9);
        return out;
    }

    private void treeSort(GenericTree<T>.Node node, List<T> list){
        if(node != null){
            treeSort(node.left, list);
            list.add(node.value);
            treeSort(node.right, list);
        }
    }

    public double getExecutionTime()
    {
        return executionTime;
    }
}
