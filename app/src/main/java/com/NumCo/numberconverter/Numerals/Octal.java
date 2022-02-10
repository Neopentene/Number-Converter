package com.NumCo.numberconverter.Numerals;

public class Octal extends Numeral {

    private String octal;

    public Octal(String octal) {
        super(octal);
        this.octal = octal;
    }

    public String toHex() {
        return Long.toHexString(Long.parseLong(octal, 8));
    }

    public String toBin() {
        return Long.toBinaryString(Long.parseLong(octal, 8));
    }

    public String toDec() {
        return Long.toString(Long.parseLong(octal, 8));
    }

}
