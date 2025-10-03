import java.lang.Math;


public class JavaLab1 {
    public static double first(double t) {
        return Math.tan(Math.pow((t / (t + 1)), (t / 3)));
    }

    public static double second(double t) {
        double expSin = Math.exp(Math.sin(t));
        return Math.cbrt(expSin);
    }

    public static double third(double t) {
        double part1 = Math.asin(0.5 * (t - 0.5) / 29);
        double part2 = Math.tan((Math.pow(t, 2) * Math.pow(2, t)) / 2);
        double part3 = Math.log((5 + Math.abs(t)) / Math.abs(t));
        double part4 = Math.sin(Math.log(Math.abs(t)));
        double part5 = Math.atan(1 / Math.exp(Math.abs(t))) + 1;

        return Math.pow(part1, part2) * Math.pow(part3, t) * (part4 * part5 / 3);
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%.4f ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] w = new int[16];
        for (int i = 0; i < 16; i++) {
            w[i] = 18 - i;
        }
        float[] x = new float[15];
        for (int i = 0; i < 15; i++) {
            x[i] = (float) (-15.0 + Math.random() * 29.0);
        }
        double[][] f = new double[16][15];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 15; j++) {
                double t = x[j];
                if (w[i] == 15) {
                    f[i][j] = first(t);
                } else if (w[i] == 3 || w[i] == 4 || w[i] == 5 || w[i] == 8 ||
                        w[i] == 9 || w[i] == 14 || w[i] == 16 || w[i] == 18) {
                    f[i][j] = second(t);
                } else {
                    f[i][j] = third(t);
                }
            }
        }
        printMatrix(f);
    }
}