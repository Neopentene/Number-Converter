package com.example.numberconverter.Numerals;

public class RomanNumeral {
    private int decimal;

    public RomanNumeral(String decimal) {
        this.decimal = Integer.parseInt(decimal);
    }

    public String toRmn() {
        StringBuilder str = new StringBuilder();
        DataStore arr[] = new DataStore[19];

        arr[0] = new DataStore(1000000, "M̅");
        arr[1] = new DataStore(500000, "D̅");
        arr[2] = new DataStore(100000, "L̅");
        arr[3] = new DataStore(50000, "L̅");
        arr[4] = new DataStore(10000, "X̅");
        arr[5] = new DataStore(5000, "V̅");
        arr[6] = new DataStore(1000, "M");
        arr[7] = new DataStore(900, "CM");
        arr[8] = new DataStore(500, "D");
        arr[9] = new DataStore(400, "CD");
        arr[10] = new DataStore(100, "C");
        arr[11] = new DataStore(90, "XC");
        arr[12] = new DataStore(50, "L");
        arr[13] = new DataStore(40, "XL");
        arr[14] = new DataStore(10, "X");
        arr[15] = new DataStore(9, "IX");
        arr[16] = new DataStore(5, "V");
        arr[17] = new DataStore(4, "IV");
        arr[18] = new DataStore(1, "I");

        int itr = 0;

        DataStore temp = null;
        while (decimal != 0) {
            temp = arr[itr];
            if (decimal >= temp.value) {
                for (int i = 0; i < decimal / temp.value; i++) {
                    str.append(temp.romanValue);
                }
                decimal = decimal % temp.value;
            }

            itr++;
        }
        return str.toString();

    }

    private class DataStore {
        private int value;
        private String romanValue;

        DataStore(int value, String romanValue) {
            this.value = value;
            this.romanValue = romanValue;
        }
    }
}
