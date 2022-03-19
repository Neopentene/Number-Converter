package com.NumCo.numberconverter.History;

public interface LocalHistoryCommands {
    void clearHistoryItem(long id, int size, boolean wasLast);

    void makeToast(String msg, int color);

    void dialogDismiss();
}
