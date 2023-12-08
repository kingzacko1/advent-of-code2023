package main.java;

import java.util.Arrays;

public class Day2 {
    private static final int MAX_RED = 12;
    private static final int MAX_GREEN = 13;
    private static final int MAX_BLUE = 14;
    private static final String RED = "red";
    private static final String GREEN = "green";
    private static final String BLUE = "blue";

    public static void main(String[] args) {
        int idSum = Arrays.stream(PUZZLE_INPUT.split("\n"))
                .map(Day2::part1)
                .filter(val -> val > 0)
                .mapToInt(Integer::intValue)
                .sum();
        int squareSum = Arrays.stream(PUZZLE_INPUT.split("\n"))
                .map(Day2::part2)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Part 1 Sum: " + idSum);
        System.out.println("Part 2 Sum: " + squareSum);
    }

    private static int part1(String line) {
        int colonIndex = line.indexOf(":");
        int gameID = Integer.parseInt(line.substring(5, colonIndex));
        String gameResultsLine = line.substring(colonIndex+2);
        String[] gameResults = gameResultsLine.split("; ");
        for (String result: gameResults) {
            String[] colorResults = result.split(", ");
            for (String colorResult : colorResults) {
                String[] numColor = colorResult.split(" ");
                int num = Integer.parseInt(numColor[0]);
                String color = numColor[1];
                switch (color) {
                    case RED:
                        if (num > MAX_RED) return -1;
                        break;
                    case GREEN:
                        if (num > MAX_GREEN) return -1;
                        break;
                    case BLUE:
                        if (num > MAX_BLUE) return -1;
                        break;
                    default:
                        System.out.println("What did you do wrong here? " + line);
                }
            }
        }
        return gameID;
    }

    private static int part2(String line) {
        int colonIndex = line.indexOf(":");
        String gameResultsLine = line.substring(colonIndex+2);
        String[] gameResults = gameResultsLine.split("; ");
        int minRed = 0;
        int minGreen = 0;
        int minBlue = 0;
        for (String result: gameResults) {
            String[] colorResults = result.split(", ");
            for (String colorResult : colorResults) {
                String[] numColor = colorResult.split(" ");
                int num = Integer.parseInt(numColor[0]);
                String color = numColor[1];
                switch (color) {
                    case RED:
                        if (minRed == 0 || num > minRed) minRed = num;
                        break;
                    case GREEN:
                        if (minGreen == 0 || num > minGreen) minGreen = num;
                        break;
                    case BLUE:
                        if (minBlue == 0 || num > minBlue) minBlue = num;
                        break;
                    default:
                        System.out.println("What did you do wrong here? " + line);
                }
            }
        }
        return minRed * minGreen * minBlue;
    }

