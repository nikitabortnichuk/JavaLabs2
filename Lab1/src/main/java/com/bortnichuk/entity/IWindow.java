package com.bortnichuk.entity;


public interface IWindow {

    int getLeft();
    int getTop();
    int getRight();
    int getBottom();
    String getColor();

    void setLeft(int left);
    void setTop(int top);
    void setRight(int right);
    void setBottom(int bottom);
    void setColor(String color);

}
