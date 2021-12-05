package com.sorter.Model;

import java.util.List;

public class GenericTree<T extends Comparable<? super T>>
{
    Node node;

    public GenericTree(T[] array)
    {
        node = new Node(array[0]);
        createTree(array);
    }

    public GenericTree(List<T> list)
    {
        node = new Node(list.get(0));
        createTree(list);
    }

    private void createTree(T[] array)
    {
        for(T val : array)
        {
            insert(node, val);
        }
    }

    private void createTree(List<T> list)
    {
        for(T val : list)
        {
            insert(node, val);
        }
    }

    public Node insert(Node node, T value){
        if(node == null)
        {
            return new Node(value);
        }

        if(value.compareTo(node.value) < 0)
        {
            node.left = insert(node.left, value);
        }
        else if(value.compareTo(node.value) > 0)
        {
            node.right = insert(node.right, value);
        }
        return node;
    }

    class Node{
        T value;
        Node left;
        Node right;
        Node(T value){
            this.value = value;
            left = null;
            right = null;
        }
    }
}
