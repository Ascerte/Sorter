import com.sorter.Model.GenericBubbleSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GenericBubbleTest
{
    @Test
    public void genericBubbleTest()
    {
        Integer [] arrayTwo = {9,8,6,3,2};
        GenericBubbleSort<Integer> bs = new GenericBubbleSort<>();
        Integer[] out = bs.sort(arrayTwo);
        assert(Arrays.toString(out).equals("[2, 3, 6, 8, 9]"));
    }

    @Test
    public void genericBubbleTestString()
    {
        String [] arrayTwo = {"pp", "bb", "aa", "dd"};
        GenericBubbleSort<String> bs = new GenericBubbleSort<>();
        String[] out = bs.sort(arrayTwo);
        assert(Arrays.toString(out).equals("[aa, bb, dd, pp]"));
    }

    @Test
    public void genericBubbleTestList()
    {
        List<Integer> list = Arrays.asList(9,8,6,3,2);
        GenericBubbleSort<Integer> bs = new GenericBubbleSort<>();
        List<Integer> out = bs.sort(list);
        assert(out.toString().equals("[2, 3, 6, 8, 9]"));
    }

    @Test
    public void genericBubbleTestStringList()
    {
        List<String> list = Arrays.asList("pp", "bb", "aa", "dd");
        GenericBubbleSort<String> bs = new GenericBubbleSort<>();
        List<String> out = bs.sort(list);
        assert(out.toString().equals("[aa, bb, dd, pp]"));
    }
}
