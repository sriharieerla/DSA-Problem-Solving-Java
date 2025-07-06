//Write a function to find the longest common prefix string amongst an array of strings.
//If there is no common prefix, return an empty string
import java.util.*;

public class LongestCommonPrefix {

    // Function to find the longest common prefix
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                // Shorten the prefix
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Example 1
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println("Input: " + Arrays.toString(strs1));
        System.out.println("Output: \"" + longestCommonPrefix(strs1) + "\"");

        System.out.println();

        // Example 2
        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println("Input: " + Arrays.toString(strs2));
        System.out.println("Output: \"" + longestCommonPrefix(strs2) + "\"");

        System.out.println();

        // Example 3: Custom user input
        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline
        String[] strs3 = new String[n];
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strs3[i] = sc.nextLine();
        }
        System.out.println("Input: " + Arrays.toString(strs3));
        System.out.println("Output: \"" + longestCommonPrefix(strs3) + "\"");

        sc.close();
    }
}
