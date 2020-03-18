package com.bortnichuk.model.entity;

public interface IWindow {

    String getColor();
    void setColor(String color);

    void setTextWindow(TextWindow textWindow);
    TextWindow getTextWindow();


    double getLength();
    double getSquare();

    void changeColor(String color);

    void show();
}
