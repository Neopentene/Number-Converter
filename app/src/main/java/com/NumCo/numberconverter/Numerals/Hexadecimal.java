package com.NumCo.numberconverter.Numerals;

public class Hexadecimal extends Numeral {

    public Hexadecimal(String hexadecimal) {
        super(hexadecimal);
    }

    public String toDec() {
        return "" + Long.parseLong(value, 16);
    }

    public String toBin() {
        return Long.toBinaryString(Long.parseLong(value, 16));
    }

    public String toOct() {
        return Long.toOctalString(Long.parseLong(value, 16));
    }

}
