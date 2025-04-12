package org.test.java23;

import java.util.List;
import java.util.stream.Gatherer;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

public class GhetherPriewFeature {
	public static void main(String[] args) {
		Stream<Integer> numbers = Stream.of(1, 2, 15, 3, 4, 12, 5, 6, 18, 7, 8, 9);

        List<Integer> gatheredList = numbers.gather(Gatherer.ofSequential((num, downstream) -> {
            if (num < 10) {
                downstream.accept(num); // Accept values less than 10
                return true; // Continue gathering
            }
            return false; // Stop gathering
        })).toList();

        System.out.println(gatheredList);
        // Expected output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
	}
}
