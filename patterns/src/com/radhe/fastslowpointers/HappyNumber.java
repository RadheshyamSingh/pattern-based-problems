package com.radhe.fastslowpointers;

public class HappyNumber {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = sumSquareNumber(slow);
            fast = sumSquareNumber(sumSquareNumber(fast));
        } while (slow != fast);

        return slow == 1;

    }

    private int sumSquareNumber(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        final HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(23));
        System.out.println(happyNumber.isHappy(12));
    }
}
