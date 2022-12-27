package org.example.faang;

public class Fibonaccy {

    public static void main1(String[] args) {

        int n = 10, firstTerm = 0, secondTerm = 1;
        System.out.println("Fibonacci Series till " + n + " terms:");

        for (int i = 1; i <= n; ++i) {
            System.out.print(firstTerm + ", ");

            // compute the next term
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
    }

    static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String args[]) {
        int N = 10;

        for (int i = 0; i < N; i++) {
            System.out.print(fib(i) + " ");
        }
    }
}
