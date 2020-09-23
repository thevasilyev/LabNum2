import java.util.Scanner;
import java.util.Random;

public class Matrix {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of rows: ");
            int row = scanner.nextInt();

            System.out.print("Enter number of columns: ");
            int col = scanner.nextInt();
            if (row == 0 || col == 0) {
                throw new Exception("Error: Zero size!");
            }

            int[][] matrix = createRandomMatrix(row, col);
            System.out.println("    Random matrix is:");
            printMatrix(matrix);

            sortMatrix(matrix);
            System.out.println("    Sorted matrix is:");
            printMatrix(matrix);

        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }

    static void printMatrix(int[][] matrix) {
        for (int[] line : matrix) {
            for (int elem : line) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    static int[][] createRandomMatrix(int row, int col) {
        int[][] matrix = new int[row][col];
        Random rand = new Random();
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                matrix[i][j] = rand.nextInt(100);
            }
        }
        return matrix;
    }

    static void sortMatrix(int[][] matrix) {
        for (int x = 0; x < matrix.length; x++) {
            for (int i = 0; i < matrix.length - 1; i++) {
                if (matrix[i][0] < matrix[i + 1][0]) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        int temp = matrix[i][j];
                        matrix[i][j] = matrix[i + 1][j];
                        matrix[i + 1][j] = temp;
                    }
                }
            }
        }
    }
}
