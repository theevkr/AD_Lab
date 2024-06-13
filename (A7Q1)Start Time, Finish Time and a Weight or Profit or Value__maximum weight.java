import java.util.*;
class Interval {
    int start, finish, weight;
    public Interval(int start, int finish, int weight) {
        this.start = start;
        this.finish = finish;
        this.weight = weight;
    }
}
public class A7Q1 {
    public static int maxWeightSubset(Interval[] Intervals) {
        Arrays.sort(Intervals, Comparator.comparingInt(i -> i.finish));
        int n = Intervals.length;
        int[] dp = new int[n];
        dp[0] = Intervals[0].weight;
        for (int i = 1; i < n; i++) {
            int latestCompatible = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (Intervals[j].finish <= Intervals[i].start) {
                    latestCompatible = j;
                    break;
                }
            }
            int include = Intervals[i].weight;
            if (latestCompatible != -1) {
                include += dp[latestCompatible];
            }
            dp[i] = Math.max(include, dp[i - 1]);
        }
        return dp[n - 1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Intervals: ");
        int n = sc.nextInt();
        Interval[] Intervals = new Interval[n];
        System.out.println("Enter Intervals in format (start finish weight):");
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int finish = sc.nextInt();
            int weight = sc.nextInt();
            Intervals[i] = new Interval(start, finish, weight);
        }
        int maxWeight = maxWeightSubset(Intervals);
        System.out.println("Maximum weight subset of mutually compatible Intervals: " + maxWeight);
    }
}