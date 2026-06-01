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
//        setZeroes(matrix);

        setZeroes2(matrix);

        System.out.println("\nMatrix after setZeroes:");
        printMatrix(matrix);
    }


    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
//method 1
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

   //method 2
   public static void setZeroes2(int[][] matrix) {
       int m = matrix.length;
       int n = matrix[0].length;

       // Naye arrays banaye track rakhne ke liye (Java me initially saare 0 hote hain)
       int[] dummyRow = new int[m];
       int[] dummyCol = new int[n];

       // Step 1: Pehla pass - jahan 0 mile, dummy arrays me 1 mark kar do
       for (int i = 0; i < m; i++) {
           for (int j = 0; j < n; j++) {
               if (matrix[i][j] == 0) {
                   dummyRow[i] = 1; // i-th row badalni hai
                   dummyCol[j] = 1; // j-th column badalna hai
               }
           }
       }

       // Step 2: Dusra pass - dummy arrays ko dekh kar matrix me 0 set karo
       for (int i = 0; i < m; i++) {
           for (int j = 0; j < n; j++) {
               // Agar us row ya us column ko pehle mark kiya gaya tha, toh element ko 0 kar do
               if (dummyRow[i] == 1 || dummyCol[j] == 1) {
                   matrix[i][j] = 0;
               }
           }
       }
   }

}
