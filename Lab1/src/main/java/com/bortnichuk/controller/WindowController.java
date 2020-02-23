package com.bortnichuk.controller;

import com.bortnichuk.dao.WindowDao;
import com.bortnichuk.entity.Window;
import com.bortnichuk.parser.WindowParser;

import java.util.List;

public class WindowController {

    private WindowParser parser;
    private WindowDao dao;

    public WindowController(){
        parser = new WindowParser();
        dao = new WindowDao();
    }

    public WindowController(WindowDao windowDao){
        parser = new WindowParser();
        dao = windowDao;
    }

    public Window saveWindow(String input){
        Window window = parser.parse(input);
        dao.addWindow(window);
        return window;
    }

    public List<Window> getWindows(){
        return dao.getWindowList();
    }

}
