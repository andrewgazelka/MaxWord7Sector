package com.andrewgazelka.maxword7sector;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;

public class MaxWord7Sector {
    public static void main(String[] args) throws IOException {

        for (int maxClocks = 1; maxClocks < 23; maxClocks++)
        {
            Path worldsFile = Paths.get("words.txt");
            BufferedReader reader = Files.newBufferedReader(worldsFile);

            Instant start = Instant.now();
            int finalMaxClocks = maxClocks;
            WordCalculation max = reader
                    .lines()
                    .parallel()
                    .map(line -> new WordCalculation(line, finalMaxClocks))
                    .filter(calc -> calc.getValue() != null)
                    .max(Comparator.comparingInt(word -> word.getValue().getCharCount()))
                    .get();

            Instant end = Instant.now();

            System.out.println("-----------------------------------");
            System.out.printf("Max Clocks: %d\n", maxClocks);
            System.out.printf("Longest Word: %s\n\n", max.getString());
            System.out.printf("Duration (ms): %d\n", Duration.between(start,end).toMillis());
            System.out.printf("Chars: %d\n", max.getValue().getCharCount());
            System.out.println("-----------------------------------");
        }
    }
}
