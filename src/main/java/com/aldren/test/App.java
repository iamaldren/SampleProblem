package com.aldren.test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Random rand = new Random();

        int[] A = new int[20000];
        int count = 1;
        for(int i = 0; i < 20000; i++) {
            A[i] = rand.nextInt(50000);
        }

        /**
         * Original Solution
         */
        Instant start = Instant.now();
        System.out.println(nestedLoop(A));
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Nested Loop --> " + timeElapsed);

        /**
         * Second Solution
         *
         * Instead of removing the items from the List,
         * I'll just be skipping them.
         */
        start = Instant.now();
        System.out.println(secondSolution(A));
        finish = Instant.now();
        timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Second Solution --> " + timeElapsed);

    }

    private static boolean nestedLoop(int[] A) {
        List<Integer> requests = new ArrayList<>();
        for(int i = 0; i < A.length; i++) {
            for(int j = i+1; j < A.length-1; j++) {
                requests = Arrays.stream(A).boxed().collect(Collectors.toList());

                requests.remove(j);
                requests.remove(i);

                int sum = 0;
                for(int k : requests) {
                    sum += k;
                }

                if(sum%3 == 0) {
                    return true;
                }

                requests.clear();
            }
        }

        return false;
    }

    private static boolean secondSolution(int[] A) {
        List<Integer> requests = Arrays.stream(A).boxed().collect(Collectors.toList());
        for(int i = 0; i < A.length; i++) {
            for(int j = i+1; j < A.length-1; j++) {

                int sum = 0;
                int counter = 0;
                for(Integer request : requests) {
                    if(counter != i || counter != j) {
                        sum += request;
                    }
                    counter++;
                }

                if(sum%3 == 0) {
                    return true;
                }

                requests.clear();
            }
        }

        return false;
    }

}
