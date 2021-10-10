package com.iuhaynad.java_crossesandnulls;

import android.app.Application;

public class Checkers extends Application {

    private static boolean isCross;
    public static void setIsCross(boolean newValue) {
        isCross = newValue;
    }
    public static boolean getIsCross() {
        return isCross;
    }

    private static boolean firstOpening = true;
    public static void setFirstOpening(boolean newValue) {
        firstOpening = newValue;
    }
    public static boolean getFirstOpening() {
        return firstOpening;
    }

    private static byte gameStatus;
    // 1 - draw, restart
    // 2 - x win, restart
    // 3 - o win, restart
    public static void setGameStatus(byte newValue) {
        gameStatus = newValue;
    }
    public static byte getGameStatus() {
        return gameStatus;
    }
}
