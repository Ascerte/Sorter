package com.sorter.Model.Interfaces;

import com.sorter.Model.GenericTree;

import java.util.List;

public interface GenericSortableTree<T extends Comparable<? super T>>
{
    List<T> sort(GenericTree<T> tree);
}
