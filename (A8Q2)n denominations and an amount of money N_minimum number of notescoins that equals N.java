import java.util.*;
public class A8Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of denominations: ");
        int n = sc.nextInt();
        int[] dens = new int[n];
        System.out.println("Enter the denominations:");
        for (int i = 0; i < n; i++) {
            dens[i] = sc.nextInt();
        }
        System.out.print("Enter the amount: ");
        int amount = sc.nextInt();
        int result = minNotesCoins(dens, amount);
        System.out.println("Minimum number of notes/coins: " + result);
    }
    static int minNotesCoins(int[] dens, int amount) {
        Arrays.sort(dens);
        int count = 0;
        for (int i = dens.length - 1; i >= 0; i--) {
            int num = amount / dens[i];
            count += num;
            amount -= num * dens[i];
        }
        return count;
    }
}