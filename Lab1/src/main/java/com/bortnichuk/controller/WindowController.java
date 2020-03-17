package com.bortnichuk.controller;

import com.bortnichuk.dao.WindowDao;
import com.bortnichuk.entity.TextWindow;
import com.bortnichuk.entity.Window;
import com.bortnichuk.parser.WindowParser;

import java.util.List;

public class WindowController {

    private WindowParser parser;
    private WindowDao dao;

    public WindowController(){
        parser = WindowParser.getInstance();
        dao = new WindowDao();
    }

    public WindowController(WindowDao windowDao){
        parser = WindowParser.getInstance();
        dao = windowDao;
    }

    public Window getWindow(String input){
        return parser.parseWindow(input);
    }

    public Window save(Window window, TextWindow textWindow) {
        window.setTextWindow(textWindow);
        dao.addWindow(window);
        return window;
    }

    public Window save(Window window){
        dao.addWindow(window);
        return window;
    }

    public void delete(Window window){
        dao.deleteWindow(window);
    }

    public void deleteLast(){
        List<Window> list = dao.getWindowList();
        list.remove(list.size() - 1);
    }

    public TextWindow getTextWindow(String input){
        return parser.parseTextWindow(input);
    }


    public List<Window> getWindows(){
        return dao.getWindowList();
    }

}
