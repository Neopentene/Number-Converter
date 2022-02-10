package com.NumCo.numberconverter.Numerals;

public class Hexadecimal extends Numeral {
    private String hexadecimal;

    public Hexadecimal(String hexadecimal) {
        super(hexadecimal);
        this.hexadecimal = hexadecimal;
    }

    public String toDec() {
        return "" + Long.parseLong(hexadecimal, 16);
    }

    public String toBin() {
        return Long.toBinaryString(Long.parseLong(hexadecimal, 16));
    }

    public String toOct() {
        return Long.toOctalString(Long.parseLong(hexadecimal, 16));
    }

}
