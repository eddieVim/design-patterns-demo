package pers.eddievim.dp.behavioral.strategy;

import java.util.Arrays;

/**
 * 排序类
 *
 * @author eddieVim
 * @微信公众号 埃迪的Code日记 / PositiveEddie
 * @blog https://blog.csdn.net/weixin_44129784
 * @create 2020/8/21 5:03 下午
 */
public class MySorter {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{0, 5, 1, 2, 5, 0};

        System.out.println(Arrays.toString(arr));

        // 策略模式，匿名内部类编写比较策略
        MySorter.sort(arr, new MyComparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 降序排序数组
                return o2 - o1;
            }
        });

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 排序方法
     *
     * @param arr 需要排序的数组
     * @param myComparator 比较器
     * @param <T> 范型
     */
    public static <T> void sort(T[] arr, MyComparator<? super T> myComparator) {
        // 简单使用了选择排序
        for (int i = 0; i < arr.length; i++) {
            T curr = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                // 如果compare结果大于0则表明需要更新curr
                if (myComparator.compare(curr, arr[j]) > 0) {
                    T temp = arr[j];
                    arr[j] = curr;
                    curr = temp;
                }
            }
            arr[i] = curr;
        }
    }
}
