package com.sorter.Model.Interfaces;

import java.util.List;

public interface Sortable
{
//    void sort(int StructureType);
    int[] sort(int[] array);
    List<Integer> sort(List<Integer> list);
}
