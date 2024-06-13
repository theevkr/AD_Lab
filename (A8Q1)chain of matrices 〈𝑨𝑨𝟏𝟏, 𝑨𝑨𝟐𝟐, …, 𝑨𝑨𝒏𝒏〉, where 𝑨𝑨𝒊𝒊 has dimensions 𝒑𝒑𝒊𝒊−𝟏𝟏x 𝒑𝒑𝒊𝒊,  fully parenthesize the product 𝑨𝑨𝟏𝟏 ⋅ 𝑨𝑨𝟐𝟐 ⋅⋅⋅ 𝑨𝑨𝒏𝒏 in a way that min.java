import java.util.Scanner;
public class A8Q1 { 
    static int[][] m;
    static int[][] s;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of matrices: ");
        int n = sc.nextInt();
        
        int[] dim = new int[n + 1];
        System.out.println("Enter the dim of matrices:");
        for (int i = 0; i <= n; i++) {
            dim[i] = sc.nextInt();
        }
        matrixChainOrder(dim);
        System.out.println("Optimal parenthesization:");
        printOptimalParenthesization(1, n);
    }
    static void matrixChainOrder(int[] p) {
        int n = p.length - 1;
        m = new int[n + 1][n + 1];
        s = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
    }
    static void printOptimalParenthesization(int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            printOptimalParenthesization(i, s[i][j]);
            printOptimalParenthesization(s[i][j] + 1, j);
            System.out.print(")");
        }
    }
}