package com.bortnichuk.dao;

import com.bortnichuk.entity.Window;

import java.util.ArrayList;
import java.util.List;

public class WindowDao {

    private List<Window> windowList = new ArrayList<>();

    public List<Window> getWindowList(){
        return windowList;
    }

    public void addWindow(Window window){
        windowList.add(window);
    }

}
