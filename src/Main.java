import java.nio.charset.StandardCharsets;
import java.util.stream.*;
import java.util.Random;
import java.util.Arrays;

public class Main {
    private static final double GRAVITY = -9.81;

    public static void main(String[] args) {
        // Exercise 1

//		double initialVelocity = 0.0;
//		double fallingTime = 10.0;
//		double initialPosition = 0.0;
//		double finalPosition = positionCalc(initialVelocity, initialPosition, fallingTime);
//		System.out.println("Pos in "+fallingTime+"sec :"+finalPosition);

        // Exercise 2

//		System.out.println(factorialRecursive(4));
//		System.out.println(factorialForLoop(4));

        // Exercise 3

//        double[] testArr = generateArray(5, 5, 10);
//
//        for (double value : testArr) {
//            System.out.println(value);
//        }
//
//        System.out.println(getMean(testArr));
//        System.out.println(getMin(testArr));
//        System.out.println(getMax(testArr));
//
//        arraySort(testArr);
//
//        for (double value : testArr) {
//            System.out.println(value);
//        }

        // Exercise 4

//        double[][] matrix = generateMatrix(5);
//        for (double[] doubles : matrix) {
//            for (double aDouble : doubles) {
//                System.out.print(aDouble + " ");
//            }
//            System.out.println();
//        }
//
//        double product = getProduct(matrix, 1, 2);
//        System.out.println(product);

        // Exercise 5

//        double[] flips = coinFlip(100);
//
//        for (double value : flips) {
//            System.out.println(value);
//        }
//
//        int[] dices = rollDice(100);
//
//        for (int value : dices) {
//            System.out.println(value);
//        }

        // Exercise 6

//        byte[] bytes = {72, 101, 108, 108, 111, 33, 32, 77, 121, 32, 115, 107, 105, 108, 108, 115, 32, 97, 114, 101,
//                32, 103, 114, 101, 97, 116, 32, 97, 108, 114, 101, 97, 100, 121, 33};
//
//        String string = getTextFromBytes(bytes);
//        System.out.println(string);

        // Exercise 7

//         String triangle = pascalsTriangle(6);
//
//         System.out.println(triangle);

         // Exercise 8

        executeStringEquation("1 - 3 * 18 / 4 + 2");
    }

    static double positionCalc(double initialVelocity, double initialPosition, double fallingTime) {
        return 0.5 * GRAVITY * Math.pow(2, fallingTime) + initialVelocity * fallingTime + initialPosition;
    }

    static int factorialForLoop(int N) {
        int factorial = 1;
        if (N < 0) {
            return 0;
        } else if (N == 0) {
            return 1;
        } else {
            for (int i = 1; i < N + 1; i++) {
                factorial *= i;
            }
        }
        return factorial;
    }

    static int factorialRecursive(int N) {
        if (N < 0) {
            return 0;
        } else if (N == 0) {
            return 1;
        } else {
            return N * factorialRecursive(N - 1);
        }
    }

    public static double[] generateArray(int N, double lower, double upper) throws Exception {
        if (lower >  upper) throw new Exception("Wrong input parameters");
        Random rand = new Random();

        double[] array = new double[N];

        for (int i = 0; i < N; i++) {
            array[i] =  rand.nextDouble(upper - lower) + lower;
        }

        return array;
    }

    public static double getMean(double[] array) throws Exception {
        if (array == null) throw new Exception("Wrong input parameters");
        return DoubleStream.of(array).sum() / array.length;
    }

    public static double getMin(double[] array) throws Exception {
        if (array == null) throw new Exception("Wrong input parameters");

        double temp = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[0]) {
                temp = array[i];
            }
        }

        return temp;
    }

    public static double getMax(double[] array) throws Exception {
        if (array == null) throw new Exception("Wrong input parameters");

        double temp = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[0]) {
                temp = array[i];
            }
        }

        return temp;
    }

    public static void arraySort(double[] array) throws Exception {
        if (array == null) throw new Exception("Wrong input parameters");

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

    }

    public static double[][] generateMatrix(int N) {
        Random rand = new Random();
        double[][] array = new double[N][N];

        for (double[] row : array) {
            Arrays.fill(row, rand.nextDouble());
        }

        return array;
    }

    public static double getProduct(double[][] matrix, int i, int j) {
        double product = 0;
        for (int k = 0; k < matrix.length; k++) {
            product += matrix[i][k] * matrix[k][j];
        }
        return product;
    }

    public static double[] coinFlip(int N) {
        Random rand = new Random();
        double[] array = new double[3];

        for (int i = 0; i < N; i++) {
            int value = rand.nextInt(2);
            if (value == 0) {
                array[0] += 1;
            } else {
                array[1] += 1;
            }
        }

        array[2] = array[0] / array[1];

        return array;
    }

    public static int[] rollDice(int N) {
        Random rand = new Random();
        int[] array = new int[6];

        for (int i = 0; i < N; i++) {
            int number = rand.nextInt((6 - 1) + 1) + 1;
            switch(number) {
                case 1 -> array[0] += 1;
                case 2 -> array[1] += 1;
                case 3 -> array[2] += 1;
                case 4 -> array[3] += 1;
                case 5 -> array[4] += 1;
                case 6 -> array[5] += 1;
            }
        }

        return array;
    }

    public static String getTextFromBytes(byte[] array) {
        return new String(array, StandardCharsets.UTF_8);
    }

    public static String pascalsTriangle(int level) {
        int[] result = new int[level + 1];
        for (int i = 0; i < level + 1; i++) {
            result[i] = factorialRecursive(level) / (factorialRecursive(i) * factorialRecursive(level - i));
        }

        return Arrays.toString(result);
    }

    public static void executeStringEquation(String inputEquation) {
        String[] test = inputEquation.split(" ");
        for (String value : test) {
            System.out.println(value);
        }
    }
}
