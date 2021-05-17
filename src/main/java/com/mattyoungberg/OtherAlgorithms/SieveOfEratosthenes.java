package com.mattyoungberg.OtherAlgorithms;

public class SieveOfEratosthenes {
    /**
     * Steps:
     * 1)   Initialize a boolean array with its size being max+1; the index doubles as the number that's being tested
     *      for primality.
     * 2)   Make all the values of the array true except for 0 and 1 (which are not prime by definition).
     * 3)   Starting at 2, cross off any multiples of it, since they cannot be prime.
     * 4)   Get the next prime number and perform step three with it.
     * 5)   Return the boolean array;
     */

    public static boolean[] sieveOfEratosthenes(int max) {
        boolean[] flags = new boolean[max + 1];

        for(int i = 2; i < flags.length; i++)
            flags[i] = true;

        int prime = 2;

        while (prime <= Math.sqrt(max)) {
            crossOff(flags, prime);
            prime = getNextPrime(flags, prime);
        }

        return flags;
    }

    private static void crossOff(boolean[] flags, int prime) {
        for (int i = prime * prime; i < flags.length; i += prime)
            flags[i] = false;
    }

    private static int getNextPrime(boolean[] flags, int prime) {
        int next = prime + 1;
        while (next < flags.length && !flags[next])
            next++;
        return next;
    }
}
