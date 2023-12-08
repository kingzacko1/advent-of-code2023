package main.java;

import java.util.Arrays;

public class Day3 {

    public static void main(String[] args) {
        part1();
    }

    private static void part1() {
        String[] lines = (String[]) Arrays.stream(EXAMPLE_INPUT.split("\n")).toArray();
        char[][] partMap = new char[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            partMap[i] = lines[i].toCharArray();
        }
        for (int i = 0; i < partMap.length; i++) {
            for (int j = 0; j < partMap[i].length; j++) {
                char thisChar = partMap[i][j];
                if (isDigit(thisChar)) {
                    String numberString = String.valueOf(thisChar);
                    j += 1;
                    //while (part)
                }
            }
        }
    }

    private static boolean isDigit(char c) {
        int intVal = Character.getNumericValue(c);
        return intVal >= 0 && intVal <= 9;
    }

    private static final String EXAMPLE_INPUT = """
            467..114..
            ...*......
            ..35..633.
            ......#...
            617*......
            .....+.58.
            ..592.....
            ......755.
            ...$.*....
            .664.598..
            """;
}

