import java.util.*;

public class BucketSort {

    public static void bucketSort(int[] arr) {
        if (arr.length == 0) return;

        // 1. Find minimum and maximum values
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int num : arr) {
            if (num < minValue) minValue = num;
            if (num > maxValue) maxValue = num;
        }

        // 2. Number of buckets (sqrt method for balance)
        int bucketCount = (int) Math.sqrt(arr.length);
        if (bucketCount == 0) bucketCount = 1;

        // 3. Calculate bucket range
        double range = (double)(maxValue - minValue + 1) / bucketCount;

        // 4. Create buckets
        List<Integer>[] buckets = new List[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 5. Distribute elements into buckets
        for (int num : arr) {
            int bucketIndex = (int)((num - minValue) / range);
            if (bucketIndex >= bucketCount) bucketIndex = bucketCount - 1; // edge case
            buckets[bucketIndex].add(num);
        }

        // 6. Sort each bucket and merge
        int index = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Take input elements
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Print unsorted
        System.out.println("Unsorted array: " + Arrays.toString(arr));

        // Sort
        bucketSort(arr);

        // Print sorted
        System.out.println("Sorted array:   " + Arrays.toString(arr));

        sc.close();
    }
}
