package grokkingalgorithms.divideandconquer;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 3, 4}, 1));
        System.out.println(binarySearch(new int[]{1, 2, 3, 4}, 4));
        System.out.println(binarySearch(new int[]{1, 2, 3, 4}, 5));
        System.out.println(binarySearch(new int[]{1, 2, 3, 4}, 0, 4, 1));
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

    public static int binarySearch(int[] array, int left, int right, int searchTerm){
        // Restrict the boundary of right index and the left index to prevent overflow of indices
        if (right >= left && left <= array.length - 1) {

            int mid = left + (right - left) / 2;

            // If the element is present at the middle itself
            if (array[mid] == searchTerm)
                return mid;

            // If element is smaller than mid, then it can only be present in left subarray
            if (array[mid] > searchTerm)
                return binarySearch(array, left, mid - 1, searchTerm);

            // Else the element can only be present in right subarray
            return binarySearch(array, mid + 1, right, searchTerm);
        }

        // We reach here when element is not present in array
        return -1;
    }
}
