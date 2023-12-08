package main.java;

public class Day6 {
    public static void main(String[] args) {
        long totalWins = waysToWin(46, 208) *
                waysToWin(85, 1412) * waysToWin(75, 1257) * waysToWin(82, 1410);
        long totalWins2 = waysToWin(46857582, 208141212571410L);
        System.out.println("Ways to win multiplied: " + totalWins);
        System.out.println("Ways to win: " + totalWins2);
    }

    private static long waysToWin(long time, long record) {
        long waysToWin = 0;
        // distance = timeHeld*(time-timeHeld)
        for (long timeHeld = 1; timeHeld < time; timeHeld++) {
            if (timeHeld*(time-timeHeld) > record) waysToWin++;
        }
        return waysToWin;
    }
}
