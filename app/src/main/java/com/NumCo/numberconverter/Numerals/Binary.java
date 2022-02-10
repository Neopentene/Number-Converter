package com.NumCo.numberconverter.Numerals;

public class Binary extends Numeral {
    private String binary;

    public Binary(String binary) {
        super(binary);
        this.binary = binary;
    }

    public String toDec() {
        return Long.toString(Integer.parseInt(binary, 2));
    }

    public String toHex() {
        return Long.toHexString(Integer.parseInt(binary, 2));
    }

    public String toOct() {
        return Long.toOctalString(Integer.parseInt(binary, 2));
    }

}
