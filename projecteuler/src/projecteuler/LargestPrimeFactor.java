package projecteuler;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class LargestPrimeFactor {

    BigInteger LIMIT;
    HashMap<Long, Boolean> map;

    public LargestPrimeFactor() {
        LIMIT = new BigInteger("600851475143");
        map = new HashMap<>();
    }

    public static void main(String[] args) {

        final long startTime = System.nanoTime(); // finds runtime

        LargestPrimeFactor lPF = new LargestPrimeFactor();
        lPF.findAllPrime();
        // lPF.printMap();

        lPF.findLargestPrimeFactor();

        final long duration = System.nanoTime() - startTime;
        System.out.println("\nRuntime: " + duration / 1000000 + " mS");
    }

    public void printMap() {
        for (Map.Entry<Long, Boolean> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public BigInteger sqrt(BigInteger x) {
        BigInteger div = BigInteger.ZERO.setBit(x.bitLength() / 2);
        BigInteger div2 = div;
        // Loop until we hit the same value twice in a row, or wind
        // up alternating.
        for (; ; ) {
            BigInteger y = div.add(x.divide(div)).shiftRight(1);
            if (y.equals(div) || y.equals(div2))
                return y;
            div2 = div;
            div = y;
        }
    }

    public void findAllPrime() {

        long N = sqrt(LIMIT).longValue();
        for (long i = 2; i < N; i++) {
            map.put(i, true);
        }
        for (long i = 2; i < N; i++) {
            if (map.containsKey(i)) {
                for (long j = i * i; j < N; j += i) {
                    map.remove(j);
                }
            }
        }
    }

    public void findLargestPrimeFactor() {
        long maxPrimeFactor = 1, N = sqrt(LIMIT).longValue();
        for (long i = 2; i < N; i++) {
            if (map.containsKey(i)) {
                BigInteger bInteger = LIMIT.remainder(new BigInteger(String.valueOf(i)));
                System.out.println(String.valueOf(i) + " : " + bInteger);
                if (bInteger.intValue() == 0) maxPrimeFactor = i;
            }
        }
        System.out.println(LIMIT.toString() + " LargestPrimeFactor " + maxPrimeFactor);
    }
}
