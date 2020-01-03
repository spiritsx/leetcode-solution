package solution201_250;

/**
 * 240. 搜索二维矩阵 II
 */
public class Solution240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 ) {
            return false;
        }
        int min = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < min; i++) {
            boolean verticalFound =  binarySearch(matrix, target, i, true);
            boolean horizontalFound =  binarySearch(matrix, target, i, false);
            if (verticalFound || horizontalFound) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
        int lo = start;
        int hi = vertical ? matrix[0].length-1 : matrix.length-1;

        while (hi >= lo) {
            int mid = (lo + hi)/2;
            if (vertical) { // searching a column
                if (matrix[start][mid] < target) {
                    lo = mid + 1;
                } else if (matrix[start][mid] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            } else { // searching a row
                if (matrix[mid][start] < target) {
                    lo = mid + 1;
                } else if (matrix[mid][start] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        // start our "pointer" in the bottom-left
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution240 solution240 = new Solution240();
        int[][] matrix = new int[][] {
                {1,   4,  7, 11, 15, 17},
                {2,   5,  8, 12, 19, 21},
                {3,   6,  9, 16, 22, 25},
                {10, 13, 14, 17, 24, 26},
                {18, 21, 23, 26, 30, 31}
        };
        boolean b = solution240.searchMatrix2(matrix, 26);
        System.out.println(b);
    }
}
