package arrays;

public class RotateMatrix90degrees {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        RotateMatrix90degrees obj = new RotateMatrix90degrees();
        int[][] rotated = obj.rotateClockwise(matrix);


        // Print the rotated matrix
        for (int[] row : rotated) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }

    private static int[][] rotateClockwise(int[][] matrix) {
        int n=matrix.length;
        int[][] rotate=new int[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                rotate[j][n-1-i]=matrix[i][j];


            }

        }
        return rotate;
    }

    public static void rotateClockwise1(int[][] matrix) {
        int n=matrix.length;
        //1.transpose the matrix;
        for (int i = 0; i <n ; i++) {
            for (int j = i+1; j <n; j++) {
                //swap(i,j) to (j i)
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;


            }

        }
        //2. reverse each row
        for (int i = 0; i <n ; i++) {
            int left=0, right=n-1;
            while(left<right){
                int temp=matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=temp;
                left++;
                left--;


            }

        }

    }
}
