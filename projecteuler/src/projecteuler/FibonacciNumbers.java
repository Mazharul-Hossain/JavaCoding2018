package projecteuler;

import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/find-nth-fibonacci-number-using-golden-ratio/
// https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
public class FibonacciNumbers {

    int LIMIT = 4000000;
    HashMap<Integer, Long> map = new HashMap<>();

    public static void main(String[] args) {

        final long startTime = System.nanoTime(); // finds runtime

        FibonacciNumbers fSum = new FibonacciNumbers();
        fSum.findAllFiboNumber();

        fSum.printMap();
        fSum.evenSum();

        final long duration = System.nanoTime() - startTime;
        System.out.println("\nRuntime: " + duration / 1000000 + " mS");
    }

    public void printMap() {
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public void evenTermSum() {
        long fiboSum = 0, fiboNumber = 0;

        for (int i = 1; i < LIMIT; i++) {
            fiboNumber = findFiboNumber(i);

            if (fiboNumber > LIMIT) break;

            if ((i % 2) == 0) {
                fiboSum += fiboNumber;
            }
        }
        System.out.println("Sum of Even Valued terms: " + fiboSum);
    }

    public void evenSum() {
        long fiboSum = 0, fiboNumber = 0;

        int i = 1;
        for (; i < LIMIT; i++) {
            fiboNumber = findFiboNumber(i);

            if ((fiboNumber % 2) == 0) {
                fiboSum += fiboNumber;
            }
            if (fiboNumber > LIMIT) break;
        }
        System.out.println("Up to " + i + "th Even Valued terms: " + fiboNumber + " Sum: " + fiboSum + " Less than " + Long.MAX_VALUE);
    }

    public void findAllFiboNumber() {
        // setting up base case
        map.put(0, (long) 0);
        map.put(1, (long) 1);
        map.put(2, (long) 1);

        int n = 80;
        for (int i = 3; i < n; i++) {
            findFiboNumber(i);
        }
    }

    // return nth Fibonacci numbers
    public long findFiboNumber(int n) {
        int k = 0;
        long fiboNumber = 0, fiboNumber1, fiboNumber2;
        if (map.containsKey(n)) {
            fiboNumber = map.get(n);
        } else {
            if ((n % 2) == 1) {
                k = (n + 1) / 2;

                fiboNumber1 = findFiboNumber(k - 1);
                fiboNumber2 = findFiboNumber(k);
                fiboNumber = fiboNumber2 * fiboNumber2 + fiboNumber1 * fiboNumber1;
            } else {
                k = n / 2;

                fiboNumber1 = findFiboNumber(k - 1);
                fiboNumber2 = findFiboNumber(k);
                fiboNumber = (2 * fiboNumber1 + fiboNumber2) * fiboNumber2;
            }
            map.put(n, fiboNumber);
        }
        return fiboNumber;
    }
}