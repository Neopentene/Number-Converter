package com.NumCo.numberconverter.Numerals;

public class Decimal extends Numeral {


    public Decimal(String decimal) {
        super(decimal);
    }

    public String toHex() {
        return Long.toHexString(Long.parseLong(value));
    }

    public String toBin() {
        return Long.toBinaryString(Long.parseLong(value));
    }

    public String toOct() {
        return Long.toOctalString(Long.parseLong(value));
    }

}
