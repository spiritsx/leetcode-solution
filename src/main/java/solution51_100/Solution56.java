package solution51_100;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 56. 合并区间
 * created at 2020/1/1
 *
 * @author shixi
 */
public class Solution56 {

    public int[][] merge(int[][] intervals) {
        List<int[]> results = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return results.toArray(new int[0][]);
        }

        int i = 0;
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && right >= intervals[i + 1][0]) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            results.add(new int[]{left, right});
            i++;

        }

        return results.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
        int[][] intervals = new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };
        int[][] merge = solution56.merge(intervals);
        System.out.println(Arrays.deepToString(merge));
        assertTrue(Arrays.deepEquals(merge, new int[][]{{1, 6}, {8, 10}, {15, 18}}));
    }
}
