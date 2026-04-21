package stack_Queue;
import java.util.ArrayList;
import java.util.List;
public class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangle sol = new PascalTriangle();
        int rows = 5;
        List<List<Integer>> result = sol.generate(rows);

        // Result print karne ke liye loop
        for (List<Integer> row : result) {
            System.out.println(row);
        }

    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                // If it's the first or last element of the row, add 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Sum of the two elements from the previous row
                    int leftAbove = triangle.get(i - 1).get(j - 1);
                    int rightAbove = triangle.get(i - 1).get(j);
                    row.add(leftAbove + rightAbove);
                }
            }
            triangle.add(row);
        }

        return triangle;
    }
}
