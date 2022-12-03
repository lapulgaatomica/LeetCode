package recursion;

public class SearchMatrix {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1,4,7,11,15}, {2,5,8,12,19},
                {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}}, 5) == true);
        System.out.println(searchMatrix(new int[][]{{1,4,7,11,15}, {2,5,8,12,19},
                {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}}, 20) == false);
        System.out.println(searchMatrix(new int[][]{{-1, 3}}, 3) == true);
        System.out.println(searchMatrix(new int[][]{{-5}}, 3) == false);
        System.out.println(searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},
                {3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5) == true);
        System.out.println(searchMatrix(new int[][]{{1, 4}, {2, 5}}, 2) == true);
    }

    static int[][] mat;
    static int targ;
    public static boolean searchMatrix(int[][] matrix, int target) {
        mat = matrix;
        targ = target;
        if(matrix == null || matrix.length == 0)
            return false;

        return searchRec(0, 0, matrix[0].length - 1, matrix.length - 1);
    }

    private static boolean searchRec(int left, int up, int right, int down){
        if(left > right || up > down)
            return false;
        else if(targ < mat[up][left] || targ > mat[down][right])
            return false;
        int mid = left + (right - left) / 2;

        int row = up;
        while (row <= down && mat[row][mid] <= targ){
            if(mat[row][mid] == targ)
                return true;
            row++;
        }

        return searchRec(left, row, mid - 1, down) || searchRec(mid + 1, up, right, row - 1);
    }
}
