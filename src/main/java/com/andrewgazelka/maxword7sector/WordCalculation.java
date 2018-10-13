package com.andrewgazelka.maxword7sector;

public class WordCalculation
{

    private final String string;
    private int maxSectors;
    private Result result;

    public WordCalculation(String string, int maxSectors)
    {
        this.string = string;
        if(maxSectors < string.length()/2)
        {
            return;
        }
        this.maxSectors = maxSectors;
        result = calcSectors();
    }

    public Result getResult()
    {
        return result;
    }

    public String getString()
    {
        return string;
    }

    /**
     * @return Number of seven-segment displays
     */
    public Result getValue()
    {
        return result;
    }

    private Result calcSectors()
    {
        int charCount = 0;
        int sectorCount = 0;

        boolean shortSpace = false;
        for (char c : string.toCharArray())
        {
            Integer value = new Letter(c).getValue();
            if (value == null)
                return null;
            if (value > 1)
            {
                if (shortSpace)
                {
                    charCount += 1;
                    shortSpace = false;
                    continue;
                }
                shortSpace = true;
            } else
            {
                shortSpace = false;
            }

            sectorCount += 1;
            if(sectorCount > maxSectors)
            {
                return null;
            }
            charCount += 1;
        }
        return new Result(charCount,sectorCount);
    }

    public static class Result
    {
        private final int charCount;
        private final int sectors;

        private Result(int charCount, int sectors)
        {
            this.charCount = charCount;
            this.sectors = sectors;
        }

        public int getCharCount()
        {
            return charCount;
        }

        public int getSectors()
        {
            return sectors;
        }
    }

}
