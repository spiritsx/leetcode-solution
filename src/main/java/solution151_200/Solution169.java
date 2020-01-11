package solution151_200;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * created at 2020/1/11
 *
 * @author shixi
 */
public class Solution169 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> majorMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (majorMap.containsKey(num)) {
                majorMap.put(num, majorMap.get(num) + 1);
            } else {
                majorMap.put(num, 1);
            }
        }

        int half = nums.length / 2;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : majorMap.entrySet()) {
            if (integerIntegerEntry.getValue() > half) {
                return integerIntegerEntry.getKey();
            }
        }
        return -1;
    }

    public int majorityElement2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int majorElement = nums[0];
        int maxTime = 1;

        for (int i = 1; i < nums.length; i++) {
            if (majorElement == nums[i]) {
                maxTime++;
            } else {
                maxTime--;
            }
            if (maxTime == 0) {
                majorElement = nums[i];
                maxTime = 1;
            }
        }
        return majorElement;
    }

    public int majorityElement3(int[] nums) {
        return majorityElementrec(nums, 0, nums.length - 1);
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementrec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementrec(nums, lo, mid);
        int right = majorityElementrec(nums, mid + 1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public static void main(String[] args) {
        Solution169 solution169 = new Solution169();
        int[] nums = new int[]{3, 2, 3};
        int half = solution169.majorityElement(nums);
        System.out.println(half);
        Assertions.assertEquals(half, 3);

        int[] nums2 = new int[]{2, 2, 1, 1, 1, 2, 2};
        half = solution169.majorityElement2(nums2);
        System.out.println(half);
        Assertions.assertEquals(half, 2);

        int[] nums3 = new int[]{1, 3, 1, 2, 4, 1, 1};
        half = solution169.majorityElement3(nums3);
         System.out.println(half);
        Assertions.assertEquals(half, 1);
    }
}
