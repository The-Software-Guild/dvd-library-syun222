package com.dvdlibrary.ui;

public interface UserIO {
    void print(String msg);

    int readInt(String prompt);

    String readString(String prompt);

    double readDouble(String prompt);
}
