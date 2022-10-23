package easy4;

import java.util.HashSet;
import java.util.Set;

public class SetZeroes {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,1}, {1,0,1}, {1,1,1}};
        setZeroes(matrix);
        int[][] matrix2 = new int[][]{{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        setZeroes1(matrix2);
    }

    public static void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        for(int row = 0; row < matrix.length; row++){
            for(int column = 0; column < matrix[row].length; column++){
                if(matrix[row][column] == 0){
                    rows.add(row);
                    columns.add(column);
                }
            }
        }

        for(int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (rows.contains(row) || columns.contains(column))
                    matrix[row][column] = 0;
            }
        }
    }

    public static void setZeroes1(int[][] matrix) {
        boolean isCol = false;
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        for(int row = 0; row < rowLength; row++){
            if(matrix[row][0] == 0){
                isCol = true;
            }

            for(int column = 1; column < columnLength; column++){
                if(matrix[row][column] == 0){
                    matrix[0][column] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        for (int row = 1; row < rowLength; row++){
            for(int column = 1; column < columnLength; column++){
                if(matrix[row][0] == 0 || matrix[0][column] == 0)
                    matrix[row][column] = 0;
            }
        }

        if(matrix[0][0] == 0){
            for (int column = 0; column < columnLength; column++){
                matrix[0][column] = 0;
            }
        }

        if(isCol){
            for(int row = 0; row < rowLength; row++){
                matrix[row][0] = 0;
            }
        }
    }
}
