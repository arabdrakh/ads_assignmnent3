import java.util.Arrays;
public class Searcher {
    //Aruzhanka Abdr IT-2501
    private final Sorter   sorter   = new Sorter();
    private final Searcher searcher = new Searcher();
    private static final int[] SIZES = { 10, 100, 1_000, 10_000 };
    public int search(int[] arr, int target) {
        int low  = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();
        searcher.search(arr, target);
        long end = System.nanoTime();
        return end - start;
    }
}