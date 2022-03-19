package com.NumCo.numberconverter.CipherCreation;

import com.NumCo.numberconverter.ObjectPainter.Status;

public class Store {
    public static class ImageGenerator {
        public String id;
        public String[] commands;
        public Status status;

        public ImageGenerator(String id, String[] commands, Status status) {
            this.id = id;
            this.commands = commands;
            this.status = status;
        }
    }
}
