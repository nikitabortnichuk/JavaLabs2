package com.bortnichuk.controller;

import com.bortnichuk.model.entity.IWindow;
import com.bortnichuk.model.entity.TextWindow;
import com.bortnichuk.model.exception.IncorrectInputException;
import com.bortnichuk.service.WindowService;
import com.bortnichuk.service.factoryMethod.WindowParser;
import com.bortnichuk.service.factoryMethod.WindowParserFactory;
import lombok.Setter;

import java.util.List;

public class WindowController {

    @Setter
    private WindowService service;

    public List<IWindow> getWindows() {
        return service.getWindows();
    }

    public void deleteLast() {
        service.deleteLast();
    }

    public IWindow save(IWindow window) {
        return service.save(window);
    }

    public IWindow createWindow(String windowInput, String textWindowInput, int number){
        IWindow window = parseWindow(windowInput, number);
        TextWindow textWindow = parseTextWindow(textWindowInput);
        window.setTextWindow(textWindow);

        return window;
    }

    public IWindow parseWindow(String windowInput, int number) {
        WindowParser windowParser = getWindowParser(number);
        return windowParser.parseWindow(windowInput);
    }

    public static WindowParser getWindowParser(int number){
        WindowParser windowParser;
        switch (number){
            case 1:
                windowParser = WindowParserFactory.getRectangleWindowParser();
                break;
            case 2:
                windowParser = WindowParserFactory.getCircleWindowParser();
                break;
            default:
                throw new IncorrectInputException("Wrong input!");
        }
        return windowParser;
    }

    public TextWindow parseTextWindow(String textWindowInput) {
        return WindowParser.parseTextWindow(textWindowInput);
    }

}
