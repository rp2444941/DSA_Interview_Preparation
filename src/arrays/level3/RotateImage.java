package arrays.level3;

public class RotateImage {
    public static void printMatrix(int[][] matrix){
        for(int[] row : matrix){
            for(int val : row){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        rotate(matrix);

        System.out.println("\nAfter 90° Clockwise Rotation:");
        printMatrix(matrix);
    }
    public static void rotate(int[][] matrix) {
        int n=matrix.length;
        // transpose
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;

            }

        }
        //reverse
        for (int i = 0; i <n ; i++) {
            int start=0;
            int end=n-1;
            while(start<end){
                int temp=matrix[i][start];
                matrix[i][start]=matrix[i][end];
                matrix[i][end]=temp;
                start++;
                end--;

            }
        }
    }
}
