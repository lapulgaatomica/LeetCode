package medium;

import java.util.LinkedList;

public class FindTheWinner {
    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
        System.out.println(findTheWinner(6, 5));
    }

    public static int findTheWinner(int n, int k) {
        boolean[] friends = new boolean[n];

        int friendCount = n;
        int fp = n; // friends' pointer

        while (friendCount > 1) {
            for (int i = 0; i < k; ++i, ++fp)
                while (friends[fp % n]) // The friend is not there.
                    ++fp;                 // Point to the next one.
            friends[(fp - 1) % n] = true;
            --friendCount;
        }

        for (fp = 0; friends[fp]; ++fp) ;
        return fp + 1;
    }
}
