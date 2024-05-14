import com.jjt.dataStructure.Heap;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


/**
 * ClassName: HeapTest
 * Package: PACKAGE_NAME
 *
 * @Author jjt
 * @Create 2024/5/14 11:36
 * @Version 1.0
 * Description:
 */
public class HeapTest {




    @Test
    public void test01() {
        int[] arr = {2, 15, 169, -110, 7, 13, 1, 5};
        Heap heap = new Heap(arr);
        heap.sort();
        System.out.println(Arrays.toString(arr));
    }
}
