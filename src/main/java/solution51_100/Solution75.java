package solution51_100;

import java.util.Arrays;

/**
 * 75. 颜色分类
 * created at 2019/12/29
 *
 * @author shixi
 */
public class Solution75 {

    public void sortColors(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] statistic = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            statistic[num]++;
        }

        int index = 0;
        for (int i = 0; i < statistic.length; i++) {
            for (int j = 0; j < statistic[i]; j++) {
                nums[index++] = i;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int leftIndex = 0, rightIndex = nums.length - 1;
        int currentIndex = 0;
        while (currentIndex <= rightIndex) {
            int currentNum = nums[currentIndex];
            if (currentNum == 0) {
                nums[currentIndex++] = nums[leftIndex];
                nums[leftIndex++] = currentNum;
            } else if (currentNum == 2) {
                nums[currentIndex] = nums[rightIndex];
                nums[rightIndex--] = currentNum;
            } else {
                currentIndex++;
            }
        }
    }

    public static void main(String[] args) {
        Solution75 solution75 = new Solution75();
        int[] nums = new int[]{2, 0, 2, 1, 1, 0, 0, 2, 1};
        int[] nums2 = new int[]{0, 0, 2, 0, 1, 2};
        solution75.sortColors2(nums2);
        System.out.println(Arrays.toString(nums2));
    }
}
