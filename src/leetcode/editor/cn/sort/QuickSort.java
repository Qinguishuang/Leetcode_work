package leetcode.editor.cn.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(100);
        }
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int l, int r) {
        if (l < r) {
            int index = partition_(array, l, r);
            quickSort(array, l, index - 1);
            quickSort(array, index + 1, r);
        }
    }

    private static int partition(int[] array, int l, int r) {
        int temp = array[l];
        while (l < r) {
            while (l < r && array[r] >= temp) {
                r--;
            }
            array[l] = array[r];
            while (l < r && array[l] <= temp) {
                l++;
            }
            array[r] = array[l];
        }
        array[l] = temp;
        return l;
    }

    /**
     * 将排序数组的最右侧数字作为主元x
     * 数组被分为三部分 | <=x | >x | 无限制 | x |
     */
    private static int partition_(int[] array, int l, int r) {
        var i = l - 1;
        var pivot = array[r]; // 最右边的那个数作为主元
        for (int j = l; j < r; j++) {
            if (array[j] <= pivot) {
                i++;
                var temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        var temp = array[i + 1];
        array[i + 1] = array[r];
        array[r] = temp;
        return i + 1;
    }
}
