package class03_hashtable;

public class Code03_HappyNum {
    public int turn(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (int) Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do {
            fast = turn(fast);
            fast = turn(fast);
            slow = turn(slow);
        } while (fast != slow);
        return slow == 1;
    }

    public static void main(String[] args) {

    }
}
