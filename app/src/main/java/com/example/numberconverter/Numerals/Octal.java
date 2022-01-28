package com.example.numberconverter.Numerals;

public class Octal extends Numeral {

    private String octal;

    public Octal(String octal){
        super(octal);
        this.octal = octal;
    }

    public String toHex(){
        return Integer.toHexString(Integer.parseInt(octal, 8));
    }

    public String toBin(){
        return Integer.toBinaryString(Integer.parseInt(octal, 8));
    }

    public String toDec(){
        return Integer.toString(Integer.parseInt(octal, 8));
    }

}
