import java.util.Scanner;
public class A7Q2 {
    public static int[][] lcsLength(char[] X, char[] Y) {
        int m = X.length;
        int n = Y.length;
        int[][] c = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            c[i][0] = 0;
        for (int j = 0; j <= n; j++)
            c[0][j] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X[i - 1] == Y[j - 1])
                    c[i][j] = c[i - 1][j - 1] + 1;
                else
                    c[i][j] = Math.max(c[i][j - 1], c[i - 1][j]);
            }
        }
        return c;
    }
    public static String longestCommonSubsequence(int[][] c, char[] X, char[] Y) {
        int i = X.length;
        int j = Y.length;
        StringBuilder lcs = new StringBuilder();
        while (i > 0 && j > 0) {
            if (X[i - 1] == Y[j - 1]) {
                lcs.insert(0, X[i - 1]);
                i--;
                j--;
            } else if (c[i - 1][j] > c[i][j - 1])
                i--;
            else
                j--;
        }
        return lcs.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sequence X: ");
        String x = sc.nextLine();
        System.out.print("Enter sequence Y: ");
        String y = sc.nextLine();
        char[] X = x.toCharArray();
        char[] Y = y.toCharArray();
        int[][] c = lcsLength(X, Y);
        String lcs = longestCommonSubsequence(c, X, Y);
        System.out.println("Longest Common Subsequence: " + lcs);
    }
}