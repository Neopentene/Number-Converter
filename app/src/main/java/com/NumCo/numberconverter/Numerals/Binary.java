package com.NumCo.numberconverter.Numerals;

public class Binary extends Numeral {
    private String binary;

    public Binary(String binary) {
        super(binary);
        this.binary = binary;
    }

    public String toDec() {
        return Integer.toString(Integer.parseInt(binary, 2));
    }

    public String toHex() {
        return Integer.toHexString(Integer.parseInt(binary, 2));
    }

    public String toOct() {
        return Integer.toOctalString(Integer.parseInt(binary, 2));
    }

}
