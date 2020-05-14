package com.bortnichuk.service.factoryMethod;

public class WindowParserFactory {

    private WindowParserFactory(){}

    public static WindowParser getCircleWindowParser(){
        return new CircleWindowParser();
    }

    public static WindowParser getRectangleWindowParser(){
        return new RectangleWindowParser();
    }

}
