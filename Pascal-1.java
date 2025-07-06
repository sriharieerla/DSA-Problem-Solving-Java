//Given an integer numRows, return the first numRows of Pascal's triangle.

import java.util.*;

public class PascalsTriangle {

    // Function to generate Pascal's Triangle
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows <= 0) return triangle;

        // First row is always [1]
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        // Build the triangle row by row
        for (int row = 1; row < numRows; row++) {
            List<Integer> prevRow = triangle.get(row - 1);
            List<Integer> newRow = new ArrayList<>();

            newRow.add(1); // First element of each row is 1

            // Each inner element is sum of two elements above it
            for (int j = 1; j < row; j++) {
                newRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            newRow.add(1); // Last element of each row is 1

            triangle.add(newRow);
        }

        return triangle;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int numRows = sc.nextInt();

        List<List<Integer>> result = generate(numRows);

        System.out.println("\nPascal's Triangle:");
        for (List<Integer> row : result) {
            System.out.println(row);
        }

        sc.close();
    }
}


/*
Inputs:
Enter number of rows: 5

outputs:
Pascal's Triangle:
[1]
[1, 1]
[1, 2, 1]
[1, 3, 3, 1]
[1, 4, 6, 4, 1]
*/