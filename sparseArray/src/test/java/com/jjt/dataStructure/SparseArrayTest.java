package com.jjt.dataStructure;

import com.jjt.util.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.jjt.dataStructure.SparseArray;

/**
 * ClassName: SparseArrayTest
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2023/12/23 17:24
 * @Version 1.0
 * Description:
 */
public class SparseArrayTest {

    private SparseArray sparseArray = new SparseArray();

    @Test
    public void testConventToSparseArray() {
        double[][] orgArr = {
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };
        double[][] sparseArr= {
                {4, 4, 4},
                {0, 0, 1},
                {1, 1, 1},
                {2, 2, 1},
                {3, 3, 1},
        };

        double[][] toSparseArray = sparseArray.conventToSparseArray(orgArr);

        System.out.println("orgArray" + ": ");
        Utils.print2Array(orgArr);

        System.out.println("toSparseArray" + ": ");
        Utils.print2Array(toSparseArray);

        Assertions.assertArrayEquals(toSparseArray, sparseArr);

        System.out.println("---------------------------------------------------");

        double[][] toOrgArr = sparseArray.resumeFromSparseArray(sparseArr);

        System.out.println("sparseArr" + ": ");
        Utils.print2Array(sparseArr);

        System.out.println("toOrgArr" + ": ");
        Utils.print2Array(toOrgArr);

        Assertions.assertArrayEquals(toOrgArr, orgArr);

    }

    @Test
    public void test02() {
        double[][] sparseArr= {
                {4, 4, 4},
                {0, 0, 1},
                {1, 1, 1},
                {2, 2, 1},
                {3, 3, 1},
        };

        String path="aaa.data";
        Utils.sparseArrayToFile(path, sparseArr);

        double[][] doubles = Utils.readSparseArrayFromFile(path);

        Utils.print2Array(doubles);

    }
}
