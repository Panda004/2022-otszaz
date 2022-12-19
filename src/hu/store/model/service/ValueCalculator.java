package hu.store.model.service;

public class ValueCalculator {

    private static final int[] VALUES = {0, 500, 950, 1350};
    private static final int DIFFERENCE = 400;


    public static int value(long db) {
        return ertek((int) db);
    }

    private static int ertek(int count) {
        return count < VALUES.length
                ? VALUES[count]
                : VALUES[VALUES.length - 1] + DIFFERENCE * (count - VALUES.length + 1);
    }
}
