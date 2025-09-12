import java.util.*;

public class CountSort {

    public static void countSort(int[] arr) {
        if (arr.length == 0) return;

        // 1. Find min and max values dynamically
        int min = arr[0], max = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        // 2. Create count array based on dynamic range
        int range = max - min + 1;
        int[] count = new int[range];

        // 3. Store frequency of each element
        for (int num : arr) {
            count[num - min]++;
        }

        // 4. Reconstruct the sorted array
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                arr[index++] = i + min;
                count[i]--;
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

        // Sort
        countSort(arr);

        // Output
        System.out.println("Sorted array: " + Arrays.toString(arr));
        
        sc.close();
    }
}
