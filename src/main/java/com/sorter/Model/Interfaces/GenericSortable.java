package com.sorter.Model.Interfaces;

import java.util.List;

public interface GenericSortable<T extends Comparable<? super T>>
{
    T[] sort(T[] list);
    List<T> sort(List<T> list);
}
