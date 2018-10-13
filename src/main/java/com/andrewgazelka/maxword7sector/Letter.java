package com.andrewgazelka.maxword7sector;

import java.util.Optional;

public class Letter {

    private final Integer value;
    private final char c;

    public Letter(char c) {
        this.c = c;
        value = calcValue();
    }

    public char getChar() {
        return c;
    }

    public Integer getValue() {
        return value;
    }

    /**
     * @return How many can have on one seven-segment display. null if DNE
     */
    private Integer calcValue() {
        switch (c) {
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'j':
            case 'n':
            case 'o':
            case 'p':
            case 'q': //a '9' so...
            case 'r':
            case 's':
            case 'u':
            case 'v': // a 'u' ...
            case 'y':
            case 'z': // a '2' ...
                return 1;
            case 'i':
            case 'l': // kinda could be 1 too
                return 2;
            default:
                return null;
        }
    }
}
