package com.NumCo.numberconverter.Numerals;

public class RomanNumeral {
    private long decimal;

    public RomanNumeral(String decimal) {
        this.decimal = Integer.parseInt(decimal);
    }

    public String toRmn() {
        StringBuilder str = new StringBuilder();
        DataStore[] romanValues = new DataStore[19];

        romanValues[0] = new DataStore(1000000, "M̅");
        romanValues[1] = new DataStore(500000, "D̅");
        romanValues[2] = new DataStore(100000, "L̅");
        romanValues[3] = new DataStore(50000, "L̅");
        romanValues[4] = new DataStore(10000, "X̅");
        romanValues[5] = new DataStore(5000, "V̅");
        romanValues[6] = new DataStore(1000, "M");
        romanValues[7] = new DataStore(900, "CM");
        romanValues[8] = new DataStore(500, "D");
        romanValues[9] = new DataStore(400, "CD");
        romanValues[10] = new DataStore(100, "C");
        romanValues[11] = new DataStore(90, "XC");
        romanValues[12] = new DataStore(50, "L");
        romanValues[13] = new DataStore(40, "XL");
        romanValues[14] = new DataStore(10, "X");
        romanValues[15] = new DataStore(9, "IX");
        romanValues[16] = new DataStore(5, "V");
        romanValues[17] = new DataStore(4, "IV");
        romanValues[18] = new DataStore(1, "I");

        int iteration = 0;

        DataStore temp;
        while (decimal != 0) {
            temp = romanValues[iteration];
            if (decimal >= temp.value) {
                for (int i = 0; i < decimal / temp.value; i++) {
                    str.append(temp.romanValue);
                }
                decimal = decimal % temp.value;
            }

            iteration++;
        }
        return str.toString();

    }

    private static class DataStore {
        private final long value;
        private final String romanValue;

        DataStore(int value, String romanValue) {
            this.value = value;
            this.romanValue = romanValue;
        }
    }
}
