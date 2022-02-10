package com.NumCo.numberconverter.Numerals;

public class Decimal extends Numeral {

    private String decimal;

    public Decimal(String decimal) {
        super(decimal);
        this.decimal = decimal;
    }

    public String toHex() {
        return Long.toHexString(Integer.parseInt(decimal));
    }

    public String toBin() {
        return Long.toBinaryString(Integer.parseInt(decimal));
    }

    public String toOct() {
        return Long.toOctalString(Integer.parseInt(decimal));
    }

}
