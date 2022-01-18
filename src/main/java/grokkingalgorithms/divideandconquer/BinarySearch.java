package grokkingalgorithms.divideandconquer;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 3, 4}, 1));
        System.out.println(binarySearch(new int[]{1, 2, 3, 4}, 4));
        System.out.println(binarySearch(new int[]{1, 2, 3, 4}, 5));
    }

    public static int binarySearch(int[] array, int number){
        int low = 0;
        int high = array.length - 1;

        while (low <= high){
            int mid = (low + high) / 2;
            int guess = array[mid];

            if(guess == number){
                return mid;
            }

            if(guess > number){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return - 1;
    }
}
