package easy2;

public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{24,69,100,99,79,78,67,36,26,19}));
        System.out.println(peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(peakIndexInMountainArray(new int[]{0,2, 1, 0}));
        System.out.println(peakIndexInMountainArray(new int[]{0,10, 5, 2}));
        System.out.println(peakIndexInMountainArray(new int[]{3, 4, 5, 1}));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            if(i > 0 && arr[i - 1] > arr[i]){
                return i - 1;
            }
        }
        return -1;
    }
}
