package solution1_50;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 34.在排序数组中查找元素的第一个和最后一个位置
 * created at 2019/12/31
 *
 * @author shixi
 */
public class Solution34 {

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums.length == 0)
            return res;
        if (nums.length == 1)
            return nums[0] == target ? new int[]{0, 0} : res;
        divide(res, nums, target, 0, nums.length - 1, true);
        divide(res, nums, target, 0, nums.length - 1, false);
        return res;
    }

    public void divide(int[] result, int[] nums, int target, int low, int high, boolean isLeft) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target)
                divide(result, nums, target, mid + 1, high, isLeft);
            else if (nums[mid] > target)
                divide(result, nums, target, low, mid - 1, isLeft);
            else {
                if (isLeft) {
                    result[0] = mid;
                    divide(result, nums, target, low, mid - 1, isLeft);
                } else {
                    result[1] = mid;
                    divide(result, nums, target, mid + 1, high, isLeft);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
//        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] nums = new int[]{1, 2, 3};
        int[] ints = solution34.searchRange(nums, 2);
        System.out.println(Arrays.toString(ints));
        assertEquals(Arrays.toString(ints), Arrays.toString(new int[]{3, 4}));
    }
}
