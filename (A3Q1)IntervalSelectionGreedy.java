import java.util.*;
class Interval2 {
    int start, end;
    Interval2(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class A3Q1IntervalSelectionGreedy {
    public static class Interval2Comparator implements Comparator<Interval2> {
        @Override
        public int compare(Interval2 i1, Interval2 i2) {
            return Integer.compare(i1.end, i2.end);
        }
    }
    public static List<Interval2> findMaximalSetOfInterval2s(List<Interval2> Interval2s) {
        Interval2s.sort(new Interval2Comparator());
        List<Interval2> result = new ArrayList<>();
        int n = Interval2s.size();
        int lastEndTime = Integer.MIN_VALUE;
        for (Interval2 Interval2 : Interval2s) {
            if (Interval2.start >= lastEndTime) {
                result.add(Interval2);
                lastEndTime = Interval2.end;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of Interval2s: ");
        int n = scanner.nextInt();
        List<Interval2> Interval2s = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter start and end of Interval2 " + (i + 1) + ": ");
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            Interval2s.add(new Interval2(start, end));
        }
        List<Interval2> result = findMaximalSetOfInterval2s(Interval2s);
        System.out.println("The maximal set of mutually compatible Interval2s is:");
        for (Interval2 Interval2 : result) {
            System.out.println("[" + Interval2.start + ", " + Interval2.end + "]");
        }
        scanner.close();
    }
}