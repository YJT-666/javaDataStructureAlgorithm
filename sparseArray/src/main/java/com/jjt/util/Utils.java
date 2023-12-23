package com.jjt.util;

import java.io.*;

/**
 * ClassName: Utils
 * Package: IntelliJ IDEA
 *                         工具类
 * @Author jjt
 * @Create 2023/12/23 18:51
 * @Version 1.0
 * Description:
 */
public class Utils {
    /**
     * 工具函数，格式化打印二维数组
     */
    public static void print2Array(double[][] array) {
        System.out.println("[");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(String.format("%f\t", array[i][j]));
            }
            System.out.println();
        }
        System.out.println("]");
    }

    /**
     * 将稀疏数组保存到文件
     * @param path        文件路径
     * @param sparseArray 稀疏数组
     */
    public static void sparseArrayToFile(String path, double[][] sparseArray) {

        /**
         *  TODO:
         *      1.创建序列化流对象
         *      2.将对象写出到流对象当中
         *      3.释放资源
         * */
        ObjectOutputStream objectOutputStream=null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(sparseArray);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 从文件当中读取稀疏数组
     * @param path  文件路径
     * @return double[][]   读取的稀疏数组结果
     */
    public static double[][] readSparseArrayFromFile(String path) {
        /**
         *     TODO:
         *          1.创建序列化流对象
         *          2.读入对象
         *          3.释放资源
         * */
        ObjectInputStream objectInputStream = null;
        double[][] result=null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(path));
            result = (double[][])objectInputStream.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
