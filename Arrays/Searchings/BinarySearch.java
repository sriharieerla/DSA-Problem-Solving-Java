import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input array elements (must be sorted in ascending order)
        System.out.println("Enter elements in ascending order:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input element to search
        System.out.print("Enter element to search: ");
        int target = sc.nextInt();

        int index = binarySearch(arr, target);

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }

        sc.close();
    }

    // Standard iterative binary search
    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2; // Avoid overflow

            if (arr[mid] == target) {
                return mid; // Found
            } else if (arr[mid] < target) {
                start = mid + 1; // Search right
            } else {
                end = mid - 1; // Search left
            }
        }

        return -1; // Not found
    }
}
