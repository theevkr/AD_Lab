import java.util.*;
class Item {
    int weight;
    int profit;
    double ratio;
    Item(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
        this.ratio = (double) profit / weight;
    }
}
public class A3Q2FractionalKnapsack {
    public static double getMaxProfit(List<Item> items, int capacity) {
        items.sort((i1, i2) -> Double.compare(i2.ratio, i1.ratio));
        double totalProfit = 0.0;
        int remainingCapacity = capacity;
        for (Item item : items) {
            if (remainingCapacity == 0) {
                break;
            }
            if (item.weight <= remainingCapacity) {
                totalProfit += item.profit;
                remainingCapacity -= item.weight;
            } else {
                totalProfit += item.ratio * remainingCapacity;
                remainingCapacity = 0;
            }
        }
        return totalProfit;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = scanner.nextInt();
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight and profit of item " + (i + 1) + ": ");
            int weight = scanner.nextInt();
            int profit = scanner.nextInt();
            items.add(new Item(weight, profit));
        }
        System.out.print("Enter knapsack capacity: ");
        int capacity = scanner.nextInt();
        double maxProfit = getMaxProfit(items, capacity);
        System.out.println("The maximum profit is: " + maxProfit);
        scanner.close();
    }
}