package com.NumCo.numberconverter.Objects;

public class HISTORY {
    public String INPUT_TYPE, INPUT, OUTPUT_TYPE, OUTPUT;
    public long ID;

    public HISTORY(String INPUT_TYPE, String INPUT, String OUTPUT_TYPE, String OUTPUT) {
        this.INPUT_TYPE = INPUT_TYPE;
        this.INPUT = INPUT;
        this.OUTPUT_TYPE = OUTPUT_TYPE;
        this.OUTPUT = OUTPUT;
    }

    public HISTORY(long ID, String INPUT_TYPE, String INPUT, String OUTPUT_TYPE, String OUTPUT) {
        this.ID = ID;
        this.INPUT_TYPE = INPUT_TYPE;
        this.INPUT = INPUT;
        this.OUTPUT_TYPE = OUTPUT_TYPE;
        this.OUTPUT = OUTPUT;
    }

}
