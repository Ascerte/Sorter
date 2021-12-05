import com.sorter.Model.GenericQuickSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GenericQuickTest
{
    @Test
    public void genericQuickSortIntegerTest()
    {
        Integer[] arrayTwo = {9,8,6,3,2};
        GenericQuickSort<Integer> bs = new GenericQuickSort<>();
        Integer[] out = bs.sort(arrayTwo);
        System.out.println(Arrays.toString(out));
        assert(Arrays.toString(out).equals("[2, 3, 6, 8, 9]"));
    }

    @Test
    public void genericQuickSortStringTest()
    {
        String[] arrayTwo = {"pp", "bb", "aa", "dd"};
        GenericQuickSort<String> bs = new GenericQuickSort<>();
        String[] out = bs.sort(arrayTwo);
        System.out.println(Arrays.toString(out));
        assert(Arrays.toString(out).equals("[aa, bb, dd, pp]"));
    }

    @Test
    public void genericQuickSortStringTestList()
    {
        List<String> list = Arrays.asList("pp", "bb", "aa", "dd");
        GenericQuickSort<String> bs = new GenericQuickSort<>();
        List<String> out = bs.sort(list);
        System.out.println(out.toString());
        assert(out.toString().equals("[aa, bb, dd, pp]"));
    }

    @Test
    public void genericQuickSortTestList()
    {
        List<Integer> list = Arrays.asList(9,8,6,3,2);
        GenericQuickSort<Integer> bs = new GenericQuickSort<>();
        List<Integer> out = bs.sort(list);
        System.out.println(out.toString());
        assert(out.toString().equals("[2, 3, 6, 8, 9]"));
    }

}
