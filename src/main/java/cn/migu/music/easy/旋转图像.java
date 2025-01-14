package cn.migu.music.easy;

/**
 *
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * 示例 2：
 *
 *
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 * @version 1.0 created by huangfei on 2025/1/14 10:09
 */
public class 旋转图像 {

    /**
     *
     * 主要想解释一下两个for循环，为什么一个是n/2，另一个是（n+1）/2，前面的一个for循环代表行号，后面的一个for循环代表列号，列号取了中间值以后
     * 会影响行号的中间值。举例说明一下，例如n=4，n/2=2，（n+1）/2=2；例如n=5，n/2=2，（n+1）/2=3，首先我们可以确定[0][2]坐标中的数据是要
     * 改变的，依次改变的坐标是[2][4]->[4][2]->[2][0]，观察发现中间一行的数据是会被改变的，所以就不需要进行中间一行的改变。
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }
}
