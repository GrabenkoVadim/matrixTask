package org.example;

import java.util.Random;

public class MatrixTask {
    private static final int N =6;

    private final Random random = new Random();

    public void execute() {
        try {
            float[][] bMatrix = createRandomMatrix();
            System.out.println("Original matrix:");
            printMatrix(bMatrix);

            // результуюча матриця C = B^T
            float[][] cMatrix = transpose(bMatrix);

            float sum = calculateSum(cMatrix);

            System.out.println("\nSum (even columns — max, odd columns — min): " + sum);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

    }

    private static float calculateSum(float[][] cMatrix) {
        int rows = cMatrix.length;
        int cols = cMatrix[0].length;
        float sum = 0;

        for (int i = 0; i < rows; i++) {
            boolean isEvenColumn = (i + 1) % 2 == 0;
            float extremum = cMatrix[0][i];

            for (int j = 0; j < cols; j++) {
                if (isEvenColumn) {
                    if (cMatrix[i][j] > extremum) {
                        extremum = cMatrix[i][j];
                    }
                } else  {
                    if (cMatrix[i][j] < extremum) {
                        extremum = cMatrix[i][j];
                    }
                }
            }

            sum += extremum;
        }

        return sum;
    }

    private float[][] transpose(float[][] bMatrix) {
        int rows = bMatrix.length;
        int cols = bMatrix[0].length;
        float[][] result = new float[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = bMatrix[i][j];
            }
        }
        return result;
    }

    private void printMatrix(float[][] bMatrix) {
        for (float[] row : bMatrix) {
            for (float value : row) {
                System.out.printf("%8.2f", value);
            }
            System.out.println();
        }
    }

    private float[][] createRandomMatrix() {
        float[][] matrix = new float[MatrixTask.N][MatrixTask.N];
        for (int i = 0; i < MatrixTask.N; i++) {
            for (int j = 0; j < MatrixTask.N; j++) {
                matrix[i][j] = -10 + random.nextFloat() * 20;
            }
        }
        return matrix;
    }

}
