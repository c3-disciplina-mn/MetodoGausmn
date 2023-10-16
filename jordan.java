public class jordan {
    public static void main(String[] args) {
        double[][] A = {{ 0.02, 0.01, 0.03, 0.08 },
                        { 0.03, 0.02, 0.01, 0.07 },
                        { 0.01, 0.02, 0.02, 0.10 }};
        int n = A.length;
        int count = 0;

        for (int i = 0; i < n; i++) {

            double divisor = A[i][i];
            for (int j = i; j < n + 1; j++) {
                A[i][j] /= divisor;
                count++;
            }

            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = A[k][i];
                    for (int j = i; j < n + 1; j++) {
                        A[k][j] -= factor * A[i][j];
                        count++;
                    }
                }
            }
        }

        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = A[i][n];
        }

        System.out.println("Solução:");
        for (int i = 0; i < n; i++) {
            System.out.printf("x%d = %.2f\n", i + 1, x[i]);
        }

        System.out.println("Operações realizadas: " + count);
    }
}