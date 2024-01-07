package com.jjt.dataStructure;

/**
 * ClassName: eightQueens
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2024/1/7 14:09
 * @Version 1.0
 * Description:
 *          八皇后问题，利用递归回溯法解决
 *              在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，
 *              即：任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。
 *
 */
public class EightQueens {

    // 表示皇后的数量
    private int max = 8;
    private int cnt = 0;  // 摆放方法计算
    private int judgeCnt = 0; // 统计判断冲突的次数

    // 保存放置结果的数组
    // 数组下标表示皇后的行坐标
    // 数组当中保存的元素表示皇后的列坐标
    int[] array = new int[max];


    /**
     * 放置第 n 个皇后
     * n从 0 开始
     * */
    private void setQueues(int n) {
        if(n == max) {
            // 其实前面 0~max-1 共 max 个皇后已经放置完毕
            printQueues(); // 打印放置的结果
            //printQueues2();
            cnt++;
            return;
        }
        // 依次放入第n个皇后到第 i 列，并判断是否冲突
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if(judge(n)) {
                // 第 n 个皇后放到第 i 列上，不冲突
                //接着放下一个 n+1 皇后
                setQueues(n+1);
            }
            // 1：冲突：第 n 个皇后放到第 i 列上，冲突, 重新放置第 n 个皇后到 n+1 列
            // 2：不冲突：回溯，第 n 个皇后放到第 i 列上，不冲突，
            //    试试，将第 n 个皇后放到第 i+1 列上是否冲突
        }
    }

    /**
     *  检查皇后是否冲突
     *  TODO:
     *      放置第 n 个皇后时，检测该皇后是否和前面已经放置的皇后冲突
     *      n 从 0 开始
     *  返回：
     *      true 不冲突
     *      false 冲突
     * */
    private boolean judge(int n) {
        judgeCnt++;
        for (int i = 0; i < n; i++) {
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n]-array[i])) {
                // 条件1： 放置的第 n 个皇后 与前面的皇后处于同一列
                // 条件2： n-i 表示 行距离
                //        array[n]-array[i]  表示列距离
                //        行距离 == 列距离 表示它们处于45°的对角线上
                return false;
            }
        }
        return true;
    }

    /**
     *  执行解法
     * */

    public void slove(){
        setQueues(0);  // 从放置第 0 个皇后开始
        System.out.println("统计："+ max + "皇后问题共有"+cnt+"种解法");
        System.out.println("判断冲突"+ judgeCnt + "次");
    }


    /**
     * 打印皇后摆放的位置
     * */
    private void printQueues() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * 以二维棋盘的方式打印皇后摆放的位置
     * */
    private void printQueues2() {
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                if(j == array[i]) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
                System.out.print("\t");
            }
            System.out.println();
        }

        System.out.println("-----------------------------------------------");
    }
}
