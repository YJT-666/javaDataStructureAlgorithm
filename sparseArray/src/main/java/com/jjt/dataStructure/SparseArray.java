package com.jjt.dataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: SparseArray
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2023/12/23 16:45
 * @Version 1.0
 * Description:
 * TODO:
 *      1.实现二维数组 与 稀疏数组 之间转化
 *      2.稀疏的二维数组是指数组当中的大部分值是0或者重复的同一个值，存储到磁盘上会记录很多没有意义的数据
 *        存储效率低，因此将其转化成稀疏数组进行存储可以节约存储空间，提高存储效率
 *      3.稀疏数组记录：
 *          记录元素的二维数组用几行几列，在第几行几列存在什么值
 *      4.稀疏数组格式：
 *          row   col  value
 *       0  3     3    4     // 表示原始二维数组大小为 3 * 3 ，其中有效的数据只有 4 个
 *       1  x1    y1   v1    // 表示原始数组索引(x,y) 处的值为  v
 *       2  x2    y2   v2
 *       3  x3    y3   v3
 *       4  x4    y4   v4
 * TODO:
 *      稀疏数组的应用：存储二维的稀疏数据如【地图】和【棋盘】
 */
public class SparseArray {
    /**
     *  将一个普通二维数组转换成稀疏数组存储
     *  重复的无效值默认是 0
     * @param orgArray  普通二维数组
     * @return the 转换成的稀疏数组
     */
    public double[][] conventToSparseArray(double[][] orgArray) {
        /**
         *  TODO:
         *    1.遍历原始的二维数组，获取有效的数组元素个数 sum
         *    2.根据sum就可以创建稀疏数组 sparseArr double[sum+1][3]
         *          sum+1 是因为稀疏数组的第一行存储的是原始数组的大小、有效元素个数信息
         *    3.将原始数组的行数、列数、有效元素个数存储到sparseArr[0][] 当中
         *    4.遍历原始的二维数组，将第 n 个有效的元素的行坐标、列坐标、值存入sparseArr[n][]
         *    5.返回稀疏数组
         * */
        int sum = 0;
        List<double[]> sparseArr = new ArrayList<>();
        double[] depict = {orgArray.length, orgArray[0].length, 0};
        sparseArr.add(depict);
        for (int i = 0; i < orgArray.length; i++) {
            for (int j = 0; j < orgArray[i].length; j++) {
                if(orgArray[i][j] != 0) {
                    sum++;
                    double[] temp = {i, j, orgArray[i][j]};
                    sparseArr.add(temp);
                }
            }
        }
        sparseArr.get(0)[2] = sum;
        return sparseArr.toArray(new double[1][1]);
    }
    /**
     * 从稀疏数组当中恢复二维数组
     *
     * @param sparseArr 稀疏
     * @return 恢复的二维数组
     */
    public double[][] resumeFromSparseArray(double[][] sparseArr) {

        /**
         *  TODO:
         *      1.从sparseArr的第一行拿到原始数组的行数rows、列数cols、有效值个数num
         *      2.根据rows,cols,num 创建二维空数组orgArray
         *      3.遍历sparseArr，根据每一行描述的原始数组中有效原始的坐标row,col和值value
         *        将orgArray[row][col]位置值设置成value
         * */
        double[][] orgArray = new double[(int)sparseArr[0][0]][(int)sparseArr[0][1]];

        for (int i = 1; i < sparseArr.length; i++) {
            orgArray[(int)sparseArr[i][0]][(int)sparseArr[i][1]] = sparseArr[i][2];
        }

        return orgArray;
    }
}
