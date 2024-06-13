import java.util.*;
class HuffmanNode implements Comparable<HuffmanNode> {
    char sym;
    int freq;
    HuffmanNode left, right;
    public HuffmanNode(char sym, int freq) {
        this.sym = sym;
        this.freq = freq;
    }
    @Override
    public int compareTo(HuffmanNode node) {
        return this.freq - node.freq;
    }
}
public class A4Q1 {
    public static HashMap<Character, String> encodemsg(String msg) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : msg.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
        for (char c : freqMap.keySet()) {
            priorityQueue.offer(new HuffmanNode(c, freqMap.get(c)));
        }
        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();
            HuffmanNode parent = new HuffmanNode('\0', left.freq + right.freq);
            parent.left = left;
            parent.right = right;
            priorityQueue.offer(parent);
        }

        HuffmanNode root = priorityQueue.poll();
        HashMap<Character, String> encodingMap = new HashMap<>();
        buildEncodingMap(root, "", encodingMap);

        return encodingMap;
    }

    private static void buildEncodingMap(HuffmanNode node, String code, HashMap<Character, String> encodingMap) {
        if (node == null) return;
        if (node.sym != '\0') {
            encodingMap.put(node.sym, code);
        }
        buildEncodingMap(node.left, code + "0", encodingMap);
        buildEncodingMap(node.right, code + "1", encodingMap);
    }
    public static String encode(String msg, HashMap<Character, String> encodingMap) {
        StringBuilder encMsg = new StringBuilder();
        for (char c : msg.toCharArray()) {
            encMsg.append(encodingMap.get(c));
        }
        return encMsg.toString();
    }
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter a message:");
        String msg = sc.nextLine(); 
        HashMap<Character, String> encodingMap = encodemsg(msg);
        String encMsg = encode(msg, encodingMap);
        System.out.println("Original msg: " + msg);
        System.out.println("Encoded msg: " + encMsg);
        double fix = msg.length() * 8; 
        double huffmanBits = encMsg.length();
        double avg = (fix - huffmanBits) / msg.length();
        System.out.println("Average bits saved per character: " + avg);
    }
}