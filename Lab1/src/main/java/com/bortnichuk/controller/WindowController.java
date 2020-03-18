package com.bortnichuk.controller;

import com.bortnichuk.dao.WindowDao;
import com.bortnichuk.model.entity.IWindow;
import com.bortnichuk.model.entity.TextWindow;
import com.bortnichuk.model.entity.RectangleWindow;
import com.bortnichuk.model.exception.IncorrectInputException;
import com.bortnichuk.service.CircleWindowParser;
import com.bortnichuk.service.RectangleWindowParser;
import com.bortnichuk.service.WindowParser;
import com.bortnichuk.service.WindowService;

import java.util.List;

public class WindowController {

    private WindowService windowService;

    public WindowController(){
        windowService = new WindowService();
    }

    public List<IWindow> getWindows() {
        return windowService.getWindows();
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

    public IWindow save(IWindow window, TextWindow textWindow) {
        return windowService.save(window, textWindow);
    }

    public void deleteLast() {
        windowService.deleteLast();
    }

    public IWindow save(IWindow window) {
        return windowService.save(window);
    }
}
