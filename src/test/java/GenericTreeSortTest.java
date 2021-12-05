import com.sorter.Model.GenericTree;
import com.sorter.Model.GenericTreeSort;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GenericTreeSortTest
{
    @Test
    public void intTreeTest()
    {
        Integer[] array = {9,8,7,6,5,4,3,2,2,1,0};
        GenericTree<Integer> tree = new GenericTree<>(array);
        GenericTreeSort<Integer> sorter = new GenericTreeSort<>();
        List<Integer> out = sorter.sort(tree);
        assert(out.toString().equals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]"));
    }
}
