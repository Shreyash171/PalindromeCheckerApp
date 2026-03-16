import java.util.*;

public class UseCase13PalindromeCheckerApp {

    // Method 1: Two Pointer Approach
    public static boolean twoPointerPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Method 2: Stack Approach
    public static boolean stackPalindrome(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    // Method 3: Deque Approach
    public static boolean dequePalindrome(String str) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        // Two Pointer Timing
        long start1 = System.nanoTime();
        boolean res1 = twoPointerPalindrome(input);
        long end1 = System.nanoTime();

        // Stack Timing
        long start2 = System.nanoTime();
        boolean res2 = stackPalindrome(input);
        long end2 = System.nanoTime();

        // Deque Timing
        long start3 = System.nanoTime();
        boolean res3 = dequePalindrome(input);
        long end3 = System.nanoTime();

        System.out.println("\nResults:");

        System.out.println("Two Pointer Method: " + res1 +
                " | Time: " + (end1 - start1) + " ns");

        System.out.println("Stack Method: " + res2 +
                " | Time: " + (end2 - start2) + " ns");

        System.out.println("Deque Method: " + res3 +
                " | Time: " + (end3 - start3) + " ns");

        sc.close();
    }
}