package com.NumCo.numberconverter.Numerals;

public class Binary extends Numeral {

    public Binary(String binary) {
        super(binary);
    }

    public String toDec() {
        return Long.toString(Long.parseLong(value, 2));
    }

    public String toHex() {
        return Long.toHexString(Long.parseLong(value, 2));
    }

    public String toOct() {
        return Long.toOctalString(Long.parseLong(value, 2));
    }

}
