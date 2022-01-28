package com.example.numberconverter.Numerals;

public class Hexadecimal extends Numeral {
    private String hexadecimal;

    public Hexadecimal(String hexadecimal){
        super(hexadecimal);
        this.hexadecimal = hexadecimal;
    }

    public String toDec(){
        return new String("" + Integer.parseInt(hexadecimal, 16));
    }

    public String toBin(){
        return Integer.toBinaryString(Integer.parseInt(hexadecimal, 16));
    }

    public String toOct(){
        return Integer.toOctalString(Integer.parseInt(hexadecimal, 16));
    }

    public String toRMN(){
        return Integer.toHexString(Integer.parseInt(hexadecimal));
    }
}
