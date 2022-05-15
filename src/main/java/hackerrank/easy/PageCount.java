package hackerrank.easy;

public class PageCount {
    public static void main(String[] args) {
        //n = number of pages
        //p = page to turn to
        System.out.println();
    }

    public static int pageCount(int n, int p) {
        int front = p >> 1;
        int back =  ((n & 1) == 1) ? (n - p) >> 1 : (n - p + 1) >> 1;
        return Math.min(front, back);
    }
}
