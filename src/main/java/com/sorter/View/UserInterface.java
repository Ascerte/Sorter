package com.sorter.View;

import com.sorter.Controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class UserInterface
{
    Controller controller;
    static Scanner scanner = new Scanner(System.in);
    public static final int SORT_TYPE_BUBBLE = 1, SORT_TYPE_QUICK = 2;
    public static final int SORT_TYPE_TREE = 3, SORT_TYPE_ALL = 4;
    public static final int STRUCT_TYPE_LIST = 1, STRUCT_TYPE_ARRAY = 2;
    public static final int STRUCT_TYPE_ALL = 3;
    private static final Logger logger = LogManager.getLogger(UserInterface.class);
    public UserInterface()
    {
        controller = new Controller();
    }

    public void start()
    {
        logger.info("Program started");
        int max = readMaxLength();
        logger.info("Array length: " + max);
        Integer[] input = createArray(max);
        printArray(input, "Input Array");
        logger.info("Input Array: " + Arrays.toString(input));
        int algorithmType = parseAlgorithmType();
        int structureType = parseStructureType();
        switch(algorithmType)
        {
            case SORT_TYPE_BUBBLE:
                switch (structureType)
                {
                    case STRUCT_TYPE_LIST -> {
                        printBubbleSortList(input);
                    }
                    case STRUCT_TYPE_ARRAY -> {
                        printBubbleSortArray(input);
                    }
                    case STRUCT_TYPE_ALL -> {
                        System.out.println("Array List: ");
                        printBubbleSortList(input);
                        System.out.println("Array: ");
                        printBubbleSortArray(input);
                        printCollectionsResult(input);
                    }
                }
                break;
            case SORT_TYPE_QUICK:
                switch (structureType)
                {
                    case STRUCT_TYPE_LIST -> printQuickSortList(input);
                    case STRUCT_TYPE_ARRAY -> printQuickSortArray(input);
                    case STRUCT_TYPE_ALL -> {
                        System.out.println("Array List: ");
                        printQuickSortList(input);
                        System.out.println("Array: ");
                        printQuickSortArray(input);
                        printCollectionsResult(input);
                    }
                }
                break;
            case SORT_TYPE_TREE:
                printTreeSort(input);
                printCollectionsResult(input);
                break;
            case SORT_TYPE_ALL:
                switch (structureType)
                {
                    case STRUCT_TYPE_LIST -> {
                        printBubbleSortList(input);
                        printQuickSortList(input);
                        printCollectionsResult(input);
                    }
                    case STRUCT_TYPE_ARRAY -> {
                        printBubbleSortArray(input);
                        printQuickSortArray(input);
                        printCollectionsResult(input);
                    }
                    case STRUCT_TYPE_ALL -> {
                        System.out.println("Array List:");
                        printBubbleSortList(input);
                        printQuickSortList(input);
                        System.out.println("Array: ");
                        printBubbleSortArray(input);
                        printQuickSortArray(input);
                        System.out.println("Binary Search Tree: ");
                        printTreeSort(input);
                        printCollectionsResult(input);
                    }
                }
                break;
        }
        logger.info("End of program");
    }

    private void printBubbleSortArray(Integer[] input)
    {
        controller.sortBubbleArray(input);
        System.out.println("BubbleSort: " + controller.printBubbleTime());
    }

    private void printBubbleSortList(Integer[] input)
    {
        List<Integer> list = Controller.toList(input);
        controller.sortBubbleList(list);
        System.out.println("BubbleSort: " + controller.printBubbleTime());
    }

    private void printQuickSortArray(Integer[] input)
    {
        Integer[] array = controller.sortQuickArray(input);
        System.out.println("Quick Sort: " + controller.printQuickSortTime());
    }

    private void printQuickSortList(Integer[] input)
    {
        List<Integer> list = Controller.toList(input);
        list = controller.sortQuickList(list);
        System.out.println("QuickSort: " + controller.printQuickSortTime());
    }

    private int readMaxLength()
    {
        int maxLength = 0;
        String input = null;
        System.out.print("Input array length: ");
        while(true)
        {
            try
            {
                input = scanner.nextLine();
                maxLength = Integer.parseInt(input);
            }
            catch(Exception e)
            {
                logger.error("Erroneous value for array size: " + input);
                System.out.println("Invalid number");
                System.out.print(">");
                continue;
            }
            if(maxLength > 0)
                return maxLength;
            else
            {
                System.out.println("Invalid number");
                logger.error("Erroneous value for array size: " + input);
            }
            System.out.print(">");
        }
    }

    private Integer[] createArray(int length)
    {
        Integer[] array;
        Random r = new Random();
        array = r.ints(length, 10,50000).boxed().toArray(Integer[]::new);
        return array;
    }

    private int parseAlgorithmType()
    {
        int selection = 0;
        String input = null;
        System.out.print("Select 1 for BubbleSort, 2 for QuickSort, 3 for TreeSort, 4 for both: ");
        while(true)
        {
            try
            {
                input = scanner.nextLine();
                selection = Integer.parseInt(input);
            }
            catch(Exception e)
            {
                logger.error("Erroneous value for sorter type: " + input);
                System.out.println("Invalid number");
                System.out.print(">");
                continue;
            }
            if(selection > 0 && selection < 5)
                return selection;
            else
            {
                logger.error("Erroneous value for sorter type: " + selection);
                System.out.println("Invalid number");
            }
            System.out.print(">");
        }
    }

    private int parseStructureType()
    {
        int selection = 0;
        String input = null;
        System.out.print("Select 1 for ArrayList, 2 for Array, 3 for both: ");
        while(true)
        {
            try
            {
                input = scanner.nextLine();
                selection = Integer.parseInt(input);
            }
            catch(Exception e)
            {
                logger.error("Erroneous value for structure type: " + input);
                System.out.println("Invalid number");
                System.out.print(">");
                continue;
            }
            if(selection > 0 && selection < 4)
                return selection;
            else
            {
                logger.error("Erroneous value for structure type: " + selection);
                System.out.println("Invalid number");
            }            System.out.print(">");
        }
    }

    private <T>void printArray(T[] array, String message)
    {
        System.out.println(message + ": " + Arrays.toString(array));
    }

    private void printList(List<Integer> list, String message)
    {
        System.out.println(message + ": " + list.toString());
    }

    private void printCollectionsResult(Integer[] arr)
    {
        List<Integer> list = Controller.toList(arr);
        long startTime = System.nanoTime();
        Collections.sort(list);
        long endTime = System.nanoTime();
        double elapsed = (endTime - startTime) / Math.pow(10, 9);
        System.out.println("Collections.sort: " + elapsed + " seconds");
        printList(list, "Sorted Array");
        logger.info("Sorted Array: " + list);
    }

    private void printTreeSort(Integer[] array)
    {
        List<Integer> out = controller.treeSort(array);
        System.out.println("Tree Sort: " + controller.printTreeSortTime());
    }
}
