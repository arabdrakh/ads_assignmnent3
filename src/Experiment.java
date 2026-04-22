import java.util.Arrays;
//Aruzhanka Abdr IT-2501
public class Experiment {
    public long measureSortTime(int[] arr, String type) {
        long start = System.nanoTime();

        if (type.equalsIgnoreCase("basic")) {
            sorter.basicSort(arr);
        } else {
            sorter.advancedSort(arr);
        }

        long end = System.nanoTime();
        return end - start;
    }
}