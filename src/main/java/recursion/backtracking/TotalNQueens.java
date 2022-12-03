package recursion.backtracking;

import java.util.HashSet;
import java.util.Set;

public class TotalNQueens {
    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }

    public static int totalNQueens(int n) {
        Set<Integer> blockedColumns = new HashSet<>();
        Set<Integer> blockedUpDiagonals = new HashSet<>();
        Set<Integer> blockedDownDiagonals = new HashSet<>();
        return getNumberOfNonAttackingQueenPlacements(0, blockedColumns, blockedUpDiagonals, blockedDownDiagonals, n);
    }

    private static int getNumberOfNonAttackingQueenPlacements(int row, Set<Integer> blockedColumns, Set<Integer> blockedUpDiagonals, Set<Integer> blockedDownDiagonals, int boardSize) {
        if(row == boardSize)
            return 1;

        int validPlacements = 0;
        for(int col = 0; col < boardSize; col++){
            if(isNonAttackingPlacement(row, col, blockedColumns, blockedUpDiagonals, blockedDownDiagonals)){
                placeQueen(row, col, blockedColumns, blockedUpDiagonals, blockedDownDiagonals);
                validPlacements += getNumberOfNonAttackingQueenPlacements(row + 1, blockedColumns, blockedUpDiagonals, blockedDownDiagonals, boardSize);
                removeQueen(row, col, blockedColumns, blockedUpDiagonals, blockedDownDiagonals);
            }
        }
        return validPlacements;
    }

    private static void removeQueen(int row, int col, Set<Integer> blockedColumns, Set<Integer> blockedUpDiagonals, Set<Integer> blockedDownDiagonals) {
        blockedColumns.remove(col);
        blockedUpDiagonals.remove(row + col);
        blockedDownDiagonals.remove(row - col);
    }

    private static void placeQueen(int row, int col, Set<Integer> blockedColumns, Set<Integer> blockedUpDiagonals, Set<Integer> blockedDownDiagonals) {
        blockedColumns.add(col);
        blockedUpDiagonals.add(row + col);
        blockedDownDiagonals.add(row - col);
    }

    private static boolean isNonAttackingPlacement(int row, int col, Set<Integer> blockedColumns, Set<Integer> blockedUpDiagonals, Set<Integer> blockedDownDiagonals) {
        if(blockedColumns.contains(col) || blockedUpDiagonals.contains(row + col) || blockedDownDiagonals.contains(row - col))
            return false;
        return true;
    }


}
