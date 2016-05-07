package com.jam.brookshearCPU.util;

/**
 * Created by Jack on 02-May-16.
 */
public final class Hex {
    private Hex() {};

    public static String toHex(byte byteToConvert) {
        return String.format("%02X", byteToConvert);
    }

    public static String toHex(short shortToConvert) {
        return String.format("%04X", shortToConvert);
    }

    public static String toHex(int intToConvert) {
        return String.format("%08X", intToConvert);
    }
}
