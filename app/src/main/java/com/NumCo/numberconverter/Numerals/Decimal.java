package com.NumCo.numberconverter.Numerals;

public class Decimal extends Numeral {

    private String decimal;

    public Decimal(String decimal) {
        super(decimal);
        this.decimal = decimal;
    }

    public String toHex() {
        return Integer.toHexString(Integer.parseInt(decimal));
    }

    public String toBin() {
        return Integer.toBinaryString(Integer.parseInt(decimal));
    }

    public String toOct() {
        return Integer.toOctalString(Integer.parseInt(decimal));
    }

}
