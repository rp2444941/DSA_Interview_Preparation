package arrays.level3;

public class SetMatrixZeroes {
    public static void main(String[] args) {

            int[][] matrix = {
                    {1, 1, 1},
                    {1, 0, 1},
                    {1, 1, 1}
            };

            System.out.println("Original Matrix:");
            printMatrix(matrix);

            setZeroes(matrix);

            System.out.println("\nAfter Applying Set Matrix Zeroes:");
            printMatrix(matrix);
    }
    // ✅ Print matrix function
    public static void printMatrix(int[][] matrix){
        for(int[] row : matrix){
            for(int val : row){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    // time: O((n*m) * (n+m)) ❌ Slow
//        public static void setZeroes(int[][] matrix) {
//            int n = matrix.length;
//            int m = matrix[0].length;
//
//            // Step 1: Mark rows & columns
//            for(int i = 0; i < n; i++){
//                for(int j = 0; j < m; j++){
//                    if(matrix[i][j] == 0){
//
//                        // Mark row
//                        for(int col = 0; col < m; col++){
//                            if(matrix[i][col] != 0)
//                                matrix[i][col] = -1;
//                        }
//
//                        // Mark column
//                        for(int row = 0; row < n; row++){
//                            if(matrix[row][j] != 0)
//                                matrix[row][j] = -1;
//                        }
//                    }
//                }
//            }
//
//            // Step 2: Convert mark to 0
//            for(int i = 0; i < n; i++){
//                for(int j = 0; j < m; j++){
//                    if(matrix[i][j] == -1){
//                        matrix[i][j] = 0;
//                    }
//                }
//            }
//
//
//        }
//T.C: O(n*m)
//S.C: O(n + m)
//    public static void setZeroes(int[][] matrix) {
//        int n = matrix.length;
//        int m = matrix[0].length;
//        int[] row = new int[n];
//        int[] col = new int[m];
//        // Step 1: Mark rows and columns
//        for (int i = 0; i <n ; i++) {
//            for (int j = 0; j <m ; j++) {
//                if(matrix[i][j]==0){
//                    row[i]=1;
//                    col[j]=1;
//                }
//
//            }
//
//        }
//        // Step 2: Update matrix
//        for (int i = 0; i <n ; i++) {
//            for (int j = 0; j < m; j++) {
//                if (row[i] == 1 || col[j]==1) {
//                    matrix[i][j]=0;
//
//                }
//
//            }
//
//        }
//
//    }
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int col0 = 1;
        // scan mark row and col 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n ; j++) {
                if(matrix[i][j]==0){
                    // mark row 0
                    matrix[i][0]=0;
                    // mark col 0
                    if(j!=0){
                        matrix[0][j]=0;
                    }else{
                        col0=0;
                    }
                }
                
            }
            
        }
        //  Step 2: Update inner matrix (reverse traversal)
        for (int i = m-1; i >=1 ; i--) {
            for(int j=n-1;j>=1;j--){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;

                }
            }

        }
        // Step 3: Update first row if needed
        if(matrix[0][0]==0){
            for (int j = 0; j < n; j++) {
                matrix[0][j]=0;

            }
        }
        if(col0==0){
            for (int i = 0; i < m; i++) {
                matrix[i][0]=0;

            }
        }
    }

}
