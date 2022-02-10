package com.NumCo.numberconverter.Numerals;

public class Decimal extends Numeral {

    private String decimal;

    public Decimal(String decimal) {
        super(decimal);
        this.decimal = decimal;
    }

    public String toHex() {
        return Long.toHexString(Long.parseLong(decimal));
    }

    public String toBin() {
        return Long.toBinaryString(Long.parseLong(decimal));
    }

    public String toOct() {
        return Long.toOctalString(Long.parseLong(decimal));
    }

}
