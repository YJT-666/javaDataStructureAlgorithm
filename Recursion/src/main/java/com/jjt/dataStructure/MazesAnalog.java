package com.jjt.dataStructure;

/**
 * ClassName: MazesAnalog
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2024/1/6 22:07
 * @Version 1.0
 * Description:
 *
 *        迷宫模拟小游戏
 */
public class MazesAnalog {

    // 二维地图模拟迷宫
    // 1 表示墙  0 表示空地
    // 2 表示小球走过是通路
    // 3 表示小球走过，但是是死路，走不通
    int[][] map = new int[8][7];

    public MazesAnalog() {
        // 初始化地图
        setMap1();
    }


    // 清空地图
    public void clearMap() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                map[i][j] = 0;
            }
        }
        // 设置墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
    }

    // 设置地图1
    public void setMap1() {
        clearMap();
        // 设置挡板
        map[3][1] =1;
        map[3][2] =1;
    }
    public void setMap2() {
        clearMap();
        // 设置挡板
        map[3][1] =1;
        map[3][2] =1;
        map[2][2] =1;
    }

    /**
     *  使用递归回溯给小球找路
     *  (i,j)表示从哪个位置出发开始找
     *  返回 为true，说明已经找到出口，false 则没有找到出口
     *  出口位置为 (6,5)
     *  地图上的标记:
     *     1 表示墙  0 表示空地
     *     2 表示小球走过是通路
     *     3 表示小球走过，但是是死路，走不通
     *  走迷宫的策略:
     *     下 -> 右 -> 上 -> 左， 如果该点走不通，再回溯
     *     其他的策略
     *       4*3*2*1 = 24种
     * */
    public boolean setWay(int i, int j) {
        if(map[6][5] == 2) {
            // 出口已经找到了
            return true;
        } else {
            if(map[i][j] == 0) {
                // 当前整个点还没有走过
                map[i][j] = 2;  // 假定该点可以走通
                if(setWay(i+1, j)) {
                    return true;  // 向下走可以走通
                } else if(setWay(i, j+1)) {
                    return true;  // 向右走可以走通
                } else if(setWay(i-1, j)) {
                    return true;  // 向上走可以走通
                } else if(setWay(i,j-1)) {
                    return true;  // 向左走可以走通
                } else {
                    // 该点走不通
                    map[i][j] = 3;
                    return false;
                }
            }else {
                // 1 , 2, 3
                return false;
            }
        }
    }

    // 打印地图
    public void printMap() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------");
    }
}
