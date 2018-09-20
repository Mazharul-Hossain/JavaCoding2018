package projecteuler;

public class SmallestMultiple {

    public static void main(String[] args) {

        final long startTime = System.nanoTime(); // finds runtime

        SmallestMultiple smallestMultiple = new SmallestMultiple();
        smallestMultiple.findSmallestMultiple(20);

        final long duration = System.nanoTime() - startTime;
        System.out.println("\nRuntime: " + ((float) duration / 1000000) + " mS");
    }

    public long findGCD(long A, long B) {
        if (A == 0) return B;
        else if (B == 0) return A;
        else if (A > B) return findGCD(B, A % B);
        else return findGCD(A, B % A);
    }

    public void findSmallestMultiple(int N) {
        long product = 1;

        // initializing
        int arrayNum[] = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            arrayNum[i] = i;
        }
        // dividing everyone to just keep the prime factor
        for (int i = 3; i <= N; i++) {
            for (int j = 2; j < i; j++) {
                if ((arrayNum[i] % arrayNum[j]) == 0) arrayNum[i] = arrayNum[i] / arrayNum[j];
            }
        }
        // finding result
        for (int i = 1; i <= N; i++) {
            System.out.println(i + " : " + arrayNum[i]);
            product *= arrayNum[i];
        }
        System.out.println("\nSmallest number that can be divided by each of the numbers from 1 to " + N + " without any remainder is " + product);
    }
}
