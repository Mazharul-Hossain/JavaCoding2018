package projecteuler;

public class LargestPalindromeProduct {

    public static void main(String[] args) {

        final long startTime = System.nanoTime(); // finds runtime

        LargestPalindromeProduct largestPalindromeProduct = new LargestPalindromeProduct();
        largestPalindromeProduct.findLargestPalindromeProduct(3);

        final long duration = System.nanoTime() - startTime;
        System.out.println("\nRuntime: " + ((float) duration / 1000000) + " mS");
    }

    public boolean isPalindrome(long number) {
        long reverse = 0, quotient = number;

        while (quotient > 0) {

            long remainder = quotient % 10;
            quotient = quotient / 10;

            reverse = reverse * 10 + remainder;
        }
        System.out.println("number: " + number + " reverse: " + reverse);
        return reverse == number;
    }

    public void findLargestPalindromeProduct(int n) {

        long maxProduct = 0;

        int mult1 = 0, mult2 = 0;

        int upperLimit = (int) Math.pow(10, n) - 1;
        int lowerLimit = (int) Math.pow(10, n - 1);
        System.out.println("upperLimit: " + upperLimit + " lowerLimit: " + lowerLimit);

        for (int i = upperLimit; i >= lowerLimit; i--) {
            for (int j = upperLimit; j >= i; j--) {

                long product = i * j;
                if (product < maxProduct) break;

                if (isPalindrome(product) && product > maxProduct) {
                    maxProduct = product;

                    mult1 = i;
                    mult2 = j;
                }
            }
        }
        System.out.println("\nLargest Palindrome Product: " + maxProduct + " = " + mult1 + " * " + mult2);
    }
}
