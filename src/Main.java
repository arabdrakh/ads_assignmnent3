public class Main {

    public static void main(String[] args) {

        // Initialize core classes
        Sorter sorter = new Sorter();
        Searcher searcher = new Searcher();
        Experiment experiment = new Experiment();

        System.out.println("\n--- SORTING & SEARCHING ALGORITHM ANALYSIS SYSTEM ---");
        System.out.println("Algorithms: Insertion Sort, Merge Sort, Binary Search\n");

        System.out.println("--- Basic Sort 1: Insertion Sort (10 elements) ---");
        int[] smallRandom = sorter.generateRandomArray(10);
        System.out.print("Before sorting: ");
        sorter.printArray(smallRandom);

        long time1 = experiment.measureSortTime(smallRandom, "basic");
        System.out.print("After sorting:  ");
        sorter.printArray(smallRandom);
        System.out.printf("Time: %,d ns%n%n", time1);

        System.out.println("--- Advanced sort 2: Merge Sort (10 elements) ---");
        int[] smallRandom2 = sorter.generateRandomArray(10);
        System.out.print("Before sorting: ");
        sorter.printArray(smallRandom2);

        long time2 = experiment.measureSortTime(smallRandom2, "advanced");
        System.out.print("After sorting:  ");
        sorter.printArray(smallRandom2);
        System.out.printf("Time: %,d ns%n%n", time2);

        System.out.println("--- Sort 3: Sorting a MEDIUM random array (100 elements) ---");
        int[] mediumRandom1 = sorter.generateRandomArray(100);
        int[] mediumRandom2 = mediumRandom1.clone();

        long timeBasicMed = experiment.measureSortTime(mediumRandom1, "basic");
        long timeAdvancedMed = experiment.measureSortTime(mediumRandom2, "advanced");

        System.out.printf("Insertion Sort time: %,d ns%n", timeBasicMed);
        System.out.printf("Merge Sort time:     %,d ns%n", timeAdvancedMed);
        System.out.print("Sorted (first 20):   ");
        sorter.printArray(mediumRandom1);
        System.out.println();

        System.out.println("--- Random Arrya 4: Sorting a LARGE random array (1,000 elements) ---");
        int[] largeRandom1 = sorter.generateRandomArray(1000);
        int[] largeRandom2 = largeRandom1.clone();

        long timeBasicLg = experiment.measureSortTime(largeRandom1, "basic");
        long timeAdvancedLg = experiment.measureSortTime(largeRandom2, "advanced");

        System.out.printf("Insertion Sort time: %,d ns%n", timeBasicLg);
        System.out.printf("Merge Sort time:     %,d ns%n", timeAdvancedLg);
        System.out.print("Sorted (preview):    ");
        sorter.printArray(largeRandom1);
        System.out.println();

        System.out.println("--- Sorted 5: Sorting an ALREADY-SORTED array (1,000 elements) ---");
        int[] sortedArr1 = sorter.generateSortedArray(1000);
        int[] sortedArr2 = sortedArr1.clone();

        long timeBasicSorted = experiment.measureSortTime(sortedArr1, "basic");
        long timeAdvancedSorted = experiment.measureSortTime(sortedArr2, "advanced");

        System.out.printf("Insertion Sort time: %,d ns (best case - O(n))%n", timeBasicSorted);
        System.out.printf("Merge Sort time:     %,d ns (always O(n log n))%n", timeAdvancedSorted);
        System.out.println();

        System.out.println("--- Search 6: Binary Search on sorted arrays ---");
        int[] searchArr = sorter.generateSortedArray(1000);
        int target1 = 500;
        int target2 = 9999;

        long searchTime1 = experiment.measureSearchTime(searchArr, target1);
        int result1 = searcher.search(searchArr, target1);
        System.out.printf("Searching for %d -> index %d | Time: %,d ns%n", target1, result1, searchTime1);

        long searchTime2 = experiment.measureSearchTime(searchArr, target2);
        int result2 = searcher.search(searchArr, target2);
        System.out.printf("Searching for %d -> index %d (not found) | Time: %,d ns%n%n", target2, result2, searchTime2);

        System.out.println("--- FULL PERFORMANCE EXPERIMENTS ---");
        experiment.runAllExperiments();

        System.out.println("--- ALL EXPERIMENTS COMPLETE ---");
    }
}
