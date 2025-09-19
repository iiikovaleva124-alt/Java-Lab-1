import java.lang.Math;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class Lab1 {
    public static void main(String args[]) {
        int[] w = new int[16];
        for (int i = 0; i<16; i++) {
            w[15 - i] = i;
        }
        float[] x = new float[15];
        for (int i = 0; i < 15; i++) {
            x[i] = (float) (-15.0 + Math.random() * 29.0);
        }
        double[][] f = new double[16][15];
        for (int i = 0; i < 16; i++){
            for (int j = 0; j < 15; j++){
                float t = x[j];
                if (w[i] == 15){
                    f[i][j] = Math.tan(Math.pow(t/(t+1), t/3));
                }
                else if (w[i] != 6 && w[i] != 7 && w[i] != 10 && w[i] != 11 && w[i] != 12 && w[i] != 13 && w[i] != 15 && w[i] != 17){
                    f[i][j] = Math.exp((Math.sin(t)/3));
                }
                else{
                    double part1 = Math.asin(0.5 * (t - 0.5) / 29);
                    double part2 = Math.tan((Math.pow(t, 2) * Math.pow(2, t)) / 2);
                    double part3 = Math.log((5 + Math.abs(t)) / Math.abs(t));
                    double part4 = Math.sin(Math.log(Math.abs(t)));
                    double part5 = Math.atan(1 / Math.exp(Math.abs(t))) + 1;

                    double res = Math.pow(part1, part2) * Math.pow(part3, t) * (part4 * part5 / 3);
                    f[i][j] = res;
                }
            }
        }
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 15; j++) {
                String res = new String();
                res = String.format("%.4f", f[i][j]);
                System.out.print(res + " ");
            }
            System.out.println();
        }
    }
}