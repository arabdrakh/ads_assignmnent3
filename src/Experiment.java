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
    public long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();
        searcher.search(arr, target);
        long end = System.nanoTime();
        return end - start;
    }
    //Aruzhan Abdrakhmanova
    public void runAllExperiments() {
        System.out.println("\n--- SORTING PERFORMANCE RESULTS ---");
        System.out.printf("%-15s %-15s %-25s %-25s%n", "Array Size", "Input Type", "Insertion Sort (ns)", "Merge Sort (ns)");

        for (int size : SIZES) {
            int[] randomForBasic    = sorter.generateRandomArray(size);
            int[] randomForAdvanced = randomForBasic.clone();

            long basicRandomTime    = measureSortTime(randomForBasic, "basic");
            long advancedRandomTime = measureSortTime(randomForAdvanced, "advanced");

            System.out.printf("%-15d %-15s %-25s %-25s%n",
                    size, "Random", formatNano(basicRandomTime), formatNano(advancedRandomTime));

            int[] sortedForBasic    = sorter.generateSortedArray(size);
            int[] sortedForAdvanced = sortedForBasic.clone();

            long basicSortedTime    = measureSortTime(sortedForBasic, "basic");
            long advancedSortedTime = measureSortTime(sortedForAdvanced, "advanced");

            System.out.printf("%-15d %-15s %-25s %-25s%n",
                    size, "Sorted", formatNano(basicSortedTime), formatNano(advancedSortedTime));
        }
        System.out.println("\n--- SEARCHING PERFORMANCE RESULTS ---");
        System.out.printf("%-15s %-15s %-25s %-15s%n", "Array Size", "Scenario", "Binary Search (ns)", "Result Index")
        for (int size : SIZES) {
            int[] sortedArr = sorter.generateSortedArray(size);
            int existingTarget = sortedArr[size / 2];
            long searchFoundTime = measureSearchTime(sortedArr, existingTarget);
            int foundIndex = searcher.search(sortedArr, existingTarget);

            System.out.printf("%-15d %-15s %-25s %-15d%n",
                    size, "Found", formatNano(searchFoundTime), foundIndex);
            int missingTarget = size * 10 + 999;  // guaranteed to be absent
            long searchNotFoundTime = measureSearchTime(sortedArr, missingTarget);

            System.out.printf("%-15d %-15s %-25s %-15d%n",
                    size, "Not Found", formatNano(searchNotFoundTime), -1);
        }
        System.out.println();
    }

    private String formatNano(long nanos) {
        return String.format("%,d", nanos);
    }
}