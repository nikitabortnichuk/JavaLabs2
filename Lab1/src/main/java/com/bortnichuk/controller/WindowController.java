package com.bortnichuk.controller;

import com.bortnichuk.model.entity.IWindow;
import com.bortnichuk.model.entity.TextWindow;
import com.bortnichuk.model.exception.IncorrectInputException;
import com.bortnichuk.service.*;
import com.bortnichuk.service.proxy.Proxy;

import java.util.List;

public class WindowController {

    private WindowService proxy;

    public WindowController(){
        proxy = new Proxy();
    }

    public List<IWindow> getWindows() {
        return proxy.getWindows();
    }

    public IWindow getWindow(String windowInput, int number) {
        WindowParser windowParser;
        switch (number){
            case 1:
                windowParser = new RectangleWindowParser();
                break;
            case 2:
                windowParser = new CircleWindowParser();
                break;
            default:
                throw new IncorrectInputException("Wrong input!");
        }
        return windowParser.parseWindow(windowInput);
    }

    public TextWindow getTextWindow(String textWindowInput) {
        return WindowParser.parseTextWindow(textWindowInput);
    }

    public void deleteLast() {
        proxy.deleteLast();
    }

    public IWindow save(IWindow window) {
        return proxy.save(window);
    }
}
