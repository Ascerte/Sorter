import com.sorter.Model.BubbleSort;
import com.sorter.Model.QuickSort;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SorterTest
{
    private static int[] largeArray;
    static List<Integer> largeList;

    @BeforeAll
    static void setup()
    {
        Random r = new Random();
        largeArray = r.ints(50000, 10,50000).toArray();
        largeList = new ArrayList<>();
        for(int value : largeArray)
        {
            largeList.add(value);
        }
    }

    @Test
    public void bubbleSortArrayTest()
    {
        int [] arrayTwo = {9,8,6,3,2};
        BubbleSort bs = new BubbleSort();
        int [] out = bs.sort(arrayTwo);
        assert(Arrays.toString(out).equals("[2, 3, 6, 8, 9]"));
    }

    @Test
    public void bubbleSortLargeArrayTest()
    {
        BubbleSort bs = new BubbleSort();
        int [] out = bs.sort(largeArray);
        System.out.println(bs.getExecutionTime() + " seconds");
    }

    @Test
    public void bubbleSortListTest()
    {
        List<Integer> list = Arrays.asList(9,8,6,3,2);
        BubbleSort bs = new BubbleSort();
        List<Integer> out = bs.sort(list);
        assert(out.toString().equals("[2, 3, 6, 8, 9]"));
    }

    @Test
    public void bubbleSortLargeListTest()
    {
        BubbleSort bs = new BubbleSort();
        List<Integer> out = bs.sort(largeList);
        System.out.println(bs.getExecutionTime() + " seconds");
    }

    @Test
    public void quickSortArrayTest()
    {
        QuickSort qs = new QuickSort();
        int[] arr = {9,8,6,3,2};
        int[] out = qs.sort(arr);
        assert(Arrays.toString(out).equals("[2, 3, 6, 8, 9]"));
    }

    @Test
    public void quickSortLargeArrayTest()
    {
        QuickSort qs = new QuickSort();
        int[] out = qs.sort(largeArray);
        int[] array = Arrays.copyOf(largeArray, largeArray.length);
        Arrays.sort(array);
        System.out.println(qs.getExecutionTime() + " seconds");
        assert(Arrays.toString(out).equals(Arrays.toString(array)));
    }
}
