import java.util.Arrays;
import java.util.Random;
public class Sorter {
    //aruzhan abd it-2501
    //Class 1: randmm
    private final Random random = new Random();
    public int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size * 10);
        }
        return arr;
    }
    public int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }
    //Class 1: Print array
    public void printArray(int[] arr) {
        if (arr.length <= 20) {
            // print full array for small sizes
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
                if (i < arr.length - 1) sb.append(", ");
            }
            sb.append("]");
            System.out.println(sb);
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < 10; i++) {
                sb.append(arr[i]).append(", ");
            }
            sb.append("... , ");
            for (int i = arr.length - 10; i < arr.length; i++) {
                sb.append(arr[i]);
                if (i < arr.length - 1) sb.append(", ");
            }
            sb.append("]");
            System.out.println(sb);
        }
    }
    //insertion sort

    public void basicSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    //Aruzhan Abdrakhmanova IT-2501
    public void advancedSort(int[] arr) {
        if (arr.length < 2) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;    // size of left sub-array
        int n2 = right - mid;       // size of right sub-array

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1) arr[k++] = leftArr[i++];

        while (j < n2) arr[k++] = rightArr[j++];
    }
}