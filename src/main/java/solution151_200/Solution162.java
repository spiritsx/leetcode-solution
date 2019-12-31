package solution151_200;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * 162. 寻找峰值
 * created at 2019/12/31
 *
 * @author shixi
 */
public class Solution162 {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1 || nums[0] > nums[1]) {
            return 0;
        } else if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public int findPeakElement2(int[] nums) {

        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int left, int right) {
        if (right == left) {
            return left;
        }
        int middle = (right - left) / 2 + left;
        if (nums[middle] > nums[middle + 1]) {
            return helper(nums, left, middle);
        } else {
            return helper(nums, middle + 1, right);
        }
    }

    public int findPeakElement3(int[] nums) {
        int left = 0, right = nums.length - 1;
        int middle = (right - left) / 2 + left;
        while (left < right) {
            if (nums[middle] > nums[middle + 1]) {
                right = middle;
            } else {
                left  = middle + 1;
            }
            middle = (right - left) / 2 + left;
        }
        return middle;
    }

    @Test
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 3, 5, 6, 4};
        Solution162 solution162 = new Solution162();
        int peakElement = solution162.findPeakElement3(nums);
        System.out.println(peakElement);
        assertEquals(peakElement, 1);
    }
}
