package com.aldren.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int[] A = {1,1,1,1,1,1};

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
                    System.out.println(true);
                }

                requests.clear();
            }
        }

        System.out.println(false);
    }

}
