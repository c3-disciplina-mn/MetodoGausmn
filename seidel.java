import java.util.Arrays;

public class seidel {
    public static void main(String[] args) {
        double[][] A = {{ 0.02, 0.01, 0.03 },
                        { 0.03, 0.02, 0.01 },
                        { 0.01, 0.02, 0.02 }};
        double[] b = { 0.08, 0.07, 0.10 };
        double[] x = { 0, 0, 0 };
        double[] x0 = { 0, 0, 0 };
        int iterations = 0;
        double epsilon = 1e-4;
        int cp = 50;
        boolean isConverged = false;

        while (!isConverged && iterations < cp) {
            for (int i = 0; i < A.length; i++) {
                double sum = b[i];
                for (int j = 0; j < A.length; j++) {
                    if (j != i) {
                        sum -= A[i][j] * x[j];
                    }
                }
                x[i] = sum / A[i][i];
            }

            isConverged = true;
            for (int i = 0; i < A.length; i++) {
                if (Math.abs(x[i] - x0[i]) > epsilon) {
                    isConverged = false;
                    break;
                }
            }

            iterations++;
            System.arraycopy(x, 0, x0, 0, x.length);
        }

        if (iterations == cp) System.out.println("cp máximo atingido");
        
        System.out.println("Solução: " + Arrays.toString(x));
        System.out.println("Quantidade de iterações: " + iterations);
    }
}