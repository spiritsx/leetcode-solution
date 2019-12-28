package solution301_350;

/**
 * 334
 * created at 2019/12/9
 *
 * @author shixi
 */
public class Solution334 {

    public boolean increasingTriplet(int[] nums) {
        int n1 = Integer.MAX_VALUE, n2 = Integer.MAX_VALUE, n3 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (n1 > num) {
                n1 = num;
            } else if (num != n1 && num < n2) {
                n2 = num;
            } else if (num != n1 && num != n2 && num < n3) {
                n3 = num;
            }

            if (n1 < n2 && n2 < n3 && n3 < Integer.MAX_VALUE) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 10, 0, 100};
        Solution334 solution334 = new Solution334();
        boolean b = solution334.increasingTriplet(nums);
        System.out.println(b);
    }
}
