package com.NumCo.numberconverter;

import androidx.annotation.StringRes;

public interface Notify {
    void makeSnackBar(String msg, int color);
    void makeSnackBar(String msg, int color, @StringRes int redId, Runnable runnable);
}
