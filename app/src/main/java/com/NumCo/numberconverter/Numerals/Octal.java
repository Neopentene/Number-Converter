package com.NumCo.numberconverter.Numerals;

public class Octal extends Numeral {

    public Octal(String octal) {
        super(octal);
    }

    public String toHex() {
        return Long.toHexString(Long.parseLong(value, 8));
    }

    public String toBin() {
        return Long.toBinaryString(Long.parseLong(value, 8));
    }

    public String toDec() {
        return Long.toString(Long.parseLong(value, 8));
    }

}
