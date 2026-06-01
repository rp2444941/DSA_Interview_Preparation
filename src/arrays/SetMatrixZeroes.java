package arrays;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        // Ek test matrix banayi humne yahan
        int[][] matrix = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        // Function ko call kiya
        setZeroes(matrix);

        System.out.println("\nMatrix after setZeroes:");
        printMatrix(matrix);
    }


    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        // step 1 :Asli 0 dhoondo aur row/col ko -1 mark karo
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if(matrix[i][j]==0){
                    markRowAndCol(matrix,m,n,i,j);
                }

            }

        }
        // Step 2: Ek aur baar iterate karo, jahan -1 hai use 0 bana do
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if(matrix[i][j]==-1){
                    matrix[i][j]=0;
                }

            }

        }
    }
    public static void markRowAndCol(int[][] matrix, int m, int n, int row, int col) {
        //puri row me janha 0 nhi hai -1 dal
        for (int j = 0; j <n ; j++) {
            if(matrix[row][j]!=0){
                matrix[row][j]=-1;
            }

        }
        // puri col me janha 0 nhi hai -1 kr do
        for (int i = 0; i <m ; i++) {
            if(matrix[i][col]!=0){
                matrix[i][col]=-1;
            }

        }
    }

}