    private static final String PUZZLE_INPUT = "Game 1: 2 green, 6 blue, 7 red; 12 green, 6 blue, 3 red; 5 red, 18 green, 4 blue\n" +
            "Game 2: 10 green, 4 red; 2 red; 12 green, 11 red, 1 blue; 1 blue, 11 red, 5 green; 10 red, 9 green, 1 blue\n" +
            "Game 3: 3 green; 15 red, 7 blue, 1 green; 3 red, 6 blue, 1 green; 14 blue, 13 red, 2 green; 1 green, 6 blue, 6 red; 16 red, 13 blue, 2 green\n" +
            "Game 4: 5 blue; 8 blue, 7 red; 9 blue, 5 red, 4 green; 4 red, 1 green; 8 red, 6 blue; 2 blue, 4 red, 3 green\n" +
            "Game 5: 3 blue, 4 red, 10 green; 13 green, 8 blue, 2 red; 2 red, 4 green, 6 blue; 3 blue, 5 green, 2 red; 4 red, 13 blue, 8 green; 9 green, 2 red\n" +
            "Game 6: 3 red, 2 blue; 6 green, 13 blue; 11 blue, 1 red; 4 green, 3 red, 5 blue\n" +
            "Game 7: 14 green, 2 red, 5 blue; 4 blue, 8 green; 2 red, 2 green, 9 blue\n" +
            "Game 8: 10 green, 6 blue; 3 green, 4 red; 7 blue, 7 red, 5 green; 1 red, 11 green; 3 blue, 2 red, 11 green\n" +
            "Game 9: 4 blue, 1 green, 6 red; 5 red, 5 blue; 1 blue, 7 red; 4 red, 8 blue; 6 red\n" +
            "Game 10: 3 green, 7 blue, 6 red; 1 red, 5 blue; 6 red; 1 red, 5 green, 6 blue; 5 red, 2 blue; 6 red, 4 blue, 6 green\n" +
            "Game 11: 8 red, 6 blue, 6 green; 5 blue, 2 red, 5 green; 4 blue, 5 green; 4 blue, 3 red, 8 green\n" +
            "Game 12: 5 green, 1 red, 7 blue; 1 red, 10 green; 6 red, 3 green, 7 blue; 5 red, 6 blue, 7 green; 3 blue, 4 green; 1 red, 3 blue, 3 green\n" +
            "Game 13: 11 red, 9 blue, 16 green; 1 red, 3 green, 3 blue; 14 green, 2 red, 7 blue\n" +
            "Game 14: 4 red, 8 blue, 12 green; 7 blue, 4 red, 2 green; 4 blue, 7 green, 6 red; 3 red, 11 blue, 12 green\n" +
            "Game 15: 6 red; 3 red, 5 blue; 3 red, 10 blue, 1 green; 2 green, 8 red, 2 blue\n" +
            "Game 16: 2 green, 4 red, 6 blue; 2 green, 16 blue, 2 red; 13 blue, 7 green, 3 red\n" +
            "Game 17: 5 blue; 1 blue; 2 red, 2 green, 4 blue; 6 blue, 4 green, 2 red\n" +
            "Game 18: 3 red; 7 green, 11 red, 6 blue; 6 red, 3 blue, 12 green; 5 red, 3 blue; 7 green, 8 red, 9 blue\n" +
            "Game 19: 2 green, 13 blue; 11 blue, 16 red, 7 green; 13 blue, 10 green, 8 red; 18 red, 1 green, 14 blue\n" +
            "Game 20: 10 red, 6 green; 1 blue, 6 red, 15 green; 15 green, 9 red, 3 blue; 3 blue, 11 red, 9 green; 2 blue, 5 red, 10 green\n" +
            "Game 21: 1 green, 5 red, 8 blue; 4 red, 6 green, 7 blue; 13 blue, 10 green, 6 red; 9 blue, 2 red, 14 green; 16 green, 10 blue, 1 red; 9 blue, 3 red, 11 green\n" +
            "Game 22: 4 blue; 1 green, 1 red, 16 blue; 15 blue, 1 red\n" +
            "Game 23: 2 blue, 6 green; 15 green, 2 blue, 10 red; 1 green, 6 blue, 6 red; 8 red, 1 green; 4 green, 3 blue, 10 red; 7 red, 3 blue, 20 green\n" +
            "Game 24: 1 red, 13 blue, 8 green; 3 blue, 7 red, 8 green; 3 red, 11 green, 12 blue; 7 green, 6 blue, 2 red; 11 blue, 5 red, 10 green; 13 blue, 3 green, 8 red\n" +
            "Game 25: 4 red, 6 green, 8 blue; 4 red, 10 blue, 9 green; 5 red, 2 blue, 3 green; 2 green, 9 red, 4 blue\n" +
            "Game 26: 14 red, 4 green, 5 blue; 3 blue, 2 red, 3 green; 1 red, 9 blue, 1 green; 5 green, 15 red, 8 blue; 5 green, 6 red, 6 blue\n" +
            "Game 27: 1 blue, 1 green, 9 red; 4 green, 1 blue, 1 red; 4 green, 4 red; 5 green, 4 red; 1 green, 1 blue, 8 red; 9 red\n" +
            "Game 28: 11 red, 3 blue, 19 green; 3 green, 13 red, 5 blue; 8 blue, 16 red, 18 green; 13 red, 5 blue, 7 green; 8 red, 5 green, 4 blue; 16 green, 1 blue, 15 red\n" +
            "Game 29: 12 red, 15 blue, 1 green; 3 green, 10 red, 5 blue; 4 green, 5 blue, 17 red; 11 red, 2 blue; 6 blue, 3 green, 4 red; 1 blue, 13 red\n" +
            "Game 30: 2 blue, 2 green, 3 red; 1 green, 4 red; 1 red, 2 blue; 1 green, 1 blue, 2 red\n" +
            "Game 31: 3 green, 5 blue, 4 red; 3 red, 1 green; 3 blue, 4 red, 3 green; 8 blue, 8 red; 6 blue; 1 green, 6 blue, 1 red\n" +
            "Game 32: 3 blue, 12 green, 2 red; 13 red, 12 green, 4 blue; 9 green, 1 red; 10 red; 12 green, 9 red; 15 red, 3 blue, 10 green\n" +
            "Game 33: 1 green, 8 blue; 3 red, 7 green; 4 red, 3 green; 5 red, 9 green\n" +
            "Game 34: 12 blue, 3 red, 2 green; 12 blue, 12 green, 2 red; 10 blue, 8 green; 3 red, 3 green, 9 blue\n" +
            "Game 35: 4 red, 4 blue, 6 green; 3 blue, 8 green, 2 red; 5 green, 2 red, 2 blue\n" +
            "Game 36: 12 blue, 4 red, 5 green; 18 blue, 2 red, 5 green; 2 green, 2 red; 3 red, 9 green, 13 blue; 2 green, 12 blue, 1 red\n" +
            "Game 37: 8 red, 3 blue; 6 blue, 5 red; 9 red, 10 blue, 3 green; 4 green, 10 red\n" +
            "Game 38: 1 green, 3 blue, 7 red; 6 blue, 6 green, 9 red; 5 green\n" +
            "Game 39: 7 red, 1 blue, 1 green; 5 red, 2 blue, 3 green; 9 red, 9 blue; 5 red, 3 green, 1 blue; 1 green, 9 red, 1 blue\n" +
            "Game 40: 1 blue, 1 green, 3 red; 3 red, 2 green, 2 blue; 5 red, 1 blue, 8 green; 2 green, 4 red, 2 blue; 13 red, 2 green\n" +
            "Game 41: 17 blue, 5 red, 3 green; 10 green, 4 red, 5 blue; 3 red, 17 blue, 1 green; 11 blue, 10 red, 3 green\n" +
            "Game 42: 8 blue, 2 green, 7 red; 4 blue, 1 red; 9 red, 2 green, 6 blue; 4 blue, 9 red; 1 green, 9 blue, 8 red; 6 red, 1 green\n" +
            "Game 43: 1 green, 6 blue, 14 red; 7 green, 1 blue, 8 red; 3 green, 16 red, 7 blue\n" +
            "Game 44: 5 red, 5 blue; 1 green, 8 red, 9 blue; 6 red, 3 blue\n" +
            "Game 45: 4 green, 17 red, 14 blue; 14 red, 2 green, 2 blue; 9 blue, 1 green, 8 red\n" +
            "Game 46: 1 blue, 10 red, 7 green; 3 red, 4 blue; 2 blue, 1 green, 1 red\n" +
            "Game 47: 8 red, 2 green, 13 blue; 10 red, 9 blue; 4 green, 15 blue, 2 red; 1 blue, 1 green, 16 red\n" +
            "Game 48: 9 red, 8 green, 1 blue; 10 green, 5 red; 9 red, 3 green, 1 blue; 8 red, 1 green\n" +
            "Game 49: 11 blue, 18 green, 1 red; 13 red, 9 blue; 17 green, 18 red, 6 blue\n" +
            "Game 50: 2 green, 10 red, 6 blue; 6 red, 6 blue, 7 green; 7 red, 5 green, 3 blue; 5 green, 2 red, 1 blue\n" +
            "Game 51: 1 blue, 9 green, 7 red; 2 blue, 11 red, 10 green; 1 blue, 9 green, 12 red; 10 red, 5 green, 3 blue; 9 green, 3 blue, 14 red\n" +
            "Game 52: 4 green; 6 blue; 4 green, 7 blue; 1 blue; 1 red, 8 green, 1 blue\n" +
            "Game 53: 6 green, 3 blue, 13 red; 3 blue, 2 green, 16 red; 13 red, 9 green, 2 blue; 1 red, 1 blue, 7 green\n" +
            "Game 54: 1 green, 4 blue, 10 red; 2 red, 6 blue; 2 blue, 5 red; 3 blue, 7 red, 1 green\n" +
            "Game 55: 17 red; 18 red, 3 blue, 4 green; 5 blue, 14 red, 1 green; 4 green, 5 blue, 4 red; 2 green, 18 red\n" +
            "Game 56: 14 green, 2 red, 18 blue; 8 green, 12 blue, 2 red; 1 red, 13 blue, 12 green\n" +
            "Game 57: 2 green, 4 blue, 12 red; 1 green, 3 red, 4 blue; 4 green, 2 red, 3 blue; 3 green, 6 red; 3 red, 3 blue, 3 green\n" +
            "Game 58: 2 blue, 5 red, 2 green; 6 red, 6 green; 8 red, 11 green, 2 blue; 9 green, 1 blue, 11 red; 2 blue, 17 green, 11 red; 7 red, 8 green, 2 blue\n" +
            "Game 59: 4 blue, 1 red, 16 green; 2 blue, 5 green, 1 red; 2 green, 6 blue; 3 blue, 10 green; 14 green, 6 blue; 1 red, 11 green\n" +
            "Game 60: 4 red, 1 blue, 5 green; 2 green, 6 blue; 1 red, 17 green; 2 red, 11 blue, 14 green; 2 red, 8 blue, 14 green\n" +
            "Game 61: 6 red, 7 blue, 1 green; 2 red, 10 green, 16 blue; 14 blue, 10 green, 7 red; 12 red, 15 blue, 3 green; 5 blue, 1 red\n" +
            "Game 62: 9 blue, 4 red; 1 green, 2 blue, 4 red; 8 red, 9 blue; 6 red, 15 blue; 7 blue, 10 red\n" +
            "Game 63: 8 green, 2 red, 4 blue; 2 red, 1 green, 3 blue; 1 red, 3 green; 2 blue, 9 green\n" +
            "Game 64: 4 green, 13 red; 2 red, 6 green, 2 blue; 4 red, 6 green, 2 blue; 6 red, 2 blue; 5 red, 9 green; 3 red, 1 blue, 10 green\n" +
            "Game 65: 8 blue, 3 red, 3 green; 6 red, 8 green; 6 blue, 7 green, 7 red\n" +
            "Game 66: 6 red, 2 blue, 2 green; 15 green, 11 red, 1 blue; 1 red, 2 blue, 10 green; 2 blue, 17 green; 12 green, 2 blue, 4 red; 16 green, 10 red, 3 blue\n" +
            "Game 67: 1 green, 2 red, 12 blue; 2 red, 3 blue, 3 green; 8 blue, 4 green, 1 red; 12 blue, 2 red, 4 green; 2 red, 10 blue\n" +
            "Game 68: 6 red, 4 green, 16 blue; 9 red, 7 green, 11 blue; 7 blue, 16 green, 15 red; 2 red, 2 green; 16 red; 13 red, 15 green, 2 blue\n" +
            "Game 69: 14 red, 3 blue, 14 green; 4 blue, 18 green, 2 red; 4 green, 9 blue, 7 red; 15 green, 9 blue, 10 red\n" +
            "Game 70: 2 green, 5 red, 12 blue; 3 green, 5 red, 4 blue; 5 blue, 4 red; 6 red, 11 blue; 5 red, 2 blue; 5 blue, 1 green, 4 red\n" +
            "Game 71: 3 green, 3 red; 6 green, 11 blue, 2 red; 6 red, 4 blue\n" +
            "Game 72: 9 blue, 4 green, 4 red; 5 blue, 5 red, 3 green; 9 blue, 11 green, 3 red\n" +
            "Game 73: 1 blue, 13 red; 12 red; 5 red, 1 green, 6 blue; 5 blue, 7 red; 8 red, 9 blue\n" +
            "Game 74: 7 green, 17 red, 3 blue; 15 red, 2 green; 5 red, 3 blue, 1 green; 19 red, 1 blue; 3 red, 1 blue, 6 green; 7 red, 3 blue, 1 green\n" +
            "Game 75: 11 blue, 9 green, 4 red; 5 green, 2 red, 16 blue; 13 blue, 2 red; 3 red, 18 blue, 1 green\n" +
            "Game 76: 5 green, 13 red, 10 blue; 5 red, 11 green; 1 red, 5 green, 8 blue; 4 red, 14 green; 7 blue, 12 green, 2 red\n" +
            "Game 77: 5 blue, 2 green, 3 red; 2 red; 1 green, 6 blue; 5 blue, 1 red\n" +
            "Game 78: 9 red, 7 green; 10 red, 2 blue, 6 green; 13 red, 3 blue, 15 green; 9 blue, 10 green, 2 red; 1 blue, 4 red, 12 green\n" +
            "Game 79: 4 red, 3 green; 3 blue, 10 green, 4 red; 1 red, 12 green, 7 blue; 5 blue, 3 green, 6 red; 10 green, 1 blue, 5 red; 5 green, 5 red\n" +
            "Game 80: 3 blue, 18 green; 5 blue, 11 green, 3 red; 2 blue, 13 green, 7 red; 4 red, 1 blue, 8 green\n" +
            "Game 81: 9 green, 18 blue, 10 red; 6 red, 5 green, 13 blue; 8 red, 4 blue, 7 green\n" +
            "Game 82: 9 green, 2 red, 2 blue; 7 green, 2 red, 1 blue; 2 green, 2 red, 2 blue; 2 red, 14 green, 1 blue\n" +
            "Game 83: 10 red, 7 green, 3 blue; 4 green, 12 red, 12 blue; 13 blue, 1 green, 8 red\n" +
            "Game 84: 10 green, 3 blue; 8 green, 2 red; 3 blue, 5 green; 3 blue, 1 green; 5 blue, 7 green, 1 red; 8 green, 5 blue, 2 red\n" +
            "Game 85: 6 blue, 4 green, 5 red; 11 green, 1 blue, 13 red; 11 green, 1 red; 6 green, 2 red; 1 blue, 5 green, 4 red\n" +
            "Game 86: 1 blue, 10 red; 2 blue, 5 red; 1 red, 2 blue, 2 green\n" +
            "Game 87: 11 green, 13 red, 6 blue; 8 blue, 2 red, 6 green; 10 blue, 11 red, 1 green; 16 green, 16 blue, 6 red; 6 green, 12 red, 3 blue\n" +
            "Game 88: 15 green, 4 red, 2 blue; 6 red, 13 green, 4 blue; 3 green, 17 red, 4 blue; 4 blue, 14 green\n" +
            "Game 89: 6 green, 12 red, 7 blue; 3 blue, 6 green, 7 red; 6 green, 13 red, 5 blue; 6 red, 7 green\n" +
            "Game 90: 19 blue, 19 red; 6 blue, 12 red, 6 green; 2 green, 7 blue, 17 red; 3 green, 9 blue, 7 red; 8 red, 7 green, 18 blue\n" +
            "Game 91: 3 red, 1 green; 14 red, 2 blue, 2 green; 7 red, 3 blue; 1 blue, 6 red\n" +
            "Game 92: 2 green, 16 red, 15 blue; 3 green, 3 blue, 11 red; 7 blue, 6 red; 7 blue, 13 red\n" +
            "Game 93: 1 red, 1 blue, 9 green; 12 green, 3 red, 4 blue; 3 green, 3 red, 7 blue\n" +
            "Game 94: 12 green, 5 red, 9 blue; 3 blue, 3 green, 2 red; 5 green, 2 blue; 5 green, 7 red, 10 blue; 7 red, 10 blue, 10 green\n" +
            "Game 95: 3 blue, 15 red, 10 green; 3 blue, 16 red; 1 blue, 13 green, 6 red\n" +
            "Game 96: 11 blue, 2 green, 5 red; 2 green, 10 red, 15 blue; 11 blue, 19 red, 8 green\n" +
            "Game 97: 7 green, 2 red, 1 blue; 5 red, 3 blue, 12 green; 4 blue, 2 green, 3 red\n" +
            "Game 98: 2 green, 5 blue, 9 red; 4 green, 9 blue, 8 red; 7 green, 11 blue, 7 red\n" +
            "Game 99: 2 green, 15 blue, 2 red; 2 red, 6 green, 12 blue; 11 green, 18 blue, 2 red; 3 red, 9 blue, 3 green; 18 blue\n" +
            "Game 100: 13 red, 2 green; 15 red, 1 green; 4 green, 1 blue; 11 red, 5 green; 3 green, 8 red";
}
