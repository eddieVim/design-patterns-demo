package pers.eddievim;

import java.util.Arrays;

/**
 * @author eddie
 * @微信公众号 PositiveEddie
 * @create 2021/3/15 22:36
 * @description
 */
public class Solution {
    public static void main(String[] args) {
        double[] jidian = new double[] {
                1.9, 3.5, 2.2, 3.9, 2.9, 3, 2, 3, 1.6, 3.0, 4.2, 2.4, 3.1,4.9, 3.2, 4.8, 1.8, 3.7, 2,
                1.5, 2.2, 3.2, 4.2, 4, 4.9, 3.4, 4, 0, 1.3, 1, 1.1, 1.6, 2.2, 3.5, 2.6, 3.6, 3, 3, 3.3,
                4.6, 0, 2.7, 2.9, 3.7, 2.8, 2, 1.3, 1.7, 3.2, 3.5, 3, 3.3, 4.8, 0,
                4.5, 4.5, 4.5, 4.5, 4.5, 4.5, 4.5, 4.5, 4.5, 4.5, 4.5
        };

        double[] xuefen = new double[] {
                2, 2, 3, 0.5, 3, 1, 3, 1, 2, 0.5, 2, 0, 3, 2, 0.5, 0.25, 2.5, 1, 3,
                3, 2.5, 2, 3, 0.5, 2, 0.5, 3, 0.25, 3, 1, 3, 3, 2, 3.5, 3, 2, 0.5, 2, 0,
                2, 0.25, 3.5, 2, 1, 2, 3, 3, 2, 2, 3, 0.5, 3, 2, 0.25,
                2, 3, 2.5, 2.5, 2, 3, 2.5, 0.5, 2, 2.5, 0
        };

        double sum = 0;

        for (double d : xuefen) {
            sum += d;
        }

        double jiaquan = 0;

        for (int i = 0; i < jidian.length; i++) {
            jiaquan += jidian[i] * xuefen[i];
        }

        System.out.println(jiaquan / sum);

        System.out.println(jidian.length == xuefen.length);
    }
}
